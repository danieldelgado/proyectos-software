package com.vst.dao;

import java.util.List;

import com.vst.dominio.Perfil;
import com.vst.util.IDAO;

public interface PerfilDAO extends IDAO<Perfil> {

	List<Perfil> obtenerTodosActivos();

}
