package com.vst.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vst.service.LoginService;

public class FiltroSeguridad implements Filter{

	private static Logger logger=LoggerFactory.getLogger(FiltroSeguridad.class);

	private FilterConfig filterConfig=null;

	@Autowired
	private LoginService loginService;
	
	public void init(FilterConfig arg0) throws ServletException {
			
	}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
		
	}

	public void destroy(){
	}

	private String getUsername(String cadenaDes){
		String username=null;
		if(cadenaDes != null){
			int index=cadenaDes.indexOf('=');
			int indexsep=cadenaDes.indexOf('&');
			username=cadenaDes.substring(index + 1,indexsep);

		}
		// logger.debug("username " + username);
		return username;
	}



}