package training.endava.app.Hibernate.serviceHibernate;

import training.endava.app.Hibernate.domainHibernate.PhoneNumber;
import training.endava.app.Hibernate.repositoryHibernate.PhoneNumberRepository;

import java.util.List;

public class PhoneNumberService {
    private PhoneNumberRepository repo = new PhoneNumberRepository();

    public PhoneNumber getById(int id){

        return repo.getById(id);
    }
    public List<PhoneNumber> all(){

        return repo.all();
    }

    public PhoneNumber add (PhoneNumber entity){

        return repo.add(entity);
    }

    public Boolean update (PhoneNumber entity){

        return repo.update(entity);
    }

    public Boolean deleteById (int id){
        return repo.deleteById(id);
    }
}
