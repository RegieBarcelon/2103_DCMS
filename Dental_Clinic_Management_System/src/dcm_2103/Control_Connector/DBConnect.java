/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dcm_2103.Control_Connector;
import java.sql.*;
/**
 *
 * @author JESSA MARIE BEBITA
 */
public class DBConnect {
     private static Connection connect;
    private static DBConnect dbconnect;
    
    private static String url= "jdbc:mysql://localhost:3306/dcms";
    private static String user = "root";
    private static String password = "";

      public static Connection getConnect() {
          return connect;
          
      }
       public static void setConnect(Connection connect){
           DBConnect.connect = connect;
       }
       public static DBConnect getDbconnect(){
           return dbconnect;
       }
           public static void setDbconnect(DBConnect dbconnect){
                DBConnect.dbconnect = dbconnect;
           }
           public DBConnect(){
        connect = null;
        try {
         connect = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
        }
        }
           

    public static DBConnect getDBConnect() {
        if (dbconnect == null) {
            dbconnect = new DBConnect();
        }
        return dbconnect;
    } 
    public static Connection getConnection(){
        return connect;
    }
     public static void main(String[] args) {
         Connection connection = DBConnect.getConnection();
         if (connection != null) {
             System.err.println("CONNECTION IS READY TO USE");
         } else {
             System.err.println("FAILED TO ESTABLISHED");
         }
     }
}

 
       
    
           

