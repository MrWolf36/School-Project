/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kerem
 */
public class User {
    private int id;
    private String name;
    private String tcno;
  //  private String password;
    
    public User(){}
    
    public User(int id, String name, String tcno) {
        this.id = id;
        this.name = name;
        this.tcno = tcno;
      //  this.password = password;
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
     * @return the tcno
     */
    public String getTcno() {
        return tcno;
    }

    /**
     * @param tcno the tcno to set
     */
    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    /**
     * @return the password
     */
    //public String getPassword() {
    //    return password;
    //}

    /**
     * @param password the password to set
     */
    //public void setPassword(String password) {
    //    this.password = password;
   // }
}
