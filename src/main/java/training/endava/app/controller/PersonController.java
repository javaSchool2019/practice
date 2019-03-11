package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.service.impl.PersonServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @GetMapping(value = "/all")
    public String getAll (){
        return "am returnat TOT!";
    }

    @GetMapping("/{id}")
    public Person findPersonById (@PathVariable(value = "id") Integer id){
        return this.personServiceImpl.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable(value = "id") Integer id){
        this.personServiceImpl.deleteById(id);
        return "HTTP DELETE was called!";
    }


    @PostMapping(value = "/insert")
    public @ResponseBody String insertPerson(@ModelAttribute Person person){
        System.out.println(person);
        return "HTTP POST was called";

    }

    @GetMapping(value = "/listAll")
    public List<Person> findAll(){
        return this.personServiceImpl.findAll();
    }




}
