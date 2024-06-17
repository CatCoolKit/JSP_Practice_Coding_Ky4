/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DButil.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import obJect.peoPle1;

/**
 *
 * @author manhc
 */
public class peoPle_DAO implements dao_Interface<peoPle1> {

    connectDB cn = new connectDB();

    @Override
    public int inSert(peoPle1 t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO Human (humanid, humanname, humandob, humangender,typeid) "
                    + " VALUES (?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getHumanId());
            st.setString(2, t.getHumanName());
            st.setString(3, t.getHumanDob());
            st.setString(4, t.getHumangender());
            st.setInt(5, t.getTypeId());

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
        }

        return ketQua;
    }

    @Override
    public int upDate(peoPle1 t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE Human "
                    + " SET "
                    + " humanname=?"
                    + ", humandob=?"
                    + ", humangender=?"
                    + ", typeid=?"
                    + " WHERE humanid=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(5, t.getHumanId());
            st.setString(1, t.getHumanName());
            st.setString(2, t.getHumanDob());
            st.setString(3, t.getHumangender());
            st.setInt(4, t.getTypeId());

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
        }

        return ketQua;
    }

    @Override
    public int deLete(peoPle1 t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from Human "
                    + " WHERE humanid=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getHumanId());

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
        }

        return ketQua;
    }

    @Override
    public ArrayList<peoPle1> selectAll() {
        ArrayList<peoPle1> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From Human";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                int humanid = rs.getInt("humanid");
                String humanname = rs.getString("humanname");
                String humandob = rs.getString("humandob");
                String humangender = rs.getString("humangender");
                int typeid = rs.getInt("typeid");

                peoPle1 people = new peoPle1(humanid, humanname, humandob, humangender, typeid);
                ketQua.add(people);
            }

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<peoPle1> selectById(peoPle1 t) {
        ArrayList<peoPle1> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From Human Where humanname LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + t.getHumanName() + "%");

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                int humanid = rs.getInt("humanid");
                String humanname = rs.getString("humanname");
                String humandob = rs.getString("humandob");
                String humangender = rs.getString("humangender");
                int typeid = rs.getInt("typeid");

                peoPle1 p = new peoPle1(humanid, humanname, humandob, humangender, typeid);
                ketQua.add(p);
            }

            // Bước 5:
            cn.closeConnection(con);

           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<peoPle1> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        peoPle_DAO p = new peoPle_DAO();
        peoPle1 people1 = new peoPle1(4, "hung", "2001-10-02", "Flase", 1);
        //p.inSert(people1);

        //p.upDate(people1);
        //p.deLete(people1);
        ArrayList<peoPle1> peoList = p.selectById(people1);
        for (peoPle1 ple1 : peoList) {
            System.out.println(ple1.toString());
        }
    }
    
    public String toTable(){
        String r = "";
        r += "<table>";
        for (peoPle1 object : selectAll()) {
            r += "<tr>";
            r += "<td>"+object+"</td>";
            r += "<tr>";
            r += "<tr>";
            
        }
        
        return r;
    }
}
