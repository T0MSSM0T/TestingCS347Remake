package Controller;


import database.Database;
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
    int pk; 
    ResultSet result; 
    
    public Authentication(String username,String password){
        this.username = username; 
        this.password = password; 
    }
    public boolean authenticate() throws SQLException{
        Connection conection = getConnection(); 
        String query = "SELECT * FROM UserTable "; 
        Statement st = conection.createStatement(); 
        result = st.executeQuery(query); 
        
        while(result.next()){
            if(username.equals(result.getString("Username"))&& password.equals(result.getString("Password"))){
                pk = result.getInt("UserID"); 
               return true; 
            }
                
        }
        
        return false;
        
    }
    public Credentials getCredentials() throws SQLException{
        /**
        Connection conection = getConnection(); 
        Statement st = conection.createStatement(); 
        ResultSet result; 
        String query = "SELECT * FROM UserTable WHERE UserID = "+pk; 
        result = st.executeQuery(query); 
        **/
        Credentials  credential = new Credentials(); 
        
        credential.setUsername(result.getString("Username")); 
        credential.setFirstname(result.getString("FirstName"));
        credential.setLastname(result.getString("LastName"));
        credential.setAge(result.getInt("Age"));
        credential.setEmail(result.getString("Email"));
        credential.setGender(result.getString("Gender"));

        
        return credential; 
       
    }
    
   
    
  
}
