/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control_connector;
import java.sql.*;

public class datbaseconnection {
    private static Connection konek;
    private static datbaseconnection dbkon;
    
    
    
    private static String url = "jbdc:mysql://localhost:3306/dcbms";
    private static String user = "root";
    private static String password = "";
    public datbaseconnection(){
        konek = null;
        try {
            konek = DriverManager.getConnection(url, user, password);
            
        } 
        catch (Exception e) {
            
        }
        
  }
    public static getdatbaseconnection(){
            return dbkon;
        }
    public static Connection 
}

