/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author dvernazza and tyoung
 */

public class User implements Serializable {
    
    private String first_name;
    private String last_name;
    private String email_address;
    private String book_title;
    private String due_date;
    private String overdue;
    private String date_due;
    
    public User() {
        first_name = "";
        last_name = "";
        email_address = "";
        book_title = "";
        due_date = "";
        overdue = "";
        date_due = "";
    }
    
    public User(String firstName, String lastName, String emailAddress,String bookTitle, String dueDate, String overdue, String date_due) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.email_address = emailAddress;
        this.book_title = bookTitle;
        this.due_date = dueDate;
        this.overdue = overdue;
        this.date_due = date_due;
    }
    
    public String getFirstName() {
        return first_name;
    }
    
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }
    
    public String getLastName() {
        return last_name;
    }
    
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
    
    public String getEmailAddress() {
        return email_address;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.email_address = emailAddress;
    }
    
    public String getBookTitle() {
        return book_title;
    }
    
    public void setBookTitle(String bookTitle) {
        this.book_title = bookTitle;
    }
    
    public String getDueDate() {
        return due_date;
    }
    
    public void setDueDate(String dueDate) {
        this.due_date = dueDate;
    }
    
    public void setDueDate(LocalDate currentDate) {
        LocalDate dateDue = currentDate.plus(2, ChronoUnit.WEEKS);
        String dueDate = dateDue.toString();
        this.due_date = dueDate;
    }
    
    public String getOverdue() {
        return overdue;
    }
    
    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }
    
    public String getDateDue() {
        return date_due;
    }
    
    public void setDateDue(String dateDue) {
        int first = dateDue.indexOf("-");
        int second = dateDue.indexOf("-", first+1);
        String newDate = dateDue.substring(first+1, second+1) + dateDue.substring(second+1) + "-" + dateDue.substring(0, first);
        this.date_due = newDate;
    }
}