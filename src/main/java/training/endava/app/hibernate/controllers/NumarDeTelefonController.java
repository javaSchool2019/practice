package training.endava.app.hibernate.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.hibernate.entities.NumarDeTelefon;
import training.endava.app.hibernate.services.NumarDeTelefonService;

import java.util.List;

@RestController
@RequestMapping("/telefon")
public class NumarDeTelefonController {

    private NumarDeTelefonService _service = new NumarDeTelefonService();

    @GetMapping(value = "/id={ID}")
    public ResponseEntity<NumarDeTelefon> getById(@PathVariable(value="ID") Integer id) {
        NumarDeTelefon response = _service.getById(id);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<NumarDeTelefon>> getAll() {
        List<NumarDeTelefon> response = _service.getAll();
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<NumarDeTelefon> add(@RequestBody NumarDeTelefon entity) {
        NumarDeTelefon response = _service.add(entity);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody NumarDeTelefon entity) {
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
