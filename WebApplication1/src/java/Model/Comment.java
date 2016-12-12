package Model;

import Database.Database;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Encapsulates Comment table
 * @author hirstrb
 */
public class Comment extends Database {

    int commentID;
    int siteID;
    String username;
    String commentMade;
    Date date;
    ArrayList<Comment> comments;

    /**
     * Default Constructor 
     */
    public Comment() {

    }

    /**
     *  
     * @param cID comment id 
     * @param sID web site id 
     * @param un username 
     * @param comMade comment mad
     * @param da Date 
     */
    public Comment(int cID, int sID, String un, String comMade, Date da) {
        this.commentID = cID;
        this.siteID = sID;
        this.username = un;
        this.commentMade = comMade;
        this.date = da;
    }
    /**
     * Get comment id 
     * @return comment id 
     */
    public int getCommentID() {
        return commentID;
    }
    /**
     * set comment id 
     * @param commentID 
     */
    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }
    /**
     * Gets site ID 
     * @return siteID 
     */
    public int getSiteID() {
        return siteID;
    }
    /**
     * Set site ID 
     * @param siteID 
     */
    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }
    /**
     * Get username
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Set username 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Gets comment made 
     * @return commentMade
     */
    public String getCommentMade() {
        return commentMade;
    }
    /**
     * Set comment made 
     * @param commentMade 
     */
    public void setCommentMade(String commentMade) {
        this.commentMade = commentMade;
    }
    /**
     * Get date 
     * @return date 
     */
    public Date getDate() {
        return date;
    }
    /**
     * Set date 
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Gets an ArrayList based on the site id 
     * @param id
     * @return ArrayList 
     */
    public ArrayList<Comment> getCommentsBySite(int id) {
        ArrayList<Comment> coms = new ArrayList<Comment>();
        Connection co = getConnection();
        String sql = "SELECT * FROM CommentsTable WHERE SiteID=" + "\"" + id + "\"";

        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int cID = rs.getInt(1);
                int sID = rs.getInt(2);
                String un = rs.getString(3);
                String comMade = rs.getString(4);
                Date da = rs.getDate(5);

                Comment com = new Comment(cID, sID, un, comMade, da);
                coms.add(com);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Website.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coms;
    }
    /**
     * Gets comments from comments table and encapsulates them 
     * @return ArrayList with comments 
     */
    public ArrayList<Comment> getComments() {
        ArrayList<Comment> all = new ArrayList<Comment>();
        Connection co = getConnection();
        String sql = "SELECT * FROM CommentsTable";

        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int cID = rs.getInt(1);
                int sID = rs.getInt(2);
                String un = rs.getString(3);
                String comMade = rs.getString(4);
                Date da = rs.getDate(5);

                Comment com = new Comment(cID, sID, un, comMade, da);
                all.add(com);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Website.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    /**
     * Insert Comment 
     * @throws SQLException 
     */
    public void insertComment() throws SQLException {
        int count = 0;
        Connection co = getConnection();
        String countQ = "SELECT COUNT(*) FROM CommentsTable";
        Statement q = co.createStatement();
        ResultSet res = q.executeQuery(countQ);
        res.next();

        int rows = res.getInt("COUNT(*)") + 1;

        String sql = "INSERT INTO CommentsTable VALUES(?, ?, ?, ?)";
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setInt(1, rows);
        ps.setInt(2, siteID);
        ps.setString(3, username);
        ps.setString(4, commentMade);
        ps.executeUpdate();
    }
}
