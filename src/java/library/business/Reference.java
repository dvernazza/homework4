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

public class Reference implements Serializable {
    
    private String email_address;
    private String book_title;

    
    public Reference() {
        email_address = "";
        book_title = "";
    }
    
    public Reference(String emailAddress, String bookTitle) {
        this.email_address = emailAddress;
        this.book_title = bookTitle;
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

}