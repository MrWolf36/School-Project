/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.sql.*;
/**
 *
 * @author Kerem
 */
public class OptionPane {
    private DBConnection conn=new DBConnection();
    private Connection con=conn.connDB();
    private Statement st=null;
    private ResultSet rs=null;
    private PreparedStatement pt=null;
    public static void OptionPaneChangeButton(){
        UIManager.put("OptionPane.cancelButtonText", "İptal");
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }
    
    public static void showMessage(String str){
        OptionPaneChangeButton();
        String warning;
        String msg;
        
        switch(str){
            case "fill":
            msg="Lütfen Tüm Alanları Doldurunuz";
            warning="DİKKAT!";
            break;
            case "success":
            msg="İşlem Başarı İle Gerçekleşti";
            warning="BAŞARILI!";
            break;
            case "error":
                msg="Bir Hata Oluştu";
                warning="HATA!";
                break;
            case "wrongPassword":
                msg="T.C. Numarası veya Şifre Hatalı";
                warning="HATALI GİRİŞ!";
                break;
        
                          
            default:
                msg=str;
                warning=str;
                
        }
        JOptionPane.showMessageDialog(null, msg,warning,JOptionPane.WARNING_MESSAGE);
    }
    
    public static boolean showConfirm(String str){
        String msg;
        switch(str){
            case "sure":
                msg="Bu İşlemi Yapmak İstiyormusun?";
                break;
            default:
                msg=str;
                break;
        }
           int res=JOptionPane.showConfirmDialog(null, msg,"DİKKAT!",JOptionPane.YES_NO_OPTION);
        if(res==0){
            return true;}
        else{
            return false;}
       
        }
    
    }
      

