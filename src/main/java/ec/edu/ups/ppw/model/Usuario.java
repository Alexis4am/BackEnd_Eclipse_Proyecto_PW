package ec.edu.ups.ppw.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PW_USUARIOS") // Apunta a la misma tabla que Spring Boot
public class Usuario implements Serializable {

    @Id
    @Column(name = "usu_id")
    private Integer id;

    // No necesitas copiar todos los campos (password, roles, etc.)
    // Solo los que necesites para mostrar info básica en Eclipse, o solo el ID.
    
    @Column(name = "usu_nombre")
    private String nombre;

    @Column(name = "usu_apellido")
    private String apellido;

    @Column(name = "usu_email")
    private String email;

    public Usuario() {}

    // Getters y Setters necesarios
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}