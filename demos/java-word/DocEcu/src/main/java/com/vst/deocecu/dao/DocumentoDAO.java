package com.vst.deocecu.dao;

import java.util.List;

import com.vst.deocecu.dominio.Documento;
import com.vst.deocecu.dominio.Seccion_Documento;
import com.vst.deocecu.util.IDAO;

public interface DocumentoDAO extends IDAO<Documento> {

	List<Documento> obtenetDocumentosPorSeccionDocumento(Seccion_Documento sd);

}
