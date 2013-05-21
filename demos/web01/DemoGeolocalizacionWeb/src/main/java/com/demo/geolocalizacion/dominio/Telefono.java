package com.demo.geolocalizacion.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the telefono database table.
 * 
 */
@XmlRootElement(name = "telefono")  
@XmlAccessorType(XmlAccessType.FIELD) 
@Entity
@Table(name="telefono")
public class Telefono  extends Usuario  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="numero", length=12,nullable=false)
	@XmlElement(name = "numero")
	private String numero;

	@Column(name="tipo_telefono", length=1,nullable=false)
	@XmlElement(name = "tipoTelefono")
	private Integer tipoTelefono;
	
//	@XmlTransient
//	@OneToMany(mappedBy="telefono")
//	private List<Geolocalizacion> geolocalizaciones;

	public Telefono() {
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getTipoTelefono() {
		return this.tipoTelefono;
	}

	public void setTipoTelefono(Integer tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

//	public List<Geolocalizacion> getGeolocalizaciones() {
//		return geolocalizaciones;
//	}
//
//	public void setGeolocalizaciones(List<Geolocalizacion> geolocalizaciones) {
//		this.geolocalizaciones = geolocalizaciones;
//	}

}