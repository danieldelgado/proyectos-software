package com.vst.filtro;

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
import org.springframework.beans.factory.annotation.Autowired;

import com.vst.service.RegistrarHistorialService;

public class FiltroSeguridad implements Filter{

	private static Logger log=LoggerFactory.getLogger(FiltroSeguridad.class);

	@SuppressWarnings("unused")
	private FilterConfig filterConfig=null;
	
	@Autowired
	private RegistrarHistorialService historialService;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig=fConfig;
	}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
		if(request instanceof HttpServletRequest){
			HttpServletRequest objRequest=(HttpServletRequest) request;	
			log.debug("[ url:filtro - calse:FiltroSeguridad - metodo:doFilter ]");
			historialService.registrarHistorial("FiltroSeguridad", "doFilter", "", objRequest);
		}
		chain.doFilter(request,response);	
	}


	public void destroy(){
	}

	@SuppressWarnings("unused")
	private String getUsername(String cadenaDes){
		String username=null;
		if(cadenaDes != null){
			int index=cadenaDes.indexOf('=');
			int indexsep=cadenaDes.indexOf('&');
			username=cadenaDes.substring(index + 1,indexsep);

		}
		return username;
	}



}