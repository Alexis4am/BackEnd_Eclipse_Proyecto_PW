package ec.edu.ups.ppw.services;

import java.util.List;
import ec.edu.ups.ppw.business.GestionDisponibilidad;
import ec.edu.ups.ppw.model.Disponibilidad;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("disponibilidad")
public class DisponibilidadService {

    @Inject
    private GestionDisponibilidad gd;

    @GET
    @Produces("application/json")
    public List<Disponibilidad> getListaDisponibilidad() {
        return gd.getDisponibilidad();
    }
}
