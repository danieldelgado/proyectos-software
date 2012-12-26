package com.vst.ws.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vst.util.Config;
import com.vst.util.Constantes;
import com.vst.util.Util;
import com.vst.ws.CamposValidar;
import com.vst.ws.Validador;
import com.vst.ws.WsValidarEndPointProxy;

public class ServicioWebValidacion {

	public static final WsValidarEndPointProxy validarProxy = new WsValidarEndPointProxy();

	private static final Logger log = LoggerFactory.getLogger(ServicioWebValidacion.class);
	
	private static final Boolean isValidar =  Boolean.parseBoolean(Config.getPropiedad("validar.ws.valdarMethod"));
	
	public static Validador obtenerValidadorServiceLogin( String usuario , String clave , Integer perfil ){	
		Validador v=null;		
		if(isValidar){			
//			List<CamposValidar> lstCampos = new ArrayList<CamposValidar>();
//			CamposValidar cmp1 = new CamposValidar();
//			cmp1.setCampo(Constantes.CAMPO_LOGIN_USUARIO);
//			cmp1.setValor(usuario);
//			lstCampos.add(cmp1);
//			CamposValidar cmp2 = new CamposValidar();
//			cmp2.setEntidad("usuario");
//			cmp2.setCampo(Constantes.CAMPO_CLAVE);
//			cmp2.setTipo(Constantes.CAMPO_CLAVE);
//			cmp2.setValor(clave);
//			lstCampos.add(cmp2);
//			CamposValidar cmp3 = new CamposValidar();
//			cmp3.setCampo(Constantes.CAMPO_SELECTOR);
//			cmp3.setValor(String.valueOf(perfil));
//			lstCampos.add(cmp3);	
//			try {				
//				v = validarProxy.validarParametros(lstCampos.toArray(new CamposValidar[lstCampos.size()]));
				log.info("[ metodo:obtenerValidadorServiceLogin - respuesta de servicio web validar : " + Util.getJson(v) + " ]");
//				return v;
//			} catch (RemoteException e) {		
//				e.printStackTrace();
//			}				
		}else{			
			v = new Validador();
			v.setRespuesta(1);
			return v;
		}	
		return null;
	}
	
	
	
}
