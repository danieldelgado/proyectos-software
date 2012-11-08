package com.vst.service.mantenimiento.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.service.impl.LoginServiceImpl;
import com.vst.service.mantenimiento.MantenimientoParametroService;
import com.vst.util.Constantes;

@Service("MantenimientoParametroService")
public class MantenimientoParametroServiceImpl implements MantenimientoParametroService {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroService.class);
	
	@Autowired
	private ParametroDAO parametroDAO;
	
	public List<Parametro> obtenerEstados() {
		List<Parametro> l =  parametroDAO.obtenerPorTipo(Constantes.TIPO_ESTADO);	
		return l;
	}

	public List<Parametro> obtenerParametrosPadre() {
		List<Parametro> l =  parametroDAO.obtenerParametrosPadre();	
		return l;
	}

}
