package com.demo.geolocalizacion.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.geolocalizacion.dao.TelefonoDAO;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.service.UsuarioService;
import com.demo.geolocalizacion.util.Constantes;
import com.demo.geolocalizacion.util.CustomLog;

@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger logger = CustomLog.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private TelefonoDAO telefonoDAO;
	
	
	@Override
	public int validarUsuarioPorNumeroRegistrado(String numero) {		
		try {
			Telefono telefono = telefonoDAO.existeTelefonoRegistrado(numero);
			if(telefono==null){
				logger.info(" telefono :"+numero +" no extiste");
				return Constantes.USUARIO_NO_EXISTE;
			}else{
				logger.info(" numero telefono existe");
				return Constantes.USUARIO_EXISTE;			
			}
		} catch (Exception e) {
			logger.error("error del servidor ["+e.getLocalizedMessage()+"]");
			e.printStackTrace();
		}	
		return Constantes.ERROR_SERVER;
	}

}
