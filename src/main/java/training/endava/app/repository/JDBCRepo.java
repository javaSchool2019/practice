package training.endava.app.repository;

import training.endava.app.database.PostgreDB;
import training.endava.app.domain.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import static training.endava.app.logger.YellowPagesLogger.LOGGER;

public class JDBCRepo {

//    private static void printPersonsBornBefore1990() {
//        try (Connection connection = PostgreDB.getConnection()) {
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM persons WHERE extract(year from birthdate) < 1990";
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String birthplace = resultSet.getString("birthplace");
//                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
//                long address_id = resultSet.getLong("address_id");
//                System.out.println(new Person(id, name, birthdate, birthplace, address_id));
//            }
//        } catch (SQLException exception) {
//            LOGGER.warning("Error connecting to db" + exception);
//        }
//    }
//
//    private static void printPersonsLiveInTheSameCityTheyWereBorn() {
//        try (Connection connection = PostgreDB.getConnection()) {
//            Statement statement = connection.createStatement();
//            String query = "SELECT persons.id, name, birthplace, birthdate, address_id " +
//                    "FROM persons JOIN addresses ON persons.id = addresses.id WHERE birthplace = city";
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String birthplace = resultSet.getString("birthplace");
//                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
//                long address_id = resultSet.getLong("address_id");
//                System.out.println(new Person(id, name, birthdate, birthplace, address_id));
//            }
//        } catch (SQLException exception) {
//            LOGGER.warning("Error connecting to db" + exception);
//        }
//    }
//
//    public static void main(String[] args) {
//        printPersonsBornBefore1990();
//        printPersonsLiveInTheSameCityTheyWereBorn();
//    }

}
