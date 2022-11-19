/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Helper.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kerem
 */
public class Student extends User{
   

   private String shNumber;
   private String password;
   private String gender;
   private String classes;
   private int L1NOT1;
   private int L1NOT2;
   private int L1NOT3;
   private int L2NOT1;
   private int L2NOT2;
   private int L2NOT3;
   private int L3NOT1;
   private int L3NOT2;
   private int L3NOT3;
   
   private String L1Result;
   private String L2Result;
   private String L3Result;
  


   private DBConnection conn=new DBConnection();
   private Connection con=conn.connDB();
   private Statement st=null;
   private ResultSet rs=null;
   private PreparedStatement pt=null;
   
   
   
   
   public Student(){}
 
       public Student(int id, String name, String tcno, String password, String shNumber,String classes,String gender) {
        super(id, name, tcno);
        
        
        this.shNumber =shNumber;
        this.password = password;
        this.gender=gender;
        this.classes=classes;

    }
        public boolean addStudent(String name,String tcno,String password,String shNumber,String classes,String gender){
        boolean key=false;
        try {
            String query="INSERT INTO student "+"(name,tcno,password,shNumber,classes,gender)"+"VALUES"+"(?,?,?,?,?,?)";
            st=con.createStatement();
            pt=con.prepareStatement(query);
            pt.setString(1, name);
            pt.setString(2, tcno);
            pt.setString(3, password);
            pt.setString(4, shNumber);
            pt.setString(5, classes);
            pt.setString(6, gender);
           
            pt.executeUpdate();
            key=true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(key)
            return true;
        else
            return false;
    }
     
          public ArrayList<Student> getStudentList(){
        ArrayList<Student> list=new ArrayList<>();
        Student obj;
        try {
             st=con.createStatement();
            rs=st.executeQuery("SELECT*FROM student");
            while(rs.next()){
                obj=new Student(rs.getInt("id"),rs.getString("name"),rs.getString("tcno"),rs.getString("password"),rs.getString("shNumber"),rs.getString("classes"),rs.getString("gender"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
          
          public boolean updateStudent(String name,String tcno,String password,String shNumber,String classes,String gender){
            boolean key=false;
           String query="UPDATE student SET name=?,tcno=?,password=?,shNumber=?,classes=?,gender=?";
              
              try {
           st=con.createStatement();
           pt=con.prepareStatement(query);
           pt.setString(1, name);
           pt.setString(2, tcno);
           pt.setString(3, password);
           pt.setString(4, shNumber);
           pt.setString(5, classes);
           pt.setString(6, gender);
           pt.executeUpdate();
           key=true;
       } catch (SQLException ex) {
           Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
       }
              if(key)
                  return true;
              else
                  return false;
          }
          public boolean delStudent(int id){
              boolean key=false;
           String query="DELETE FROM student WHERE id=?";
       try {
           
           st=con.createStatement();
           pt=con.prepareStatement(query);
           pt.setInt(1, id);
           pt.executeUpdate();
           key=true;
       } catch (SQLException ex) {
           Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(key)
           return true;
       else
           return false;
          }

  

   

    /**
     * @return the phoneNumber
     */
    public String getshNumber() {
        return shNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.shNumber = phoneNumber;
    }
      public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the classes
     */
    public String getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }

    /**
     * @return the L1NOT1
     */
    public int getL1NOT1() {
        return L1NOT1;
    }

    /**
     * @param L1NOT1 the L1NOT1 to set
     */
    public void setL1NOT1(int L1NOT1) {
        this.L1NOT1 = L1NOT1;
    }

    /**
     * @return the L1NOT2
     */
    public int getL1NOT2() {
        return L1NOT2;
    }

    /**
     * @param L1NOT2 the L1NOT2 to set
     */
    public void setL1NOT2(int L1NOT2) {
        this.L1NOT2 = L1NOT2;
    }

    /**
     * @return the L1NOT3
     */
    public int getL1NOT3() {
        return L1NOT3;
    }

    /**
     * @param L1NOT3 the L1NOT3 to set
     */
    public void setL1NOT3(int L1NOT3) {
        this.L1NOT3 = L1NOT3;
    }

    /**
     * @return the L2NOT1
     */
    public int getL2NOT1() {
        return L2NOT1;
    }

    /**
     * @param L2NOT1 the L2NOT1 to set
     */
    public void setL2NOT1(int L2NOT1) {
        this.L2NOT1 = L2NOT1;
    }

    /**
     * @return the L2NOT2
     */
    public int getL2NOT2() {
        return L2NOT2;
    }

    /**
     * @param L2NOT2 the L2NOT2 to set
     */
    public void setL2NOT2(int L2NOT2) {
        this.L2NOT2 = L2NOT2;
    }

    /**
     * @return the L2NOT3
     */
    public int getL2NOT3() {
        return L2NOT3;
    }

    /**
     * @param L2NOT3 the L2NOT3 to set
     */
    public void setL2NOT3(int L2NOT3) {
        this.L2NOT3 = L2NOT3;
    }

    /**
     * @return the L3NOT1
     */
    public int getL3NOT1() {
        return L3NOT1;
    }

    /**
     * @param L3NOT1 the L3NOT1 to set
     */
    public void setL3NOT1(int L3NOT1) {
        this.L3NOT1 = L3NOT1;
    }

    /**
     * @return the L3NOT2
     */
    public int getL3NOT2() {
        return L3NOT2;
    }

    /**
     * @param L3NOT2 the L3NOT2 to set
     */
    public void setL3NOT2(int L3NOT2) {
        this.L3NOT2 = L3NOT2;
    }

    /**
     * @return the L3NOT3
     */
    public int getL3NOT3() {
        return L3NOT3;
    }

    /**
     * @param L3NOT3 the L3NOT3 to set
     */
    public void setL3NOT3(int L3NOT3) {
        this.L3NOT3 = L3NOT3;
    }

    /**
     * @return the L1Result
     */
    public String getL1Result() {
        return L1Result;
    }

    /**
     * @param L1Result the L1Result to set
     */
    public void setL1Result(String L1Result) {
        this.L1Result = L1Result;
    }

    /**
     * @return the L2Result
     */
    public String getL2Result() {
        return L2Result;
    }

    /**
     * @param L2Result the L2Result to set
     */
    public void setL2Result(String L2Result) {
        this.L2Result = L2Result;
    }

    /**
     * @return the L3Result
     */
    public String getL3Result() {
        return L3Result;
    }

    /**
     * @param L3Result the L3Result to set
     */
    public void setL3Result(String L3Result) {
        this.L3Result = L3Result;
    }

    /**
     * @return the name
     */

    

    /**
     * @return the gender
     */
  
       
}
