package com.vst.hsd.service.mantenimiento.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.hsd.dao.BotonDAO;
import com.vst.hsd.dao.FormularioDAO;
import com.vst.hsd.dao.ParametroDAO;
import com.vst.hsd.dao.ParametroPorParametroDAO;
import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Formulario;
import com.vst.hsd.dominio.Parametro;
import com.vst.hsd.service.mantenimiento.MantenimientoParametroService;

@Service("MantenimientoParametroService")
public class MantenimientoParametroServiceImpl implements MantenimientoParametroService {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroService.class);

	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private FormularioDAO formularioDAO;

	@Autowired
	private ParametroPorParametroDAO parametroPorParametroDAO;

	@Autowired
	private BotonDAO botonDAO;
	
	public List<Parametro> obtenerEstados() {
		log.info("obtenerEstados");
		return null;
	}
	
	public List<Parametro> obtenerParametrosPadre() {

		return null;
	}

	public Parametro obtenerParametro(int param) {

		return null;
	}

	public int guardarParametro(Parametro parametro) {
		return 1;
	}

	@SuppressWarnings("rawtypes")
	public List obtenerParametrosRulesEntidad(String entidad) {
		// Parametro
		// entidadParametrorules=parametroDAO.parametroPorParametroDAO(entidad);
		// List<Parametro> parametroshijo =
		// parametroDAO.obtenerParametrosHijos(entidadParametrorules.getId());
		// Map<String, Object> camposReglas = new HashMap<String, Object>();
		// for (int i = 0; i < parametroshijo.size(); i++) {
		// Parametro pH = parametroshijo.get(i);
		// String campo= pH.getCampo();
		// List<ParametroPorParametro> parametroPorParametrosHijos =
		// parametroPorParametroDAO.obtenerParametroPorParametroPorParametroHijo(pH);
		// Map<String, Object> reglas = new HashMap<String, Object>();
		// for (int j = 0; j < parametroPorParametrosHijos.size(); j++) {
		// ParametroPorParametro pppRules = parametroPorParametrosHijos.get(j);
		// Parametro
		// ppH=parametroDAO.get(pppRules.getId().getParametroIdParametroHijo());
		// String obj = "";
		// if((pppRules.getAtributo()!=null)){
		// if((!pppRules.getAtributo().equals(""))){
		// obj = pppRules.getAtributo();
		// }else{
		// obj = ppH.getAtributo();
		// }
		// }else{
		// obj = ppH.getAtributo();
		// }
		// if(ppH.getTipovariable().toLowerCase().equals("string")){
		// reglas.put(obj, ppH.getValor());
		// }
		// if(ppH.getTipovariable().toLowerCase().equals("integer")){
		// reglas.put(obj,Integer.parseInt(ppH.getValor()));
		// }
		// if(ppH.getTipovariable().toLowerCase().equals("boolean")){
		// reglas.put(obj,Boolean.parseBoolean(ppH.getValor()));
		// }
		// if(ppH.getTipovariable().toLowerCase().equals("double")){
		// reglas.put(obj,Double.parseDouble(ppH.getValor()));
		// }
		//
		// }
		// camposReglas.put(campo,reglas);
		// }
		// List l = new ArrayList();
		// l.add(camposReglas);
		return null;
	}
	
	public List<Map<String, Object>> obtenerParametros() {
		// List<Parametro> l = parametroDAO.obtenerParametros();
		// List<Map<String,Object>> lstObj = new
		// ArrayList<Map<String,Object>>();
		// for (int i = 0; i < l.size() ; i++) {
		// Map<String, Object> obj = new HashMap<String, Object>();
		// Parametro p = l.get(i);
		// obj.put("id", p.getId());
		// obj.put("nombre", p.getNombre());
		// lstObj.add(obj);
		// }
		return null;
	}

	public Formulario obtenerFormulario(String codigoFormulario) {
		Formulario f = formularioDAO.getPorCodigo(codigoFormulario);		
		return f;
	}

	public List<Boton> obtenerBotonesPorFormulario(String codigoFormulario) {
		List<Boton>  l = botonDAO.obtenerBotonesPorFormulario(codigoFormulario);
		return l;
	}

}
