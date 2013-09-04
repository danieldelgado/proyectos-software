package com.google.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private DispositivoMovilDAO  dispositivoMovilDAO;
	
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
		boolean existe = dispositivoMovilDAO.existeDispositivoMovilPorRegIDMovil(regId);
		if(existe){
			System.out.println("registrado");
			usuario = dispositivoMovilDAO.obtenerUsuarioPorRegIDMovil(regId);
		}else{
			System.out.println("no registrado");
			usuario = new Usuario("device", "device", "device", "device");			
			DispositivoMovil d = new DispositivoMovil();
			d.setKey_device(regId);
			d.setFecha_registro(new Date());
			d.setActivo(true);
			d.setNumeromovil("0000000000");
			d.setUsuario(usuario);
			List<DispositivoMovil> s =new ArrayList<DispositivoMovil>();
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
//		DispositivoMovil dispositivo=dispositivoMovilDAO.obtenerDispositivoActualPorUsuario(usuario);
//		usuario.setDispositivoMovilActual(dispositivo);
		return usuario;
	}

	public Usuario obtenerUsuarioPorIDDispositivoActual(int id) {
		Usuario usuario = usuarioDAO.get(id);
		DispositivoMovil dispositivo=dispositivoMovilDAO.obtenerDispositivoActualPorUsuario(usuario);
		usuario.setDispositivoMovilActual(dispositivo);
		return usuario;
	}
	
	@Transactional
	public int registrarUsuarioDesdeDispositivoMovil(Usuario usuario, String numero, String regId) {
		if(notNull(numero)&&notNull(regId)){
			boolean existeNumero = dispositivoMovilDAO.existeDispositivoMovilPorNumero(numero);	
			System.out.println("existeNumero:"+existeNumero);
			try {
				if(existeNumero){
					boolean redID = dispositivoMovilDAO.existeDispositivoMovilPorRegIDMovil(regId);
					System.out.println("redID:"+redID);
					if(redID){
						return  Constantes.DISPOSITIVO_REGISTRADO;
					}else{
						DispositivoMovil dispositivoMovil = dispositivoMovilDAO.obtenerDispositivoMovilActualPorNumero(numero);
						dispositivoMovil.setActivo(false);
						Usuario u = dispositivoMovil.getUsuario();
						DispositivoMovil nuevoDispositivo = new DispositivoMovil(regId, numero);
						nuevoDispositivo.setUsuario(u);
						nuevoDispositivo.setFecha_registro(new Date());
						nuevoDispositivo.setActivo(true);			
						System.out.println("cambiar a inactivo");
						dispositivoMovilDAO.guardar(dispositivoMovil);	
						System.out.println("nuevo dispositivo");
						dispositivoMovilDAO.guardar(nuevoDispositivo);	
						return  Constantes.NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO;
					}			
				}else{
					usuarioDAO.guardar(usuario);	
					DispositivoMovil dispositivoMovil = new DispositivoMovil(regId, numero);
					dispositivoMovil.setUsuario(usuario);
					dispositivoMovil.setFecha_registro(new Date());
					dispositivoMovil.setActivo(true);
					dispositivoMovilDAO.guardar(dispositivoMovil);
					return  Constantes.REGISTRO_EXITOSO;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return Constantes.ERROR_SERVIDOR;
			}
		}
		return Constantes.MENOS_UNO;
	}

	private boolean notNull(String str) {
		if(str!=null){
			if(!(str.equals(""))){
				return true;
			}
		}
		return false;
	}

	public int existeDispositivo(String regId, String numero) {
		DispositivoMovil existeDispositivo = dispositivoMovilDAO.obtenerDispositivoPorRegIDNumero(regId,numero);
		if(existeDispositivo!=null){
			return 1;
		}
		return 0;
	}

	

}
