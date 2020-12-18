
package dbtest_1;

//класс соединятется с базой данных

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private final static String DB_PATH = "dbhere/";
    private final static String DB_NAME = "mydb";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "root";
    private static  Connection conn;
    
    //метод возвращающий соединение:
    public static Connection getConnection(){
        if(loadDriver()){
            String connStr = "jdbc:hsqldb:file:" + DB_PATH + DB_NAME;
            try{
                conn = DriverManager.getConnection(connStr, DB_USER, DB_PASS);
                System.out.println("Соединение cоздано");
            }catch(SQLException ex){
                System.out.println("Соединение не cоздано");
            }
        }else{
            conn = null;
        }
        return conn;
    }
    
    private static  boolean loadDriver(){
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println("Драйвер загружен");
            return true;
        } catch(ClassNotFoundException ex){
            System.out.println("драйвер не загружен");
            return false;
        }
    }
    
}
