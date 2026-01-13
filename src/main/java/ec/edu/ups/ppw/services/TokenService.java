package ec.edu.ups.ppw.services;

import java.util.List;
import ec.edu.ups.ppw.business.GestionToken;
import ec.edu.ups.ppw.model.Token;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("token")
public class TokenService {

    @Inject
    private GestionToken gt;

   
}
