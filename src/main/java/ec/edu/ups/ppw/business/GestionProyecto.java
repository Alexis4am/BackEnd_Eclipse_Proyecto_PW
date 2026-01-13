package ec.edu.ups.ppw.business;

import java.util.List;
import ec.edu.ups.ppw.dao.ProyectoDAO;
import ec.edu.ups.ppw.model.Proyecto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProyecto {

    @Inject
    private ProyectoDAO daoProyecto;

    public List<Proyecto> getProyecto() {
        return daoProyecto.getAll();
    }
}
