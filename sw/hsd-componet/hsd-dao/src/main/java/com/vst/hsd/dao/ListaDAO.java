package com.vst.hsd.dao;

import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Usuario;
import com.vst.util.IDAO;





public interface ListaDAO extends IDAO<Lista> {

	Lista obtenerListaPorUsuario(String entidad, Usuario u);

 

}
