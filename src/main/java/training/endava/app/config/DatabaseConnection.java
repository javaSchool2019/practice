package training.endava.app.config;

import java.sql.*;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            LOGGER.severe("Database connection creation failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    /**
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet query(String query) {
        try {
            Statement statement = instance.connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
            return null;
        }
    }
}
