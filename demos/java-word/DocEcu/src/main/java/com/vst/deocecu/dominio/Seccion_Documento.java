package com.vst.deocecu.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.deocecu.util.Entidad;

@Entity
@Table(name = "Seccion_Documento")
public class Seccion_Documento implements Entidad{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_Seccion_Documento")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaActua")
	private Date fechaActua;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private  Proyecto proyecto;
	
	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "documentos")
	private List<Documento>  lstdocumentos;
	
	public Seccion_Documento(){
		
	}

	





	public Proyecto getProyecto() {
		return proyecto;
	}







	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}







	public List<Documento> getLstdocumentos() {
		return lstdocumentos;
	}







	public void setLstdocumentos(List<Documento> lstdocumentos) {
		this.lstdocumentos = lstdocumentos;
	}







	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
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
