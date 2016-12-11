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
 * @author hirstrb
 */
public class Rating extends Database {

    int ratingID;
    int siteID;
    String username;
    int rating;

    public Rating() {

    }

    public Rating(int ratingID, int siteID, String username, int rating) {
        this.ratingID = ratingID;
        this.siteID = siteID;
        this.username = username;
        this.rating = rating;
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<Rating> getRatings() throws SQLException {
        Connection co = getConnection();
        String sql = "SELECT * FROM RatingsTable";
        ArrayList<Rating> ratings = new ArrayList<Rating>();

        Statement st = co.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int rID = rs.getInt(1);
            int sID = rs.getInt(2);
            String un = rs.getString(3);
            int rat = rs.getInt(4);
            Rating ratObj = new Rating(rID, sID, un, rat);

            ratings.add(ratObj);
        }
        return ratings;
    }

    public ArrayList<Rating> getRatingsBySite(int id) throws SQLException {
        Connection co = getConnection();
        String sql = "SELECT * FROM RatingsTable WHERE SiteID=" +id;  
        ArrayList<Rating> siteRatings = new ArrayList<Rating>();

        Statement st = co.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int rID = rs.getInt(1);
            int sID = rs.getInt(2);
            String un = rs.getString(3);
            int rat = rs.getInt(4);
            
            Rating ratObj = new Rating(rID, sID, un, rat);
            siteRatings.add(ratObj);
        }
        return siteRatings;
    }
}