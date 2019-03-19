package training.endava.app.hibernate.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import training.endava.app.hibernate.domain.PhoneNumber;
import training.endava.app.hibernate.repository.PhoneNumberRepo;

import java.util.List;


@RestController
public class PhoneNumberController {

    private PhoneNumberRepo phoneNumberRepo=new PhoneNumberRepo();

    @GetMapping(value="phonenumber/{id}")
    public PhoneNumber getById(@PathVariable(value = "id") Integer id) {
        return this.phoneNumberRepo.getById(id);
    }


    @GetMapping(value = "phonenumber/listAll", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<PhoneNumber> getAll() {
        List<PhoneNumber> phoneNumberList=this.phoneNumberRepo.getAll();
        return phoneNumberList;
    }


    @PostMapping(value = "phonenumber/insert")
    public @ResponseBody String add(@ModelAttribute PhoneNumber phoneNumber) {
        this.phoneNumberRepo.add(phoneNumber);
        return "HTTP POST was called";
    }


    @PutMapping(value = "phonenumber/update")
    public @ResponseBody String update(@ModelAttribute PhoneNumber phoneNumber) {
        this.phoneNumberRepo.update(phoneNumber);
        return "HTTP PUT was called";
    }


    @DeleteMapping(value="phonenumber/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        this.phoneNumberRepo.delete(id);
        return "HTTP DELETE was called!";
    }

}
