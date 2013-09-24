package com.vst.deocecu.service;

import java.util.List;

import com.vst.deocecu.dominio.Documento;
import com.vst.deocecu.dominio.Proyecto;
import com.vst.deocecu.dominio.Seccion_Documento;


public interface DocumentadorService {

	public int guardarContenidoHTMLALFRESCO(String html);

	public List<Proyecto> obtenerListaProyectos();

	public int guardarNuevoProyecto(Proyecto proyecto);

	public Proyecto obtenerProyectoPorID(Integer id);

	public List<Seccion_Documento> obtenerSesscionesProyecto(com.vst.deocecu.dominio.Proyecto p);

	public int guardarSeccionProyecto(Integer id_proyecto, Seccion_Documento seccion_Documento);

	public List<Seccion_Documento> obtenerSeccionesDocumentos(com.vst.deocecu.dominio.Proyecto p);

	public Seccion_Documento obtenerSeccionProyectoPorId(Integer sdid);

	public int guardarContenidoEnDocumentoAlfresco(Proyecto p, Seccion_Documento sd, Documento documento);
	
}
