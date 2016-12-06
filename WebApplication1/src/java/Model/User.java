/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author perezcx
 */
public class User extends Database {

    static int ID = 1;
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

    public User() {

    }

    public User(String username, String password, String password2, String firstname, String lastname, String email, String age, String gender) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = parseInt(age);
        this.email = email;
        this.gender = gender;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        User.ID = ID;
    }

    public static int getLINK() {
        return LINK;
    }

    public static void setLINK(int LINK) {
        User.LINK = LINK;
    }

    public static String getADMIN() {
        return ADMIN;
    }

    public static void setADMIN(String ADMIN) {
        User.ADMIN = ADMIN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void insertRegister() throws SQLException {
        Connection co = getConnection();
        String sql = "INSERT INTO UserTable VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sts = co.prepareStatement(sql);
        sts.setInt(1, ID);//Quesry database to get last id + 1
        sts.setInt(2, LINK);
        sts.setString(3, username);
        sts.setString(4, password);
        sts.setString(5, email);
        sts.setString(6, firstname);
        sts.setString(7, lastname);
        sts.setInt(8, age);
        sts.setString(9, gender);
        sts.setString(10, ADMIN);
        ID++;
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
