package com.vst.temp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "Conexion")
public class Conexion implements Entidad{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_conexion")
	private Integer id;
	
	@Column(name = "connectionId")	
	private String connectionId;
	
	@Column(name = "origin")
	private String origin;
	

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user", insertable = false, updatable = false)
	private Usuario user;
	

	public Conexion(String connectionId, String origin) {
		this.connectionId = connectionId;
		this.origin = origin;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public Boolean getActivo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
