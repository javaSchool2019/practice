package training.endava.app.repository.repositorysql;

import training.endava.app.database.Postgres;
import training.endava.app.domain.sqldomain.PhoneNumberSql;

import java.sql.Connection;
import java.sql.Statement;

public class PhoneNumberSqlRepository {

    public void add(PhoneNumberSql phoneNumberSql) {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            String variables = "" + phoneNumberSql.getNumber() + "," + phoneNumberSql.getServiceProvider() + "," + phoneNumberSql.getId() + "," + phoneNumberSql.getPersonId();
            stmt.executeQuery("INSERT INTO public.\"PhoneNumber\"(\n" +
                    "\t\"number\", service_provider, id, person_id)\n" +
                    "\tVALUES (" + variables + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(PhoneNumberSql phoneNumber) {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("UPDATE public.\"PhoneNumber\"\n" +
                    "\tSET \"number\"=" + phoneNumber.getNumber() + ", service_provider=" + phoneNumber.getServiceProvider() + ",person_id=" + phoneNumber.getPersonId() + "\n" +
                    "\tWHERE id=" + phoneNumber.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM public.\"PhoneNumber\"\n" +
                    "\tWHERE id=" + id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
