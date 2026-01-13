package ec.edu.ups.ppw.services;

import java.util.List;
import ec.edu.ups.ppw.business.GestionAsesoria;
import ec.edu.ups.ppw.model.Asesoria;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("asesoria")
public class AsesoriaService {

    @Inject
    private GestionAsesoria ga;

    @GET
    @Produces("application/json")
    public List<Asesoria> getListaAsesorias() {
        return ga.getAsesoria();
    }
}
