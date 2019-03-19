package training.endava.app.Hibernate.serviceHibernate;

import training.endava.app.Hibernate.domainHibernate.Employee;
import training.endava.app.Hibernate.repositoryHibernate.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository repo = new EmployeeRepository();

    public Employee getById(int id){
        return repo.getById(id);
    }

    public List<Employee> all(){
        return repo.all();
    }

    public Employee add (Employee entity){
        return repo.add(entity);
    }

    public Boolean update (Employee entity){
        return repo.update(entity);
    }

    public Boolean deleteById (int id){
        return repo.deleteById(id);
    }
}
