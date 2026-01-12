package ec.edu.ups.ppw.dao;

import ec.edu.ups.ppw.model.Asesoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class AsesoriaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Asesoria asesoria) {
        em.persist(asesoria);
    }

    public void update(Asesoria asesoria) {
        em.merge(asesoria);
    }

    public Asesoria read(int id) {
        return em.find(Asesoria.class, id);
    }

    public void delete(int id) {
        Asesoria asesoria = em.find(Asesoria.class, id);
        if (asesoria != null) {
            em.remove(asesoria);
        }
    }

    public List<Asesoria> getAll() {
        String jpql = "SELECT a FROM Asesoria a";
        Query q = em.createQuery(jpql, Asesoria.class);
        return q.getResultList();
    }
}