package com.vst.dominio;

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

	@Column(name="entidad",length=200)
	private String entidad;	
	
	@Column(name="campo",length=200)
	private String campo;	

	@Column(name="tipo_variable",length=200)
	private String tipovariable;
	

	@Column(name="tipo_parametro",length=200)
	private String tipo;
	
	
	@Column(name="atributo",length=200)
	private String atributo;	
	
	
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
		
	@ManyToOne//(fetch = FetchType.EAGER)
	private Parametro parametro;
/*
	@OneToMany(mappedBy = "parametro")
	private List<Parametro> parametros;
		*/
	private transient List<Parametro> parametros;
	
	/*
	//bi-directional many-to-one association to ParametroPorParametro
	@OneToMany(mappedBy="parametroPadre")
	private List<ParametroPorParametro> parametroPorParametrosPadre;

	//bi-directional many-to-one association to ParametroPorParametro
	@OneToMany(mappedBy="parametroHijo")
	private List<ParametroPorParametro> parametroPorParametrosHijo;
*/
	private transient List<ParametroPorParametro> parametroPorParametrosPadre;

	private transient List<ParametroPorParametro> parametroPorParametrosHijo;
	
    public Parametro() {
    }

    
    
    
	public Parametro(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}




	public Parametro(Integer id, String codigo, Character estado, Boolean activo, String entidad, String campo, String tipo, String atributo, String valor, String descripcion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.estado = estado;
		this.activo = activo;
		this.entidad = entidad;
		this.campo = campo;
		this.tipo = tipo;
		this.atributo = atributo;
		this.valor = valor;
		this.descripcion = descripcion;
	}




	public Parametro(Integer id, String codigo, Character estado, Boolean activo, String entidad, String campo, String tipo, String atributo, String valor, String descripcion,
			Date fechaActualizacion, Date fechaRegistro) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.estado = estado;
		this.activo = activo;
		this.entidad = entidad;
		this.campo = campo;
		this.tipo = tipo;
		this.atributo = atributo;
		this.valor = valor;
		this.descripcion = descripcion;
		this.fechaActualizacion = fechaActualizacion;
		this.fechaRegistro = fechaRegistro;
	}




	public Parametro(Integer id, String codigo, String valor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.valor = valor;
	}



/*
	public Parametro(Integer id, String codigo, Character estado, Boolean activo, String entidad, String campo, String tipo, String valor, List<Parametro> parametros) {
		this.id = id;
		this.codigo = codigo;
		this.estado = estado;
		this.activo = activo;
		this.entidad = entidad;
		this.campo = campo;
		this.tipo = tipo;
		this.valor = valor;
		this.parametros = parametros;
	}

*/


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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLabel() {
		return null;
	}

	public String getNombreCompleto() {
		return null;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
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








	public String getAtributo() {
		return atributo;
	}




	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}




	public List<ParametroPorParametro> getParametroPorParametrosPadre() {
		return parametroPorParametrosPadre;
	}




	public void setParametroPorParametrosPadre(List<ParametroPorParametro> parametroPorParametrosPadre) {
		this.parametroPorParametrosPadre = parametroPorParametrosPadre;
	}




	public List<ParametroPorParametro> getParametroPorParametrosHijo() {
		return parametroPorParametrosHijo;
	}




	public void setParametroPorParametrosHijo(List<ParametroPorParametro> parametroPorParametrosHijo) {
		this.parametroPorParametrosHijo = parametroPorParametrosHijo;
	}




	public String getTipovariable() {
		return tipovariable;
	}




	public void setTipovariable(String tipovariable) {
		this.tipovariable = tipovariable;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




    

}