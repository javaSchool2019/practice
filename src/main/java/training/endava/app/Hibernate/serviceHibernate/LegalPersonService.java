package training.endava.app.Hibernate.serviceHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import training.endava.app.Hibernate.domainHibernate.LegalPerson;
import training.endava.app.Hibernate.repositoryHibernate.LegalPersonRepository;
import training.endava.app.exception.PersonDoesntExistException;

import java.util.List;

@Service
public class LegalPersonService {

    @Autowired
    private LegalPersonRepository repo;

    public List<LegalPerson> getAllLegalPersonFromDb(){
        return repo.getAllLegalPersonFromDb();


    }
   public LegalPerson getLegalPersonById(Integer intId){
        return repo.getLegalPersonById(intId);

   }
    public void addPersonToDataBase(LegalPerson legalPerson){
        System.out.println("persServ"+legalPerson);
        repo.addPersonToDatabase(legalPerson);
    }

    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {

        return this.repo.delete(a);

    }
    public ResponseEntity updatePerson(LegalPerson legalPerson) throws PersonDoesntExistException{
        return repo.updatePerson(legalPerson);
    }
}
