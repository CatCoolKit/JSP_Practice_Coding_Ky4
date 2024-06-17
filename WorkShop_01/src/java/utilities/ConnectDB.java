/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author manhc
 */
public class ConnectDB {

    private String hostName;
    private String instance;
    private String port;
    private String dbName;
    private String user;
    private String pass;

    public ConnectDB() {
        this.hostName = "localhost";
        this.instance = "BODUA_GROUP\\\\BODUAGROUP";
        this.port = "1433";
        this.dbName = "ProductIntro";
        this.user = "manhcuong123";
        this.pass = "chambas";
    }

    public ConnectDB(ServletContext sc) {
        this.hostName = sc.getInitParameter("hostAddress");
        this.instance = sc.getInitParameter("instance");
        this.port = sc.getInitParameter("dbPort");
        this.dbName = sc.getInitParameter("dbName");
        this.user = sc.getInitParameter("userName");
        this.pass = sc.getInitParameter("userPass");
    }

    public String getURLString() {
        String fm = "jdbc:sqlserver://%s\\%s:%s;databaseName=%s;user=%s;password=%s;";
        return String.format(fm, this.hostName, this.instance.trim(), this.port, this.dbName, this.user, this.pass);
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(getURLString());
    }

    public void closeConnection(Connection c) {
        if (c != null) {
            try {
                c.close();
                System.out.println("Đã ngắt kết nối thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            ConnectDB a = new ConnectDB();
            Connection c = a.getConnection();
            System.out.println(c);
            System.out.println("ket noi thanh cong");
            a.closeConnection(c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
