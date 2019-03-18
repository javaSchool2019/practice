package training.endava.app.hibernate.interfaces;

public interface ServiceInterface<T>{
    T add(T entity);
    T getById(int id);
    boolean update(T entity);
    boolean deleteById(int id);
}
