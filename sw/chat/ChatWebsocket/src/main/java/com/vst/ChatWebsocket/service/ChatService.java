package com.vst.ChatWebsocket.service;

import java.util.List;

import com.vst.ChatWebsocket.bean.Chat;
import com.vst.ChatWebsocket.bean.Conexion;
import com.vst.ChatWebsocket.bean.Usuario;

public interface ChatService {

	public boolean existeUsuario(String usuario);
	public Usuario getUsuario(String usuario);
	public List<Usuario> listaUsuariosConectados();//todos conectados al chat
	public void addUsuarioConectado(String connectionId, String origin, Usuario usuario);
	public void removeUsuarioConectado(Usuario usuario);
	public List<Usuario> listaConectados(Usuario usuario);//todos conectados al chat menos yo
	public List<Usuario> listaUsuarios(); ////todos los registrados
	public void guardar(Usuario usuario);
	public int getLastID();
	public int getLastID2();
	public void addMensaje( Conexion conexion, Usuario usuariofrom, Usuario to, String mensaje);
	
	
}
