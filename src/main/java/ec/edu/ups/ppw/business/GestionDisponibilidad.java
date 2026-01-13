package ec.edu.ups.ppw.business;

import java.util.List;
import ec.edu.ups.ppw.dao.DisponibilidadDAO;
import ec.edu.ups.ppw.model.Disponibilidad;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionDisponibilidad {

    @Inject
    private DisponibilidadDAO daoDisponibilidad;

    public List<Disponibilidad> getDisponibilidad() {
        return daoDisponibilidad.getAll();
    }
}
