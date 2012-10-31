/**
 * Validador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vst.ws;

public class Validador  implements java.io.Serializable {
    private int respuesta;

    private java.lang.Integer[] codigosErrors;

    public Validador() {
    }

    public Validador(
           int respuesta,
           java.lang.Integer[] codigosErrors) {
           this.respuesta = respuesta;
           this.codigosErrors = codigosErrors;
    }


    /**
     * Gets the respuesta value for this Validador.
     * 
     * @return respuesta
     */
    public int getRespuesta() {
        return respuesta;
    }


    /**
     * Sets the respuesta value for this Validador.
     * 
     * @param respuesta
     */
    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }


    /**
     * Gets the codigosErrors value for this Validador.
     * 
     * @return codigosErrors
     */
    public java.lang.Integer[] getCodigosErrors() {
        return codigosErrors;
    }


    /**
     * Sets the codigosErrors value for this Validador.
     * 
     * @param codigosErrors
     */
    public void setCodigosErrors(java.lang.Integer[] codigosErrors) {
        this.codigosErrors = codigosErrors;
    }

    public java.lang.Integer getCodigosErrors(int i) {
        return this.codigosErrors[i];
    }

    public void setCodigosErrors(int i, java.lang.Integer _value) {
        this.codigosErrors[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Validador)) return false;
        Validador other = (Validador) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.respuesta == other.getRespuesta() &&
            ((this.codigosErrors==null && other.getCodigosErrors()==null) || 
             (this.codigosErrors!=null &&
              java.util.Arrays.equals(this.codigosErrors, other.getCodigosErrors())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getRespuesta();
        if (getCodigosErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCodigosErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCodigosErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
