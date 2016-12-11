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
import java.util.ArrayList;
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
    int categoryid;
    ResultSet result;

    /**
     * Default Constructor 
     * @param username username to be authenticated 
     * @param password password to be authenticated 
     */
    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /**
     * Authenticate user based on username and password
     * @return true if username matches password
     * @throws SQLException unable to perform query
     */
    public boolean authenticate() throws SQLException {
        String hash = encodePassword(password);

        Connection conection = getConnection();
        String query = "SELECT * FROM UserTable WHERE Username = '" + username + "' AND Password = '" + hash + "'";
        Statement st = conection.createStatement();
        result = st.executeQuery(query);

        if (result.first()) {
            categoryid = result.getInt("FavoriteCategoryIDLink");
            return true;
        }

        return false;
    }
    /**
     * Get credentials based on the category id 
     * @return Credentials object
     * @throws SQLException unable to perform query
     */
    public Credentials getCredentials() throws SQLException {
        Credentials credential = new Credentials();

        credential.setUsername(result.getString("Username"));
        credential.setFirstname(result.getString("FirstName"));
        credential.setLastname(result.getString("LastName"));
        credential.setAge(result.getInt("Age"));
        credential.setEmail(result.getString("Email"));
        credential.setGender(result.getString("Gender"));

        CategoryList obj = new CategoryList();
        ArrayList<String> catList = obj.getCategories();
        Connection conection = getConnection();
        String query = "SELECT * FROM UsersFavoriteTable WHERE UsernameCategoryID =" + categoryid;
        Statement st;

        st = conection.createStatement();
        result = st.executeQuery(query);

        result.next();

        for (int i = 0; i < catList.size(); i++) {
            if (result.getInt(catList.get(i)) == 1) {
                credential.addCategories(true);
            } else {
                credential.addCategories(false);
            }
        }

        return credential;
    }
    /**
     * Hash password 
     * @param password un-hashed password 
     * @return hashed password
     */
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
