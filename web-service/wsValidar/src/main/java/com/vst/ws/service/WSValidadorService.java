package com.vst.ws.service;

import java.util.List;

import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;

public interface WSValidadorService {

	public Validador validarObjetos(List<CamposValidar> lstCamposValidar);

}
