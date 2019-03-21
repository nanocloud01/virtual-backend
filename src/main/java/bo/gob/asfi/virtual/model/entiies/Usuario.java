package bo.gob.asfi.virtual.model.entiies;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="usuarios")
@Data
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cedula_identidad", nullable=false, length=15)
	private String cedulaIdentidad;

	@Column(name="lugar_expedido", nullable=false, length=15)
	private String lugarExpedido;
	
	@Column(nullable=false, length=50)
	private String nombres;
	
	@Column(name="primer_apellido", nullable=true, length=30)
	private String primerApellido;
	
	@Column(name="segundo_apellido", nullable=true, length=30)
	private String segundoApellido;
	
	@Column(name="apellido_casada", nullable=true, length=30)
	private String apellidoCasada;
	
	@Column(name="fecha_nacimiento", nullable=false, length=12)
	private String fechaNacimiento;
	
	@Column(name="correo_electronico", nullable=false, length=70)
	private String correoElectronico;
	
}
