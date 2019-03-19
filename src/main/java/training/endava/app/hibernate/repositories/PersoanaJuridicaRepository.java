package training.endava.app.hibernate.repositories;

import training.endava.app.hibernate.EM;
import training.endava.app.hibernate.entities.PersoanaJuridica;
import training.endava.app.hibernate.entities.PersoanaJuridica;
import training.endava.app.hibernate.interfaces.RepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersoanaJuridicaRepository implements RepositoryInterface<PersoanaJuridica> {

    private EntityManagerFactory _emf = EM.getInstance();

    @Override
    public PersoanaJuridica add(PersoanaJuridica entity) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        PersoanaJuridica PersoanaJuridica = em.find(PersoanaJuridica.class, entity.getId());
        em.close();
        return PersoanaJuridica;
    }

    @Override
    public PersoanaJuridica getById(int id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        PersoanaJuridica PersoanaJuridica = em.find(PersoanaJuridica.class, id);
        em.close();
        return PersoanaJuridica;
    }

    public List<PersoanaJuridica> getAll() {
        EntityManager em = _emf.createEntityManager();
        TypedQuery<PersoanaJuridica> result = em.createQuery("select a from PersoanaJuridica a", PersoanaJuridica.class);
        List<PersoanaJuridica> PersoanaJuridicaList = result.getResultList();
        em.close();
        return PersoanaJuridicaList;
    }

    @Override
    public boolean update(PersoanaJuridica entity) {
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
            Query query = em.createNativeQuery("DELETE FROM Persoana WHERE id = ?");
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
