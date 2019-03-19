package training.endava.app.JPAContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import training.endava.app.JPAContext.JPAContextRepository.AddressRepository;
import training.endava.app.JPAContext.JPAdomain.Address;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    public AddressRepository addressRepository;


    @GetMapping("/address")
    public List<Address> getAllAddresses()
    {
        return this.addressRepository.findAll();
    }

    @GetMapping("/address2")
    public List<Address> getAllAddresses2()
    {
        return this.addressRepository.findAll2();
    }

    @PostMapping(path = "/address")
    public void addMember(@RequestBody Address address) {
        this.addressRepository.insertWithQuery(address);
    }

    @GetMapping("/address/{id}")
    public Address findAddressById(@PathVariable(value = "id") int id) {
        return this.addressRepository.findById(id);
    }

    @PutMapping("/address/")
    public void updateAddress(@RequestBody Address address){
        this.addressRepository.updateAddress(address);
    }

    @DeleteMapping("address/{id}")
    public void deleteAddressByID(@PathVariable(value = "id") int id){
        this.addressRepository.deleteAddress(id);
    }
}
