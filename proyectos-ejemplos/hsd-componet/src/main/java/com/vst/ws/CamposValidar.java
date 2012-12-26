/**
 * CamposValidar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vst.ws;

public class CamposValidar  implements java.io.Serializable {
    private java.lang.String tipo;

    private java.lang.String entidad;

    private java.lang.String campo;

    private java.lang.String valor;

    private java.lang.String format;

    private java.lang.Boolean valid;

    public CamposValidar() {
    }

    public CamposValidar(
           java.lang.String tipo,
           java.lang.String entidad,
           java.lang.String campo,
           java.lang.String valor,
           java.lang.String format,
           java.lang.Boolean valid) {
           this.tipo = tipo;
           this.entidad = entidad;
           this.campo = campo;
           this.valor = valor;
           this.format = format;
           this.valid = valid;
    }


    /**
     * Gets the tipo value for this CamposValidar.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this CamposValidar.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the entidad value for this CamposValidar.
     * 
     * @return entidad
     */
    public java.lang.String getEntidad() {
        return entidad;
    }


    /**
     * Sets the entidad value for this CamposValidar.
     * 
     * @param entidad
     */
    public void setEntidad(java.lang.String entidad) {
        this.entidad = entidad;
    }


    /**
     * Gets the campo value for this CamposValidar.
     * 
     * @return campo
     */
    public java.lang.String getCampo() {
        return campo;
    }


    /**
     * Sets the campo value for this CamposValidar.
     * 
     * @param campo
     */
    public void setCampo(java.lang.String campo) {
        this.campo = campo;
    }


    /**
     * Gets the valor value for this CamposValidar.
     * 
     * @return valor
     */
    public java.lang.String getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this CamposValidar.
     * 
     * @param valor
     */
    public void setValor(java.lang.String valor) {
        this.valor = valor;
    }


    /**
     * Gets the format value for this CamposValidar.
     * 
     * @return format
     */
    public java.lang.String getFormat() {
        return format;
    }


    /**
     * Sets the format value for this CamposValidar.
     * 
     * @param format
     */
    public void setFormat(java.lang.String format) {
        this.format = format;
    }


    /**
     * Gets the valid value for this CamposValidar.
     * 
     * @return valid
     */
    public java.lang.Boolean getValid() {
        return valid;
    }


    /**
     * Sets the valid value for this CamposValidar.
     * 
     * @param valid
     */
    public void setValid(java.lang.Boolean valid) {
        this.valid = valid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CamposValidar)) return false;
        CamposValidar other = (CamposValidar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.entidad==null && other.getEntidad()==null) || 
             (this.entidad!=null &&
              this.entidad.equals(other.getEntidad()))) &&
            ((this.campo==null && other.getCampo()==null) || 
             (this.campo!=null &&
              this.campo.equals(other.getCampo()))) &&
            ((this.valor==null && other.getValor()==null) || 
             (this.valor!=null &&
              this.valor.equals(other.getValor()))) &&
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.valid==null && other.getValid()==null) || 
             (this.valid!=null &&
              this.valid.equals(other.getValid())));
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
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getEntidad() != null) {
            _hashCode += getEntidad().hashCode();
        }
        if (getCampo() != null) {
            _hashCode += getCampo().hashCode();
        }
        if (getValor() != null) {
            _hashCode += getValor().hashCode();
        }
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getValid() != null) {
            _hashCode += getValid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
