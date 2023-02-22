/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Service.DBConnect;
import View.MsgDialog;
import View.TruckMainPage;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Bhop
 */
public class Truck extends TruckOwner {

    String brand;
    String truckCapasity;
    String truckPlate;

    public Truck() {
    }

    public Truck(String brand, String truckCapasity, String truckPlate) {
        this.brand = brand;
        this.truckCapasity = truckCapasity;
        this.truckPlate = truckPlate;
    }

    public void insertTruck(int id, String truckBrand, String truckCapasity, String truckPlate) throws SQLException {
        connect = new DBConnect();
        String query = "{CALL insert_truck(?,?,?,?)}";
        TruckMainPage tmp = new TruckMainPage();
        try {
            connect.connection.setAutoCommit(false);
            CallableStatement pstmt = connect.connection.prepareCall(query);
            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            connect.ps.setInt(1, id);
            connect.ps.setString(2, truckBrand);
            connect.ps.setString(3, truckCapasity);
            connect.ps.setString(4, truckPlate);

            connect.ps.executeUpdate();
            connect.connection.commit();
            connect.ps.close();
            connect.connection.close();
            MsgDialog msg = new MsgDialog(tmp, "Başarılı", "Başarılı bir şekilde kayıt olundu", 0, MsgDialog.SelectedIcon.SUCCESS_ICON);
            msg.setVisible(true);
        } catch (SQLException ex) {
            //connect.connection.rollback();

            MsgDialog msg = new MsgDialog(tmp, "Hata", "Bu kullanıcıdan var", 0, MsgDialog.SelectedIcon.WARNING_ICON);
            msg.setVisible(true);
            System.out.println("Not insert");
            connect.connection.rollback();
            ex.printStackTrace();

        }
    }
/*
    public ArrayList<Object> getTruck(int id, ArrayList<Object> list) {
        connect = new DBConnect();
        String query = "{CALL truckGet(?)}";

        try {

            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            connect.ps.setInt(1, id);

            ResultSet rs = connect.ps.executeQuery();

            while (rs.next()) {

                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    String str = rs.getString(i);
                    list.add(str);
                    System.out.println(str);
                }

            }

        } catch (SQLException e) {
            System.out.println("Tır çekme hatası");
               e.printStackTrace();
        }

        return list;
    }
*/

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTruckCapasity() {
        return truckCapasity;
    }

    public void setTruckCapasity(String truckCapasity) {
        this.truckCapasity = truckCapasity;
    }

    public String getTruckPlate() {
        return truckPlate;
    }

    //int truckOwnerId;
    public void setTruckPlate(String truckPlate) {
        this.truckPlate = truckPlate;
    }

}
