/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import testData.author;
import testData.jdbcUtil;

/**
 *
 * @author manhc
 */
public class authorDAO implements daoLoad<author>{
    
    public static authorDAO getInstace() {
        return new authorDAO();
    }

    @Override
    public int inSert(author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int upDate(author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deLete(author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public author selectById(author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<author> selectAll() {
        ArrayList<author> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "SELECT * From athor";

            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while(rs.next()){
                int id = rs.getInt("atId");
                String name = rs.getString("athorName");
                String title = rs.getString("athorTitle");
                
                author selectAuthor = new author(id, name, title);
                ketQua.add(selectAuthor);             
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(authorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public ArrayList<author> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        authorDAO dao = new authorDAO();
        ArrayList<author> list = dao.selectAll();
        for (author object : list) {
            System.out.println(object);
        }
    }
    
}
