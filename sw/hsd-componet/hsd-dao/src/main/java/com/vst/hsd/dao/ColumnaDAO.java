package com.vst.hsd.dao;

import java.util.List;

import com.vst.hsd.dominio.Columna;
import com.vst.util.IDAO;

public interface ColumnaDAO extends IDAO<Columna> {

	List<Columna> buscarPorLista(Integer id);

	
}
