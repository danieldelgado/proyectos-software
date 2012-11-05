package com.vst.dao;

import com.vst.dominio.Lista;
import com.vst.dominio.Usuario;
import com.vst.util.IDAO;





public interface ListaDAO extends IDAO<Lista> {

	Lista obtenerListaPorUsuario(String entidad, Usuario u);

 

}
