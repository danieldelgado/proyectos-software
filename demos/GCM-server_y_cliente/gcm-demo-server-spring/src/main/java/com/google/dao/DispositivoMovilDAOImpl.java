package com.google.dao;

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
			DispositivoMovil dm = (DispositivoMovil) q.getSingleResult();
			return  dm;
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

}
