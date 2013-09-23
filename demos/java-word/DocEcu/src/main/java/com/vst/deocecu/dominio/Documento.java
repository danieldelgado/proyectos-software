package com.vst.deocecu.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.deocecu.util.Entidad;

@Entity
@Table(name = "Documento")
public class Documento implements Entidad{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_documento")
	private Integer id;

	@Column(name = "ruta_alfresco")
	private String ruta_alfresco;

	@Column(name = "content_html")
	private String content_html;
	
	@Column(name = "ruta_Absoluta")
	private String ruta_Absoluta; 

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaActua")
	private Date fechaActua;

	@Column(name = "isDocumento")
	private Boolean isDocumento;
	
	@ManyToOne(fetch=FetchType.EAGER)  
//	@JoinColumn(name = "seccion_documento")
	private Seccion_Documento seccion_documento;
	
	public Documento(){
		
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




	public String getRuta_alfresco() {
		return ruta_alfresco;
	}


	public void setRuta_alfresco(String ruta_alfresco) {
		this.ruta_alfresco = ruta_alfresco;
	}


	public String getContent_html() {
		return content_html;
	}


	public void setContent_html(String content_html) {
		this.content_html = content_html;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public Boolean getIsDocumento() {
		return isDocumento;
	}


	public void setIsDocumento(Boolean isDocumento) {
		this.isDocumento = isDocumento;
	}

	

	public Seccion_Documento getSeccion_documento() {
		return seccion_documento;
	}




	public void setSeccion_documento(Seccion_Documento seccion_documento) {
		this.seccion_documento = seccion_documento;
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

}
