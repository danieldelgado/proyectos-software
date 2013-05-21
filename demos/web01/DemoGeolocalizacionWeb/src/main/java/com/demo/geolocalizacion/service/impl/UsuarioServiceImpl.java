package com.demo.geolocalizacion.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.geolocalizacion.dao.TelefonoDAO;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.service.UsuarioService;
import com.demo.geolocalizacion.util.Constantes;
import com.demo.geolocalizacion.util.CustomLog;
import com.demo.geolocalizacion.util.SimpleValidate;

@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger logger = CustomLog
			.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private TelefonoDAO telefonoDAO;

	@Override
	public int validarUsuarioPorNumeroRegistrado(String numero) {
		try {
			if (SimpleValidate.validar(Constantes.FORMATO_TELEFONO, numero)) {
				Telefono telefono = telefonoDAO
						.existeTelefonoRegistrado(numero);
				if (telefono == null) {
					logger.info(" telefono : " + numero + " no extiste");
					return Constantes.USUARIO_NO_EXISTE;
				} else {
					logger.info(" numero telefono existe");
					return Constantes.USUARIO_EXISTE;
				}
			} else {
				logger.info(" numero telefono no cumple el formato : " + numero);
				return Constantes.NO_CUMPLE_CON_FORMATO;
			}
		} catch (Exception e) {
			logger.error("error del servidor [" + e.getLocalizedMessage() + "]");
			e.printStackTrace();
		}
		return Constantes.ERROR_SERVER;
	}

	
	@Override
	@Transactional
	public Map<String, Object> registrarUsuario_Telefono(Telefono telefono) {
		Map<String, Object> obRespuyesta = new HashMap<String, Object>();
		if (telefono != null) {
			List<String> lstErrores = new ArrayList<String>();
			if ( !(SimpleValidate.validar(Constantes.FORMATO_NOMBRE, telefono.getNombresCompleto())) ) {
				lstErrores.add("nombresCompleto");
			}
			if ( !(SimpleValidate.validar(Constantes.FORMATO_NOMBRE, telefono.getApellidosCompletos())) ) {
				lstErrores.add("apellidosCompletos");
			}
			if ( !(SimpleValidate.validar(Constantes.FORMATO_TELEFONO, telefono.getNumero())) ) {
				lstErrores.add("numero");
			}
			if ( !(telefono.getTipoTelefono() > 0) ) {
				lstErrores.add("tipotelefono");
			}
			if(lstErrores.size()>0){
				logger.info(" usuario no se puede guardar ");
				obRespuyesta.put("registro", Constantes.NO_CUMPLE_CON_FORMATO);
				obRespuyesta.put("errores", lstErrores);				
			}else{
				logger.info(" usuario se guardar con exito");
				telefonoDAO.guardar(telefono);
				obRespuyesta.put("registro", Constantes.REGISTRADO);
			}
		}else{
			logger.info(" el objeto es null ");
			obRespuyesta.put("registro", Constantes.USUARIO_NO_EXISTE);
		}
		return obRespuyesta;
	}

}
