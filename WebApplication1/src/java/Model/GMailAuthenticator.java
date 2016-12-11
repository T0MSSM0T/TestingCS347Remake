/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author hirstrb
 */
public class GMailAuthenticator extends Authenticator {

    String user;
    String pw;
    /**
     * Set username and password 
     * @param username
     * @param password 
     */
    public GMailAuthenticator(String username, String password) {
        super();
        this.user = username;
        this.pw = password;
    }
    /**
     * 
     * @return PasswordAuthentication 
     */
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pw);
    }
}
