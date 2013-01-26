package com.vst.hsd.dao;

import java.util.List;

import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Menu;
import com.vst.util.IDAO;

public interface BotonDAO extends IDAO<Boton> {

	List<Boton> obtenerBotonesPorMenu(Menu m);

}
