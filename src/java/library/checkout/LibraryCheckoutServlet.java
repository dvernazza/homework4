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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import library.business.Book;
import library.business.User;
import library.business.Reference;
import library.data.UserDB;
import library.data.BookDB;
import library.data.ReferenceDB;


/**
 *
 * @author dvernazza
 */
@WebServlet(name = "LibraryCheckoutServlet", urlPatterns = {"/libraryCheckout"})
public class LibraryCheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        } 
        String url = "/checkout.jsp";
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
            User user = new User(firstName, lastName, emailAddress);
            UserDB.insert(user);
            Book book = new Book(bookTitle, dueDate, overdue);
            BookDB.insert(book);
            Reference reference = new Reference(emailAddress);
            ReferenceDB.insert(reference);
            dueDate = dateFormat(dueDate);
            Book book2 = new Book(bookTitle, dueDate, overdue);
            session.setAttribute("user", user);
            session.setAttribute("book", book2);
            session.setAttribute("reference", reference);
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
