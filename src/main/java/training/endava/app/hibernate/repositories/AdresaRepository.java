package training.endava.app.hibernate.repositories;

import org.springframework.stereotype.Repository;
import training.endava.app.hibernate.EM;
import training.endava.app.hibernate.entities.Adresa;
import training.endava.app.hibernate.interfaces.RepositoryInterface;

import javax.persistence.*;
import java.util.List;

@Repository
public class AdresaRepository implements RepositoryInterface<Adresa> {

    private EntityManagerFactory _emf = EM.getInstance();

    @Override
    public Adresa add(Adresa entity) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        Adresa adresa = em.find(Adresa.class, entity.getId());
        em.close();
        return adresa;
    }

    @Override
    public Adresa getById(int id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        Adresa adresa = em.find(Adresa.class, id);
        em.close();
        return adresa;
    }

    public List<Adresa> getAll() {
        EntityManager em = _emf.createEntityManager();
        TypedQuery<Adresa> result = em.createQuery("select a from Adresa a", Adresa.class);
        List<Adresa> adresaList = result.getResultList();
        em.close();
        return adresaList;
    }

    @Override
    public boolean update(Adresa entity) {
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
            Adresa adresa = getById(id);
            em.getTransaction().begin();
            em.remove(adresa);
            em.getTransaction().commit();
            em.close();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }
}
