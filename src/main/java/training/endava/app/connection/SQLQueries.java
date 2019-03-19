package training.endava.app.connection;

import training.endava.app.domain.Person;
import training.endava.app.domain.PhoneNumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLQueries {

    private static final String sql_AddressTEST="Select * from AddressService";


    private static final String sqlAllPersonsBornBefore1990 = "select id, name,  birthday, birthplace, email from Person  where extract(year from birthday)<1990;";
    private static final String sqlAllPersonsLiveInTheSameCityTheyWereBorn="select  a.id, a.name,  a.birthday, a.birthplace, a.email from Person a\n" +
            "inner join AddressService b on a.id=b.personId\n" +
            "where b.city=a.birthplace;";



    //1. implement method for getting all the persons that are born before 1990

    public static List<Person> getListOfPersonsBornBefore1990(){
        List<Person> personList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlAllPersonsBornBefore1990))
        {

            while (rs.next()) {
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                String birthday=rs.getString("birthday");
                String birthplace=rs.getString("birthplace");
                String email=rs.getString("email");
                personList.add(new Person(id, name, birthday,birthplace,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }



    //2. implement method for getting all the persons live in the same city they were born

    public static List<Person> getListOfPersonsLiveInTheSameCityTheyWereBorn () {
        List<Person> personList=new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlAllPersonsLiveInTheSameCityTheyWereBorn))
        {

            while (rs.next()) {
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                String birthday=rs.getString("birthday");
                String birthplace=rs.getString("birthplace");
                String email=rs.getString("email");
                personList.add(new Person(id, name, birthday, birthplace,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }



    //3.1. implement method for getting all the persons live on the same country, city or street

    public static List<Person> getListOfPersonsThatLiveInTheSameCityAndCountry(String city, String country) {
        List<Person> personList=new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select  a.id, a.name,  a.birthday, a.birthplace, a.email from Person a\n" +
                     "inner join AddressService b on a.id=b.personId where b.city=" + "'" + city+ "'" + "and b.country='" +country+ "'" +";"))
        {

            while (rs.next()) {
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                String birthday=rs.getString("birthday");
                String birthplace=rs.getString("birthplace");
                String email=rs.getString("email");
                personList.add(new Person(id, name, birthday, birthplace,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }



//3.2. implement method for getting all the persons live on the same country, city or street

    public static List<Person> getListOfPersonsThatLiveInTheSameCityStreetAndCountry(String city, String country,String street) {
        List<Person> personList=new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select  a.id, a.name,  a.birthday, a.birthplace, a.email from Person a\n" +
                     "inner join AddressService b on a.id=b.personId where b.city=" + "'" + city+ "'" + "and b.country='" +country+ "'" + "and b.street='" +street+ "'" +";"))
        {

            while (rs.next()) {
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                String birthday=rs.getString("birthday");
                String birthplace=rs.getString("birthplace");
                String email=rs.getString("email");
                personList.add(new Person(id, name, birthday, birthplace,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }




    //4. implement method for getting all the persons that have the same Phone service provider

    public static List<Person> getListOfPersonsThatHaveSamePhoneServiceProvider (String provider) {
        List<Person> personList=new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select a.id, a.name,  a.birthday, a.birthplace, a.email from Person a\n" +
                     "inner join PhoneNumber b on a.id=b.personId where b.service_provider=" + "'" + provider + "'" +";"))
        {

            while (rs.next()) {
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                String birthday=rs.getString("birthday");
                String birthplace=rs.getString("birthplace");
                String email=rs.getString("email");
                personList.add(new Person(id, name, birthday, birthplace,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }




    //5. implement method for updating and inserting AddressService and PhoneNumber by Person's id


    public static boolean updateAddressByPersonId (String street, String city, Integer personId) {

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps= conn.prepareStatement("UPDATE AddressService\n" +
                     "SET street=? , city= ? where personId=" + "'" + personId  + "'" +";"))
        {
            int idx=0;
            ps.setString(++idx,street);
            ps.setString(++idx,city);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    public static boolean updatePhoneNumberByPersonId (String number, Integer personId,String serviceProvider) {

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps= conn.prepareStatement("UPDATE PhoneNumber\n" +
                     "SET number=?  where personId=" + personId + "and service_provider=" + "'" + serviceProvider + "'" +";"))
        {
            int idx=0;
            ps.setString(++idx,number);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    public static boolean insertPhoneNumber (PhoneNumber phoneNumber) {

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps= conn.prepareStatement("INSERT INTO PhoneNumber (id, personId, number, service_provider) " +
                     "VALUES (?,?,?,?);\n"))
        {
            int idx=0;
            ps.setInt(++idx,phoneNumber.getId());
            ps.setInt(++idx,phoneNumber.getPersonId());
            ps.setString(++idx,phoneNumber.getNumber());
            ps.setString(++idx,phoneNumber.getServiceProvider());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }




    public static void main(String[] args) {
        System.out.println("\n" + "All the persons that are born before 1990" + "\n" + getListOfPersonsBornBefore1990());
//        System.out.println("\n" + "All the persons live in the same city they were born" + "\n" + getListOfPersonsLiveInTheSameCityTheyWereBorn());
//        System.out.println("\n" + "All the persons live in the same city and country: "+ "\n" + getListOfPersonsThatLiveInTheSameCityAndCountry("Iasi","Romania"));
//        System.out.println("\n" + "All the persons live in the same city, street and country: "+ "\n" + getListOfPersonsThatLiveInTheSameCityStreetAndCountry("Iasi","Romania","street 2"));
//        System.out.println("\n" + "All the persons that have the same Phone service provider: "+ "\n" + getListOfPersonsThatHaveSamePhoneServiceProvider("provider 3"));
//        System.out.println(updateAddressByPersonId("\n" + "Update AddressService By Person Id:" + "street 3", "Timis",5));
//        System.out.println(updatePhoneNumberByPersonId("\n" + "Update Phone Number By Person Id:" + "0743335551",5,"provider 3"));


    }


}





