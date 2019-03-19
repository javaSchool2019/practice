package training.endava.app.Hibernate.serviceHibernate;
import org.springframework.http.ResponseEntity;
import training.endava.app.Hibernate.domainHibernate.Address;
import training.endava.app.Hibernate.repositoryHibernate.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.endava.app.exception.PersonDoesntExistException;

import java.util.List;

@Service
public class AddressService {

@Autowired
public AddressRepository repo;
    public List<Address> getAllAddressFromDb(){
        return repo.getAllAddressFromDb();


    }
    public Address getAddressById(Integer intId){
        return repo.getAddressById(intId);

    }
    public void addAddressToDataBase(Address address){
        System.out.println("persServ"+address);
        repo.addAddressToDataBase(address);
    }
    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {

        return this.repo.delete(a);

    }
    public ResponseEntity updateAddress(Address address) throws PersonDoesntExistException{
        return repo.updateAddress(address);
    }

}
