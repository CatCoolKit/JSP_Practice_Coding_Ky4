/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.connectDB;
import Object.info_User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manhc
 */
public class user_DAO implements dao_Interface<info_User>{
    
    connectDB cn = new connectDB();

    @Override
    public int inSert(info_User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int upDate(info_User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deLete(info_User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<info_User> selectAll() {
    
    ArrayList<info_User> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From tbl_User";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String usId = rs.getString("userId");
                int pass = rs.getInt("password");
                String fullname = rs.getString("fullName");
                int role = rs.getInt("role");

                info_User user = new info_User(usId, pass, fullname, role);
                ketQua.add(user);
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
    public ArrayList<info_User> selectById(info_User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<info_User> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        user_DAO dao = new user_DAO();
        ArrayList<info_User> ketQua = dao.selectAll();
        for (info_User user : ketQua) {
            System.out.println(user.toString());
        }
    }
    
}
