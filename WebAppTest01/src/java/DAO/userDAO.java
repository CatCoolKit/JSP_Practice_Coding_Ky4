/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import testData.author;
import testData.jdbcUtil;
import testData.userKH;

/**
 *
 * @author manhc
 */
public class userDAO implements daoLoad<userKH> {

    public static userDAO getInstace() {
        return new userDAO();
    }

    @Override
    public int inSert(userKH t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO khAthor (khId, hoVaTen, ngaySinh, diaChi) "
                    + " VALUES (?, ?, ?, ?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getId());
            st.setString(2, t.getName());
            st.setDate(3, (java.sql.Date) t.getDate());
            st.setString(4, t.getDiaChi());

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
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int upDate(userKH t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deLete(userKH t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<userKH> selectAll() {
        ArrayList<userKH> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * From khAthor";

            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while (rs.next()) {
                int id = rs.getInt("khId");
                String name = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String dc = rs.getString("diaChi");

                userKH selectUser = new userKH(id, name, ngaySinh, dc);
                ketQua.add(selectUser);
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public userKH selectById(userKH t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<userKH> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        userDAO dao = new userDAO();

        String khdate = "2000-02-02";
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        java.util.Date convertedDate = null;

        try {
            convertedDate = sdf.parse(khdate);
        } catch (ParseException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Chuyển đổi java.util.Date thành java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(convertedDate.getTime());

        userKH t = new userKH(1002, "hung hdd", sqlDate, "hai ba chung");
        dao.inSert(t);
        ArrayList<userKH> list = dao.selectAll();
        for (userKH object : list) {
            System.out.println(object);
        }
    }

}
