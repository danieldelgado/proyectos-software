package com.vst.ChatWebsocket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vst.ChatWebsocket.Entitys.Conexion;
import com.vst.ChatWebsocket.Entitys.MessageInfo;
import com.vst.ChatWebsocket.Entitys.StatusInfo;
import com.vst.ChatWebsocket.Entitys.Usuario;
import com.vst.ChatWebsocket.messages.ConnectionInfo;
import com.vst.ChatWebsocket.service.ChatService;

@Service("ChatService")
public class ChatServiceImpl implements ChatService {
	public static List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	static {
		Usuario usuario = null;
		usuario = new Usuario(1, "chat01", "chat01", "chat01", "chat01");
		listaUsuarios.add(usuario);
		usuario = new Usuario(2, "chat02", "chat02", "chat02", "chat02");
		listaUsuarios.add(usuario);
		usuario = new Usuario(3, "chat03", "chat03", "chat03", "chat03");
		listaUsuarios.add(usuario);
		usuario = new Usuario(4, "chat04", "chat04", "chat04", "chat04");
		listaUsuarios.add(usuario);
		usuario = null;
	}

	@Override
	public List<Usuario> listaUsuarios() {
		return listaUsuarios;
	}

	//
	@Override
	public void guardarUsuario(Usuario usuario) {
		for (Usuario u : listaUsuarios) {
			if (u.getUserName().equals(usuario.getUserName())) {
				return;
			}
		}
		listaUsuarios.add(usuario);
	}

	@Override
	public boolean existeUsuario(String usuario) {
		for (Usuario u : listaUsuarios) {
			if (u.getUserName().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Usuario getUsuario(String usuario) {
		for (Usuario u : listaUsuarios) {
			if (u.getUserName().equals(usuario)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void guardarMessageInfo(MessageInfo messageInfo) {
		System.out.println(" guardarMessageInfo " + messageInfo);
	}

	@Override
	public void guardarStatusInfo(StatusInfo statusInfo) {
		System.out.println(" guardarStatusInfo " + statusInfo);
	}

	@Override
	public void guardarConnectionInfo(ConnectionInfo connectionInfo) {
		System.out.println(" guardarConnectionInfo " + connectionInfo);
	}

	@Override
	public void guardarConexion(Conexion c) {
		
		
	}

}
