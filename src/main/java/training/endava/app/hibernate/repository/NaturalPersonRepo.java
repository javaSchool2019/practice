package training.endava.app.hibernate.repository;

import training.endava.app.hibernate.EntityManagerUtil;
import training.endava.app.hibernate.domain.LegalPerson;
import training.endava.app.hibernate.domain.NaturalPerson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class NaturalPersonRepo {

    private EntityManagerFactory emf = EntityManagerUtil.getInstance();


    public String add(NaturalPerson naturalPerson){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(naturalPerson);
            entityManager.getTransaction().commit();
            entityManager.close();
            return naturalPerson + " was added to db!";

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Something went wrong!";
    }


    public List<NaturalPerson> getAll() {
        List<NaturalPerson> naturalPersonList=new ArrayList<>();
        try {
            EntityManager entityManager = emf.createEntityManager();
            TypedQuery<NaturalPerson> result = entityManager.createQuery("SELECT np from NaturalPerson np", NaturalPerson.class);
            naturalPersonList = result.getResultList();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return naturalPersonList;
    }


    public NaturalPerson getById(Integer addId){
        NaturalPerson naturalPerson=null;
        try {
            EntityManager entityManager = emf.createEntityManager();
            naturalPerson = (NaturalPerson) entityManager.find(NaturalPerson.class, addId);
            entityManager.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return naturalPerson;
    }


    public boolean update(NaturalPerson naturalPerson){
        try {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(naturalPerson);
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
            NaturalPerson naturalPerson = (NaturalPerson) entityManager.find(NaturalPerson.class, deleteId);
            entityManager.remove(naturalPerson);
            entityManager.getTransaction().commit();
            entityManager.close();
            return  true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }



}
