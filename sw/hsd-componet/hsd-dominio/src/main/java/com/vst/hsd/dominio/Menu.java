package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name = "menu")
public class Menu extends Recurso implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/** The function. */
	@Column(name = "function", length = 100)
	private String function;

	/** The nombre. */
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	/** The orden. */
	@Column(name = "orden", length = 2, nullable = false)
	private Integer orden;

	/** The tipo. */
	@Column(name = "tipo", length = 50, nullable = false)
	private String tipo;

	/** The default menu. */
	@Column(name = "defaultMenu", nullable = false)
	private Boolean defaultMenu;

	/** The todos. */
	@Column(name = "todos", nullable = false)
	private Boolean todos;

	/** The url. */
	@Column(name = "url", length = 500)
	private String url;

	/** The menu. */
	@ManyToOne(fetch = FetchType.LAZY)
	private Menu menu;

	/** The menus. */
	@OneToMany(mappedBy = "menu")
	private List<Menu> menus;

	/** The paginas. */
	@OneToMany(mappedBy = "menu")
	private List<Pagina> paginas;

	/**
	 * Instantiates a new menu.
	 */
	public Menu() {
		defaultMenu = false;
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the paginas.
	 *
	 * @return the paginas
	 */
	public List<Pagina> getPaginas() {
		return paginas;
	}

	/**
	 * Sets the paginas.
	 *
	 * @param paginas the new paginas
	 */
	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	/**
	 * Gets the function.
	 *
	 * @return the function
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * Sets the function.
	 *
	 * @param function the new function
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the orden.
	 *
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * Sets the orden.
	 *
	 * @param orden the new orden
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the todos.
	 *
	 * @return the todos
	 */
	public Boolean getTodos() {
		return todos;
	}

	/**
	 * Sets the todos.
	 *
	 * @param todos the new todos
	 */
	public void setTodos(Boolean todos) {
		this.todos = todos;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * Sets the menu.
	 *
	 * @param menu the new menu
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * Gets the menus.
	 *
	 * @return the menus
	 */
	public List<Menu> getMenus() {
		return menus;
	}

	/**
	 * Sets the menus.
	 *
	 * @param menus the new menus
	 */
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * Gets the default menu.
	 *
	 * @return the default menu
	 */
	public Boolean getDefaultMenu() {
		return defaultMenu;
	}

	/**
	 * Sets the default menu.
	 *
	 * @param defaultMenu the new default menu
	 */
	public void setDefaultMenu(Boolean defaultMenu) {
		this.defaultMenu = defaultMenu;
	}

}