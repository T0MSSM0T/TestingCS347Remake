package Model;

import Database.Database;
import java.sql.Connection;
import java.sql.Date;
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
public class Comment extends Database {

    int commentID;
    int siteID;
    String username;
    String commentMade;
    Date date;
    ArrayList<Comment> comments;

    public Comment() {
        
    }

    private Comment(int cID, int sID, String un, String comMade, Date da) {
        this.commentID = cID;
        this.siteID = sID;
        this.username = un;
        this.commentMade = comMade;
        this.date = da;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
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

    public String getCommentMade() {
        return commentMade;
    }

    public void setCommentMade(String commentMade) {
        this.commentMade = commentMade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
}
