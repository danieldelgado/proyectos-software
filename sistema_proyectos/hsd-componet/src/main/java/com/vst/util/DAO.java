package com.vst.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		log.info(" [ Crea aspecto de la Entidad:" + clazz.getName()+ "]" );
	}

	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		try {
			return (T) em.find(clazz, id);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "cast" })
	public List<T> getTodos() {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e";
		log.info("[ Entro al metodo getTodos de Entidad " + clazz.getName() + "  con query: " + sql + " ]");
		return em.createQuery(sql).getResultList();
	}

	public void guardar(T objeto) {
		try {
			log.info("[ Entro al metodo guardar de Entidad " + clazz.getName() + " ]");
			if (objeto.getId() != null)
				em.merge(objeto);
			else
				em.persist(objeto);
			log.info("[ objeto registrado :"+Util.getJsonObject(objeto)+" ]");	
			log.info("[ Transaction terminada  " + clazz.getName() + " con id :" + objeto.getId()+" ]");
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
			log.error("[ Transaction rollback  " + clazz.getName() + " error: " + e.getMessage()+" ]");
			e.printStackTrace();
		} finally {
			log.info("[ Transaction cerrada finally " + clazz.getName()+" ]");
		}

	}

	public void eliminar(T objeto) {
		try {
			if (objeto.getId() != null)
				em.remove(objeto);
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
			log.error(" Transaction rollback  " + clazz.getName() + " error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			log.info(" Transaction cerrada  " + clazz.getName());
		}

	}

	@SuppressWarnings("unchecked")
	public T obtenerPorCodigo(String codigo, String campoCodigo) {
		Entity e = (Entity) clazz.getAnnotation(Entity.class);
		String nombre = null;
		if (e == null || e.name() == null || e.name().length() == 0)
			nombre = clazz.getSimpleName();
		else
			nombre = e.name();
		String sql = "SELECT e FROM " + nombre + " e  where e." + campoCodigo + " = :codigo";
		log.info("[ Entro al metodo obtenerPorCodigo de Entidad " + clazz.getName() + "  con query: " + sql+" ]");
		return (T) em.createQuery(sql).setParameter("codigo", codigo).getSingleResult();
	}

}
