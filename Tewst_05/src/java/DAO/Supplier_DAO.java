/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBContext;
import DTO.Supplier;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manhc
 */
public class Supplier_DAO implements DAO_Interac<Supplier>{
    
    private DBContext cn = new DBContext();

    @Override
    public int insertRec(Supplier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateRec(Supplier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteRec(Supplier obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from [dbo].[Suppliers] "
                    + " WHERE SupplierID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getSupplierID());

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
            Logger.getLogger(Supplier_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public Supplier getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Supplier> getALlSupplier() {
        Vector<Supplier> ketQua = new Vector<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From [dbo].[Suppliers]";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String id = rs.getString("SupplierID");
                String name = rs.getString("SupplierName");
                Date bod = rs.getDate("BirthDate");
                String gd = rs.getString("Gender");
                String ad = rs.getString("Address");

                Supplier user = new Supplier(id, name, bod, gd, ad);
                ketQua.add(user);
            }

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Supplier_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }
    
    public Vector<Supplier> getSupplierByName(String nameBy) {
        Vector<Supplier> ketQua = new Vector<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From [dbo].[Suppliers] WHERE SupplierName like ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+nameBy+"%");
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String id = rs.getString("SupplierID");
                String name = rs.getString("SupplierName");
                Date bod = rs.getDate("BirthDate");
                String gd = rs.getString("Gender");
                String ad = rs.getString("Address");

                Supplier user = new Supplier(id, name, bod, gd, ad);
                ketQua.add(user);
            }

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Supplier_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }
    
    public Vector<Supplier> getSupplierByYear(String year) {
        Vector<Supplier> ketQua = new Vector<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From [dbo].[Suppliers] WHERE year(BirthDate) = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, year);
            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String id = rs.getString("SupplierID");
                String name = rs.getString("SupplierName");
                Date bod = rs.getDate("BirthDate");
                String gd = rs.getString("Gender");
                String ad = rs.getString("Address");

                Supplier user = new Supplier(id, name, bod, gd, ad);
                ketQua.add(user);
            }

            // Bước 5:
            cn.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Supplier_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }
    
    public static void main(String[] args) {
        Supplier_DAO spl = new Supplier_DAO();
        Vector<Supplier> list = spl.getALlSupplier();
        for (Supplier supplier : list) {
            System.out.println(supplier.toString());
        }
        list = spl.getSupplierByYear("1990");
        for (Supplier supplier : list) {
            System.out.println(supplier.toString());
        }
        
    }
    
    
    
}
