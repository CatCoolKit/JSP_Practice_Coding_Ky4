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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import utilities.ConnectDB;

/**
 *
 * @author manhc
 */
public class AccountDao implements Accessible<Account> {

    private ConnectDB cn = new ConnectDB();

    @Override
    public int insertRec(Account obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO accounts (account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getAccount());
            st.setString(2, obj.getPass());
            st.setString(3, obj.getLastName());
            st.setString(4, obj.getFirstName());
            st.setDate(5, new java.sql.Date(obj.getBirthday().getTime()));
            st.setBoolean(6, obj.isGender());
            st.setString(7, obj.getPhone());
            st.setBoolean(8, obj.isIsUse());
            st.setInt(9, obj.getRoleInSystem());

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
    public int updateRec(Account obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE accounts "
                    + " SET "
                    + " pass=?"
                    + ", lastName=?"
                    + ", firstName=?"
                    + ", birthday=?"
                    + ", gender=?"
                    + ", phone=?"
                    + ", isUse=?"
                    + ", roleInSystem=?"
                    + " WHERE account=?";

            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, obj.getPass());
            st.setString(2, obj.getLastName());
            st.setString(3, obj.getFirstName());
            st.setDate(4, new java.sql.Date(obj.getBirthday().getTime()));
            st.setBoolean(5, obj.isGender());
            st.setString(6, obj.getPhone());
            st.setBoolean(7, obj.isIsUse());
            st.setInt(8, obj.getRoleInSystem());
            st.setString(9, obj.getAccount());

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
    public Account getObjectById(String id) {
        Account ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From accounts Where account=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String account = rs.getString("account");
                String pass = rs.getString("pass");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                Date birthday = rs.getDate("birthday");
                boolean gender = rs.getBoolean("gender");
                String phone = rs.getString("phone");
                boolean isUser = rs.getBoolean("isUse");
                int roleInSystem = rs.getInt("roleInSystem");

                ketQua = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUser, roleInSystem);

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
    public List<Account> listAll() {
        ArrayList<Account> ketQua = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * From accounts";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String account = rs.getString("account");
                String pass = rs.getString("pass");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                Date birthday = rs.getDate("birthday");
                boolean gender = rs.getBoolean("gender");
                String phone = rs.getString("phone");
                boolean isUser = rs.getBoolean("isUse");
                int roleInSystem = rs.getInt("roleInSystem");

                Account user = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUser, roleInSystem);
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
    public int deleteRec(Account obj) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from accounts "
                    + " WHERE account=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getAccount());

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

    public static void main(String[] args) throws ParseException {
        AccountDao pd = new AccountDao();
        Account ac = new Account("admin", "", "", "", null, true, null, true, 0);
        pd.updateIsUsed(ac, "0");
        List<Account> list = pd.listAll();
        for (Account product : list) {
            System.out.println(product.toString());
        }
    }

    public void updateIsUsed(Account account, String iu) {
        int ketQua;
        boolean check = true;
        if(iu.equals("0")){
            check = false;
        }else{
            check = true;
        }
        
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = cn.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE accounts "
                    + " SET "
                    + " isUse=?"
                    + " WHERE account=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setBoolean(1, check);
            st.setString(2, account.getAccount());

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

    }
}
