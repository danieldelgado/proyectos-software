package com.vst.ws.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.util.Constantes;
import com.vst.util.Util;
import com.vst.ws.service.MantenimientoParametroService;

@Service("MantenimientoParametroService")
public class MantenimientoParametroServiceImpl implements MantenimientoParametroService {

	@Autowired
	private ParametroDAO parametroDAO;
	
	public String registrarParametrosIniciales() {
		
		System.out.println("Constantes.ACTIVO:"+Constantes.ACTIVO);
		Parametro cantidadDecimales = new Parametro();
		cantidadDecimales.setActivo(true);
		cantidadDecimales.setCodigo(Util.getCodigo(cantidadDecimales));
		cantidadDecimales.setDescripcion("cantidadDecimales");
		cantidadDecimales.setEstado(Constantes.ACTIVO);
		cantidadDecimales.setFechaActualizacion(new Date());
		cantidadDecimales.setFechaRegistro(new Date());
		cantidadDecimales.setNombre("Cantidad Decimales");
		cantidadDecimales.setTipo_parametro("numero");
		cantidadDecimales.setValorString("2");
		parametroDAO.guardar(cantidadDecimales);
		
		Parametro rangoEnteroMin = new Parametro();
		rangoEnteroMin.setActivo(true);
		rangoEnteroMin.setCodigo(Util.getCodigo(rangoEnteroMin));
		rangoEnteroMin.setDescripcion("rangoEnteroMin");
		rangoEnteroMin.setEstado(Constantes.ACTIVO);
		rangoEnteroMin.setFechaActualizacion(new Date());
		rangoEnteroMin.setFechaRegistro(new Date());
		rangoEnteroMin.setNombre("Rango Entero Minimo");
		rangoEnteroMin.setTipo_parametro("numero");
		rangoEnteroMin.setValorString("1");
		parametroDAO.guardar(rangoEnteroMin);

		Parametro rangoEnteroMax = new Parametro();
		rangoEnteroMax.setActivo(true);
		rangoEnteroMax.setCodigo(Util.getCodigo(rangoEnteroMax));
		rangoEnteroMax.setDescripcion("rangoEnteroMax");
		rangoEnteroMax.setEstado(Constantes.ACTIVO);
		rangoEnteroMax.setFechaActualizacion(new Date());
		rangoEnteroMax.setFechaRegistro(new Date());
		rangoEnteroMax.setNombre("Rango Entero Max");
		rangoEnteroMax.setTipo_parametro("numero");
		rangoEnteroMax.setValorString("9");
		parametroDAO.guardar(rangoEnteroMax);
		
		Parametro valorEnteroMax = new Parametro();
		valorEnteroMax.setActivo(true);
		valorEnteroMax.setCodigo(Util.getCodigo(valorEnteroMax));
		valorEnteroMax.setDescripcion("valorEnteroMax");
		valorEnteroMax.setEstado(Constantes.ACTIVO);
		valorEnteroMax.setFechaActualizacion(new Date());
		valorEnteroMax.setFechaRegistro(new Date());
		valorEnteroMax.setNombre("valor Entero Max");
		valorEnteroMax.setTipo_parametro("numero");
		valorEnteroMax.setValorString("999999999");
		parametroDAO.guardar(valorEnteroMax);

		Parametro valorEnteroMin = new Parametro();
		valorEnteroMin.setActivo(true);
		valorEnteroMin.setCodigo(Util.getCodigo(valorEnteroMin));
		valorEnteroMin.setDescripcion("valorEnteroMin");
		valorEnteroMin.setEstado(Constantes.ACTIVO);
		valorEnteroMin.setFechaActualizacion(new Date());
		valorEnteroMin.setFechaRegistro(new Date());
		valorEnteroMin.setNombre("valor Entero Min");
		valorEnteroMin.setTipo_parametro("numero");
		valorEnteroMin.setValorString("1");
		parametroDAO.guardar(valorEnteroMin);

		Parametro rangoDecimalMin = new Parametro();
		rangoDecimalMin.setActivo(true);
		rangoDecimalMin.setCodigo(Util.getCodigo(rangoDecimalMin));
		rangoDecimalMin.setDescripcion("rangoDecimalMin");
		rangoDecimalMin.setEstado(Constantes.ACTIVO);
		rangoDecimalMin.setFechaActualizacion(new Date());
		rangoDecimalMin.setFechaRegistro(new Date());
		rangoDecimalMin.setNombre("rango Decimal Min");
		rangoDecimalMin.setTipo_parametro("numero");
		rangoDecimalMin.setValorString("1");
		parametroDAO.guardar(rangoDecimalMin);

		Parametro rangoDecimalMax = new Parametro();
		rangoDecimalMax.setActivo(true);
		rangoDecimalMax.setCodigo(Util.getCodigo(rangoDecimalMax));
		rangoDecimalMax.setDescripcion("rangoDecimalMax");
		rangoDecimalMax.setEstado(Constantes.ACTIVO);
		rangoDecimalMax.setFechaActualizacion(new Date());
		rangoDecimalMax.setFechaRegistro(new Date());
		rangoDecimalMax.setNombre("rango Decimal Max");
		rangoDecimalMax.setTipo_parametro("numero");
		rangoDecimalMax.setValorString("2");
		parametroDAO.guardar(rangoDecimalMax);
		

		Parametro valorDecimalMin = new Parametro();
		valorDecimalMin.setActivo(true);
		valorDecimalMin.setCodigo(Util.getCodigo(valorDecimalMin));
		valorDecimalMin.setDescripcion("valorDecimalMin");
		valorDecimalMin.setEstado(Constantes.ACTIVO);
		valorDecimalMin.setFechaActualizacion(new Date());
		valorDecimalMin.setFechaRegistro(new Date());
		valorDecimalMin.setNombre("valor Decimal Min");
		valorDecimalMin.setTipo_parametro("numero");
		valorDecimalMin.setValorString("1");
		parametroDAO.guardar(valorDecimalMin);
		

		Parametro valorDecimalMax = new Parametro();
		valorDecimalMax.setActivo(true);
		valorDecimalMax.setCodigo(Util.getCodigo(valorDecimalMax));
		valorDecimalMax.setDescripcion("valorDecimalMax");
		valorDecimalMax.setEstado(Constantes.ACTIVO);
		valorDecimalMax.setFechaActualizacion(new Date());
		valorDecimalMax.setFechaRegistro(new Date());
		valorDecimalMax.setNombre("valor Decimal Max");
		valorDecimalMax.setTipo_parametro("numero");
		valorDecimalMax.setValorString("99");
		parametroDAO.guardar(valorDecimalMax);
		
		
		
		Parametro rangoCadenaMin = new Parametro();
		rangoCadenaMin.setActivo(true);
		rangoCadenaMin.setCodigo(Util.getCodigo(rangoCadenaMin));
		rangoCadenaMin.setDescripcion("rangoCadenaMin");
		rangoCadenaMin.setEstado(Constantes.ACTIVO);
		rangoCadenaMin.setFechaActualizacion(new Date());
		rangoCadenaMin.setFechaRegistro(new Date());
		rangoCadenaMin.setNombre("rango Cadena Min");
		rangoCadenaMin.setTipo_parametro("cadena");
		rangoCadenaMin.setValorString("4");
		parametroDAO.guardar(rangoCadenaMin);
		

		Parametro valorSelectorMin = new Parametro();
		valorSelectorMin.setActivo(true);
		valorSelectorMin.setCodigo(Util.getCodigo(valorSelectorMin));
		valorSelectorMin.setDescripcion("valorSelectorMin");
		valorSelectorMin.setEstado(Constantes.ACTIVO);
		valorSelectorMin.setFechaActualizacion(new Date());
		valorSelectorMin.setFechaRegistro(new Date());
		valorSelectorMin.setNombre(" valor Selector Min ");
		valorSelectorMin.setTipo_parametro("numero");
		valorSelectorMin.setValorString("1");
		parametroDAO.guardar(valorSelectorMin);
		

		List<Parametro> parametros=new ArrayList<Parametro>();
		Parametro cadenaRestringida01 = new Parametro();
		cadenaRestringida01.setActivo(true);
		cadenaRestringida01.setCodigo(Util.getCodigo(cadenaRestringida01));
		cadenaRestringida01.setDescripcion("cadenaRestringida01");
		cadenaRestringida01.setEstado(Constantes.ACTIVO);
		cadenaRestringida01.setFechaActualizacion(new Date());
		cadenaRestringida01.setFechaRegistro(new Date());
		cadenaRestringida01.setNombre(" cadena Restringida 01 ");
		cadenaRestringida01.setTipo_parametro("cadena");
		cadenaRestringida01.setValorString("Usuario");
		parametroDAO.guardar(cadenaRestringida01);
		parametros.add(cadenaRestringida01);
		
		Parametro cadenaRestringida02 = new Parametro();
		cadenaRestringida02.setActivo(true);
		cadenaRestringida02.setCodigo(Util.getCodigo(cadenaRestringida02));
		cadenaRestringida02.setDescripcion("cadenaRestringida02");
		cadenaRestringida02.setEstado(Constantes.ACTIVO);
		cadenaRestringida02.setFechaActualizacion(new Date());
		cadenaRestringida02.setFechaRegistro(new Date());
		cadenaRestringida02.setNombre(" cadena Restringida 02 ");
		cadenaRestringida02.setTipo_parametro("cadena");
		cadenaRestringida02.setValorString("Administrador");
		parametroDAO.guardar(cadenaRestringida02);
		parametros.add(cadenaRestringida02);
		

		Parametro cadenasRestringidas = new Parametro();
		cadenasRestringidas.setActivo(true);
		cadenasRestringidas.setCodigo(Util.getCodigo(cadenasRestringidas));
		cadenasRestringidas.setDescripcion("cadenasRestringidas");
		cadenasRestringidas.setEstado(Constantes.ACTIVO);
		cadenasRestringidas.setFechaActualizacion(new Date());
		cadenasRestringidas.setFechaRegistro(new Date());
		cadenasRestringidas.setNombre(" cadenas Restringidas ");
		cadenasRestringidas.setTipo_parametro("arreglo");		
		cadenasRestringidas.setParametros(parametros);
		parametroDAO.guardar(cadenasRestringidas);
		
		
		
		
		return null;
	}

	
	/*

	public String[] getCadenasRestringidasSelector();

	  
	 * */
}
