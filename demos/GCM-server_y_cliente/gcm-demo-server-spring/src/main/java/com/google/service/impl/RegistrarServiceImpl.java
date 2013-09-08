package com.google.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.bean.DispositivoMovil;
import com.google.bean.Usuario;
import com.google.dao.DispositivoMovilDAO;
import com.google.dao.UsuarioDAO;
import com.google.gcm.util.Constantes;
import com.google.service.RegistrarService;

@Service("RegistrarService")
public class RegistrarServiceImpl implements RegistrarService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private DispositivoMovilDAO dispositivoMovilDAO;

	@Transactional
	public void guardarUsuairo(Usuario usuario) {
		usuarioDAO.guardar(usuario);
	}

	public List<Usuario> obtenerTodos() {
		return usuarioDAO.getTodos();
	}

	@Transactional
	public void registrarUsuarioPorRegIDMovil(String regId) {
		Usuario usuario = null;
		boolean existe = dispositivoMovilDAO
				.existeDispositivoMovilPorRegIDMovil(regId);
		if (existe) {
			System.out.println("registrado");
			usuario = dispositivoMovilDAO.obtenerUsuarioPorRegIDMovil(regId);
		} else {
			System.out.println("no registrado");
			usuario = new Usuario("device", "device", "device", "device");
			DispositivoMovil d = new DispositivoMovil();
			d.setKey_device(regId);
			d.setFecha_registro(new Date());
			d.setActivo(true);
			d.setNumeromovil("0000000000");
			d.setUsuario(usuario);
			List<DispositivoMovil> s = new ArrayList<DispositivoMovil>();
			s.add(d);
			usuario.setDispositivoMovils(s);
			usuarioDAO.guardar(usuario);
			dispositivoMovilDAO.guardar(d);
		}

	}

	public Usuario buscarUsuarioPorRegId(String regId) {
		return dispositivoMovilDAO.obtenerUsuarioPorRegIDMovil(regId);
	}

	public DispositivoMovil obtenerDispositivoMovilPorRegId(String regId) {
		return dispositivoMovilDAO.buscarDispositivoMovilPorRegIDMovil(regId);
	}

	@Transactional
	public void guardarDispositivoMovil(DispositivoMovil d) {
		dispositivoMovilDAO.guardar(d);
	}

	public DispositivoMovil obtenerDispositivoMovil() {
		return dispositivoMovilDAO.getTodos().get(0);
	}

	public Usuario obtenerUsuarioPorID(int id) {
		Usuario usuario = usuarioDAO.get(id);
		// DispositivoMovil
		// dispositivo=dispositivoMovilDAO.obtenerDispositivoActualPorUsuario(usuario);
		// usuario.setDispositivoMovilActual(dispositivo);
		return usuario;
	}

	public Usuario obtenerUsuarioPorIDDispositivoActual(int id) {
		Usuario usuario = usuarioDAO.get(id);
		DispositivoMovil dispositivo = dispositivoMovilDAO
				.obtenerDispositivoActualPorUsuario(usuario);
		usuario.setDispositivoMovilActual(dispositivo);
		return usuario;
	}

	@Transactional
	public int registrarUsuarioDesdeDispositivoMovil(Usuario usuario,
			String numero, String regId) {
		if (notNull(numero) && notNull(regId)) {
			boolean existeNumero = dispositivoMovilDAO
					.existeDispositivoMovilPorNumero(numero);
			System.out.println("existeNumero:" + existeNumero);
			try {
				if (existeNumero) {
					boolean redID = dispositivoMovilDAO
							.existeDispositivoMovilPorRegIDMovil(regId);
					System.out.println("redID:" + redID);
					if (redID) {
						return Constantes.registro.DISPOSITIVO_REGISTRADO;
					} else {
						DispositivoMovil dispositivoMovil = dispositivoMovilDAO
								.obtenerDispositivoMovilActualPorNumero(numero);
						dispositivoMovil.setActivo(false);
						Usuario u = dispositivoMovil.getUsuario();
						DispositivoMovil nuevoDispositivo = new DispositivoMovil(
								regId, numero);
						nuevoDispositivo.setUsuario(u);
						nuevoDispositivo.setFecha_registro(new Date());
						nuevoDispositivo.setActivo(true);
						System.out.println("cambiar a inactivo");
						dispositivoMovilDAO.guardar(dispositivoMovil);
						System.out.println("nuevo dispositivo");
						dispositivoMovilDAO.guardar(nuevoDispositivo);
						return Constantes.registro.NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO;
					}
				} else {
					usuarioDAO.guardar(usuario);
					DispositivoMovil dispositivoMovil = new DispositivoMovil(
							regId, numero);
					dispositivoMovil.setUsuario(usuario);
					dispositivoMovil.setFecha_registro(new Date());
					dispositivoMovil.setActivo(true);
					dispositivoMovilDAO.guardar(dispositivoMovil);
					return Constantes.registro.REGISTRO_EXITOSO;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return Constantes.errores_servidor.ERROR_SERVIDOR;
			}
		}
		return Constantes.valores_por_defecto.MENOS_UNO;
	}

	private boolean notNull(String str) {
		if (str != null) {
			if (!(str.equals(""))) {
				return true;
			}
		}
		return false;
	}

//	pubLIC INT EXISTEDISPOSITIVO(STRING REGID, STRING NUMERO) {
//		DISPOSITIVOMOVIL EXISTEDISPOSITIVO = DISPOSITIVOMOVILDAO
//				.OBTENERDISPOSITIVOPORREGIDNUMERO(REGID, NUMERO);
//		IF (EXISTEDISPOSITIVO != NULL) {
//			RETURN 1;
//		}
//		RETURN 0;
//	}
	
	@Transactional
	public Map<String, Object> registrarDispositivoMovil(String regId,
			String numero, String email, int tipo_registro_mobile) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		DispositivoMovil dispo ;
		Usuario u;
		switch (tipo_registro_mobile) {
		case Constantes.tipo_registro_mobile.DESDE_CLASE_GCMINTENT_SERVICE:
			dispo = dispositivoMovilDAO.buscarDispositivoMovilPorRegIDMovil(regId);
			if(dispo==null){
				dispo = new DispositivoMovil();
				dispo.setKey_device(regId);
				dispo.setActivo(true);
				dispo.setFecha_registro(new Date());
				dispositivoMovilDAO.guardar(dispo);
				respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil, Constantes.respuestas_servidor.DISPOSITIVO_REGISTRADO);
			}else{
				u = dispo.getUsuario();
				List<DispositivoMovil> listDispositivos = dispositivoMovilDAO.obtenerDispositivosAnterioresPorUsuario(u);
				for (DispositivoMovil dispositivoMovil : listDispositivos) {
					if(!dispositivoMovil.getKey_device().equals(regId)){
						dispositivoMovil.setActivo(false);
						dispositivoMovilDAO.guardar(dispositivoMovil);
					}
				}
				dispo.setActivo(true);
				dispo.setUsuario(u);
				dispositivoMovilDAO.guardar(dispo);
				respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil, Constantes.respuestas_servidor.NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO);
			}
			break;
		case Constantes.tipo_registro_mobile.DESDE_CLASE_REGISTRO_ACTIVITY:
			u = usuarioDAO.existeUsuarioPorEmail(email);
			dispo = dispositivoMovilDAO.buscarDispositivoMovilPorRegIDMovil(regId);
			if(u!=null){
				u.setEmail(email);
				if(dispo!=null){
					List<DispositivoMovil> listDispositivos = dispositivoMovilDAO.obtenerDispositivosAnterioresPorUsuario(u);
					for (DispositivoMovil dispositivoMovil : listDispositivos) {
						if(!dispositivoMovil.getKey_device().equals(regId)){
							dispositivoMovil.setActivo(false);
							dispositivoMovilDAO.guardar(dispositivoMovil);
						}
					}
					dispo.setActivo(true);
					dispo.setNumeromovil(numero);	
					dispo.setUsuario(u);
					respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil, Constantes.respuestas_servidor.NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO);
				}else{
					dispo = new DispositivoMovil();
					dispo.setKey_device(regId);
					dispo.setNumeromovil(numero);	
					dispo.setActivo(true);
					dispo.setFecha_registro(new Date());
					dispo.setUsuario(u);
					respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil, Constantes.respuestas_servidor.DISPOSITIVO_REGISTRADO);
				}
				dispositivoMovilDAO.guardar(dispo);
				usuarioDAO.guardar(u);				
			}else{
				u = new Usuario();
				u.setEmail(email);
				if(dispo==null){
					dispo = new DispositivoMovil();
					dispo.setKey_device(regId);
					dispo.setNumeromovil(numero);
					dispo.setActivo(true);
					dispo.setFecha_registro(new Date());
					dispo.setUsuario(u);	
					respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil, Constantes.respuestas_servidor.NUEVO_DISPOSITIVO_POR_NUEVO_USUARIO_REGISTRADO);
				}else{
					dispo.setKey_device(regId);
					dispo.setNumeromovil(numero);
					dispo.setActivo(true);
					dispo.setUsuario(u);
					dispo.setFecha_registro(new Date());
					respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil, Constantes.respuestas_servidor.NUEVO_USUARIO_POR_DISPOSITIVO_REGISTRADO);
				}
				usuarioDAO.guardar(u);
				dispositivoMovilDAO.guardar(dispo);				
			}
			break;
		case Constantes.tipo_registro_mobile.DESDE_CLASE_MENSAJERIA_ACTIVITY:

			break;

		}

		return respuesta;
	}

	public Map<String, Object> existeDispositivo(String regId) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		DispositivoMovil dispo = dispositivoMovilDAO.buscarDispositivoMovilPorRegIDMovil(regId);
		if(dispo==null){
			respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_existeDispositivo, false );
		}else{
			dispo.getUsuario().setDispositivoMovils(null);
			dispo.getUsuario().setDispositivoMovilActual(null);
			respuesta.put(Constantes.respuestas_servidor.KEY_RESPUESTA_existeDispositivo, true );
			respuesta.put(Constantes.respuestas_servidor.KEY_OBJETO_DIPOSITIVO, dispo );
		}		
		return respuesta;
	}

}
