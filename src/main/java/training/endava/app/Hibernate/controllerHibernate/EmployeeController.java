package training.endava.app.Hibernate.controllerHibernate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.Hibernate.domainHibernate.Employee;
import training.endava.app.Hibernate.serviceHibernate.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    public EmployeeService serv = new EmployeeService();

    @GetMapping(value = "/id={ID}")
    public ResponseEntity <Employee> getById (@PathVariable(value = "ID") Integer id){
        Employee response = serv.getById(id);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> all (){
        List<Employee> response = serv.all();
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Employee> add (@RequestBody Employee entity){
        Employee response = serv.add(entity);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody Employee entity){
        Boolean response = serv.update(entity);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping (value="/id={ID}")
    public ResponseEntity<Boolean> deleteById(@PathVariable(value = "ID") Integer id){
        Boolean response = serv.deleteById(id);
        if(response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


}
