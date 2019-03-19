package training.endava.app.Hibernate.repositoryHibernate;
import training.endava.app.Hibernate.domainHibernate.Employee;
import training.endava.app.Hibernate.entityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeRepository {
    private EntityManagerFactory entityManagerFactory = entityManager.getinstance();

    public Employee add (Employee entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        Employee employee = entityManager.find(Employee.class,entity.getId());
        entityManager.close();
        return employee;
    }

    public Employee getById (int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.close();
        return employee;
    }

    public List<Employee> all(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> result = entityManager.createQuery("select e from Employee e",Employee.class);
        List<Employee> employeeList = result.getResultList();
        return employeeList;
    }

    public boolean update (Employee entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    public boolean deleteById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = getById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }


}
