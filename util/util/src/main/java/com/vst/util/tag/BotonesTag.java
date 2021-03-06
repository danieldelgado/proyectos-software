package com.vst.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotonesTag extends SimpleTagSupport {

	private static final Logger log = LoggerFactory.getLogger(BotonesTag.class);

	@SuppressWarnings("rawtypes")
	private List botones;

	private String clase;

	private String tabBar;

	@Override
	public void doTag() throws JspException, IOException {
		String jsp = "/WEB-INF/views/estructura/botones.jsp";
		PageContext pageContext = (PageContext) getJspContext();
		pageContext.setAttribute("listaBotones", botones, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("random", (int) (Math.random() * 40), PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("clase", clase, PageContext.REQUEST_SCOPE);
		if (tabBar != null) {
			pageContext.setAttribute("tabBarContainer", tabBar, PageContext.REQUEST_SCOPE);
		} else
			tabBar = "tabBar";
		try {
			pageContext.include(jsp);
		} catch (ServletException e) {
			log.error(e.getMessage(), e);
		}
	}

	@SuppressWarnings("rawtypes")
	public List getBotones() {
		return botones;
	}

	@SuppressWarnings("rawtypes")
	public void setBotones(List botones) {
		this.botones = botones;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

}
