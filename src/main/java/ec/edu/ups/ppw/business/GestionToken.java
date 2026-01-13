package ec.edu.ups.ppw.business;

import ec.edu.ups.ppw.dao.TokenDAO;
import ec.edu.ups.ppw.model.Token;
import ec.edu.ups.ppw.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionToken {

    @Inject
    private TokenDAO daoToken;

    // VALIDAR: Sirve para los filtros de seguridad (verificar si el token es real)
    public boolean esTokenValido(String tokenStr) {
        Token t = daoToken.getPorTokenString(tokenStr);
        if (t == null) return false;
        if (t.isRevoked() || t.isExpired()) return false;
        return true;
    }
    
    // GUARDAR: Se llama AL MOMENTO DEL LOGIN
    public void crearToken(Usuario usuario, String tokenStr) {
        Token t = new Token();
        t.setUsuario(usuario);
        t.setToken(tokenStr);
        t.setRevoked(false);
        t.setExpired(false);
        // Aquí podrías setear expiración calculada, etc.
        daoToken.insert(t);
    }
    
    // REVOCAR: Se llama AL MOMENTO DEL LOGOUT
    public void revocarToken(String tokenStr) {
        Token t = daoToken.getPorTokenString(tokenStr);
        if(t != null) {
            t.setRevoked(true);
            daoToken.update(t);
        }
    }
}