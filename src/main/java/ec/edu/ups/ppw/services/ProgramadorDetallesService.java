package ec.edu.ups.ppw.services;

import java.util.List;
import ec.edu.ups.ppw.business.GestionProgramadorDetalles;
import ec.edu.ups.ppw.model.ProgramadorDetalles;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("programador-detalles")
public class ProgramadorDetallesService {

    @Inject
    private GestionProgramadorDetalles gpd;

    @GET
    @Produces("application/json")
    public List<ProgramadorDetalles> getListaProgramadorDetalles() {
        return gpd.getProgramadorDetalles();
    }
}
