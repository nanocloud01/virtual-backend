package bo.gob.asfi.digital.cic.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class ConsumidorFinancieroHistorico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String DocumentoIdentificacionConExtension;
	private String ComplementoDocumentoIdentificacion;
	private String LugarExpedicion;
	private String FechaNacimiento;
	private String NombresRazonSocial;
	private String PrimerApellido;
	private String SegundoApellido;
	private String ApellidoCasada;
	private String DocumentoIdentificacion;
	private String CodigoTipoIdentificacion;
	
	public ConsumidorFinancieroHistorico(String documentoIdentificacionConExtension, String complementoDocumentoIdentificacion,
			String lugarExpedicion, String fechaNacimiento, String nombresRazonSocial, String primerApellido,
			String segundoApellido, String apellidoCasada, String documentoIdentificacion,
			String codigoTipoIdentificacion) {
		super();
		DocumentoIdentificacionConExtension = documentoIdentificacionConExtension;
		ComplementoDocumentoIdentificacion = complementoDocumentoIdentificacion;
		LugarExpedicion = lugarExpedicion;
		FechaNacimiento = fechaNacimiento;
		NombresRazonSocial = nombresRazonSocial;
		PrimerApellido = primerApellido;
		SegundoApellido = segundoApellido;
		ApellidoCasada = apellidoCasada;
		DocumentoIdentificacion = documentoIdentificacion;
		CodigoTipoIdentificacion = codigoTipoIdentificacion;
	}
	
}
