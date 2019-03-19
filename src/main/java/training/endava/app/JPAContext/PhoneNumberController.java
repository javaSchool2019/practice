//package training.endava.app.JPAContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.*;
//import training.endava.app.JPAContext.JPAContextRepository.AddressRepository;
//import training.endava.app.JPAContext.JPAContextRepository.PhoneNumberRepository;
//import training.endava.app.JPAContext.JPAdomain.Address;
//import training.endava.app.JPAContext.JPAdomain.PhoneNumber;
//
//import java.util.List;
//
//@RestController
//public class PhoneNumberController {
//
//    @Autowired
//    public PhoneNumberRepository phoneNumberRepository;
//
//    @GetMapping("/pnumber")
//    public List<PhoneNumber> getAllPhoneNumbers()
//    {
//        return this.phoneNumberRepository.findAll();
//    }
//
//    @PostMapping("/pnumber")
//    public void addPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
//        this.phoneNumberRepository.insertWithQuery(phoneNumber);
//    }
//
//    @GetMapping("/pnumber/{id}")
//    public PhoneNumber findPhoneNumberById(@PathVariable(value = "id") int id) {
//        return this.phoneNumberRepository.findById(id);
//    }
//
//    @PutMapping("/pnumber")
//    public void updatePhoneNumber(@RequestBody PhoneNumber phoneNumber){
//        this.phoneNumberRepository.updatePhoneNumber(phoneNumber);
//    }
//
//    @DeleteMapping("pnumber/{id}")
//    public void deleteAddressByID(@PathVariable(value = "id") int id){
//        this.phoneNumberRepository.deletePhoneNumber(id);
//    }
//}
