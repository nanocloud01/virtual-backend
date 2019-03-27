package bo.gob.asfi.digital.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="digital.usuario_consumidor_financiero")
@Data
public class UsuarioConsumidorFinanciero implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_consumidor_financiero")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cedula_identidad")
    private String cedulaIdentidad;
    
    @Size(max = 50)
    @Column(name = "contrasenia_consumidor_financiero")
    private String contraseniaConsumidorFinanciero;
    
    @NotNull
    @Column(name = "es_primer_ingreso")
    private boolean esPrimerIngreso;
    
    @Column(name = "fecha_primer_ingreso")
    private LocalDate fechaPrimerIngreso;
    
    @NotNull
    @Column(name = "esta_bloqueado")
    private boolean estaBloqueado;
    
    @Column(name = "fecha_bloqueo")
    private LocalDate fechaBloqueo;
    
    @Column(name = "fecha_estado")
    private LocalDate fechaEstado;
    
    @Size(max = 50)
    @Column(name = "usuario_estado")
    private String usuarioEstado;
    
    @Size(max = 1)
    @Column(name = "estado_registro")
    private String estadoRegistro;
    
    @JsonIgnore
    @JoinColumn(name = "id_consumidor_financiero", referencedColumnName = "id_consumidor_financiero")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private ConsumidorFinanciero idConsumidorFinanciero;

}
