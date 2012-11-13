package com.vst.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametro_por_parametro database table.
 * 
 */
@Entity
@Table(name="parametro_por_parametro")
public class ParametroPorParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParametroPorParametroPK id;

	private String atributo;

	private Integer orden;

	//bi-directional many-to-one association to Parametro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parametro_id_parametro_padre",insertable=false,updatable=false)
	private Parametro parametroPadre;

	//bi-directional many-to-one association to Parametro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parametro_id_parametro_hijo",insertable=false,updatable=false)
	private Parametro parametroHijo;

	
	
	
	
    public ParametroPorParametro(Integer idpadre,Integer idhijo) {
		id = new ParametroPorParametroPK(idpadre,idhijo);
	}

	public ParametroPorParametro() {
    }

	public ParametroPorParametroPK getId() {
		return this.id;
	}

	public void setId(ParametroPorParametroPK id) {
		this.id = id;
	}
	
	
	
	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public Parametro getParametroPadre() {
		return parametroPadre;
	}

	public void setParametroPadre(Parametro parametroPadre) {
		this.parametroPadre = parametroPadre;
	}

	public Parametro getParametroHijo() {
		return parametroHijo;
	}

	public void setParametroHijo(Parametro parametroHijo) {
		this.parametroHijo = parametroHijo;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	
	
}