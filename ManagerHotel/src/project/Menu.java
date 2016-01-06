/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Đứcc
 */
public class Menu extends javax.swing.JFrame implements UndoableEditListener{

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        txaNote.getDocument().addUndoableEditListener(manager);
    }
    DateFormat dateformat = new SimpleDateFormat("HH:mm");
    Calendar cal = Calendar.getInstance();
    String currenttime = dateformat.format(cal.getTime());
    public void showTable(String Code){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagement";
            Connection con = DriverManager.getConnection(connectionString, "taobivocam9x", "duc12345");
            PreparedStatement ps = con.prepareStatement(Code);
            ps.execute();
            ps.close();
            con.close();
        }catch(ClassNotFoundException e){
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
        }
    }
    public void addInformation(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagement";
            Connection con = DriverManager.getConnection(connectionString, "taobivocam9x", "duc12345");
            String strName = txtName.getText();
            String strGender = (String)cbGender.getSelectedItem();
            String strNational = txtNationality.getText();
            String strDate = (String)cbDay.getSelectedItem();
            String strMonth = (String)cbMonth.getSelectedItem();
            String strYears = (String)cbYear.getSelectedItem();
            String strDateOfBirth = strYears+"-"+strMonth+"-"+strDate;
            String strPlaceOfBirth = txtPlaceOfBirth.getText();
            String strAddress = txaAddress.getText();
            int PhoneNumber = Integer.parseInt(txfPhone.getText());
            String strEmail = txtEmail.getText();
            int strCMND = Integer.parseInt(txfCMND.getText());
            String strIssuedBy = txtIssuedBy.getText();
            String strNote = txaNote.getText();
            PreparedStatement ps = con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1, strName);
            ps.setString(2, strGender);
            ps.setString(3, strNational);
            ps.setString(4, strDateOfBirth);
            ps.setString(5, strPlaceOfBirth);
            ps.setString(6, strAddress);
            ps.setInt(7, PhoneNumber);
            ps.setString(8, strEmail);
            ps.setInt(9, strCMND);
            ps.setString(10, strIssuedBy);
            ps.setString(11, strNote);
            ps.execute();
            ps.close();
            con.close();
        }catch(ClassNotFoundException e){
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void addCheckIn(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagement";
            Connection con = DriverManager.getConnection(connectionString, "taobivocam9x", "duc12345");
            String strName = txtName.getText();
            String strCheckIn = txfDayBook.getText();
            String strDateArrived = txfDayArrived.getText();
            String strHoursArrived = txtHours.getText();
            String strCheckOut = txfCheckOut.getText();
            int Adult = Integer.parseInt(txfAdult.getText());
            int Child = Integer.parseInt(txfChild.getText());
            int RoomNumber = Integer.parseInt(txfRoomNumber.getText());
            float deposit = Float.parseFloat(txfDeposit.getText());
            String request = txaRequest.getText();
            PreparedStatement ps = con.prepareStatement("insert into CheckIn values(?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1, strName);
            ps.setString(2, strCheckIn);
            ps.setString(3, strDateArrived);
            ps.setString(4, strHoursArrived);
            ps.setString(5, strCheckOut);
            ps.setInt(6, Adult);
            ps.setInt(7, Child);
            ps.setInt(8, RoomNumber);
            ps.setFloat(9, deposit);
            ps.setString(10, request);
            ps.execute();
            ps.close();
            con.close();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }

    /**
     *
     */

    UndoManager manager = new UndoManager();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCheckIn = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pnRequest2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaRequest = new javax.swing.JTextArea();
        txfDayBook = new javax.swing.JFormattedTextField();
        txfDayArrived = new javax.swing.JFormattedTextField();
        txtHours = new javax.swing.JTextField();
        txfCheckOut = new javax.swing.JFormattedTextField();
        txfChild = new javax.swing.JFormattedTextField();
        txfAdult = new javax.swing.JFormattedTextField();
        txfRoomNumber = new javax.swing.JFormattedTextField();
        txfDeposit = new javax.swing.JFormattedTextField();
        btnOk = new javax.swing.JButton();
        dialogSetting = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        tbAdmin = new javax.swing.JToggleButton();
        tbUndo = new javax.swing.JToggleButton();
        tbRedo = new javax.swing.JToggleButton();
        tbSetting = new javax.swing.JToggleButton();
        tbSearch = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        btnOk1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        pnInformations = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaNote = new javax.swing.JTextArea();
        lblGender = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        lblPlaceOfBirth = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCMND = new javax.swing.JLabel();
        lblIssuedBy = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cbGender = new javax.swing.JComboBox();
        cbYear = new javax.swing.JComboBox();
        txtPlaceOfBirth = new javax.swing.JTextField();
        lblNationality = new javax.swing.JLabel();
        txtNationality = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        txfPhone = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        txfCMND = new javax.swing.JFormattedTextField();
        txtIssuedBy = new javax.swing.JTextField();
        lblWarnName = new javax.swing.JLabel();
        lblDateOfBirthWarning = new javax.swing.JLabel();
        lblPhoneWarning = new javax.swing.JLabel();
        lblIDWarning = new javax.swing.JLabel();
        lblPassport = new javax.swing.JLabel();
        cbDay = new javax.swing.JComboBox();
        cbMonth = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmHethong = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmDanhmuc = new javax.swing.JMenu();

        dialogCheckIn.setTitle("Đặt phòng");
        dialogCheckIn.setMinimumSize(new java.awt.Dimension(400, 550));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Đặt phòng"));
        jPanel4.setMaximumSize(new java.awt.Dimension(450, 550));
        jPanel4.setMinimumSize(new java.awt.Dimension(450, 550));
        jPanel4.setPreferredSize(new java.awt.Dimension(450, 550));
        jPanel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel19.setText("Ngày Đặt");

        jLabel20.setText("Ngày Đến");

        jLabel21.setText("Giờ Đến");

        jLabel22.setText("Ngày Đi");

        jLabel23.setText("Người Lớn");

        jLabel24.setText("Trẻ Em");

        jLabel25.setText("Số Phòng");

        jLabel26.setText("Đưa trước");

        pnRequest2.setBackground(new java.awt.Color(255, 255, 255));
        pnRequest2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Yêu Cầu Của Khách Hàng"));
        pnRequest2.setLayout(new java.awt.BorderLayout());

        txaRequest.setColumns(20);
        txaRequest.setRows(5);
        jScrollPane6.setViewportView(txaRequest);

        pnRequest2.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        try{
            txfDayBook = new JFormattedTextField(new MaskFormatter("####-##-##"));
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }

        try{
            txfDayArrived = new JFormattedTextField(new MaskFormatter("####-##-##"));
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }

        try{
            txfCheckOut = new JFormattedTextField(new MaskFormatter("####-##-##"));
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }

        try{
            txfRoomNumber = new JFormattedTextField(new MaskFormatter("###"));
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }

        try{
            txfDeposit = new JFormattedTextField(new MaskFormatter("###.###"));
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnRequest2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txfDeposit, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfRoomNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(txfAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel24)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txfChild, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txfCheckOut)
                                    .addComponent(txfDayBook)
                                    .addComponent(txfDayArrived)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnOk)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txfDayBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txfDayArrived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txfCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txfAdult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txfChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txfRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txfDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogCheckIn.getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.setMaximumSize(new java.awt.Dimension(450, 550));
        jPanel2.setMinimumSize(new java.awt.Dimension(450, 550));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vietnamese", "English", "Italy" }));

        jLabel1.setText("Language");

        jLabel2.setText("Full screen");

        btnSave.setText("Save");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(93, 93, 93))
        );

        dialogSetting.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Khách Sạn");

        jToolBar1.setRollover(true);

        tbAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/tải xuống.jpe"))); // NOI18N
        tbAdmin.setFocusable(false);
        tbAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAdminActionPerformed(evt);
            }
        });
        jToolBar1.add(tbAdmin);

        tbUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/undo.png"))); // NOI18N
        tbUndo.setFocusable(false);
        tbUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbUndoActionPerformed(evt);
            }
        });
        jToolBar1.add(tbUndo);

        tbRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/redo.png"))); // NOI18N
        tbRedo.setFocusable(false);
        tbRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbRedoActionPerformed(evt);
            }
        });
        jToolBar1.add(tbRedo);

        tbSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images (2).jpe"))); // NOI18N
        tbSetting.setFocusable(false);
        tbSetting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbSetting.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSettingActionPerformed(evt);
            }
        });
        jToolBar1.add(tbSetting);

        tbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/searchicon.png"))); // NOI18N
        tbSearch.setFocusable(false);
        tbSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(tbSearch);

        jPanel1.setPreferredSize(new java.awt.Dimension(460, 322));
        jPanel1.setLayout(new java.awt.BorderLayout());

        btnOk1.setText("OK");
        btnOk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOk1ActionPerformed(evt);
            }
        });

        jSplitPane1.setPreferredSize(new java.awt.Dimension(459, 350));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Các loại Phòng");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Phòng đơn");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Phòng đôi");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Phòng gia đình");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Phòng VIP");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setMaximumSize(new java.awt.Dimension(150, 64));
        jTree1.setMinimumSize(new java.awt.Dimension(50, 0));
        jTree1.setPreferredSize(new java.awt.Dimension(150, 64));
        jTree1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTree1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        pnInformations.setBackground(new java.awt.Color(255, 255, 255));
        pnInformations.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Quản lý thông tin"));
        pnInformations.setToolTipText("");
        pnInformations.setMaximumSize(new java.awt.Dimension(300, 322));
        pnInformations.setMinimumSize(new java.awt.Dimension(200, 0));
        pnInformations.setPreferredSize(new java.awt.Dimension(300, 322));

        lblName.setText("Họ và Tên");

        txaNote.setColumns(20);
        txaNote.setRows(5);
        jScrollPane2.setViewportView(txaNote);

        lblGender.setText("Giới Tính");

        lblDateOfBirth.setText("Ngày Sình");

        lblPlaceOfBirth.setText("Nơi Sinh");

        lblAddress.setText("Địa chỉ");

        lblPNumber.setText("Điện Thoại");

        lblEmail.setText("E-mail");

        lblCMND.setText("Số CMND");

        lblIssuedBy.setText("Nơi Cấp");

        lblNote.setText("Ghi Chú");

        txtName.setMaximumSize(new java.awt.Dimension(6, 20));

        cbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));

        cbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", " " }));

        txtPlaceOfBirth.setMaximumSize(new java.awt.Dimension(6, 20));

        lblNationality.setText("Quốc Tịch");

        txaAddress.setColumns(20);
        txaAddress.setRows(5);
        jScrollPane3.setViewportView(txaAddress);

        try{
            txfCMND = new JFormattedTextField(new MaskFormatter("#########"));
        }catch(java.text.ParseException e){
            e.printStackTrace();
        }

        lblWarnName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWarnName.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnName.setMaximumSize(new java.awt.Dimension(170, 20));
        lblWarnName.setMinimumSize(new java.awt.Dimension(170, 20));
        lblWarnName.setPreferredSize(new java.awt.Dimension(170, 20));

        lblDateOfBirthWarning.setMaximumSize(new java.awt.Dimension(170, 20));
        lblDateOfBirthWarning.setMinimumSize(new java.awt.Dimension(170, 20));
        lblDateOfBirthWarning.setPreferredSize(new java.awt.Dimension(170, 20));

        lblPhoneWarning.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPhoneWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblPhoneWarning.setMaximumSize(new java.awt.Dimension(170, 20));
        lblPhoneWarning.setMinimumSize(new java.awt.Dimension(170, 20));
        lblPhoneWarning.setPreferredSize(new java.awt.Dimension(170, 20));

        lblIDWarning.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIDWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIDWarning.setMaximumSize(new java.awt.Dimension(170, 20));
        lblIDWarning.setMinimumSize(new java.awt.Dimension(170, 20));
        lblIDWarning.setPreferredSize(new java.awt.Dimension(170, 20));

        lblPassport.setText("hoặc Passport");

        cbDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12", " " }));

        javax.swing.GroupLayout pnInformationsLayout = new javax.swing.GroupLayout(pnInformations);
        pnInformations.setLayout(pnInformationsLayout);
        pnInformationsLayout.setHorizontalGroup(
            pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformationsLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnInformationsLayout.createSequentialGroup()
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(lblPNumber)
                            .addComponent(lblEmail)
                            .addComponent(lblCMND)
                            .addComponent(lblIssuedBy)
                            .addComponent(lblNote))
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInformationsLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(pnInformationsLayout.createSequentialGroup()
                                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIssuedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnInformationsLayout.createSequentialGroup()
                                                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txfCMND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblPassport)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(pnInformationsLayout.createSequentialGroup()
                                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnInformationsLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnInformationsLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInformationsLayout.createSequentialGroup()
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateOfBirth)
                            .addComponent(lblPlaceOfBirth))
                        .addGap(18, 18, 18)
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlaceOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnInformationsLayout.createSequentialGroup()
                                .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInformationsLayout.createSequentialGroup()
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblGender))
                        .addGap(18, 18, 18)
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnInformationsLayout.createSequentialGroup()
                                .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNationality)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDateOfBirthWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPhoneWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIDWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblWarnName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnInformationsLayout.setVerticalGroup(
            pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWarnName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 53, Short.MAX_VALUE)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnInformationsLayout.createSequentialGroup()
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGender)
                            .addComponent(lblNationality)
                            .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateOfBirthWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDateOfBirth)
                        .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaceOfBirth)
                    .addComponent(txtPlaceOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPNumber)
                    .addComponent(txfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCMND)
                    .addComponent(txfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassport))
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformationsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblIssuedBy))
                    .addGroup(pnInformationsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIssuedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNote)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jSplitPane1.setRightComponent(pnInformations);

        jmHethong.setText("Hệ Thống");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Undo");
        jmHethong.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Redo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmHethong.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Exit");
        jmHethong.add(jMenuItem3);

        jMenuBar1.add(jmHethong);

        jmDanhmuc.setText("Danh Mục");
        jMenuBar1.add(jmDanhmuc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(btnOk1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbUndoActionPerformed

        if(manager.canUndo()){
        manager.undo();
        }
    }//GEN-LAST:event_tbUndoActionPerformed

    private void tbRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbRedoActionPerformed
        if(manager.canRedo()){
            manager.redo();
        }
//        tbUndo.setText(manager.getUndoPresentationName());
//        tbRedo.setText(manager.getRedoPresentationName());
//        tbUndo.setEnabled(manager.canUndo());
//        tbRedo.setEnabled(manager.canRedo());
    }//GEN-LAST:event_tbRedoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnOk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOk1ActionPerformed

        if(txtName.getText().equals("")){
            lblWarnName.setText("Tên không được để trống");            
        }else{
            lblWarnName.setText("");
        }
        if(txfPhone.getText().equals("")){
            lblPhoneWarning.setText("Số đt không được để trống");
        }else{
            lblPhoneWarning.setText("");
        }
        if(txfCMND.getText().endsWith(" ")){
            lblIDWarning.setText("CMND không được để trống");
        }
        else{
            lblIDWarning.setText("");
        }
        if(txtName.getText().equals("")==false && txfPhone.getText().equals("")== false && txfCMND.getText().endsWith(" ") == false ){
            dialogCheckIn.setLocationRelativeTo(null);
            dialogCheckIn.setVisible(true);
        }
    }//GEN-LAST:event_btnOk1ActionPerformed

    private void tbSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSettingActionPerformed
        dialogSetting.setLocationRelativeTo(null);
        dialogSetting.setVisible(true);
    }//GEN-LAST:event_tbSettingActionPerformed

    private void tbAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAdminActionPerformed

    }//GEN-LAST:event_tbAdminActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        addInformation();
        addCheckIn();
    }//GEN-LAST:event_btnOkActionPerformed

    private void jTree1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTree1AncestorAdded
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagement";
            Connection con = DriverManager.getConnection(connectionString, "taobivocam9x", "duc12345");
            PreparedStatement ps = con.prepareStatement("select * from Room");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String type = rs.getString(2);
                String status = rs.getString(3);

                if(type.equals("Phòng đơn")){
                    jTree1.setSelectionRow(1);
                    TreePath path = jTree1.getSelectionPath();
                    MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
                    MutableTreeNode newNode = new DefaultMutableTreeNode(id +"("+status+")");
                    model.insertNodeInto(newNode, node, node.getChildCount());
                }
                if(type.equals("Phòng đôi")){
                    jTree1.setSelectionRow(2);
                    TreePath path = jTree1.getSelectionPath();
                    MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
                    MutableTreeNode newNode = new DefaultMutableTreeNode(id +"("+status+")");
                    model.insertNodeInto(newNode, node, node.getChildCount());
                }
                if(type.equals("Phòng gia đình")){
                    jTree1.setSelectionRow(3);
                    TreePath path = jTree1.getSelectionPath();
                    MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
                    MutableTreeNode newNode = new DefaultMutableTreeNode(id +"("+status+")");
                    model.insertNodeInto(newNode, node, node.getChildCount());
                }
                if(type.equals("Phòng VIP")){
                    jTree1.setSelectionRow(4);
                    TreePath path = jTree1.getSelectionPath();
                    MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
                    MutableTreeNode newNode = new DefaultMutableTreeNode(id +"("+status+")");
                    model.insertNodeInto(newNode, node, node.getChildCount());
                }
            }
            
            ps.close();
            con.close();
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jTree1AncestorAdded

    private void jPanel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel4AncestorAdded
        txtHours.setText(currenttime);
    }//GEN-LAST:event_jPanel4AncestorAdded

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnOk1;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbDay;
    private javax.swing.JComboBox cbGender;
    private javax.swing.JComboBox cbMonth;
    private javax.swing.JComboBox cbYear;
    private javax.swing.JDialog dialogCheckIn;
    private javax.swing.JDialog dialogSetting;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenu jmDanhmuc;
    private javax.swing.JMenu jmHethong;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblDateOfBirthWarning;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIDWarning;
    private javax.swing.JLabel lblIssuedBy;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblPNumber;
    private javax.swing.JLabel lblPassport;
    private javax.swing.JLabel lblPhoneWarning;
    private javax.swing.JLabel lblPlaceOfBirth;
    private javax.swing.JLabel lblWarnName;
    private javax.swing.JPanel pnInformations;
    private javax.swing.JPanel pnRequest2;
    private javax.swing.JToggleButton tbAdmin;
    private javax.swing.JToggleButton tbRedo;
    private javax.swing.JToggleButton tbSearch;
    private javax.swing.JToggleButton tbSetting;
    private javax.swing.JToggleButton tbUndo;
    private javax.swing.JTextArea txaAddress;
    private javax.swing.JTextArea txaNote;
    private javax.swing.JTextArea txaRequest;
    private javax.swing.JFormattedTextField txfAdult;
    private javax.swing.JFormattedTextField txfCMND;
    private javax.swing.JFormattedTextField txfCheckOut;
    private javax.swing.JFormattedTextField txfChild;
    private javax.swing.JFormattedTextField txfDayArrived;
    private javax.swing.JFormattedTextField txfDayBook;
    private javax.swing.JFormattedTextField txfDeposit;
    private javax.swing.JFormattedTextField txfPhone;
    private javax.swing.JFormattedTextField txfRoomNumber;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHours;
    private javax.swing.JTextField txtIssuedBy;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtPlaceOfBirth;
    // End of variables declaration//GEN-END:variables



    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        manager.addEdit(e.getEdit());
    }
}
