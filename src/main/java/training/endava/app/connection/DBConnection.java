package training.endava.app.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:postgresql://localhost:5432/school" );
        config.setUsername( "postgres" );
        config.setPassword( "12345" );
        config.setMaximumPoolSize(2);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    protected DBConnection() {}

    public static Connection getConnection()  {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Connection dbContext = null;

    public static Connection getInstance(){
        if(dbContext!=null){
            return dbContext;
        }else{
            return getConnection();
        }
    }


}
