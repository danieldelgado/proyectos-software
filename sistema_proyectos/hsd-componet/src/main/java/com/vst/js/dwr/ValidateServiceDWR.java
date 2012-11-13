package com.vst.js.dwr;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dominio.Parametro;
import com.vst.service.mantenimiento.MantenimientoParametroService;

@Service("springService2")
@RemoteProxy(name = "validateServiceDWR")
public class ValidateServiceDWR {

	private static Logger log=LoggerFactory.getLogger(ValidateServiceDWR.class);
	
	@Autowired
	private MantenimientoParametroService mantenimientoParametroService;
	
	/*@RemoteMethod
	public Parametro obtenerParametrosRulesEntidad(String entidad){
		return mantenimientoParametroService.obtenerParametrosRulesEntidad(entidad);
	}
	*/
	
}
