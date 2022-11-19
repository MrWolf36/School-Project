/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUIs;

import static GUIs.LoginGUI.studentData;
import static GUIs.LoginGUI.teacherData;
import Helper.DBConnection;
import Model.LessonTakers;
import Model.Student;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kerem
 */
public class LessonTakersI extends javax.swing.JInternalFrame {
LessonTakers LT = new LessonTakers();
Student student= new Student();    

    /**
     * Creates new form LessonTakersI
     */
    public LessonTakersI() {
        initComponents();
        
         this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
            BasicInternalFrameUI ui=(BasicInternalFrameUI) this.getUI();
            ui.setNorthPane(null);
             
   
             selName();
            getLesTbl();
        
            
    }
    
    
    public void getLesTbl(){
        try {
       
        String branch=(String) teacherData[4];
        st=con.createStatement(); 
        rs=st.executeQuery("SELECT*FROM student WHERE L1='"+branch+"'OR L2='"+branch+"'OR L3='"+branch+"'");
        while(rs.next()){
             if(rs.getString("L1").equals(branch)){
                 Les1Tbl();
                 Les2Tbl();
                   Les3Tbl();
               break;
             }
             else if(rs.getString("L2").equals(branch)){
                 
                   Les1Tbl();
                  Les2Tbl();
                   Les3Tbl();
                 break;
             }
             else if(rs.getString("L3").equals(branch)){
                   Les1Tbl();
                 Les2Tbl();
                   Les3Tbl();
                 break;
             }
             else{
                 Helper.OptionPane.showMessage("error");
             }
        }
           
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakersI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     
    
    
    public void selName(){
        String branch=(String) teacherData[4];
    try {
        st=con.createStatement();
          rs=st.executeQuery("SELECT*FROM student WHERE L1='"+branch+"'OR L2='"+branch+"'OR L3='"+branch+"'");
          while(rs.next()){
              nameCB.addItem(rs.getString("name"));
          }
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakersI.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }
 
    public void Les1Tbl(){
       
        String branch=(String) teacherData[4];
         LesTakeModel=(DefaultTableModel) examsTbl.getModel();
            LesTakeData= new Object[6];
           for(int i=0;i<LT.getExamList1(branch).size();i++){
                LesTakeData[0]=LT.getExamList1(branch).get(i).getName();
                LesTakeData[1]=teacherData[4];
                LesTakeData[2]=LT.getExamList1(branch).get(i).getL1NOT1();
                LesTakeData[3]=LT.getExamList1(branch).get(i).getL1NOT2();
                LesTakeData[4]=LT.getExamList1(branch).get(i).getL1NOT3();
                LesTakeData[5]=LT.getExamList1(branch).get(i).getL1Result();
                LesTakeModel.addRow(LesTakeData);
        
         }
       
    }
    
     public void Les2Tbl(){
        
        String branch=(String) teacherData[4];
         LesTakeModel=(DefaultTableModel) examsTbl.getModel();
            LesTakeData= new Object[6];
             for(int i=0;i<LT.getExamList2(branch).size();i++){
                LesTakeData[0]=LT.getExamList2(branch).get(i).getName();
                LesTakeData[1]=teacherData[4];
                LesTakeData[2]=LT.getExamList2(branch).get(i).getL2NOT1();
                LesTakeData[3]=LT.getExamList2(branch).get(i).getL2NOT2();
                LesTakeData[4]=LT.getExamList2(branch).get(i).getL2NOT3();
                LesTakeData[5]=LT.getExamList2(branch).get(i).getL2Result();
                LesTakeModel.addRow(LesTakeData);
             }
     }
     
        public void Les3Tbl(){
    
        String branch=(String) teacherData[4];
         LesTakeModel=(DefaultTableModel) examsTbl.getModel();
            LesTakeData= new Object[6];
            for(int i=0;i<LT.getExamList3(branch).size();i++){
                LesTakeData[0]=LT.getExamList3(branch).get(i).getName();
                LesTakeData[1]=teacherData[4];
                LesTakeData[2]=LT.getExamList3(branch).get(i).getL3NOT1();
                LesTakeData[3]=LT.getExamList3(branch).get(i).getL3NOT2();
                LesTakeData[4]=LT.getExamList3(branch).get(i).getL3NOT3();
                 LesTakeData[5]=LT.getExamList3(branch).get(i).getL3Result();
                LesTakeModel.addRow(LesTakeData);
         
           }
               }
        
        public void updateLesTbl(){
   
        DefaultTableModel clearModel= (DefaultTableModel) examsTbl.getModel();
         clearModel.setRowCount(0);
       
        Les1Tbl();
        Les2Tbl();
        Les3Tbl();
        }
        
        public String Calculate(int vize1,int vize2,int fnl){
            String sonuc = null;
            if(fnl<70){
                sonuc="BAŞARISIZ";
            }
            else{
            double result=((vize1*20)/100)+((vize2*20)/100)+(((fnl*60)/100));
            if(result>0&&result<50){
            sonuc="BAŞARISIZ";
            }
           else if(result>=50&&result<65){
            sonuc="YETERLİ";
                }
            else if(result>=65&&result<70){
            sonuc="ORTA";
            }
            else if(result>=70&&result<85){
            sonuc="İYİ";
        }
        else if(result>=85&&result<90){
            sonuc="B";
        }
        else if(result>=90&&result<101){
            sonuc="ÇOK İYİ";
            }
            
        }
            return sonuc;
        }
     
   
  public void addLessonExam(){
          int v1=Integer.parseInt(vize1Txt.getText());
       int v2=Integer.parseInt(vize2Txt.getText());
       int f=Integer.parseInt(finalTxt.getText());
      if(v1<0||v1>100||v2<0||v2>100||f<0||f>100){
           Helper.OptionPane.showMessage("GİRDİĞİNİZ NOT BELİRLENEN ARALIKTA DEĞİL!");
       }
      else{
        try {
             String branch=(String) teacherData[4];
             String name=(String) nameCB.getSelectedItem();
            st=con.createStatement();
            rs=st.executeQuery("SELECT*FROM student WHERE name='"+name+"' AND L1='"+branch+"' OR name='"+name+"' AND L2='"+branch+"'OR name='"+name+"'AND L3='"+branch+"'");
      while(rs.next()){
         
          if(branch.equals(rs.getString("L1"))){
             
            String sonuc=Calculate(v1, v2, f);
              LT.updateLesson1Takers(name,v1,v2,f,sonuc);
              updateLesTbl();
              vize1Txt.setText("");
              vize2Txt.setText("");
              finalTxt.setText("");
              break;
          }if(branch.equals(rs.getString("L2"))){
              String sonuc=Calculate(v1, v2, f);
              LT.updateLesson2Takers(name,v1,v2,f,sonuc);
              updateLesTbl();
              vize1Txt.setText("");
              vize2Txt.setText("");
              finalTxt.setText("");
              break;
          }if(branch.equals(rs.getString("L3"))){
             String sonuc=Calculate(v1, v2, f);
              LT.updateLesson3Takers(name,v1,v2,f,sonuc);
              updateLesTbl();
              vize1Txt.setText("");
              vize2Txt.setText("");
              finalTxt.setText("");
              break;
          }
          else{
              Helper.OptionPane.showConfirm("error");
          }
      }
        }catch (SQLException ex) {
            Logger.getLogger(LessonTakersI.class.getName()).log(Level.SEVERE, null, ex);
        }
  
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

        MainPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        examsTbl = new javax.swing.JTable();
        vize1Lbl = new javax.swing.JLabel();
        vize2Lbl = new javax.swing.JLabel();
        finalLbl = new javax.swing.JLabel();
        vize1Txt = new javax.swing.JTextField();
        vize2Txt = new javax.swing.JTextField();
        finalTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        nameCB = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 0, 0));
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPnl.setBackground(new java.awt.Color(51, 0, 0));
        MainPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(51, 0, 0));

        examsTbl.setBackground(new java.awt.Color(51, 0, 0));
        examsTbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        examsTbl.setForeground(new java.awt.Color(255, 255, 255));
        examsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AD SOYAD", "DERS ADI", "VİZE1", "VİZE2","FİNAL","SONUÇ"
            }
        ));
        jScrollPane1.setViewportView(examsTbl);

        MainPnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 220));

        vize1Lbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vize1Lbl.setForeground(new java.awt.Color(255, 255, 255));
        vize1Lbl.setText("VİZE1");
        MainPnl.add(vize1Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 80, 20));

        vize2Lbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vize2Lbl.setForeground(new java.awt.Color(255, 255, 255));
        vize2Lbl.setText("VİZE2");
        MainPnl.add(vize2Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 80, 20));

        finalLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        finalLbl.setForeground(new java.awt.Color(255, 255, 255));
        finalLbl.setText("FİNAL");
        MainPnl.add(finalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 80, 20));

        vize1Txt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MainPnl.add(vize1Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 70, 25));

        vize2Txt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MainPnl.add(vize2Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 70, 25));

        finalTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MainPnl.add(finalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 70, 25));

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addBtn.setText("EKLE");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        MainPnl.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 90, 25));

        MainPnl.add(nameCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 140, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ÖĞRENCİ ADI SOYADI");
        MainPnl.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, 140, 20));

        getContentPane().add(MainPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
           if(vize1Txt.getText().equals("")||vize2Txt.getText().equals("")||finalTxt.getText().equals("")){
           Helper.OptionPane.showMessage("fill");
       }
          else{
         
        addLessonExam();
          
          }
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPnl;
    private javax.swing.JButton addBtn;
    private javax.swing.JTable examsTbl;
    private javax.swing.JLabel finalLbl;
    private javax.swing.JTextField finalTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> nameCB;
    private javax.swing.JLabel vize1Lbl;
    private javax.swing.JTextField vize1Txt;
    private javax.swing.JLabel vize2Lbl;
    private javax.swing.JTextField vize2Txt;
    // End of variables declaration//GEN-END:variables
private DBConnection conn=new DBConnection();
private Connection con=conn.connDB();
private Statement st=null;
private ResultSet rs=null;
private PreparedStatement pt=null;
    DefaultTableModel LesTakeModel=null;
    Object[] LesTakeData=null;


}
