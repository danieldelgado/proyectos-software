package com.demo.demogeolocalizacion.ws.client;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class GeolocalizacionWService {
//	http://192.168.43.123:9998/WebServiceGeolocalizacion?wsdl
	private static final String SOAP_ACTION = "http://endpoint.ws.geolocalizacion.demo.com/geolocalizacion";
    private static final String METHOD_NAME = "sayHello";
    private static final String NAMESPACE = "http://endpoint.ws.geolocalizacion.demo.com/";
    private static final String URL = "http://192.168.43.123:9998/WebServiceGeolocalizacion?wsdl";
 
    public String Convert(String fromCurrency) {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("msj", fromCurrency);
 
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try {
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            return result.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
