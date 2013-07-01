package com.vst.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vst.hsd.dominio.Boton;

// TODO: Auto-generated Javadoc
/**
 * The Class BotonesTag.
 */
public class BotonesTag extends SimpleTagSupport {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(BotonesTag.class);

	/** The botones. */
	private List<Boton> botones;

	/** The clase. */
	private String clase;

	/** The tab bar. */
	private String tabBar;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("  entra BotonesTag ");
		String jsp = "/WEB-INF/views/estructura/tag/botones.jsp";
		PageContext pageContext = (PageContext) getJspContext();
		pageContext.setAttribute("listaBotones", botones, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("random", (int) (Math.random() * 40), PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("clase", clase, PageContext.REQUEST_SCOPE);
		if (tabBar != null) {
			pageContext.setAttribute("tabBarContainer", tabBar, PageContext.REQUEST_SCOPE);
		} else
			tabBar = "tabBar";
		try {
			System.out.println(jsp);
			pageContext.include(jsp);
		} catch (ServletException e) {
			System.out.println(" error ");
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * Gets the botones.
	 * 
	 * @return the botones
	 */
	public List<Boton> getBotones() {
		return botones;
	}

	/**
	 * Sets the botones.
	 * 
	 * @param botones
	 *            the new botones
	 */
	public void setBotones(List<Boton> botones) {
		this.botones = botones;
	}

	/**
	 * Gets the clase.
	 * 
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}

	/**
	 * Sets the clase.
	 * 
	 * @param clase
	 *            the new clase
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}

}
