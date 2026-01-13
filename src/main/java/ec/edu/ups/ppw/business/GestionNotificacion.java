package ec.edu.ups.ppw.business;

import java.util.List;
import ec.edu.ups.ppw.dao.NotificacionDAO;
import ec.edu.ups.ppw.model.Notificacion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionNotificacion {

    @Inject
    private NotificacionDAO daoNotificacion;

    public List<Notificacion> getNotificacion() {
        return daoNotificacion.getAll();
    }
}
