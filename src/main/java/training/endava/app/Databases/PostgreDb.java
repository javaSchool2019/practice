package training.endava.app.Databases;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreDb {

    private static Connection dbContext = null;

    public static Connection getInstance(){
        if(dbContext!=null){
            return dbContext;
        }else{
            return getConnexion();
        }
    }
    private static Connection getConnexion(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/javaSchoolDB","postgres", "admin");
            dbContext = connection;
            return connection;
            }
        catch (Exception e){
            e.fillInStackTrace();
            return null;
        }
    }

}
