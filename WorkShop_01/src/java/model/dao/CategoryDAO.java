/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Category;
import utilities.ConnectDB;

/**
 *
 * @author manhc
 */
public class CategoryDAO implements Accessible<Category>{
    
    private ConnectDB cn = new ConnectDB();

    @Override
    public int insertRec(Category obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO categories (categoryName, memo) "
                    + " VALUES (?, ?)";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getCategoryName());
            st.setString(2, obj.getMemo());

            // Bước 3: thực thi câu lệnh SQL

            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int updateRec(Category obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE categories "
                    + " SET "
                    + " categoryName=?"
                    + ", memo=?"
                    + " WHERE typeId=?";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, obj.getCategoryName());
            st.setString(2, obj.getMemo());
            st.setInt(3, obj.getTypeId());

            // Bước 3: thực thi câu lệnh SQL
            
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public Category getObjectById(String id) {
        Category ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From categories Where typeId=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));

            // Bước 3: thực thi câu lệnh SQL

            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()){
                int typeId = rs.getInt("typeId");
                String categoryName = rs.getString("categoryName");
                String memo = rs.getString("memo");
                
                ketQua = new Category(typeId, categoryName, memo);
                           
            }

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }
    
    public Category getObjectByCondition(String condition) {
        Category ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From categories Where categoryName = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, condition);

            // Bước 3: thực thi câu lệnh SQL

            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()){
                int typeId = rs.getInt("typeId");
                String categoryName = rs.getString("categoryName");
                String memo = rs.getString("memo");
                
                ketQua = new Category(typeId, categoryName, memo);
                           
            }

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public List<Category> listAll() {
        ArrayList<Category> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From categories";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL

            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()){
                int typeId = rs.getInt("typeId");
                String categoryName = rs.getString("categoryName");
                String memo = rs.getString("memo");
                
                Category user = new Category(typeId, categoryName, memo);
                ketQua.add(user);             
            }

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int deleteRec(Category obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from categories "
                    + " WHERE typeId=?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, obj.getTypeId());

            // Bước 3: thực thi câu lệnh SQL
            
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }
    
    public static void main(String[] args) {
        CategoryDAO cgd = new CategoryDAO();
        String categoryName = "content test";
        String memo = "content test";
        Category cg = new Category(0, categoryName, memo);
        //cgd.insertRec(cg);
        Category test = cgd.getObjectById("1006");
        System.out.println(test.toString());
        List<Category> list = cgd.listAll();
        for (Category category : list) {
            System.out.println(category.toString());
        }
    }
    
}
