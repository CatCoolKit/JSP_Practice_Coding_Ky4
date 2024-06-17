/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testData;

/**
 *
 * @author manhc
 */
public class account {
    private int atID;
    private int khID;

    public account() {
    }

    public account(int atID, int khID) {
        this.atID = atID;
        this.khID = khID;
    }

    public int getAtID() {
        return atID;
    }

    public void setAtID(int atID) {
        this.atID = atID;
    }

    public int getKhID() {
        return khID;
    }

    public void setKhID(int khID) {
        this.khID = khID;
    }

    @Override
    public String toString() {
        return "account{" + "atID=" + atID + ", khID=" + khID + '}';
    }
    
    
    
}
