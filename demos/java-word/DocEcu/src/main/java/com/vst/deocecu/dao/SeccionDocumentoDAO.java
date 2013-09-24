package com.vst.deocecu.dao;

import java.util.List;

import com.vst.deocecu.dominio.Proyecto;
import com.vst.deocecu.dominio.Seccion_Documento;
import com.vst.deocecu.util.IDAO;

public interface SeccionDocumentoDAO extends IDAO<Seccion_Documento> {

	List<Seccion_Documento> obtenerSeccionesDocumentos(Proyecto p);

}
