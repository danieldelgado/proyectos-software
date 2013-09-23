package com.vst.deocecu.service;

import java.util.List;

import com.vst.deocecu.dominio.Proyecto;


public interface DocumentadorService {

	public int guardarContenidoHTMLALFRESCO(String html);

	public List<Proyecto> obtenerListaProyectos();

	public int guardarNuevoProyecto(Proyecto proyecto);

	public Proyecto obtenerProyectoPorID(Integer id);
	
}
