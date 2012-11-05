package com.vst.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.dao.ListaDAO;
import com.vst.dominio.Lista;
import com.vst.dominio.Usuario;
import com.vst.util.DAO;




@Repository("ListaDAO")
public class ListaDAOImpl extends DAO<Lista> implements ListaDAO {

	public Lista obtenerListaPorUsuario(String entidad, Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

  
  
 


}
