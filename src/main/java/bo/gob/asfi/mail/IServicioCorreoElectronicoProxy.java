package bo.gob.asfi.mail;

public class IServicioCorreoElectronicoProxy implements bo.gob.asfi.mail.IServicioCorreoElectronico {
  private String _endpoint = null;
  private bo.gob.asfi.mail.IServicioCorreoElectronico iServicioCorreoElectronico = null;
  
  public IServicioCorreoElectronicoProxy() {
    _initIServicioCorreoElectronicoProxy();
  }
  
  public IServicioCorreoElectronicoProxy(String endpoint) {
    _endpoint = endpoint;
    _initIServicioCorreoElectronicoProxy();
  }
  
  private void _initIServicioCorreoElectronicoProxy() {
    try {
      iServicioCorreoElectronico = (new bo.gob.asfi.mail.ServicioCorreoElectronicoLocator()).getBasicHttpBinding_Autenticacion();
      if (iServicioCorreoElectronico != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iServicioCorreoElectronico)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iServicioCorreoElectronico)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iServicioCorreoElectronico != null)
      ((javax.xml.rpc.Stub)iServicioCorreoElectronico)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public bo.gob.asfi.mail.IServicioCorreoElectronico getIServicioCorreoElectronico() {
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico;
  }
  
  public java.lang.Boolean enviaCorreoCopia(java.lang.String mensaje, java.lang.String[] listadoCorreoDestino, java.lang.String correoOrigen, java.lang.String asunto, java.lang.String[] listadoCopia) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoCopia(mensaje, listadoCorreoDestino, correoOrigen, asunto, listadoCopia);
  }
  
  public java.lang.Boolean enviaCorreoEntidad(java.lang.String mensaje, java.lang.String codTipoEntidad, java.lang.String nroCorrelativoEntidad, java.lang.String correo, java.lang.Integer idEntidad, java.lang.String asunto) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoEntidad(mensaje, codTipoEntidad, nroCorrelativoEntidad, correo, idEntidad, asunto);
  }
  
  public java.lang.Boolean enviaCorreoOrigen(java.lang.String mensaje, java.lang.String correoDestino, java.lang.String[] listadoCorreoOrigen, java.lang.String asunto) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoOrigen(mensaje, correoDestino, listadoCorreoOrigen, asunto);
  }
  
  public java.lang.Boolean enviaCorreoRol(java.lang.String mensaje, java.lang.String rol, java.lang.String correoOrigen, java.lang.String asunto) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoRol(mensaje, rol, correoOrigen, asunto);
  }
  
  public java.lang.Boolean enviaCorreoRolCC(java.lang.String mensaje, java.lang.String rol, java.lang.String correoOrigen, java.lang.String asunto, java.lang.String correoBackup) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoRolCC(mensaje, rol, correoOrigen, asunto, correoBackup);
  }
  
  public java.lang.Boolean enviaCorreoRolSistema(java.lang.String mensaje, java.lang.String rol, java.lang.String correoOrigen, java.lang.String asunto, java.lang.Integer sistema) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoRolSistema(mensaje, rol, correoOrigen, asunto, sistema);
  }
  
  public java.lang.Boolean envioCorreo(java.lang.String mensaje, java.lang.String correoDestino, java.lang.String correoOrigen, java.lang.String asunto) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.envioCorreo(mensaje, correoDestino, correoOrigen, asunto);
  }
  
  public java.lang.Boolean envioCorreoAdjunto(java.lang.String mensaje, java.lang.String correoDestino, java.lang.String correoOrigen, java.lang.String asunto, java.lang.String nombreArchivo, byte[] datos) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.envioCorreoAdjunto(mensaje, correoDestino, correoOrigen, asunto, nombreArchivo, datos);
  }
  
  public java.lang.Boolean enviaCorreoCodigoFuncionario(java.lang.String mensaje, int[] listadoDestino, java.lang.String correoOrigen, java.lang.String asunto) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoCodigoFuncionario(mensaje, listadoDestino, correoOrigen, asunto);
  }
  
  public java.lang.Boolean enviaCorreoporAreayPuesto(java.lang.String mensaje, java.lang.String asunto, java.lang.String correoOrigen, java.lang.String area, java.lang.String puesto) throws java.rmi.RemoteException{
    if (iServicioCorreoElectronico == null)
      _initIServicioCorreoElectronicoProxy();
    return iServicioCorreoElectronico.enviaCorreoporAreayPuesto(mensaje, asunto, correoOrigen, area, puesto);
  }
  
  
}