/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author t-bye-
 */
public class MyConnection {
    Connection conn=null;
    public static Connection ConnectDB(){
        try{
         
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/wqmd","root","");
            
            
            return conn;
            
        }
       catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
           return null;
    }
       }
}
