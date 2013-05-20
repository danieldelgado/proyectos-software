package com.demo.geolocalizacion.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the geolocalizacion database table.
 * 
 */
@Entity
@Table(name="geolocalizacion")
public class Geolocalizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_geolocalizacion")
	private int idGeolocalizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Telefono telefono;
		
	@OneToMany(mappedBy="geolocalizacion")
	private List<PuntoGeolocalizacion> puntoGeolocalizacions;

	public Geolocalizacion() {
	}

	public int getIdGeolocalizacion() {
		return this.idGeolocalizacion;
	}

	public void setIdGeolocalizacion(int idGeolocalizacion) {
		this.idGeolocalizacion = idGeolocalizacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public List<PuntoGeolocalizacion> getPuntoGeolocalizacions() {
		return this.puntoGeolocalizacions;
	}

	public void setPuntoGeolocalizacions(List<PuntoGeolocalizacion> puntoGeolocalizacions) {
		this.puntoGeolocalizacions = puntoGeolocalizacions;
	}

}