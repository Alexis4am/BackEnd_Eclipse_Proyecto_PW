package ec.edu.ups.ppw.dao;

import java.util.List;

import ec.edu.ups.ppw.model.Notificacion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class NotificacionDAO {
	 @PersistenceContext
	    private EntityManager em;

	    public void insert(Notificacion notificacion) {
	        em.persist(notificacion);
	    }

	    public void update(Notificacion notificacion) {
	        em.merge(notificacion);
	    }

	    public Notificacion read(int id) {
	        return em.find(Notificacion.class, id);
	    }

	    public void delete(int id) {
	    	Notificacion notificacion = em.find(Notificacion.class, id);
	        if (notificacion != null) {
	            em.remove(notificacion);
	        }
	    }

	    public List<Notificacion> getAll() {
	        String jpql = "SELECT a FROM Asesoria a";
	        Query q = em.createQuery(jpql, Notificacion.class);
	        return q.getResultList();
	    }
}
