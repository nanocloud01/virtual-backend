package bo.gob.asfi.digital.params.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="parametros.clasificador")
@Data
public class Clasificador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clasificador")
    private Integer id;
	
    @NotNull
    private String dominio;
    
    @NotNull
    private String codigo;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String descripcion;    
    
    private String extension;
    
    @NotNull
    private int orden;    
    
    @NotNull
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
    
    @NotNull
    @Column(name = "usuario_registro")
    private String usuarioRegistro;
    
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;
    
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    
    @Column(name = "estado_registro")
    private String estadoRegistro;
    
}
