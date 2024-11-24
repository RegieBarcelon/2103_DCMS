package dcm_2103.Control_Connector;
import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnect {
    private static Connection connect;
    private static DBConnect dbconnect;
    private static String url= "jdbc:mysql://localhost:3306/dcms";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnect() {
        return connect;
    }

    public static void setConnect(Connection connect) {
        DBConnect.connect = connect;
    }

    public static DBConnect getDbconnect() {
        return dbconnect;
    }

    public static void setDbconnect(DBConnect dbconnect) {
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
        public static DBConnect getDBConnect(){
            if(dbconnect == null){
                dbconnect = new DBConnect();
            }
            return dbconnect;
        }
        
        public static Connection getConnection(){
            return connect;
            
            
        }
    
       
}