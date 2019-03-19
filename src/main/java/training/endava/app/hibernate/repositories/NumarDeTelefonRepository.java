package training.endava.app.hibernate.repositories;

import training.endava.app.hibernate.EM;
import training.endava.app.hibernate.entities.NumarDeTelefon;
import training.endava.app.hibernate.entities.NumarDeTelefon;
import training.endava.app.hibernate.interfaces.RepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class NumarDeTelefonRepository implements RepositoryInterface<NumarDeTelefon> {

    private EntityManagerFactory _emf = EM.getInstance();

    @Override
    public NumarDeTelefon add(NumarDeTelefon entity) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        NumarDeTelefon NumarDeTelefon = em.find(NumarDeTelefon.class, entity.getId());
        em.close();
        return NumarDeTelefon;
    }

    @Override
    public NumarDeTelefon getById(int id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        NumarDeTelefon NumarDeTelefon = em.find(NumarDeTelefon.class, id);
        em.close();
        return NumarDeTelefon;
    }

    public List<NumarDeTelefon> getAll() {
        EntityManager em = _emf.createEntityManager();
        TypedQuery<NumarDeTelefon> result = em.createQuery("select a from NumarDeTelefon a", NumarDeTelefon.class);
        List<NumarDeTelefon> NumarDeTelefonList = result.getResultList();
        em.close();
        return NumarDeTelefonList;
    }

    @Override
    public boolean update(NumarDeTelefon entity) {
        try {
            EntityManager em = _emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            em.close();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        try {
            EntityManager em = _emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("DELETE FROM NumarDeTelefon WHERE id = ?");
            query.setParameter(1, id);
            em.getTransaction().commit();
            em.close();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }
}
