package com.vst.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.ColumnaDAO;
import com.vst.dao.DataListComponet;
import com.vst.dao.ListaDAO;
import com.vst.dominio.Columna;
import com.vst.dominio.Lista;
import com.vst.dominio.Usuario;
import com.vst.service.PrincipalService;
import com.vst.util.Constantes;

@Service("PrincipalService")
public class PrincipalServiceImpl implements PrincipalService {


	private static final Logger log = LoggerFactory.getLogger(PrincipalServiceImpl.class);
			
	@Autowired
	private ListaDAO listaDAO;
	
	@Autowired
	private ColumnaDAO columnaDAO;
	
	@Autowired
	private DataListComponet dataListComponet;
	
	public Lista obtenerListaEntidad(String entidad, HttpSession session) {		
		log.info("[ metodo:buscarUsuarioLogueado - buscar el usuario en session ]");
		Usuario u = (Usuario) session.getAttribute(Constantes.SESION_USUARIO);		
		Lista lista = listaDAO.obtenerListaPorUsuario(entidad,u);
		
		lista = new Lista();
		lista.setCodigo("parametro");
		lista.setIdMenu(1);
		lista.setTabla("parametro");
		lista.setNombre("Lsita de Parametro");	
		
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
			
		lista.setColumnas(columnas);
		
		return lista;
	}


	public Map<String, Object> obtenerData(Usuario usuario, String entidad, String sidx, String sord, int page, int filas, boolean _search, String searchField, String searchOper, String searchString) {
		
		Character estado='A';		
		Lista lista  = new Lista();
		lista.setCodigo("parametro");
		lista.setIdMenu(1);
		lista.setTabla("parametro");
		log.debug("Grid: " + lista);
		if(lista != null){
			List<Columna> columnas=columnaDAO.buscarPorLista(lista.getId());
			if(columnas != null && columnas.size() > 0){
				Map<String,Object> objeto=new HashMap<String,Object>();
				int count=dataListComponet.getCantidadDataRows(usuario,entidad,estado);
				int total=0;
				int records=0;
				if(count > 0){
					int resto=count%filas;
					if(resto==0){
						total=count/filas;
					}else{
						total=count/filas + 1;
					}
				}
				List<Map<String,Object>> data=dataListComponet.getData(usuario,entidad,columnas,lista.getEstado(),sidx,sord,page,filas,_search,searchField,searchOper,searchString);
				objeto.put("page",page);
				objeto.put("total",total);
				if(data != null){
					records=data.size();
				}
				objeto.put("records",records);
				objeto.put("data",data);				
				return objeto;
			}
		}
		return null;
	}


}
