package training.endava.app.hibernate.interfaces;

import training.endava.app.hibernate.entities.Adresa;

import java.util.List;

public interface RepositoryInterface<T> {
    T add(T entity);
    T getById(int id);
    boolean update(T entity);
    boolean deleteById(int id);
}
