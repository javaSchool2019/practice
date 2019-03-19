package training.endava.app.hibernate.repository;
import training.endava.app.hibernate.EntityManagerUtil;
import training.endava.app.hibernate.domain.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class AddressRepo {

    private EntityManagerFactory emf = EntityManagerUtil.getInstance();

    public String add(Address address){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            entityManager.close();
            return address + " was added to db!";

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Something went wrong!";
    }



    public List<Address> getAll() {
        List<Address> addressList=new ArrayList<>();
        try {
            EntityManager entityManager = emf.createEntityManager();
            TypedQuery<Address> result = entityManager.createQuery("SELECT a from AddressService a", Address.class);
            addressList = result.getResultList();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return addressList;
    }



    public Address getById(Integer addId){
        Address address=null;
        try {
            EntityManager entityManager = emf.createEntityManager();
            address = (Address) entityManager.find(Address.class, addId);
            entityManager.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return address;
    }



    public boolean update(Address address){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(address);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("DB was updated!");
            return  true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(Integer deleteId){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            Address address = (Address)entityManager.find(Address.class, deleteId);
            entityManager.remove(address);
            entityManager.getTransaction().commit();
            entityManager.close();
            return  true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
