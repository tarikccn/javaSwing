/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Service.DBConnect;
import View.MsgDialog;
import View.RegisterPage;

import java.sql.*;


/**
 *
 * @author Bhop
 */
public class Customer extends User{
    DBConnect connect;
    public Customer() {
        
    }
    
    public Customer(int id, String email, String name, String phone, String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }
    /*
    public Customer(String name, String email, String telefon, String sifre, String type){
        DBConnect connect = new DBConnect();
        String query = "{CALL insertCustomer()}";
        try {
            CallableStatement stmt = connect.connection.prepareCall(query);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    */
    
    public void insertCustomer(String email, String name, String telefon, String sifre) throws SQLException{
        connect = new DBConnect();
        String query = "{CALL insert_customer(?,?,?,?)}";
        RegisterPage registerPage = new RegisterPage();
        try {
            connect.connection.setAutoCommit(false);
            CallableStatement pstmt = connect.connection.prepareCall(query);
            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            connect.ps.setString(1, email);
            connect.ps.setString(2, name);
            connect.ps.setString(3, telefon);
            connect.ps.setString(4, sifre);
            
            
            connect.ps.executeUpdate();
            connect.connection.commit();
            connect.ps.close();
            connect.connection.close();
            MsgDialog msg = new MsgDialog(registerPage, "Başarılı", "Başarılı bir şekilde kayıt olundu", 0, MsgDialog.SelectedIcon.SUCCESS_ICON);
            msg.setVisible(true);
        } catch (SQLException ex) {
            //connect.connection.rollback();
            
            MsgDialog msg = new MsgDialog(registerPage, "Hata", "Bu kullanıcıdan var", 0, MsgDialog.SelectedIcon.WARNING_ICON);
            msg.setVisible(true);
            System.out.println("Not insert");
            connect.connection.rollback();
            ex.printStackTrace();
            
        }
    }
    
    public void loginCustomer(String email, String password){
        connect = new DBConnect();
        String query = "{CALL login_customer(?,?)}";
        
        try {
            CallableStatement pstmt = connect.connection.prepareCall(query);
            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            connect.ps.setString(1, name);
            connect.ps.setString(2, email);
        } catch (Exception e) {
            
        }
        
    }
    
    
    
}
