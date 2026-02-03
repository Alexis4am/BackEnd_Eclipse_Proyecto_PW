package ec.edu.ups.ppw.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import ec.edu.ups.ppw.model.enums.ProjectCategory;

@Entity
@Table(name = "PW_PROYECTOS")
public class Proyecto {
    
    public Proyecto() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pry_id")
    private int id;

    // Solo guardamos el ID del programador (sin relación JPA)
    @Column(name = "pry_programador_id", nullable = false)
    private int programadorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "pry_categoria", nullable = false)
    private ProjectCategory categoria;

    @Column(name = "pry_nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "pry_descripcion", columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "pry_tecnologias_usadas", length = 255)
    private String tecnologiasUsadas;
    
    @Column(name = "pry_url_repositorio", length = 512)
    private String urlRepositorio;
    
    @Column(name = "pry_url_despliegue", length = 512)
    private String urlDespliegue;

    @Column(name = "pry_url_imagen_preview", length = 512)
    private String urlImagenPreview;

    @Column(name = "pry_created_at")
    private LocalDateTime createdAt;

    @Column(name = "pry_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "pry_activo")
    private Boolean activo;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if(this.activo == null) this.activo = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // --- GETTERS Y SETTERS ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProgramadorId() {
        return programadorId;
    }

    public void setProgramadorId(int programadorId) {
        this.programadorId = programadorId;
    }

    public ProjectCategory getCategoria() {
        return categoria;
    }

    public void setCategoria(ProjectCategory categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTecnologiasUsadas() {
        return tecnologiasUsadas;
    }

    public void setTecnologiasUsadas(String tecnologiasUsadas) {
        this.tecnologiasUsadas = tecnologiasUsadas;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public String getUrlDespliegue() {
        return urlDespliegue;
    }

    public void setUrlDespliegue(String urlDespliegue) {
        this.urlDespliegue = urlDespliegue;
    }

    public String getUrlImagenPreview() {
        return urlImagenPreview;
    }

    public void setUrlImagenPreview(String urlImagenPreview) {
        this.urlImagenPreview = urlImagenPreview;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}