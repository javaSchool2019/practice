package training.endava.app.Hibernate.controllerHibernate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.Hibernate.domainHibernate.PhoneNumber;
import training.endava.app.Hibernate.serviceHibernate.PhoneNumberService;


import java.util.List;

@RestController
@RequestMapping("/phone")

public class PhoneNumberController {
    private PhoneNumberService serv = new PhoneNumberService();

    @GetMapping(value = "/id={ID}")
    public ResponseEntity<PhoneNumber> getById (@PathVariable(value = "ID") Integer id){
        PhoneNumber response = serv.getById(id);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PhoneNumber>> all (){
        List <PhoneNumber> response = serv.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PhoneNumber> add (@RequestBody PhoneNumber entity){
        PhoneNumber response = serv.add(entity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody PhoneNumber entity){
        Boolean response = serv.update(entity);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping (value="/id={ID}")
    public ResponseEntity<Boolean> deleteById(@PathVariable(value = "ID") Integer id){
        Boolean response = serv.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
