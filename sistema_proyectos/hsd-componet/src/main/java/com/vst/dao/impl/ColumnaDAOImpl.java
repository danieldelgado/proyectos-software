package com.vst.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.vst.dao.ColumnaDAO;
import com.vst.dominio.Columna;
import com.vst.util.Constantes;
import com.vst.util.DAO;

@Repository("ColumnaDAO")
public class ColumnaDAOImpl extends DAO<Columna> implements ColumnaDAO {

	/*@SuppressWarnings("unchecked")
	public List<Columna> buscarPorGrid(Integer idGrid){
		sqlQuery="SELECT new Columna(c.id,c.grid.id,c.nombre,c.codigo,c.ancho,c.visible,c.tipo,c.orden,c.titulo,c.procesar,c.alineacion) FROM Columna c WHERE c.grid.id=:idGrid AND c.estado=:estado ORDER BY c.orden";
		q=em.createQuery(sqlQuery);
		q.setParameter("idGrid",idGrid);
		q.setParameter("estado",Constantes.ACTIVO);
		return q.getResultList();
	}*/

	public boolean eliminarColuma(int idColumna){
		sqlQuery="DELETE FROM Columna c WHERE c.id=:idColumna";
		q=em.createQuery(sqlQuery);
		q.setParameter("idColumna",idColumna);
		return q.executeUpdate()==1;
	}

	/*@SuppressWarnings("unchecked")
	public List<Columna> buscarTodasPorGrid(int idGrid){
		sqlQuery="SELECT new Columna(c.id,c.grid.id,c.nombre,c.codigo,c.ancho,c.visible,c.tipo,c.orden,c.titulo,c.procesar) FROM Columna c WHERE c.grid.id=:idGrid ORDER BY c.nombre";
		q=em.createQuery(sqlQuery);
		q.setParameter("idGrid",idGrid);
		return q.getResultList();
	}*/

	public List<Columna> buscarPorLista(Integer id) {
		List<Columna> columnas = new ArrayList<Columna>();
		Columna c1 = new Columna();
		c1.setActivo(true);
		c1.setAddColumn(true);
		c1.setAncho(0);
		c1.setAtributo("id");
		c1.setCabecera("id");
		c1.setEstado(Constantes.ACTIVO);
		c1.setFechaActualizacion(new Date());
		c1.setFechaRegistro(new Date());
		c1.setId(1);
		c1.setMapping(true);
		c1.setOrden(1);
		c1.setVisible(false);
		columnas.add(c1);
		
		Columna c2 = new Columna();
		c2.setActivo(true);
		c2.setAddColumn(true);
		c2.setAncho(100);
		c2.setAtributo("campo");
		c2.setCabecera("campo");
		c2.setEstado(Constantes.ACTIVO);
		c2.setFechaActualizacion(new Date());
		c2.setFechaRegistro(new Date());
		c2.setId(2);
		c2.setMapping(true);
		c2.setOrden(2);
		c2.setVisible(true);
		columnas.add(c2);
		
		
		Columna c3 = new Columna();
		c3.setActivo(true);
		c3.setAddColumn(true);
		c3.setAncho(100);
		c3.setAtributo("valor");
		c3.setCabecera("valor");
		c3.setEstado(Constantes.ACTIVO);
		c3.setFechaActualizacion(new Date());
		c3.setFechaRegistro(new Date());
		c3.setId(3);
		c3.setMapping(true);
		c3.setOrden(3);
		c3.setVisible(true);
		columnas.add(c3);
					
		return columnas;
	}

}
