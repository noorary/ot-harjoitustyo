


/*


package moodtracker.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.List;
import moodtracker.domain.User;


public class DatabaseUserDao implements UserDao{
    

    
    
    
    
    public static void H2database() throws Exception {
    
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/moodtracker";
    
    static final String USER = "sa";
    static final String PASS = "";
        
        
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            System.out.println("Creating table in given database");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE Users"
                    + "(id INTEGER not null"
                    + "name VARCHAR(255)"
                    + "username VARCHAR(255)"
                    + "PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            
            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
}

*/


