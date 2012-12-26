package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the codigo_cliente database table.
 * 
 */
@Entity
@Table(name="codigo_cliente")
public class CodigoCliente extends Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;


    public CodigoCliente() {
    }


	public String getCodigo() {
		return this.codigo;
	}

	
	
}