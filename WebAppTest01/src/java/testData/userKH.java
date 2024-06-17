/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testData;

import java.sql.Date;




/**
 *
 * @author manhc
 */
public class userKH {
    private int id;
    private String name;
    private Date date;
    private String diaChi;

    public userKH() {
    }

    public userKH(int id, String name, Date date, String diaChi) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    

    @Override
    public String toString() {
        return "userKH{" + "id=" + id + ", name=" + name + ", date=" + date + ", diaChi=" + diaChi + '}';
    }
    
    
}
