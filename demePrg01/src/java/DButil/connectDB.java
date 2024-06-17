/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DButil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manhc
 */
public class connectDB {

    private String hostName;
    private String port;
    private String dbName;
    private String userName;
    private String userPass;
    private String instace;
    
    public connectDB(){
        this.hostName = "localhost"; //127.0.0.1
        this.port = "1433";
        this.dbName = "Human";
        this.userName = "manhcuong123";
        this.userPass = "chambas";
    }

    public connectDB(String hostName, String port, String dbName, String userName, String userPass) {
        this.instace = "BODUA_GROUP\\BODUAGROUP";
        this.hostName = hostName;
        this.port = port;
        this.dbName = dbName;
        this.userName = userName;
        this.userPass = userPass;
    }
    
    public String getConnectURL(){
        return "jdbc:sqlserver://"+this.hostName+":"+this.port+";"+
                "databaseName="+this.dbName+";"+
                "user="+this.userName+";"+"password="+this.userPass+";";
    }
    
    public Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection(this.getConnectURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
                
    }
    
    public void closeConnection(Connection c){
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
        connectDB a = new connectDB();
        Connection c = a.getConnection();
        System.out.println(c);
        System.out.println("ket noi thanh cong");
        a.closeConnection(c);
        
    }
    

}
