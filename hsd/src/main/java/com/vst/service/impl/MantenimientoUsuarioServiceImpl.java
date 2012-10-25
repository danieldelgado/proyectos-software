package com.vst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;
import com.vst.service.MantenimientoUsuarioService;

@Service("MantenimientoUsuarioService")
public class MantenimientoUsuarioServiceImpl implements MantenimientoUsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Transactional
	public void guardar(Usuario u) {
		usuarioDAO.guardar(u);
		
	}

}
