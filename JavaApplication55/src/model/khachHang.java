/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;





/**
 *
 * @author manhc
 */
public class khachHang {
    private int id;
    private String hoVaTen;
    private Date ngaySinh;
    private String diaChi;

    public khachHang() {
    }

    public khachHang(int id, String hoVaTen, Date ngaySinh, String diaChi) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "khachHang{" + "id=" + id + ", hoVaTen=" + hoVaTen + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + '}';
    }
    
    
}
