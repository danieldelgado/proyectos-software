package com.autentia.tutorial.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Usuario")
public class Usuario implements Entidad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_persona")
	private Integer id;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaActualizacion")
	private Date fechaActualizacion;

	/** The fecha creacion. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	/** The fecha nacimiento. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	/** The nombre. */
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	/** The apellidos. */
	@Column(name = "apellidos", length = 100, nullable = false)
	private String apellidos;

	/** The estado. */
	@Column(name = "estado", length = 1, nullable = false)
	private Character estado;

	/** The activo. */
	@Column(name = "activo", nullable = false)
	private Boolean activo;

	@Column(name = "codigo", length = 50, nullable = false)
	public String codigo;

	@Column(name = "telefono_fijo", length = 9)
	private String telefono_fijo;

	@Column(name = "celular", length = 11)
	private String celular;
	
	@Lob()	
	private  byte[] api_key;
	


	/** The login. */
	@Column(name = "login", length = 50, nullable = false)
	private String login;

	/** The clave. */
	@Column(name = "clave", length = 50, nullable = false)
	private String clave;

	/** The estado civil. */
	@Column(name = "estado_civil", length = 1, nullable = false)
	private Integer estadoCivil;

	/** The ruc. */
	@Column(name = "ruc", length = 11)
	private String ruc;

	/** The tipo_documento. */
	@Column(name = "tipo_documento", length = 1, nullable = false)
	private Integer tipo_documento;

	/** The numero_documento. */
	@Column(name = "numero_documento", length = 12, nullable = false)
	private String numero_documento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTelefono_fijo() {
		return telefono_fijo;
	}

	public void setTelefono_fijo(String telefono_fijo) {
		this.telefono_fijo = telefono_fijo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public byte[] getApi_key() {
		return api_key;
	}

	public void setApi_key(byte[] api_key) {
		this.api_key = api_key;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Integer getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(Integer tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

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
