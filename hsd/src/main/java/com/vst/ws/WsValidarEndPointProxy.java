package com.vst.ws;

public class WsValidarEndPointProxy implements com.vst.ws.WsValidarEndPoint {
  private String _endpoint = null;
  private com.vst.ws.WsValidarEndPoint wsValidarEndPoint = null;
  
  public WsValidarEndPointProxy() {
    _initWsValidarEndPointProxy();
  }
  
  public WsValidarEndPointProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsValidarEndPointProxy();
  }
  
  private void _initWsValidarEndPointProxy() {
    try {
      wsValidarEndPoint = (new com.vst.ws.ServicioValidarLocator()).getwsValidarEndPointPort();
      if (wsValidarEndPoint != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsValidarEndPoint)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsValidarEndPoint)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsValidarEndPoint != null)
      ((javax.xml.rpc.Stub)wsValidarEndPoint)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vst.ws.WsValidarEndPoint getWsValidarEndPoint() {
    if (wsValidarEndPoint == null)
      _initWsValidarEndPointProxy();
    return wsValidarEndPoint;
  }
  
  public com.vst.ws.Validador validarParametros(com.vst.ws.CamposValidar[] lstCamposValidar) throws java.rmi.RemoteException{
    if (wsValidarEndPoint == null)
      _initWsValidarEndPointProxy();
    return wsValidarEndPoint.validarParametros(lstCamposValidar);
  }
  
  public java.lang.String msj(java.lang.String msjPrueba) throws java.rmi.RemoteException{
    if (wsValidarEndPoint == null)
      _initWsValidarEndPointProxy();
    return wsValidarEndPoint.msj(msjPrueba);
  }
  
  
}