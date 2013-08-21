package com.vst.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vst.util.persistence.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class AsignableTag.
 */
public class AsignableTag extends SimpleTagSupport {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AsignableTag.class);

	/** The identificador. */
	private String identificador;

	/** The titulo. */
	private String titulo;

	/** The disponibles. */
	private List<? extends Entidad> disponibles;

	/** The asignados. */
	private List<? extends Entidad> asignados;

	/** The nombre input. */
	private String nombreInput;

	/** The formulario. */
	private String formulario;

	/** The ancho. */
	private String ancho;

	/** The alto. */
	private Integer alto;

	/** The style. */
	private String style;

	/** The funcion asignar. */
	private String funcionAsignar;

	/** The funcion no asignar. */
	private String funcionNoAsignar;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		String jsp = "/WEB-INF/views/estructura/asignable.jsp";
		PageContext pageContext = (PageContext) getJspContext();
		pageContext.setAttribute("identificador", identificador, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("titulo", titulo, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("disponibles", disponibles, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("asignados", asignados, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("nombreInput", nombreInput, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("formulario", formulario, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("style", style, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("funcionAsignar", funcionAsignar, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("funcionNoAsignar", funcionNoAsignar, PageContext.REQUEST_SCOPE);

		if (ancho == null) {
			ancho = "500px";
		}
		if (!ancho.contains("%") && !ancho.contains("px")) {
			ancho += "px";
		}

		pageContext.setAttribute("ancho", ancho, PageContext.REQUEST_SCOPE);
		if (alto == null)
			alto = 250;
		if (alto < 194)
			alto = 194;
		pageContext.setAttribute("alto", alto, PageContext.REQUEST_SCOPE);
		try {
			pageContext.include(jsp);
		} catch (ServletException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * Gets the identificador.
	 * 
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Sets the identificador.
	 * 
	 * @param identificador
	 *            the new identificador
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the disponibles.
	 * 
	 * @return the disponibles
	 */
	public List<? extends Entidad> getDisponibles() {
		return disponibles;
	}

	/**
	 * Sets the disponibles.
	 * 
	 * @param disponibles
	 *            the new disponibles
	 */
	public void setDisponibles(List<? extends Entidad> disponibles) {
		this.disponibles = disponibles;
	}

	/**
	 * Gets the asignados.
	 * 
	 * @return the asignados
	 */
	public List<? extends Entidad> getAsignados() {
		return asignados;
	}

	/**
	 * Sets the asignados.
	 * 
	 * @param asignados
	 *            the new asignados
	 */
	public void setAsignados(List<? extends Entidad> asignados) {
		this.asignados = asignados;
	}

	/**
	 * Gets the nombre input.
	 * 
	 * @return the nombre input
	 */
	public String getNombreInput() {
		return nombreInput;
	}

	/**
	 * Sets the nombre input.
	 * 
	 * @param nombreInput
	 *            the new nombre input
	 */
	public void setNombreInput(String nombreInput) {
		this.nombreInput = nombreInput;
	}

	/**
	 * Gets the formulario.
	 * 
	 * @return the formulario
	 */
	public String getFormulario() {
		return formulario;
	}

	/**
	 * Sets the formulario.
	 * 
	 * @param formulario
	 *            the new formulario
	 */
	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	/**
	 * Gets the ancho.
	 * 
	 * @return the ancho
	 */
	public String getAncho() {
		return ancho;
	}

	/**
	 * Sets the ancho.
	 * 
	 * @param ancho
	 *            the new ancho
	 */
	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	/**
	 * Gets the alto.
	 * 
	 * @return the alto
	 */
	public Integer getAlto() {
		return alto;
	}

	/**
	 * Sets the alto.
	 * 
	 * @param alto
	 *            the new alto
	 */
	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	/**
	 * Gets the style.
	 * 
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * Sets the style.
	 * 
	 * @param style
	 *            the new style
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * Gets the funcion asignar.
	 * 
	 * @return the funcion asignar
	 */
	public String getFuncionAsignar() {
		return funcionAsignar;
	}

	/**
	 * Sets the funcion asignar.
	 * 
	 * @param funcionAsignar
	 *            the new funcion asignar
	 */
	public void setFuncionAsignar(String funcionAsignar) {
		this.funcionAsignar = funcionAsignar;
	}

	/**
	 * Gets the funcion no asignar.
	 * 
	 * @return the funcion no asignar
	 */
	public String getFuncionNoAsignar() {
		return funcionNoAsignar;
	}

	/**
	 * Sets the funcion no asignar.
	 * 
	 * @param funcionNoAsignar
	 *            the new funcion no asignar
	 */
	public void setFuncionNoAsignar(String funcionNoAsignar) {
		this.funcionNoAsignar = funcionNoAsignar;
	}

}
