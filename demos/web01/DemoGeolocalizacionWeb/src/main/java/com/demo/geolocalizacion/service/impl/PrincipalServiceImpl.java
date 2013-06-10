package com.demo.geolocalizacion.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.geolocalizacion.dao.TelefonoDAO;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.service.PrincipalService;
import com.demo.geolocalizacion.util.Constantes;
import com.demo.geolocalizacion.util.CustomLog;
import com.demo.geolocalizacion.util.SimpleValidate;

@Service("PrincipalService")
public class PrincipalServiceImpl implements PrincipalService {

	private static final Logger logger = CustomLog.getLogger(PrincipalServiceImpl.class);

	@Autowired
	private TelefonoDAO telefonoDAO;

	/**
	 * Valido el numero, si existe en la base de datos o no.
	 */
	@Override
	public int validarUsuarioPorNumeroRegistrado(String numero) {
		try {
			if (SimpleValidate.validar(Constantes.FORMATO_TELEFONO, numero)) {
				Telefono telefono = telefonoDAO.existeTelefonoRegistrado(numero);
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

	/**
	 * Guardo el objeto en la base de datos, si el numero no existe en caso contrario no se registra
	 * retorna un mapa.
	 */
	@Override
	@Transactional
	public Map<String, Object> registrarUsuario_Telefono(Telefono telefono) {
		Map<String, Object> obRespuyesta = new HashMap<String, Object>();
		try {
			if (telefono != null) {
				List<String> lstErrores = new ArrayList<String>();
				if (!(SimpleValidate.validar(Constantes.FORMATO_NOMBRE,
						telefono.getNombresCompleto()))) {
					lstErrores.add("nombres");
				}
				if (!(SimpleValidate.validar(Constantes.FORMATO_NOMBRE,
						telefono.getApellidosCompletos()))) {
					lstErrores.add("apellidos");
				}
				if (!(SimpleValidate.validar(Constantes.FORMATO_TELEFONO,
						telefono.getNumero()))) {
					lstErrores.add("numero");
				}
				if (!(telefono.getTipoTelefono() > 0)) {
					lstErrores.add("tipotelefono");
				}

				if (lstErrores.size() > 0) {
					logger.info(" usuario no se puede guardar ");
					obRespuyesta.put("registro",Constantes.NO_CUMPLE_CON_FORMATO);
					obRespuyesta.put("errores", lstErrores);
				} else {
					if (validarUsuarioPorNumeroRegistrado(telefono.getNumero()) == Constantes.USUARIO_NO_EXISTE) {
						logger.info(" usuario se guardar con exito");
						telefono.setFechaRegistro(new Date());
						telefono.setFechaActualizacion(new Date());
						try {
							telefonoDAO.guardar(telefono);							
						} catch (Exception e) {
							e.printStackTrace();							
						}
						obRespuyesta.put("registro", Constantes.REGISTRADO);
					} else {
						logger.info(" El numero que desea registrar, ya se encuentra registrado ");
						obRespuyesta.put("registro", Constantes.NO_REGISTRADO);
					}
				}
			} else {
				logger.info(" el objeto es null ");
				obRespuyesta.put("registro", Constantes.USUARIO_NO_EXISTE);
			}
		} catch (Exception e) {
			obRespuyesta.put("registro", Constantes.ERROR_SERVER);
			logger.error("error del servidor [" + e.getLocalizedMessage() + "]");
			e.printStackTrace();
		}
		return obRespuyesta;
	}

}
