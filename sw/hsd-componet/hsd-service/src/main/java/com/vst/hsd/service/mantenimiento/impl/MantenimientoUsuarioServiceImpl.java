package com.vst.hsd.service.mantenimiento.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.hsd.dao.UsuarioDAO;
import com.vst.hsd.dominio.Usuario;
import com.vst.hsd.service.mantenimiento.MantenimientoUsuarioService;

@Service("MantenimientoUsuarioService")
public class MantenimientoUsuarioServiceImpl implements MantenimientoUsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Transactional
	public void guardar(Usuario u) {
		usuarioDAO.guardar(u);
		
	}

}
