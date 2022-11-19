/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Helper.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author Kerem
 */
public class StudentLes extends Student{
    private DBConnection conn=new DBConnection();
    private Connection con=conn.connDB();
    private Statement st=null;
    private ResultSet rs=null;
    private PreparedStatement pt=null;
    private String L1;
     private String L2;
    private String L3;
    
    public StudentLes() {}

    public StudentLes(String L1, String L2, String L3) {
        this.L1 = L1;
        this.L2 = L2;
        this.L3 = L3;
    }
   
       public ArrayList<StudentLes> getLessonList(String tcno){
       ArrayList<StudentLes> lesList = new ArrayList<>();
           StudentLes obj;
            
            try {
          
           st=con.createStatement();
           rs=st.executeQuery("SELECT * FROM student WHERE tcno="+tcno);
           while(rs.next()){
               obj=new StudentLes(rs.getString("L1"),rs.getString("L2"),rs.getString("L3"));
               lesList.add(obj);
           }
       } catch (SQLException ex) {
           Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
       }
            return lesList;
        }
       
       
       public boolean addStudentLes(String L1,String L2,String L3){
           String query="INSERT INTO student (L1,L2,L3) VALUES (?,?,?) ";
           boolean key=false;
        try {
            
            st=con.createStatement();
            pt=con.prepareStatement(query);
            pt.setString(1, L1);
            pt.setString(2, L2);
            pt.setString(3, L3);
            pt.executeUpdate();
            key=true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentLes.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(key)
            return true;
        else 
            return false;
       }
       
       public boolean delLesson(int id){
           boolean key=false;
        try {
            st=con.createStatement();
            pt=con.prepareStatement("DELETE FROM student WHERE id=?");
            pt.setInt(1, id);
            pt.executeUpdate();
            key=true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentLes.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(key) 
             return true;
         else
             return false;
                   
       }
       public boolean updateLesson1(String tcno,String L1,String L2,String L3){
           boolean key=false;
        try {
            st=con.createStatement();
            pt=con.prepareStatement("UPDATE student SET L1=?,L2=?,L3=? WHERE tcno=?");
            pt.setString(1, L1);
             pt.setString(2, L2);
              pt.setString(3, L3);
              pt.setString(4, tcno);
              pt.executeUpdate();
               key=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentLes.class.getName()).log(Level.SEVERE, null, ex);
        }
          if(key) 
              return true;
          else
              return false;
       }
       
       public boolean updateLesson(String tcno,String L1,int L1NOT1,int L1NOT2,int L1NOT3,String L1Result,String L2,int L2NOT1,int L2NOT2,int L2NOT3,String L2Result,String L3,int L3NOT1,int L3NOT2,int L3NOT3,String L3Result){
           boolean key=false;
        try {
            st=con.createStatement();
            pt=con.prepareStatement("UPDATE student SET L1=?,L1NOT1=?,L1NOT2=?,L1NOT3=?,L1Result=?,L2=?,L2NOT1=?,L2NOT2=?,L2NOT3=?,L2Result=?,L3=?,L3NOT1=?,L3NOT2=?,L3NOT3=?,L3Result=? WHERE tcno=?");
            pt.setString(1, L1);
            pt.setInt(2, L1NOT1);
            pt.setInt(3, L1NOT2);
            pt.setInt(4, L1NOT3);
            pt.setString(5, L1Result);
            pt.setString(6, L2);
            pt.setInt(7, L2NOT1);
            pt.setInt(8, L2NOT2);
            pt.setInt(9, L2NOT3);
            pt.setString(10, L2Result);
            pt.setString(11, L3);
            pt.setInt(12, L3NOT1);
            pt.setInt(13, L3NOT2);
            pt.setInt(14, L3NOT3);
            pt.setString(15, L3Result);
            pt.setString(16, tcno);
            pt.executeUpdate();
            key=true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentLes.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(key)
            return true;
        else 
            return false;
       }
    /**
     * @return the L1
     */
    public String getL1() {
        return L1;
    }

    /**
     * @param L1 the L1 to set
     */
    public void setL1(String L1) {
        this.L1 = L1;
    }

    /**
     * @return the L2
     */
    public String getL2() {
        return L2;
    }

    /**
     * @param L2 the L2 to set
     */
    public void setL2(String L2) {
        this.L2 = L2;
    }

    /**
     * @return the L3
     */
    public String getL3() {
        return L3;
    }

    /**
     * @param L3 the L3 to set
     */
    public void setL3(String L3) {
        this.L3 = L3;
    }
}
