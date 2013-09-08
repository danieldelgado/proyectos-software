package com.google.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.bean.DispositivoMovil;
import com.google.bean.Usuario;
import com.google.gcm.util.DAO;

@Repository("UsuarioDAO")
public class UsuarioDAOImpl extends DAO<Usuario> implements UsuarioDAO {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	
	@SuppressWarnings("unchecked")
//	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		if(usuario!=null){
			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido)  from Usuario u where u.userName=:userName";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por username "+usuario.getUserName());
			q.setParameter("userName", usuario.getUserName());
			List<Usuario> lst = q.getResultList();
			if(lst!=null && lst.size()>0){
				Usuario u = lst.get(0);
				return u ;
			}
		}		
		return null;
	}
	
	@SuppressWarnings("unchecked")
//	@Override
	public Usuario buscarUsuario(String userName) {
		if(userName!=null&&userName.length()>0){
			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido)  from Usuario u where u.userName=:userName";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por username "+userName);
			q.setParameter("userName",userName);
			try {
				Usuario n = (Usuario) q.getSingleResult();
				if (n != null) {
					return  n;
				}
			} catch  (NoResultException e){
				System.out.println("sin resultados");
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}		
		return null;
	}

	public Usuario existeUsuarioPorEmail(String email) {
		if(email!=null&&email.length()>0){
			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido)  from Usuario u where u.email=:email";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por email "+email);
			q.setParameter("email",email);
			try {
				Usuario n = (Usuario) q.getSingleResult();
				if (n != null) {
					return  n;
				}
			} catch  (NoResultException e){
				System.out.println("sin resultados");
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}		
		return null;
	}

//	public boolean buscarUsuarioRegIdDevie(String regId) {
//		if(regId!=null){
//			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido, u.key_device)  from Usuario u where u.key_device=:key_device";
//			q = em.createQuery(sqlQuery);
//			logger.info("buscando usuario por regId "+regId);
//			q.setParameter("key_device",regId);
//			List<Usuario> lst = q.getResultList();
//			if(lst!=null && lst.size()>0){
//				return true ;
//			}
//		}		
//		return false;
//	}
//
//	public Usuario buscarUsuarioPorDevie(String regId) {
//		if(regId!=null){
//			sqlQuery = "select  new Usuario(u.id, u.userName, u.clave, u.nombre, u.apellido, u.key_device)  from Usuario u where u.key_device=:key_device";
//			q = em.createQuery(sqlQuery);
//			logger.info("buscando usuario por regId "+regId);
//			q.setParameter("key_device",regId);
//			List<Usuario> lst = q.getResultList();
//			if(lst!=null && lst.size()>0){
//				Usuario u = lst.get(0);
//				return u ;
//			}
//		}		
//		return null;
//	}
}
