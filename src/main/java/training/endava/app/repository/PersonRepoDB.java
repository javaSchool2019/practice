//package training.endava.app.repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import training.endava.app.connection.DBConnection;
//import training.endava.app.domain.Person;
//import training.endava.app.exceptions.PersonIdAlreadyExistException;
//import training.endava.app.exceptions.PersonIdNotExistException;
//
//public class PersonRepoDB {
//
//    private Connection conn = null;
//
//    public PersonRepoDB(){
//        conn = DBConnection.getInstance();
//    }
//
//    public Person getPersonById(Integer id){
//        Person person=null;
//        try (
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("Select * from Person where id=" + "'" + id + "'" +";"))
//        {
//
//            while (rs.next()) {
//                Integer personId=rs.getInt("id");
//                String name=rs.getString("name");
//                String birthday=rs.getString("birthday");
//                String birthplace=rs.getString("birthplace");
//                String email=rs.getString("email");
//                person=(new Person(personId, name, birthday,birthplace,email));
//                return person;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new PersonIdNotExistException(id);
//        }
//        return person;
//    }
//
//
//    public List<Person> findAllPersons(){
//        List<Person> personList=new ArrayList<>();
//
//        try (
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("Select * from Person;"))
//        {
//
//            while (rs.next()) {
//                Integer personId=rs.getInt("id");
//                String name=rs.getString("name");
//                String birthday=rs.getString("birthday");
//                String birthplace=rs.getString("birthplace");
//                String email=rs.getString("email");
//                personList.add(new Person(personId, name, birthday,birthplace,email));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return personList;
//    }
//
//
//
//    public Person addPerson (Person person) {
//        try (
//                PreparedStatement ps= conn.prepareStatement("INSERT INTO Person (id, name, birthday, birthplace, email) VALUES (?, ?,?,?, ?');\n"))
//        {
//            int idx=0;
//            ps.setInt(++idx,person.getId());
//            ps.setString(++idx,person.getName());
//            ps.setString(++idx,person.getBirthday());
//            ps.setString(++idx,person.getBirthplace());
//            ps.setString(++idx,person.getEmail());
//            ps.executeUpdate();
//            return person;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new PersonIdAlreadyExistException(person.getId());
//        }
//    }
//
//
//    public void removePerson(Integer id){
//        try {
//            Connection conn = DBConnection.getConnection();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("delete from person where id=" + "'" + id + "'" + ";");
//        }  catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public Person updatePerson(Person person){
//
//        try (
//                PreparedStatement ps= conn.prepareStatement("UPDATE Person\n" +
//                        "SET name=?, birthday=?, birthplace=?, email=?  where id=" + "'" + person.getId()  + "'" +";"))
//        {
//            int idx=0;
//            ps.setString(++idx,person.getName());
//            ps.setString(++idx,person.getBirthday());
//            ps.setString(++idx,person.getBirthplace());
//            ps.setString(++idx,person.getEmail());
//            ps.executeUpdate();
//            return person;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new PersonIdNotExistException(person.getId());
//        }
//
//    }
//
//
//}
