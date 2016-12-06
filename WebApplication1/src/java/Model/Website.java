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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hirstrb
 */
public class Website extends Database {

    int siteID;
    int categoryIDLink;
    String siteTitle;
    String hyperLink;
    int adCount;
    String notes;
    int rating;

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public int getCategoryIDLink() {
        return categoryIDLink;
    }

    public void setCategoryIDLink(int categoryIDLink) {
        this.categoryIDLink = categoryIDLink;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }

    public int getAdCount() {
        return adCount;
    }

    public void setAdCount(int adCount) {
        this.adCount = adCount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public ArrayList<String> getWebsites() {
        ArrayList<String> websites = new ArrayList<String>();
        
        Connection co = getConnection();
        String sql = "SELECT Hyperlink FROM SitesTable"; 
        try { 
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                websites.add(rs.getString("Hyperlink"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Website.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return websites; 
    }
}
