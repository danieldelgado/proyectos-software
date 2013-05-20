package com.demo.geolocalizacion.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.geolocalizacion.dao.TelefonoDAO;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.service.UsuarioService;
import com.demo.geolocalizacion.util.Constantes;
import com.demo.geolocalizacion.util.CustomLog;
import com.demo.geolocalizacion.util.SimpleValidate;

@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger logger = CustomLog.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private TelefonoDAO telefonoDAO;
	
	
	@Override
	public int validarUsuarioPorNumeroRegistrado(String numero) {		
		try {
			if(SimpleValidate.validar(Constantes.FORMATO_TELEFONO, numero)){
				Telefono telefono = telefonoDAO.existeTelefonoRegistrado(numero);
				if(telefono==null){
					logger.info(" telefono : "+numero +" no extiste");
					return Constantes.USUARIO_NO_EXISTE;
				}else{
					logger.info(" numero telefono existe");
					return Constantes.USUARIO_EXISTE;			
				}
			}else{
				logger.info(" numero telefono no cumple el formato : "+numero);
				return Constantes.NO_CUMPLE_CON_FORMATO;	
			}
		} catch (Exception e) {
			logger.error("error del servidor ["+e.getLocalizedMessage()+"]");
			e.printStackTrace();
		}	
		return Constantes.ERROR_SERVER;
	}

}
