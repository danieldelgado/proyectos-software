package com.vst.ws;

public class HelloWorldServiceProxy implements com.vst.ws.HelloWorldService {
  private String _endpoint = null;
  private com.vst.ws.HelloWorldService helloWorldService = null;
  
  public HelloWorldServiceProxy() {
    _initHelloWorldServiceProxy();
  }
  
  public HelloWorldServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWorldServiceProxy();
  }
  
  private void _initHelloWorldServiceProxy() {
    try {
      helloWorldService = (new com.vst.ws.HelloWorldServiceBeanServiceLocator()).getHelloWorldServiceBeanPort();
      if (helloWorldService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWorldService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWorldService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWorldService != null)
      ((javax.xml.rpc.Stub)helloWorldService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vst.ws.HelloWorldService getHelloWorldService() {
    if (helloWorldService == null)
      _initHelloWorldServiceProxy();
    return helloWorldService;
  }
  
  public java.lang.String sayHello(java.lang.String arg0) throws java.rmi.RemoteException{
    if (helloWorldService == null)
      _initHelloWorldServiceProxy();
    return helloWorldService.sayHello(arg0);
  }
  
  
}