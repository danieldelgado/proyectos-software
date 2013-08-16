package com.vst.dominio;

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

import com.vst.util.Entidad;

@Entity
@Table(name = "MessageInfo")
public class MessageInfo   implements Entidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_messageInfo")
	private Integer id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_from", insertable = false, updatable = false)
	private Usuario from;
	@Column(name = "fromuserName")
	private String fromuserName;	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_to", insertable = false, updatable = false)
	private Usuario to;
	@Column(name = "touserName")
	private String touserName;
	@Column(name = "message")
	private String message;

	public MessageInfo(){
		
	}
			
	public MessageInfo(Usuario from, Usuario to, String message) {
		this.from = from;
		this.to = to;
		this.message = message;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Usuario getFrom() {
		return from;
	}

	public Usuario getTo() {
		return to;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getFromuserName() {
		return fromuserName;
	}

	public void setFromuserName(String fromuserName) {
		this.fromuserName = fromuserName;
	}

	public String getTouserName() {
		return touserName;
	}

	public void setTouserName(String touserName) {
		this.touserName = touserName;
	}

	public void setFrom(Usuario from) {
		this.from = from;
	}

	public void setTo(Usuario to) {
		this.to = to;
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