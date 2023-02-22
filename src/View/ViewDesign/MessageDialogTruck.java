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
public class MessageDialogTruck extends javax.swing.JDialog {
    private final  JFrame frame;
    public int fiyat;
    public MessageDialogTruck(JFrame frame, String title, String explanation) {
        super(frame, true);
        this.frame = frame;
        this.setUndecorated(true);
        
        initComponents();
        this.titleLabel.setText(title);
        explanationArea.setText(explanation);
        explanationArea.setEnabled(false);
        setLocationRelativeTo(frame);
        getContentPane().setBackground(Color.black);
        
        //fiyat = Integer.parseInt(priceTF.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customPanel1 = new View.ViewDesign.CustomPanel();
        confirmationButton = new View.ViewDesign.CustomButton();
        cancelButton = new View.ViewDesign.CustomButton();
        titleLabel = new javax.swing.JLabel();
        priceTF = new View.ViewDesign.TextField();
        textAreaScroll1 = new View.ViewDesign.TextAreaScroll();
        explanationArea = new View.ViewDesign.TextArea();
        exitButton = new View.ViewDesign.CustomButton();

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

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Title");

        priceTF.setLabelText("Fiyat ₺");
        priceTF.setLineColor(new java.awt.Color(0, 0, 0));
        priceTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceTFKeyTyped(evt);
            }
        });

        textAreaScroll1.setLabelText("Açıklama");
        textAreaScroll1.setLineColor(new java.awt.Color(0, 0, 0));

        explanationArea.setColumns(20);
        explanationArea.setRows(5);
        explanationArea.setSelectionColor(new java.awt.Color(0, 0, 0));
        textAreaScroll1.setViewportView(explanationArea);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_close_16.png"))); // NOI18N
        exitButton.setBorderColor(new java.awt.Color(0, 0, 0));
        exitButton.setColorClick(new java.awt.Color(102, 102, 102));
        exitButton.setColorOver(new java.awt.Color(0, 0, 0));
        exitButton.setRadius(500);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customPanel1Layout = new javax.swing.GroupLayout(customPanel1);
        customPanel1.setLayout(customPanel1Layout);
        customPanel1Layout.setHorizontalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customPanel1Layout.createSequentialGroup()
                        .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(customPanel1Layout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(confirmationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(priceTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71))
                    .addGroup(customPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        customPanel1Layout.setVerticalGroup(
            customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        
        if (priceTF.getText().equals("")) {
            System.out.println("Değer gir");
            
        }else{
            fiyat = Integer.parseInt(priceTF.getText());
            dispose();
        }
        
    }//GEN-LAST:event_confirmationButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void priceTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTFKeyTyped
        char c = evt.getKeyChar();
        int tLength = priceTF.getText().length();
        if (!Character.isDigit(c) || tLength == 10){
            evt.consume();
        }
        
    }//GEN-LAST:event_priceTFKeyTyped

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.ViewDesign.CustomButton cancelButton;
    private View.ViewDesign.CustomButton confirmationButton;
    private View.ViewDesign.CustomPanel customPanel1;
    private View.ViewDesign.CustomButton exitButton;
    private View.ViewDesign.TextArea explanationArea;
    private View.ViewDesign.TextField priceTF;
    private View.ViewDesign.TextAreaScroll textAreaScroll1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
