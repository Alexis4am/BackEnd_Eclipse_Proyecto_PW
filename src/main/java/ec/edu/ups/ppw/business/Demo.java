package ec.edu.ups.ppw.business;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


import ec.edu.ups.ppw.dao.*;
import ec.edu.ups.ppw.model.*;
import ec.edu.ups.ppw.model.enums.*;

@Singleton
@Startup
public class Demo {
	
	

    @Inject
    private ProgramadorDetallesDAO daoDetalles;
    @Inject
    private ProyectoDAO daoProyecto;
    @Inject
    private DisponibilidadDAO daoDisponibilidad;

	@PostConstruct
	public void init() {
		

       
		
	}
	
	
}
