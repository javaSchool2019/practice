package training.endava.app.hibernate.repositories;

import training.endava.app.hibernate.EM;
import training.endava.app.hibernate.entities.PersoanaFizica;
import training.endava.app.hibernate.entities.PersoanaFizica;
import training.endava.app.hibernate.interfaces.RepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersoanaFizicaRepository implements RepositoryInterface<PersoanaFizica> {

    private EntityManagerFactory _emf = EM.getInstance();

    @Override
    public PersoanaFizica add(PersoanaFizica entity) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        PersoanaFizica PersoanaFizica = em.find(PersoanaFizica.class, entity.getId());
        em.close();
        return PersoanaFizica;
    }

    @Override
    public PersoanaFizica getById(int id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        PersoanaFizica PersoanaFizica = em.find(PersoanaFizica.class, id);
        em.close();
        return PersoanaFizica;
    }

    public List<PersoanaFizica> getAll() {
        EntityManager em = _emf.createEntityManager();
        TypedQuery<PersoanaFizica> result = em.createQuery("select a from PersoanaFizica a", PersoanaFizica.class);
        List<PersoanaFizica> PersoanaFizicaList = result.getResultList();
        em.close();
        return PersoanaFizicaList;
    }

    @Override
    public boolean update(PersoanaFizica entity) {
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
            PersoanaFizica PersoanaFizica = getById(id);
            em.getTransaction().begin();
            em.remove(PersoanaFizica);
            em.getTransaction().commit();
            em.close();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }
}
