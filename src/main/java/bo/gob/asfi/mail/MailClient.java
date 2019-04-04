package bo.gob.asfi.mail;

import java.rmi.RemoteException;

public class MailClient {

	public int correoAdjunto(String mensaje, String destino, String origen, String asunto, String nombreArchivo) {
		int resp = 1;
		IServicioCorreoElectronicoProxy proxy = new IServicioCorreoElectronicoProxy();
		try {
			proxy.envioCorreoAdjunto(mensaje, destino, origen, asunto, nombreArchivo, hexStringToByteArray("Hernan"));
		} catch (RemoteException e) {
			resp = 0;
			e.printStackTrace();
		}
		return resp;
	}
	
	public int correo(String mensaje, String destino, String origen, String asunto) {
		int resp = 1;
		IServicioCorreoElectronicoProxy proxy = new IServicioCorreoElectronicoProxy();
		try {
			proxy.envioCorreo(mensaje, destino, origen, asunto);
		} catch (RemoteException e) {
			resp = 0;
			e.printStackTrace();
		}
		return resp;
	}
	
	private byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}

}
