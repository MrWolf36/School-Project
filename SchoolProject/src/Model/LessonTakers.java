/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GUIs.LoginGUI;
import Helper.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kerem
 */
public class LessonTakers extends Student{

private DBConnection conn=new DBConnection();
private Connection con=conn.connDB();
private Statement st=null;
private ResultSet rs=null;
private PreparedStatement pt=null;
 
    private String name;
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
    
    
    public LessonTakers(){}
    public LessonTakers(int L1NOT1, int L1NOT2, int L1NOT3, int L2NOT1, int L2NOT2, int L2NOT3, int L3NOT1, int L3NOT2, int L3NOT3) {
       
        this.L1NOT1 = L1NOT1;
        this.L1NOT2 = L1NOT2;
        this.L1NOT3 = L1NOT3;
        this.L2NOT1 = L2NOT1;
        this.L2NOT2 = L2NOT2;
        this.L2NOT3 = L2NOT3;
        this.L3NOT1 = L3NOT1;
        this.L3NOT2 = L3NOT2;
        this.L3NOT3 = L3NOT3;
        
    }
      public LessonTakers(String name,int L1NOT1,int L1NOT2,int L1NOT3,String L1Result,int L2NOT1,int L2NOT2,int L2NOT3,String L2Result,int L3NOT1,int L3NOT2,int L3NOT3,String L3Result){
        this.name=name;
       this.L1NOT1=L1NOT1;
       this.L1NOT2=L1NOT2;
       this.L1NOT3=L1NOT3;
       this.L1Result=L1Result;
       
        this.L2NOT1=L2NOT1;
       this.L2NOT2=L2NOT2;
       this.L2NOT3=L2NOT3;
       this.L2Result=L2Result;
       
        this.L3NOT1=L3NOT1;
       this.L3NOT2=L3NOT2;
       this.L3NOT3=L3NOT3;
       this.L3Result=L3Result;
   }

    public LessonTakers(String L1Result, String L2Result, String L3Result) {
        this.L1Result = L1Result;
        this.L2Result = L2Result;
        this.L3Result = L3Result;
    }
    
  public ArrayList<LessonTakers> getExamList1(String branch){
      ArrayList<LessonTakers> list =new ArrayList<>();  
       LessonTakers obj;
        
    try {
        st=con.createStatement();//"SELECT*FROM student WHERE name='"+name+"'"
          rs=st.executeQuery("SELECT*FROM student WHERE L1='"+branch+"' AND L1='"+branch+"' OR L2='"+branch+"' AND L1='"+branch+"'OR L3='"+branch+"' AND L1='"+branch+"'");
       while(rs.next()){
        obj=new LessonTakers(rs.getString("name"),rs.getInt("L1NOT1"),rs.getInt("L1NOT2"),rs.getInt("L1NOT3"),rs.getString("L1Result"),rs.getInt("L2NOT1"),rs.getInt("L2NOT2"),rs.getInt("L2NOT3"),rs.getString("L2Result"),rs.getInt("L3NOT1"),rs.getInt("L3NOT2"),rs.getInt("L3NOT3"),rs.getString("L3Result"));
        list.add(obj);
       } 
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakers.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
     
    }
    public ArrayList<LessonTakers> getExamList2(String branch){
      ArrayList<LessonTakers> list =new ArrayList<>();  
       LessonTakers obj;
        
    try {
        st=con.createStatement();//"SELECT*FROM student WHERE name='"+name+"'"
          rs=st.executeQuery("SELECT*FROM student WHERE L1='"+branch+"' AND L2='"+branch+"' OR L2='"+branch+"' AND L2='"+branch+"'OR L3='"+branch+"' AND L2='"+branch+"'");
       while(rs.next()){
        obj=new LessonTakers(rs.getString("name"),rs.getInt("L1NOT1"),rs.getInt("L1NOT2"),rs.getInt("L1NOT3"),rs.getString("L1Result"),rs.getInt("L2NOT1"),rs.getInt("L2NOT2"),rs.getInt("L2NOT3"),rs.getString("L2Result"),rs.getInt("L3NOT1"),rs.getInt("L3NOT2"),rs.getInt("L3NOT3"),rs.getString("L3Result"));
        list.add(obj);
       } 
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakers.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
     
    }
    public ArrayList<LessonTakers> getExamList3(String branch){
      ArrayList<LessonTakers> list =new ArrayList<>();  
       LessonTakers obj;
        
    try {
        st=con.createStatement();//"SELECT*FROM student WHERE name='"+name+"'"
          rs=st.executeQuery("SELECT*FROM student WHERE L1='"+branch+"' AND L3='"+branch+"' OR L2='"+branch+"' AND L3='"+branch+"'OR L3='"+branch+"' AND L3='"+branch+"'");
       while(rs.next()){
        obj=new LessonTakers(rs.getString("name"),rs.getInt("L1NOT1"),rs.getInt("L1NOT2"),rs.getInt("L1NOT3"),rs.getString("L1Result"),rs.getInt("L2NOT1"),rs.getInt("L2NOT2"),rs.getInt("L2NOT3"),rs.getString("L2Result"),rs.getInt("L3NOT1"),rs.getInt("L3NOT2"),rs.getInt("L3NOT3"),rs.getString("L3Result"));
        list.add(obj);
       } 
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakers.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
     
    }
    
    
    
     public boolean updateLesson1Takers(String name,int L1NOT1,int L1NOT2,int L1NOT3,String L1Result){
  boolean key=false;
  
    try {
        st=con.createStatement();
        pt=con.prepareStatement("UPDATE student SET L1NOT1=?,L1NOT2=?,L1NOT3=?,L1Result=? WHERE name=?");
        pt.setInt(1, L1NOT1);
        pt.setInt(2, L1NOT2);
        pt.setInt(3, L1NOT3);
        pt.setString(4, L1Result);
        pt.setString(5, name);
        pt.executeUpdate();
        key=true;
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakers.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(key)
        return true;
    else
        return false;
    }

     
     
          public boolean updateLesson2Takers(String name,int L2NOT1,int L2NOT2,int L2NOT3,String L2Result){
  boolean key=false;
    try {
        st=con.createStatement();
        pt=con.prepareStatement("UPDATE student SET L2NOT1=?,L2NOT2=?,L2NOT3=?,L2Result=? WHERE name=?");
        pt.setInt(1, L2NOT1);
        pt.setInt(2, L2NOT2);
        pt.setInt(3, L2NOT3);
        pt.setString(4,L2Result);
        pt.setString(5, name);
        pt.executeUpdate();
        key=true;
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakers.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(key)
        return true;
    else
        return false;
    }
          
          
   public boolean updateLesson3Takers(String name,int L3NOT1,int L3NOT2,int L3NOT3,String L3Result){
  boolean key=false;
    try {
        st=con.createStatement();
        pt=con.prepareStatement("UPDATE student SET L3NOT1=?,L3NOT2=?,L3NOT3=?,L3Result=? WHERE name=?");
        pt.setInt(1, L3NOT1);
        pt.setInt(2, L3NOT2);
        pt.setInt(3, L3NOT3);
        pt.setString(4,L3Result);
        pt.setString(5,name);
        pt.executeUpdate();
        key=true;
    } catch (SQLException ex) {
        Logger.getLogger(LessonTakers.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(key)
        return true;
    else
        return false;
    }
   
   
    /**
     * @return the L1NOT1
     */
@Override
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
  
}
