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

public class ContentTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID=1656870319155987026L;

	private String tituloConent;
	
	private String ent;

	private String estiloConent;

	private String javascriptConent;
		
	private Boolean dwr;
	
	private String methodDWR;	
	
	public int doStartTag() throws JspException{
		
		String cabecera="/WEB-INF/views/estructura/conentTagCabecera.jsp";
		ServletRequest request=pageContext.getRequest();
		request.setAttribute("tituloConent",tituloConent);
		request.setAttribute("dwr",dwr);
		request.setAttribute("entidad",ent);	
		
		String[] estilos;
		String[] scripts;
		String[] methodDWRs;
		
		
		if(methodDWR != null){
			StringTokenizer st=new StringTokenizer(methodDWR,",");
			List<String> css=new ArrayList<String>();
			while(st.hasMoreTokens()){
				String token=st.nextToken().trim();
				if(!token.startsWith("http://")){					
					if(token.indexOf(".css") > 0)						
						token="/dwr/interface/" + token;
					else
						token="/dwr/interface/" + token + ".css";
				}
				css.add(token);
			}
			methodDWRs=new String[css.size()];
			css.toArray(methodDWRs);
		}
		else{
			methodDWRs=new String[0];
		}
		
		request.setAttribute("methodDWRs",methodDWRs);	
			
		if(estiloConent != null){
			StringTokenizer st=new StringTokenizer(estiloConent,",");
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
		request.setAttribute("estiloConent",estilos);
		
		if(javascriptConent != null){
			StringTokenizer st=new StringTokenizer(javascriptConent,",");
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
		request.setAttribute("javascriptConent",scripts);
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

	public int doEndTag() throws JspException{
		String pie="/WEB-INF/views/estructura/ConentPieTag.jsp";
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

	public String getEnt() {
		return ent;
	}

	public void setEnt(String ent) {
		this.ent = ent;
	}

	public String getTituloConent() {
		return tituloConent;
	}

	public void setTituloConent(String tituloConent) {
		this.tituloConent = tituloConent;
	}

	public String getEstiloConent() {
		return estiloConent;
	}

	public void setEstiloConent(String estiloConent) {
		this.estiloConent = estiloConent;
	}

	public String getJavascriptConent() {
		return javascriptConent;
	}

	public void setJavascriptConent(String javascriptConent) {
		this.javascriptConent = javascriptConent;
	}

	public Boolean getDwr() {
		return dwr;
	}

	public void setDwr(Boolean dwr) {
		this.dwr = dwr;
	}

	public String getMethodDWR() {
		return methodDWR;
	}

	public void setMethodDWR(String methodDWR) {
		this.methodDWR = methodDWR;
	}


	
	
	

}
