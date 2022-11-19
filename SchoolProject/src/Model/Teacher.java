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
public class Teacher extends User {
    private String branch;
    private String password;
    private String gender;
    private String type;

  
    private DBConnection conn=new DBConnection();
    private Connection con=conn.connDB();
    private Statement st=null;
    private ResultSet rs=null;
    private PreparedStatement pt=null;

    
    public Teacher(){}
    public Teacher( int id, String name, String tcno,String password,String branch,String gender,String type) {
        super(id, name, tcno);
        this.branch = branch;
        this.password=password;
        this.gender=gender;
        this.type=type;
    }

    
    public ArrayList<Teacher> getTeacherList(){
        ArrayList<Teacher> list=new ArrayList<>();
        Teacher obj;
        try {
            con=conn.connDB();
             st=con.createStatement();
            rs=st.executeQuery("SELECT*FROM teacher");
            while(rs.next()){
                obj=new Teacher(rs.getInt("id"),rs.getString("name"),rs.getString("tcno"),rs.getString("password"),rs.getString("branch"),rs.getString("gender"),rs.getString("type"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public boolean addTeacher(String name,String tcno,String password,String branch,String gender,String type){
        boolean key=false;
        String query="INSERT INTO teacher "+"(name,tcno,password,branch,gender,type)"+"VALUES"+"(?,?,?,?,?,?)";
        try {
            
            st=con.createStatement();
            pt=con.prepareStatement(query);
            pt.setString(1, name);
            pt.setString(2, tcno);
            pt.setString(3, password);
            pt.setString(4, branch);
           
            pt.setString(5, gender);
             pt.setString(6, type);
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
    public boolean delTeacher(int id){
         boolean key=false;
            String query="DELETE FROM teacher WHERE id=?";
        try {
           
            st=con.createStatement();
            pt=con.prepareStatement(query);
            pt.setInt(1, id);
            pt.executeUpdate();
            key=true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(key){
            return true;
            }
            else{
                 return false;      
                    }
         
        
    }
    public boolean updateTeacher(int id,String name,String tcno,String password,String branch){
        boolean key=false;
         String query="UPDATE teacher SET name=?,tcno=?,password=?,branch=? WHERE id=? ";
        try {
           
            st=con.createStatement();
            pt=con.prepareStatement(query);
            
            pt.setString(1, name);
            pt.setString(2, tcno);
            pt.setString(3, password);
            pt.setString(4, branch);
            pt.setInt(5, id);
            pt.executeUpdate();
            key=true;
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(key){
            return true;}
            else{
                    return false;
                    }
        
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
