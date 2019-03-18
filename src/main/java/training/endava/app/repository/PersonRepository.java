package training.endava.app.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import training.endava.app.domain.Person;
import training.endava.app.domain.PhoneNumber;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;

@Repository
public class PersonRepository {
    private final String PERSONS = "\"Person\"";
    private final String ADDRESS = "\"Address\"";
    private final String PHONE = "\"PhoneNumber\"";


    //CRUD OD DB


    public List<Person> getAllPersonsFromDb() {
        List<Person> DbPersonList = new ArrayList<>();

        try {

            Connection con = DatabaseConnection.getInstance().getConnection();
            System.out.println("Conn made it");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + PERSONS);

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nume = rs.getString("name");
                Date date = rs.getDate("birthday");
                String place=rs.getString("birthplace");
                Integer id_address = rs.getInt("id_address");
                Person pes = new Person(id, nume, date, place, id_address);
                DbPersonList.add(pes);

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        return DbPersonList;

    }


    public List<Person> getAllPersonsFromDbByAge() {

        List<Person> DbPersonList = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            System.out.println("Conn made it");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM" + PERSONS + "WHERE birthday < '1990-01-01'");
            while (rs.next()) {

                String lastName = rs.getString("name");
                System.out.println(lastName);
                Date date = rs.getDate("birthday");
                System.out.println(date);
                String place = rs.getString("birthplace");
                System.out.println(place);
                Integer id = rs.getInt("id");
                System.out.println(id);
                Integer id_address = rs.getInt("id_address");
                System.out.println(id_address);
                Person pes = new Person(id, lastName, date, place, id_address);
                DbPersonList.add(pes);

            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DbPersonList;

    }

    public List<Person> getAllPersonsFromDbByCountry() {
        List<Person> DbPersonList = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            System.out.println("Conn made it");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM " + PERSONS + " JOIN " + ADDRESS + " ON " + PERSONS + ".birthplace= " + ADDRESS + ".city");
            while (rs.next()) {
                String lastName = rs.getString("name");
                System.out.print(lastName + " ");
                Date date = rs.getDate("birthday");
                System.out.print(date + " ");
                String place = rs.getString("birthplace");
                System.out.print(place + " ");
                Integer id = rs.getInt("id");
                System.out.print(id + " ");
                Integer id_address = rs.getInt("id_address");
                System.out.print(id_address + " ");
                System.out.println();
                Person pes = new Person(id, lastName, date, place, id_address);
                DbPersonList.add(pes);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DbPersonList;

    }


    public void addPersonToDatabase(Person person) {
        try {
            java.util.Date utilDate = person.getBirthday();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Connection con = DatabaseConnection.getInstance().getConnection();
            System.out.println("add pers");
            String insertTableSQL = "INSERT INTO " + PERSONS + "(\"name\", \"birthday\", \"birthplace\", \"id\", \"id_address\") VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, person.getName());
            System.out.println(" add person : " + person.getName());
            preparedStatement.setDate(2, sqlDate);
            System.out.println(" add person : " + person.getBirthday());
            preparedStatement.setString(3, person.getBirthplace());
            preparedStatement.setInt(4, person.getId());
            preparedStatement.setInt(5, person.getId_address());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersonAlreadyExistsException("LegalPerson already exists.");
        }


    }

    public List<Person> getAllPersonWithSamePhoneProvider(String provider) {
        List<Person> DBPersonList = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + PERSONS + " pe join " + PHONE + " ph ON pe.id=ph.id_person WHERE ph.service_provider= '" + provider + "'");

            while (rs.next()) {
                String lastName = rs.getString("name");
                System.out.print(lastName + " ");
                Date date = rs.getDate("birthday");
                System.out.print(date + " ");
                String place = rs.getString("birthplace");
                System.out.print(place + " ");
                Integer id = rs.getInt("id");
                System.out.print(id + " ");
                Integer id_address = rs.getInt("id_address");
                System.out.print(id_address + " ");
                System.out.println();
                Person pes = new Person(id, lastName, date, place, id_address);
                DBPersonList.add(pes);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DBPersonList;
    }


    public List<Person> getAllPersonsFromSameCountryCityStreet(String city) {
        List<Person> DbPersonList = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getInstance().getConnection();
            System.out.println("Conn made it");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from \"LegalPerson\" p join \"Address\" a on p.\"id\" = a.\"id\" where a.\"city\" = '" + city + "'");
            while (rs.next()) {
                String lastName = rs.getString("name");
                System.out.println(lastName);
                Date date = rs.getDate("birthday");
                System.out.println(date);
                String place = rs.getString("birthplace");
                System.out.println(place);
                Integer id = rs.getInt("id");
                System.out.println(id);
                Integer id_address = rs.getInt("id_address");
                System.out.println(id_address);
                Person pes = new Person(id, lastName, date, place, id_address);
                DbPersonList.add(pes);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DbPersonList;

    }


    public boolean insertPhoneNumber(PhoneNumber number) {

        try {

            String insertTableSQL = "INSERT INTO " + PHONE + "(id, number, service_provider, id_person) VALUES (?,?,?,?)";

            Connection con = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, number.getId());

            preparedStatement.setString(2, number.getNumber());

            preparedStatement.setString(3, number.getProvider());

            preparedStatement.setInt(4, number.getPersonId());

            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }


    public boolean updatePhoneNrByPersId(Integer persId, String phoneNumber, String service_provider) {

        try {

            Connection con = DatabaseConnection.getInstance().getConnection();
            String sqlUpdate = "UPDATE " + PHONE + " SET number = ?, service_provider = ? where  id_person = " + persId;

            //UPDATE "PhoneNumber" SET number = '123123123', service_provider = 'vodaorange' WHERE  id_person= 1


            PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, service_provider);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return true;

    }


    //OLD CRUD


    private List<Person> listOfPerson;

    public PersonRepository() {

        listOfPerson = new ArrayList<>(Arrays.asList());
    }

    public List<Person> getPersons() {
        return listOfPerson;
    }


    public void addPerson(Person person) throws PersonDoesntExistException {
        if (!listOfPerson.stream().filter(p -> p.getId().equals(person.getId())).findFirst().isPresent()) {

            listOfPerson.add(person);
        } else throw new PersonAlreadyExistsException();
    }

    public Optional<Person> getPersonById(Integer id) {
        return this.getPersons().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    public ResponseEntity updatePerson(Person person) throws PersonDoesntExistException {

        Optional<Person> initialPerson = this.getPersonById(person.getId());

        if (initialPerson.isPresent()) {
            this.listOfPerson.remove(initialPerson.get());
            this.listOfPerson.add(person);
            return ResponseEntity.ok(HttpStatus.OK);
        } else throw new PersonDoesntExistException();
    }

    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {


        if (getPersonById(a).isPresent()) {
            this.listOfPerson.remove(getPersonById(a).get());
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            throw new PersonDoesntExistException();

        }

    }

}