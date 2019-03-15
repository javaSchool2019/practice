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

    public void add(Person person) {

        String SQL = "INSERT INTO persons(person_id,name,birthday,birthplace,address_id) "
                + "VALUES(?,?,?,?,?)";
        System.out.println(person.getBirthday().getClass());
        try (
                PreparedStatement statement = dbConnection.prepareStatement(SQL)) {
            statement.setInt(1, person.getPerson_id());
            statement.setString(2, person.getName());
            statement.setDate(3, person.getBirthday());
            statement.setString(4, person.getBirthplace());
            statement.setInt(5, person.getAddress_id());

            statement.executeUpdate();
        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Person person, Integer i) {

        String SQL = "UPDATE persons set name = ? ,birthday = ? ,birthplace = ? ,address_id = ? where person_id = ?";
        System.out.println(person.getBirthday().getClass());
        try (
                PreparedStatement statement = dbConnection.prepareStatement(SQL)) {
            statement.setInt(5, person.getPerson_id());
            statement.setString(1, person.getName());
            statement.setDate(2, person.getBirthday());
            statement.setString(3, person.getBirthplace());
            statement.setInt(4, person.getAddress_id());

            statement.executeUpdate();
        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Integer personId) {

        String SQL = "DELETE FROM persons WHERE person_id = ?";
        try (
                PreparedStatement statement = dbConnection.prepareStatement(SQL)) {
            statement.setInt(1, personId);

            statement.executeUpdate();
        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        DBExercises exercises = new DBExercises();
    }
}
