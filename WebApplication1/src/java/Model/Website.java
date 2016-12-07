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

    public Website() {

    }

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

    public String getIFrame() {
        return IFrame;
    }

    public void setIFrame(String IFrame) {
        this.IFrame = IFrame;
    }

    public ArrayList<String> getHyperlinks() {
        ArrayList<String> hyperlinks = new ArrayList<String>();
        Connection co = getConnection();
        String sql = "SELECT Hyperlink FROM SitesTable";
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                hyperlinks.add(rs.getString("Hyperlink"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Website.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hyperlinks;
    }

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
