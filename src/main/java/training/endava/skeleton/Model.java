package training.endava.skeleton;

import training.endava.skeleton.db.ClassNotInstantiated;
import training.endava.skeleton.db.MockDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Model implements SkeletonRepository<Person, Integer> {

    ArrayList<Person> list;
    public Model() {
        this.list = new ArrayList<Person>();
    }

    public Person save(Person id) {
        this.list = (ArrayList) MOCK_DB.getTable(Person.class);
        try {
            if (id == null) {
                throw new ClassNotInstantiated(Person.class.toString() + " not instantiated", 1);
            }
            if (!this.existsById(id.getId())) {
                throw new PersonAlreadyExists("Person already exists", 3);
            }
            this.list.add(id);
            MOCK_DB.setTable(Person.class, this.list);
        } catch (ClassNotInstantiated e) {
            System.out.println(e.getMessage() + " " + e.getCode());
        } catch (PersonAlreadyExists i) {
            System.out.println(i.getMessage() + " " + i.getCode());
        } finally {
            return id;
        }

    }

    public Optional<Person> findById(Integer id) {
        this.list = (ArrayList) MOCK_DB.getTable(Person.class);
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    return Optional.ofNullable(list.get(i));
                }
            }
            throw new PersonNotFound("Person with id " + id + " not found", 2);
        } catch (PersonNotFound e) {
            System.out.println(e.getMessage() + " " + e.getCode());
        }
        return Optional.empty();
    }

    public boolean existsById(Integer id) {
        this.list = (ArrayList) MOCK_DB.getTable(Person.class);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<Person> findAll() {
        this.list = (ArrayList) MOCK_DB.getTable(Person.class);
        return this.list;
    }

    public long count() {
        this.list = (ArrayList) MOCK_DB.getTable(Person.class);
        return list.size();
    }

    public void deleteById(Integer id) {
        Optional<Person> per = findById(id);
        this.list = (ArrayList) MOCK_DB.getTable(Person.class);
        this.list.remove(per.get());
        MOCK_DB.setTable(Person.class, list);
    }

    public void deleteAll() {
        this.list = new ArrayList<>();
        MOCK_DB.setTable(Person.class, list);
    }
}
