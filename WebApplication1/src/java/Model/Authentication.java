package Model;

import Model.Credentials;
import Database.Database;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() throws SQLException {
        Connection conection = getConnection();
        String query = "SELECT * FROM UserTable ";
        Statement st = conection.createStatement();
        result = st.executeQuery(query);
        String hash = encodePassword(password); 
        
        while (result.next()) {
            if (username.equals(result.getString("Username")) && hash.equals(result.getString("Password"))) {
                pk = result.getInt("UserID");
                return true;
            }
        }

        return false;

    }

    public Credentials getCredentials() throws SQLException {
        /**
         * Connection conection = getConnection(); Statement st =
         * conection.createStatement(); ResultSet result; String query = "SELECT
         * * FROM UserTable WHERE UserID = "+pk; result =
         * st.executeQuery(query);
         *
         */
        Credentials credential = new Credentials();

        credential.setUsername(result.getString("Username"));
        credential.setFirstname(result.getString("FirstName"));
        credential.setLastname(result.getString("LastName"));
        credential.setAge(result.getInt("Age"));
        credential.setEmail(result.getString("Email"));
        credential.setGender(result.getString("Gender"));
        
         getCategories(credential); 

        return credential;
    }
    public void getCategories(Credentials credential) throws SQLException {
          
        Connection conection = getConnection();
        String query = "SELECT * FROM UsersFavoriteTable WHERE UsernameCategoryID = 2";
        Statement st;
     
            st = conection.createStatement();
            result = st.executeQuery(query);
           
      
        
        while (result.next()) {

            try {
                
                credential.categories[0] = result.getInt("Movies");
                //credential.categories[1] = result.getInt("News"); 
            } catch (SQLException ex) {
                System.out.println("error en getInt"); 
            }
        }
    }

    private static String encodePassword(String password) {
        try {
            byte[] bytes = password.getBytes("UTF-8");
            bytes = MessageDigest.getInstance("MD5").digest(bytes);
            Formatter f = new Formatter();
            for (byte b : bytes) {
                f.format("%02x", b);
            }
            return f.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
