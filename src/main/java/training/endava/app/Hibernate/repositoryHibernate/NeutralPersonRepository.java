package training.endava.app.Hibernate.repositoryHibernate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import training.endava.app.Hibernate.EntManagerFact;
import training.endava.app.Hibernate.domainHibernate.NeutralPerson;
import training.endava.app.exception.PersonDoesntExistException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NeutralPersonRepository {
    private EntityManagerFactory emFact = EntManagerFact.getInstance();

    public List<NeutralPerson> getAllNeutralPersonFromDb() {

        EntityManager em = emFact.createEntityManager();

        TypedQuery<NeutralPerson> result = em.createQuery("select a from PersonH a", NeutralPerson.class);

        List<NeutralPerson> NeutralPersonList = result.getResultList();

        em.close();

        return NeutralPersonList;

    }

    public NeutralPerson getNeutralPersonById(Integer intId) {

        EntityManager em = emFact.createEntityManager();

        em.getTransaction().begin();

        NeutralPerson neutralPerson = em.find(NeutralPerson.class, intId);

        em.close();

        return neutralPerson;

    }

    public void addPersonToDatabase(NeutralPerson neutralPerson) {


        EntityManager em = emFact.createEntityManager();

        em.getTransaction().begin();

        em.persist(neutralPerson);

        em.getTransaction().commit();

        em.close();

    }

    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {

        try {

            EntityManager em = emFact.createEntityManager();
            NeutralPerson LegalPerson = getNeutralPersonById(a);
            em.getTransaction().begin();
            em.remove(LegalPerson);
            em.getTransaction().commit();
            em.close();
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {

            e.fillInStackTrace();
            return ResponseEntity.ok(HttpStatus.CONFLICT);


        }
    }




    public ResponseEntity updatePerson(NeutralPerson neutralPerson) throws PersonDoesntExistException {
        try {

            EntityManager em = emFact.createEntityManager();

            em.getTransaction().begin();

            em.merge(neutralPerson);

            em.getTransaction().commit();

            em.close();
            return ResponseEntity.ok(HttpStatus.OK);


        } catch (Exception e) {

            e.fillInStackTrace();
            return ResponseEntity.ok(HttpStatus.OK);


        }

    }
}