/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Customer;
import Model.TruckOwner;
import Service.DBConnect;
import com.sun.source.tree.BreakTree;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswing.JavaSwing;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author Bhop
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    DBConnect con;
    public LoginPage() {
        UIManager.put("TextField.caretForeground", Color.white);
        UIManager.put("PasswordField.caretForeground", Color.white);
        this.setUndecorated(true);
        initComponents();
        getContentPane().setBackground(new Color(51, 51, 51));
        setLocationRelativeTo(null);
        
        JavaSwing js = new JavaSwing();
        if(js.connectionState == true){
            connectionIcon.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_connected_16.png")));
            connectionLabel.setText("Bağlandı");
            connectionLabel.setForeground(Color.green);
            connectionIcon1.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_connected_16.png")));
            connectionLabel1.setText("Bağlandı");
            connectionLabel1.setForeground(Color.green);
        }else{
            connectionIcon.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_disconnected_16.png")));
            connectionLabel.setText("Bağlantı Kesildi");
            connectionLabel.setForeground(Color.red);
            connectionIcon1.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_disconnected_16.png")));
            connectionLabel1.setText("Bağlantı Kesildi");
            connectionLabel1.setForeground(Color.red);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customPanel3 = new View.ViewDesign.CustomPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        registerButton = new View.ViewDesign.CustomButton();
        materialTabbed1 = new View.ViewDesign.MaterialTabbed();
        customPanel1 = new View.ViewDesign.CustomPanel();
        truckEmailTF = new View.ViewDesign.TextField();
        truckLoginButton = new View.ViewDesign.CustomButton();
        truckPasswordTF = new View.ViewDesign.PasswordField();
        connectionIcon = new javax.swing.JLabel();
        connectionLabel = new javax.swing.JLabel();
        customPanel2 = new View.ViewDesign.CustomPanel();
        customerEmailTF = new View.ViewDesign.TextField();
        customerLoginButton = new View.ViewDesign.CustomButton();
        customerPasswordTF = new View.ViewDesign.PasswordField();
        connectionIcon1 = new javax.swing.JLabel();
        connectionLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        customPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Merhaba!");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hala kayıt olmadıysan aşağıda");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("olabilirsin...");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("bulunan buton ile kayıt");

        registerButton.setText("Kayıt Ol !");
        registerButton.setAlignmentX(0.5F);
        registerButton.setBorderColor(new java.awt.Color(0, 0, 0));
        registerButton.setColorActive(new java.awt.Color(255, 255, 255));
        registerButton.setColorClick(new java.awt.Color(102, 102, 102));
        registerButton.setColorDisable(new java.awt.Color(0, 0, 0));
        registerButton.setColorOver(new java.awt.Color(0, 0, 0));
        registerButton.setRadius(20);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel3Layout = new javax.swing.GroupLayout(customPanel3);
        customPanel3.setLayout(customPanel3Layout);
        customPanel3Layout.setHorizontalGroup(
            customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(customPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customPanel3Layout.setVerticalGroup(
            customPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(88, 88, 88)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        materialTabbed1.setBackground(new java.awt.Color(51, 51, 51));
        materialTabbed1.setForeground(new java.awt.Color(255, 255, 255));

        customPanel1.setBackground(new java.awt.Color(51, 51, 51));

        truckEmailTF.setBackground(new java.awt.Color(51, 51, 51));
        truckEmailTF.setForeground(new java.awt.Color(255, 255, 255));
        truckEmailTF.setLabelText("Email");
        truckEmailTF.setLineColor(new java.awt.Color(255, 255, 255));
        truckEmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                truckEmailTFActionPerformed(evt);
            }
        });

        truckLoginButton.setBackground(new java.awt.Color(51, 51, 51));
        truckLoginButton.setForeground(new java.awt.Color(255, 255, 255));
        truckLoginButton.setText("Giriş Yap");
        truckLoginButton.setAlignmentX(0.5F);
        truckLoginButton.setBorderColor(new java.awt.Color(255, 255, 255));
        truckLoginButton.setColor(new java.awt.Color(51, 51, 51));
        truckLoginButton.setColorActive(new java.awt.Color(0, 0, 0));
        truckLoginButton.setColorClick(new java.awt.Color(102, 102, 102));
        truckLoginButton.setColorDisable(java.awt.Color.white);
        truckLoginButton.setColorOver(new java.awt.Color(255, 255, 255));
        truckLoginButton.setRadius(20);
        truckLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                truckLoginButtonActionPerformed(evt);
            }
        });

        truckPasswordTF.setBackground(new java.awt.Color(51, 51, 51));
        truckPasswordTF.setForeground(new java.awt.Color(255, 255, 255));
        truckPasswordTF.setAdressEye("/WhiteIcon/eye.png");
        truckPasswordTF.setAdressEyeHide("/WhiteIcon/hideEye.png");
        truckPasswordTF.setLabelText("Şifre");
        truckPasswordTF.setLineColor(new java.awt.Color(255, 255, 255));
        truckPasswordTF.setShowAndHide(true);

        connectionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        connectionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_connected_16.png"))); // NOI18N

        connectionLabel.setForeground(new java.awt.Color(0, 255, 51));
        connectionLabel.setText("Connected");

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(connectionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(truckLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(truckEmailTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(truckPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(connectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(connectionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(truckEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(truckPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(truckLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        materialTabbed1.addTab("Tır Sahibi Giriş", new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_truck_32_1.png")), customPanel1); // NOI18N

        customPanel2.setBackground(new java.awt.Color(51, 51, 51));

        customerEmailTF.setBackground(new java.awt.Color(51, 51, 51));
        customerEmailTF.setForeground(new java.awt.Color(255, 255, 255));
        customerEmailTF.setLabelText("Email");
        customerEmailTF.setLineColor(new java.awt.Color(255, 255, 255));
        customerEmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerEmailTFActionPerformed(evt);
            }
        });

        customerLoginButton.setBackground(new java.awt.Color(51, 51, 51));
        customerLoginButton.setForeground(new java.awt.Color(255, 255, 255));
        customerLoginButton.setText("Giriş Yap");
        customerLoginButton.setAlignmentX(0.5F);
        customerLoginButton.setBorderColor(new java.awt.Color(255, 255, 255));
        customerLoginButton.setColor(new java.awt.Color(51, 51, 51));
        customerLoginButton.setColorActive(new java.awt.Color(0, 0, 0));
        customerLoginButton.setColorClick(new java.awt.Color(102, 102, 102));
        customerLoginButton.setColorDisable(java.awt.Color.white);
        customerLoginButton.setColorOver(new java.awt.Color(255, 255, 255));
        customerLoginButton.setRadius(20);
        customerLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerLoginButtonActionPerformed(evt);
            }
        });

        customerPasswordTF.setBackground(new java.awt.Color(51, 51, 51));
        customerPasswordTF.setForeground(new java.awt.Color(255, 255, 255));
        customerPasswordTF.setAdressEye("/WhiteIcon/eye.png");
        customerPasswordTF.setAdressEyeHide("/WhiteIcon/hideEye.png");
        customerPasswordTF.setLabelText("Şifre");
        customerPasswordTF.setLineColor(new java.awt.Color(255, 255, 255));
        customerPasswordTF.setShowAndHide(true);

        connectionIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        connectionIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_connected_16.png"))); // NOI18N

        connectionLabel1.setForeground(new java.awt.Color(0, 255, 51));
        connectionLabel1.setText("Connected");

        javax.swing.GroupLayout customPanel2Layout = new javax.swing.GroupLayout(customPanel2);
        customPanel2.setLayout(customPanel2Layout);
        customPanel2Layout.setHorizontalGroup(
            customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel2Layout.createSequentialGroup()
                .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(connectionIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(customerLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(customerEmailTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customerPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        customPanel2Layout.setVerticalGroup(
            customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(connectionLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(connectionIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(customerEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(customerPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(customerLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        materialTabbed1.addTab("Müşteri Girişi", new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_customer_32_1.png")), customPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        RegisterPage registerPage = null;
        try {
            registerPage = new RegisterPage();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        registerPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void truckLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_truckLoginButtonActionPerformed
     
        con = new DBConnect();          
        if(truckEmailTF.getText().equals("") || truckPasswordTF.getText().equals("")){
            MsgDialog msg = new MsgDialog(this,"Hatalı Giriş","Lütfen Kullanıcı Adı ve Şifre Girin.",0,MsgDialog.SelectedIcon.WARNING_ICON);
            msg.setVisible(true);

        }else{
            //Bu sorgu procedure yapilacak.
            String query = "select * from TruckOwnerTable where email = ? and password = ?";
            try {
                
                con.stmt = con.connection.createStatement();
                con.ps = con.connection.prepareStatement(query);
                con.ps.setString(1, truckEmailTF.getText());
                con.ps.setString(2, truckPasswordTF.getText());
                ResultSet rs = con.ps.executeQuery();

                

                if(rs.next()){
                        System.out.println(rs.getInt("truck_owner_id"));
                        TruckOwner to = new TruckOwner(rs.getInt("truck_owner_id"), rs.getString("email"),
                                rs.getString("name_surname"),rs.getString("phone_no"),rs.getString("password"));
                        //CustomerMainPage cmp = new CustomerMainPage(c);
                        
                        TruckMainPage tmp = new TruckMainPage(to);
                        tmp.setVisible(true);
                        dispose();
                }
               
                else{        
                        MsgDialog msg = new MsgDialog(this,"Hatalı Giriş","Email veya Şifre Yanlış",0, MsgDialog.SelectedIcon.WARNING_ICON);
                        msg.setVisible(true);
                        System.out.println(truckEmailTF.getText() + " " + rs.getString("email"));                               
                    }
            } catch (SQLException e) {
                System.out.println("error");
                e.printStackTrace();
            }
        }      
    }//GEN-LAST:event_truckLoginButtonActionPerformed

    private void truckEmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_truckEmailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_truckEmailTFActionPerformed

    private void customerEmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerEmailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerEmailTFActionPerformed

    private void customerLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerLoginButtonActionPerformed
        con = new DBConnect();          
        if(customerEmailTF.getText().equals("") ||customerPasswordTF.getText().equals("")){
            MsgDialog msg = new MsgDialog(this,"Hatalı Giriş","Lütfen Kullanıcı Adı ve Şifre Girin.",0,MsgDialog.SelectedIcon.WARNING_ICON);
            msg.setVisible(true);

        }else{
            try {
                

                PreparedStatement st = (PreparedStatement) con.connection.prepareStatement("select * from CustomerTable where email = ? and password = ?");
                st.setString(1, customerEmailTF.getText());
                st.setString(2, customerPasswordTF.getText());
                ResultSet rs = st.executeQuery();  

                if(rs.next()){
                        System.out.println(rs.getString("customer_id"));
                        Customer c = new Customer(rs.getInt("customer_id"), rs.getString("email"),
                                rs.getString("name_surname"),rs.getString("phone_no"),rs.getString("password"));
                        CustomerMainPage cmp = new CustomerMainPage(c);
                        
                        cmp.setVisible(true);
                        this.dispose();
                }
                
                else{        
                        MsgDialog msg = new MsgDialog(this,"Hatalı Giriş","Email veya Şifre Yanlış",0, MsgDialog.SelectedIcon.WARNING_ICON);
                        msg.setVisible(true);
                        System.out.println(customerEmailTF.getText() + " " + rs.getString("email"));                               
                    }
            } catch (Exception e) {
                System.out.println("error");
                //e.printStackTrace();
            }
        }      
    }//GEN-LAST:event_customerLoginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectionIcon;
    private javax.swing.JLabel connectionIcon1;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JLabel connectionLabel1;
    private View.ViewDesign.CustomPanel customPanel1;
    private View.ViewDesign.CustomPanel customPanel2;
    private View.ViewDesign.CustomPanel customPanel3;
    private View.ViewDesign.TextField customerEmailTF;
    private View.ViewDesign.CustomButton customerLoginButton;
    private View.ViewDesign.PasswordField customerPasswordTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private View.ViewDesign.MaterialTabbed materialTabbed1;
    private View.ViewDesign.CustomButton registerButton;
    private View.ViewDesign.TextField truckEmailTF;
    private View.ViewDesign.CustomButton truckLoginButton;
    private View.ViewDesign.PasswordField truckPasswordTF;
    // End of variables declaration//GEN-END:variables
}
