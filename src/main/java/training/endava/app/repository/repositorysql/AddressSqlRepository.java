package training.endava.app.repository.repositorysql;

import training.endava.app.database.Postgres;
import training.endava.app.domain.sqldomain.AddressSql;

import java.sql.Connection;
import java.sql.Statement;

public class AddressSqlRepository {

    public void add(AddressSql addressSql){
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            String variables = ""+addressSql.getCountry()+","+addressSql.getCity()+","+addressSql.getStreet()+","+addressSql.getId();
            stmt.executeQuery("INSERT INTO public.\"Address\"(\n" +
                    "\tcountry, city, street, id)\n" +
                    "\tVALUES ("+ variables +")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM public.\"Address\"\n" +
                    "\tWHERE id="+id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(AddressSql addressSql){
        try (Connection conn = Postgres.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("UPDATE public.\"Address\"\n" +
                    "\tSET country="+addressSql.getCountry()+", city="+ addressSql.getCity()+ ", street="+addressSql.getStreet()+"\n" +
                    "\tWHERE id="+addressSql.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
