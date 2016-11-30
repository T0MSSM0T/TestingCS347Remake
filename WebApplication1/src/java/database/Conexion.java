/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {

    public static final String USERNAME = "team15";
    public static final String PASSWORD = "go!f9";
    public static final String HOST = "grove.cs.jmu.edu";
    public static final String PORT = "3306";
    public static final String DATABASE = "team15_db";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://grove.cs.jmu.edu:3306/team15_db"; //+ HOST + ":" + PORT + "/" + DATABASE;

    public java.sql.Connection con;

    public Conexion() {

        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } 
        catch (ClassNotFoundException e) {
           System.out.println(e);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }

    }

   
}
