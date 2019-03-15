package training.endava.app.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import training.endava.app.config.DatabaseConnection;
import training.endava.app.domain.Person;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private DatabaseConnection db = DatabaseConnection.getInstance();
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public PersonRepository() throws SQLException {
    }

    public Optional<Person> findById(long id) {
        ResultSet rs = db.query("SELECT * FROM persons where id =" + id);
        try {
            rs.next();
            Person person = getPersonFromResultSet(rs);
            rs.close();
            return Optional.of(person);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public List<Person> findAll() throws SQLException {
        List<Person> persons = new ArrayList<>();
        ResultSet rs = db.query("SELECT * FROM persons");
        while (rs.next()) {
            persons.add(getPersonFromResultSet(rs));
        }
        rs.close();
        return persons;
    }

    public List<Person> findAllBornBefore1990() throws SQLException {
        List<Person> persons = new ArrayList<>();
        ResultSet rs = db.query("SELECT * from persons where birthday < '1990-01-01'");
        while (rs.next()) {
            persons.add(getPersonFromResultSet(rs));
        }
        rs.close();
        return persons;
    }

    public List<Person> findAllLivingInTheSameCityAsTheirBirthplace() throws SQLException {
        List<Person> persons = new ArrayList<>();
        ResultSet rs = db.query("SELECT * from persons p JOIN addresses a on p.address_id = a.id WHERE p.birthplace = a.city");
        while (rs.next()) {
            persons.add(getPersonFromResultSet(rs));
        }
        rs.close();
        return persons;
    }

    public List<Person> findAllLivingInTheSameCountry(String country) throws SQLException {
        List<Person> persons = new ArrayList<>();
        ResultSet rs = db.query("SELECT * from persons p JOIN addresses a on p.address_id = a.id  WHERE a.country ='" + country + "'");
        while (rs.next()) {
            persons.add(getPersonFromResultSet(rs));
        }
        rs.close();
        return persons;
    }

    public List<Person> findAllByPhoneServiceProvider(String serviceProvider) throws SQLException {
        List<Person> persons = new ArrayList<>();
        ResultSet rs = db.query("SELECT * from persons p join phone_numbers pn on p.id = pn.person_id where pn.service_provider ='"
                + serviceProvider + "'");
        while (rs.next()) {
            persons.add(getPersonFromResultSet(rs));
        }
        rs.close();
        return persons;
    }

    public void save(Person person) {
        try {
            final String insertSQL = "INSERT INTO persons(id, name, birthday, birthplace, address_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(insertSQL);
            preparedStatement.setLong(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setDate(3, (Date) person.getBirthday());
            preparedStatement.setString(4, person.getBirthplace());
            preparedStatement.setLong(5, person.getAddress().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Person already exists.");
        }
    }

    public void update(long id, Person person) {
    }

    public void delete(long id) {
    }

    private Person getPersonFromResultSet(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setName(rs.getString("name"));
        person.setBirthplace(rs.getString("birthplace"));
        person.setBirthday(rs.getDate("birthday"));
        person.setAddress(addressRepository.findById(rs.getLong("address_id")).get());
        person.setPhoneNumbers(phoneNumberRepository.findByPersonId(rs.getLong("id")));
        return person;
    }
}
