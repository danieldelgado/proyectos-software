package com.vst.deocecu.dao;

import com.vst.deocecu.dominio.Proyecto;
import com.vst.deocecu.util.IDAO;

public interface ProyectoDAO extends IDAO<Proyecto> {

	Proyecto existeProyectoPorFolder(String folder, String titulo);

}
