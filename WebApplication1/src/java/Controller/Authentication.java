package Controller;


import Database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author perezcx
 */
public class Authentication extends Database {

    private String username; 
    private String password; 
    
    public Authentication(String username,String password){
        this.username = username; 
        this.password = password; 
    }
    public boolean authenticate() throws SQLException{
        Connection conection = getConnection(); 
        String query = "SELECT * FROM UserTable"; 
        Statement st = conection.createStatement(); 
        ResultSet result = st.executeQuery(query); 
        
        while(result.next()){
            if(username.equals(result.getString("Username"))&& password.equals(result.getString("Password")))
                return true; 
        }
        
        return false;
    }
    
  
}
