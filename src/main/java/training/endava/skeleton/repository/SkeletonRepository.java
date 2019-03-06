package training.endava.skeleton.repository;

import java.util.List;
import java.util.Optional;

import training.endava.skeleton.exception.PersonNotFoundException;
import training.endava.skeleton.model.SkeletonObject;
import training.endava.skeleton.db.MockDB;

public interface SkeletonRepository<T extends SkeletonObject<T, ID>, ID> {

    MockDB MOCK_DB = MockDB.getInstance();

    T save(T id);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    long count();

    void deleteById(ID id);

    void deleteAll();
}
