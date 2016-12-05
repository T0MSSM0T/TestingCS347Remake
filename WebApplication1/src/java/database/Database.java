/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    public static final String USERNAME = "team15";
    public static final String PASSWORD = "go!f9";
    public static final String HOST = "grove.cs.jmu.edu";
    public static final String PORT = "3306";
    public static final String DATABASE = "team15_db";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://grove.cs.jmu.edu:3306/team15_db"; //+ HOST + ":" + PORT + "/" + DATABASE;

    public Connection con;

    public Connection getConnection() {

        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public void RgisterUserFunction() throws SQLException {
        Connection co = getConnection();
        String sql = "INSERT INTO CategoryTable VALUES(?,?,?)";
        PreparedStatement sts = co.prepareStatement(sql);
        int id = 2;
        String cat = "sports";
        String note = "testing";

        sts.setInt(1, id);
        sts.setString(2, cat);
        sts.setString(3, note);

        sts.executeUpdate();
    }

}
