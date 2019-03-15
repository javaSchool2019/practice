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

import javax.swing.text.html.Option;

import static java.util.logging.Level.ALL;

@Repository
public class PersonRepository {

    //handler
   // private static final Logger LOGGER = Logger.getLogger(log.class.getName());
    private final String PERSONS = "\"Person\"";
    private final String ADDRESS = "\"Addess\"";
    private final String PhoneNumber = "\"PhoneNumber\"";


    public void getPhoneNumber(){
        try{

            Connection conn = Database.getInstance().connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + PhoneNumber);
            while (rs.next()) {

                String serviceProvider = rs.getString("service_provider");
                System.out.println(serviceProvider);
            }
            conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getPerson(){
        try{

        Connection conn = Database.getInstance().connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + PERSONS);
        while (rs.next()) {

            String lastName = rs.getString("name");
            Date birthdate = rs.getDate("birthday");
            String birthplace = rs.getString("birthplace");
            Integer id = rs.getInt("id");
            System.out.println(lastName + " " + birthdate + " " + birthplace + " " + id );
        }
            conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public long insertPerson(Person person) {
        String SQL = "INSERT INTO " +PERSONS+ "(birthplace, birthday, name, id)";
        long id = 0;
        try (Connection conn = Database.getInstance().connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, person.getBirthplace());
            pstmt.setDate(2, (Date) person.getBirthday());
            pstmt.setString(3, person.getName());
            pstmt.setInt(4, person.getId());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public void getPersonsBeforeNinety() {

        //for POSTMAN
        //List<Person> personListDB = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().connect();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM" + PERSONS + "WHERE birthday < '1990-01-01'");
            while (rs.next()) {
                String lastName = rs.getString("name");
                Date birthdate = rs.getDate("birthday");
                String birthplace = rs.getString("birthplace");
                Integer id = rs.getInt("id");

                System.out.println(lastName + " " + birthdate + " " + birthplace + " " + id + " ");

                //to use with POSTMAN, not in console...
                //Person personTest = new Person(id,lastName, birthdate, birthplace);
                //personListDB.add(personTest);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sameCityTheyWereBorn() {

        try {
            Connection conn = Database.getInstance().connect();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT p.name FROM" + PERSONS + "as p " +
                    "join " + ADDRESS + "as a " +
                    "on p.id=a.id where p.birthplace = a.city");
            while (rs.next()) {
                String lastName = rs.getString("name");
                System.out.println(lastName);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAddress(){
        try{

            Connection con = Database.getInstance().connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + ADDRESS);
            while (rs.next()) {

                String country = rs.getString("country");
                System.out.println(country);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findActorByID(int PersonID) {


        try (Connection conn = Database.getInstance().connect();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * "
                     + "FROM" + PERSONS
                     + "WHERE id = ?")) {

            pstmt.setInt(1, PersonID);
            ResultSet rs = pstmt.executeQuery();
            displayPerson(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void displayPerson(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t"
                    + rs.getString("name") + "\t"
                    + rs.getDate("birthday") + "\t"
                    + rs.getString("birthdate"));
        }



//    private List<Person> listOfPerson ;
//    public PersonRepository() {
//        listOfPerson = new ArrayList<>(Arrays.asList(new Person(1, "Person",,"Iasi"),
//                new Person(2, "Person", 1992,"Vs"), new Person(3, "Person",11.11.1991 ,"Trei")));
//    }
//    public List<Person> getPersons() {
//        return listOfPerson;
//    }
//    public void addPerson(Person person)
//    {
//        listOfPerson.add(person);
//    }
//
//    public Optional<Person> getPersonById (Integer id){
//        return this.getPersons().stream().filter(p->p.getId().equals(id)).findFirst();
//    }
//
//    public ResponseEntity updatePerson(Person person) {
//
//        Optional<Person> initialPerson =  this.getPersonById(person.getId());
//
//        if(initialPerson.isPresent()) {
//            this.listOfPerson.remove(initialPerson.get());
//            this.listOfPerson.add(person);
//            return ResponseEntity.ok(HttpStatus.OK);
//        }
//        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
//
//    }
//
//    public ResponseEntity delete(Integer a) {
//        Optional<Person> personOptional = getPersonById(a);
//
//        if (personOptional.isPresent()) {
//            this.listOfPerson.remove(personOptional.get());
//            return ResponseEntity.ok(HttpStatus.OK);
//        } else {
//            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
//
//        }

    }

}

