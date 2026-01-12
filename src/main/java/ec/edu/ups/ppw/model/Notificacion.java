package ec.edu.ups.ppw.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PW_NOTIFICACIONES")
public class Notificacion {

    public enum NotificationType {
        EMAIL, WHATSAPP
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "not_id")
    private int id;

    // A quién se le envió la notificación
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "not_usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "not_tipo", length = 20)
    private NotificationType tipo; 

    @Column(name = "not_mensaje", columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "not_fecha_envio")
    private LocalDateTime fechaEnvio;

    @Column(name = "not_exitoso")
    private boolean exitoso;

    public Notificacion() {
        this.fechaEnvio = LocalDateTime.now();
        this.exitoso = true; // Por defecto asumimos éxito, cambiamos si falla el try-catch
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public NotificationType getTipo() {
		return tipo;
	}

	public void setTipo(NotificationType tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public boolean isExitoso() {
		return exitoso;
	}

	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}
    
}