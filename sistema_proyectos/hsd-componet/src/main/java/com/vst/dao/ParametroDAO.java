package com.vst.dao;

import java.util.List;

import com.vst.dominio.Parametro;
import com.vst.util.IDAO;

public interface ParametroDAO extends IDAO<Parametro> {

	List<Parametro> obtenerPorTipo(String tipoEstado);

	List<Parametro> obtenerParametrosPadre();

}
