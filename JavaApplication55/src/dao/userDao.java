/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.jdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author manhc
 */
public class userDao implements DAO_Interface<User>{
    public static userDao getInstace() {
        return new userDao();
    }

    @Override
    public int inSert(User t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO Registration (username, password, lastname, isAdmin) "
                    + " VALUES (?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getUsername());
            st.setString(2, t.getPassword());
            st.setString(3, t.getHoVaTen());

            // Bước 3: thực thi câu lệnh SQL
            
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int upDate(User t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE Registration "
                    + " SET "
                    + " password=?" 
                    + ", lastname=?"
                    + " WHERE username=?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getPassword());
            st.setString(2, t.getHoVaTen());
            st.setString(3, t.getUsername());

            // Bước 3: thực thi câu lệnh SQL
            
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int deLete(User t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from Registration "
                    + " WHERE username=?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getUsername());

            // Bước 3: thực thi câu lệnh SQL
            
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From Registration";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL

            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String hoVaTen = rs.getString("lastname");
                
                User selectBook = new User(username, password, hoVaTen);
                ketQua.add(selectBook);             
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public User selectById(User t) {
        User ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From Registration Where username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getUsername());

            // Bước 3: thực thi câu lệnh SQL

            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String hoVaTen = rs.getString("lastname");
                
                ketQua = new User(username, password, hoVaTen);
                           
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * From Registration Where " + condition;

            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String hoVaTen = rs.getString("lastname");
                
                User selectBook = new User(username, password, hoVaTen);
                ketQua.add(selectBook);             
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }
}
