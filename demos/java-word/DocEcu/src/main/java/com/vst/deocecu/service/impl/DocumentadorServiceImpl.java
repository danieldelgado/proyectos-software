package com.vst.deocecu.service.impl;

import java.util.Date;
import java.util.List;

import org.alfresco.webservice.types.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alfresco.com.vst.service.component.AlfrescoServiceConexion;

import com.vst.deocecu.dao.DocumentoDAO;
import com.vst.deocecu.dao.ProyectoDAO;
import com.vst.deocecu.dao.SeccionDocumentoDAO;
import com.vst.deocecu.dominio.Documento;
import com.vst.deocecu.dominio.Proyecto;
import com.vst.deocecu.dominio.Seccion_Documento;
import com.vst.deocecu.service.DocumentadorService;

@Service
public class DocumentadorServiceImpl implements DocumentadorService {

	@Autowired
	private AlfrescoServiceConexion alfrescoServiceConexion;

	@Autowired
	private ProyectoDAO proyectoDAO;

	@Autowired
	private DocumentoDAO documentoDAO;

	@Autowired
	private SeccionDocumentoDAO seccionDocumentoDAO;

	public int guardarContenidoHTMLALFRESCO(String html) {
		// System.out.println("alfrescoServiceConexion");
		 System.out.println("iniciarConexion:"+alfrescoServiceConexion.iniciarConexion());
		 Reference carpetaProyecto = alfrescoServiceConexion.obtenerCarpetaProyectos();
		// System.out.println("hsd:"+alfrescoServiceConexion.obtenerSubCarpetaProyecto("hsd"));
		// System.out.println("hsd:"+alfrescoServiceConexion.crearSubCarpetaProyecto("hsd"));
		// System.out.println("docecu:"+alfrescoServiceConexion.obtenerSubCarpetaProyecto("docecu"));
		// System.out.println("docecu:"+alfrescoServiceConexion.crearSubCarpetaProyecto("docecu"));
		// System.out.println("chatwebsocket:"+alfrescoServiceConexion.obtenerSubCarpetaProyecto("chatwebsocket"));
		// System.out.println("chatwebsocket:"+alfrescoServiceConexion.crearSubCarpetaProyecto("chatwebsocket"));
		 System.out.println("terminarConexion:"+alfrescoServiceConexion.terminarConexion());
		return 0;
	}

	public List<Proyecto> obtenerListaProyectos() {
		return proyectoDAO.getTodos();
	}

	@Transactional
	public int guardarNuevoProyecto(Proyecto proyecto) {
		// Reference carpetaProyecto =
		// alfrescoServiceConexion.obtenerCarpetaProyectos();
		Proyecto exiproyecto = proyectoDAO.existeProyectoPorFolder(proyecto.getFolder(), proyecto.getTitulo());
		try {
			if (exiproyecto == null) {
				// alfrescoServiceConexion.iniciarConexion()
				Proyecto nuevo = null;
				if (alfrescoServiceConexion.iniciarConexion() == AlfrescoServiceConexion.AlfresoConstantes.USUARIO_AUNTENTICADO) {
					nuevo = alfrescoServiceConexion.crearSubCarpetaProyecto(proyecto);
					alfrescoServiceConexion.terminarConexion();
				}
				nuevo.setFechaRegistro(new Date());
				nuevo.setFechaActua(new Date());
				proyectoDAO.guardar(nuevo);
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Proyecto obtenerProyectoPorID(Integer id) {
		return proyectoDAO.get(id);
	}

	public List<Seccion_Documento> obtenerSesscionesProyecto(Proyecto p) {

		return null;
	}

	@Transactional
	public int guardarSeccionProyecto(Integer id_proyecto, Seccion_Documento seccion_Documento) {
		Proyecto p = proyectoDAO.get(id_proyecto);
		if (alfrescoServiceConexion.iniciarConexion() == AlfrescoServiceConexion.AlfresoConstantes.USUARIO_AUNTENTICADO) {
			seccion_Documento = alfrescoServiceConexion.crearSeccionesDelProyecto(p, seccion_Documento);
			alfrescoServiceConexion.terminarConexion();
		}
		seccion_Documento.setFechaRegistro(new Date());
		seccion_Documento.setFechaActua(new Date());
		seccion_Documento.setProyecto(p);
		seccionDocumentoDAO.guardar(seccion_Documento);
		return 1;
	}

	public List<Seccion_Documento> obtenerSeccionesDocumentos(Proyecto p) {
		List<Seccion_Documento> lst = seccionDocumentoDAO.obtenerSeccionesDocumentos(p);
		return lst;
	}

	public Seccion_Documento obtenerSeccionProyectoPorId(Integer sdid) {	
		return seccionDocumentoDAO.get(sdid);
	}

	@Transactional
	public int guardarContenidoEnDocumentoAlfresco(Proyecto p, Seccion_Documento sd, Documento documento) {
		if (alfrescoServiceConexion.iniciarConexion() == AlfrescoServiceConexion.AlfresoConstantes.USUARIO_AUNTENTICADO) {			
			documento = alfrescoServiceConexion.crearContenidoWeb(p,sd,documento);			
			alfrescoServiceConexion.terminarConexion();
		}
		documento.setSeccion_documento(sd);
		documentoDAO.guardar(documento);		
		return 1;
	}

}
