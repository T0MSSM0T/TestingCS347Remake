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
    String IFrame;
    
    /**
     * Default Constructor
     */
    public Website() {
        
    }
    /**
     * 
     * @param siteID
     * @param categoryIDLink
     * @param siteTitle
     * @param hyperLink
     * @param adCount
     * @param notes
     * @param rating
     * @param IFrame 
     */
    public Website(int siteID, int categoryIDLink, String siteTitle,
            String hyperLink, int adCount, String notes, int rating, String IFrame) {
        this.siteID = siteID;
        this.categoryIDLink = categoryIDLink;
        this.siteTitle = siteTitle;
        this.hyperLink = hyperLink;
        this.adCount = adCount;
        this.notes = notes;
        this.rating = rating;
        this.IFrame = IFrame;
    }
    /**
     * @return siteID
     */
    public int getSiteID() {
        return siteID;
    }
    /**
     * @param siteID 
     */
    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }
    /**
     * @return category ID Link 
     */
    public int getCategoryIDLink() {
        return categoryIDLink;
    }
    /**
     * @param categoryIDLink 
     */
    public void setCategoryIDLink(int categoryIDLink) {
        this.categoryIDLink = categoryIDLink;
    }
    /**
     * @return site title 
     */
    public String getSiteTitle() {
        return siteTitle;
    }
    /*
     * @param siteTitle 
     */
    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }
    /**
     * @return hyper link 
     */
    public String getHyperLink() {
        return hyperLink;
    }
    /**
     * @param hyperLink 
     */
    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }
    /**
     * @return ad Count 
     */
    public int getAdCount() {
        return adCount;
    }
    /**
     * @param adCount 
     */
    public void setAdCount(int adCount) {
        this.adCount = adCount;
    }
    /**
     * @return notes 
     */
    public String getNotes() {
        return notes;
    }
    /**
     * @param notes 
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    /**
     * @return rating 
     */
    public int getRating() {
        return rating;
    }
    /**
     * @param rating 
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * @return IFrame
     */
    public String getIFrame() {
        return IFrame;
    }
    /**
     * @param IFrame 
     */
    public void setIFrame(String IFrame) {
        this.IFrame = IFrame;
    }
    /**
     * Get Category based on category id 
     * @param category
     * @return ArrayList with categories 
     */
    public ArrayList<Website> getCategoryWebsites(int category) {
        ArrayList<Website> categoryWebsites = new ArrayList<Website>();
        Connection co = getConnection();
        String sql = "SELECT * FROM SitesTable WHERE CategoryIDLink = " + category;

        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int sID = rs.getInt(1);
                int cLink = rs.getInt(2);
                String sTitle = rs.getString(3);
                String hLink = rs.getString(4);
                int aCount = rs.getInt(5);
                String note = rs.getString(6);
                int rate = rs.getInt(7);
                String frame = rs.getString(8);

                Website site = new Website(sID, cLink, sTitle, hLink, aCount, note, rate, frame);
                categoryWebsites.add(site);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Website.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categoryWebsites;
    }
    /**
     * Gets web site based on title 
     * @param siteTitle
     * @return Website 
     */
    public Website getWebsite(String siteTitle) {
        Website site = null;
        Connection co = getConnection();
        String sql = "SELECT * FROM SitesTable WHERE SiteTitle=" + "\"" + siteTitle + "\"";

        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int sID = rs.getInt(1);
                int cLink = rs.getInt(2);
                String sTitle = rs.getString(3);
                String hLink = rs.getString(4);
                int aCount = rs.getInt(5);
                String note = rs.getString(6);
                int rate = rs.getInt(7);
                String frame = rs.getString(8);

                site = new Website(sID, cLink, sTitle, hLink, aCount, note, rate, frame);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Website.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return site;
    }
    /**
     * Get all the web sites 
     * @return ArrayList with web sites
     */
    public ArrayList<Website> getWebsites() {
        ArrayList<Website> websites = new ArrayList<Website>();
        Connection co = getConnection();
        String sql = "SELECT * FROM SitesTable";

        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int sID = rs.getInt(1);
                int cLink = rs.getInt(2);
                String sTitle = rs.getString(3);
                String hLink = rs.getString(4);
                int aCount = rs.getInt(5);
                String note = rs.getString(6);
                int rate = rs.getInt(7);
                String frame = rs.getString(8);

                Website site = new Website(sID, cLink, sTitle, hLink, aCount, note, rate, frame);
                websites.add(site);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Website.class.getName()).log(Level.SEVERE, null, ex);
        }

        return websites;
    }
}
