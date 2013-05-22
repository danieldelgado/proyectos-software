package com.demo.geolocalizacion.service;

import java.util.Map;

import com.demo.geolocalizacion.dominio.Telefono;

public interface PrincipalService {

	int validarUsuarioPorNumeroRegistrado(String numero);

	 Map<String, Object> registrarUsuario_Telefono(Telefono telefono);

}
