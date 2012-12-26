package com.vst.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.ParametroDAO;
import com.vst.util.Constantes;
import com.vst.util.Util;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;
import com.vst.ws.service.RegistrarHistorialService;
import com.vst.ws.service.WSValidadorService;

@Service("WSValidadorService")
public class WSValidadorServiceImpl implements WSValidadorService {

	private static final Logger log = LoggerFactory.getLogger(WSValidadorServiceImpl.class);

	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private RegistrarHistorialService historRegistrarHistorialService;

	@Transactional
	public Validador validarObjetos(List<CamposValidar> lstCamposValidar) {
		log.info("[ metodo: validarObjetos -  objetos : "+Util.getJson(lstCamposValidar)+"]");
		Validador v = new Validador();
		historRegistrarHistorialService.registrarHistorial("WSValidadorServiceImpl", "validarObjetos", " registrarInicio validarObjetos lstCamposValidar:", lstCamposValidar);
		if(lstCamposValidar.size()>0){
			for (int i = 0; i < lstCamposValidar.size(); i++) {
				CamposValidar cv = lstCamposValidar.get(i);
				log.info("[CamposValidar:"+Util.getJson(cv)+"]");
				validarGeneric(cv,v);				
			}
		}		
		historRegistrarHistorialService.registrarHistorial("WSValidadorServiceImpl", "validarObjetos", "registrarFin validarObjetos Validador:", v);
		return v;
	}

	private void validarGeneric(CamposValidar cv, Validador v) {
		
				
	}
	

	

}
