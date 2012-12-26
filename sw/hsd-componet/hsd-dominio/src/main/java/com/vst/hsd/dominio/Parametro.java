package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.Entidad;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@Table(name="parametro")
public class Parametro implements Entidad , Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator",
					table = "sequence_table", 
					pkColumnName = "sequence_name", 
					valueColumnName = "sequence_value")
	@Column(name="id_parametro")
	private Integer id;

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;


	@Column(name="nombre",length=50,nullable=false)
	private String nombre;
	
	@Column(name="estado",length=1)
	private Character estado;

	@Column(name="activo")
	private Boolean activo;	

	@Column(name="tipo",length=200)
	private String tipo;
	
	
	@Column(name="valor",length=200)
	private String valor;	

	@Column(name="descripcion",length=250)
	private String descripcion;
	
	@Temporal( TemporalType.DATE)	 
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private transient List<Parametro> parametros;
		
	private transient List<ParametroPorParametro> parametroPorParametrosPadre;

	private transient List<ParametroPorParametro> parametroPorParametrosHijo;
	
    public Parametro() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

	public List<ParametroPorParametro> getParametroPorParametrosPadre() {
		return parametroPorParametrosPadre;
	}

	public void setParametroPorParametrosPadre(
			List<ParametroPorParametro> parametroPorParametrosPadre) {
		this.parametroPorParametrosPadre = parametroPorParametrosPadre;
	}

	public List<ParametroPorParametro> getParametroPorParametrosHijo() {
		return parametroPorParametrosHijo;
	}

	public void setParametroPorParametrosHijo(
			List<ParametroPorParametro> parametroPorParametrosHijo) {
		this.parametroPorParametrosHijo = parametroPorParametrosHijo;
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}
    
    


    

}