/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author perezcx
 */
public class Register extends Database{
    
    static int ID = 89;
    static int LINK = 2;
    static String ADMIN = "Admin"; 

    private String username; 
    private String password; 
    private String password2; 
    private String firstname; 
    private String lastname;
    private int age; 
    private String email; 
    private String gender; 
    
    public Register(String username, String password, String password2, String firstname, String lastname, String email, String age, String gender) {
        this.username = username; 
        this.password = password; 
        this.password2 = password2; 
        this.firstname = firstname; 
        this.lastname = lastname; 
        this.age = parseInt(age); 
        this.email = email; 
        this.gender = gender; 
    }
    
    public void insertRegister() throws SQLException{
        Connection co = getConnection(); 
        String sql = "INSERT INTO UserTable VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sts = co.prepareStatement(sql);
         sts.setInt(1, ID);
         sts.setInt(2,LINK);
         sts.setString(3, username);
         sts.setString(4, password);
         sts.setString(5, email);
         sts.setString(6, firstname);
         sts.setString(7, lastname);
         sts.setInt(8, age);
         sts.setString(9, gender);
         sts.setString(10,ADMIN);
         
         sts.executeUpdate(); 
    }
    
     private int parseInt(String name) {
        try {
            return Integer.parseInt(name);
        } catch (NumberFormatException exc) {
            //Quick-fix to make the query have a default year.
            System.out.println("unable to parse"); 
        }
        return 0; 
    }
    
}
