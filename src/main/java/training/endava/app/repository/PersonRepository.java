package training.endava.app.repository;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import training.endava.app.domain.Person;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.*;

@Repository
public class PersonRepository {

    private final LogManager logManager = LogManager.getLogManager();
    private final Logger LOGGER = Logger.getLogger("dbLogger");

    private Connection dbConnection;

    public PersonRepository() {
        try {
            dbConnection = DataBaseConnection.getConnection();

            FileHandler file = new FileHandler("./src/main/resources/loggerDB.log", true);
            file.setFormatter(new SimpleFormatter());
            file.setLevel(Level.INFO);

            Handler console = new ConsoleHandler();
            console.setLevel(Level.SEVERE);

            LOGGER.addHandler(file);
            LOGGER.addHandler(console);

        } catch (IOException exception) {
            exception.fillInStackTrace();
            LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
        }
    }

    public List<Person> getList() {
        LOGGER.info("GetAll from DB");
        List<Person> personsList = new ArrayList<>();
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "Select * from persons";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("person_id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("birthplace"),
                        rs.getInt("address_id"));
                personsList.add(person);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return personsList;
        }
    }

    public Optional<Person> getById(Integer id) {
        LOGGER.info("GetById from DB");
        Person person = null;
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "Select * from persons where person_id=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                person = new Person(
                        rs.getInt("person_id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("birthplace"),
                        rs.getInt("address_id"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Optional<Person> op = Optional.ofNullable(person);
            return op;
        }
    }

    public void add(Person person) {
        LOGGER.info("Add from DB");
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
        LOGGER.info("Update from DB");
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
        LOGGER.info("Delete from DB");
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
}