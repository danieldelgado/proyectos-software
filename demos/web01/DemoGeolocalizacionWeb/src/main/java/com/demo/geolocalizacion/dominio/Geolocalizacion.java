package com.demo.geolocalizacion.dominio;

import java.io.Serializable;
import javax.persistence.*;

import com.demo.geolocalizacion.util.Entidad;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the geolocalizacion database table.
 * 
 */
@Entity
@Table(name="geolocalizacion")
public class Geolocalizacion implements Entidad, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_geolocalizacion")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Telefono telefono;
			
//	@OneToMany(mappedBy="geolocalizacion")
//	private List<PuntoGeolocalizacion> puntoGeolocalizacions;

	public Geolocalizacion() {
	}

	

	public Geolocalizacion(Integer id, Date fechaRegistro) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
	}

	public Geolocalizacion(Integer id, Date fechaRegistro,Telefono telefono) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
		this.telefono = telefono;
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

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

//	public List<PuntoGeolocalizacion> getPuntoGeolocalizacions() {
//		return this.puntoGeolocalizacions;
//	}
//
//	public void setPuntoGeolocalizacions(List<PuntoGeolocalizacion> puntoGeolocalizacions) {
//		this.puntoGeolocalizacions = puntoGeolocalizacions;
//	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

}