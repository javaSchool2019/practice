package training.endava.app.hibernate.services;

import training.endava.app.hibernate.entities.Adresa;
import training.endava.app.hibernate.entities.NumarDeTelefon;
import training.endava.app.hibernate.interfaces.ServiceInterface;
import training.endava.app.hibernate.repositories.NumarDeTelefonRepository;

import java.util.List;

public class NumarDeTelefonService implements ServiceInterface<NumarDeTelefon> {

    private NumarDeTelefonRepository _repository = new NumarDeTelefonRepository();

    @Override
    public NumarDeTelefon add(NumarDeTelefon entity) {
        return _repository.add(entity);
    }

    @Override
    public NumarDeTelefon getById(int id) {
        return _repository.getById(id);
    }

    public List<NumarDeTelefon> getAll() {
        return _repository.getAll();
    }

    @Override
    public boolean update(NumarDeTelefon entity) {
        return _repository.update(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return _repository.deleteById(id);
    }
}
