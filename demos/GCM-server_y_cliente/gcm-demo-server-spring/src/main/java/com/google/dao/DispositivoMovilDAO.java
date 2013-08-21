package com.google.dao;

import com.google.bean.DispositivoMovil;
import com.google.bean.Usuario;
import com.google.gcm.util.IDAO;

public interface DispositivoMovilDAO extends IDAO<DispositivoMovil> {

	boolean existeDispositivoMovilPorRegIDMovil(String regId);
	
	DispositivoMovil buscarDispositivoMovilPorRegIDMovil(String regId);

	Usuario obtenerUsuarioPorRegIDMovil(String regId);



}
