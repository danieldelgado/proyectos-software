package com.vst.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vst.dominio.Usuario;
import com.vst.service.LoginService;
import com.vst.service.RegistrarHistorialService;
import com.vst.util.Config;
import com.vst.util.Constantes;
import com.vst.util.UtilEncrip;

public class FiltroSeguridad implements Filter{

	private static Logger log=LoggerFactory.getLogger(FiltroSeguridad.class);

	private FilterConfig filterConfig=null;

	/*@Autowired
	private LoginService loginService;
	*/
	
	@Autowired
	private RegistrarHistorialService historialService;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig=fConfig;
	}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
		
		if(request instanceof HttpServletRequest){
			HttpServletRequest objRequest=(HttpServletRequest) request;		
			log.info("-");
			historialService.guardarHistorial(this,"doFilter",objRequest);
		}
		chain.doFilter(request,response);	
		/*if(request instanceof HttpServletRequest){
			HttpServletRequest objRequest=(HttpServletRequest) request;		
			log.info("Ingreso FiltroSeguridad");
			historialService.guardarHistorial(this,"doFilter",objRequest);
			objRequest.setCharacterEncoding("UTF-8");
			HttpServletResponse miResponse=null;
			String uri=objRequest.getRequestURI();
			HttpSession sesion=objRequest.getSession();
			if(sesion.getAttribute(Constantes.SESION_TITULO)==null){
				sesion.setAttribute(Constantes.SESION_TITULO,Config.getPropiedad("std.titulo"));
			}
			Usuario usuario=(Usuario) sesion.getAttribute(Constantes.SESION_USUARIO);
			log.debug("Uri solicitada=" + uri);*/
			//request.getRequestDispatcher(uri).forward(objRequest,miResponse);
			/*if(response instanceof HttpServletResponse){
				miResponse=(HttpServletResponse) response;
				if(Config.getPropiedadBoolean("login.seguridad")){
					if(!uri.contains("service") && !uri.contains("axis2-web") && !uri.contains("/remote/") && !uri.contains("uploadExternalFile")){
						String error=filterConfig.getInitParameter("error");
						if(error == null || error.equals("")){
							error="/error/errorLogin.html";
						}
						boolean correcto=false;
						boolean logout=false;

						if(uri.endsWith("login.action")){
							logout=true;
						}
						String sessionId=objRequest.getParameter("session");
						String cadenaEnc=objRequest.getParameter("xxyyxxx");
						String rol=objRequest.getParameter("rol");
						String usu=null;
						if(sessionId != null && !sessionId.equals("") && cadenaEnc != null && !cadenaEnc.equals("")){
							cadenaEnc=cadenaEnc.replaceAll(" ","+");
							String cadenaDes;
							try{
								cadenaDes=UtilEncrip.decrypt(sessionId,cadenaEnc);
								usu=getUsername(cadenaDes);
							}
							catch(Exception e){
								log.error("No se pudo desencriptar la sesion.");
							}

							if(usuario != null){
								correcto=true;
								
								/*if(usu != null && !usuario.getUsuario().equals(usu)){
									correcto=false;
									logger.warn("El usuario " + usu + " esta intentando iniciar sesion, pero el usuario " + usuario.getUsuario() + " ya esta en sesion.");
									error="/error/enSesion.html";
								}
								
								if(rol != null && usuario.getPerfilSesion() != null && !usuario.getPerfilSesion().getNombre().equals(rol)){
									loginService.asignarRol(usuario,rol,objRequest);
								}
								
							}
							else{
								if(usu != null){
									/*if(loginService.loginSeguridad(usu,rol,objRequest)){
										correcto=true;
									}
								}
							}
						}
						if(correcto){
							chain.doFilter(objRequest,miResponse);
						}
						else{
							/*if(logout){
								error="/error/finSesion.html";
							}
							//request.getRequestDispatcher(error).forward(objRequest,miResponse);
						}
					}
					else{
						chain.doFilter(objRequest,miResponse);
					}
				}
				else{
					if(!(uri.contains("login") || uri.contains("resources"))){
						if(usuario!=null){
							chain.doFilter(objRequest,miResponse);
						}
						else{
							//request.getRequestDispatcher("/app/login").forward(objRequest,miResponse);
							request.getRequestDispatcher("/").forward(objRequest,miResponse);	
						}
					}
					else if((uri.contains("login") && !uri.contains("out")) && usuario!=null){
						request.getRequestDispatcher("/").forward(objRequest,miResponse);						
					}
					else{
						chain.doFilter(objRequest,miResponse);
					}
				}
			}*/
			
		//}
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