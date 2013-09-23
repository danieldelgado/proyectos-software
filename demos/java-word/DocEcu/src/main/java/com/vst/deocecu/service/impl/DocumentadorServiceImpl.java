package com.vst.deocecu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alfresco.com.vst.service.component.AlfrescoServiceConexion;

import com.vst.deocecu.service.DocumentadorService;

@Service
public class DocumentadorServiceImpl implements DocumentadorService {
	
	@Autowired 
	private AlfrescoServiceConexion alfrescoServiceConexion;

	public int guardarContenidoHTMLALFRESCO(String html) {
		
		System.out.println("alfrescoServiceConexion");
		System.out.println("iniciarConexion:"+alfrescoServiceConexion.iniciarConexion());
		alfrescoServiceConexion.obtenerCarpetaProyectos();
		System.out.println("hsd:"+alfrescoServiceConexion.obtenerSubCarpetaProyecto("hsd"));
		System.out.println("hsd:"+alfrescoServiceConexion.crearSubCarpetaProyecto("hsd"));
		System.out.println("docecu:"+alfrescoServiceConexion.obtenerSubCarpetaProyecto("docecu"));
		System.out.println("docecu:"+alfrescoServiceConexion.crearSubCarpetaProyecto("docecu"));
		System.out.println("chatwebsocket:"+alfrescoServiceConexion.obtenerSubCarpetaProyecto("chatwebsocket"));
		System.out.println("chatwebsocket:"+alfrescoServiceConexion.crearSubCarpetaProyecto("chatwebsocket"));
		System.out.println("terminarConexion:"+alfrescoServiceConexion.terminarConexion());
		
		
		return 0;
	}
	
	
	
}
