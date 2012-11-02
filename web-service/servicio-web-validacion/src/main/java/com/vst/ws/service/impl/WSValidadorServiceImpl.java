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
		if(v.getCodigosErrors()==null){
			v.setCodigosErrors(new ArrayList<Integer>());			
		}
		
		if(cv.getTipo().equals(Constantes.CAMPO_LOGIN_USUARIO)){
			cv.setValid(Util.validarCadena(cv.getValor(), parametroDAO.getRangoCadenaMin(), parametroDAO.getRangoCadenaMax(), parametroDAO.getCadenasRestringidas()));
			log.info("[CamposValidar "+cv.getTipo()+":"+cv.getValid()+"]");
			if(!(cv.getValid())){
				v.getCodigosErrors().add(Constantes.CAMPO_LOGIN_USUARIO_ERROR);
			}
		}
		else
		if(cv.getTipo().equals(Constantes.CAMPO_CLAVE)){
			cv.setValid(Util.validarFormato(cv.getValor(),parametroDAO.getFormatoCampo(cv.getEntidad(),cv.getCampo(),Constantes.CAMPO_CLAVE), parametroDAO.getRangoCadenaMin(), parametroDAO.getRangoCadenaMax(), parametroDAO.getCadenasRestringidas()));
			log.info("[CamposValidar "+cv.getTipo()+":"+cv.getValid()+"]");
			if(!(cv.getValid())){
				v.getCodigosErrors().add(Constantes.CAMPO_LOGIN_USUARIO_CLAVE);
			}
		}
		else
		if(cv.getTipo().equals(Constantes.FORMATO_CAMPO)){
			cv.setValid(Util.validarSelector(cv.getValor(), parametroDAO.getValorSelectorMin(), parametroDAO.getCadenasRestringidasSelector()));
			log.info("[CamposValidar "+cv.getTipo()+":"+cv.getValid()+"]");
			if(!(cv.getValid())){
				v.getCodigosErrors().add(Constantes.CAMPO_LOGIN_USUARIO_SELECTOR);
			}
		}
		
		
		if(v.getCodigosErrors()==null || v.getCodigosErrors().size()==0){
			v.setRespuesta(Constantes.VALIDACION_CORRECTA);
		}else{
			v.setRespuesta(Constantes.VALIDACION_INCORRECTA);
		}
				
	}
	

	

}
