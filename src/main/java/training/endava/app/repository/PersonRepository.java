package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;
import training.endava.app.database.PostgreDB;
import training.endava.app.domain.Address;
import training.endava.app.domain.Person;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonAlreadyExistsExceptionChild;
import training.endava.app.logger.YellowPagesLogger;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static training.endava.app.logger.YellowPagesLogger.LOGGER;

@Repository
public class PersonRepository {

    public PersonRepository() {

    }

    public List<Person> getAll() {
        try (Connection connection = PostgreDB.getConnection()){
            List<Person> persons = new ArrayList<>();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM persons";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String birthplace = resultSet.getString("birthplace");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                long address_id = resultSet.getLong("address_id");
                persons.add(new Person(id, name, birthdate, birthplace, address_id));
            }
            return persons;
        }
        catch (SQLException exception){
            LOGGER.warning("Error connecting to db" + exception);
        }
        return null;
    }

    public void addPerson(Person person) {
        try (Connection conn = PostgreDB.getConnection()){
            String query = "INSERT INTO persons (id, name, birthdate, birthplace, address_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setDate(3, Date.valueOf(person.getBirthdate()));
            preparedStatement.setString(4, person.getBirthplace());
            preparedStatement.setLong(5, person.getAddress());
            preparedStatement.execute();
        }
        catch (SQLException exception){
            LOGGER.warning("Error connecting to db" + exception);
        }
        LOGGER.info("Person added in the database");
    }

    public void updatePerson(long id, Person person) {
        try (Connection conn = PostgreDB.getConnection()){
            String query = "UPDATE persons SET name = ?, birthdate = ?, birthplace = ?, address_id = ?" +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(5, id);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, Date.valueOf(person.getBirthdate()));
            preparedStatement.setString(3, person.getBirthplace());
            preparedStatement.setLong(4, person.getAddress());
            preparedStatement.execute();
        }
        catch (SQLException exception){
            LOGGER.warning("Error connecting to db" + exception);
        }
    }

    public void deletePerson(long id) {
        try (Connection conn = PostgreDB.getConnection()){
            String query = "DELETE FROM persons WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
        catch (SQLException exception){
            LOGGER.warning("Error connecting to db" + exception);
        }
    }
}
