/**
 * IServicioCorreoElectronico.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bo.gob.asfi.mail;

public interface IServicioCorreoElectronico extends java.rmi.Remote {
    public java.lang.Boolean enviaCorreoCopia(java.lang.String mensaje, java.lang.String[] listadoCorreoDestino, java.lang.String correoOrigen, java.lang.String asunto, java.lang.String[] listadoCopia) throws java.rmi.RemoteException;
    public java.lang.Boolean enviaCorreoEntidad(java.lang.String mensaje, java.lang.String codTipoEntidad, java.lang.String nroCorrelativoEntidad, java.lang.String correo, java.lang.Integer idEntidad, java.lang.String asunto) throws java.rmi.RemoteException;
    public java.lang.Boolean enviaCorreoOrigen(java.lang.String mensaje, java.lang.String correoDestino, java.lang.String[] listadoCorreoOrigen, java.lang.String asunto) throws java.rmi.RemoteException;
    public java.lang.Boolean enviaCorreoRol(java.lang.String mensaje, java.lang.String rol, java.lang.String correoOrigen, java.lang.String asunto) throws java.rmi.RemoteException;
    public java.lang.Boolean enviaCorreoRolCC(java.lang.String mensaje, java.lang.String rol, java.lang.String correoOrigen, java.lang.String asunto, java.lang.String correoBackup) throws java.rmi.RemoteException;
    public java.lang.Boolean enviaCorreoRolSistema(java.lang.String mensaje, java.lang.String rol, java.lang.String correoOrigen, java.lang.String asunto, java.lang.Integer sistema) throws java.rmi.RemoteException;
    public java.lang.Boolean envioCorreo(java.lang.String mensaje, java.lang.String correoDestino, java.lang.String correoOrigen, java.lang.String asunto) throws java.rmi.RemoteException;
    public java.lang.Boolean envioCorreoAdjunto(java.lang.String mensaje, java.lang.String correoDestino, java.lang.String correoOrigen, java.lang.String asunto, java.lang.String nombreArchivo, byte[] datos) throws java.rmi.RemoteException;
    public java.lang.Boolean enviaCorreoCodigoFuncionario(java.lang.String mensaje, int[] listadoDestino, java.lang.String correoOrigen, java.lang.String asunto) throws java.rmi.RemoteException;
    public java.lang.Boolean enviaCorreoporAreayPuesto(java.lang.String mensaje, java.lang.String asunto, java.lang.String correoOrigen, java.lang.String area, java.lang.String puesto) throws java.rmi.RemoteException;
}
