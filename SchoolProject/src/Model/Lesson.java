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


public class Lesson  {
    
private int id;
private String className;
private String lessonName;
private int quota;
private DBConnection conn=new DBConnection();
private Connection con=conn.connDB();
private Statement st=null;
private ResultSet rs=null;
private PreparedStatement pt=null;

public Lesson(){}

   public Lesson(int id, String lessonName, int quota,String className) {
        this.id = id;
        this.lessonName = lessonName;
        this.quota = quota;
        this.className=className;
    }
 
   
   public ArrayList<Lesson> getLessonList(){
     ArrayList<Lesson> list =new ArrayList<>();
        String query="SELECT * FROM lesson";
       Lesson lesson;
       try {
       
       
        st=con.createStatement();
        rs=st.executeQuery(query);
        while(rs.next()){
        lesson = new Lesson(rs.getInt("id"),rs.getString("lessonName"),rs.getInt("quota"),rs.getString("className"));  
        list.add(lesson);
    } }
       
       catch (SQLException ex) {
        Logger.getLogger(Lesson.class.getName()).log(Level.SEVERE, null, ex);
    }
      return list; 
   }
   
   public boolean addLesson(String lessonName,int quota,String className){
    String query="INSERT INTO lesson (lessonName,quota,className) VALUES (?,?,?) ";
        boolean key=false;
       try {
        st=con.createStatement();
        pt=con.prepareStatement(query);
        pt.setString(1, lessonName);
        pt.setInt(2, quota);
        pt.setString(3, className);
        pt.executeUpdate();
        key=true;
    } catch (SQLException ex) {
        Logger.getLogger(Lesson.class.getName()).log(Level.SEVERE, null, ex);
    }
       if(key)
           return true;
       else
           return false;
}
   
   public ArrayList<Lesson> getLessonList2(String lesName){
     ArrayList<Lesson> list =new ArrayList<>();
        String query="SELECT * FROM lesson WHERE lessonName='"+lesName+"'";
       Lesson lesson;
       try {
       
       
        st=con.createStatement();
        rs=st.executeQuery(query);
        while(rs.next()){
        lesson = new Lesson(rs.getInt("id"),rs.getString("lessonName"),rs.getInt("quota"),rs.getString("className"));  
        list.add(lesson);
    } }
       
       catch (SQLException ex) {
        Logger.getLogger(Lesson.class.getName()).log(Level.SEVERE, null, ex);
    }
      return list; 
   }

   public boolean delLesson(int id){
     String query="DELETE FROM lesson WHERE id=?";
        boolean key=false;
       
       try {
       
        st=con.createStatement();
        pt=con.prepareStatement(query);
        pt.setInt(1, id);
         pt.executeUpdate();
         key=true;
    } catch (SQLException ex) {
        Logger.getLogger(Lesson.class.getName()).log(Level.SEVERE, null, ex);
    }
       if(key)
           return true;
       else
           return false;
   }
   public boolean updateQuota(String lessonName,int quota){
       String query="UPDATE lesson SET quota=? WHERE lessonName=?";
       boolean key=false;
    try {
        st=con.createStatement();
         pt=con.prepareStatement(query);
         pt.setInt(1, quota);
         pt.setString(2, lessonName);
         pt.executeUpdate();
         key=true;
    } catch (SQLException ex) {
        Logger.getLogger(Lesson.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(key)
       return true;
    else 
        return false;
   }
   
    public boolean updateLesson(int id,String lessonName,int quota,String className){
    String query="UPDATE lesson SET lessonName=?, quota=?,className=? WHERE id=? ";
        boolean key=false;
        try {
        
        st=con.createStatement();
        pt=con.prepareStatement(query);
        pt.setString(1, lessonName);
        pt.setInt(2, quota);
        pt.setString(3, className);
        pt.setInt(4, id);
        pt.executeUpdate();
        key=true;
    } catch (SQLException ex) {
        Logger.getLogger(Lesson.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(key)
            return true;
        else 
            return false; 
    }
    
     public int getId() {
        return id;
    }
    

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lessonName
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * @param lessonName the lessonName to set
     */
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    /**
     * @return the quota
     */
    public int getQuota() {
        return quota;
    }

    /**
     * @param quota the quota to set
     */
    public void setQuota(int quota) {
        this.quota = quota;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }


}
