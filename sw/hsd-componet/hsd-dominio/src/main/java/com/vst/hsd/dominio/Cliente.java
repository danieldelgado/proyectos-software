package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente extends Persona implements  Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;
	
	@Column(name="estado_civil",length=1,nullable=false)
	private Integer estadoCivil;

	@Column(name="ruc",length=11,nullable=false)
	private String ruc;

	@Column(name="tipo_documento",length=1,nullable=false)
	private Integer tipo_documento;
	
	@Column(name="numero_documento",length=12,nullable=false)
	private String numero_documento;

    public Cliente() {
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	
    
}