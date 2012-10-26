package com.vst.ws.service;

import java.util.List;

import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;
import com.vst.ws.service.impl.WSValidadorServiceImpl;


public interface RegistrarHistorialService {

	public void registrarFin(Object ob,String string, Validador v) ;

	public void registrarInicio(Object ob, String string, List<CamposValidar> lstCamposValidar) ;
}
