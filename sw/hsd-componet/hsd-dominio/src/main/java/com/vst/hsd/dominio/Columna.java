package com.vst.hsd.dominio;

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
					table = "sequence_table", 
					pkColumnName = "sequence_name", 
					valueColumnName = "sequence_value")
	@Column(name="id_columna")
	private Integer id;

	
	@Column(name="addColumn",nullable=false)
	private Boolean addColumn;

	@Column(name="ancho",length=4,nullable=false)
	private Integer ancho;

	@Column(name="atributo",length=50,nullable=false)
	private String atributo;

	@Column(name="cabecera",length=50,nullable=false)
	private String cabecera;

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;

	@Column(name="tabla",length=50,nullable=false)
	private String tabla;
	
	@Column(name="alineacion",length=50,nullable=false)
	private String alineacion;

	@Column(name="formato_tipo",length=50,nullable=false)
	private String formato_tipo;

	
	@Column(name="mapping",nullable=false)
	private Boolean mapping;

	@Column(name="visible",nullable=false)
	private Boolean visible;
	
	@Column(name="orden",nullable=false)
	private Integer orden;

	@ManyToMany(mappedBy="columnas")
	private List<Lista> listas;
	 
	@Temporal( TemporalType.DATE)	 
	@Column(name="fecha_actualizacion",nullable=false)
	private Date fechaActualizacion;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_registro",nullable=false)
	private Date fechaRegistro;
	
	@Column(name="estado",length=1,nullable=false)
	private Character estado;

	@Column(name="activo",nullable=false)
	private Boolean activo;
	
    public Columna() {
    }
    
    
    

	public Columna(Integer id, Boolean addColumn, Integer ancho,
			String atributo, String cabecera, String codigo, String tabla,
			String alineacion, String formato_tipo, Boolean mapping,
			Boolean visible, Integer orden, Character estado, Boolean activo) {
		this.id = id;
		this.addColumn = addColumn;
		this.ancho = ancho;
		this.atributo = atributo;
		this.cabecera = cabecera;
		this.codigo = codigo;
		this.tabla = tabla;
		this.alineacion = alineacion;
		this.formato_tipo = formato_tipo;
		this.mapping = mapping;
		this.visible = visible;
		this.orden = orden;
		this.estado = estado;
		this.activo = activo;
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

	public String getAlineacion() {
		return alineacion;
	}

	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}

	public String getFormato_tipo() {
		return formato_tipo;
	}

	public void setFormato_tipo(String formato_tipo) {
		this.formato_tipo = formato_tipo;
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

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	

	
}