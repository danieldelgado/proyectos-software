package com.demo.geolocalizacion.dominio;

import java.io.Serializable;
import javax.persistence.*;

import com.demo.geolocalizacion.util.Entidad;

import java.util.Date;


/**
 * The persistent class for the punto_geolocalizacion database table.
 * 
 */
@Entity
@Table(name="punto_geolocalizacion")
public class PuntoGeolocalizacion implements Entidad, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_punto")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="latitud", length=50,nullable=false)
	private String latitud;

	@Column(name="longitud", length=50,nullable=false)
	private String longitud;

	@Column(name="flagPuntoInicial")
	private Boolean flagPuntoInicial;
	
	@ManyToOne
	private Geolocalizacion geolocalizacion;

	public PuntoGeolocalizacion() {
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public Geolocalizacion getGeolocalizacion() {
		return this.geolocalizacion;
	}

	public void setGeolocalizacion(Geolocalizacion geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
	
	public Boolean getFlagPuntoInicial() {
		return flagPuntoInicial;
	}

	public void setFlagPuntoInicial(Boolean flagPuntoInicial) {
		this.flagPuntoInicial = flagPuntoInicial;
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getNombreCompleto() {
		return null;
	}

}