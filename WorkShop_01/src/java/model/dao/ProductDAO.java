/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Category;
import model.Product;
import utilities.ConnectDB;

/**
 *
 * @author manhc
 */
public class ProductDAO implements Accessible<Product> {

    ConnectDB cn = new ConnectDB();

    @Override
    public int insertRec(Product obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO products (productId, productName, productImage, brief, typeId, account, unit, price, discount) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getProductId());
            st.setString(2, obj.getProductName());
            st.setString(3, obj.getProductImage());
            st.setString(4, obj.getBrief());
            st.setInt(5, obj.getType().getTypeId());
            st.setString(6, obj.getAccount().getAccount());
            st.setString(7, obj.getUnit());
            st.setDouble(8, obj.getPrice());
            st.setDouble(9, obj.getDiscount());
            
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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ketQua;
    }

    @Override
    public int updateRec(Product obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE products "
                    + " SET "
                    + " productName=?"
                    + ", productImage=?"
                    + ", brief=?"
                    + ", postedDate=?"
                    + ", typeId=?"
                    + ", account=?"
                    + ", unit=?"
                    + ", price=?"
                    + ", discount=?"
                    + " WHERE productId=?";

            PreparedStatement st = con.prepareStatement(sql);

           
            st.setString(1, obj.getProductName());
            st.setString(2, obj.getProductImage());
            st.setString(3, obj.getBrief());
            st.setDate(4, new java.sql.Date(obj.getPostedDate().getTime()));
            st.setInt(5, obj.getType().getTypeId());
            st.setString(6, obj.getAccount().getAccount());
            st.setString(7, obj.getUnit());
            st.setDouble(8, obj.getPrice());
            st.setDouble(9, obj.getDiscount());
             st.setString(10, obj.getProductId());

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
    public Product getObjectById(String id) {
        Product ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From products Where productId=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                String brief = rs.getString("brief");
                Date postedDate = rs.getDate("postedDate");
                Category type = new Category(rs.getInt("typeId"), "", "");
                Account account = new Account(rs.getString("account"), "", "", "", null, true, "", true, 0);
                String unit = rs.getString("unit");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");

                // Create a DecimalFormat object to format the double values as strings
                NumberFormat formatter = new DecimalFormat("#.##");
                String formattedPrice = formatter.format(price);
                String formattedDiscount = formatter.format(discount);

                ketQua = new Product(productId, productName, productImage, brief, postedDate, type, account, unit, Double.parseDouble(formattedPrice), Double.parseDouble(formattedDiscount));
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
    public List<Product> listAll() {
        ArrayList<Product> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From products";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                String brief = rs.getString("brief");
                Date postedDate = rs.getDate("postedDate");
                Category type = new Category(rs.getInt("typeId"), "", "");
                Account account = new Account(rs.getString("account"), "", "", "", null, true, "", true, 0);
                String unit = rs.getString("unit");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");

                // Create a DecimalFormat object to format the double values as strings
                NumberFormat formatter = new DecimalFormat("#.##");
                String formattedPrice = formatter.format(price);
                String formattedDiscount = formatter.format(discount);

                Product pd = new Product(productId, productName, productImage, brief, postedDate, type, account, unit, Double.parseDouble(formattedPrice), Double.parseDouble(formattedDiscount));
                ketQua.add(pd);
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
    public int deleteRec(Product obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from products "
                    + " WHERE productId=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getProductId());

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
        ProductDAO pd = new ProductDAO();
        List<Product> list = pd.listAll();
        DecimalFormat formatter = new DecimalFormat("#.##");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setCurrency(Currency.getInstance("VND"));
        double a = 10.5;
        Product as = new Product("test", "test", "test", "test", null, new Category(1, "", ""), new Account("admin", "", "", "", null, true, "", true, 0), "test", 240000000, 1);
        
        String priceFormatted = currencyFormat.format(a);
       
        System.out.println(formatter.format(a));
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

}
