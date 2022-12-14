/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import static GUIs.LoginGUI.studentData;
import Helper.DBConnection;
import Model.Student;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Kerem
 */
public class StudentGUI extends javax.swing.JFrame {

    /**
     * Creates new form StudentGUI
     */
    public StudentGUI() {
        initComponents();
        
        
        try {
            
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM student");
            while(rs.next()){
                sGuiWelcomeLbl.setText("Hoşgeldiniz "+ studentData[1]);
                if(studentData[6].equals("ERKEK")){
                    sGuiLeftTopLbl.setIcon(new ImageIcon("C:\\swingDemos\\SchoolProject\\src\\Img\\erkek.png"));
                }else if(studentData[6].equals("KADIN")){
                     sGuiLeftTopLbl.setIcon(new ImageIcon("C:\\swingDemos\\SchoolProject\\src\\Img\\kadin.png"));
                }
                else{
                    Helper.OptionPane.showMessage("error");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGUI.class.getName()).log(Level.SEVERE, null, ex);
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

        sGuiMainPnl = new javax.swing.JPanel();
        sGuiTopPnl = new javax.swing.JPanel();
        sGuiTopLbl = new javax.swing.JLabel();
        sGuiLeftTopPnl = new javax.swing.JPanel();
        sGuiLeftTopLbl = new javax.swing.JLabel();
        sGuiWelcomeLbl = new javax.swing.JLabel();
        sGuiLeftDownPnl = new javax.swing.JPanel();
        sGuiGetStuPnl = new javax.swing.JPanel();
        sGuiGetStuLbl = new javax.swing.JLabel();
        sGuiMyInfoPnl = new javax.swing.JPanel();
        sGuiMyInfoLbl1 = new javax.swing.JLabel();
        sGuiChangePassPnl = new javax.swing.JPanel();
        sGuiChangePassLbl = new javax.swing.JLabel();
        LogOutLbl1 = new javax.swing.JLabel();
        sGuiDP = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sGuiMainPnl.setBackground(new java.awt.Color(102, 0, 0));
        sGuiMainPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sGuiTopLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/student page 500X100.png"))); // NOI18N

        javax.swing.GroupLayout sGuiTopPnlLayout = new javax.swing.GroupLayout(sGuiTopPnl);
        sGuiTopPnl.setLayout(sGuiTopPnlLayout);
        sGuiTopPnlLayout.setHorizontalGroup(
            sGuiTopPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sGuiTopLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sGuiTopPnlLayout.setVerticalGroup(
            sGuiTopPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sGuiTopLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sGuiMainPnl.add(sGuiTopPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 500, 100));

        sGuiLeftTopPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sGuiLeftTopLbl.setBackground(new java.awt.Color(102, 0, 0));
        sGuiLeftTopLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sGuiLeftTopLbl.setOpaque(true);
        sGuiLeftTopPnl.add(sGuiLeftTopLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        sGuiWelcomeLbl.setBackground(new java.awt.Color(102, 0, 0));
        sGuiWelcomeLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sGuiWelcomeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sGuiWelcomeLbl.setOpaque(true);
        sGuiLeftTopPnl.add(sGuiWelcomeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 100));

        sGuiMainPnl.add(sGuiLeftTopPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 160));

        sGuiLeftDownPnl.setBackground(new java.awt.Color(102, 0, 0));
        sGuiLeftDownPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sGuiGetStuPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sGuiGetStuLbl.setBackground(new java.awt.Color(102, 0, 0));
        sGuiGetStuLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sGuiGetStuLbl.setText("Aldığım Dersler");
        sGuiGetStuLbl.setOpaque(true);
        sGuiGetStuLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sGuiGetStuLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sGuiGetStuLblMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sGuiGetStuLblMousePressed(evt);
            }
        });
        sGuiGetStuPnl.add(sGuiGetStuLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        sGuiLeftDownPnl.add(sGuiGetStuPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 200, 40));

        sGuiMyInfoPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sGuiMyInfoLbl1.setBackground(new java.awt.Color(102, 0, 0));
        sGuiMyInfoLbl1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sGuiMyInfoLbl1.setText(" Bilgilerim");
        sGuiMyInfoLbl1.setOpaque(true);
        sGuiMyInfoLbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sGuiMyInfoLbl1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sGuiMyInfoLbl1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sGuiMyInfoLbl1MousePressed(evt);
            }
        });
        sGuiMyInfoPnl.add(sGuiMyInfoLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        sGuiLeftDownPnl.add(sGuiMyInfoPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        sGuiChangePassLbl.setBackground(new java.awt.Color(102, 0, 0));
        sGuiChangePassLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sGuiChangePassLbl.setText(" Şifre Değiştir");
        sGuiChangePassLbl.setOpaque(true);
        sGuiChangePassLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sGuiChangePassLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sGuiChangePassLblMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sGuiChangePassLblMousePressed(evt);
            }
        });

        javax.swing.GroupLayout sGuiChangePassPnlLayout = new javax.swing.GroupLayout(sGuiChangePassPnl);
        sGuiChangePassPnl.setLayout(sGuiChangePassPnlLayout);
        sGuiChangePassPnlLayout.setHorizontalGroup(
            sGuiChangePassPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sGuiChangePassPnlLayout.createSequentialGroup()
                .addComponent(sGuiChangePassLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sGuiChangePassPnlLayout.setVerticalGroup(
            sGuiChangePassPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sGuiChangePassPnlLayout.createSequentialGroup()
                .addComponent(sGuiChangePassLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sGuiLeftDownPnl.add(sGuiChangePassPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 200, 40));

        sGuiMainPnl.add(sGuiLeftDownPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 290));

        LogOutLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogOutLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIs/Images/logout (4).png"))); // NOI18N
        LogOutLbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogOutLbl1MousePressed(evt);
            }
        });
        sGuiMainPnl.add(LogOutLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, -1));

        sGuiDP.setBackground(new java.awt.Color(51, 0, 0));

        javax.swing.GroupLayout sGuiDPLayout = new javax.swing.GroupLayout(sGuiDP);
        sGuiDP.setLayout(sGuiDPLayout);
        sGuiDPLayout.setHorizontalGroup(
            sGuiDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        sGuiDPLayout.setVerticalGroup(
            sGuiDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        sGuiMainPnl.add(sGuiDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 500, 400));

        getContentPane().add(sGuiMainPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutLbl1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutLbl1MousePressed
        LoginGUI logOut=new LoginGUI();
        logOut.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogOutLbl1MousePressed

    private void sGuiMyInfoLbl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiMyInfoLbl1MouseEntered
        sGuiMyInfoLbl1.setBackground(new Color(51,0,0));
    }//GEN-LAST:event_sGuiMyInfoLbl1MouseEntered

    private void sGuiMyInfoLbl1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiMyInfoLbl1MouseExited
         sGuiMyInfoLbl1.setBackground(new Color(102,0,0));
    }//GEN-LAST:event_sGuiMyInfoLbl1MouseExited

    private void sGuiGetStuLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiGetStuLblMouseEntered
        sGuiGetStuLbl.setBackground(new Color(51,0,0));
    }//GEN-LAST:event_sGuiGetStuLblMouseEntered

    private void sGuiGetStuLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiGetStuLblMouseExited
         sGuiGetStuLbl.setBackground(new Color(102,0,0));
    }//GEN-LAST:event_sGuiGetStuLblMouseExited

    private void sGuiChangePassLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiChangePassLblMouseEntered
       sGuiChangePassLbl.setBackground(new Color(51,0,0));
    }//GEN-LAST:event_sGuiChangePassLblMouseEntered

    private void sGuiChangePassLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiChangePassLblMouseExited
        sGuiChangePassLbl.setBackground(new Color(102,0,0));
    }//GEN-LAST:event_sGuiChangePassLblMouseExited

    private void sGuiChangePassLblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiChangePassLblMousePressed
        StuChangePassI scp=new StuChangePassI();
        sGuiDP.removeAll();
        sGuiDP.add(scp).setVisible(true);
    }//GEN-LAST:event_sGuiChangePassLblMousePressed

    private void sGuiMyInfoLbl1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiMyInfoLbl1MousePressed
    
        MyInfoI myInfo=new MyInfoI();
      sGuiDP.removeAll();
      sGuiDP.add(myInfo).setVisible(true);
    }//GEN-LAST:event_sGuiMyInfoLbl1MousePressed

    private void sGuiGetStuLblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sGuiGetStuLblMousePressed
       MyLessonsI myLes=new MyLessonsI();
       sGuiDP.removeAll();
       sGuiDP.add(myLes).setVisible(true);
    }//GEN-LAST:event_sGuiGetStuLblMousePressed

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
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StudentGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogOutLbl1;
    private javax.swing.JLabel sGuiChangePassLbl;
    private javax.swing.JPanel sGuiChangePassPnl;
    private javax.swing.JDesktopPane sGuiDP;
    private javax.swing.JLabel sGuiGetStuLbl;
    private javax.swing.JPanel sGuiGetStuPnl;
    private javax.swing.JPanel sGuiLeftDownPnl;
    private javax.swing.JLabel sGuiLeftTopLbl;
    private javax.swing.JPanel sGuiLeftTopPnl;
    private javax.swing.JPanel sGuiMainPnl;
    private javax.swing.JLabel sGuiMyInfoLbl1;
    private javax.swing.JPanel sGuiMyInfoPnl;
    private javax.swing.JLabel sGuiTopLbl;
    private javax.swing.JPanel sGuiTopPnl;
    private javax.swing.JLabel sGuiWelcomeLbl;
    // End of variables declaration//GEN-END:variables
DBConnection conn = new DBConnection();
Connection con=conn.connDB();
Statement st=null;
ResultSet rs=null;
PreparedStatement pt=null;
LoginGUI lGUI=new LoginGUI();
Student student=new Student();
}
