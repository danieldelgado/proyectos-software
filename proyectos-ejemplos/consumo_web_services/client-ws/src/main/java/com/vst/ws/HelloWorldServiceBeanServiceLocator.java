/**
 * HelloWorldServiceBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vst.ws;

public class HelloWorldServiceBeanServiceLocator extends org.apache.axis.client.Service implements com.vst.ws.HelloWorldServiceBeanService {

    public HelloWorldServiceBeanServiceLocator() {
    }


    public HelloWorldServiceBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWorldServiceBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWorldServiceBeanPort
    private java.lang.String HelloWorldServiceBeanPort_address = "http://localhost:8080/servicio-web-validacion/HelloWorld";

    public java.lang.String getHelloWorldServiceBeanPortAddress() {
        return HelloWorldServiceBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWorldServiceBeanPortWSDDServiceName = "HelloWorldServiceBeanPort";

    public java.lang.String getHelloWorldServiceBeanPortWSDDServiceName() {
        return HelloWorldServiceBeanPortWSDDServiceName;
    }

    public void setHelloWorldServiceBeanPortWSDDServiceName(java.lang.String name) {
        HelloWorldServiceBeanPortWSDDServiceName = name;
    }

    public com.vst.ws.HelloWorldService getHelloWorldServiceBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWorldServiceBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWorldServiceBeanPort(endpoint);
    }

    public com.vst.ws.HelloWorldService getHelloWorldServiceBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.vst.ws.HelloWorldServiceBeanServiceSoapBindingStub _stub = new com.vst.ws.HelloWorldServiceBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getHelloWorldServiceBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWorldServiceBeanPortEndpointAddress(java.lang.String address) {
        HelloWorldServiceBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.vst.ws.HelloWorldService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.vst.ws.HelloWorldServiceBeanServiceSoapBindingStub _stub = new com.vst.ws.HelloWorldServiceBeanServiceSoapBindingStub(new java.net.URL(HelloWorldServiceBeanPort_address), this);
                _stub.setPortName(getHelloWorldServiceBeanPortWSDDServiceName());
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
        if ("HelloWorldServiceBeanPort".equals(inputPortName)) {
            return getHelloWorldServiceBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.vst.com/", "HelloWorldServiceBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.vst.com/", "HelloWorldServiceBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWorldServiceBeanPort".equals(portName)) {
            setHelloWorldServiceBeanPortEndpointAddress(address);
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
