package ec.edu.ups.ppw.dao;

import ec.edu.ups.ppw.model.Token;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class TokenDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Token token) {
        em.persist(token);
    }

    public void update(Token token) {
        em.merge(token);
    }

    // Nota: ID es long
    public Token read(long id) {
        return em.find(Token.class, id);
    }

    public void delete(long id) {
        Token token = em.find(Token.class, id);
        if (token != null) {
            em.remove(token);
        }
    }

    // Buscar token por el string (para validar request)
    public Token getPorTokenString(String tokenStr) {
        String jpql = "SELECT t FROM Token t WHERE t.token = :token";
        Query q = em.createQuery(jpql, Token.class);
        q.setParameter("token", tokenStr);
        List<Token> result = q.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}