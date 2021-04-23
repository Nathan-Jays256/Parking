/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inno;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Nathan Jays Clerkson
 */
public class Sign_in extends javax.swing.JFrame {
        Connection conn;
        ResultSet rs;
        PreparedStatement pst;
        String filename;
    
    public Sign_in() {
        initComponents();
        conn = javaconnect.ConnectDb();
        Compare();
        
    }
    public void message(long diff) throws AWTException{
        SystemTray tray =  SystemTray.getSystemTray();
        java.awt.Image image = Toolkit.getDefaultToolkit().createImage("Tray.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("REELEX CAR PARK");
        tray.add(trayIcon);
        trayIcon.displayMessage("Parking Sync", "Few Expiry is near by"+ diff + "" + "days", TrayIcon.MessageType.INFO);
    }
    private void Compare(){
        try{
            String sql = "select expiry from Parked";
            pst = conn.prepareStatement(sql);
            rs =pst.executeQuery();
            String ex;
            java.util.Date cdate = new java.util.Date();
            java.util.Date exDate;
            long diff = 0;
            if(rs.next()){
                ex = rs.getString("expiry");
                exDate = (java.util.Date) new SimpleDateFormat("MMM dd, yyyy").parse(ex);
                diff = exDate.getTime() - cdate.getTime();
                diff  = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                if(diff <= 7){
                    message(diff);
                }
            }
            pst.close();
            rs.close();
        
        }catch(AWTException | SQLException | ParseException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    public void logs(){
        String sql = "insert into Login(name,password)values(?,?)";
        try{
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, Name.getText());
            pst.setString(2, password.getText());
            pst.execute();
            pst.close();
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        select = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SignP = new javax.swing.JPanel();
        SignUp = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        Login = new javax.swing.JLabel();
        imgX = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        address = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/carlogosmall.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("create an account");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("FULL NAME");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("EMAIL");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("PASSWORD");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("TYPE");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("CONTACT");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 1));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 1));

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 1));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 1));

        select.setBackground(new java.awt.Color(36, 47, 65));
        select.setForeground(new java.awt.Color(255, 255, 255));
        select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", " " }));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/User_18px.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Gmail_18px.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/IP Address_18px_1.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Phone_18px_1.png"))); // NOI18N

        SignP.setBackground(new java.awt.Color(97, 212, 195));

        SignUp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SignUp.setForeground(new java.awt.Color(255, 255, 255));
        SignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignUp.setText("Sign up");
        SignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignUpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SignUpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SignUpMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout SignPLayout = new javax.swing.GroupLayout(SignP);
        SignP.setLayout(SignPLayout);
        SignPLayout.setHorizontalGroup(
            SignPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignPLayout.createSequentialGroup()
                .addComponent(SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SignPLayout.setVerticalGroup(
            SignPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Name.setBackground(new java.awt.Color(36, 47, 65));
        Name.setForeground(new java.awt.Color(204, 204, 204));
        Name.setText("Enter your Full name");
        Name.setBorder(null);
        Name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Name.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        Name.setDisabledTextColor(new java.awt.Color(36, 47, 65));
        Name.setOpaque(false);
        Name.setSelectedTextColor(new java.awt.Color(36, 47, 65));
        Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameMouseClicked(evt);
            }
        });

        email.setBackground(new java.awt.Color(36, 47, 65));
        email.setForeground(new java.awt.Color(204, 204, 204));
        email.setText("Your Email"); // NOI18N
        email.setBorder(null);
        email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        email.setOpaque(false);
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailMouseClicked(evt);
            }
        });

        contact.setBackground(new java.awt.Color(36, 47, 65));
        contact.setForeground(new java.awt.Color(204, 204, 204));
        contact.setText("Contact");
        contact.setBorder(null);
        contact.setOpaque(false);
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactMouseClicked(evt);
            }
        });

        Login.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        Login.setForeground(new java.awt.Color(153, 153, 153));
        Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login.setText("Already a member");
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginMouseExited(evt);
            }
        });

        imgX.setBackground(new java.awt.Color(0, 102, 102));
        imgX.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setText("Upload Picture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 1));

        address.setBackground(new java.awt.Color(36, 47, 65));
        address.setForeground(new java.awt.Color(204, 204, 204));
        address.setText("Provide your location ");
        address.setBorder(null);
        address.setOpaque(false);
        address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("ADDRESS");

        password.setBackground(new java.awt.Color(36, 47, 65));
        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setText("password");
        password.setBorder(null);
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imgX, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(SignP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabel11))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imgX, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(64, 64, 64)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SignP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Login)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(402, 598));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseClicked
        String sql = "insert into Signup(name,email,password,contact,address,type,imgfile)values(?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Name.getText());
            pst.setString(2, email.getText());
            pst.setString(3, password.getText());
            pst.setString(4, contact.getText());
            pst.setString(5, address.getText());
            pst.setString(6, (String)select.getSelectedItem());
            
            File imgfile = new File(filename);
            FileInputStream fis = new FileInputStream(imgfile);
            pst.setBinaryStream(7, (InputStream)fis, (int)imgfile.length());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registered Sucessfully");
            logs();
            Name.setText("");
            email.setText("");
            contact.setText("");
            contact.setText("");
            
            pst.close();
            
           
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sign Up Failed");
        }
    }//GEN-LAST:event_SignUpMouseClicked

    private void SignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseEntered
        SignP.setBackground(Color.orange);
    }//GEN-LAST:event_SignUpMouseEntered

    private void SignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseExited
        SignP.setBackground( Color.CYAN);
    }//GEN-LAST:event_SignUpMouseExited

    private void SignUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMousePressed
        SignP.setBackground(new Color(43,44,67));
    }//GEN-LAST:event_SignUpMousePressed

    private void SignUpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseReleased
        SignP.setBackground(Color.orange);
    }//GEN-LAST:event_SignUpMouseReleased

    private void emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseClicked
        email.setText("");
    }//GEN-LAST:event_emailMouseClicked

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseClicked
        setVisible(false);
        Log l = new Log();
        l.setVisible(true);
        

    }//GEN-LAST:event_LoginMouseClicked

    private void LoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseEntered
        Login.setForeground(Color.CYAN);
    }//GEN-LAST:event_LoginMouseEntered

    private void LoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseExited
        // TODO add your handling code here:[153,153,153]
        Login.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_LoginMouseExited

    private void NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseClicked
        Name.setText("");
    }//GEN-LAST:event_NameMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File file = chooser.getSelectedFile();
        filename = file.getAbsolutePath();
        
        
        BufferedImage bufferedImage = null;
        
        
        try {
            bufferedImage = ImageIO.read(new File(filename));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Image scaledImage = bufferedImage.getScaledInstance(imgX.getWidth(),imgX.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaledImage);
        imgX.setIcon(image);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressMouseClicked
        address.setText("");
    }//GEN-LAST:event_addressMouseClicked

    private void contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseClicked
        contact.setText("");
    }//GEN-LAST:event_contactMouseClicked

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        password.setText("");
    }//GEN-LAST:event_passwordMouseClicked

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
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            }
         catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JTextField Name;
    private javax.swing.JPanel SignP;
    private javax.swing.JLabel SignUp;
    private javax.swing.JTextField address;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JLabel imgX;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> select;
    // End of variables declaration//GEN-END:variables
}
