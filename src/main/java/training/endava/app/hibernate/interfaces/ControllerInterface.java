package training.endava.app.hibernate.interfaces;

import org.springframework.web.bind.annotation.*;
import training.endava.app.hibernate.entities.Adresa;

import java.util.List;

public interface ControllerInterface<T> {


    T getById( Integer id);

    List<T> getAll();

    T add(T entity);

    boolean deleteById( Integer id);
}
