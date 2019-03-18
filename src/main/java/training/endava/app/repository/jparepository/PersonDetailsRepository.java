package training.endava.app.repository.jparepository;

import training.endava.app.domain.entity.PersonDetails;
import training.endava.app.domain.entity.PhoneNumber;

import java.util.List;

public interface PersonDetailsRepository {
    void add(PersonDetails personDetails);
    void delete(PersonDetails personDetails);
    PersonDetails getById(Long id);
    List<PersonDetails> getAll();
    void update (PersonDetails personDetails);

}
