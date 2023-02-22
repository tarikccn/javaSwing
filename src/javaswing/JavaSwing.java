/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaswing;

import Service.DBConnect;
import View.LoginPage;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.UIManager;
import java.sql.*;

/**
 *
 * @author Bhop
 */
public class JavaSwing {
    public static boolean connectionState = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            connectionState = true;
        } catch (MalformedURLException e) {
            System.out.println("Internet is not connected");
            connectionState = false;
        }catch(IOException exception){
            System.out.println("Internet is not connected");
            connectionState = false;
        }
        /*
        DBConnect con = new DBConnect();
        try {
            ResultSet rs = con.stmt.executeQuery("SELECT * FROM customer");
            while(rs.next()){
                System.out.println("email : "+rs.getString("email"));
                System.out.println("password : "+rs.getString("sifre"));
            }
        } catch (SQLException e) {
            System.out.println("No data");
            e.printStackTrace();
        }
        */
        
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
                
    }
    
}
