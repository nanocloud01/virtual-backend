package bo.gob.asfi.digital.cic.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import bo.gob.asfi.digital.cic.entities.ConsumidorFinancieroHistorico;

@Repository
public class ConsumidorFinancieroHistorialRepository {
	
	@PersistenceContext(unitName  = "cicEntityManagerFactory")
	private EntityManager entityManager;
	
	public List<ConsumidorFinancieroHistorico> getConsumidoresHistoricos(String ci) {
		List<ConsumidorFinancieroHistorico> resultado = new ArrayList<>();
		JpaResultMapper jpaResultMapper = new JpaResultMapper();
		Query query;
	    StringBuilder consulta = new StringBuilder();
        consulta.append("SET NOCOUNT ON; ");
		consulta.append("EXEC [Informes].[busca_documento_identificacion] ");
		consulta.append(" '" + ci + "'");
		
		query = this.entityManager.createNativeQuery(consulta.toString());
        resultado = jpaResultMapper.list(query, ConsumidorFinancieroHistorico.class);
		
		return resultado;
	}

}
