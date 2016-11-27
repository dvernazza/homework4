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

public class User implements Serializable {
    
    private String first_name;
    private String last_name;
    private String email_address;
    
    public User() {
        first_name = "";
        last_name = "";
        email_address = "";
    }
    
    public User(String firstName, String lastName, String emailAddress) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.email_address = emailAddress;
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
}