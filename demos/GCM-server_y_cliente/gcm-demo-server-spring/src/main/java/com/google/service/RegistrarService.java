package com.google.service;

import java.util.List;
import java.util.Map;

import com.google.bean.DispositivoMovil;
import com.google.bean.Usuario;

public interface RegistrarService {

	void guardarUsuairo(Usuario usuario);

	List<Usuario> obtenerTodos();

	void registrarUsuarioPorRegIDMovil(String regId);

	Usuario buscarUsuarioPorRegId(String regId);

	DispositivoMovil obtenerDispositivoMovilPorRegId(String regId);

	void guardarDispositivoMovil(DispositivoMovil d);

	DispositivoMovil obtenerDispositivoMovil();

	Usuario obtenerUsuarioPorID(int id);

	Usuario obtenerUsuarioPorIDDispositivoActual(int id);

	int registrarUsuarioDesdeDispositivoMovil(Usuario usuario, String numero, String regId);


	Map<String, Object> registrarDispositivoMovil(String regId, String numero,
			String email, int tipo_registro_mobile);

	Map<String, Object> existeDispositivo(String regId);


	

}
