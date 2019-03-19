package training.endava.app.hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.exceptions.PersonNotFoundException;
import training.endava.app.hibernate.entities.Adresa;
import training.endava.app.hibernate.interfaces.ControllerInterface;
import training.endava.app.hibernate.repositories.AdresaRepository;
import training.endava.app.hibernate.services.AdresaService;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/adresa")
public class AdresaController{

    private AdresaService _service = new AdresaService();

    @GetMapping(value = "/id={ID}")
    public ResponseEntity<Adresa> getById(@PathVariable(value="ID") Integer id) {
        Adresa response = _service.getById(id);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/startsWith={ID}")
    public ResponseEntity<List<Adresa>> getByName(@PathVariable(value="ID") String id) {
        List<Adresa> response = _service.getAllByName(id);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/sortByLocalitate")
    public ResponseEntity<List<Adresa>> getAllSortByLocalitate() {
        List<Adresa> response = _service.getAllOrderByLocalitate();
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Adresa>> getAll() {
        List<Adresa> response = _service.getAll();
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Adresa> add(@RequestBody Adresa entity) {
        Adresa response = _service.add(entity);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody Adresa entity) {
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
