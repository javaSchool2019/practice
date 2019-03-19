package training.endava.app.hibernate.repository;

import training.endava.app.hibernate.EntityManagerUtil;
import training.endava.app.hibernate.domain.LegalPerson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class LegalPersonRepo {

    private EntityManagerFactory emf = EntityManagerUtil.getInstance();

    public String add(LegalPerson legalPerson){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(legalPerson);
            entityManager.getTransaction().commit();
            entityManager.close();
            return legalPerson + " was added to db!";

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Something went wrong!";
    }


    public List<LegalPerson> getAll() {
        List<LegalPerson> legalPersonArrayList=new ArrayList<>();
        try {
            EntityManager entityManager = emf.createEntityManager();
            TypedQuery<LegalPerson> result = entityManager.createQuery("SELECT lp from LegalPerson lp", LegalPerson.class);
            legalPersonArrayList = result.getResultList();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return legalPersonArrayList;
    }


    public LegalPerson getById(Integer addId){
        LegalPerson legalPerson=null;
        try {
            EntityManager entityManager = emf.createEntityManager();
            legalPerson = (LegalPerson) entityManager.find(LegalPerson.class, addId);
            entityManager.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return legalPerson;
    }


    public boolean update(LegalPerson legalPerson){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(legalPerson);
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
            LegalPerson legalPerson = (LegalPerson) entityManager.find(LegalPerson.class, deleteId);
            entityManager.remove(legalPerson);
            entityManager.getTransaction().commit();
            entityManager.close();
            return  true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



}
