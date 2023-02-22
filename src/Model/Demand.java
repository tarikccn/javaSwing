/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Service.DBConnect;
import View.CustomerMainPage;
import View.MsgDialog;
import View.ViewDesign.Table;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bhop
 */
public class Demand extends Customer{

    public Demand() {
    }
    
    
    
    public void insertDemand(int customer_id,String name, String product_type, String product_ex, String product_capasity, String demandPrice, String current_city, String country, String city,String adress, String state) throws SQLException{
        connect = new DBConnect();
        String query = "{CALL insert_demand(?,?,?,?,?,?,?,?,?,?,?)}";
        CustomerMainPage cmp = new CustomerMainPage();
        try {
            connect.connection.setAutoCommit(false);
            CallableStatement pstmt = connect.connection.prepareCall(query);
            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            connect.ps.setInt(1, customer_id);
            connect.ps.setString(2, name);
            connect.ps.setString(3, product_type);
            connect.ps.setString(4, product_ex);
            connect.ps.setString(5, product_capasity);
            connect.ps.setString(6, demandPrice);
            connect.ps.setString(7, current_city);
            connect.ps.setString(8, country);
            connect.ps.setString(9, city);
            connect.ps.setString(10, adress);
            connect.ps.setString(11, state);

            connect.ps.executeUpdate();
            connect.connection.commit();
            connect.ps.close();
            connect.connection.close();
            MsgDialog msg = new MsgDialog(cmp, "Başarılı", "Başarılı bir şekilde kayıt olundu", 0, MsgDialog.SelectedIcon.SUCCESS_ICON);
            msg.setVisible(true);
        } catch (SQLException ex) {
            //connect.connection.rollback();

            MsgDialog msg = new MsgDialog(cmp, "Hata", "Bu kullanıcıdan var", 0, MsgDialog.SelectedIcon.WARNING_ICON);
            msg.setVisible(true);
            System.out.println("Not insert");
            connect.connection.rollback();
            ex.printStackTrace();

        }
    }
    
    
}
