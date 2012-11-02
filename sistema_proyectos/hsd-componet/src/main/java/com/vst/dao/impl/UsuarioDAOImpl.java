package com.vst.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;
import com.vst.util.DAO;

@Repository("UsuarioDAO")
public class UsuarioDAOImpl extends DAO<Usuario> implements UsuarioDAO {


	public Usuario buscarUsuario(String usuario, Integer perfil) {
		sqlQuery =  " select new Usuario(u.id, u.nombre, u.apellidos, u.estado, u.activo, u.codigo, u.login, u.clave,u.perfils) " +
					" from Usuario u  left join fetch u.perfils perfiles " +
					" where " +
					" u.login = :login and" +
					" perfiles.id = :perfil ";		
		q = em.createQuery(sqlQuery);
		q.setParameter("login", usuario);
		q.setParameter("perfil", perfil);
		q.setMaxResults(1);
		Usuario u = (Usuario)q.getSingleResult();
		return u;
	}

	

}
