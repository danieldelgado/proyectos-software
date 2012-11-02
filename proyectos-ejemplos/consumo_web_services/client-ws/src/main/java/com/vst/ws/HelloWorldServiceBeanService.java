/**
 * HelloWorldServiceBeanService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vst.ws;

public interface HelloWorldServiceBeanService extends javax.xml.rpc.Service {
    public java.lang.String getHelloWorldServiceBeanPortAddress();

    public com.vst.ws.HelloWorldService getHelloWorldServiceBeanPort() throws javax.xml.rpc.ServiceException;

    public com.vst.ws.HelloWorldService getHelloWorldServiceBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
