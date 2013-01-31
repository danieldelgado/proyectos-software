package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
public class Menu extends Recurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;

	@Column(name="function",length=100)
	private String function;

	@Column(name="nombre",length=100,nullable=false)
	private String nombre;

	@Column(name="orden",length=2,nullable=false)
	private Integer orden;

	@Column(name="tipo",length=50,nullable=false)
	private String tipo;
	
	@Column(name="defaultMenu",nullable=false)
	private Boolean defaultMenu;

	@Column(name="todos",nullable=false)
	private Boolean todos;

	@Column(name="url",length=500)
	private String url;

	@ManyToOne(fetch = FetchType.LAZY)
	private Menu menu;

	@OneToMany(mappedBy = "menu")
	private List<Menu> menus;
	
	@OneToMany(mappedBy="menu")
	private List<Pagina> paginas;
	
	public Menu() {
		defaultMenu=false;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Pagina> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getTodos() {
		return todos;
	}

	public void setTodos(Boolean todos) {
		this.todos = todos;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Boolean getDefaultMenu() {
		return defaultMenu;
	}

	public void setDefaultMenu(Boolean defaultMenu) {
		this.defaultMenu = defaultMenu;
	}

	
	
}