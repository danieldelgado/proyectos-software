package com.vst.ChatWebsocket.service;

import java.util.List;

import com.vst.ChatWebsocket.bean.Chat;
import com.vst.ChatWebsocket.bean.Conexion;

public interface ChatService {

	public List<Conexion> listaUsuariosConectados(Conexion conexion);

	public void addConexion(Conexion conexion);

	public void quitConexion(Conexion conexion);

	public void guardarMensaje(Chat conexion);

	public Conexion obtenerConexionPorUsuario(String user);
	
	public int getId();
	
	public int getCId();
	
}
