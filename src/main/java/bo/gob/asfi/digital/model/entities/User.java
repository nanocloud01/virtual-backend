package bo.gob.asfi.digital.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="digital.users")
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_consumidor_financiero")
	private Integer id;
	
	@Column(unique=true, length=70)
	private String username;
	
	@Column(length=60)
	private String password;
	
	private Boolean enabled;
	
	@JsonIgnore
    @JoinColumn(name = "id_consumidor_financiero", referencedColumnName = "id_consumidor_financiero")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private ConsumidorFinanciero idConsumidorFinanciero;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="digital.users_roles", 
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="roles_id"),
			uniqueConstraints={@UniqueConstraint(columnNames={"user_id", "roles_id"})})
	private List<Rol> roles;

}
