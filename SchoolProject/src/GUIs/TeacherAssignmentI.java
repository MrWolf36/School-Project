/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUIs;

import static GUIs.LoginGUI.studentData;
import Helper.DBConnection;
import Model.Classes;
import Model.Lesson;
import Model.Student;
import Model.TeachToLes;
import Model.Teacher;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kerem
 */
public class TeacherAssignmentI extends javax.swing.JInternalFrame {
    Classes classes=new Classes();
    Lesson lesson=new Lesson();
    Teacher teacher=new Teacher();
    TeachToLes TTL=new TeachToLes();
    Student student=new Student();
    /**
     * Creates new form TeacherToLessonI
     */
    public TeacherAssignmentI() {
        initComponents();
           this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        
        selTbl();
      getTbl();
          
           
    }
    public void getTbl(){
          TeachToLesData=new Object[4];
        TeachToLesModel=(DefaultTableModel) atamaTbl.getModel();
      for(int i=0;i<TTL.getTeachToLes().size();i++){
         
             TeachToLesData[0]=TTL.getTeachToLes().get(i).getId();
            TeachToLesData[1]=TTL.getTeachToLes().get(i).getEpisode();
            TeachToLesData[2]=TTL.getTeachToLes().get(i).getLessonName();
            TeachToLesData[3]=TTL.getTeachToLes().get(i).getTeacherName();
             
             TeachToLesModel.addRow(TeachToLesData);
         
         }
    }
  
    public void updateTbl(){
       DefaultTableModel clearTable=(DefaultTableModel) atamaTbl.getModel();
        clearTable.setRowCount(0);
        getTbl();
      
           
    }
    
    
    public void selTbl(){
        atamaTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
               hiddenLbl.setVisible(false);
               hiddenLbl.setText(atamaTbl.getValueAt(atamaTbl.getSelectedRow(), 0).toString());
            }
                catch(Exception ex){
                   
                
            }
        }
        });
       
    }
    
    
    
  
   
        
       
      public void selLes(){
          String lesBolum=(String) bolumCB.getSelectedItem();
          LesNameCB.removeAllItems();
        try {
            st=con.createStatement();
              rs=st.executeQuery("SELECT*FROM lesson WHERE className='"+lesBolum+"'");
              while(rs.next()){
                  LesNameCB.addItem(rs.getString("lessonName"));
              }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAssignmentI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           }
      
        public void selTeacher(String lesName){
             
             TeacherCB.removeAllItems();
        try {
       
           st=con.createStatement();
             rs=st.executeQuery("SELECT * FROM teacher WHERE branch='"+lesName+"'");
              while(rs.next()){
                  TeacherCB.addItem(rs.getString("name"));
              }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAssignmentI.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }
        
    
      
 public void selBolum(){
        try {
          
            st=con.createStatement();
              rs=st.executeQuery("SELECT*FROM classes");
        while(rs.next()){
            bolumCB.addItem(rs.getString("className"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAssignmentI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
 
 public void lesControl(String ders){
     String lesName=(String) LesNameCB.getSelectedItem();
        try {
            st=con.createStatement();
              rs=st.executeQuery("SELECT*FROM teachtoles WHERE lessonName='"+lesName+"'");
              while(rs.next()){
                 String lesson=rs.getString("lessonName");
                 if(ders.equals(lesson)){
                     JOptionPane.showMessageDialog(null, "SEÇMİŞ OLDUĞUNUZ DERSİN ÖĞRETMEN ATAMASI YAPILMIŞTIR","DİKKAT",JOptionPane.WARNING_MESSAGE);
                     break;
                 }
              }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAssignmentI.class.getName()).log(Level.SEVERE, null, ex);
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

        mainPnl = new javax.swing.JPanel();
        LesNameCB = new javax.swing.JComboBox<>();
        LesNameLbl = new javax.swing.JLabel();
        TeachNameLbl = new javax.swing.JLabel();
        TeacherCB = new javax.swing.JComboBox<>();
        ancestorBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        atamaTbl = new javax.swing.JTable();
        bolumLbl = new javax.swing.JLabel();
        bolumCB = new javax.swing.JComboBox<>();
        selBolumBtn = new javax.swing.JButton();
        selLesBtn = new javax.swing.JButton();
        hiddenLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPnl.setBackground(new java.awt.Color(51, 0, 0));
        mainPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LesNameCB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainPnl.add(LesNameCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 150, -1));

        LesNameLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LesNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        LesNameLbl.setText(" DERS ADI");
        mainPnl.add(LesNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 80, 30));

        TeachNameLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TeachNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        TeachNameLbl.setText(" AKADEMİSYEN ADI");
        mainPnl.add(TeachNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 150, 30));

        TeacherCB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainPnl.add(TeacherCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 150, -1));

        ancestorBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ancestorBtn.setText("ATA");
        ancestorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ancestorBtnActionPerformed(evt);
            }
        });
        mainPnl.add(ancestorBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 60, -1));

        delBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delBtn.setText("SİL");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });
        mainPnl.add(delBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 60, -1));

        jScrollPane1.setBackground(new java.awt.Color(51, 0, 0));

        atamaTbl.setBackground(new java.awt.Color(51, 0, 0));
        atamaTbl.setForeground(new java.awt.Color(255, 255, 255));
        atamaTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID","BÖLÜM","DERSİN ADI","AKADEMİSYEN"
            }
        ));
        jScrollPane1.setViewportView(atamaTbl);

        mainPnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 260));

        bolumLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bolumLbl.setForeground(new java.awt.Color(255, 255, 255));
        bolumLbl.setText("BÖLÜM ADI");
        mainPnl.add(bolumLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 80, 30));

        bolumCB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bolumCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elektrik-Elektronik", "Bilgisayar", "Yazılım", "Tekstil" }));
        mainPnl.add(bolumCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 150, -1));

        selBolumBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selBolumBtn.setText("SEÇ");
        selBolumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selBolumBtnActionPerformed(evt);
            }
        });
        mainPnl.add(selBolumBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 60, -1));

        selLesBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selLesBtn.setText("SEÇ");
        selLesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selLesBtnActionPerformed(evt);
            }
        });
        mainPnl.add(selLesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 60, -1));

        hiddenLbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPnl.add(hiddenLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 60, 20));

        getContentPane().add(mainPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selBolumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selBolumBtnActionPerformed
        
        selLes();
    }//GEN-LAST:event_selBolumBtnActionPerformed

    private void selLesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selLesBtnActionPerformed
        String ders=(String) LesNameCB.getSelectedItem();
        int count=0;
        try {
             st=con.createStatement();
              rs=st.executeQuery("SELECT*FROM teachtoles WHERE lessonName='"+ders+"'");
              while(rs.next()){
                 String lesson=rs.getString("lessonName");
                 if(ders.equals(lesson)){
                     count++;
                    
                 }else{
                    count=0;
                 }
              }
                                  
                   
              } catch (SQLException ex) {
            Logger.getLogger(TeacherAssignmentI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count<1){
             selTeacher(ders); 
             
        }
        else{
             TeacherCB.removeAllItems();
            JOptionPane.showMessageDialog(null, "SEÇMİŞ OLDUĞUNUZ DERSİN ÖĞRETMEN ATAMASI YAPILMIŞTIR","DİKKAT",JOptionPane.WARNING_MESSAGE); 
        }
        
    }//GEN-LAST:event_selLesBtnActionPerformed

    private void ancestorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ancestorBtnActionPerformed
       if(bolumCB.getSelectedIndex()==-1||LesNameCB.getSelectedIndex()==-1||TeacherCB.getSelectedIndex()==-1){
           JOptionPane.showMessageDialog(null,"LÜTFEN SEÇİMLERİNİZİN TAMAMINI YAPINIZ","HATA!",JOptionPane.WARNING_MESSAGE);
       }
       else{
               boolean control= TTL.TeachToLesADD((String)bolumCB.getSelectedItem(),(String) LesNameCB.getSelectedItem(),(String) TeacherCB.getSelectedItem());
                if(control==true){
                    Helper.OptionPane.showMessage("success");
                    LesNameCB.removeAllItems();
                    TeacherCB.removeAllItems();
                    updateTbl();
                 
             }
     
        }
     
    }//GEN-LAST:event_ancestorBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
           if(hiddenLbl.getText().equals("")){
            Helper.OptionPane.showMessage("select");
        }
        else{
        int selID=Integer.parseInt(hiddenLbl.getText());
        boolean control=TTL.TeachToLesDEL(selID);
        if(control==true){
            Helper.OptionPane.showMessage("success");
            hiddenLbl.setText("");
            updateTbl();
        }
        }
    }//GEN-LAST:event_delBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> LesNameCB;
    private javax.swing.JLabel LesNameLbl;
    private javax.swing.JLabel TeachNameLbl;
    private javax.swing.JComboBox<String> TeacherCB;
    private javax.swing.JButton ancestorBtn;
    private javax.swing.JTable atamaTbl;
    private javax.swing.JComboBox<String> bolumCB;
    private javax.swing.JLabel bolumLbl;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel hiddenLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPnl;
    private javax.swing.JButton selBolumBtn;
    private javax.swing.JButton selLesBtn;
    // End of variables declaration//GEN-END:variables
private DBConnection conn=new DBConnection();
private Connection con=conn.connDB();
private Statement st=null;
private ResultSet rs=null;
private PreparedStatement pt=null;
        DefaultTableModel TeachToLesModel=null;
        Object[] TeachToLesData=null;
} 
