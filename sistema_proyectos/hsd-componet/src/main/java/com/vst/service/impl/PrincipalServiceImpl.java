package com.vst.service.impl;

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
		if(u!=null){
			Lista l = listaDAO.obtenerListaPorUsuario(entidad, u);
			l.setColumnas(columnaDAO.buscarPorLista(l.getId()));
			l.setMenus(null);
			return l;			
		}
		return null;		
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
