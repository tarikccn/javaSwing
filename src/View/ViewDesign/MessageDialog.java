/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.ViewDesign;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Bhop
 */
public class MessageDialog extends javax.swing.JDialog {
    
    private final  JFrame frame;
    
    public MessageDialog(JFrame frame, String title, String explanation) {
        super(frame, true);
        this.frame = frame;
        this.setUndecorated(true);
        initComponents();
        init();
        this.title.setText(title);
        aciklama.setText(explanation);
    }
    
    private void init(){
        setLocationRelativeTo(frame);
        getContentPane().setBackground(Color.black);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customPanel1 = new View.ViewDesign.CustomPanel();
        confirmationButton = new View.ViewDesign.CustomButton();
        cancelButton = new View.ViewDesign.CustomButton();
        title = new javax.swing.JLabel();
        aciklama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        customPanel1.setBackground(new java.awt.Color(255, 255, 255));
        customPanel1.setRoundBottomLeft(20);
        customPanel1.setRoundBottomRight(20);
        customPanel1.setRoundTopLeft(20);
        customPanel1.setRoundTopRight(20);

        confirmationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_ok_16.png"))); // NOI18N
        confirmationButton.setText("Onayla");
        confirmationButton.setAlignmentX(0.5F);
        confirmationButton.setBorderColor(new java.awt.Color(0, 0, 0));
        confirmationButton.setColorActive(new java.awt.Color(255, 255, 255));
        confirmationButton.setColorClick(new java.awt.Color(102, 102, 102));
        confirmationButton.setColorDisable(new java.awt.Color(0, 0, 0));
        confirmationButton.setColorOver(new java.awt.Color(0, 0, 0));
        confirmationButton.setRadius(20);
        confirmationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmationButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_cancel_16.png"))); // NOI18N
        cancelButton.setText("İptal Et");
        cancelButton.setAlignmentX(0.5F);
        cancelButton.setBorderColor(new java.awt.Color(0, 0, 0));
        cancelButton.setColorActive(new java.awt.Color(255, 255, 255));
        cancelButton.setColorClick(new java.awt.Color(102, 102, 102));
        cancelButton.setColorDisable(new java.awt.Color(0, 0, 0));
        cancelButton.setColorOver(new java.awt.Color(0, 0, 0));
        cancelButton.setRadius(20);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Title");

        aciklama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aciklama.setText("Açıklama");

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aciklama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmationButtonActionPerformed
        dispose();
    }//GEN-LAST:event_confirmationButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aciklama;
    private View.ViewDesign.CustomButton cancelButton;
    private View.ViewDesign.CustomButton confirmationButton;
    private View.ViewDesign.CustomPanel customPanel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
