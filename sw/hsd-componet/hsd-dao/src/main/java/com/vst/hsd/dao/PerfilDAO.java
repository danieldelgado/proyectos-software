package com.vst.hsd.dao;

import java.util.List;

import com.vst.hsd.dominio.Perfil;
import com.vst.util.IDAO;

public interface PerfilDAO extends IDAO<Perfil> {

	List<Perfil> obtenerTodosActivos();

}
