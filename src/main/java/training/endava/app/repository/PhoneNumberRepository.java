package training.endava.app.repository;

import org.springframework.stereotype.Repository;
import training.endava.app.config.DatabaseConnection;
import training.endava.app.domain.PhoneNumber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PhoneNumberRepository {
    private DatabaseConnection db = DatabaseConnection.getInstance();

    public PhoneNumberRepository() throws SQLException {
    }

    public List<PhoneNumber> findByPersonId(long id) {
        ResultSet rs = db.query("SELECT * FROM phone_numbers where person_id =" + id);
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        try {
            while (rs.next()) {
                PhoneNumber phoneNumber = new PhoneNumber();
                phoneNumber.setId(rs.getLong("id"));
                phoneNumber.setNumber(rs.getString("number"));
                phoneNumber.setServiceProvider(rs.getString("service_provider"));
                phoneNumbers.add(phoneNumber);
            }
            rs.close();
            return phoneNumbers;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
