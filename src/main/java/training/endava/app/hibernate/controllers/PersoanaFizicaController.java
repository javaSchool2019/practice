package training.endava.app.hibernate.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.hibernate.entities.PersoanaFizica;
import training.endava.app.hibernate.services.PersoanaFizicaService;

import java.util.List;

@RestController
@RequestMapping("/persoana/fizica")
public class PersoanaFizicaController {

    private PersoanaFizicaService _service = new PersoanaFizicaService();

    @GetMapping(value = "/id={ID}")
    public ResponseEntity<PersoanaFizica> getById(@PathVariable(value="ID") Integer id) {
        PersoanaFizica response = _service.getById(id);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<PersoanaFizica>> getAll() {
        List<PersoanaFizica> response = _service.getAll();
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<PersoanaFizica> add(@RequestBody PersoanaFizica entity) {
        PersoanaFizica response = _service.add(entity);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody PersoanaFizica entity) {
        Boolean response = _service.update(entity);
        if(response){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/id={ID}")
    public ResponseEntity<Boolean> deleteById(@PathVariable(value="ID") Integer id) {
        Boolean response = _service.deleteById(id);
        if(response){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

}
