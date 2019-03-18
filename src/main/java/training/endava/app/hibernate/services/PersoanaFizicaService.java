package training.endava.app.hibernate.services;

import training.endava.app.hibernate.entities.Adresa;
import training.endava.app.hibernate.entities.PersoanaFizica;
import training.endava.app.hibernate.entities.PersoanaFizica;
import training.endava.app.hibernate.interfaces.ServiceInterface;
import training.endava.app.hibernate.repositories.PersoanaFizicaRepository;

import java.util.List;

public class PersoanaFizicaService implements ServiceInterface<PersoanaFizica> {

    private PersoanaFizicaRepository _repository = new PersoanaFizicaRepository();

    @Override
    public PersoanaFizica add(PersoanaFizica entity) {
        return _repository.add(entity);
    }

    @Override
    public PersoanaFizica getById(int id) {
        return _repository.getById(id);
    }

    public List<PersoanaFizica> getAll() {
        return _repository.getAll();
    }

    @Override
    public boolean update(PersoanaFizica entity) {
        return _repository.update(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return _repository.deleteById(id);
    }
}
