package com.ap.sample;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AppSamplePostServlet extends HttpServlet {
	
	public static List<BeanConexion> lstConexiones = new ArrayList<BeanConexion>();
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		System.out.println(" Coneccion doPost ");	
		BeanConexion bc = new BeanConexion(req.getRemoteHost(), String.valueOf(req.getRemotePort()), getDateString(), "yo", "doPost",req.getParameterMap().toString(),"");
		gestionarComandos(req.getParameterMap());	
		if(!existeInstanciaIP(bc)){
			lstConexiones.add(bc);	
		}		
		resp.setContentType("text/plain");
		resp.getWriter().println("ingreso");
	}	
	
	@SuppressWarnings("rawtypes")
	private void gestionarComandos(Map<String, String[]> map) {
		Iterator it = null;
		Map.Entry e = null;
		String key = null;
		String tsrv = null;
		it = map.entrySet().iterator();
		while (it.hasNext()) {
			e = (Map.Entry) it.next();
			key = e.getKey().toString();
			tsrv = ((String[]) e.getValue())[0];
			if(key.equals("CLEAR")){
				if(tsrv.equals("true")){
					lstConexiones.clear();
				}
			}
		}		
	}

	private static boolean existeInstanciaIP(BeanConexion bc ) {
		for (BeanConexion bcinst : lstConexiones) {
			if(bcinst.getIp().equals(bc.getIp()))
				return true;			
		}
		return false;
	}

	public static String getDateString(){
		SimpleDateFormat sdf=new SimpleDateFormat();
		Date d = new Date();
		return sdf.format(d);		
	}
	
}