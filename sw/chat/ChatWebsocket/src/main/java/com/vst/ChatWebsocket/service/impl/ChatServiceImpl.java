package com.vst.ChatWebsocket.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.vst.ChatWebsocket.bean.Chat;
import com.vst.ChatWebsocket.bean.Conexion;
import com.vst.ChatWebsocket.bean.Usuario;
import com.vst.ChatWebsocket.service.ChatService;

@Service("ChatService")
public class ChatServiceImpl implements ChatService {

	public static List<Chat> listaChats=new ArrayList<Chat>();
	public static List<Conexion> listaConexiones = new ArrayList<Conexion>();
	public static List<Usuario> listaUsuarios=new ArrayList<Usuario>();
	
	static{
		Usuario	usuario = null;
		usuario=new Usuario(1, "chat01", "chat01", "chat01", "chat01");
		listaUsuarios.add(usuario);
		usuario=new Usuario(2, "chat02", "chat02", "chat02", "chat02");
		listaUsuarios.add(usuario);
		usuario=new Usuario(3, "chat03", "chat03", "chat03", "chat03");
		listaUsuarios.add(usuario);
		usuario=new Usuario(4, "chat04", "chat04", "chat04", "chat04");
		listaUsuarios.add(usuario);
		usuario = null;		
	}

	@Override
	public List<Usuario> listaUsuariosConectados() {
		List<Usuario> l = new ArrayList<Usuario>();
		for (Conexion conexion : listaConexiones) {
			l.add(conexion.getUsuario());
		}		
		return l;
	}

	@Override
	public void addUsuarioConectado(String connectionId, String origin, Usuario usuario) {
		listaConexiones.add(new Conexion(connectionId, origin , usuario));		
	}

	@Override
	public void removeUsuarioConectado(Usuario usuario) {
		for (Conexion conexion : listaConexiones) {
			if(conexion.getUsuario().getId() == usuario.getId()){
				listaConexiones.remove(conexion);
			}
		}			
	}

	@Override
	public List<Usuario> listaConectados(Usuario usuario) {
		List<Usuario> l = new ArrayList<Usuario>();
		for ( Conexion c : listaConexiones) {
			if(!(c.getUsuario().getUserName().equals(usuario.getUserName()))){
				l.add(c.getUsuario());
			}
		}
		return l;
	}

	@Override
	public List<Usuario> listaUsuarios() {
		return listaUsuarios;
	}

	@Override
	public void guardar(Usuario usuario) {
		listaUsuarios.add(usuario);				
	}

	@Override
	public int getLastID() {
		return listaUsuarios.size()+1;
	}

	@Override
	public void addMensaje(Conexion conexion, Usuario usuariofrom, Usuario to,
			String mensaje) {
		Chat chat = new Chat(getLastID2(), conexion, usuariofrom, to, mensaje);
		listaChats.add(chat);		
	}

	@Override
	public int getLastID2() {
		return listaChats.size()+1;
	}

	@Override
	public boolean existeUsuario(String usuario) {
		for (Usuario u : listaUsuarios) {
			if(u.getUserName().equals(usuario)){
				return true;
			}
		}	
		return false;
	}

	@Override
	public Usuario getUsuario(String usuario) {
		for (Usuario u : listaUsuarios) {
			if(u.getUserName().equals(usuario)){
				return u;
			}
		}	
		return null;
	}

}
