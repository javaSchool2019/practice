package training.endava.app.Hibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.endava.app.Hibernate.domainHibernate.NeutralPerson;
import training.endava.app.Hibernate.serviceHibernate.NeutralPersonService;
import training.endava.app.exception.ParentException;
import training.endava.app.logging.LoggerExample;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/NeutralPerson")
public class NeutralPersonController {

    private Logger LOGGER = LoggerExample.returnLogger();
    @Autowired
    private NeutralPersonService neutralPerson;


    @GetMapping(value = "/allNeutralPerson")
    public List<NeutralPerson> allUsers() {
        try {
            return this.neutralPerson.getAllNeutralPersonFromDb();
        }catch(ParentException e){
            LOGGER.severe("No Persons,can t getAll()");
            LOGGER.warning("No persons,can t getAll()");
            return new ArrayList<NeutralPerson>();

        }

    }








}
