package com.vst.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class DAO<T extends Entidad> implements IDAO<T> {

	private static final Logger log = LoggerFactory.getLogger(DAO.class);

	@PersistenceContext
	protected EntityManager em;

	private Class<Entidad> clazz;

	protected String sqlQuery = null;

	protected Query q = null;

	@SuppressWarnings("unchecked")
	public DAO() {
		clazz = (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		log.debug(" [ Crea aspecto de la Entidad:" + clazz.getName() + "]");
	}

	@SuppressWarnings("unchecked")
	public T get(Integer id) {
			return (T) em.find(clazz, id);		
	}

	@SuppressWarnings("unchecked")
	public List<T> getTodos() {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e";
		return em.createQuery(sql).getResultList();
	}
	
	public void guardar(T objeto) {
			if (objeto.getId() != null)
				em.merge(objeto);
			else
				em.persist(objeto);
	}

	public void eliminar(T objeto) {
			if (objeto.getId() != null)
				em.remove(objeto);
	}

	@SuppressWarnings("unchecked")
	public T getPorCodigo(String codigo) {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e  where e.codigo = :codigo";
		return (T) em.createQuery(sql).setParameter("codigo", codigo).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getTodosActivos() {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e where e.activo = 'A'";
		return em.createQuery(sql).getResultList();
	}

}
