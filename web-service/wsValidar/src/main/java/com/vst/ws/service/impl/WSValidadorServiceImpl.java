package com.vst.ws.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.HistorialDAO;
import com.vst.dao.ParametroDAO;
import com.vst.dominio.Historial;
import com.vst.util.Constantes;
import com.vst.util.Util;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;
import com.vst.ws.service.WSValidadorService;

@Service("WSValidadorService")
public class WSValidadorServiceImpl implements WSValidadorService {

	private static final Logger log = LoggerFactory.getLogger(WSValidadorServiceImpl.class);

	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private HistorialDAO historialDAO;

	public Validador validarObjetos(List<CamposValidar> lstCamposValidar) {
		log.info("WSValidadorServiceImpl validarObjetos:"+Util.getJson(lstCamposValidar));
		Validador v = new Validador();
		historialDAO.registrarInicio("WSValidadorServiceImpl validarObjetos",lstCamposValidar);
		if(lstCamposValidar.size()>0){
			for (int i = 0; i < lstCamposValidar.size(); i++) {
				CamposValidar cv = lstCamposValidar.get(i);
				log.info("CamposValidar:"+Util.getJson(cv));
				if(cv.getTipo()==Constantes.CAMPO_ENTERO){
					cv.setValid(Util.validarEntero(cv.getEntero(),parametroDAO.getRangoEnteroMin(),parametroDAO.getRangoEnteroMax(),parametroDAO.getValorEnteroMin(),parametroDAO.getValorEnteroMax()));
					log.info("CamposValidar:"+cv.getValid());
				}
				else
				if(cv.getTipo()==Constantes.CAMPO_DECIMAL){	
					cv.setValid(Util.validarDecimal(cv.getDecimal(),parametroDAO.getRangoDecimalMin(),parametroDAO.getRangoDecimalMax(),parametroDAO.getValorDecimalMin(),parametroDAO.getValorDecimalMax(),parametroDAO.getCantidadDecimales()));
					log.info("CamposValidar:"+cv.getValid());
				}
				else
				if(cv.getTipo()==Constantes.CAMPO_CADENA){	
					cv.setValid(Util.validarCadena(cv.getCadena(), parametroDAO.getRangoCadenaMin(), parametroDAO.getRangoCadenaMax(), parametroDAO.getCadenasRestringidas()));
					log.info("CamposValidar:"+cv.getValid());
				}
				else
				if(cv.getTipo()==Constantes.CAMPO_FORMATO){						
					cv.setValid(Util.validarFormato(cv.getFormat(),cv.getValorFormat(), parametroDAO.getRangoCadenaMin(), parametroDAO.getRangoCadenaMax(), parametroDAO.getCadenasRestringidas()));
					log.info("CamposValidar:"+cv.getValid());
				}
			}
		}	
		historialDAO.registrarFin("WSValidadorServiceImpl validarObjetos",v);		
		return v;
	}
	

	

}
