package com.demo.geolocalizacion.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the telefono database table.
 * 
 */
@Entity
@Table(name="telefono")
public class Telefono  extends Usuario  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="numero", length=12,nullable=false)
	private String numero;

	@Column(name="tipo_telefono", length=1,nullable=false)
	private Integer tipoTelefono;
	
	@OneToMany(mappedBy="telefono")
	private List<Geolocalizacion> geolocalizaciones;

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

	public List<Geolocalizacion> getGeolocalizaciones() {
		return geolocalizaciones;
	}

	public void setGeolocalizaciones(List<Geolocalizacion> geolocalizaciones) {
		this.geolocalizaciones = geolocalizaciones;
	}

}