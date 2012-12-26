package com.vst.hsd.service.mantenimiento;

import java.util.List;
import java.util.Map;

import com.vst.hsd.dominio.Parametro;

public interface MantenimientoParametroService {

	List<Parametro> obtenerEstados();

	List<Parametro> obtenerParametrosPadre();

	int guardarParametro(Parametro parametro);

	Parametro obtenerParametro(int param);

	List   obtenerParametrosRulesEntidad(String entidad);

	 List<Map<String,Object>> obtenerParametros();

}
