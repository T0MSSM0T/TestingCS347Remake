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
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String gender;
    private ArrayList<Integer> favsC;

    public User() {

    }
    /**
     * 
     * @param username
     * @param firstname
     * @param lastname
     * @param email
     * @param age
     * @param gender
     * @param favs 
     */
    public User(String username, String firstname, String lastname, String email, String age, String gender, ArrayList<Integer> favs) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = Integer.parseInt(age);
        this.email = email;
        this.gender = gender;
        this.favsC = favs;
    }

    /**
     * 
     * @param username
     * @param password
     * @param firstname
     * @param lastname
     * @param email
     * @param age
     * @param gender
     * @param favs 
     */
   
    public User(String username, String password, String firstname, String lastname, String email, String age, String gender, ArrayList<Integer> favs) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = Integer.parseInt(age);
        this.email = email;
        this.gender = gender;
        this.favsC = favs;
    }
    /**
     * @return ROLE
     */
    public static String getRole() {
        return ROLE;
    }
    /**
     * @param Role 
     */
    public static void setRole(String Role) {
        User.ROLE = ROLE;
    }
    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

  
    /**
     * @return first name
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * @param firstname 
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * @return last name
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * @param lastname 
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * @return age 
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * @param gender 
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Edits user information 
     * @throws SQLException 
     */
    public void resetPassword(String newPass) throws SQLException {
        Connection con = getConnection();
        String currentUser = "UPDATE UserTable SET Password = ? WHERE Email = \'" + email + "'";
        PreparedStatement sts1 = con.prepareStatement(currentUser);
        sts1.setString(1, newPass);
        sts1.executeUpdate();
    }
    /**
     * Edit user based on username
     * @throws SQLException 
     */
    public void editRegister() throws SQLException {
        Connection con = getConnection();
        String selectrow = "UPDATE UserTable SET Email = ? , FirstName = ? , LastName = ? ,Age = ? , Gender = ? , Password = ? WHERE Username = '" + username + "'";
        String query = "SELECT * FROM UserTable WHERE Username = '" + username + "'";
        Statement sts1 = con.createStatement();
        ResultSet result;
        result = sts1.executeQuery(query);
        result.next();
        int favId = result.getInt("FavoriteCategoryIDLink");
        PreparedStatement sts2 = con.prepareStatement(selectrow);
        sts2.setString(1, email);
        sts2.setString(2, firstname);
        sts2.setString(3, lastname);
        sts2.setInt(4, age);
        sts2.setString(5, gender);
        sts2.setString(6, password);
        sts2.executeUpdate();  //(selectrow);

        CategoryList obj = new CategoryList();
        ArrayList<String> catList = obj.getCategories();
        String sql = "UPDATE UsersFavoriteTable SET";

        for (int i = 0; i < catList.size(); i++) {
            sql += " " + catList.get(i) + " = " + favsC.get(i) + ",";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += " WHERE UsernameCategoryID = " + favId;

        Statement sts3 = con.createStatement();
        System.out.print(sql);
        sts3.executeUpdate(sql);
    }
    /**
     * Registers a new user and adds his favorite categories to the 
     * corresponding tables
     * @return true if user was successful registered
     * @throws SQLException 
     */
    public boolean insertRegister() throws SQLException {
        int count = 0;

        Connection co = getConnection();
        String countQ = "SELECT COUNT(*) FROM UserTable";
        Statement q = co.createStatement();
        ResultSet res = q.executeQuery(countQ);
        res.next();
        int rows = res.getInt("COUNT(*)") + 1;
        String check = "SELECT * FROM UserTable WHERE Username = ?";
        PreparedStatement sts = co.prepareStatement(check);
        sts.setString(1, username);
        ResultSet result;
        result = sts.executeQuery();

        while (result.next()) {
            count++;
        }

        if (count == 1) {
            return false;
        }

        String sql1 = "INSERT INTO UserTable VALUES(?,?,?,?,?,?,?,?,?,?)";

        String sql2 = "INSERT INTO UsersFavoriteTable VALUES(" + rows;
        for (int i = 0; i < favsC.size(); i++) {
            sql2 += "," + favsC.get(i);
        }
        sql2 += ")";
        Statement sts2 = co.createStatement();
        sts2.executeUpdate(sql2);

        PreparedStatement sts1 = co.prepareStatement(sql1);

        sts1.setInt(1, rows);//Quesry database to get last id + 1
        sts1.setInt(2, rows);
        sts1.setString(3, username);
        sts1.setString(4, password);
        sts1.setString(5, email);
        sts1.setString(6, firstname);
        sts1.setString(7, lastname);
        sts1.setInt(8, age);
        sts1.setString(9, gender);
        sts1.setString(10, ROLE);
        sts1.executeUpdate();
        return true;
    }
}
