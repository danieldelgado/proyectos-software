package com.vst.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vst.dao.HistorialDAO;
import com.vst.dominio.Historial;
import com.vst.util.DAO;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;

@Repository("HistorialDAO")
public class HistorialDAOImpl extends DAO<Historial> implements HistorialDAO {

	public void registrarFin(String string, Validador v) {
		// TODO Auto-generated method stub
		
	}

	public void registrarInicio(String string, List<CamposValidar> lstCamposValidar) {
		// TODO Auto-generated method stub
		
	}

	

}
