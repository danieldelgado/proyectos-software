package com.vst.ws.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.HistorialDAO;
import com.vst.dominio.Historial;
import com.vst.util.Util;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;
import com.vst.ws.service.RegistrarHistorialService;

@Service("RegistrarHistorialService")
public class RegistrarHistorialServiceImpl implements RegistrarHistorialService {

	private static Logger log=LoggerFactory.getLogger(RegistrarHistorialServiceImpl.class);
	
	@Autowired
	private HistorialDAO historialDAO;
	
	public void registrarInicio(Object ob,String string, List<CamposValidar> lstCamposValidar) {
		Historial h =  new Historial();
		h.setClase(ob.getClass().getSimpleName());
		h.setCodigo(Util.getCodigo(h));
		h.setMetodo(string);
		h.setFechaRegistro(new Date());
		h.setValor(Util.getJson(lstCamposValidar));
		historialDAO.guardar(h);
		log.info("RegistrarHistorialServiceImpl registrarInicio registrando Historial "+Util.getJson(lstCamposValidar) );
	}
	
	public void registrarFin(Object ob,String string, Validador v) {
		Historial h =  new Historial();
		h.setClase(ob.getClass().getSimpleName());
		h.setCodigo(Util.getCodigo(h));
		h.setMetodo(string);
		h.setFechaRegistro(new Date());
		h.setValor(Util.getJson(v));
		historialDAO.guardar(h);
		log.info("RegistrarHistorialServiceImpl registrarFin registrando Historial "+Util.getJson(v) );
	}

	

}
