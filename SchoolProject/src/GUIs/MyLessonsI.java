/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUIs;

import static GUIs.LoginGUI.studentData;

import Helper.DBConnection;
import Helper.Item;
import Model.Classes;
import Model.Lesson;
import Model.StudentLes;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kerem
 */
public class MyLessonsI extends javax.swing.JInternalFrame {
    Lesson lesson =new Lesson();
    Item item =null;
    Classes classes=new Classes();
    StudentLes SLes=new StudentLes();
    StudentGUI sGUI=new StudentGUI();
    /**
     * Creates new form MyLessonsI
     */
    public MyLessonsI() {
        initComponents();
          this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        getMyClasses();
         getLessData();
         MyLesList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
         MyLesList2.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
          LesTableModel = (DefaultTableModel) myLesTbl.getModel();
         
         LessonData=new Object[5];
         for(int i=0;i< SLes.getLessonList((String) studentData[2]).size();i++){
             
                   LessonData[0]= SLes.getLessonList((String) studentData[2]).get(i).getL1();
             LessonData[1]= SLes.getLessonList((String) studentData[2]).get(i).getL2();
             LessonData[2]= SLes.getLessonList((String) studentData[2]).get(i).getL3();
               LessonData[3]=studentData[5];
          
             LesTableModel.addRow(LessonData);
             }
           
         
        
      
       
    }
     public void getLessData(){
    try {
        st=con.createStatement();
        rs=st.executeQuery("SELECT*FROM lesson");
        while(rs.next()){
            
            LesData[0]=rs.getInt("id");
            LesData[1]=rs.getString("lessonName");
        LesData[2]=rs.getString("quota");
        LesData[3]=rs.getString("className");
        }
       
                } catch (SQLException ex) {
        Logger.getLogger(Lesson.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   static Object[] LesData=new Object[4];
   
   
   
    public void updateLesTable(){
        DefaultTableModel clearTable=(DefaultTableModel) myLesTbl.getModel();
        clearTable.setRowCount(0);
       for(int i=0;i< SLes.getLessonList((String) studentData[2]).size();i++){
             
             LessonData[0]= SLes.getLessonList((String) studentData[2]).get(i).getL1();
             LessonData[1]= SLes.getLessonList((String) studentData[2]).get(i).getL2();
             LessonData[2]= SLes.getLessonList((String) studentData[2]).get(i).getL3();
             LessonData[3]=studentData[5];
             
             LesTableModel.addRow(LessonData);
             
       }
         }
    

    
    
     public void getMyClasses(){
      for(int i=0;i<classes.getClassesList().size();i++) {
          int key=classes.getClassesList().get(i).getId();
          String value=classes.getClassesList().get(i).getClassName();
          item = new Item(value,key);
          myLesCB.addItem(item.toString());
                  
      }
    }

     
     public void selClassLes(){
        list.removeAllElements();
        try {
              String selClass=(String) myLesCB.getSelectedItem();
            st=con.createStatement();
             rs=st.executeQuery("SELECT*FROM lesson WHERE className='"+selClass+"'");
             while(rs.next()){
                 
                 list.addElement(rs.getString("lessonName"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
           MyLesList.setModel(list);
     }   
        
    
     
     public boolean getEqualsAddLes(String ders1,String ders2,String ders3,String db) throws SQLException{
         boolean key=false;
        
                 
        try {
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM lesson");
          
            while(rs.next()){
                
                 db=rs.getString("lessonName");
                
                if(ders1.equals(db)){
                   
                   kota1=rs.getInt("quota");
                   --kota1;
                   
                
                  lesson.updateQuota(db, kota1);
                  System.out.println(kota1);
                  System.out.println(db);
                 
                   key=true;
                   
                }
                 }
            } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
                 try{
                 st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM lesson");
            
                 while(rs.next()){
                     
              db=rs.getString("lessonName"); 
                
                if(ders2.equals(db)){
                       
                   kota2=(rs.getInt("quota"));
                  --kota2;
                 
                
               
                  lesson.updateQuota(db, kota2);
                  System.out.println(kota2);
                  System.out.println(db);
                 
                   key=true;
                   
                              }
                 } 
                 } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                 
                try{
                  st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM lesson");
                 while(rs.next()){
                    db=rs.getString("lessonName");  
           if(ders3.equals(db)){
               
                    kota3=(rs.getInt("quota"));
                   --kota3;
           
                 
                     lesson.updateQuota(db, kota3);
                  System.out.println(kota3);
                System.out.println(db);
                
                
                   key=true;
                       
               
                 
                                }
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        if(key)
            return true;
         else
            return false;
     }
     
     
     public boolean getEqualsDelLes(String ders1,String ders2,String ders3,String db) throws SQLException{
         boolean key=false;
        
                 
        try {
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM lesson");
          
            while(rs.next()){
                
                 db=rs.getString("lessonName");
                
                if(ders1.equals(db)){
                   
                   kota1=rs.getInt("quota");
                   ++kota1;
                   if(kota1>30){
                       kota1=30;
                   }
                 
                   else{
                        lesson.updateQuota(db, kota1);
                 System.out.println(kota1);
                  System.out.println(db);
                  
                   key=true;
                   }
                 
                }
                 }
            } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
                 try{
                 st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM lesson");
            
                 while(rs.next()){
                     
              db=rs.getString("lessonName"); 
                
                if(ders2.equals(db)){
                       
                    kota2=(rs.getInt("quota"));
                  ++kota2;
                 
                   if(kota2>30){
                       kota2=30;
                   }else{
                        lesson.updateQuota(db, kota2);
                 System.out.println(kota2);
                  System.out.println(db);
                  
                   key=true;
                   }
                }
                 } 
                 } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                 
                try{
                  st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM lesson");
                 while(rs.next()){
                    db=rs.getString("lessonName");  
           if(ders3.equals(db)){
               
                    kota3=(rs.getInt("quota"));
                   ++kota3;
                   if(kota3>30){
                       kota3=30;
                   }else{
                        lesson.updateQuota(db, kota3);
                 System.out.println(kota3);
                  System.out.println(db);
                  
                   key=true;
                   }
                }
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        if(key)
            return true;
         else
            return false;
     }
     
     public void quotaControl(){
         String ders=MyLesList.getSelectedValue();
        if(ders==null){
             Helper.OptionPane.showMessage("Lütfen Bölüm Seçerek Seçilecek Ders Listesinden Ders Seçiniz");
         }else{
             ders=MyLesList.getSelectedValue();
        try {
            st=con.createStatement(); 
            rs=st.executeQuery("SELECT * FROM lesson WHERE lessonName='"+ders+"'");
            while(rs.next()){
                rs.getString("lessonName");
                int kota=rs.getInt("quota");
              if(kota<1){
                  JOptionPane.showMessageDialog(null,"Seçtiğiniz Dersin Kontenjanı Dolmuştur Lütfen Başka Bir Ders Seçniz","KONTENJAN DOLDU!",JOptionPane.OK_OPTION);
              }   
              else{
                  selMyLes();
              }
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
     }
      
      
      
     
     public void selMyLes(){
             if(studentData[5].equals((String) myLesCB.getSelectedItem())){
         
             if(MyLesList.getSelectedIndex()!=-1){
             
                  if(list2.size()<3){
                     
                 list2.addElement(MyLesList.getSelectedValue());
                  
                 aList[i]=MyLesList.getSelectedValue();
                 i++;
                 list.removeElement(MyLesList.getSelectedValue());
              MyLesList2.setModel(list2);
              System.out.println(Arrays.toString(aList));
              }
                  else{
                         JOptionPane.showMessageDialog(null,"Seçebileceğiniz Maximum Ders Sayısına Ulaştınız","DİKKAT!",JOptionPane.WARNING_MESSAGE);
                  }
             
             
         }
         else{
            JOptionPane.showMessageDialog(null,"LİSTEDEN DERS SEÇİNİZ","DİKKAT!",JOptionPane.WARNING_MESSAGE);
         }
     }
         else{
             JOptionPane.showMessageDialog(null,"BÖLÜM DERSLERİ DIŞINDA DERS SEÇEMEZSİNİZ!","DİKKAT!",JOptionPane.WARNING_MESSAGE);
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

        myLesMainPnl = new javax.swing.JPanel();
        myLesCB = new javax.swing.JComboBox<>();
        myLesBut = new javax.swing.JButton();
        myLesScrollPane = new javax.swing.JScrollPane();
        myLesTbl = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        MyLesList = new javax.swing.JList<>();
        dersAktarBut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        MyLesList2 = new javax.swing.JList<>();
        myLesOKBtn = new javax.swing.JButton();
        delLesBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        delSelLesBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 0, 0));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myLesMainPnl.setBackground(new java.awt.Color(51, 0, 0));
        myLesMainPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myLesCB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        myLesCB.setSelectedItem("Elektrik-Elektronik");
        myLesMainPnl.add(myLesCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 170, 20));

        myLesBut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        myLesBut.setText("BÖLÜM SEÇ");
        myLesBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myLesButActionPerformed(evt);
            }
        });
        myLesMainPnl.add(myLesBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 170, 20));

        myLesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DERS1", "DERS2","DERS3","BÖLÜM"
            }
        ));
        myLesScrollPane.setViewportView(myLesTbl);

        myLesMainPnl.add(myLesScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 120));

        jScrollPane1.setViewportView(MyLesList);

        myLesMainPnl.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 170, -1));

        dersAktarBut.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        dersAktarBut.setText("DERS AKTAR");
        dersAktarBut.setToolTipText("");
        dersAktarBut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dersAktarBut.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        dersAktarBut.setVerifyInputWhenFocusTarget(false);
        dersAktarBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dersAktarButActionPerformed(evt);
            }
        });
        myLesMainPnl.add(dersAktarBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<<");
        myLesMainPnl.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 70, 30));

        jScrollPane4.setViewportView(MyLesList2);

        myLesMainPnl.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 170, -1));

        myLesOKBtn.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        myLesOKBtn.setText("DERS SEÇİMİMİ TAMAMLA");
        myLesOKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myLesOKBtnActionPerformed(evt);
            }
        });
        myLesMainPnl.add(myLesOKBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 170, 20));

        delLesBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        delLesBtn.setText("DERS SİL");
        delLesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delLesBtnActionPerformed(evt);
            }
        });
        myLesMainPnl.add(delLesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(">>");
        myLesMainPnl.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seçilen Ders Listesi");
        myLesMainPnl.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 170, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seçilecek Ders Listesi");
        myLesMainPnl.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 170, 20));

        delSelLesBtn.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        delSelLesBtn.setText("DERS SEÇİMİMİ SİL");
        delSelLesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delSelLesBtnActionPerformed(evt);
            }
        });
        myLesMainPnl.add(delSelLesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 170, 20));
        delSelLesBtn.getAccessibleContext().setAccessibleName("Ders Seçimlerimi Sil");

        getContentPane().add(myLesMainPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myLesButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myLesButActionPerformed
        selClassLes();
       
    }//GEN-LAST:event_myLesButActionPerformed

    private void dersAktarButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dersAktarButActionPerformed
      
        quotaControl();
        
    }//GEN-LAST:event_dersAktarButActionPerformed

    private void delLesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delLesBtnActionPerformed
       if(MyLesList2.getSelectedIndex()!=-1){
             list.addElement(MyLesList2.getSelectedValue());
             list2.removeElement(MyLesList2.getSelectedValue());
             i--;
             aList[i]=null;
             
             System.out.println(Arrays.toString(aList));
        MyLesList2.setModel(list2);
        MyLesList.setModel(list);
          
       }
       else{
            JOptionPane.showMessageDialog(null,"LİSTEDEN DERS SEÇİNİZ","DİKKAT!",JOptionPane.WARNING_MESSAGE);
       }
        
        
      
    }//GEN-LAST:event_delLesBtnActionPerformed

    private void myLesOKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myLesOKBtnActionPerformed
            try {
                
            String tcno=(String) studentData[2];
            st=con.createStatement();
            rs=st.executeQuery("SELECT*FROM student WHERE tcno="+tcno);
            while(rs.next()){
              String ders1=rs.getString("L1");
                String ders2=rs.getString("L2");
                String ders3=rs.getString("L3");
               
                if(!ders1.equals("")||!ders2.equals("")||!ders3.equals("")){
                     JOptionPane.showMessageDialog(null, "Ders Seçiminiz Yapılmış Görünüyor Ders Seçimlerinizi Silmeden Bu İşlem Gerçekleşemez!","Dikkat!",JOptionPane.WARNING_MESSAGE);
                     break;
                }
                else{
        
               ders1=aList[0];
              ders2=aList[1];
              ders3=aList[2];
         
        if( Helper.OptionPane.showConfirm("sure")){
         if(i<3){
            JOptionPane.showMessageDialog(null,"DERS AKTARMA İŞLEMİNİZ YETERLİ SAYIDA DEĞİLDİR!","DİKKAT!",JOptionPane.WARNING_MESSAGE);
         }else{
             
          
        boolean control=SLes.updateLesson1((String) studentData[2],ders1,ders2,ders3);
        if(control==true){
            Helper.OptionPane.showMessage("success");
                 try {
                     getEqualsAddLes(ders1,ders2,ders3,(String) LesData[1]);
                     myLesOKBtn.setEnabled(false);
                     delLesBtn.setEnabled(false);
                     dersAktarBut.setEnabled(false);
                     list2.removeAllElements();
                    
                 } catch (SQLException ex) {
                     Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
                 }
            System.out.println(ders1);
        System.out.println(ders2);
        System.out.println(ders3);
        updateLesTable();
        }
         
        else{
            Helper.OptionPane.showMessage("error");
        }
         }
       }
                } 
            }
            }
              catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_myLesOKBtnActionPerformed

    private void delSelLesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delSelLesBtnActionPerformed
        try {
            String tcno=(String) studentData[2];
            st=con.createStatement();
            rs=st.executeQuery("SELECT*FROM student WHERE tcno= "+tcno);
            while(rs.next()){
              String ders1=rs.getString("L1");
                String ders2=rs.getString("L2");
                String ders3=rs.getString("L3");
                      
                if(ders1==null||ders2==null||ders3==null||ders1.equals("")||ders2.equals("")||ders3.equals("")){
                     JOptionPane.showMessageDialog(null, "Ders Seçiminiz Tamamlanmadan Bu İşlem Gerçekleşmez","Dikkat!",JOptionPane.WARNING_MESSAGE);
                     break;
                }
                else{
                if( Helper.OptionPane.showConfirm("sure")){
                    String result="Hesaplanmadı";
                   
                    boolean control=SLes.updateLesson((String) studentData[2],ders1,0,0,0,result,ders2,0,0,0,result,ders3,0,0,0,result);
                    if(control==true){
                        Helper.OptionPane.showMessage("success");
                        try {
                            getEqualsDelLes(ders1,ders2,ders3,(String) LesData[1]);
                            
                            list.addElement(ders1);
                            list.addElement(ders2);
                            list.addElement(ders3);
                            MyLesList.setModel(list);
                            aList[0]="";
                            aList[1]="";
                            aList[2]="";
                            ders1=aList[0];
                            ders2=aList[1];
                            ders3=aList[2];
                           SLes.updateLesson((String) studentData[2],ders1,0,0,0,result,ders2,0,0,0,result,ders3,0,0,0,result);
                            updateLesTable();
                            
                            dispose();
                            
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(ders1);
                        System.out.println(ders2);
                        System.out.println(ders3);
                        updateLesTable(); 
                        break;
                    }
                }
               
                }
                }
                
            
        
        } catch (SQLException ex) {
            Logger.getLogger(MyLessonsI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delSelLesBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> MyLesList;
    private javax.swing.JList<String> MyLesList2;
    private javax.swing.JButton delLesBtn;
    private javax.swing.JButton delSelLesBtn;
    private javax.swing.JButton dersAktarBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton myLesBut;
    private javax.swing.JComboBox<String> myLesCB;
    private javax.swing.JPanel myLesMainPnl;
    private javax.swing.JButton myLesOKBtn;
    private javax.swing.JScrollPane myLesScrollPane;
    private javax.swing.JTable myLesTbl;
    // End of variables declaration//GEN-END:variables
int count=0;
private DBConnection conn=new DBConnection();
private Connection con=conn.connDB();
private Statement st=null;
private ResultSet rs=null;
private PreparedStatement pt=null;
 DefaultListModel<String> list=new DefaultListModel<>();
 DefaultListModel<String> list2=new DefaultListModel<>();
    DefaultTableModel LesTableModel=null;
    Object[] LessonData=null;
int i=0;
String[] aList=new String[3];
int kota1,kota2,kota3;

}
