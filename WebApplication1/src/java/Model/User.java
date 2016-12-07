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
import java.util.ArrayList;

/**
 *
 * @author perezcx
 */
public class User extends Database {

    static String ROLE = "User";
    static int ID = 10;
    private String username;
    private String password;
    private String password2;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String gender;
    private ArrayList<Integer> favsC;

    public User() {

    }

    public User(String username, String password, String password2, String firstname, String lastname, String email, String age, String gender, ArrayList<Integer> favs) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = parseInt(age);
        this.email = email;
        this.gender = gender;
        this.favsC = favs;
    }

    public static String getRole() {
        return ROLE;
    }

    public static void setRole(String Role) {
        User.ROLE = ROLE;
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
        
        String countQ = "SELECT COUNT(*) FROM UserTable";
        Statement q = co.createStatement();
        ResultSet res = q.executeQuery(countQ);
        res.next();
        int rows = res.getInt("COUNT(*)") + 1;
        
        String sql1 = "INSERT INTO UserTable VALUES(?,?,?,?,?,?,?,?,?,?)";
        /**
        String sql2 = "INSERT INTO UsersFavoriteTable VALUES(" + rows + ",";
        for (int i = 0; i < favsC.size(); i++)
        {
            sql2 += favsC.get(i) + ",";
        }
        sql2 = sql2.substring(0, sql2.length()-1);
        sql2 += ")";
        //sql2 += favsC.get(favsC.size()-1) + ")";
        Statement sts2 = co.createStatement();
        sts2.executeUpdate(sql2);
        **/
        PreparedStatement sts1 = co.prepareStatement(sql1);
        
        sts1.setInt(1, ID);//Quesry database to get last id + 1
        sts1.setInt(2, 7);
        sts1.setString(3, username);
        sts1.setString(4, password);
        sts1.setString(5, email);
        sts1.setString(6, firstname);
        sts1.setString(7, lastname);
        sts1.setInt(8, age);
        sts1.setString(9, gender);
        sts1.setString(10, ROLE);
        sts1.executeUpdate();
        ID++;
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
