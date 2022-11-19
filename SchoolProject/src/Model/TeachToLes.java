/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import GUIs.TeacherAssignmentI;
import Helper.DBConnection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kerem
 */
public class TeachToLes {
    private DBConnection conn=new DBConnection();
    private Connection con=conn.connDB();
    private Statement st=null;
    private ResultSet rs=null;
    private PreparedStatement pt=null;
  
    private int id;
    private String teacherName,lessonName,episode;

  public TeachToLes(int id,String episode,String teacherName, String lessonName) {
        this.id = id;
        this.teacherName = teacherName;
        this.lessonName = lessonName;
        this.episode = episode;
        
    }

    public TeachToLes() {
        
    }
    
      public ArrayList<TeachToLes> getTeachToLes(){
        TeachToLes obj;
        ArrayList<TeachToLes> list =new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM teachtoles");
            while(rs.next()){
               obj=new TeachToLes(rs.getInt("id"),rs.getString("episode"),rs.getString("lessonName"),rs.getString("teacherName"));  
            list.add(obj);
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAssignmentI.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list;
    }
    
    public boolean TeachToLesADD(String episode,String lessonName,String teacherName){
        boolean key=false;
        try {
            st=con.createStatement(); 
            pt=con.prepareStatement("INSERT INTO teachtoles(episode,lessonName,teacherName) VALUES (?,?,?)");
            pt.setString(1, episode);
            pt.setString(2, lessonName);
            pt.setString(3, teacherName);
          
            pt.executeUpdate();
            key=true;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAssignmentI.class.getName()).log(Level.SEVERE, null, ex);
        }
      if(key)
          return true;
      else
          return false;
    }
    public boolean TeachToLesDEL(int id){
        boolean key=false;
        try {
            st=con.createStatement();
             pt=con.prepareStatement("DELETE FROM teachtoles WHERE id=?");
             pt.setInt(1, id);
             pt.executeUpdate();
             key=true;
        } catch (SQLException ex) {
            Logger.getLogger(TeachToLes.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(key)
           return true;
       else
           return false;
    }

    /**
     * @return the id
     */
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
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
     * @return the episode
     */
    public String getEpisode() {
        return episode;
    }

    /**
     * @param episode the episode to set
     */
    public void setEpisode(String episode) {
        this.episode = episode;
    }

    /**
     * @return the quota
     */
 

    /**
     * @param quota the quota to set
     */
  
}