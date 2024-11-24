/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConnection;
import dcm_2103.Control_Connector.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JESSA MARIE BEBITA
 */
public class Database {
    private static Connection connect;
    private static Database bcon;
    private static String url = "jdbc:mysql://localhost:3306/dcms";
    private static String user = "root";
    private static String password = "";
    
    private Database() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException ex) {
        }
        }
    public static Database getDatabase(){
        if (bcon == null) {
            try {        
                bcon = new Database();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public static Connection getConnection(){
        if (bcon == null) {
            getDatabase();
            
        }
        return connect;
    }
     
     }
      

