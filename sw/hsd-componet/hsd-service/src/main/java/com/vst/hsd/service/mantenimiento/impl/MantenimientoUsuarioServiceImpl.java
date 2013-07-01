package com.vst.hsd.service.mantenimiento.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.hsd.dao.UsuarioDAO;
import com.vst.hsd.dominio.Usuario;
import com.vst.hsd.service.mantenimiento.MantenimientoUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class MantenimientoUsuarioServiceImpl.
 */
@Service("MantenimientoUsuarioService")
public class MantenimientoUsuarioServiceImpl implements MantenimientoUsuarioService {

	/** The usuario dao. */
	@Autowired
	UsuarioDAO usuarioDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vst.hsd.service.mantenimiento.MantenimientoUsuarioService#guardar
	 * (com.vst.hsd.dominio.Usuario)
	 */
	@Transactional
	public void guardar(Usuario u) {
		usuarioDAO.guardar(u);

	}

}
