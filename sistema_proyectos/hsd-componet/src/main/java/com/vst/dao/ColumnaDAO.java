package com.vst.dao;

import java.util.List;

import com.vst.dominio.Columna;
import com.vst.util.IDAO;

public interface ColumnaDAO extends IDAO<Columna> {

	boolean eliminarColuma(int idColumna);

	List<Columna> buscarPorLista(Integer id);
	
}
