package com.vst.util.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HTMLTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1656870319155987026L;

	private String titulo;

	private String estilo;

	private String javascript;

	private String ent;

	public int doStartTag() throws JspException {
		String cabecera = "/WEB-INF/views/estructura/cabecera.jsp";
		ServletRequest request = pageContext.getRequest();
		request.setAttribute("titulo", titulo);
		request.setAttribute("ent", ent);
		String[] estilos;
		String[] scripts;
		if (estilo != null) {
			StringTokenizer st = new StringTokenizer(estilo, ",");
			List<String> css = new ArrayList<String>();
			while (st.hasMoreTokens()) {
				String token = st.nextToken().trim();
				if (!token.startsWith("http://")) {
					if (token.indexOf(".css") > 0)
						token = "/resources/css/" + token;
					else
						token = "/resources/css/" + token + ".css";
				}
				css.add(token);
			}
			estilos = new String[css.size()];
			css.toArray(estilos);
		} else {
			estilos = new String[0];
		}
		request.setAttribute("estilo", estilos);
		if (javascript != null) {
			StringTokenizer st = new StringTokenizer(javascript, ",");
			List<String> js = new ArrayList<String>();
			while (st.hasMoreTokens()) {
				String token = st.nextToken().trim();
				if (!token.startsWith("http://")) {
					if (token.indexOf(".js") > 0)
						token = "/resources/js/" + token;
					else
						token = "/resources/js/" + token + ".js";
				}
				js.add(token);
			}
			scripts = new String[js.size()];
			js.toArray(scripts);
		} else {
			scripts = new String[0];
		}
		request.setAttribute("javascript", scripts);
		try {
			// esto es lo que llama al jsp
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
			ServletConfig config = pageContext.getServletConfig();
			RequestDispatcher rd = config.getServletContext().getRequestDispatcher(cabecera);
			rd.include(request, response);
		} catch (IOException ioe) {
			throw new JspException("IOException: " + ioe);
		} catch (ServletException se) {
			throw new JspException("ServletException: " + se);
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		String pie = "/WEB-INF/views/estructura/pie.jsp";
		try {
			// Ensure body is included before footer
			pageContext.getOut().flush();

			// Context objects
			ServletRequest request = pageContext.getRequest();
			ServletResponse response = pageContext.getResponse();
			ServletConfig config = pageContext.getServletConfig();
			RequestDispatcher rd = config.getServletContext().getRequestDispatcher(pie);
			rd.include(request, response);
		} catch (ServletException se) {
			throw new JspException("ServletException: " + se);
		} catch (IOException ioe) {
			throw new JspException("IOException: " + ioe);
		}
		return EVAL_PAGE;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public void setJavascript(String javascript) {
		this.javascript = javascript;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEnt() {
		return ent;
	}

	public void setEnt(String ent) {
		this.ent = ent;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEstilo() {
		return estilo;
	}

	public String getJavascript() {
		return javascript;
	}

}
