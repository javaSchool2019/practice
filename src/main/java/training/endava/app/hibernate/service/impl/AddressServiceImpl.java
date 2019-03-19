package training.endava.app.hibernate.service.impl;

import training.endava.app.hibernate.domain.Address;
import training.endava.app.hibernate.repository.AddressRepo;
import training.endava.app.hibernate.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressRepo addressRepo = new AddressRepo();

    @Override
    public Address getById(Integer id) {
        return this.addressRepo.getById(id);
    }

    @Override
    public List<Address> getAll () {
        return this.addressRepo.getAll();
    }

    @Override
    public boolean update(Address address) {
        return this.addressRepo.update(address);
    }

    @Override
    public boolean delete(Integer deleteId) {
        return this.addressRepo.delete(deleteId);
    }

    @Override
    public String add(Address address) {
        return this.addressRepo.add(address);
    }

}
