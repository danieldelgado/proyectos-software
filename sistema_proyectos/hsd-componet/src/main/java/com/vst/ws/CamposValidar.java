/**
 * CamposValidar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vst.ws;

public class CamposValidar  implements java.io.Serializable {
    private java.lang.String nombreCampo;

    private java.lang.Integer entero;

    private java.lang.Double decimal;

    private java.lang.String cadena;

    private java.util.Calendar fecha;

    private java.lang.String valorFormat;

    private java.lang.String format;

    private java.lang.Integer tipo;

    private java.lang.Boolean valid;

    private java.lang.String entidad;

    private java.lang.String campo;

    public CamposValidar() {
    }

    public CamposValidar(
           java.lang.String nombreCampo,
           java.lang.Integer entero,
           java.lang.Double decimal,
           java.lang.String cadena,
           java.util.Calendar fecha,
           java.lang.String valorFormat,
           java.lang.String format,
           java.lang.Integer tipo,
           java.lang.Boolean valid,
           java.lang.String entidad,
           java.lang.String campo) {
           this.nombreCampo = nombreCampo;
           this.entero = entero;
           this.decimal = decimal;
           this.cadena = cadena;
           this.fecha = fecha;
           this.valorFormat = valorFormat;
           this.format = format;
           this.tipo = tipo;
           this.valid = valid;
           this.entidad = entidad;
           this.campo = campo;
    }


    /**
     * Gets the nombreCampo value for this CamposValidar.
     * 
     * @return nombreCampo
     */
    public java.lang.String getNombreCampo() {
        return nombreCampo;
    }


    /**
     * Sets the nombreCampo value for this CamposValidar.
     * 
     * @param nombreCampo
     */
    public void setNombreCampo(java.lang.String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }


    /**
     * Gets the entero value for this CamposValidar.
     * 
     * @return entero
     */
    public java.lang.Integer getEntero() {
        return entero;
    }


    /**
     * Sets the entero value for this CamposValidar.
     * 
     * @param entero
     */
    public void setEntero(java.lang.Integer entero) {
        this.entero = entero;
    }


    /**
     * Gets the decimal value for this CamposValidar.
     * 
     * @return decimal
     */
    public java.lang.Double getDecimal() {
        return decimal;
    }


    /**
     * Sets the decimal value for this CamposValidar.
     * 
     * @param decimal
     */
    public void setDecimal(java.lang.Double decimal) {
        this.decimal = decimal;
    }


    /**
     * Gets the cadena value for this CamposValidar.
     * 
     * @return cadena
     */
    public java.lang.String getCadena() {
        return cadena;
    }


    /**
     * Sets the cadena value for this CamposValidar.
     * 
     * @param cadena
     */
    public void setCadena(java.lang.String cadena) {
        this.cadena = cadena;
    }


    /**
     * Gets the fecha value for this CamposValidar.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this CamposValidar.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the valorFormat value for this CamposValidar.
     * 
     * @return valorFormat
     */
    public java.lang.String getValorFormat() {
        return valorFormat;
    }


    /**
     * Sets the valorFormat value for this CamposValidar.
     * 
     * @param valorFormat
     */
    public void setValorFormat(java.lang.String valorFormat) {
        this.valorFormat = valorFormat;
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
     * Gets the tipo value for this CamposValidar.
     * 
     * @return tipo
     */
    public java.lang.Integer getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this CamposValidar.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.Integer tipo) {
        this.tipo = tipo;
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
            ((this.nombreCampo==null && other.getNombreCampo()==null) || 
             (this.nombreCampo!=null &&
              this.nombreCampo.equals(other.getNombreCampo()))) &&
            ((this.entero==null && other.getEntero()==null) || 
             (this.entero!=null &&
              this.entero.equals(other.getEntero()))) &&
            ((this.decimal==null && other.getDecimal()==null) || 
             (this.decimal!=null &&
              this.decimal.equals(other.getDecimal()))) &&
            ((this.cadena==null && other.getCadena()==null) || 
             (this.cadena!=null &&
              this.cadena.equals(other.getCadena()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.valorFormat==null && other.getValorFormat()==null) || 
             (this.valorFormat!=null &&
              this.valorFormat.equals(other.getValorFormat()))) &&
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.valid==null && other.getValid()==null) || 
             (this.valid!=null &&
              this.valid.equals(other.getValid()))) &&
            ((this.entidad==null && other.getEntidad()==null) || 
             (this.entidad!=null &&
              this.entidad.equals(other.getEntidad()))) &&
            ((this.campo==null && other.getCampo()==null) || 
             (this.campo!=null &&
              this.campo.equals(other.getCampo())));
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
        if (getNombreCampo() != null) {
            _hashCode += getNombreCampo().hashCode();
        }
        if (getEntero() != null) {
            _hashCode += getEntero().hashCode();
        }
        if (getDecimal() != null) {
            _hashCode += getDecimal().hashCode();
        }
        if (getCadena() != null) {
            _hashCode += getCadena().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getValorFormat() != null) {
            _hashCode += getValorFormat().hashCode();
        }
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getValid() != null) {
            _hashCode += getValid().hashCode();
        }
        if (getEntidad() != null) {
            _hashCode += getEntidad().hashCode();
        }
        if (getCampo() != null) {
            _hashCode += getCampo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
