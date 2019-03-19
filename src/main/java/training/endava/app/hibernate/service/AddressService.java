package training.endava.app.hibernate.service;

import training.endava.app.hibernate.domain.Address;
import java.util.List;

public interface AddressService {

    String add(Address address);
    Address getById(Integer id);
    List<Address> getAll();
    boolean update(Address address);
    boolean delete(Integer deleteId);

}

