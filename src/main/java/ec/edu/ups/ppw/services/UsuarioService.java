package ec.edu.ups.ppw.services;

import java.util.List;

import ec.edu.ups.ppw.business.GestionUsuario;
import ec.edu.ups.ppw.model.Usuario;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("usuarios")
public class UsuarioService {

    @Inject
    private GestionUsuario gu;

    //CREAR 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario usuario) {
        try {
            gu.createUsuario(usuario);
            return Response.ok(usuario).build(); // Devuelve 200 OK y el usuario creado
        } catch (Exception e) {
            // Error interno (500) o Bad Request (400)
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error al crear usuario: " + e.getMessage()).build();
        }
    }

    //LEER
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getListaUsuarios() {
        return gu.getUsuarios();
    }

    // 3. LEER UNO (Buscar por ID)
    @GET
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") int id) { // 
        Usuario usu = gu.getUsuarioPorId(id);
        if (usu != null) {
            return Response.ok(usu).build();
        } else {
            // Devuelve 404 si no existe [cite: 172]
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Usuario no encontrado").build();
        }
    }

    // 4. ACTUALIZAR 
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(Usuario usuario) {
        try {
            // Verificar si existe
            Usuario existente = gu.getUsuarioPorId(usuario.getId()); // Asumiendo que el usuario trae ID
            if (existente == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("No se puede actualizar: Usuario no existe").build();
            }
            gu.updateUsuario(usuario);
            return Response.ok("Usuario actualizado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error al actualizar").build();
        }
    }

    //ELIMINAR 
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarUsuario(@PathParam("id") int id) {
        try {
            // Valid existencia
            Usuario existente = gu.getUsuarioPorId(id);
            if (existente == null) {
                 return Response.status(Response.Status.NOT_FOUND).build();
            }
            gu.deleteUsuario(id);
            return Response.ok("Usuario eliminado").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}