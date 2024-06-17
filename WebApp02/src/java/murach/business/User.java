/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.business;

import java.io.Serializable;

/**
 *
 * @author manhc
 */
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String music;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        music = null;
    }

    public User(String firstName, String lastName, String email, String music) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.music = music;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

}
