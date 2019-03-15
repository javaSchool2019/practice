package training.endava.app.repository.repositorysql;

import training.endava.app.database.Postgres;
import training.endava.app.domain.sqldomain.AddressSql;
import training.endava.app.domain.sqldomain.PersonSql;
import training.endava.app.domain.sqldomain.PhoneNumberSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonRepository {
    public void add(PersonSql person) {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            String variables = "" + person.getName() + "," + person.getBirthDay() + "," + person.getBirthPlace() + "," + person.getId() + "," + person.getAddressId();
            stmt.executeQuery("INSERT INTO public.\"Person\"(\n" +
                    "\tname, birthdate, birthplace, id, address_id)\n" +
                    "\tVALUES (" + variables + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(PersonSql personSql) {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("UPDATE public.\"Person\"\n" +
                    "\tSET name=" + personSql.getName() + "," +
                    " birthdate=" + personSql.getBirthDay() + " , " +
                    "birthplace=" + personSql.getBirthPlace() + ", address_id=" + personSql.getAddressId() + "\n" +
                    "\tWHERE id=" + personSql.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void delete(PersonSql person) {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            AddressSqlRepository addressSqlRepository = new AddressSqlRepository();
            PhoneNumberSqlRepository phoneNumberSqlRepository = new PhoneNumberSqlRepository();
            phoneNumberSqlRepository.delete(person.getId());
            addressSqlRepository.delete(person.getAddressId());
            stmt.executeQuery("DELETE FROM public.\"Person\"\n" +
                    "\tWHERE id=" + person.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertAddressAndPhoneByPersonId(int personId, PhoneNumberSql phoneNumberSql, AddressSql addressSql) {
        AddressSqlRepository addressSqlRepository = new AddressSqlRepository();
        PhoneNumberSqlRepository phoneNumberSqlRepository = new PhoneNumberSqlRepository();

        phoneNumberSql.setPersonId(personId);
        addressSqlRepository.add(addressSql);
        phoneNumberSqlRepository.add(phoneNumberSql);
    }

    public void updateAddressAndPhoneByPersonId(int personId, PhoneNumberSql phoneNumberSql, AddressSql addressSql) {
        AddressSqlRepository addressSqlRepository = new AddressSqlRepository();
        PhoneNumberSqlRepository phoneNumberSqlRepository = new PhoneNumberSqlRepository();

        phoneNumberSql.setPersonId(personId);
        addressSqlRepository.update(addressSql);
        phoneNumberSqlRepository.update(phoneNumberSql);
    }

    public void getAllPersonsBefore1900(int age) {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT name, birthdate, birthplace, id, address_id from public.\"Person\" where extract(year from birthdate) >" + age);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getPeopleWithBirthPlaceEqualsWithAddressCity() {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT p1.name, p1.birthplace\n" +
                    "\tFROM public.\"Person\" as p1 join \"Address\" as ad on p1.addressid=ad.id where birthplace=ad.city");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + resultSet.getString("birthplace"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllPersonsWithSamePhoneServiceProvider(String serviceProvider) {
        try (Connection conn = Postgres.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from \"Person\" as p join \"PhoneNumber\" as pn" +
                    "on p.id = pn.person_id where pn.service_provider=" + serviceProvider);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getAllPersonsLiveOnTheSameCityAddressOrContry(String country, String city, String street) {
        try (Connection conn = Postgres.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from \"Person\" as p join \"Address\" as ad" +
                    "on p.address_id = ad.id where ad.city=" + country + "or ad.country=" + city + "or ad.street=" + street);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



