package com.vst.service.mantenimiento.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.service.impl.LoginServiceImpl;
import com.vst.service.mantenimiento.MantenimientoParametroService;
import com.vst.util.Constantes;

@Service("MantenimientoParametroService")
public class MantenimientoParametroServiceImpl implements MantenimientoParametroService {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroService.class);
	
	@Autowired
	private ParametroDAO parametroDAO;
	
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

}
