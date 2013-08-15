package com.vst.ChatWebsocket.Entitys;

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

import com.vst.ChatWebsocket.messages.STATUS;
import com.vst.ChatWebsocket.util.Entidad;

@Entity
@Table(name = "StatusInfo")
public class StatusInfo  implements Entidad  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_statusInfo")
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user", insertable = false, updatable = false)
	private Usuario user;

	@Column(name = "status")
	private STATUS status;

	@Column(name = "sta")
	private int sta;

	public StatusInfo(Usuario user, STATUS status, int sta) {
		this.user = user;
		this.status = status;
		this.sta = sta;
	}

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setUser(Usuario user) {
		this.user = user;
	}



	public void setStatus(STATUS status) {
		this.status = status;
	}



	public void setSta(int sta) {
		this.sta = sta;
	}



	public int getSta() {
		return sta;
	}

	public Usuario getUser() {
		return user;
	}

	public STATUS getStatus() {
		return status;
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