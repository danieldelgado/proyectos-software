package com.vst.ws.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.util.Constantes;
import com.vst.util.Util;
import com.vst.ws.service.MantenimientoParametroService;

@Service("MantenimientoParametroService")
public class MantenimientoParametroServiceImpl implements MantenimientoParametroService {

	@Autowired
	private ParametroDAO parametroDAO;
	
	@Transactional
	public String registrarParametrosIniciales() {
		Parametro cantidadDecimales = new Parametro();
		cantidadDecimales.setActivo(true);
		cantidadDecimales.setCodigo(Util.getCodigo(cantidadDecimales));
		cantidadDecimales.setDescripcion("cantidadDecimales");
		cantidadDecimales.setEstado(Constantes.ACTIVO);
		cantidadDecimales.setFechaActualizacion(new Date());
		cantidadDecimales.setFechaRegistro(new Date());
		cantidadDecimales.setTipo(Constantes.CANTIDAD_DECIMALES);
		cantidadDecimales.setValor("2");
		parametroDAO.guardar(cantidadDecimales);
		
		Parametro rangoEnteroMin = new Parametro();
		rangoEnteroMin.setActivo(true);
		rangoEnteroMin.setCodigo(Util.getCodigo(rangoEnteroMin));
		rangoEnteroMin.setDescripcion("rangoEnteroMin");
		rangoEnteroMin.setEstado(Constantes.ACTIVO);
		rangoEnteroMin.setFechaActualizacion(new Date());
		rangoEnteroMin.setFechaRegistro(new Date());
		rangoEnteroMin.setTipo(Constantes.RANGO_ENTERO_MININO);
		rangoEnteroMin.setValor("1");
		parametroDAO.guardar(rangoEnteroMin);

		Parametro rangoEnteroMax = new Parametro();
		rangoEnteroMax.setActivo(true);
		rangoEnteroMax.setCodigo(Util.getCodigo(rangoEnteroMax));
		rangoEnteroMax.setDescripcion("rangoEnteroMax");
		rangoEnteroMax.setEstado(Constantes.ACTIVO);
		rangoEnteroMax.setFechaActualizacion(new Date());
		rangoEnteroMax.setFechaRegistro(new Date());
		rangoEnteroMax.setTipo(Constantes.RANGO_ENTERO_MAXIMO);
		rangoEnteroMax.setValor("9");
		parametroDAO.guardar(rangoEnteroMax);
		
		Parametro valorEnteroMax = new Parametro();
		valorEnteroMax.setActivo(true);
		valorEnteroMax.setCodigo(Util.getCodigo(valorEnteroMax));
		valorEnteroMax.setDescripcion("valorEnteroMax");
		valorEnteroMax.setEstado(Constantes.ACTIVO);
		valorEnteroMax.setFechaActualizacion(new Date());
		valorEnteroMax.setFechaRegistro(new Date());
		valorEnteroMax.setTipo(Constantes.VALOR_ENTERO_MAXIMO);
		valorEnteroMax.setValor(String.valueOf(Integer.MAX_VALUE));
		parametroDAO.guardar(valorEnteroMax);

		Parametro valorEnteroMin = new Parametro();
		valorEnteroMin.setActivo(true);
		valorEnteroMin.setCodigo(Util.getCodigo(valorEnteroMin));
		valorEnteroMin.setDescripcion("valorEnteroMin");
		valorEnteroMin.setEstado(Constantes.ACTIVO);
		valorEnteroMin.setFechaActualizacion(new Date());
		valorEnteroMin.setFechaRegistro(new Date());
		valorEnteroMin.setTipo(Constantes.VALOR_ENTERO_MINIMO);
		valorEnteroMin.setValor(String.valueOf(Integer.MIN_VALUE));
		parametroDAO.guardar(valorEnteroMin);

		Parametro rangoDecimalMin = new Parametro();
		rangoDecimalMin.setActivo(true);
		rangoDecimalMin.setCodigo(Util.getCodigo(rangoDecimalMin));
		rangoDecimalMin.setDescripcion("rangoDecimalMin");
		rangoDecimalMin.setEstado(Constantes.ACTIVO);
		rangoDecimalMin.setFechaActualizacion(new Date());
		rangoDecimalMin.setFechaRegistro(new Date());
		rangoDecimalMin.setTipo(Constantes.RANGO_DECIMAL_MINIMO);
		rangoDecimalMin.setValor(String.valueOf(Integer.MIN_VALUE));
		parametroDAO.guardar(rangoDecimalMin);

		Parametro rangoDecimalMax = new Parametro();
		rangoDecimalMax.setActivo(true);
		rangoDecimalMax.setCodigo(Util.getCodigo(rangoDecimalMax));
		rangoDecimalMax.setDescripcion("rangoDecimalMax");
		rangoDecimalMax.setEstado(Constantes.ACTIVO);
		rangoDecimalMax.setFechaActualizacion(new Date());
		rangoDecimalMax.setFechaRegistro(new Date());
		rangoDecimalMax.setTipo(Constantes.RANGO_DECIMAL_MAXIMO);
		rangoDecimalMax.setValor("2");
		parametroDAO.guardar(rangoDecimalMax);
		

		Parametro valorDecimalMin = new Parametro();
		valorDecimalMin.setActivo(true);
		valorDecimalMin.setCodigo(Util.getCodigo(valorDecimalMin));
		valorDecimalMin.setDescripcion("valorDecimalMin");
		valorDecimalMin.setEstado(Constantes.ACTIVO);
		valorDecimalMin.setFechaActualizacion(new Date());
		valorDecimalMin.setFechaRegistro(new Date());
		valorDecimalMin.setTipo(Constantes.VALOR_DECIMAL_MINIMO);
		valorDecimalMin.setValor("1");
		parametroDAO.guardar(valorDecimalMin);
		

		Parametro valorDecimalMax = new Parametro();
		valorDecimalMax.setActivo(true);
		valorDecimalMax.setCodigo(Util.getCodigo(valorDecimalMax));
		valorDecimalMax.setDescripcion("valorDecimalMax");
		valorDecimalMax.setEstado(Constantes.ACTIVO);
		valorDecimalMax.setFechaActualizacion(new Date());
		valorDecimalMax.setFechaRegistro(new Date());
		valorDecimalMax.setTipo(Constantes.VALOR_DECIMAL_MAXIMO);
		valorDecimalMax.setValor("99");
		parametroDAO.guardar(valorDecimalMax);
		
		
		
		Parametro rangoCadenaMin = new Parametro();
		rangoCadenaMin.setActivo(true);
		rangoCadenaMin.setCodigo(Util.getCodigo(rangoCadenaMin));
		rangoCadenaMin.setDescripcion("rangoCadenaMin");
		rangoCadenaMin.setEstado(Constantes.ACTIVO);
		rangoCadenaMin.setFechaActualizacion(new Date());
		rangoCadenaMin.setFechaRegistro(new Date());
		rangoCadenaMin.setTipo(Constantes.RANGO_CADENA_MINIMO);
		rangoCadenaMin.setValor("4");
		parametroDAO.guardar(rangoCadenaMin);
		

		Parametro rangoCadenaMax = new Parametro();
		rangoCadenaMax.setActivo(true);
		rangoCadenaMax.setCodigo(Util.getCodigo(rangoCadenaMin));
		rangoCadenaMax.setDescripcion("rangoCadenaMax");
		rangoCadenaMax.setEstado(Constantes.ACTIVO);
		rangoCadenaMax.setFechaActualizacion(new Date());
		rangoCadenaMax.setFechaRegistro(new Date());
		rangoCadenaMax.setTipo(Constantes.RANGO_CADENA_MAXIMO);
		rangoCadenaMax.setValor("100");
		parametroDAO.guardar(rangoCadenaMax);
		
		
		
		
		Parametro valorSelectorMin = new Parametro();
		valorSelectorMin.setActivo(true);
		valorSelectorMin.setCodigo(Util.getCodigo(valorSelectorMin));
		valorSelectorMin.setDescripcion("valorSelectorMin");
		valorSelectorMin.setEstado(Constantes.ACTIVO);
		valorSelectorMin.setFechaActualizacion(new Date());
		valorSelectorMin.setFechaRegistro(new Date());
		valorSelectorMin.setTipo(Constantes.VALOR_SELECT_MINIMO);
		valorSelectorMin.setValor("1");
		parametroDAO.guardar(valorSelectorMin);
		

		Parametro cadenasRestringidas = new Parametro();
		cadenasRestringidas.setActivo(true);
		cadenasRestringidas.setCodigo(Util.getCodigo(cadenasRestringidas));
		cadenasRestringidas.setDescripcion("cadenasRestringidas");
		cadenasRestringidas.setEstado(Constantes.ACTIVO);
		cadenasRestringidas.setFechaActualizacion(new Date());
		cadenasRestringidas.setFechaRegistro(new Date());
		cadenasRestringidas.setTipo(Constantes.CADENAS_RESTRINGIDAS);	
		List<Parametro> parametros=new ArrayList<Parametro>();
		cadenasRestringidas.setParametros(parametros);
		parametroDAO.guardar(cadenasRestringidas);
		
		Parametro cadenaRestringida01 = new Parametro();
		cadenaRestringida01.setActivo(true);
		cadenaRestringida01.setValor("Usuario");
		cadenaRestringida01.setCodigo(Util.getCodigo(cadenaRestringida01));
		cadenaRestringida01.setDescripcion("cadenaRestringida01");
		cadenaRestringida01.setEstado(Constantes.ACTIVO);
		cadenaRestringida01.setFechaActualizacion(new Date());
		cadenaRestringida01.setFechaRegistro(new Date());
		cadenaRestringida01.setValor("Usuario");
		cadenaRestringida01.setTipo(cadenaRestringida01.getValor());
		cadenaRestringida01.setParametro(cadenasRestringidas);
		parametroDAO.guardar(cadenaRestringida01);
		parametros.add(cadenaRestringida01);
		
		Parametro cadenaRestringida02 = new Parametro();
		cadenaRestringida02.setActivo(true);
		cadenaRestringida02.setCodigo(Util.getCodigo(cadenaRestringida02));
		cadenaRestringida02.setDescripcion("cadenaRestringida02");
		cadenaRestringida02.setEstado(Constantes.ACTIVO);
		cadenaRestringida02.setFechaActualizacion(new Date());
		cadenaRestringida02.setFechaRegistro(new Date());
		cadenaRestringida02.setValor("Administrador");
		cadenaRestringida02.setTipo(cadenaRestringida02.getValor());
		cadenaRestringida02.setParametro(cadenasRestringidas);
		parametroDAO.guardar(cadenaRestringida02);
		parametros.add(cadenaRestringida02);
		
		parametroDAO.guardar(cadenasRestringidas);
		
		
		
		
		List<Parametro> parametros2=new ArrayList<Parametro>();		
		Parametro cadenasRestringidasSelector = new Parametro();
		cadenasRestringidasSelector.setActivo(true);
		cadenasRestringidasSelector.setCodigo(Util.getCodigo(cadenasRestringidasSelector));
		cadenasRestringidasSelector.setDescripcion("cadenasRestringidasSelector");
		cadenasRestringidasSelector.setEstado(Constantes.ACTIVO);
		cadenasRestringidasSelector.setFechaActualizacion(new Date());
		cadenasRestringidasSelector.setFechaRegistro(new Date());
		cadenasRestringidasSelector.setTipo(Constantes.CADENAS_RESTRINGIDAS_SELECTOR);
		cadenasRestringidasSelector.setParametros(parametros2);
		parametroDAO.guardar(cadenasRestringidasSelector);
		
		Parametro cadenasRestringidasSelector01 = new Parametro();
		cadenasRestringidasSelector01.setActivo(true);
		cadenasRestringidasSelector01.setCodigo(Util.getCodigo(cadenasRestringidasSelector01));
		cadenasRestringidasSelector01.setDescripcion("cadenaRestringida01");
		cadenasRestringidasSelector01.setEstado(Constantes.ACTIVO);
		cadenasRestringidasSelector01.setFechaActualizacion(new Date());
		cadenasRestringidasSelector01.setFechaRegistro(new Date());
		cadenasRestringidasSelector01.setValor("Seleccione");
		cadenasRestringidasSelector01.setTipo(cadenasRestringidasSelector01.getValor());
		cadenasRestringidasSelector01.setParametro(cadenasRestringidasSelector);
		parametroDAO.guardar(cadenasRestringidasSelector01);
		parametros2.add(cadenasRestringidasSelector01);
		
		Parametro cadenasRestringidasSelector02 = new Parametro();
		cadenasRestringidasSelector02.setActivo(true);
		cadenasRestringidasSelector02.setCodigo(Util.getCodigo(cadenasRestringidasSelector02));
		cadenasRestringidasSelector02.setDescripcion("cadenaRestringida02");
		cadenasRestringidasSelector02.setEstado(Constantes.ACTIVO);
		cadenasRestringidasSelector02.setFechaActualizacion(new Date());
		cadenasRestringidasSelector02.setFechaRegistro(new Date());
		cadenasRestringidasSelector02.setValor("Seleccion");
		cadenasRestringidasSelector02.setTipo(cadenasRestringidasSelector02.getValor());
		cadenasRestringidasSelector02.setParametro(cadenasRestringidasSelector);
		parametroDAO.guardar(cadenasRestringidasSelector02);
		parametros2.add(cadenasRestringidasSelector02);
		
		parametroDAO.guardar(cadenasRestringidasSelector02);
		
		Parametro formatoCampoClave = new Parametro();
		formatoCampoClave.setActivo(true);
		formatoCampoClave.setCodigo(Util.getCodigo(formatoCampoClave));
		formatoCampoClave.setDescripcion("formatoCampoClave");
		formatoCampoClave.setEstado(Constantes.ACTIVO);
		formatoCampoClave.setFechaActualizacion(new Date());
		formatoCampoClave.setFechaRegistro(new Date());
		formatoCampoClave.setTipo(Constantes.FORMATO_CAMPO);
		formatoCampoClave.setEntidad("usuario");
		formatoCampoClave.setCampo("clave");
		formatoCampoClave.setValor("(\\d)\\w{1,10}");
		parametroDAO.guardar(formatoCampoClave);
		
		
		
		
		return null;
	}

	
	/*

	public String[] getCadenasRestringidasSelector();

	  
	 * */
}
