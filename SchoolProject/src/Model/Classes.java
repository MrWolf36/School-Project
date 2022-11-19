/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class Classes {
    private int id;
    private String ClassName;
      private DBConnection conn=new DBConnection();
    private Connection con=conn.connDB();
    private Statement st=null;
    private ResultSet rs=null;
    private PreparedStatement pt=null;
    
    
    public Classes(){}

    public Classes(int id, String ClassName) {
        this.id = id;
        this.ClassName = ClassName;
    }
    
    public ArrayList<Classes> getClassesList(){
         ArrayList<Classes> list =new ArrayList<>();
         Classes obj;
        try {
           
            st=con.createStatement();
            rs=st.executeQuery("SELECT*FROM classes");
            while(rs.next()){
             obj=new Classes(rs.getInt("id"),rs.getString("className"));
             list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
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
     * @return the ClassName
     */
    public String getClassName() {
        return ClassName;
    }

    /**
     * @param ClassName the ClassName to set
     */
    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }
}

