package com.vst.hsd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.hsd.dao.BotonDAO;
import com.vst.hsd.dao.ColumnaDAO;
import com.vst.hsd.dao.DataListComponet;
import com.vst.hsd.dao.ListaDAO;
import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Columna;
import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Usuario;
import com.vst.hsd.service.PrincipalService;
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
	
	@Autowired
	private BotonDAO botonDAO;
	
	public Lista obtenerListaEntidad(String entidad, HttpSession session) {		
		log.info("metodo:buscarUsuarioLogueado - buscar el usuario en session");
		Usuario u = (Usuario) session.getAttribute(Constantes.SESION_USUARIO);	
		if(u!=null){
			Lista l = listaDAO.obtenerListaPorUsuario(entidad, u);
			if(l!=null){
				log.info(" Lista obtenida :"+l.getCodigo());
				List<Columna> lstColumnas = columnaDAO.buscarPorLista(l.getId());
				log.info(" lista de columnas  :"+lstColumnas.size());
				l.setColumnas(lstColumnas);
				l.setMenus(null);
				return l;		
			}				
		}
		return null;		
	}


	public Map<String, Object> obtenerData(Usuario usuario, String entidad, String sidx, String sord, int page, int filas, boolean _search, String searchField, String searchOper, String searchString) {
		
		Character estado='A';		
		Lista lista  = listaDAO.obtenerListaPorEntidad(entidad);
		log.info(" Lista obtenida :"+lista.getCodigo());
		if(lista != null){
			List<Columna> columnas=columnaDAO.buscarPorLista(lista.getId());
			if(columnas != null && columnas.size() > 0){
				Map<String,Object> objeto=new HashMap<String,Object>();
				int count=dataListComponet.getCantidadDataRows(usuario,entidad,estado);			
				log.info("  lista generica count:"+count);
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
							
				log.info("  data generica count:"+data.size());
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


	public List<Menu> obtenerMenusPorPerfil(Usuario u) {
		List<Menu> ms = new ArrayList<Menu>();
		Menu m = new Menu();
		m.setId(1);
		m.setNombre("Mantenimiento");
		m.setUrl(null);
		m.setTipo("interno");
		m.setOrden(0);
		m.setFunction(null);
		ms.add(m);

		List<Menu> mss = new ArrayList<Menu>();
		Menu mm = new Menu();
		mm.setId(1);
		mm.setNombre("Parametro");
		mm.setUrl("Parametro");
		mm.setDefaultMenu(true);
		mm.setTipo("interno");
		mm.setOrden(0);
		mm.setFunction(null);
		mss.add(mm);

		Menu mm2 = new Menu();
		mm2.setId(1);
		mm2.setNombre("Perfil");
		mm2.setUrl("Perfil");
		mm2.setTipo("interno");
		mm2.setOrden(0);
		mm2.setFunction(null);
		mss.add(mm2);

		Menu mm3 = new Menu();
		mm3.setId(1);
		mm3.setNombre("Lista");
		mm3.setUrl("Lista");
		mm3.setTipo("interno");
		mm3.setOrden(0);
		mm3.setFunction(null);
		mss.add(mm3);

		Menu mm4 = new Menu();
		mm4.setId(1);
		mm4.setNombre("Columna");
		mm4.setUrl("Columna");
		mm4.setTipo("interno");
		mm4.setOrden(0);
		mm4.setFunction(null);
		mss.add(mm4);

		m.setMenus(mss);

		return ms;
	}


	public List<Boton> obtenerBotonesPorMenuDefault(List<Menu> lstMenus) {
	
		List<Boton> bs = new ArrayList<Boton>();
		Boton b = new Boton();
		b.setId(1);
		b.setActivo(true);
		b.setDescripcion(" boton prueba  ");
		bs.add(b);
		
		Boton b2 = new Boton();
		b2.setId(1);
		b2.setActivo(true);
		b2.setDescripcion(" Guardar  ");
		bs.add(b2);
		
		return bs;
	}


}
