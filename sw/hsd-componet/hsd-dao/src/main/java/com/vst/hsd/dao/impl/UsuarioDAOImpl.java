package com.vst.hsd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.UsuarioDAO;
import com.vst.hsd.dominio.Usuario;
import com.vst.util.DAO;

@Repository("UsuarioDAO")
public class UsuarioDAOImpl extends DAO<Usuario> implements UsuarioDAO {


	@SuppressWarnings("unchecked")
	public Usuario buscarUsuario(String usuario, Integer perfil) {
		sqlQuery =  " select new Usuario(u.id, u.nombre, u.apellidos, u.estado, u.activo, u.codigo, u.login, u.clave) " +
					" from Usuario u LEFT JOIN u.perfiles p  " +
					" where  u.login = :login and p.id = :perfil " ;
					
		q = em.createQuery(sqlQuery);
		q.setParameter("login", usuario);
		q.setParameter("perfil", perfil);
		q.setMaxResults(1);
		//System.out.println(q.);
		List<Usuario> lstU=q.getResultList();
		if(lstU.size()>0){
			Usuario u = lstU.get(0);
			return u;
		}
		return null;
	}

	

}
