package com.vst.ws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.ParametroDAO;
import com.vst.dao.ParametroPorParametroDAO;
import com.vst.ws.service.MantenimientoParametroService;

@Service("MantenimientoParametroService")
public class MantenimientoParametroServiceImpl implements MantenimientoParametroService {

	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private ParametroPorParametroDAO parametroPorParametroDAO;
	
	@Transactional
	public String registrarParametrosIniciales() {
	
		return null;
	}

}
