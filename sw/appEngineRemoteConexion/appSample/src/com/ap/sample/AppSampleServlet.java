package com.ap.sample;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AppSampleServlet extends HttpServlet {
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		StringBuffer stb = new StringBuffer();
		System.out.println("Lista de IPs");
		List<BeanConexion> lstConexiones = AppSamplePostServlet.lstConexiones ;
		stb.append("--IPS--\n");
		stb.append("|");
		for (BeanConexion bc : lstConexiones) {
			stb.append("|ip="+bc.getIp()+"|");
			stb.append("|puerto="+bc.getPuerto()+"|");
			stb.append("|fechaRegistro="+bc.getFechaRegsitro()+"|");
			stb.append("|responsable="+bc.getResponsable()+"|");
			stb.append("|Medoto="+bc.getMetodo()+"|");
			stb.append("|QString="+bc.getQueryString()+"|");
			stb.append("|Json="+bc.getJson()+"|");	
			stb.append("----\n");
		}	
		System.out.println(stb.toString());
		resp.getWriter().println(stb.toString());
	}
	
	
}
