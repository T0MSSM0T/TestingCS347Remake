/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author schieftg
 */
public class CategoryList extends Database{
    public ArrayList<String> getCategories() throws SQLException {
        ArrayList<String> categories = new ArrayList<String>();
        Connection conection = getConnection(); 
        String query = "SELECT CategoryName FROM CategoryTable";
        Statement st = conection.createStatement();
        ResultSet result = st.executeQuery(query); 
        while(result.next()){
            categories.add(result.getString("CategoryName"));
        }
        return  categories;
    }
}