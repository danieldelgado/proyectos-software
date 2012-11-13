package com.vst.service.mantenimiento;

import java.util.List;
import java.util.Map;

import com.vst.dominio.Parametro;

public interface MantenimientoParametroService {

	List<Parametro> obtenerEstados();

	List<Parametro> obtenerParametrosPadre();

	int guardarParametro(Parametro parametro);

	Parametro obtenerParametro(int param);

	Map<String, Object>  obtenerParametrosRulesEntidad(String entidad);

}
