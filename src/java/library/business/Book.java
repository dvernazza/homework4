/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.business;

import java.io.Serializable;
/**
 *
 * @author dvernazza
 */

public class Book implements Serializable {
    
    private String book_title;
    private String due_date;
    private String overdue;
    
    public Book() {
        book_title = "";
        due_date = "";
        overdue = "";
    }
    
    public Book(String bookTitle, String dueDate, String overdue) {
        this.book_title = bookTitle;
        this.due_date = dueDate;
        this.overdue = overdue;
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
    
    public String getOverdue() {
        return overdue;
    }
    
    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }
}