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

public class AsignableTag extends SimpleTagSupport {

	private static final Logger log = LoggerFactory.getLogger(AsignableTag.class);

	private String identificador;

	private String titulo;

	private List<? extends Entidad> disponibles;

	private List<? extends Entidad> asignados;

	private String nombreInput;

	private String formulario;

	private String ancho;

	private Integer alto;

	private String style;

	private String funcionAsignar;

	private String funcionNoAsignar;

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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<? extends Entidad> getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(List<? extends Entidad> disponibles) {
		this.disponibles = disponibles;
	}

	public List<? extends Entidad> getAsignados() {
		return asignados;
	}

	public void setAsignados(List<? extends Entidad> asignados) {
		this.asignados = asignados;
	}

	public String getNombreInput() {
		return nombreInput;
	}

	public void setNombreInput(String nombreInput) {
		this.nombreInput = nombreInput;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFuncionAsignar() {
		return funcionAsignar;
	}

	public void setFuncionAsignar(String funcionAsignar) {
		this.funcionAsignar = funcionAsignar;
	}

	public String getFuncionNoAsignar() {
		return funcionNoAsignar;
	}

	public void setFuncionNoAsignar(String funcionNoAsignar) {
		this.funcionNoAsignar = funcionNoAsignar;
	}

}
