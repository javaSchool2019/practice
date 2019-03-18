package training.endava.app.Hibernate.serviceHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.Hibernate.domainHibernate.NeutralPerson;
import training.endava.app.Hibernate.repositoryHibernate.NeutralPersonRepository;

import java.util.List;

@Service
public class NeutralPersonService {
    @Autowired
    private NeutralPersonRepository repo;

    public List<NeutralPerson> getAllNeutralPersonFromDb(){
        return repo.getAllLegalPersonFromDb();


    }
}
