package com.vst.service.mantenimiento;

import java.util.List;

import com.vst.dominio.Parametro;

public interface MantenimientoParametroService {

	List<Parametro> obtenerEstados();

	List<Parametro> obtenerParametrosPadre();

}
