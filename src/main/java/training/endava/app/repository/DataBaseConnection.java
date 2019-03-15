package training.endava.app.repository;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection(){
        final String url = "jdbc:postgresql://localhost:5432/myDataBase";
        final String user = "postgres";
        final String password = "admin";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e);
        }

        return connection;
    }
}
