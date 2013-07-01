package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the boton database table.
 * 
 */
@Entity
@Table(name = "boton")
public class Boton extends Recurso implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bloqueable. */
	@Column(name = "bloqueable", nullable = false)
	private Boolean bloqueable;

	/** The icono. */
	@Column(name = "icono", length = 50)
	private String icono;

	/** The on complete. */
	@Column(name = "on_complete", length = 80)
	private String onComplete;

	/** The on_click. */
	@Column(name = "on_click", length = 80)
	private String on_click;

	/** The on submit. */
	@Column(name = "on_submit", length = 80)
	private String onSubmit;

	/** The orden. */
	@Column(name = "orden", length = 2, nullable = false)
	private Integer orden;

	/** The parametros json. */
	@Lob()
	@Column(name = "parametros_json")
	private String parametrosJson;

	/** The tipo. */
	@Column(name = "tipo", length = 50, nullable = false)
	private String tipo;//pagina principal o subpaginas (listado- nuevo - guardar - cancelar)

	/** The url. */
	@Column(name = "url", length = 250)
	private String url;

	// bi-directional many-to-many association to Menu
	// @ManyToMany(mappedBy="botons",fetch=FetchType.LAZY)
	// private List<Menu> menus;

	/**
	 * Instantiates a new boton.
	 */
	public Boton() {
		orden = 0;
	}

	
	


	public Boton(Integer id,String codigo, String icono, Integer orden, String parametrosJson, String tipo, String url) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.icono = icono;
		this.orden = orden;
		this.parametrosJson = parametrosJson;
		this.tipo = tipo;
		this.url = url;
	}

	
	

	/**
	 * Gets the bloqueable.
	 * 
	 * @return the bloqueable
	 */
	public Boolean getBloqueable() {
		return this.bloqueable;
	}

	/**
	 * Sets the bloqueable.
	 * 
	 * @param bloqueable
	 *            the new bloqueable
	 */
	public void setBloqueable(Boolean bloqueable) {
		this.bloqueable = bloqueable;
	}

	/**
	 * Gets the icono.
	 * 
	 * @return the icono
	 */
	public String getIcono() {
		return this.icono;
	}

	/**
	 * Sets the icono.
	 * 
	 * @param icono
	 *            the new icono
	 */
	public void setIcono(String icono) {
		this.icono = icono;
	}

	/**
	 * Gets the on complete.
	 * 
	 * @return the on complete
	 */
	public String getOnComplete() {
		return this.onComplete;
	}

	/**
	 * Sets the on complete.
	 * 
	 * @param onComplete
	 *            the new on complete
	 */
	public void setOnComplete(String onComplete) {
		this.onComplete = onComplete;
	}

	/**
	 * Gets the on submit.
	 * 
	 * @return the on submit
	 */
	public String getOnSubmit() {
		return this.onSubmit;
	}

	/**
	 * Sets the on submit.
	 * 
	 * @param onSubmit
	 *            the new on submit
	 */
	public void setOnSubmit(String onSubmit) {
		this.onSubmit = onSubmit;
	}

	/**
	 * Gets the orden.
	 * 
	 * @return the orden
	 */
	public int getOrden() {
		return this.orden;
	}

	/**
	 * Sets the orden.
	 * 
	 * @param orden
	 *            the new orden
	 */
	public void setOrden(int orden) {
		this.orden = orden;
	}

	/**
	 * Gets the parametros json.
	 * 
	 * @return the parametros json
	 */
	public String getParametrosJson() {
		return this.parametrosJson;
	}

	/**
	 * Sets the parametros json.
	 * 
	 * @param parametrosJson
	 *            the new parametros json
	 */
	public void setParametrosJson(String parametrosJson) {
		this.parametrosJson = parametrosJson;
	}

	/**
	 * Gets the tipo.
	 * 
	 * @return the tipo
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Sets the tipo.
	 * 
	 * @param tipo
	 *            the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the on_click.
	 * 
	 * @return the on_click
	 */
	public String getOn_click() {
		return on_click;
	}

	/**
	 * Sets the on_click.
	 * 
	 * @param on_click
	 *            the new on_click
	 */
	public void setOn_click(String on_click) {
		this.on_click = on_click;
	}

	/**
	 * Sets the orden.
	 * 
	 * @param orden
	 *            the new orden
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}