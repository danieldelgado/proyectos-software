package com.vst.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the boton database table.
 * 
 */
@Entity
@Table(name="boton")
public class Boton extends Recurso implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="bloqueable")
	private Boolean bloqueable;

	@Column(name="codigo",length=20)
	private String codigo;

	@Column(name="icono",length=50)
	private String icono;

	@Column(name="on_complete",length=80)
	private String onComplete;

	@Column(name="on_submit",length=80)
	private String onSubmit;

	@Column(name="orden",length=2)
	private Integer orden;

    @Lob()
	@Column(name="parametros_json")
	private String parametrosJson;

    @Column(name="tipo",length=50)
	private String tipo;

	@Column(name="url",length=250)
	private String url;

	//bi-directional many-to-many association to Menu
	@ManyToMany(mappedBy="botons")
	private List<Menu> menus;
		
    public Boton() {
    }

	

	public List<Menu> getMenus() {
		return menus;
	}



	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}



	public Boolean getBloqueable() {
		return this.bloqueable;
	}

	public void setBloqueable(Boolean bloqueable) {
		this.bloqueable = bloqueable;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getOnComplete() {
		return this.onComplete;
	}

	public void setOnComplete(String onComplete) {
		this.onComplete = onComplete;
	}

	public String getOnSubmit() {
		return this.onSubmit;
	}

	public void setOnSubmit(String onSubmit) {
		this.onSubmit = onSubmit;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getParametrosJson() {
		return this.parametrosJson;
	}

	public void setParametrosJson(String parametrosJson) {
		this.parametrosJson = parametrosJson;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}