package training.endava.app.Hibernate.controllerHibernate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.Hibernate.domainHibernate.Address;
import training.endava.app.Hibernate.serviceHibernate.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")

public class AddressController {
    private AddressService serv = new AddressService();

    @GetMapping(value = "/id={ID}")
    public ResponseEntity<Address> getById (@PathVariable(value="ID") Integer id){
        Address response = serv.getById(id);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Address>> all (){
        List<Address> response = serv.all();
        if(response != null)
            return new ResponseEntity<>(response,HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Address> add(@RequestBody Address entity){
        Address response = serv.add(entity);
        if(response != null)
            return new ResponseEntity<>(response,HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @PatchMapping
    public ResponseEntity<Boolean> update (@RequestBody Address entity){
        Boolean response = serv.update(entity);
        if(response != null)
            return new ResponseEntity<>(response,HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping (value="/id={ID}")
    public ResponseEntity<Boolean> deleteById (@PathVariable(value="ID") Integer id ){
        Boolean response = serv.deleteById(id);
        if(response != null)
            return new ResponseEntity<>(response,HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
