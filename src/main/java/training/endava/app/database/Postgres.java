package training.endava.app.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Postgres {

    private static Connection instance;

    public static Connection getConnection () throws Exception{
        if(instance == null){
            instance = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "123456");
        }

        return instance;
    }
}
