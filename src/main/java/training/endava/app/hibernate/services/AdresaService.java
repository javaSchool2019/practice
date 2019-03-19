package training.endava.app.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import training.endava.app.hibernate.entities.Adresa;
import training.endava.app.hibernate.interfaces.ServiceInterface;
import training.endava.app.hibernate.repositories.AdresaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class AdresaService implements ServiceInterface<Adresa> {

    private AdresaRepository _repository = new AdresaRepository();

    @Override
    public Adresa add(Adresa entity) {
        return _repository.add(entity);
    }

    @Override
    public Adresa getById(int id) {
        return _repository.getById(id);
    }

    public List<Adresa> getAll() {
        return _repository.getAll();
    }

    public List<Adresa> getAllByName(String startsWith) {
        return _repository.getAllByName(startsWith);
    }

    public List<Adresa> getAllOrderByLocalitate() {
        return _repository.getAllOrderByLocalitate();
    }

    @Override
    public boolean update(Adresa entity) {
        return _repository.update(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return _repository.deleteById(id);
    }
}
