package ec.edu.ups.ppw.services;

import java.util.List;
import ec.edu.ups.ppw.business.GestionNotificacion;
import ec.edu.ups.ppw.model.Notificacion;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("notificacion")
public class NotificacionService {

    @Inject
    private GestionNotificacion gn;

    @GET
    @Produces("application/json")
    public List<Notificacion> getListaNotificaciones() {
        return gn.getNotificacion();
    }
}
