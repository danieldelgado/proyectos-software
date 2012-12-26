package com.vst.hsd.dao;

import java.util.List;
import java.util.Map;

import com.vst.hsd.dominio.Columna;
import com.vst.hsd.dominio.Usuario;


public interface DataListComponet {
	
	List<Map<String,Object>> getData(Usuario usuario,String codigo,List<Columna> columnas,Character estado,String columnaOrden,String direccionOrden, int pagina, int filas, boolean _search, String searchField, String searchOper, String searchString);
	
	Integer getCuentaData(Usuario usuario,String codigo,List<Columna> columnas,Character estado);

    int getCantidadDataRows(Usuario usuario,String codigo,Character estado);
}
