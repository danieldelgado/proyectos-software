package com.vst.deocecu.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.deocecu.util.Entidad;

@Entity
@Table(name = "Proyecto")
public class Proyecto implements Entidad{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_proyecto")
	private Integer id;
	@Column(name = "folder")
	private String folder;

	@Column(name = "ruta_padre")
	private String ruta_padre;

	@Column(name = "ruta_Absoluta")
	private String ruta_Absoluta; 

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descripcion")
	private String descripcion; 

	@Column(name = "address")
	private String address; 

	@Column(name = "scheme")
	private String scheme;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@Column(name = "fechaActua")
	private Date fechaActua;
	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "proyecto")
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Seccion_Documento>  seccion_Documentos;
	
	
	public Proyecto(){
		
	}

	public Proyecto( Integer id , String folder, String ruta_padre, String ruta_Absoluta, String uuid, String address, String scheme) {
		this.id = id;
		this.folder = folder;
		this.ruta_padre = ruta_padre;
		this.ruta_Absoluta = ruta_Absoluta;
		this.uuid = uuid;
		this.address = address;
		this.scheme = scheme;
	}

	public Proyecto(String folder, String ruta_padre, String ruta_Absoluta, String uuid, String address, String scheme) {
		this.folder = folder;
		this.ruta_padre = ruta_padre;
		this.ruta_Absoluta = ruta_Absoluta;
		this.uuid = uuid;
		this.address = address;
		this.scheme = scheme;
	}





	public String getFolder() {
		return folder;
	}



	public void setFolder(String folder) {
		this.folder = folder;
	}







	public String getRuta_padre() {
		return ruta_padre;
	}

	public void setRuta_padre(String ruta_padre) {
		this.ruta_padre = ruta_padre;
	}

	public String getRuta_Absoluta() {
		return ruta_Absoluta;
	}

	public void setRuta_Absoluta(String ruta_Absoluta) {
		this.ruta_Absoluta = ruta_Absoluta;
	}

	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getScheme() {
		return scheme;
	}



	public void setScheme(String scheme) {
		this.scheme = scheme;
	}


	

	public List<Seccion_Documento> getSeccion_Documentos() {
		return seccion_Documentos;
	}

	public void setSeccion_Documentos(List<Seccion_Documento> seccion_Documentos) {
		this.seccion_Documentos = seccion_Documentos;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean getActivo() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActua() {
		return fechaActua;
	}

	public void setFechaActua(Date fechaActua) {
		this.fechaActua = fechaActua;
	}

}
