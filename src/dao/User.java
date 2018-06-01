/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author CeachiBogdan
 */
public class User {
    
    private static String userEmail;
    
    public User() {
        
    }
    public User(String userEmail) {
        this.userEmail = userEmail;
    }

    public static String getUserEmail() {
        return userEmail;
    }
}
