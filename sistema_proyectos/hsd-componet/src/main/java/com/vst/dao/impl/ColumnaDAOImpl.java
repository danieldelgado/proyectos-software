package com.vst.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.vst.dao.ColumnaDAO;
import com.vst.dominio.Columna;
import com.vst.dominio.Lista;
import com.vst.util.Constantes;
import com.vst.util.DAO;

@Repository("ColumnaDAO")
public class ColumnaDAOImpl extends DAO<Columna> implements ColumnaDAO {

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
		c2.setAtributo("nombre");
		c2.setCabecera("Nombre");
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
		c3.setCabecera("Valor");
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
