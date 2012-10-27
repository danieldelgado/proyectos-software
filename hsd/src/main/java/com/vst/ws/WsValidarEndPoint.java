/**
 * WsValidarEndPoint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vst.ws;

public interface WsValidarEndPoint extends java.rmi.Remote {
    public com.vst.ws.Validador validarParametros(com.vst.ws.CamposValidar[] lstCamposValidar) throws java.rmi.RemoteException;
    public java.lang.String msj(java.lang.String msjPrueba) throws java.rmi.RemoteException;
}
