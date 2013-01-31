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

// TODO: Auto-generated Javadoc
/**
 * The Class HTMLTag.
 */
public class HTMLTag extends TagSupport{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID=1656870319155987026L;

	/** The titulo. */
	private String titulo;

	/** The estilo. */
	private String estilo;

	/** The javascript. */
	private String javascript;

	/** The ent. */
	private String ent;

	
	
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException{
		String cabecera="/WEB-INF/views/estructura/cabecera.jsp";
		ServletRequest request=pageContext.getRequest();
		request.setAttribute("titulo",titulo);
		request.setAttribute("ent",ent);		
		String[] estilos;
		String[] scripts;
		if(estilo != null){
			StringTokenizer st=new StringTokenizer(estilo,",");
			List<String> css=new ArrayList<String>();
			while(st.hasMoreTokens()){
				String token=st.nextToken().trim();
				if(!token.startsWith("http://")){
					if(token.indexOf(".css") > 0)
						token="/resources/css/" + token;
					else
						token="/resources/css/" + token + ".css";
				}
				css.add(token);
			}
			estilos=new String[css.size()];
			css.toArray(estilos);
		}
		else{
			estilos=new String[0];
		}
		request.setAttribute("estilo",estilos);
		if(javascript != null){
			StringTokenizer st=new StringTokenizer(javascript,",");
			List<String> js=new ArrayList<String>();
			while(st.hasMoreTokens()){
				String token=st.nextToken().trim();
				if(!token.startsWith("http://")){
					if(token.indexOf(".js") > 0)
						token="/resources/js/" + token;
					else
						token="/resources/js/" + token + ".js";
				}
				js.add(token);
			}
			scripts=new String[js.size()];
			js.toArray(scripts);
		}
		else{
			scripts=new String[0];
		}
		request.setAttribute("javascript",scripts);
		try{
			// esto es lo que llama al jsp
			HttpServletResponse response=(HttpServletResponse) pageContext.getResponse();
			ServletConfig config=pageContext.getServletConfig();
			RequestDispatcher rd=config.getServletContext().getRequestDispatcher(cabecera);
			rd.include(request,response);
		}
		catch(IOException ioe){
			throw new JspException("IOException: " + ioe);
		}
		catch(ServletException se){
			throw new JspException("ServletException: " + se);
		}
		return EVAL_BODY_INCLUDE;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException{
		String pie="/WEB-INF/views/estructura/pie.jsp";
		try{
			// Ensure body is included before footer
			pageContext.getOut().flush();

			// Context objects
			ServletRequest request=pageContext.getRequest();
			ServletResponse response=pageContext.getResponse();
			ServletConfig config=pageContext.getServletConfig();
			RequestDispatcher rd=config.getServletContext().getRequestDispatcher(pie);
			rd.include(request,response);
		}
		catch(ServletException se){
			throw new JspException("ServletException: " + se);
		}
		catch(IOException ioe){
			throw new JspException("IOException: " + ioe);
		}
		return EVAL_PAGE;
	}

	/**
	 * Sets the estilo.
	 *
	 * @param estilo the new estilo
	 */
	public void setEstilo(String estilo){
		this.estilo=estilo;
	}

	/**
	 * Sets the javascript.
	 *
	 * @param javascript the new javascript
	 */
	public void setJavascript(String javascript){
		this.javascript=javascript;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo the new titulo
	 */
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}

	/**
	 * Gets the ent.
	 *
	 * @return the ent
	 */
	public String getEnt() {
		return ent;
	}

	/**
	 * Sets the ent.
	 *
	 * @param ent the new ent
	 */
	public void setEnt(String ent) {
		this.ent = ent;
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
	 * Gets the estilo.
	 *
	 * @return the estilo
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * Gets the javascript.
	 *
	 * @return the javascript
	 */
	public String getJavascript() {
		return javascript;
	}

}
