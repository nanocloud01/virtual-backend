package bo.gob.asfi.digital.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Entity
@Table(name="digital.consumidor_financiero")
@Data
public class ConsumidorFinanciero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_consumidor_financiero", nullable=false)
	private Integer id;
	
	@Column(name="cedula_identidad", nullable=false, length=30)
	private String cedulaIdentidad;
	
	@Column(name="complemento_cedula_identidad", nullable=true, length=5)
	private String complementoCedulaIdentidad;

	@Column(name="lugar_expedicion", nullable=false, length=2)
	private String lugarExpedicion;
	
	@Column(nullable=false, length=50)
	private String nombres;
	
	@Column(name="primer_apellido", nullable=true, length=50)
	private String primerApellido;
	
	@Column(name="segundo_apellido", nullable=true, length=50)
	private String segundoApellido;
	
	@Column(name="apellido_casada", nullable=true, length=50)
	private String apellidoCasada;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@Column(name="fecha_nacimiento", nullable=false, length=12)
	private LocalDate fechaNacimiento;
	
	@Column(name="correo_electronico", nullable=false, length=70)
	private String correoElectronico;
	
	@Column(name="numero_celular", nullable=true, length=30)
	private String numeroCelular;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@Column(name="fecha_estado", nullable=false, length=12)
	private LocalDateTime fechaEstado;
	
	@Column(name="usuario_estado", nullable=false, length=50)
	private String usuarioEstado;
	
	@Column(name="estado_registro", nullable=false, length=1)
	private String estadoRegistro;
	
	@OneToOne(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, 
			mappedBy = "idConsumidorFinanciero")
    private UsuarioConsumidorFinanciero usuarioConsumidorFinanciero;
	
}
