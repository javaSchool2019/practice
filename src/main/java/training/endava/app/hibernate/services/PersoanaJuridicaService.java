package training.endava.app.hibernate.services;

import training.endava.app.hibernate.entities.Adresa;
import training.endava.app.hibernate.entities.PersoanaJuridica;
import training.endava.app.hibernate.entities.PersoanaJuridica;
import training.endava.app.hibernate.interfaces.ServiceInterface;
import training.endava.app.hibernate.repositories.PersoanaJuridicaRepository;

import java.util.List;

public class PersoanaJuridicaService implements ServiceInterface<PersoanaJuridica> {

    private PersoanaJuridicaRepository _repository = new PersoanaJuridicaRepository();

    @Override
    public PersoanaJuridica add(PersoanaJuridica entity) {
        return _repository.add(entity);
    }

    @Override
    public PersoanaJuridica getById(int id) {
        return _repository.getById(id);
    }

    public List<PersoanaJuridica> getAll() {
        return _repository.getAll();
    }

    @Override
    public boolean update(PersoanaJuridica entity) {
        return _repository.update(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return _repository.deleteById(id);
    }
}
