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

	

}
