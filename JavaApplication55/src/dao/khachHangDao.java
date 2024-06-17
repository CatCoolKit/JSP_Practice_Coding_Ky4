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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.khachHang;
import model.sach;

/**
 *
 * @author manhc
 */
public class khachHangDao implements DAO_Interface<khachHang> {

    public static khachHangDao getinstance() {
        return new khachHangDao();
    }

    @Override
    public int inSert(khachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinhFormatted = dateFormat.format(t.getNgaySinh()); // Chuyển đổi ngày tháng thành chuỗi
            String sql = "INSERT INTO khachHang (id, hoVaTen, ngaySinh, diaChi) "
                    + " VALUES (" + t.getId() + " , '" + t.getHoVaTen() + "' , '" + ngaySinhFormatted + "' , '" + t.getDiaChi() + "')";

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
    public int upDate(khachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinhFormatted = dateFormat.format(t.getNgaySinh()); // Chuyển đổi ngày tháng thành chuỗi
            String sql = "UPDATE khachHang "
                    + " SET "
                    + " hoVaTen='" + t.getHoVaTen() + "'"
                    + ", ngaySinh='" + ngaySinhFormatted + "'"
                    + ", diaChi='" + t.getDiaChi() + "'"
                    + " WHERE id=" + t.getId();

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
    public int deLete(khachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "DELETE from khachHang "
                    + " WHERE id=" + t.getId();
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
    public ArrayList<khachHang> selectAll() {
        ArrayList<khachHang> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * From khachHang";

            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while(rs.next()){
                int id = rs.getInt("id");
                String hoVaTen = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi");
                
                khachHang selectBook = new khachHang(id, hoVaTen, ngaySinh, diaChi);
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
    public khachHang selectById(khachHang t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<khachHang> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
