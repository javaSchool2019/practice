package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import training.endava.app.config.DatabaseConnection;
import training.endava.app.domain.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class AddressRepository {
    private DatabaseConnection db = DatabaseConnection.getInstance();

    public AddressRepository() throws SQLException {
    }

    public Optional<Address> findById(long id) {
        ResultSet rs = db.query("SELECT * FROM addresses where id =" + id);
        try {
            rs.next();
            Address address = new Address();
            address.setId(rs.getLong("id"));
            address.setCity(rs.getString("city"));
            address.setCountry(rs.getString("country"));
            address.setStreet(rs.getString("street"));
            rs.close();
            return Optional.of(address);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
