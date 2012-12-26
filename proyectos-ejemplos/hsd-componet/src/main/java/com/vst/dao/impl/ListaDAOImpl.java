package com.vst.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.dao.ListaDAO;
import com.vst.dominio.Lista;
import com.vst.dominio.Usuario;
import com.vst.util.DAO;




@Repository("ListaDAO")
public class ListaDAOImpl extends DAO<Lista> implements ListaDAO {

	public Lista obtenerListaPorUsuario(String entidad, Usuario u) {
		//Lista(Integer id,String codigo, String nombre, String tabla)
		sqlQuery = " SELECT new Lista( ls.id, ls.codigo, ls.nombre, ls.tabla) FROM Lista ls where ls.tabla = :entidad" +
				   " and " +
				   " ls.id = ( select rpp.id.recurso.id from RecursoPorPerfil rpp where rpp.id.perfil.id = :perfil )   ";
		q=em.createQuery(sqlQuery);
		q.setParameter("entidad", entidad);
		q.setParameter("perfil", u.getPerfilLogueado().getId());	
		try {
			Lista l = (Lista)q.getSingleResult();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

  
  
 


}
