package com.vst.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.Entidad;


/**
 * The persistent class for the columna database table.
 * 
 */
@Entity
@Table(name="columna")
public class Columna implements Entidad , Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator",
					table = "sequence", 
					pkColumnName = "sequence_recurso_name", 
					valueColumnName = "sequence_recurso_value")
	@Column(name="id_columna")
	private Integer id;

	
	@Column(name="addColumn")
	private Boolean addColumn;

	@Column(name="ancho",length=4)
	private Integer ancho;

	@Column(name="atributo",length=20)
	private String atributo;

	@Column(name="cabecera",length=20)
	private String cabecera;

	@Column(name="codigo",length=20)
	private String codigo;

	@Column(name="mapping")
	private Boolean mapping;

	@Column(name="visible")
	private Boolean visible;

	@ManyToMany(mappedBy="columnas")
	private List<Lista> listas;
	 
	@Temporal( TemporalType.DATE)	 
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal( TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	@Column(name="estado",length=1)
	private Character estado;

	@Column(name="activo")
	private Boolean activo;
	
    public Columna() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAddColumn() {
		return addColumn;
	}

	public void setAddColumn(Boolean addColumn) {
		this.addColumn = addColumn;
	}

	public Integer getAncho() {
		return ancho;
	}

	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getMapping() {
		return mapping;
	}

	public void setMapping(Boolean mapping) {
		this.mapping = mapping;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public List<Lista> getListas() {
		return listas;
	}

	public void setListas(List<Lista> listas) {
		this.listas = listas;
	}

	public String getLabel() {
		return null;
	}

	
	public String getNombreCompleto() {
		return null;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	

	
}