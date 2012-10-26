package com.vst.dao;

import java.util.List;

import com.vst.dominio.Historial;
import com.vst.util.IDAO;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;

public interface HistorialDAO extends IDAO<Historial> {


	public void registrarFin(String string, Validador v);

	public void registrarInicio(String string, List<CamposValidar> lstCamposValidar);

}
