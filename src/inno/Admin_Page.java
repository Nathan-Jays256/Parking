
package inno;

import java.awt.Color;
import java.awt.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Nathan Jays Clerkson
 */
public class Admin_Page extends javax.swing.JFrame {

        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
    public Admin_Page() {
        initComponents();
        conn = javaconnect.ConnectDb();
        
        
        UpdateTable();
        getData2_space_Available();
        getData3_space_Reserved();
        //pick_picture();
   
       
        
    }
     public Admin_Page(String Use) {
        initComponents();
        conn = javaconnect.ConnectDb();
        
        UpdateTable();
        getData2_space_Available();
        getData3_space_Reserved();
        pick_picture(Use);
        
        
        User.setText(Use);
        User2.setText(Use);
        
        
    }
    private void GetUser(){/*
        try {          
               String sql = "select * from Login where name =? ";
               pst = conn.prepareStatement(sql);
               pst.setString(1, Usa.getText());
               rs = pst.executeQuery();
               if(rs.next()){
               user.setText(rs.getString(1));
               String add2 = rs.getString("name");
               User2.setText(add2);
            }                 
                }
        catch (Exception ex) {
                
            }
        finally{
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e){ }
                        
            }*/
}
    public void status(){
    try{
        String s;
        java.util.Date exDate;
        long diff = 0;
        s = ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
        exDate = (java.util.Date) new SimpleDateFormat("MMM dd, yyyy").parse(s);
        Format formatier = new SimpleDateFormat("MMM dd, yyyy");
        String ss = formatier.format(new java.util.Date());
        SimpleDateFormat myformat = new SimpleDateFormat("MMM dd, yyyy");
        java.util.Date date1 = myformat.parse(ss);
        java.util.Date date2 = myformat.parse(s);
        long diff1 = date2.getTime() - date1.getTime();
        
        System.out.println(""+TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS));
        if(diff<=2 && diff1>1){
            status.setBackground(Color.YELLOW);
            status.setText("Expiry is Near");
        }else if(diff<=1){
            status.setBackground(Color.RED);
            status.setText("Expired");
        }
        else{
            status.setBackground(Color.GREEN);
            status.setText("Active");
        }
    }
    catch(Exception e){JOptionPane.showMessageDialog(null, e);} 
    finally{
        try{
            rs.close();
            pst.close();
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e);} 
    }
    }
    public void UpdateData1(){
        try{
            String s = PT4.getText();
            String ss = PT5.getText();
            String sql = "update lap set status='"+str+"' where lapno ='"+s+"' and trackno = '"+ss+"'";
            pst= conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    }
    public void UpdateTable(){
        try{
            String sql = "select plate as PLATE,name as Name,issue as Park_Date,expiry as Release_Date from Parked order by Name";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        finally{
            try{
                rs.close();
                pst.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }}
        
    }
    
    private void getData2_space_Available(){
        String str = "Available";
        try{
            String sql = "select count(status) from Lap where status = '"+str+"' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String sum = rs.getString("count(status)");
                avail.setText(sum);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
                pst.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    }
    private void getData3_space_Reserved(){
                String str = "Reserved";
        try{
            String sql = "select count(status) from Lap where status = '"+str+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String sum = rs.getString("count(status)");
                reserved.setText(sum);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
                pst.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void pick_picture(String Use){
        try{
            String a = Use;
            String sql = "select * from Signup where name='"+a+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                //Retreiving the Image back to the user
                byte[] add = rs.getBytes("imgfile");
                Image image = getToolkit().createImage(add);
                Image img = image.getScaledInstance(98,70,Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                Pic.setIcon(icon);
                rs.close();
                pst.close();

            }
            

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        BigSidePage = new javax.swing.JPanel();
        TopBar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        User2 = new javax.swing.JTextField();
        MidPage = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();
        P2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PT4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        PT1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        PT5 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        PT3 = new javax.swing.JTextField();
        PT2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Release_park = new javax.swing.JButton();
        status = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        BT6 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        BT8 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        BT1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        BT10 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        P3 = new javax.swing.JPanel();
        Welcome = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        avail = new javax.swing.JTextField();
        reserved = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        P4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Receipts = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Terms = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        terms = new javax.swing.JButton();
        GenerateReceipt = new javax.swing.JButton();
        Report = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        P5 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        ReleaseSearch = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        BT5 = new javax.swing.JTextField();
        BT3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        BT4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BT2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        LeftSmallpage = new javax.swing.JPanel();
        icons = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ActionsP = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        moto = new javax.swing.JLabel();
        Release = new javax.swing.JPanel();
        B2 = new javax.swing.JLabel();
        Space = new javax.swing.JPanel();
        B3 = new javax.swing.JLabel();
        Reports = new javax.swing.JPanel();
        B4 = new javax.swing.JLabel();
        Logout = new javax.swing.JPanel();
        B5 = new javax.swing.JLabel();
        Pic = new javax.swing.JLabel();
        User = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BigSidePage.setBackground(new java.awt.Color(204, 204, 255));

        TopBar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Search_25px.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(255, 102, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 1));

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/User_18px.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        User2.setEditable(false);
        User2.setBackground(new java.awt.Color(255, 255, 255));
        User2.setFont(new java.awt.Font("CenturyRepriseBlackSSi", 0, 12)); // NOI18N
        User2.setForeground(new java.awt.Color(255, 102, 0));
        User2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        User2.setBorder(null);
        User2.setOpaque(false);

        javax.swing.GroupLayout TopBarLayout = new javax.swing.GroupLayout(TopBar);
        TopBar.setLayout(TopBarLayout);
        TopBarLayout.setHorizontalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopBarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopBarLayout.createSequentialGroup()
                        .addComponent(User2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel11)
                .addGap(25, 25, 25))
        );
        TopBarLayout.setVerticalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopBarLayout.createSequentialGroup()
                        .addGroup(TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(User2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TopBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)))
                .addContainerGap())
        );

        MidPage.setBackground(new java.awt.Color(204, 204, 204));
        MidPage.setPreferredSize(new java.awt.Dimension(770, 110));
        MidPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Channel", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Reelex car Park");
        MidPage.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 244, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/cc.png"))); // NOI18N
        MidPage.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 270, 110));

        jLabel2.setFont(new java.awt.Font("Channel", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Admin Page");
        MidPage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 180, 40));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 102, 0));
        jLabel37.setText("\"security Parking and safe handling over the day and night\" ");
        MidPage.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        Content.setLayout(new java.awt.CardLayout());

        P2.setBackground(new java.awt.Color(51, 0, 51));
        P2.setPreferredSize(new java.awt.Dimension(770, 500));

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)), "Park Your Car", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        PT4.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Parking Issue");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Brand");

        jRadioButton2.setBackground(new java.awt.Color(51, 0, 51));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Male");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Lap No.");

        jRadioButton1.setBackground(new java.awt.Color(51, 0, 51));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Female");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Car Plate");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Full Name");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Position");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------Select-------", "Toyota", "Ferrari", "Mustang", "Spacio", "Vitz", "Mark-X", "V8", "V6", "Poshe", "Lambo", "None of the Above", " " }));

        PT5.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Parking Expiry");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Track No.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PT1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addComponent(PT2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PT5)
                    .addComponent(PT4)
                    .addComponent(PT3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(PT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(PT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(PT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(PT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(PT5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Table.setBackground(new java.awt.Color(51, 0, 51));
        Table.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0), new java.awt.Color(153, 153, 0)));
        Table.setForeground(new java.awt.Color(255, 255, 255));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table.setGridColor(new java.awt.Color(0, 51, 51));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Table);

        Release_park.setBackground(new java.awt.Color(0, 153, 153));
        Release_park.setText("Release");
        Release_park.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Release_parkActionPerformed(evt);
            }
        });

        status.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel46.setBackground(new java.awt.Color(51, 0, 0));
        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Status");
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        BT6.setEditable(false);

        jLabel36.setBackground(new java.awt.Color(51, 0, 0));
        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Bill");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        BT8.setEditable(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Days Spent");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("No. Plate");

        BT1.setEditable(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 51, 0));
        jLabel50.setText("Note: $10 Per day");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Fee ");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Full Name");

        javax.swing.GroupLayout P2Layout = new javax.swing.GroupLayout(P2);
        P2.setLayout(P2Layout);
        P2Layout.setHorizontalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                                .addComponent(Release_park, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(290, 290, 290))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(P2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(P2Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(274, 274, 274))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                .addContainerGap(516, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(P2Layout.createSequentialGroup()
                .addGap(437, 437, 437)
                .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT1)
                    .addComponent(BT6, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(BT8)
                    .addComponent(BT10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        P2Layout.setVerticalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(BT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(BT10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(BT8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BT6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Release_park)
                .addGap(41, 41, 41))
        );

        Content.add(P2, "card2");

        P3.setBackground(new java.awt.Color(51, 51, 0));
        P3.setPreferredSize(new java.awt.Dimension(770, 518));

        Welcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Welcome.setForeground(new java.awt.Color(204, 51, 0));
        Welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Welcome.setText("Welcome to Reelex Car Park");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 153, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Parking Availability");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 153, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Reserved");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 255, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Available");

        javax.swing.GroupLayout P3Layout = new javax.swing.GroupLayout(P3);
        P3.setLayout(P3Layout);
        P3Layout.setHorizontalGroup(
            P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3Layout.createSequentialGroup()
                .addGroup(P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P3Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(P3Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(P3Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(avail, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(reserved, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(171, 171, 171))
        );
        P3Layout.setVerticalGroup(
            P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(Welcome)
                .addGap(45, 45, 45)
                .addComponent(jLabel28)
                .addGroup(P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P3Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(P3Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(33, 33, 33)
                                .addComponent(avail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31)
                                .addGroup(P3Layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(reserved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(P3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel27)))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        Content.add(P3, "card4");

        P4.setBackground(new java.awt.Color(0, 102, 102));
        P4.setPreferredSize(new java.awt.Dimension(770, 450));

        Receipts.setBackground(new java.awt.Color(204, 204, 204));
        Receipts.setColumns(20);
        Receipts.setLineWrap(true);
        Receipts.setRows(5);
        Receipts.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 0)));
        jScrollPane1.setViewportView(Receipts);

        Terms.setEditable(false);
        Terms.setBackground(new java.awt.Color(0, 102, 102));
        Terms.setColumns(20);
        Terms.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Terms.setForeground(new java.awt.Color(204, 204, 204));
        Terms.setLineWrap(true);
        Terms.setRows(5);
        Terms.setBorder(null);
        Terms.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(Terms);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Reports");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Terms and Condtions");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Receipt");

        terms.setBackground(new java.awt.Color(0, 153, 153));
        terms.setText(" Read terms");
        terms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termsActionPerformed(evt);
            }
        });

        GenerateReceipt.setBackground(new java.awt.Color(0, 153, 153));
        GenerateReceipt.setText("Generate Receipt");
        GenerateReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateReceiptActionPerformed(evt);
            }
        });

        Report.setBackground(new java.awt.Color(0, 153, 153));
        Report.setText("Report");
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(0, 102, 102));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("I agree to the Terms & Conditions");
        jCheckBox1.setBorder(null);
        jCheckBox1.setIconTextGap(2);

        javax.swing.GroupLayout P4Layout = new javax.swing.GroupLayout(P4);
        P4.setLayout(P4Layout);
        P4Layout.setHorizontalGroup(
            P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P4Layout.createSequentialGroup()
                .addGroup(P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P4Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(289, 289, 289))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                        .addComponent(terms)
                        .addGap(115, 115, 115)
                        .addComponent(Report)
                        .addGap(105, 105, 105)
                        .addComponent(GenerateReceipt)
                        .addGap(128, 128, 128))))
        );
        P4Layout.setVerticalGroup(
            P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terms)
                    .addComponent(GenerateReceipt)
                    .addComponent(Report))
                .addGap(36, 36, 36))
        );

        Content.add(P4, "card5");

        P5.setBackground(new java.awt.Color(0, 51, 51));
        P5.setPreferredSize(new java.awt.Dimension(770, 450));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Search");

        ReleaseSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ReleaseSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ReleaseSearchKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Take your Car");

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "BILL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 102, 0))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Fee ");

        BT5.setEditable(false);

        BT3.setEditable(false);

        jLabel22.setBackground(new java.awt.Color(51, 0, 0));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Bill");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        BT4.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Full Name");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Days Spent");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("No. Plate");

        BT2.setEditable(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 0));
        jLabel25.setText("Note: $10 Per day");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BT2)
                        .addComponent(BT3)
                        .addComponent(BT4)
                        .addComponent(BT5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel22)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(BT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(BT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(BT5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 51, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Search for your Number Plate");

        javax.swing.GroupLayout P5Layout = new javax.swing.GroupLayout(P5);
        P5.setLayout(P5Layout);
        P5Layout.setHorizontalGroup(
            P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P5Layout.createSequentialGroup()
                .addGroup(P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P5Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addGroup(P5Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(ReleaseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P5Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        P5Layout.setVerticalGroup(
            P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReleaseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Content.add(P5, "card5");

        javax.swing.GroupLayout BigSidePageLayout = new javax.swing.GroupLayout(BigSidePage);
        BigSidePage.setLayout(BigSidePageLayout);
        BigSidePageLayout.setHorizontalGroup(
            BigSidePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MidPage, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
            .addGroup(BigSidePageLayout.createSequentialGroup()
                .addGroup(BigSidePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TopBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BigSidePageLayout.setVerticalGroup(
            BigSidePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BigSidePageLayout.createSequentialGroup()
                .addComponent(TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MidPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 531, Short.MAX_VALUE))
        );

        LeftSmallpage.setBackground(new java.awt.Color(0, 18, 50));
        LeftSmallpage.setMaximumSize(new java.awt.Dimension(26, 250));

        icons.setBackground(new java.awt.Color(0, 18, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Plus_16px.png"))); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Menu_16px.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Upload_16px.png"))); // NOI18N

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Download_16px.png"))); // NOI18N

        javax.swing.GroupLayout iconsLayout = new javax.swing.GroupLayout(icons);
        icons.setLayout(iconsLayout);
        iconsLayout.setHorizontalGroup(
            iconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(iconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        iconsLayout.setVerticalGroup(
            iconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout LeftSmallpageLayout = new javax.swing.GroupLayout(LeftSmallpage);
        LeftSmallpage.setLayout(LeftSmallpageLayout);
        LeftSmallpageLayout.setHorizontalGroup(
            LeftSmallpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftSmallpageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        LeftSmallpageLayout.setVerticalGroup(
            LeftSmallpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftSmallpageLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(icons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ActionsP.setBackground(new java.awt.Color(36, 47, 65));
        ActionsP.setPreferredSize(new java.awt.Dimension(135, 350));

        Logo.setFont(new java.awt.Font("Channel", 0, 24)); // NOI18N
        Logo.setForeground(new java.awt.Color(0, 102, 102));
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/carlogosmalls.png"))); // NOI18N

        moto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        moto.setForeground(new java.awt.Color(255, 102, 0));
        moto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moto.setText("\" Park Best \"");

        Release.setBackground(new java.awt.Color(0, 128, 145));

        B2.setFont(new java.awt.Font("DIN", 0, 14)); // NOI18N
        B2.setForeground(new java.awt.Color(255, 255, 255));
        B2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Car Rental_16px_1.png"))); // NOI18N
        B2.setText("Release");
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                B2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout ReleaseLayout = new javax.swing.GroupLayout(Release);
        Release.setLayout(ReleaseLayout);
        ReleaseLayout.setHorizontalGroup(
            ReleaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReleaseLayout.setVerticalGroup(
            ReleaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        Space.setBackground(new java.awt.Color(0, 128, 145));

        B3.setFont(new java.awt.Font("DIN", 0, 14)); // NOI18N
        B3.setForeground(new java.awt.Color(255, 255, 255));
        B3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Car_16px_1.png"))); // NOI18N
        B3.setText("Space");
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                B3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout SpaceLayout = new javax.swing.GroupLayout(Space);
        Space.setLayout(SpaceLayout);
        SpaceLayout.setHorizontalGroup(
            SpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SpaceLayout.setVerticalGroup(
            SpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        Reports.setBackground(new java.awt.Color(0, 128, 145));

        B4.setFont(new java.awt.Font("DIN", 0, 14)); // NOI18N
        B4.setForeground(new java.awt.Color(255, 255, 255));
        B4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Google News_16px.png"))); // NOI18N
        B4.setText("Reports");
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                B4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout ReportsLayout = new javax.swing.GroupLayout(Reports);
        Reports.setLayout(ReportsLayout);
        ReportsLayout.setHorizontalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReportsLayout.setVerticalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        Logout.setBackground(new java.awt.Color(0, 128, 145));

        B5.setBackground(new java.awt.Color(240, 240, 230));
        B5.setFont(new java.awt.Font("DIN", 0, 14)); // NOI18N
        B5.setForeground(new java.awt.Color(255, 255, 255));
        B5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im/Logout Rounded_16px_1.png"))); // NOI18N
        B5.setText("Logout");
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                B5MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout);
        Logout.setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(B5, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        Pic.setBackground(new java.awt.Color(0, 102, 102));
        Pic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));

        User.setEditable(false);
        User.setBackground(new java.awt.Color(255, 255, 255));
        User.setFont(new java.awt.Font("CenturyRepriseBlackSSi", 0, 12)); // NOI18N
        User.setForeground(new java.awt.Color(255, 102, 0));
        User.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        User.setText("user");
        User.setBorder(null);
        User.setOpaque(false);

        javax.swing.GroupLayout ActionsPLayout = new javax.swing.GroupLayout(ActionsP);
        ActionsP.setLayout(ActionsPLayout);
        ActionsPLayout.setHorizontalGroup(
            ActionsPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionsPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ActionsPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ActionsPLayout.createSequentialGroup()
                        .addComponent(Pic, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ActionsPLayout.createSequentialGroup()
                        .addGroup(ActionsPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ActionsPLayout.createSequentialGroup()
                                .addGroup(ActionsPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Logo)
                                    .addGroup(ActionsPLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(moto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Reports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Space, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Release, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(ActionsPLayout.createSequentialGroup()
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        ActionsPLayout.setVerticalGroup(
            ActionsPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionsPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(moto)
                .addGap(18, 18, 18)
                .addComponent(Pic, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(Release, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Space, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Reports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LeftSmallpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ActionsP, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BigSidePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BigSidePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ActionsP, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
            .addComponent(LeftSmallpage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(977, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void B2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseEntered
        Release.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B2MouseEntered

    private void B2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseExited
         Release.setBackground(new Color(0,128,145));
    }//GEN-LAST:event_B2MouseExited

    private void B2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MousePressed
         Release.setBackground(new Color(43,44,67));
    }//GEN-LAST:event_B2MousePressed

    private void B2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseReleased
          Release.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B2MouseReleased

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
        if(evt.getSource()== B2){
            
            P2.setVisible(true);
            P3.setVisible(false);
            P4.setVisible(false);
        }
    }//GEN-LAST:event_B2MouseClicked

    private void B3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseEntered
        Space.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B3MouseEntered

    private void B3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseExited
        Space.setBackground(new Color(0,128,145));
    }//GEN-LAST:event_B3MouseExited

    private void B3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MousePressed
        Space.setBackground(new Color(43,44,67));
    }//GEN-LAST:event_B3MousePressed

    private void B3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseReleased
        Space.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B3MouseReleased

    private void B4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseEntered
       Reports.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B4MouseEntered

    private void B4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseExited
        Reports.setBackground(new Color(0,128,145));
    }//GEN-LAST:event_B4MouseExited

    private void B4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MousePressed
        Reports.setBackground(new Color(43,44,67));
    }//GEN-LAST:event_B4MousePressed

    private void B4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseReleased
        Reports.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B4MouseReleased

    private void B4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseClicked
        if(evt.getSource()== B4){
            
            P2.setVisible(false);
            P3.setVisible(false);
            P4.setVisible(true);
        }
    }//GEN-LAST:event_B4MouseClicked

    private void B5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseEntered
        Logout.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B5MouseEntered

    private void B5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseExited
         Logout.setBackground(new Color(0,128,145));
    }//GEN-LAST:event_B5MouseExited

    private void B5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MousePressed
         Logout.setBackground(new Color(43,44,67));
    }//GEN-LAST:event_B5MousePressed

    private void B5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseReleased
        Logout.setBackground(new Color(246,89,102));
    }//GEN-LAST:event_B5MouseReleased

    private void B5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseClicked
        setVisible(false);
        Log l = new Log();
        l.setVisible(true);
    }//GEN-LAST:event_B5MouseClicked
    public void clear(){
        ReleaseSearch.setText("");
        status.setText("");
        BT5.setText("");
        BT2.setText("");
        BT3.setText("");
        BT4.setText("");
        PT1.setText("");
        PT2.setText("");
        PT3.setText("");
        PT4.setText("");
        PT5.setText("");
        ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText("");
        ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).setText("");
    }    public void rel(){
            JOptionPane.showMessageDialog(null, "Please Select the Brand");
            try{
            String sql ="insert into Released(plate,name,gender,position,brand,issue,expiry,lapno,trackno) values (?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, PT1.getText());
            pst.setString(2, PT2.getText());
            jRadioButton1.setActionCommand("Female");
            jRadioButton2.setActionCommand("Male");
            pst.setString(3, buttonGroup1.getSelection().getActionCommand());
            pst.setString(4, PT3.getText());
            pst.setString(5, (String)jComboBox1.getSelectedItem());
            pst.setString(6, ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
            pst.setString(7, ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
            pst.setString(8, PT4.getText());
            pst.setString(9, PT5.getText());
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,"Error occured while parking");}
    } 
    public void price(){
            JTextField t1 = new JTextField();
            JTextField t2 = new JTextField();
            String a1 = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
            Format formatter  = new SimpleDateFormat("MMM dd, yyyy");
            String s = formatter.format(new java.util.Date());
            SimpleDateFormat myformat = new SimpleDateFormat("MMM dd, yyyy");
            try{
                java.util.Date date1 = myformat.parse(a1);
                java.util.Date date2 = myformat.parse(s);
                long diff = date2.getTime() - date1.getTime();
                t1.setText("" + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                String aw = t1.getText();
                int a5 = Integer.parseInt(aw);
                int tot = a5 * 5;
                String at = Integer.toString(tot);
                try{
                    String plate = PT1.getText();
                    String sql = "update Released set totalday='"+aw+"', paid ='"+at+"' where plate='"+plate+"'";
                    pst=conn.prepareStatement(sql);
                    pst.executeUpdate();
                    pst.close();
                }catch(Exception e){}
            }
            catch(ParseException e){
                e.printStackTrace();
            }

    }
    private void Release_parkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Release_parkActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are You sure", "Release", JOptionPane.YES_NO_OPTION);
        if(p==0){
            String sql ="delete from Parked where plate=?";
            try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, PT1.getText());
                pst.execute();
                rel();
                UpdateData1();
                price();
                UpdateTable();
                
                
                JOptionPane.showMessageDialog(null, "Car Released");
                
            }
            catch(Exception e ){
                JOptionPane.showMessageDialog(null, "Error occured while Releasing"+e.getMessage());
            }
            finally{
                  try{
            String sql2 ="select * from Released where plate=?";
            pst = conn.prepareStatement(sql2);
            pst.setString(1, PT1.getText());
            rs=pst.executeQuery();
            //clear();
            if(rs.next()){
                String add2 = rs.getString("name");
                BT10.setText(add2);
                String add3 = rs.getString("totalday");
                BT8.setText(add3);
                String add4 = rs.getString("paid");
                BT6.setText("$"+add4);
                //clear();
                
            }
            rs.close();
            pst.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error occured while Billing");
        }
            }
        }
    }//GEN-LAST:event_Release_parkActionPerformed

    private void B3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseClicked
        if(evt.getSource()== B3){
            P2.setVisible(false);
            P3.setVisible(true);
            P4.setVisible(false);
        }
    }//GEN-LAST:event_B3MouseClicked

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();
        String Table_Click = (Table.getModel().getValueAt(row, 0).toString());
           
        try{
            String sql = "select * from Parked where plate='"+Table_Click+"'";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("plate");
                PT1.setText(add1);
                BT1.setText(add1);
                String add2 = rs.getString("name");
                PT2.setText(add2);
                BT10.setText(add2);

                String add3 = rs.getString("gender");
                if(add3.endsWith("Female")){
                    jRadioButton1.setSelected(true);
                }else{jRadioButton2.setSelected(true);
                }

                String add4 = rs.getString("position");
                PT3.setText(add4);
                String add5 = rs.getString("issue");
                ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText(add5);

                String add6 = rs.getString("expiry");
                ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).setText(add6);
                String add7 = rs.getString("lapno");
                PT4.setText(add7);
                String add8 = rs.getString("trackno");
                PT5.setText(add8);
                status();
                
                }
            pst.close();
            rs.close();
           
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
        
                //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
             
                
                
            
        
    }//GEN-LAST:event_TableMouseClicked
public void clear_all(){
        ReleaseSearch.setText("");
        status.setText("");
        BT1.setText("");
        BT10.setText("");
        BT8.setText("");
        BT6.setText("");
        PT1.setText("");
        PT2.setText("");
        PT3.setText("");
        PT4.setText("");
        PT5.setText("");
        ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText("");
        ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).setText("");

}
    private void GenerateReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateReceiptActionPerformed
         int refs = 1325 + (int)(Math.random()+4238);
         Calendar timer = Calendar.getInstance();
         timer.getTime();
        SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
        tTime.format(timer.getTime());
        SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
        Tdate.format(timer.getTime());
        Receipts.append("     RELEEX CAR PARK: \n" + 
                "\n=============================\n" +
                "Reference\t" + refs +"\n"+ 
            
           "\nDays Spent:\t" + BT8.getText() + "\n" + 
           "Total Pay:\t" + BT6.getText() + "\n" +
           "\n=============================="+ "\n" +
            
           "\nDate: " + Tdate.format(timer.getTime()) +
           "\nTime: " + tTime.format(timer.getTime()) + 
           "\n\nTHANK YOU" +
           "\nGOD BLESS YOU");
        
        
    }//GEN-LAST:event_GenerateReceiptActionPerformed

    private void ReleaseSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReleaseSearchKeyReleased
      
    }//GEN-LAST:event_ReleaseSearchKeyReleased

    private void ReleaseSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReleaseSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ReleaseSearchKeyTyped

    private void termsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termsActionPerformed
            Terms.append("                   RELEEX CAR PARK (U) LTD\n"+
                    "THis is alegal Agreement between you\n"
                    + " (Either an individual or Entity)\n"
                    + " and NJC Designs INC., A limited liability Enterprise,\n"
                    + "and its subsidiaries and affiliates(NJC)."
                    + "  This Agreement is \n"
                    + "Governed by the Internal Substantive\n"
                    + " Laws of the Republic of Uganda.(And not by the 1980\n"
                    + " UN convention on contracts for the international\n "
                    + "sale of Goods, as amended)."
                    + "By installing or Using the \n"
                    + "Software,\n"
                    + " You agree to be Bound by the Terms of this Agreement\n."
                    + "If you do not Agree to the terms of this Agreement,\n "
                    + "Remove the Product from your Hard Drive and Permanently\n"
                    + " Erase all Copies of the Product.\n"
                    + " IF YOU ARE THE ORIGINAL\n"
                    + " Installer of the Software you may Prompt after Purchase\n"
                    + " Return the Software(INCLUDING PRINTED MATERIALS)\n "
                    + "With proof of Purchase to the place where"
                    + "It was Purchased for a full Refund of the Amount.\n "
                    
                    );
    }//GEN-LAST:event_termsActionPerformed

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
        MessageFormat head= new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page(0,number,integer)");
        try{
            Table.print(JTable.PrintMode.NORMAL,head,footer);
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_ReportActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ActionsP;
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B3;
    private javax.swing.JLabel B4;
    private javax.swing.JLabel B5;
    private javax.swing.JTextField BT1;
    private javax.swing.JTextField BT10;
    private javax.swing.JTextField BT2;
    private javax.swing.JTextField BT3;
    private javax.swing.JTextField BT4;
    private javax.swing.JTextField BT5;
    private javax.swing.JTextField BT6;
    private javax.swing.JTextField BT8;
    private javax.swing.JPanel BigSidePage;
    private javax.swing.JPanel Content;
    private javax.swing.JButton GenerateReceipt;
    private javax.swing.JPanel LeftSmallpage;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Logout;
    private javax.swing.JPanel MidPage;
    private javax.swing.JPanel P2;
    private javax.swing.JPanel P3;
    private javax.swing.JPanel P4;
    private javax.swing.JPanel P5;
    private javax.swing.JTextField PT1;
    private javax.swing.JTextField PT2;
    private javax.swing.JTextField PT3;
    private javax.swing.JTextField PT4;
    private javax.swing.JTextField PT5;
    private javax.swing.JLabel Pic;
    private javax.swing.JTextArea Receipts;
    private javax.swing.JPanel Release;
    private javax.swing.JTextField ReleaseSearch;
    private javax.swing.JButton Release_park;
    private javax.swing.JButton Report;
    private javax.swing.JPanel Reports;
    private javax.swing.JPanel Space;
    private javax.swing.JTable Table;
    private javax.swing.JTextArea Terms;
    private javax.swing.JPanel TopBar;
    private javax.swing.JTextField User;
    private javax.swing.JTextField User2;
    private javax.swing.JLabel Welcome;
    private javax.swing.JTextField avail;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel icons;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel moto;
    private javax.swing.JTextField reserved;
    private javax.swing.JTextField status;
    private javax.swing.JButton terms;
    // End of variables declaration//GEN-END:variables
String str = "Available";
String str1 = "Reserved";
}

