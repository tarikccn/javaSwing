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
public class TruckOwner extends User{
    

    public TruckOwner() {
        
    }

    public TruckOwner(int id, String email, String name, String phone, String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }
    
    DBConnect connect = new DBConnect();

    
    
    public void insertTruckOwner(String email, String name, String phoneNo, String password) throws SQLException{
        
        String query = "{CALL insert_truck_owner(?,?,?,?)}";
        RegisterPage registerPage = new RegisterPage();
        
        try {
            connect.connection.setAutoCommit(false);
            CallableStatement pstmt = connect.connection.prepareCall(query);
            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            
            connect.ps.setString(1, email);
            connect.ps.setString(2, name);
            connect.ps.setString(3, phoneNo);
            connect.ps.setString(4, password);
           
            
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
            
            
        }
    }
    
    public void loginTruckOwner(String email, String password){
        connect = new DBConnect();
        String query = "{CALL login_truck_owner(?,?)}";
        
        try {
            CallableStatement pstmt = connect.connection.prepareCall(query);
            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            connect.ps.setString(1, email);
            connect.ps.setString(2, password);
        } catch (Exception e) {
            System.out.println("Griş Hatası");
        }
        
    }
    
    
    
    
}
