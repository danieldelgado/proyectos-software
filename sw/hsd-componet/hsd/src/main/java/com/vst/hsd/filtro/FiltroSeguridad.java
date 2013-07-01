package com.vst.hsd.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class FiltroSeguridad.
 */
public class FiltroSeguridad implements Filter {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(FiltroSeguridad.class);

	/** The filter config. */
	@SuppressWarnings("unused")
	private FilterConfig filterConfig = null;

	// @Autowired
	// private RegistrarHistorialService historialService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest objRequest = (HttpServletRequest) request;

			// System.out.println(objRequest.getLocalAddr());
			// System.out.println(objRequest.getLocalName());
			// System.out.println(objRequest.getLocalPort());
			// System.out.println(objRequest.getContextPath());
			// System.out.println(objRequest.getContentType());
			// System.out.println(objRequest.getMethod());
			// System.out.println(objRequest.getParameterNames());
			// System.out.println(objRequest.getParameterMap());
			// System.out.println(objRequest.getHeaderNames());
			// System.out.println(objRequest.getRemoteHost());
			// System.out.println(objRequest.getRemoteAddr());
			// System.out.println(objRequest.getRemotePort());
			// System.out.println(objRequest.getRemoteUser());
			log.debug(" metodo:doFilter - filtro de seguridad ip solicitante : " + objRequest.getRemoteAddr() + " - uri:" + objRequest.getRequestURI());
			// historialService.registrarHistorial("FiltroSeguridad",
			// "doFilter", "", objRequest);
		}
		chain.doFilter(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * Gets the username.
	 * 
	 * @param cadenaDes
	 *            the cadena des
	 * @return the username
	 */
	@SuppressWarnings("unused")
	private String getUsername(String cadenaDes) {
		String username = null;
		if (cadenaDes != null) {
			int index = cadenaDes.indexOf('=');
			int indexsep = cadenaDes.indexOf('&');
			username = cadenaDes.substring(index + 1, indexsep);

		}
		return username;
	}

}