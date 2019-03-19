package training.endava.app.hibernate.repositories;

import org.springframework.stereotype.Repository;
import training.endava.app.hibernate.EM;
import training.endava.app.hibernate.entities.Adresa;
import training.endava.app.hibernate.interfaces.RepositoryInterface;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



@Repository
public class AdresaRepository implements RepositoryInterface<Adresa> {

    private EntityManagerFactory _emf = EM.getInstance();

    @Override
    public Adresa add(Adresa entity) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNativeQuery("INSERT INTO Adresa (id, adresa, localitate, oras) " +
                " VALUES(?,?,?,?)");
        query.setParameter(1, entity.getId());
        query.setParameter(2, entity.getAdresa());
        query.setParameter(3, entity.getLocalitate());
        query.setParameter(4, entity.getOras());
        query.executeUpdate();

        em.getTransaction().commit();
        Adresa adresa = em.find(Adresa.class, entity.getId());
        em.close();
        return adresa;
    }

    @Override
    public Adresa getById(int id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Adresa> q = em.createQuery("SELECT a FROM Adresa a WHERE a.id = :number", Adresa.class);
        q.setParameter("number", id);
        List<Adresa> results = q.getResultList();
        em.close();
        return results.get(0);
    }

    public List<Adresa> getAll() {
        EntityManager em = _emf.createEntityManager();
        TypedQuery<Adresa> result = em.createQuery("select a from Adresa a", Adresa.class);
        List<Adresa> adresaList = result.getResultList();
        em.close();
        return adresaList;
    }

    public List<Adresa> getAllByName(String startsWith) {
        EntityManager em = _emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Adresa> q = cb.createQuery(Adresa.class);
        javax.persistence.criteria.Root<Adresa> c = q.from(Adresa.class);
        q.select(c);
        q.where(cb.like(c.get("adresa"), startsWith + "%"));
        Query qa = em.createQuery(q);
        qa.setMaxResults(500);
        return qa.getResultList();
    }

    public List<Adresa> getAllOrderByLocalitate() {
        EntityManager em = _emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Adresa> q = cb.createQuery(Adresa.class);
        javax.persistence.criteria.Root<Adresa> c = q.from(Adresa.class);
        q.select(c);
        q.orderBy(cb.asc(c.get("localitate")));
        Query qa = em.createQuery(q);
        qa.setMaxResults(500);
        return qa.getResultList();
    }

    @Override
    public boolean update(Adresa entity) {
        try {
            EntityManager em = _emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("UPDATE Adresa SET adresa = ?, localitate = ?, oras = ? WHERE id = ?");
            query.setParameter(1, entity.getAdresa());
            query.setParameter(2, entity.getLocalitate());
            query.setParameter(3, entity.getOras());
            query.setParameter(4, entity.getId());
            query.executeUpdate();
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
            Query query = em.createNativeQuery("DELETE FROM Adresa WHERE id = ?");
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
