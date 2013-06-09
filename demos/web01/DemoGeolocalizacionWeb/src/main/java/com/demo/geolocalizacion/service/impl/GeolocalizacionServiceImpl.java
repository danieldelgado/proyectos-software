package com.demo.geolocalizacion.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.geolocalizacion.dao.GeolocalizacionDAO;
import com.demo.geolocalizacion.dao.PuntoGeolocalizacionDAO;
import com.demo.geolocalizacion.dao.TelefonoDAO;
import com.demo.geolocalizacion.dominio.Geolocalizacion;
import com.demo.geolocalizacion.dominio.PuntoGeolocalizacion;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.service.GeolocalizacionService;
import com.demo.geolocalizacion.util.Constantes;
import com.demo.geolocalizacion.util.CustomLog;

@Service("GeolocalizacionService")
public class GeolocalizacionServiceImpl implements GeolocalizacionService {

	private static final Logger logger = CustomLog
			.getLogger(GeolocalizacionServiceImpl.class);

//	@Autowired
//	private PrincipalService usuarioService;

	@Autowired
	private TelefonoDAO telefonoDAO;

	@Autowired
	private GeolocalizacionDAO geolocalizacionDAO;
	
	@Autowired
	private PuntoGeolocalizacionDAO puntoGeolocalizacionDAO;

	@Override	
	@Transactional
	public int registrarPuntoGeolocalizacion(boolean flag , String numero, String latitud,
			String longitud) {
		Telefono telefono = telefonoDAO.existeTelefonoRegistrado(numero);
		if (telefono != null) {
			try {
				double lat = Double.parseDouble(latitud);
				double log = Double.parseDouble(longitud);				
				if( lat<0 && log<0 ){
					logger.info(" El numero  ingresado existe: "+ numero + " latitud : "+latitud + " longitud : "+longitud);
					
					Geolocalizacion geolocalizacionExiste = null;
					if(flag){
						geolocalizacionExiste = new Geolocalizacion();
						geolocalizacionExiste.setFechaRegistro(new Date());
						geolocalizacionExiste.setTelefono(telefono);						
						geolocalizacionDAO.guardar(geolocalizacionExiste);			
					}else{
						geolocalizacionExiste = geolocalizacionDAO.obtenerGeolocalizacionPorTelefono(telefono);
					}
										
					PuntoGeolocalizacion p = new PuntoGeolocalizacion();
					p.setFechaRegistro(new Date());
					p.setGeolocalizacion(geolocalizacionExiste);
					p.setLatitud(latitud);
					p.setFlagPuntoInicial(flag);
					p.setLongitud(longitud);
					puntoGeolocalizacionDAO.guardar(p);	
					logger.info(" Punto de geolocalizacion a sido registrado " );
					return Constantes.REGISTRADO;
				}			
			} catch (Exception e) {
				logger.info(" El formato de latitud y logitud son incorrectos [" + e.getLocalizedMessage() + "]");
				e.printStackTrace();	
				return Constantes.NO_CUMPLE_CON_FORMATO;			
			}
		}else{
			logger.info(" El numero  ingresado  no existe: "+ numero );			
		}
		return Constantes.USUARIO_NO_EXISTE;
	}

	@Override
	public Telefono obtenerTelefono(String numero) {	
		return telefonoDAO.existeTelefonoRegistrado(numero);
	}

	@Override
	public List<Geolocalizacion> obtenerListaGeolocalizacionPorTelefono(
			Telefono telefono) {	
		return geolocalizacionDAO.obtenerLstGeolocalizacionPorTelefono(telefono);
	}

	@Override
	public List<PuntoGeolocalizacion> obtenerPuntosGeolocalizacion(Integer id) {
		
		return puntoGeolocalizacionDAO.obtenerPuntosGeolocalizacion(id);
	}
	
	
}
