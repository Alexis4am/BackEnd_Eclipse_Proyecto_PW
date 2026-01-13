package ec.edu.ups.ppw.business;

import java.util.List;
import ec.edu.ups.ppw.dao.ProgramadorDetallesDAO;
import ec.edu.ups.ppw.model.ProgramadorDetalles;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProgramadorDetalles {

    @Inject
    private ProgramadorDetallesDAO daoProgramadorDetalles;

    public List<ProgramadorDetalles> getProgramadorDetalles() {
        return daoProgramadorDetalles.getAll();
    }
}
