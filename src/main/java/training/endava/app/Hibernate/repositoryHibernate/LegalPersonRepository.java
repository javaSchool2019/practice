package training.endava.app.Hibernate.repositoryHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import training.endava.app.Hibernate.EntManagerFact;
import training.endava.app.Hibernate.domainHibernate.LegalPerson;
import training.endava.app.exception.PersonDoesntExistException;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LegalPersonRepository {

    private EntityManagerFactory emFact = EntManagerFact.getInstance();

    public List<LegalPerson> getAllLegalPersonFromDb() {
        EntityManager em = emFact.createEntityManager();

        Query result = em.createNativeQuery("select a from person a", LegalPerson.class);

        List<LegalPerson> LegalPersonList = result.getResultList();

        em.close();

        return LegalPersonList;


    }

    public LegalPerson getLegalPersonById(Integer intId) {

        EntityManager em = emFact.createEntityManager();

        em.getTransaction().begin();

        LegalPerson legalPerson = em.find(LegalPerson.class, intId);

        em.close();

        return legalPerson;

    }


    public void addPersonToDatabase(LegalPerson legalPerson) {


        EntityManager em = emFact.createEntityManager();

        em.getTransaction().begin();

        em.persist(legalPerson);

        em.getTransaction().commit();

        em.close();

    }


    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {

        try {

            EntityManager em = emFact.createEntityManager();
            LegalPerson LegalPerson = getLegalPersonById(a);
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


    public ResponseEntity updatePerson(LegalPerson legalPerson) throws PersonDoesntExistException {
        try {

            EntityManager em = emFact.createEntityManager();

            em.getTransaction().begin();

            em.merge(legalPerson);

            em.getTransaction().commit();

            em.close();
            return ResponseEntity.ok(HttpStatus.OK);


        } catch (Exception e) {

            e.fillInStackTrace();
            return ResponseEntity.ok(HttpStatus.OK);


        }

    }


}
