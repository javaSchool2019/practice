package training.endava.app.hibernate.repository;

import training.endava.app.hibernate.EntityManagerUtil;
import training.endava.app.hibernate.domain.Address;
import training.endava.app.hibernate.domain.PhoneNumber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberRepo {

    private EntityManagerFactory emf = EntityManagerUtil.getInstance();

    public String add(PhoneNumber phoneNumber){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(phoneNumber);
            entityManager.getTransaction().commit();
            entityManager.close();
            return phoneNumber + " was added to db!";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Something went wrong!";
    }


    public PhoneNumber getById(Integer getId){
        PhoneNumber phoneNumber=null;
        try {
            EntityManager entityManager = emf.createEntityManager();
            phoneNumber = (PhoneNumber) entityManager.find(PhoneNumber.class, getId);
            entityManager.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return phoneNumber;
    }


    public List<PhoneNumber> getAll() {
        List<PhoneNumber> phoneNumberList=new ArrayList<>();
        try {
            EntityManager entityManager = emf.createEntityManager();
            TypedQuery<PhoneNumber> result = entityManager.createQuery("SELECT p from phonenumber p", PhoneNumber.class);
            phoneNumberList = result.getResultList();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return phoneNumberList;
    }


    public boolean update(PhoneNumber phoneNumber){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(phoneNumber);
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
            PhoneNumber pn = (PhoneNumber)entityManager.find(PhoneNumber.class, deleteId);
            entityManager.remove(pn);
            entityManager.getTransaction().commit();
            entityManager.close();
            return  true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }




}
