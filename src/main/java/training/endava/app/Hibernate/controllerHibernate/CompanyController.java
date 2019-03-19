package training.endava.app.Hibernate.controllerHibernate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.Hibernate.domainHibernate.Address;
import training.endava.app.Hibernate.domainHibernate.Company;
import training.endava.app.Hibernate.serviceHibernate.CompanyService;

import java.util.List;


public class CompanyController {
    private CompanyService serv = new CompanyService();
    @GetMapping(value = "/id={ID}")
    public ResponseEntity<Company> getById (@PathVariable(value="ID") Integer id){
        Company response = serv.getById(id);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Company>> all (){
        List<Company> response = serv.all();
        if(response != null)
            return new ResponseEntity<>(response,HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Company> add(@RequestBody Company entity){
        Company response = serv.add(entity);
        if(response != null)
            return new ResponseEntity<>(response,HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @PatchMapping
    public ResponseEntity<Boolean> update (@RequestBody Company entity){
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
