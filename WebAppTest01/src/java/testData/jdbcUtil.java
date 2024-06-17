/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manhc
 */
public class jdbcUtil {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        
        // Đăng ký Driver (nếu cần thiết)
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ301_SE1706";
        String username = "manhcuong123";
        String password = "chambas";
        
        // Load and register the JDBC driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Establish the connection
        Connection connection = DriverManager.getConnection(url, username, password);
        
        return connection;
    }
    
    public static void closeConnection(Connection c){
        if (c != null) {
            try {
                c.close();
                System.out.println("Đã ngắt kết nối thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void printInfo(Connection c){
        if (c != null) {
            try {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
                
            } catch (SQLException ex) {
                Logger.getLogger(jdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
