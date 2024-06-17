/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author manhc
 */
public class Supplier {
    private String SupplierID, SupplierName, Gender, Address;
    private Date BirthDate;

    public Supplier() {
    }

    public Supplier(String SupplierID, String SupplierName, Date BirthDate, String Gender, String Address) {
        this.SupplierID = SupplierID;
        this.SupplierName = SupplierName;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
        this.Address = Address;
        
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public String getGender() {
        return Gender.equals("1")?"Male":"Female";
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    @Override
    public String toString() {
        return "Supplier{" + "SupplierID=" + SupplierID + ", SupplierName=" + SupplierName + ", Gender=" + Gender + ", Address=" + Address + ", BirthDate=" + BirthDate + '}';
    }
    
}
