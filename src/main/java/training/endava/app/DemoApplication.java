package training.endava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import training.endava.app.repository.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);
    }

}
