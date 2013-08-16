package com.vst.service;

import java.util.List;

import com.vst.dominio.Conexion;
import com.vst.dominio.MessageInfo;
import com.vst.dominio.StatusInfo;
import com.vst.dominio.Usuario;


public interface ChatService {

	public boolean existeUsuario(String usuario);

	public Usuario getUsuario(String usuario);

	public List<Usuario> listaUsuarios(); 

	public void guardarUsuario(Usuario usuario);
	
	public void guardarMessageInfo(MessageInfo messageInfo);

	public void guardarStatusInfo(StatusInfo statusInfo);

	public void guardarConexion(Conexion c);

}
