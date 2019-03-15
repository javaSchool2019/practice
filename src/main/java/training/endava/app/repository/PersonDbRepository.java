package training.endava.app.repository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import training.endava.app.Databases.PostgreDb;
import training.endava.app.domain.Person;
import training.endava.app.domain.PhoneNumber;
import training.endava.app.exceptions.BadRequestException;
import training.endava.app.exceptions.BaseException;
import training.endava.app.exceptions.PersonAlreadyExists;
import training.endava.app.exceptions.PersonNotFoundException;

import java.sql.*;
import java.util.*;
import java.sql.Date;

@Repository
public class PersonDbRepository {

    private Connection dbConnection = null;

    private final String ADRESSES = "\"Adresses\"";
    private final String PERSONS = "\"Persons\"";
    private final String PHONES = "\"PhoneNumbers\"";

    public PersonDbRepository(){
        dbConnection = PostgreDb.getInstance();
    }

    public Person getPersonById(Integer id){
        Person person = null;
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + PERSONS + " where id = "+id);
            while (rs.next()) {
                Integer myID = rs.getInt("id");
                Integer adressId = rs.getInt("adressId");
                String nume = rs.getString("name");
                String prenume = rs.getString("prenume");
                Date birthday = rs.getDate("birthday");
                person =  new Person(myID, nume, prenume, adressId, birthday);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public List<Person> getAllPersons(){
        List<Person> personList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + PERSONS);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer adressId = rs.getInt("adressId");
                String nume = rs.getString("name");
                String prenume = rs.getString("prenume");
                Date birthday = rs.getDate("birthday");
                personList.add(new Person(id, nume, prenume, adressId, birthday));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public HttpStatus addPerson(Person person){
        try {
            String insertTableSQL = "INSERT INTO "+ PERSONS + "(\"id\", \"name\", \"adressId\", \"prenume\", \"birthday\") VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setInt(3, person.getAdressId());
            preparedStatement.setString(4, person.getPrenume());
            preparedStatement.setDate(5,  person.getBirthday());
            preparedStatement.executeUpdate();
            return HttpStatus.OK;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersonAlreadyExists("Person already exists.");
        }
    }

    public HttpStatus updatePerson(Person person){
        try {
            String updatePersonSQL = "UPDATE "+ PERSONS + " SET \"name\" = ?, \"adressId\" = ?, \"prenume\" = ?, \"birthday\" = ? WHERE id = " + person.getId();

            PreparedStatement preparedStatement = dbConnection.prepareStatement(updatePersonSQL);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAdressId());
            preparedStatement.setString(3, person.getPrenume());
            preparedStatement.setDate(4,  person.getBirthday());
            preparedStatement.executeUpdate();
            return HttpStatus.OK;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersonNotFoundException("Person already exists.");
        }
    }

    public HttpStatus deletePersonById(Integer id){
        try {
            String deletePersonSql = "DELETE FROM "+ PERSONS + " WHERE id = " + id;

            Statement stmt = dbConnection.createStatement();
            stmt.execute(deletePersonSql);

            return HttpStatus.OK;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersonNotFoundException("Person already exists.");
        }
    }

    public List<Person> getAllPersonsBornBefore1990(){
        List<Person> personList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from " + PERSONS + " where birthday < '1990-01-01'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer adressId = rs.getInt("adressId");
                String nume = rs.getString("name");
                String prenume = rs.getString("prenume");
                Date birthday = rs.getDate("birthday");
                personList.add(new Person(id, nume, prenume, adressId, birthday));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public List<Person> getAllPersonsThatLiveOnTheSameCity(String city){
        List<Person> personList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from \"Persons\" p join \"Adresses\" a on p.\"adressId\" = a.\"id\" where a.\"oras\" = '" + city + "'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer adressId = rs.getInt("adressId");
                String nume = rs.getString("name");
                String prenume = rs.getString("prenume");
                Date birthday = rs.getDate("birthday");
                personList.add(new Person(id, nume, prenume, adressId, birthday));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public List<Person> getAllPersonsThatLiveOnTheSameTown(String localitate){
        List<Person> personList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from \"Persons\" p join \"Adresses\" a on p.\"adressId\" = a.\"id\" where a.\"localitate\" = '" + localitate + "'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer adressId = rs.getInt("adressId");
                String nume = rs.getString("name");
                String prenume = rs.getString("prenume");
                Date birthday = rs.getDate("birthday");
                personList.add(new Person(id, nume, prenume, adressId, birthday));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public List<Person> getAllPersonsThatHaveTheSamePhoneProvider(String provider){
        List<Person> personList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from \"Persons\" p join \"PhoneNumbers\" a on p.\"id\" = a.\"personId\" where a.\"provider\" = '" + provider + "'");
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer adressId = rs.getInt("adressId");
                String nume = rs.getString("name");
                String prenume = rs.getString("prenume");
                Date birthday = rs.getDate("birthday");
                personList.add(new Person(id, nume, prenume, adressId, birthday));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }
    public boolean updateAdressByPersonId(Integer clientId, String adresa, String localitate, String oras){
        try {
            String updatePersonSQL = "UPDATE \"Adresses\" a SET \"adresa\" = ?, \"localitate\" = ?, \"oras\" = ? where (select \"adressId\" from \"Persons\" p where p.\"id\" = "+clientId+" ) = a.\"id\"";

            PreparedStatement preparedStatement = dbConnection.prepareStatement(updatePersonSQL);
            preparedStatement.setString(1, adresa);
            preparedStatement.setString(2, localitate);
            preparedStatement.setString(3, oras);
            preparedStatement.executeUpdate();
            return  true;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }

    public boolean updatePhoneNumberByPersonId(Integer clientId, String phoneNumber, String provider){
        try {
            String updatePersonSQL = "UPDATE \"PhoneNumbers\" a SET \"phoneNumber\" = ?, \"provider\" = ? where  \"personId\" = " + clientId;

            PreparedStatement preparedStatement = dbConnection.prepareStatement(updatePersonSQL);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, provider);
            preparedStatement.executeUpdate();
            return  true;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }



    public boolean insertPhoneNumber(PhoneNumber number){
        try {
            String insertTableSQL = "INSERT INTO "+ PHONES + "(\"id\", \"phoneNumber\", \"provider\", \"personId\") VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, number.getId());
            preparedStatement.setString(2, number.getPhoneNumber());
            preparedStatement.setString(3, number.getProvider());
            preparedStatement.setInt(4,  number.getPersonId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
