package dbtest_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBase {

    public static void main(String[] args) {
        
        try{
        Connection conn = Connector.getConnection();
        
        //стейтмент - это объект который позволяет отправить запрос в базу данных.
        
        Statement stmt = conn.createStatement();
        //stmt.executeUpdate("INSERT INTO USERS (name,age) VALUES ('Oxana Ruzaeva', 35)");
        ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
        //ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name LIKE 'S%';");
        while(rs.next()){
            System.out.println("| " + rs.getInt("iduser") + " | " + rs.getString("name") + " I " + rs.getFloat("age") + " |"); 
        }
        conn.close();
        }catch(SQLException ex){
            System.out.println("DB Error : " + ex.getMessage());
        }
    }
}

