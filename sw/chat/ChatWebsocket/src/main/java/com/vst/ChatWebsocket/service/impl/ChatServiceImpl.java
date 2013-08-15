package com.vst.ChatWebsocket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vst.ChatWebsocket.messages.Conexion;
import com.vst.ChatWebsocket.messages.ConnectionInfo;
import com.vst.ChatWebsocket.messages.MessageInfo;
import com.vst.ChatWebsocket.messages.StatusInfo;
import com.vst.ChatWebsocket.messages.Usuario;
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

//	@Override
//	public List<Usuario> listaUsuariosConectados() {
//		Conexion c = null;
//		List<Usuario> usuList = new ArrayList<Usuario>();
//		for (Usuario usuario : listaUsuarios) {
//			if (usuario.getListaConexionsid() != null && usuario.getListaConexionsid().size() > 0) {
//				c = usuario.getListaConexionsid().get(usuario.getListaConexionsid().size() - 1);
//				if (c != null) {
//					usuList.add(usuario);
//				}
//			}
//		}
//		c = null;
//		if (usuList.size() > 0) {
//			return usuList;
//		}
//		usuList = null;
//		return null;
//	}

	@Override
	public void guardarConexion(Conexion c) {
		
		
	}

	// public static void main(String[] args) {
	// ChatServiceImpl chatServiceImpl = new ChatServiceImpl();
	// System.out.println(chatServiceImpl.listaUsuarios().size());
	// Usuario u1 = new Usuario(chatServiceImpl.getLastID(),
	// "chat"+chatServiceImpl.getLastID(), "chat", "chat", "chat");
	// chatServiceImpl.guardar(u1);
	// Usuario u2 = new Usuario(chatServiceImpl.getLastID(),
	// "chat"+chatServiceImpl.getLastID(), "chat", "chat", "chat");
	// chatServiceImpl.guardar(u2);
	// Usuario u3 = new Usuario(chatServiceImpl.getLastID(),
	// "chat"+chatServiceImpl.getLastID(), "chat", "chat", "chat");
	// chatServiceImpl.guardar(u3);
	// Usuario u4 = new Usuario(chatServiceImpl.getLastID(),
	// "chat"+chatServiceImpl.getLastID(), "chat", "chat", "chat");
	// chatServiceImpl.guardar(u4);
	// Usuario u5 = new Usuario(chatServiceImpl.getLastID(),
	// "chat"+chatServiceImpl.getLastID(), "chat", "chat", "chat");
	// chatServiceImpl.guardar(u5);
	// Usuario u6 = chatServiceImpl.getUsuario("chat01");
	// System.out.println("existe chat01:"+chatServiceImpl.existeUsuario("chat01"));
	// System.out.println("existe chat012:"+chatServiceImpl.existeUsuario("chat012"));
	// System.out.println(chatServiceImpl.listaUsuarios().size());
	// Conexion conexion01 = chatServiceImpl.addUsuarioConectado("asdas",
	// "asdsadfsdf", u1);
	// System.out.println(conexion01);
	// Conexion conexion02 = chatServiceImpl.addUsuarioConectado("asda1s",
	// "asdsadfsd31f", u2);
	// System.out.println(conexion02);
	// Conexion conexion03 = chatServiceImpl.addUsuarioConectado("asdas23",
	// "asdsadfsdf432", u3);
	// System.out.println(conexion03);
	// Conexion conexion04 = chatServiceImpl.addUsuarioConectado("asdas24",
	// "asdsadfsdf43442", u4);
	// System.out.println(conexion04);
	// Conexion conexion05 = chatServiceImpl.addUsuarioConectado("asdas5564",
	// "asdsadfsdf6666", u5);
	// System.out.println(conexion05);
	// Conexion conexion06 = chatServiceImpl.addUsuarioConectado("asdas66664",
	// "asdsadfsdf6666", u6);
	// System.out.println(conexion06);
	// System.out.println(chatServiceImpl.listaConectados(u1).size());
	// System.out.println(chatServiceImpl.listaConectados(u2).size());
	// System.out.println(chatServiceImpl.listaConectados(u3).size());
	// System.out.println("esta conectado :"+chatServiceImpl.estaUsuarioConectado(u3.getUserName()));
	// chatServiceImpl.removeUsuarioConectado(u3);
	// System.out.println(chatServiceImpl.listaConectados(u2).size());
	// System.out.println(chatServiceImpl.listaConectados(u3));
	// System.out.println("mensaje eviado "+chatServiceImpl.addMensaje(conexion01,
	// u2, u1, "hola!!"));
	// }

}
