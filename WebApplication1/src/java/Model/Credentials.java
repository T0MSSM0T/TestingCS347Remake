/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author perezcx
 */
public class Credentials {

    private String username;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String gender;
    private ArrayList<Boolean> categories = new ArrayList<Boolean>();

    /**
     * Encapsulates user credentials 
     * @param username
     * @param firstname
     * @param lastname
     * @param age
     * @param email
     * @param gender
     * @param categories 
     */
    public Credentials(String username, String firstname, String lastname, int age, String email, String gender, ArrayList<Boolean> categories) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.categories = categories;
    }
    /**
     * Default Constructor
     */
    public Credentials() {

    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the categories
     */
    public ArrayList<Boolean> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(ArrayList<Boolean> categories) {
        this.categories = categories;
    }
    /**
     * Adds Category
     * @param category 
     */
    public void addCategories(Boolean category) {
        this.categories.add(category);
    }
}
