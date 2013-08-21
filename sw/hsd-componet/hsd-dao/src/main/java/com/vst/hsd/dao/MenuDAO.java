package com.vst.hsd.dao;

import java.util.List;

import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Usuario;
import com.vst.util.persistence.IDAO;

/**
 * The Interface MenuDAO.
 */
public interface MenuDAO extends IDAO<Menu> {

	List<Menu> obtenerMenusPorPerfil(Usuario u);

	List<Menu> obtenerSubMenus(Integer id);

}
