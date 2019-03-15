package training.endava.app.connection;

import training.endava.app.domain.Address;
import training.endava.app.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLData {

    private static final String sql_AddressTEST="Select * from Address";

    private static final String sqlAllPersonsBornBefore1990="select a.id, a.name,  a.birthday, a.birthplace, a.email, b.number, c.country, c.city, c.street from Person a\n" +
            "inner join PhoneNumber b on a.id=b.personId\n" +
            "inner join Address c on a.address_id=c.id\n" +
            "where extract(year from a.birthday)<1990;\n";

    private static final String sqlAllPersonsLiveInTheSameCityTheyWereBorn="select  a.id, a.name,  a.birthday, a.birthplace, a.email, b.number, c.country, c.city, c.street from Person a\n" +
            "inner join PhoneNumber b on a.id=b.personId\n" +
            "inner join Address c on a.address_id=c.id\n" +
            "where c.city=a.birthplace;";



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
                String number=rs.getString("number");
                String country=rs.getString("country");
                String city=rs.getString("city");
                String street=rs.getString("street");
                personList.add(new Person(id,name,email,number,new Address(country,city,street), birthday,birthplace));
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
                String number=rs.getString("number");
                String country=rs.getString("country");
                String city=rs.getString("city");
                String street=rs.getString("street");
                personList.add(new Person(id,name,email,number,new Address(country,city,street), birthday,birthplace));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }


    //3. implement method for getting all the persons live on the same country, city or street




    //4. implement method for getting all the persons that have the same Phone service provider

    public static List<Person> getListOfPersonsThatHaveSamePhoneServiceProvider (String provider) {
        String sqlAllPersonsThatHaveTheSamePhoneServiceProvider="select a.id, a.name,  a.birthday, a.birthplace, a.email, b.number, c.country, c.city, c.street from Person a\n" +
                "inner join PhoneNumber b on a.id=b.personId\n" +
                "inner join Address c on a.address_id=c.id\n" +
                "where b.service_provider=" + "'"+ provider+ "'";

        List<Person> personList=new ArrayList<>();

        return personList;
    }



    //5. implement method for updating and inserting Address and PhoneNumber by Person's id
















    public static List<Address> getListOfAddressesFromDB() {
        List<Address> addressList = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql_AddressTEST))
        {

            while (rs.next()) {
                addressList.add(new Address(
                        rs.getInt("id"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("street")));
              }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressList;
    }



    public static void main(String[] args) {
//        System.out.println(getListOfPersonsLiveInTheSameCityTheyWereBorn());
        System.out.println(getListOfPersonsThatHaveSamePhoneServiceProvider("provider 3"));
    }


}










