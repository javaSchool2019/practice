package training.endava.app.hibernate.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.hibernate.entities.PersoanaJuridica;
import training.endava.app.hibernate.services.PersoanaJuridicaService;

import java.util.List;

@RestController
@RequestMapping("/persoana/juridica")
public class PersoanaJuridicaController {

    private PersoanaJuridicaService _service = new PersoanaJuridicaService();

    @GetMapping(value = "/id={ID}")
    public ResponseEntity<PersoanaJuridica> getById(@PathVariable(value="ID") Integer id) {
        PersoanaJuridica response = _service.getById(id);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<PersoanaJuridica>> getAll() {
        List<PersoanaJuridica> response = _service.getAll();
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<PersoanaJuridica> add(@RequestBody PersoanaJuridica entity) {
        PersoanaJuridica response = _service.add(entity);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody PersoanaJuridica entity) {
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
