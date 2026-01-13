package ec.edu.ups.ppw.business;

import java.util.List;
import ec.edu.ups.ppw.dao.AsesoriaDAO;
import ec.edu.ups.ppw.model.Asesoria;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionAsesoria {

    @Inject
    private AsesoriaDAO daoAsesoria;

    public List<Asesoria> getAsesoria() {
        return daoAsesoria.getAll();
    }
}
