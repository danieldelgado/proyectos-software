package com.vst.ChatWebsocket.service;

import java.util.List;

import com.vst.ChatWebsocket.Entitys.Conexion;
import com.vst.ChatWebsocket.Entitys.MessageInfo;
import com.vst.ChatWebsocket.Entitys.StatusInfo;
import com.vst.ChatWebsocket.Entitys.Usuario;

public interface ChatService {

	public boolean existeUsuario(String usuario);

	public Usuario getUsuario(String usuario);

	public List<Usuario> listaUsuarios(); 

	public void guardarUsuario(Usuario usuario);
	
	public void guardarMessageInfo(MessageInfo messageInfo);

	public void guardarStatusInfo(StatusInfo statusInfo);

	public void guardarConexion(Conexion c);

}
