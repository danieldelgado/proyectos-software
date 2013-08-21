package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.persistence.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the columna database table.
 * 
 */
@Entity
@Table(name = "columna")
public class Columna implements Entidad, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_columna")
	private Integer id;

	/** The add column. */
	@Column(name = "addColumn", nullable = false)
	private Boolean addColumn;

	/** The ancho. */
	@Column(name = "ancho", length = 4, nullable = false)
	private Integer ancho;

	/** The atributo. */
	@Column(name = "atributo", length = 50, nullable = false)
	private String atributo;

	/** The cabecera. */
	@Column(name = "cabecera", length = 50, nullable = false)
	private String cabecera;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/** The tabla. */
	@Column(name = "tabla", length = 50, nullable = false)
	private String tabla;

	/** The alineacion. */
	@Column(name = "alineacion", length = 50, nullable = false)
	private String alineacion;

	
	/** The formato_tipo. */
	@Column(name = "formato_tipo", length = 50, nullable = false)
	private String formato_tipo;

	/** The mapping. */
	@Column(name = "mapping", nullable = false)
	private Boolean mapping;

	/** The visible. */
	@Column(name = "visible", nullable = false)
	private Boolean visible;

	/** The orden. */
	@Column(name = "orden", nullable = false)
	private Integer orden;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion", nullable = false)
	private Date fechaActualizacion;

	/** The fecha registro. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false)
	private Date fechaRegistro;

	/** The estado. */
	@Column(name = "estado", length = 1, nullable = false)
	private Character estado;

	/** The activo. */
	@Column(name = "activo", nullable = false)
	private Boolean activo;

	/**
	 * Instantiates a new columna.
	 */
	public Columna() {
	}

	/**
	 * Instantiates a new columna.
	 * 
	 * @param id
	 *            the id
	 * @param addColumn
	 *            the add column
	 * @param ancho
	 *            the ancho
	 * @param atributo
	 *            the atributo
	 * @param cabecera
	 *            the cabecera
	 * @param codigo
	 *            the codigo
	 * @param tabla
	 *            the tabla
	 * @param alineacion
	 *            the alineacion
	 * @param formato_tipo
	 *            the formato_tipo
	 * @param mapping
	 *            the mapping
	 * @param visible
	 *            the visible
	 * @param orden
	 *            the orden
	 * @param estado
	 *            the estado
	 * @param activo
	 *            the activo
	 */
	public Columna(Integer id, Boolean addColumn, Integer ancho, String atributo, String cabecera, String codigo, String tabla, String alineacion, String formato_tipo, Boolean mapping,
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

	public Columna(Integer id, Boolean addColumn, Integer ancho, String atributo, String cabecera, String codigo, String tabla, String alineacion, String formato_tipo, Boolean visible, Integer orden,
			Character estado, Boolean activo) {
		this.id = id;
		this.addColumn = addColumn;
		this.ancho = ancho;
		this.atributo = atributo;
		this.cabecera = cabecera;
		this.codigo = codigo;
		this.tabla = tabla;
		this.alineacion = alineacion;
		this.formato_tipo = formato_tipo;
		this.visible = visible;
		this.orden = orden;
		this.estado = estado;
		this.activo = activo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getId()
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the adds the column.
	 * 
	 * @return the adds the column
	 */
	public Boolean getAddColumn() {
		return addColumn;
	}

	/**
	 * Sets the adds the column.
	 * 
	 * @param addColumn
	 *            the new adds the column
	 */
	public void setAddColumn(Boolean addColumn) {
		this.addColumn = addColumn;
	}

	/**
	 * Gets the ancho.
	 * 
	 * @return the ancho
	 */
	public Integer getAncho() {
		return ancho;
	}

	/**
	 * Sets the ancho.
	 * 
	 * @param ancho
	 *            the new ancho
	 */
	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	/**
	 * Gets the atributo.
	 * 
	 * @return the atributo
	 */
	public String getAtributo() {
		return atributo;
	}

	/**
	 * Gets the alineacion.
	 * 
	 * @return the alineacion
	 */
	public String getAlineacion() {
		return alineacion;
	}

	/**
	 * Sets the alineacion.
	 * 
	 * @param alineacion
	 *            the new alineacion
	 */
	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}

	/**
	 * Gets the formato_tipo.
	 * 
	 * @return the formato_tipo
	 */
	public String getFormato_tipo() {
		return formato_tipo;
	}

	/**
	 * Sets the formato_tipo.
	 * 
	 * @param formato_tipo
	 *            the new formato_tipo
	 */
	public void setFormato_tipo(String formato_tipo) {
		this.formato_tipo = formato_tipo;
	}

	/**
	 * Sets the atributo.
	 * 
	 * @param atributo
	 *            the new atributo
	 */
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	/**
	 * Gets the cabecera.
	 * 
	 * @return the cabecera
	 */
	public String getCabecera() {
		return cabecera;
	}

	/**
	 * Sets the cabecera.
	 * 
	 * @param cabecera
	 *            the new cabecera
	 */
	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	/**
	 * Gets the codigo.
	 * 
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 * 
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the mapping.
	 * 
	 * @return the mapping
	 */
	public Boolean getMapping() {
		return mapping;
	}

	/**
	 * Sets the mapping.
	 * 
	 * @param mapping
	 *            the new mapping
	 */
	public void setMapping(Boolean mapping) {
		this.mapping = mapping;
	}

	/**
	 * Gets the visible.
	 * 
	 * @return the visible
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * Sets the visible.
	 * 
	 * @param visible
	 *            the new visible
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getLabel()
	 */
	public String getLabel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getNombreCompleto()
	 */
	public String getNombreCompleto() {
		return null;
	}

	/**
	 * Gets the estado.
	 * 
	 * @return the estado
	 */
	public Character getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 * 
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(Character estado) {
		this.estado = estado;
	}

	/**
	 * Gets the activo.
	 * 
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * Sets the activo.
	 * 
	 * @param activo
	 *            the new activo
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/**
	 * Gets the fecha actualizacion.
	 * 
	 * @return the fecha actualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * Sets the fecha actualizacion.
	 * 
	 * @param fechaActualizacion
	 *            the new fecha actualizacion
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * Gets the fecha registro.
	 * 
	 * @return the fecha registro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Sets the fecha registro.
	 * 
	 * @param fechaRegistro
	 *            the new fecha registro
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Gets the tabla.
	 * 
	 * @return the tabla
	 */
	public String getTabla() {
		return tabla;
	}

	/**
	 * Sets the tabla.
	 * 
	 * @param tabla
	 *            the new tabla
	 */
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	/**
	 * Gets the orden.
	 * 
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * Sets the orden.
	 * 
	 * @param orden
	 *            the new orden
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}


}