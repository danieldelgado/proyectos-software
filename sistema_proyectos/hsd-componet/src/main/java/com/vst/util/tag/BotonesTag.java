package com.vst.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vst.dominio.Boton;

public class BotonesTag extends SimpleTagSupport{

	private static final Logger log=LoggerFactory.getLogger(BotonesTag.class);

	private List<Boton> botones;
	
	private String clase;

	private String tabBar;	

	@Override
	public void doTag() throws JspException,IOException{
		String jsp="/WEB-INF/views/estructura/botones.jsp";
		PageContext pageContext=(PageContext) getJspContext();
		pageContext.setAttribute("listaBotones",botones,PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("random",(int) (Math.random() * 40),PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("clase",clase,PageContext.REQUEST_SCOPE);
		if(tabBar!=null){
			pageContext.setAttribute("tabBarContainer",tabBar,PageContext.REQUEST_SCOPE);			
		}else
			tabBar="tabBar";
		try{
			pageContext.include(jsp);
		}
		catch(ServletException e){
			log.error(e.getMessage(),e);
		}
	}

	public List<Boton> getBotones(){
		return botones;
	}

	public void setBotones(List<Boton> botones){
		this.botones=botones;
	}

	public String getClase(){
		return clase;
	}

	public void setClase(String clase){
		this.clase=clase;
	}

}
