package training.endava.app.Hibernate.serviceHibernate;

import training.endava.app.Hibernate.domainHibernate.Address;
import training.endava.app.Hibernate.repositoryHibernate.AddressRepository;

import java.util.List;

public class AddressService {

    private AddressRepository repo = new AddressRepository();

    public Address getById (int id){
        return repo.getById(id);
    }

    public List<Address> all (){
        return repo.all();
    }

    public Address add(Address entity){
        return repo.add(entity);
    }

    public boolean update (Address entity){
        return repo.update(entity);
    }

    public boolean deleteById (int id){
        return repo.deleteById(id);
    }

}
