/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author perezcx
 */
public class User extends Database {

    static int ID = 2;
    static int LINK = 1;
    static String ROLE = "User";

    private String username;
    private String password;
    private String password2;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String gender;
    private ArrayList<Integer> favsC;

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

    public void insertRegister() throws SQLException {
        Connection co = getConnection();
        String sql1 = "INSERT INTO UserTable VALUES(?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "INSERT INTO UsersFavoriteTable VALUES(" + LINK + ",";
        for (int i = 0; i < favsC.size(); i++)
        {
            sql2 += favsC.get(i) + ",";
        }
        sql2 = sql2.substring(0, sql2.length()-1);
        sql2 += ")";
        //sql2 += favsC.get(favsC.size()-1) + ")";
        Statement sts2 = co.createStatement();
        sts2.executeUpdate(sql2);
        PreparedStatement sts1 = co.prepareStatement(sql1);
        sts1.setInt(1, ID);//Quesry database to get last id + 1
        sts1.setInt(2, LINK);
        sts1.setString(3, username);
        sts1.setString(4, password);
        sts1.setString(5, email);
        sts1.setString(6, firstname);
        sts1.setString(7, lastname);
        sts1.setInt(8, age);
        sts1.setString(9, gender);
        sts1.setString(10, ROLE);
        ID++;
        LINK++;
        sts1.executeUpdate();
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
