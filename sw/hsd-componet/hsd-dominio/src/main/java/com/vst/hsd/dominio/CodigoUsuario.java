package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the codigo_usuario database table.
 * 
 */
@Entity
@Table(name="codigo_usuario")
public class CodigoUsuario extends Usuario implements  Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="codigo",length=50,nullable=false)
	private String codigo;

	

    public CodigoUsuario() {
    }

	
   

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



		
}