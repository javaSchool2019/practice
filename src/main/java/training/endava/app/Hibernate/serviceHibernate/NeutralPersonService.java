package training.endava.app.Hibernate.serviceHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import training.endava.app.Hibernate.domainHibernate.NeutralPerson;
import training.endava.app.Hibernate.repositoryHibernate.NeutralPersonRepository;
import training.endava.app.exception.PersonDoesntExistException;

import java.util.List;

@Service
public class NeutralPersonService {
    @Autowired
    private NeutralPersonRepository repo;

    public List<NeutralPerson> getAllNeutralPersonFromDb(){
        return repo.getAllNeutralPersonFromDb();


    }
    public NeutralPerson getNeutralPersonById(Integer intId){
        return repo.getNeutralPersonById(intId);

    }
    public void addPersonToDataBase(NeutralPerson neutralPerson){
        System.out.println("persServ"+neutralPerson);
        repo.addPersonToDatabase(neutralPerson);
    }

    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {

        return this.repo.delete(a);

    }
    public ResponseEntity updatePerson(NeutralPerson neutralPerson) throws PersonDoesntExistException{
        return repo.updatePerson(neutralPerson);
    }

}
