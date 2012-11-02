package com.vst.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="recurso_por_perfil")
public class RecursoPorPerfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID=-7810555155845794831L;

	@EmbeddedId
	private RecursoPorPerfilPK id;
	
	private Boolean responsable;


	public Boolean getResponsable() {
		return responsable;
	}

	public void setResponsable(Boolean responsable) {
		this.responsable = responsable;
	}

	public RecursoPorPerfil(){
		super();
	}

	public RecursoPorPerfil(Recurso recurso,Perfil perfil){
		id=new RecursoPorPerfilPK(recurso,perfil);
	}

	public RecursoPorPerfilPK getId(){
		return id;
	}

	public void setId(RecursoPorPerfilPK id){
		this.id=id;
	}

	


}
