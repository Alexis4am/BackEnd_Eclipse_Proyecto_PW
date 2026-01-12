package ec.edu.ups.ppw.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_PERSONAS") 
public class Persona {

    @Id // Corrected: Capital 'I'
    @Column(name = "per_cedula", length=10)
    private String cedula;
    
    @Column(name = "per_nombre", length = 60)
    private String nombre;
    
    @Column(name = "per_direccion")
    private String direccion; // Corrected spelling

    // 1. Mandatory No-Args Constructor
    public Persona() {
    }

    // Getters and Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}