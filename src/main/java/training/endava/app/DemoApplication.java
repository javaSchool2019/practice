package training.endava.app;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import training.endava.app.domain.hibernateObjects.PersonInfo;
import training.endava.app.repository.DataBaseConnection;
import training.endava.app.repository.HibernateConnection;
import training.endava.app.repository.HibernateDB;

import java.sql.*;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);
    }


}
