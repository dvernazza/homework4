/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.checkout;

import java.time.temporal.ChronoUnit;
import java.lang.Object;
import java.util.Date;
import java.time.LocalDate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import library.business.User;
import library.data.UserDB;


/**
 *
 * @author dvernazza
 */
@WebServlet(name = "LibraryCheckoutServlet", urlPatterns = {"/libraryCheckout"})
public class LibraryCheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String url = "/manager.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users";
        } 
        if (action.equals("display_users")) {            
            // get list of users
            ArrayList<User> users = UserDB.selectUsers();            
            session.setAttribute("users", users);
            String emailAddress = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");
            User user = UserDB.selectUser(emailAddress, bookTitle);
            session.setAttribute("user", user);
            url = "/manager.jsp";
        }
        else if (action.equals("delete_user")) {
            // get the user
            String emailAddress = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");
            User user = UserDB.selectUser(emailAddress, bookTitle);
            
            // delte the user
            UserDB.delete(user);
            
            // get and set updated users
            ArrayList<User> users = UserDB.selectUsers();            
            request.setAttribute("users", users);            
        }
        
        if (action.equals("join")) {
            url = "/checkout.jsp";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");
            String bookTitle = request.getParameter("bookTitle");
            LocalDate currentDate = LocalDate.now();
            String dueDate = dateDue(currentDate);
            String overdue = "";
            User user = new User(firstName, lastName, emailAddress, bookTitle, dueDate, overdue);
            String message;
            if (UserDB.emailExists(user.getEmailAddress(),user.getBookTitle())) {
                message = "You currently have checked out this book.<br>" +
                          "Please return it before you can check it out again.";
                url = "/checkout.jsp";
            }
            else {
                message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
            }
            dueDate = dateFormat(dueDate);
            User user2 = new User(firstName, lastName, emailAddress, bookTitle, dueDate, overdue);
            session.setAttribute("message", message);
            session.setAttribute("user", user);
            session.setAttribute("user2", user2);
            url = "/thanks.jsp";
            
        }
        
        getServletContext()
           .getRequestDispatcher(url)
           .forward(request, response);
        
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
 
    private String dateDue(LocalDate currentDate) {
        LocalDate dateDue = currentDate.plus(2, ChronoUnit.WEEKS);
        String dueDate = dateDue.toString();
        return dueDate;
    }
    
    private String dateFormat(String date) {
        int first = date.indexOf("-");
        int second = date.indexOf("-", first+1);
        String newDate = date.substring(first+1, second+1) + date.substring(second+1) + "-" + date.substring(0, first);
        return newDate;
    }
    
    
}
