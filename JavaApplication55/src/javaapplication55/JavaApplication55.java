/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication55;

import dao.khachHangDao;
import dao.sachDao;
import dao.userDao;
import database.jdbcUtil;
import java.sql.Connection;


import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.khachHang;
import model.sach;

/**
 *
 * @author manhc
 */
public class JavaApplication55 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        sach sach1 = new sach("book2", "tai sao phai ngu", 50000, 2019);
        sach sach3 = new sach("book3", "LTC", 100000, 2010);
        //sachDao.getInstace().inSert(sach3);
        
        //sach1 = new sach("book1", "tai sao phai ngu", 100000, 2019);
        //sachDao.getInstace().upDate(sach1);

        //sachDao.getInstace().deLete(sach1);
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        try {
            ngaySinh = dateFormat.parse("1999-10-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        khachHang kh1 = new khachHang(1003, "Nguyen Van B", ngaySinh, "Thành phố HCM");
        //khachHangDao.getinstance().inSert(kh1);
        //khachHangDao.getinstance().upDate(kh1);
        //khachHangDao.getinstance().deLete(kh1);
        
        
        //Lấy sách từ DB
        ArrayList<sach> list = sachDao.getInstace().selectAll();
        for (sach object : list) {
            System.out.println(object.toString());
        }
        
        System.out.println("===================================");
        sach find = new sach();
        find.setId("book2");
        sach sach2 = sachDao.getInstace().selectById(find);
        System.out.println(sach2);
        
        //Lấy ds khách hàng từ DB
        ArrayList<khachHang> listkh = khachHangDao.getinstance().selectAll();
        for (khachHang object : listkh) {
            System.out.println(object.toString());
        }
        
        System.out.println("===================================");
        User us1 = new User("kanglinh", "nhs80a", "leehongsuk");
        //userDao.getInstace().inSert(us1);
        //userDao.getInstace().upDate(us1);
        //userDao.getInstace().deLete(us1);
        
        //Lấy ds user từ DB
        ArrayList<User> list3 = userDao.getInstace().selectAll();
        for (User object : list3) {
            System.out.println(object.toString());
        }
        
    }
    
}
