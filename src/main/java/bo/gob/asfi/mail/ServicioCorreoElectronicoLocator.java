/**
 * ServicioCorreoElectronicoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bo.gob.asfi.mail;

public class ServicioCorreoElectronicoLocator extends org.apache.axis.client.Service implements bo.gob.asfi.mail.ServicioCorreoElectronico {

    public ServicioCorreoElectronicoLocator() {
    }


    public ServicioCorreoElectronicoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioCorreoElectronicoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_Autenticacion
    private java.lang.String BasicHttpBinding_Autenticacion_address = "http://srvservicios.asfi.gov.bo/ServicioCorreoOS/ServicioCorreoElectronico.svc";

    public java.lang.String getBasicHttpBinding_AutenticacionAddress() {
        return BasicHttpBinding_Autenticacion_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_AutenticacionWSDDServiceName = "BasicHttpBinding_Autenticacion";

    public java.lang.String getBasicHttpBinding_AutenticacionWSDDServiceName() {
        return BasicHttpBinding_AutenticacionWSDDServiceName;
    }

    public void setBasicHttpBinding_AutenticacionWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_AutenticacionWSDDServiceName = name;
    }

    public bo.gob.asfi.mail.IServicioCorreoElectronico getBasicHttpBinding_Autenticacion() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_Autenticacion_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_Autenticacion(endpoint);
    }

    public bo.gob.asfi.mail.IServicioCorreoElectronico getBasicHttpBinding_Autenticacion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            bo.gob.asfi.mail.BasicHttpBinding_AutenticacionStub _stub = new bo.gob.asfi.mail.BasicHttpBinding_AutenticacionStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_AutenticacionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_AutenticacionEndpointAddress(java.lang.String address) {
        BasicHttpBinding_Autenticacion_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (bo.gob.asfi.mail.IServicioCorreoElectronico.class.isAssignableFrom(serviceEndpointInterface)) {
                bo.gob.asfi.mail.BasicHttpBinding_AutenticacionStub _stub = new bo.gob.asfi.mail.BasicHttpBinding_AutenticacionStub(new java.net.URL(BasicHttpBinding_Autenticacion_address), this);
                _stub.setPortName(getBasicHttpBinding_AutenticacionWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_Autenticacion".equals(inputPortName)) {
            return getBasicHttpBinding_Autenticacion();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "ServicioCorreoElectronico");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_Autenticacion"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_Autenticacion".equals(portName)) {
            setBasicHttpBinding_AutenticacionEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
