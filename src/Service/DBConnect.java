/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

//import com.sun.jdi.connect.spi.Connection;
//import java.beans.Statement;
import java.sql.*;

/**
 *
 * @author Bhop
 */
public class DBConnect {
    public Connection connection;
    public Statement stmt;
    public PreparedStatement ps;
    public DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.34:3306/TCT", "newUser", "rootroot");
            //connection = (Connection) DriverManager.getConnection("jdbc:mysql://172.20.10.2:3306/Truck", "newUser", "rootroot");
            //connection.setAutoCommit(false);
            stmt = connection.createStatement();
            System.out.println("Connteciton Success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connteciton Failed");
        }
    }
    
}
