package com.vst.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.HistorialDAO;
import com.vst.dao.ParametroDAO;
import com.vst.util.Util;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;
import com.vst.ws.service.WSValidadorService;

@Service("WSValidadorService")
public class WSValidadorServiceImpl implements WSValidadorService {

	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private HistorialDAO historialDAO;

	public Validador validarObjetos(List<CamposValidar> lstCamposValidar) {
		System.out.println("lstCamposValidar:"+Util.getJson(lstCamposValidar));
		
		return null;
	}
	

	

}
