/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Truck;
import Model.TruckOwner;
import Service.DBConnect;
import java.awt.Color;
import java.awt.Event;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import View.ViewDesign.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhop
 */
public class TruckMainPage extends javax.swing.JFrame {

    /**
     * Creates new form TruckMainPage
     */
    public TruckMainPage() {
        initComponents();
    }
    public int capasityInt = 3;

    public TruckMainPage(TruckOwner to) {
        initComponents();
        name.setEnabled(false);
        email.setEnabled(false);
        password.setEnabled(false);
        phoneNo.setEnabled(false);

        phoneCode.setEnabled(false);
        name.setText(to.getName());
        email.setText(to.getEmail());
        phoneNo.setText(to.getPhone());
        password.setText(to.getPassword());
        welcome_name.setText("Hoşgeldin " + to.getName().toUpperCase());
        CountryAndCity cac = new CountryAndCity();
        for (int i = 0; i < cac.phoneCountryCode.length; i++) {
            phoneCode.addItem(cac.phoneCountryCode[i]);
        }
        for (int i = 0; i < cac.plateCountryCode.length; i++) {
            truckPlateCode.addItem(cac.plateCountryCode[i]);
        }
        for (int i = 0; i < cac.capasity.length; i++) {
            truckCapasity.addItem(cac.capasity[i]);
        }

        truckTable.fixTable(scrollPane1);
        demandTable.fixTable(scrollPane);

        getContentPane().setBackground(new Color(51, 51, 51));
        /*
        demandTable.addMouseListener(new MouseAdapter(){
            
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    System.out.println("açılll");
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column
                    JOptionPane.showMessageDialog(null, demandTable.getModel().getValueAt(row, column).toString());
                    System.out.println(demandTable.getModel().getValueAt(2, 1).toString());
                    for(int i = 0; i<5; i++){
                        System.out.println(demandTable.getValueAt(row, i));
                    }
                   
        }
            }
            
        });*/

        Truck truck = new Truck();
        getData(to.getId());
        getDataDemanTable();
        System.out.println("Marka : " + truck.getBrand());

        setLocationRelativeTo(null);
        setTitle("Şöfor Sayfası");

        DefaultTableModel asd = new DefaultTableModel();
        //demandTable.setModel(asd);
        demandTable.setFocusable(true);
        System.out.println("Gelen Id : " + to.getId());
        truckTable.setEnabled(false);
        truckTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (e.getClickCount() == 2) {
                    materialTabbed1.setSelectedIndex(0);
                    int rowIndex = truckTable.rowAtPoint(e.getPoint());
                    int columnIndex = truckTable.columnAtPoint(e.getPoint());

                    System.out.println("selected this item : " + truckTable.getValueAt(rowIndex, 1));
                    Object a = truckTable.getValueAt(rowIndex, 1);

                    String b = String.valueOf(a);
                    String c = "";
                    if (b.length() == 5) {
                        c = b.substring(0, 3);
                    }
                    if (b.length() == 4) {
                        c = b.substring(0, 2);
                    }
                    capasityInt = Integer.parseInt(c);
                    System.out.println("c : " + capasityInt);
                    System.out.println("row : " + rowIndex + " , " + "column : " + columnIndex);
                    //getDemandData();
                }
            }

        });
        //getDemandData();
        TruckSaveButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(truckBrand.getText() + " " + truckCapasity.getSelectedItem().toString() + " " + truckPlate.getText());
                if (truckBrand.getText().equals("") || truckPlate.getText().equals("")) {
                    //Error Message
                } else {
                    Truck truck = new Truck();
                    try {
                        truck.insertTruck(to.getId(), truckBrand.getText(), truckCapasity.getSelectedItem().toString(),
                                truckPlateCode.getSelectedItem().toString() + " " + truckPlate.getText());
                        getData(to.getId());

                    } catch (SQLException ex) {
                        Logger.getLogger(TruckMainPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        })
        );

    }
    /*
    String[] titles = {"ID", "Ad & Soyad", "Tür", "Hacim", "Tarih", "Durum"};
    Object[][] data = {{1, "Tarık Cucun", "Portakal", "100m", "2.11.2022", "True"}, {2, "Emre Selim", "Domtates", "110m", "2.11.2022", "True"}, {3, "Mehmet KA", "Karpuz", "70m", "2.11.2022", "False"},
    {1, "Tarık Cucun", "Portakal", "100m", "2.11.2022", "True"}, {2, "Emre Selim", "Domtates", "110m", "2.11.2022", "True"}, {3, "Mehmet KA", "Karpuz", "70m", "2.11.2022", "False"},
    {1, "Tarık Cucun", "Portakal", "100m", "2.11.2022", "True"}, {2, "Emre Selim", "Domtates", "110m", "2.11.2022", "True"}, {3, "Mehmet KA", "Karpuz", "70m", "2.11.2022", "False"}};
     */
    String[] titlesTruck = {"Marka", "Tır Plaka", "Kapasite"};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialTabbed1 = new View.ViewDesign.MaterialTabbed();
        truckMain = new View.ViewDesign.CustomPanel();
        scrollPane = new javax.swing.JScrollPane();
        demandTable = new View.ViewDesign.Table();
        seachTF = new View.ViewDesign.TextField();
        truckAccount = new View.ViewDesign.CustomPanel();
        email = new View.ViewDesign.TextField();
        name = new View.ViewDesign.TextField();
        phoneNo = new View.ViewDesign.TextField();
        password = new View.ViewDesign.PasswordField();
        saveButton = new View.ViewDesign.CustomButton();
        editButton = new View.ViewDesign.CustomButton();
        phoneCode = new View.ViewDesign.Combobox();
        loginButton2 = new View.ViewDesign.CustomButton();
        jLabel1 = new javax.swing.JLabel();
        photo = new View.ViewDesign.CustomPanel();
        insertTruckPanel = new View.ViewDesign.CustomPanel();
        truckPlate = new View.ViewDesign.TextField();
        truckBrand = new View.ViewDesign.TextField();
        scrollPane1 = new javax.swing.JScrollPane();
        truckTable = new View.ViewDesign.Table();
        jLabel2 = new javax.swing.JLabel();
        TruckSaveButton = new View.ViewDesign.CustomButton();
        truckCapasity = new View.ViewDesign.Combobox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        truckPlateCode = new View.ViewDesign.Combobox();
        connectionIcon = new javax.swing.JLabel();
        welcome_name = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        materialTabbed1.setBackground(new java.awt.Color(51, 51, 51));
        materialTabbed1.setForeground(new java.awt.Color(255, 255, 255));

        truckMain.setBackground(new java.awt.Color(51, 51, 51));
        truckMain.setRoundBottomLeft(20);
        truckMain.setRoundBottomRight(20);

        scrollPane.setBackground(new java.awt.Color(51, 51, 51));

        demandTable.setBackground(new java.awt.Color(51, 51, 51));
        demandTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Tarık", "Portakal", "100", "19.05.2023", "False"},
                {"2", null, null, null, null, null},
                {"3", null, null, null, null, null},
                {"4", null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Tür", "Hacim", "Tarih", "Durum"
            }
        ));
        demandTable.setGridColor(new java.awt.Color(0, 0, 0));
        demandTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                demandTableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(demandTable);

        seachTF.setBackground(new java.awt.Color(51, 51, 51));
        seachTF.setForeground(new java.awt.Color(255, 255, 255));
        seachTF.setLabelText("Ara ...");
        seachTF.setLineColor(new java.awt.Color(255, 255, 255));
        seachTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seachTFKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout truckMainLayout = new javax.swing.GroupLayout(truckMain);
        truckMain.setLayout(truckMainLayout);
        truckMainLayout.setHorizontalGroup(
            truckMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, truckMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seachTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        truckMainLayout.setVerticalGroup(
            truckMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, truckMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seachTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        materialTabbed1.addTab("Ana Sayfa", new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_homeWhite_32.png")), truckMain); // NOI18N

        truckAccount.setBackground(new java.awt.Color(51, 51, 51));
        truckAccount.setRoundBottomLeft(20);
        truckAccount.setRoundBottomRight(20);

        email.setBackground(new java.awt.Color(51, 51, 51));
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setLabelText("Email");
        email.setLineColor(new java.awt.Color(255, 255, 255));

        name.setBackground(new java.awt.Color(51, 51, 51));
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setLabelText("Ad & Soyad");
        name.setLineColor(new java.awt.Color(255, 255, 255));

        phoneNo.setBackground(new java.awt.Color(51, 51, 51));
        phoneNo.setForeground(new java.awt.Color(255, 255, 255));
        phoneNo.setLabelText("Telefon");
        phoneNo.setLineColor(new java.awt.Color(255, 255, 255));
        phoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNoKeyTyped(evt);
            }
        });

        password.setBackground(new java.awt.Color(51, 51, 51));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setAdressEye("/WhiteIcon/eye.png");
        password.setAdressEyeHide("/WhiteIcon/hideEye.png");
        password.setLabelText("Şifre");
        password.setLineColor(new java.awt.Color(255, 255, 255));
        password.setShowAndHide(true);

        saveButton.setBackground(new java.awt.Color(51, 51, 51));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_save_16.png"))); // NOI18N
        saveButton.setActionCommand("Kaydet");
        saveButton.setAlignmentX(0.5F);
        saveButton.setBorderColor(new java.awt.Color(255, 255, 255));
        saveButton.setColor(new java.awt.Color(51, 51, 51));
        saveButton.setColorActive(new java.awt.Color(0, 0, 0));
        saveButton.setColorClick(new java.awt.Color(102, 102, 102));
        saveButton.setColorDisable(java.awt.Color.white);
        saveButton.setColorOver(new java.awt.Color(255, 255, 255));
        saveButton.setLabel("Kaydet");
        saveButton.setRadius(20);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(51, 51, 51));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_edit_16.png"))); // NOI18N
        editButton.setText("Düzenle");
        editButton.setAlignmentX(0.5F);
        editButton.setBorderColor(new java.awt.Color(255, 255, 255));
        editButton.setColor(new java.awt.Color(51, 51, 51));
        editButton.setColorActive(new java.awt.Color(0, 0, 0));
        editButton.setColorClick(new java.awt.Color(102, 102, 102));
        editButton.setColorDisable(java.awt.Color.white);
        editButton.setColorOver(new java.awt.Color(255, 255, 255));
        editButton.setRadius(20);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        phoneCode.setBackground(new java.awt.Color(51, 51, 51));
        phoneCode.setForeground(new java.awt.Color(255, 255, 255));
        phoneCode.setLabeText("Kod");
        phoneCode.setLineColor(new java.awt.Color(0, 0, 0));
        phoneCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneCodeActionPerformed(evt);
            }
        });

        loginButton2.setBackground(new java.awt.Color(51, 51, 51));
        loginButton2.setForeground(new java.awt.Color(255, 255, 255));
        loginButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_remove_16.png"))); // NOI18N
        loginButton2.setAlignmentX(0.5F);
        loginButton2.setBorderColor(new java.awt.Color(255, 255, 255));
        loginButton2.setColor(new java.awt.Color(51, 51, 51));
        loginButton2.setColorActive(new java.awt.Color(0, 0, 0));
        loginButton2.setColorClick(new java.awt.Color(102, 102, 102));
        loginButton2.setColorDisable(java.awt.Color.white);
        loginButton2.setColorOver(new java.awt.Color(255, 255, 255));
        loginButton2.setLabel("Hesabı Sil");
        loginButton2.setRadius(20);
        loginButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Şoförlük Derecesi : 4,7");

        photo.setRoundBottomLeft(500);
        photo.setRoundBottomRight(500);
        photo.setRoundTopLeft(500);
        photo.setRoundTopRight(500);

        javax.swing.GroupLayout photoLayout = new javax.swing.GroupLayout(photo);
        photo.setLayout(photoLayout);
        photoLayout.setHorizontalGroup(
            photoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        photoLayout.setVerticalGroup(
            photoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout truckAccountLayout = new javax.swing.GroupLayout(truckAccount);
        truckAccount.setLayout(truckAccountLayout);
        truckAccountLayout.setHorizontalGroup(
            truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(truckAccountLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, truckAccountLayout.createSequentialGroup()
                        .addComponent(phoneCode, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                .addGap(61, 61, 61)
                .addGroup(truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(truckAccountLayout.createSequentialGroup()
                        .addComponent(loginButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(truckAccountLayout.createSequentialGroup()
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        truckAccountLayout.setVerticalGroup(
            truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(truckAccountLayout.createSequentialGroup()
                .addGroup(truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(truckAccountLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addGroup(truckAccountLayout.createSequentialGroup()
                        .addGroup(truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(truckAccountLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(truckAccountLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(truckAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        materialTabbed1.addTab("Profil", new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_customer_32_1.png")), truckAccount); // NOI18N

        insertTruckPanel.setBackground(new java.awt.Color(51, 51, 51));
        insertTruckPanel.setForeground(new java.awt.Color(255, 255, 255));
        insertTruckPanel.setRoundBottomLeft(20);
        insertTruckPanel.setRoundBottomRight(20);

        truckPlate.setBackground(new java.awt.Color(51, 51, 51));
        truckPlate.setForeground(new java.awt.Color(255, 255, 255));
        truckPlate.setLabelText("Tır Plaka");
        truckPlate.setLineColor(new java.awt.Color(255, 255, 255));
        truckPlate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                truckPlateKeyReleased(evt);
            }
        });

        truckBrand.setBackground(new java.awt.Color(51, 51, 51));
        truckBrand.setForeground(new java.awt.Color(255, 255, 255));
        truckBrand.setLabelText("Marka");
        truckBrand.setLineColor(new java.awt.Color(255, 255, 255));
        truckBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                truckBrandKeyReleased(evt);
            }
        });

        truckTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Marka", "Tır Plaka", "Kapasite"
            }
        ));
        scrollPane1.setViewportView(truckTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mevcut Araç Tablosu");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TruckSaveButton.setBackground(new java.awt.Color(51, 51, 51));
        TruckSaveButton.setForeground(new java.awt.Color(255, 255, 255));
        TruckSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_save_16.png"))); // NOI18N
        TruckSaveButton.setActionCommand("Kaydet");
        TruckSaveButton.setAlignmentX(0.5F);
        TruckSaveButton.setBorderColor(new java.awt.Color(255, 255, 255));
        TruckSaveButton.setColor(new java.awt.Color(51, 51, 51));
        TruckSaveButton.setColorActive(new java.awt.Color(0, 0, 0));
        TruckSaveButton.setColorClick(new java.awt.Color(102, 102, 102));
        TruckSaveButton.setColorDisable(java.awt.Color.white);
        TruckSaveButton.setColorOver(new java.awt.Color(255, 255, 255));
        TruckSaveButton.setLabel("Kaydet");
        TruckSaveButton.setRadius(20);
        TruckSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TruckSaveButtonActionPerformed(evt);
            }
        });

        truckCapasity.setBackground(new java.awt.Color(51, 51, 51));
        truckCapasity.setForeground(new java.awt.Color(255, 255, 255));
        truckCapasity.setLabeText("Tır Kapasite");
        truckCapasity.setLineColor(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Yukarıdaki tabloda bulunan tırınızın üstüne mouse ile 2 kere sağ tık yaparsanız  ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("mevcut işleri görüntüleyebilirsiniz.");

        truckPlateCode.setBackground(new java.awt.Color(51, 51, 51));
        truckPlateCode.setForeground(new java.awt.Color(255, 255, 255));
        truckPlateCode.setLabeText("Kod");
        truckPlateCode.setLineColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout insertTruckPanelLayout = new javax.swing.GroupLayout(insertTruckPanel);
        insertTruckPanel.setLayout(insertTruckPanelLayout);
        insertTruckPanelLayout.setHorizontalGroup(
            insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertTruckPanelLayout.createSequentialGroup()
                .addGroup(insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertTruckPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(truckBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertTruckPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(truckCapasity, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertTruckPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(TruckSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertTruckPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(truckPlateCode, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(truckPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        insertTruckPanelLayout.setVerticalGroup(
            insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertTruckPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(insertTruckPanelLayout.createSequentialGroup()
                        .addComponent(truckBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(truckPlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(truckPlateCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(truckCapasity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(insertTruckPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(insertTruckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TruckSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Tırlar", new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_truck_32_1.png")), insertTruckPanel); // NOI18N

        connectionIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        connectionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcon/icons8_connected_16.png"))); // NOI18N

        welcome_name.setForeground(new java.awt.Color(255, 255, 255));
        welcome_name.setText("jLabel2");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcome_name, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connectionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(welcome_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Object[] lines = new Object[3];
    Object[] kolon = {"Marka", "Kapasite", "Plaka"};
    DefaultTableModel truckTableModel = new DefaultTableModel();

    void getData(int id) {
        if (truckTableModel.getRowCount() > 0) {
            for (int i = truckTableModel.getRowCount() - 1; i > -1; i--) {
                truckTableModel.removeRow(i);
            }
        }
        DBConnect connect = new DBConnect();
        String query = "{CALL get_truck(?)}";
        truckTableModel.setColumnIdentifiers(kolon);
        try {

            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            connect.ps.setInt(1, id);

            ResultSet rs = connect.ps.executeQuery();

            while (rs.next()) {
                lines[0] = rs.getString("marka");
                lines[1] = rs.getString("tir_kapasite");
                lines[2] = rs.getString("tir_plaka");
                truckTableModel.addRow(lines);
            }

        } catch (SQLException e) {
            System.out.println("Tır çekme hatası");
            e.printStackTrace();
        }
        truckTable.setModel(truckTableModel);
    }

    Object tableRow[] = new Object[6];
    Object tableColumn[] = {"Ad & Soyad", "Tür", "Ürün Kapasite", "Fiyat", "İlan Tarihi", "Talep ID"};
    DefaultTableModel demandModel = new DefaultTableModel();

    void getDataDemanTable() {
        String query = "select * from DemandTable";
        if (demandModel.getRowCount() > 0) {
            for (int i = demandModel.getRowCount() - 1; i > -1; i--) {
                demandModel.removeRow(i);
            }
        }
        DBConnect connect = new DBConnect();

        demandModel.setColumnIdentifiers(tableColumn);
        try {

            connect.ps = connect.connection.prepareStatement(query);

            ResultSet rs = connect.ps.executeQuery();

            while (rs.next()) {

                tableRow[0] = rs.getString("customer_name").toUpperCase();
                tableRow[1] = rs.getString("urun_tip");
                tableRow[2] = rs.getString("urun_kapasite");
                tableRow[3] = rs.getString("ilan_fiyat");
                tableRow[4] = rs.getString("ilan_tarih");
                tableRow[5] = rs.getInt("demand_id");
                demandModel.addRow(tableRow);

            }

        } catch (SQLException e) {
            System.out.println("Tır çekme hatası");
            e.printStackTrace();
        }
        demandTable.setModel(demandModel);
    }

    void getDemandData() {

        String query = "select * from DemandTable";

        if (demandModel.getRowCount() > 0) {
            for (int i = demandModel.getRowCount() - 1; i > -1; i--) {
                demandModel.removeRow(i);
            }
        }
        DBConnect connect = new DBConnect();

        demandModel.setColumnIdentifiers(tableColumn);
        try {

            connect.stmt = connect.connection.createStatement();
            connect.ps = connect.connection.prepareStatement(query);
            //connect.ps.setInt(1, id);

            int result;
            ResultSet rs = connect.ps.executeQuery();
            ArrayList<Integer> resultList = new ArrayList<>();

            while (rs.next()) {
                String sa = "";
                if (rs.getString("urun_kapasite").length() == 5) {
                    sa = rs.getString("urun_kapasite").substring(0, 3);
                }
                if (rs.getString("urun_kapasite").length() == 4) {
                    sa = rs.getString("urun_kapasite").substring(0, 2);
                }
                result = Integer.parseInt(sa);

                if (result <= capasityInt) {
                    tableRow[0] = rs.getString("customer_name").toUpperCase();
                    tableRow[1] = rs.getString("urun_tip");
                    tableRow[2] = rs.getString("urun_kapasite");
                    tableRow[3] = rs.getString("ilan_fiyat");
                    tableRow[4] = rs.getString("ilan_tarih");
                    tableRow[5] = rs.getInt("demand_id");
                    demandModel.addRow(tableRow);
                }

            }

        } catch (SQLException e) {
            System.out.println("Tır çekme hatası");
            e.printStackTrace();
        }
        demandTable.setModel(demandModel);

    }


    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //CustomerMainPage cmp = new CustomerMainPage();
        //cmp.setVisible(true);
        //TruckMainPage tmp = new TruckMainPage();
        //tmp.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed
    private boolean state = false;
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        if (state == false) {
            name.setEnabled(true);
            email.setEnabled(true);
            password.setEnabled(true);
            phoneNo.setEnabled(true);

            phoneCode.setEnabled(true);
            state = true;
        } else {

            name.setEnabled(false);
            email.setEnabled(false);
            password.setEnabled(false);
            phoneNo.setEnabled(false);

            phoneCode.setEnabled(false);
            state = false;
        }


    }//GEN-LAST:event_editButtonActionPerformed

    private void demandTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_demandTableMouseClicked
        if (evt.getClickCount() == 2) {
            MessageDialogTruck obj = new MessageDialogTruck(this, "Bu işe teklif etmek istiyor musnuz ?", "Bu ürün çok iyi bir şekilde ankaraya ulaştırlması gerek");
            obj.setVisible(true);
            System.out.println("Fiyat : " + obj.fiyat);
        }
    }//GEN-LAST:event_demandTableMouseClicked

    private void phoneCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneCodeActionPerformed

    private void loginButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButton2ActionPerformed

    private void phoneNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNoKeyTyped
        char c = evt.getKeyChar();
        int tLength = phoneNo.getText().length();
        if (!Character.isDigit(c) || tLength == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_phoneNoKeyTyped

    private void TruckSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TruckSaveButtonActionPerformed

    }//GEN-LAST:event_TruckSaveButtonActionPerformed

    private void truckPlateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_truckPlateKeyReleased
        int position = truckPlate.getCaretPosition();
        truckPlate.setText(truckPlate.getText().toUpperCase());
        truckPlate.setCaretPosition(position);
    }//GEN-LAST:event_truckPlateKeyReleased

    private void truckBrandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_truckBrandKeyReleased
        int position = truckBrand.getCaretPosition();
        truckBrand.setText(truckBrand.getText().toUpperCase());
        truckBrand.setCaretPosition(position);
    }//GEN-LAST:event_truckBrandKeyReleased

    private void seachTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachTFKeyReleased
        DBConnect connect = new DBConnect();
        String searchQuery = "{CALL search(?)}";
        if (demandModel.getRowCount() > 0) {
            for (int i = demandModel.getRowCount() - 1; i > -1; i--) {
                demandModel.removeRow(i);
            }
        }
        demandModel.setColumnIdentifiers(tableColumn);
        try {
            if (seachTF.getText().equals("")) {
                    getDataDemanTable();
            } else {
                connect.ps = connect.connection.prepareStatement(searchQuery);
                connect.ps.setString(1, seachTF.getText());

                ResultSet rs = connect.ps.executeQuery();

                while (rs.next()) {

                    tableRow[0] = rs.getString("customer_name").toUpperCase();
                    tableRow[1] = rs.getString("urun_tip");
                    tableRow[2] = rs.getString("urun_kapasite");
                    tableRow[3] = rs.getString("ilan_fiyat");
                    tableRow[4] = rs.getString("ilan_tarih");
                    tableRow[5] = rs.getInt("demand_id");
                    demandModel.addRow(tableRow);
                }
            }

        } catch (SQLException e) {
            System.out.println("Sonuç Döndürülmedi");
            e.printStackTrace();
        }
        demandTable.setModel(demandModel);
    }//GEN-LAST:event_seachTFKeyReleased

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
            java.util.logging.Logger.getLogger(TruckMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TruckMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TruckMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TruckMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TruckMainPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.ViewDesign.CustomButton TruckSaveButton;
    private javax.swing.JLabel connectionIcon;
    private View.ViewDesign.Table demandTable;
    private View.ViewDesign.CustomButton editButton;
    private View.ViewDesign.TextField email;
    private View.ViewDesign.CustomPanel insertTruckPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private View.ViewDesign.CustomButton loginButton2;
    private View.ViewDesign.MaterialTabbed materialTabbed1;
    private View.ViewDesign.TextField name;
    private View.ViewDesign.PasswordField password;
    private View.ViewDesign.Combobox phoneCode;
    private View.ViewDesign.TextField phoneNo;
    private View.ViewDesign.CustomPanel photo;
    private View.ViewDesign.CustomButton saveButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPane1;
    private View.ViewDesign.TextField seachTF;
    private View.ViewDesign.CustomPanel truckAccount;
    private View.ViewDesign.TextField truckBrand;
    private View.ViewDesign.Combobox truckCapasity;
    private View.ViewDesign.CustomPanel truckMain;
    private View.ViewDesign.TextField truckPlate;
    private View.ViewDesign.Combobox truckPlateCode;
    private View.ViewDesign.Table truckTable;
    private javax.swing.JLabel welcome_name;
    // End of variables declaration//GEN-END:variables
}
