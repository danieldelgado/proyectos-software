/**
 * WsValidarEndPointServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vst.ws;

public class WsValidarEndPointServiceLocator extends org.apache.axis.client.Service implements com.vst.ws.WsValidarEndPointService {

    public WsValidarEndPointServiceLocator() {
    }


    public WsValidarEndPointServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsValidarEndPointServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wsValidarEndPointPort
    private java.lang.String wsValidarEndPointPort_address = "http://localhost:8080/servicio-web-validacion/service/operation/servicio_validacion";

    public java.lang.String getwsValidarEndPointPortAddress() {
        return wsValidarEndPointPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wsValidarEndPointPortWSDDServiceName = "wsValidarEndPointPort";

    public java.lang.String getwsValidarEndPointPortWSDDServiceName() {
        return wsValidarEndPointPortWSDDServiceName;
    }

    public void setwsValidarEndPointPortWSDDServiceName(java.lang.String name) {
        wsValidarEndPointPortWSDDServiceName = name;
    }

    public com.vst.ws.WsValidarEndPoint getwsValidarEndPointPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wsValidarEndPointPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwsValidarEndPointPort(endpoint);
    }

    public com.vst.ws.WsValidarEndPoint getwsValidarEndPointPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.vst.ws.WsValidarEndPointServiceSoapBindingStub _stub = new com.vst.ws.WsValidarEndPointServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getwsValidarEndPointPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwsValidarEndPointPortEndpointAddress(java.lang.String address) {
        wsValidarEndPointPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.vst.ws.WsValidarEndPoint.class.isAssignableFrom(serviceEndpointInterface)) {
                com.vst.ws.WsValidarEndPointServiceSoapBindingStub _stub = new com.vst.ws.WsValidarEndPointServiceSoapBindingStub(new java.net.URL(wsValidarEndPointPort_address), this);
                _stub.setPortName(getwsValidarEndPointPortWSDDServiceName());
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
        if ("wsValidarEndPointPort".equals(inputPortName)) {
            return getwsValidarEndPointPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.vst.com/", "wsValidarEndPointService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.vst.com/", "wsValidarEndPointPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wsValidarEndPointPort".equals(portName)) {
            setwsValidarEndPointPortEndpointAddress(address);
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
