package training.endava.app.repository;

import org.springframework.boot.SpringApplication;
import training.endava.app.DemoApplication;
import training.endava.app.domain.Person;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.*;

public class DBExercises {
    private Connection dbConnection;

    public DBExercises() {
        dbConnection = DataBaseConnection.getConnection();
//        firstEx();
//        secondEx();
//        thirdEx();

    }

    public void firstEx() {

        try {
            String date = "1990-01-01";
            String sql = "Select * from persons where birthday < to_date('" + date + "','YYYY-MM-DD')";

            Statement statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Perons id: " + rs.getInt("person_id"));
                System.out.println("\t" + rs.getString("name"));
                System.out.println("\t" + rs.getDate("birthday"));
                System.out.println("\t" + rs.getString("birthplace"));
                System.out.println("\t" + rs.getInt("address_id"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void secondEx() {

        try {
            String sql = "Select * from persons p join address a on a.address_id = p.address_id where a.city = p.birthplace";

            Statement statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Perons id: " + rs.getInt("person_id"));
                System.out.println("\t" + rs.getString("name"));
                System.out.println("\t" + rs.getDate("birthday"));
                System.out.println("\t" + rs.getString("birthplace"));
                System.out.println("\t" + rs.getInt("address_id"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void thirdEx() {

        try {
            String sql;
            sql = "Select * from persons p1 " +
                    "join address a1 on a1.address_id = p1.address_id " +
                    "join address a2 on a2.address_id <> a1.address_id " +
                    "join persons p2 on a2.address_id = p2.address_id " +
                    "where p2.person_id != p1.person_id " +
                    "and a2.city = a1.city " +
                    "and a2.country = a1.country " +
                    "and a2.street = a1.street";

            Statement statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Perons id: " + rs.getInt("person_id"));
                System.out.println("\t" + rs.getString("name"));
                System.out.println("\t" + rs.getDate("birthday"));
                System.out.println("\t" + rs.getString("birthplace"));
                System.out.println("\t" + rs.getInt("address_id"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
