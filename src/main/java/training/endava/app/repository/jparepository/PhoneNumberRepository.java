package training.endava.app.repository.jparepository;

import training.endava.app.domain.entity.PhoneNumber;

import java.util.List;

public interface PhoneNumberRepository {
    void add(PhoneNumber phoneNumber);
    void delete(PhoneNumber phoneNumber);
    PhoneNumber getById(Long id);
    List<PhoneNumber> getAll();
    void update (PhoneNumber phoneNumber);

}
