/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.jdbcUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import model.sach;

/**
 *
 * @author manhc
 */
public class sachDao implements DAO_Interface<sach> {

    public static sachDao getInstace() {
        return new sachDao();
    }

    @Override
    public int inSert(sach t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "INSERT INTO nhaSach (id, tenSach, giaBan, namXuatBan) "
                    + " VALUES ('" + t.getId() + "' , '" + t.getTenSach() + "' , " + t.getGiaBan() + " , '" + t.getNamXuatBan() + "')";

            ketQua = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int upDate(sach t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "UPDATE nhaSach "
                    + " SET "
                    + " tenSach='" + t.getTenSach() + "'"
                    + ", giaBan=" + t.getGiaBan()
                    + ", namXuatBan=" + t.getNamXuatBan()
                    + " WHERE id='" + t.getId() + "\'";
            System.out.println(sql);
            ketQua = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int deLete(sach t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "DELETE from nhaSach "
                    + " WHERE id='" + t.getId() + "'";
            System.out.println(sql);
            ketQua = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public ArrayList<sach> selectAll() {
        ArrayList<sach> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * From nhaSach";

            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while(rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                
                sach selectBook = new sach(id, tenSach, giaBan, namXuatBan);
                ketQua.add(selectBook);             
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public sach selectById(sach t) {
        sach ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * From nhaSach Where id='" + t.getId() + "'";

            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while(rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                
                ketQua = new sach(id, tenSach, giaBan, namXuatBan);
                           
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public ArrayList<sach> selectByCondition(String condition) {
        ArrayList<sach> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * From nhaSach Where " + condition;

            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while(rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                
                sach selectBook = new sach(id, tenSach, giaBan, namXuatBan);
                ketQua.add(selectBook);             
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

}
