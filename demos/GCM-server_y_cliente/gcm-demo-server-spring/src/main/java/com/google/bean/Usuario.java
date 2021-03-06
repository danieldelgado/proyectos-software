package com.google.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.google.gcm.util.Entidad;

@Entity
@Table(name = "Usuario")
public class Usuario  implements Entidad{

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_usuario")
	private Integer id;
	@Column(name = "userName")	
	private String userName;
	@Column(name = "clave")	
	private String clave;
	@Column(name = "nombre")	
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "email")	
	private String email;

	@OneToMany(mappedBy="usuario")
	private List<DispositivoMovil> dispositivoMovils;
	
	private transient DispositivoMovil dispositivoMovilActual;
	
	public Usuario() {
	}

	public Usuario(int id, String userName, String clave, String nombre, String apellido) {
		this.id = id;
		this.userName = userName;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario(String userName, String clave, String nombre, String apellido) {
		this.userName = userName;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	
	public List<DispositivoMovil> getDispositivoMovils() {
		return dispositivoMovils;
	}

	public void setDispositivoMovils(List<DispositivoMovil> dispositivoMovils) {
		this.dispositivoMovils = dispositivoMovils;
	}

	
	
	public DispositivoMovil getDispositivoMovilActual() {
		return dispositivoMovilActual;
	}

	public void setDispositivoMovilActual(DispositivoMovil dispositivoMovilActual) {
		this.dispositivoMovilActual = dispositivoMovilActual;
	}

	//	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public Boolean getActivo() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

}
