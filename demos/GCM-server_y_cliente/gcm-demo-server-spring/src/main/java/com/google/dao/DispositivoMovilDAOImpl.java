package com.google.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.bean.DispositivoMovil;
import com.google.bean.Usuario;
import com.google.gcm.util.DAO;

@Repository("DispositivoMovilDAO")
public class DispositivoMovilDAOImpl extends DAO<DispositivoMovil> implements DispositivoMovilDAO {

	private static final Logger logger = LoggerFactory.getLogger(DispositivoMovilDAOImpl.class);

	public boolean existeDispositivoMovilPorRegIDMovil(String regId) {
		if (regId != null) {
			sqlQuery = "select count(dm.id) from DispositivoMovil dm where dm.key_device=:key_device";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por regId " + regId);
			q.setParameter("key_device", regId);
			Long n = (Long) q.getSingleResult();
			if (n != null && n > 0) {
				return true;
			}
		}
		return false;
	}

	public Usuario obtenerUsuarioPorRegIDMovil(String regId) {
		if (regId != null) {
			sqlQuery = "select dm.usuario from DispositivoMovil dm where dm.key_device=:key_device";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por regId " + regId);
			q.setParameter("key_device", regId);
			Usuario u = (Usuario) q.getSingleResult();
			return u;
		}
		return null;
	}

	public DispositivoMovil buscarDispositivoMovilPorRegIDMovil(String regId) {
		if (regId != null) {
			sqlQuery = "select dm from DispositivoMovil dm where dm.key_device=:key_device";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por regId " + regId);
			q.setParameter("key_device", regId);
//			DispositivoMovil dm = (DispositivoMovil) q.getSingleResult();
			try {
				DispositivoMovil n = (DispositivoMovil) q.getSingleResult();
				if (n != null) {
					return  n;
				}

			} catch  (NonUniqueResultException e){
				System.out.println("muchos resultados");
			} catch  (NoResultException e){
				System.out.println("sin resultados");
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return null;
	}

	public DispositivoMovil obtenerDispositivoActualPorUsuario(Usuario usuario) {
		sqlQuery = "select dm from DispositivoMovil dm where dm.usuario.id=:idUsuario and dm.activo = true order by dm.fecha_registro asc";
		q = em.createQuery(sqlQuery);
		logger.info("obtenerDispositivoActualPorUsuario id " + usuario.getId());
		q.setParameter("idUsuario", usuario.getId());
		DispositivoMovil dm = (DispositivoMovil) q.getSingleResult();
		return dm;
	}

	public boolean existeDispositivoMovilPorNumero(String numero) {
		if (numero != null) {
			sqlQuery = "select count(dm.id) from DispositivoMovil dm where dm.numeromovil=:numero";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por numero " + numero);
			q.setParameter("numero", numero);
			Long n = (Long) q.getSingleResult();
			if (n != null && n > 0) {
				return true;
			}
		}
		return false;
	}

	public DispositivoMovil obtenerDispositivoMovilActualPorNumero(String numero) {
		if (numero != null) {
			sqlQuery = "select dm from DispositivoMovil dm where dm.numeromovil=:numero order by dm.fecha_registro asc ";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por numero " + numero);
			q.setParameter("numero", numero);
			q.setMaxResults(1);
			try {
				DispositivoMovil n = (DispositivoMovil) q.getSingleResult();
				if (n != null) {
					return  n;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return null;
	}

	public DispositivoMovil obtenerDispositivoPorRegIDNumero(String regId, String numero) {
		if (numero != null) {
			sqlQuery = "select dm from DispositivoMovil dm where dm.key_device=:key_device and dm.numeromovil=:numero order by dm.fecha_registro asc ";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario por numero " + numero);
			q.setParameter("numero", numero);
			q.setParameter("key_device", regId);
			q.setMaxResults(1);
			try {
				DispositivoMovil n = (DispositivoMovil) q.getSingleResult();
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

	@SuppressWarnings("unchecked")
	public List<DispositivoMovil> obtenerDispositivosAnterioresPorUsuario(Usuario u) {
		if (u != null) {
			sqlQuery = "select dm from DispositivoMovil dm where dm.usuario.id=:id ";
			q = em.createQuery(sqlQuery);
			logger.info("buscando usuario obtenerDispositivosAnterioresPorUsuario " + u);
			q.setParameter("id", u.getId());
			q.setMaxResults(1);
			try {
				List<DispositivoMovil> n =  q.getResultList();
				if (n != null) {
					return  n;
				}				
			} catch  (NoResultException e){
				System.out.println("obtenerDispositivosAnterioresPorUsuario sin resultados");
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return null;
	}

}