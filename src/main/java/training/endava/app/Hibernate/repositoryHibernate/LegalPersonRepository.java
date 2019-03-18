package training.endava.app.Hibernate.repositoryHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import training.endava.app.Hibernate.domainHibernate.LegalPerson;
import training.endava.app.exception.PersonDoesntExistException;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LegalPersonRepository {



    public List<LegalPerson>getAllLegalPersonFromDb(){
       return null;


    }
   public LegalPerson getLegalPersonById(Integer intId){
       EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("entityManager");
       EntityManager entityManager=entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       LegalPerson legalPerson = entityManager.find(LegalPerson.class, intId);
       entityManager.close();
       System.out.println(legalPerson);
       return legalPerson;

   }

    public void addPersonToDatabase(LegalPerson legalPerson) {



    }


    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {



            return ResponseEntity.ok(HttpStatus.OK);


    }
    public ResponseEntity updatePerson(LegalPerson legalPerson) throws PersonDoesntExistException {

        return ResponseEntity.ok(HttpStatus.OK);
    }


}
