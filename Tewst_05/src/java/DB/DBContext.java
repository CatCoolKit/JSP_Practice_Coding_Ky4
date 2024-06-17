/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manhc
 */
public class DBContext {


    private final String hostName;
    private final String instance;
    private final String port;
    private final String dbName;
    private final String user;
    private final String pass;

    public DBContext() {
        this.hostName = "localhost";
        this.instance = "BODUA_GROUP\\\\BODUAGROUP";
        this.port = "1433";
        this.dbName = "Y23FA1B1";
        this.user = "sa";
        this.pass = "123456";
    }

//    public DBContext(ServletContext sc) {
//        this.hostName = sc.getInitParameter("hostAddress");
//        this.instance = sc.getInitParameter("instance");
//        this.port = sc.getInitParameter("dbPort");
//        this.dbName = sc.getInitParameter("dbName");
//        this.user = sc.getInitParameter("userName");
//        this.pass = sc.getInitParameter("userPass");
//    }

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
            }
        }
    }

    public static void main(String[] args) {
        try {
            DBContext a = new DBContext();
            Connection c = a.getConnection();
            System.out.println(c);
            System.out.println("ket noi thanh cong");
            a.closeConnection(c);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
