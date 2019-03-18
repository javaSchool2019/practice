package training.endava.app.Hibernate.repositoryHibernate;

import org.springframework.stereotype.Repository;
import training.endava.app.Hibernate.domainHibernate.NeutralPerson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NeutralPersonRepository {

    public List<NeutralPerson> getAllLegalPersonFromDb(){
       return null;

    }
}
