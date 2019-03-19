package training.endava.app.hibernate.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import training.endava.app.hibernate.domain.Address;
import training.endava.app.hibernate.service.impl.AddressServiceImpl;

import java.util.List;


@RestController
public class AddressController {

    private AddressServiceImpl addressService=new AddressServiceImpl();

    @GetMapping(value="address/{id}")
    public Address getById(@PathVariable(value = "id") Integer id) {
        return this.addressService.getById(id);
    }


    @GetMapping(value = "address/listAll", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Address> getAll() {
        List<Address> addressList=this.addressService.getAll();
        return addressList;
    }


    @PostMapping(value = "address/insert")
    public @ResponseBody String add(@ModelAttribute Address address) {
        this.addressService.add(address);
        return "HTTP POST was called";
    }


    @PutMapping(value = "address/update")
    public @ResponseBody String update(@ModelAttribute Address address) {
            this.addressService.update(address);
            return "HTTP PUT was called";
    }


    @DeleteMapping(value="address/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        this.addressService.delete(id);
        return "HTTP DELETE was called!";
    }


}
