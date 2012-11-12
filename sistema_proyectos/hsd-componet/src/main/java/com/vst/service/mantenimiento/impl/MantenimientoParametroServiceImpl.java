package com.vst.service.mantenimiento.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.ParametroDAO;
import com.vst.dao.ParametroPorParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.dominio.ParametroPorParametro;
import com.vst.service.mantenimiento.MantenimientoParametroService;
import com.vst.util.Constantes;
import com.vst.util.Util;

@Service("MantenimientoParametroService")
public class MantenimientoParametroServiceImpl implements MantenimientoParametroService {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroService.class);
	
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Autowired
	private ParametroPorParametroDAO parametroPorParametroDAO;
	
	public List<Parametro> obtenerEstados() {
		List<Parametro> l =  parametroDAO.obtenerPorTipo(Constantes.TIPO_ESTADO);
		Parametro p12 = new Parametro();
		p12.setCodigo("asdasd");
		p12.setId(0);
		p12.setTipo(Constantes.TIPO_ESTADO);
		p12.setValor("Select");
		l.add(p12);
		
		Parametro p1 = new Parametro();
		p1.setCodigo("asdasd");
		p1.setId(1);
		p1.setTipo(Constantes.TIPO_ESTADO);
		p1.setValor("Activo");
		l.add(p1);
		
		Parametro p2 = new Parametro();
		p2.setCodigo("asdasd1");
		p2.setId(2);
		p2.setTipo(Constantes.TIPO_ESTADO);
		p2.setValor("Pendiente");
		l.add(p2);

		Parametro p3 = new Parametro();
		p3.setCodigo("asdasd2");
		p3.setId(3);
		p3.setTipo(Constantes.TIPO_ESTADO);
		p3.setValor("Inactivo");
		l.add(p3);
		

		Parametro p4 = new Parametro();
		p4.setCodigo("asdasd3");
		p4.setId(4);
		p4.setTipo(Constantes.TIPO_ESTADO);
		p4.setValor("Pendiente2");
		l.add(p4);

		Parametro p5 = new Parametro();
		p5.setCodigo("asdasd35");
		p5.setId(5);
		p5.setTipo(Constantes.TIPO_ESTADO);
		p5.setValor("Inactivo23");
		l.add(p5);

		Parametro p6 = new Parametro();
		p6.setCodigo("asdasd36");
		p6.setId(6);
		p6.setTipo(Constantes.TIPO_ESTADO);
		p6.setValor("Habil");
		l.add(p6);
		
		
		return l;
	}

	public List<Parametro> obtenerParametrosPadre() {
		List<Parametro> l =  parametroDAO.obtenerParametrosPadre();	
		return l;
	}
	


	public Parametro obtenerParametro(int param) {
		
		return null;
	}
	
	//@Transactional
	public int guardarParametro(Parametro parametro) {
		System.out.println("guardar");
		return 1;
	}

	public Parametro obtenerParametrosRulesEntidad(String entidad) {
		Parametro entidadParametrorules=parametroDAO.parametroPorParametroDAO(entidad);	
		entidadParametrorules.setParametroPorParametrosPadre(null);
		entidadParametrorules.setParametro(null);
		entidadParametrorules.setParametros(null);
		entidadParametrorules.setParametros(parametroDAO.obtenerParametrosHijos(entidadParametrorules.getId()));		
		List<ParametroPorParametro> parametroPorParametrosHijo = parametroPorParametroDAO.obtenerParametrosPorParametrosPorParametro(entidadParametrorules);
		for (int i = 0; i < parametroPorParametrosHijo.size(); i++) {
			ParametroPorParametro ppH=parametroPorParametrosHijo.get(i);
			Integer pp1=ppH.getId().getParametroIdParametroPadre();
			Integer pp2=ppH.getId().getParametroIdParametroHijo();
			ppH.setParametroPadre(parametroDAO.get(pp1));
			ppH.setParametroHijo(parametroDAO.get(pp2));
		}
		entidadParametrorules.setParametroPorParametrosHijo(parametroPorParametrosHijo);
				
		
		
		
		//System.out.println("Util  obtenerParametrosRulesEntidad :  "+Util.getJsonObject(entidadParametrorules));
		return entidadParametrorules;
	}

	
	
}

