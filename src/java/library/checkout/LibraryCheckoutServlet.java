/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.checkout;

import org.joda.time.LocalDate;
import java.io.IOException;
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
 * @author dvernazza and tyoung
 */
@WebServlet(name = "LibraryCheckoutServlet", urlPatterns = {"/library"})
public class LibraryCheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String url = "/manager.jsp";
        String action = request.getParameter("action");
        String message;
        
        if (action == null) {
            action = "display_users";
        } 
        if (action.equals("checkoutBook")) {
            action = "display_users";
        }
        else if (action.equals("check")) {
            url = "/checkout.jsp";
            message = "";
        }
        else if (action.equals("return")) {
            url = "/index.jsp";
        }
        if (action.equals("display_users")) {            
            ArrayList<User> users = UserDB.selectUsers();            
            session.setAttribute("users", users);
            String emailAddress = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");
            User user = UserDB.selectUser(emailAddress, bookTitle);
            session.setAttribute("user", user);
            url = "/manager.jsp";
        }
        else if (action.equals("delete_user")) {
            String emailAddress = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");
            User user = UserDB.selectUser(emailAddress, bookTitle);

            UserDB.delete(user);

            ArrayList<User> users = UserDB.selectUsers();            
            request.setAttribute("users", users);            
        }
        
        if (action.equals("join")) {
            url = "/checkout.jsp";
        }  
        if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");
            String bookTitle = request.getParameter("bookTitle");
            LocalDate dueDate = LocalDate.now();
            String overdue = "";
            User user = new User();
            user.setBookTitle(bookTitle);
            user.setFirstName(firstName);
            user.setDueDate(dueDate);
            user.setLastName(lastName);
            user.setOverdue(overdue);
            user.setEmailAddress(emailAddress);
            user.setDateDue(user.getDueDate());
            if (UserDB.emailExists((user.getEmailAddress()), (user.getBookTitle()))) {
                message = "You currently have checked out this book.<br>" + 
                          "Please return it before you can check it out again.";
                url = "/checkout.jsp";
            }
            else {
                message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
            }
            session.setAttribute("message", message);
            session.setAttribute("user", user);
            
        }
        
        getServletContext()
           .getRequestDispatcher(url)
           .forward(request, response);
        
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    
    
}
