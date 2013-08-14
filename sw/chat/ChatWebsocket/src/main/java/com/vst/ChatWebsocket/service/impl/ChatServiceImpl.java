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
	public static List<Conexion> listaUsuarios=new ArrayList<Conexion>();
	
	static{
		listaUsuarios.add(new Conexion(1, "1ewfewffweff", new Usuario(1, "usuario01", "dsads", "dadsa1", "asdsad")));	
		listaUsuarios.add(new Conexion(2, "2ewfew", new Usuario(2, "usuario02", "dsads", "dadsa2", "asdsad")));	
		listaUsuarios.add(new Conexion(3, "3wregreg", new Usuario(3, "usuario03", "dsads", "dadsa3", "asdsad")));	
		listaUsuarios.add(new Conexion(4, "4ewfewfef", new Usuario(4, "usuario04", "dsads", "dadsa4", "asdsad")));	
		listaUsuarios.add(new Conexion(5, "5ewfergfweff", new Usuario(5, "usuario05", "dsads", "dadsa5", "asdsad")));	
		listaUsuarios.add(new Conexion(6, "6ewfegreweff", new Usuario(6, "usuario06", "dsads", "dadsa6", "asdsad")));	
	}

	@Override
	public List<Conexion> listaUsuariosConectados(Conexion conexion) {
		List<Conexion> l = new ArrayList<Conexion>();
		for ( Conexion c : listaUsuarios) {
			if(!(c.getUsuario().getUserName().equals(conexion.getUsuario().getUserName()))){
				l.add(c);
			}
		}
		return l;
	}

	@Override
	public void addConexion(Conexion conexion) {
		listaUsuarios.add(conexion);		
	}

	@Override
	public void quitConexion(Conexion conexion) {
		List<Conexion> l = new ArrayList<Conexion>();
		for ( Conexion c : listaUsuarios) {
			if((c.getUsuario().getUserName().equals(conexion.getUsuario().getUserName()))){
				l.remove(c);
			}
		}
	}

	@Override
	public void guardarMensaje(Chat conexion) {
		listaChats.add(conexion);		
	}

	@Override
	public int getId() {		
		return listaUsuarios.size()+1;
	}

	@Override
	public int getCId() {
		return listaChats.size() + 1 ;
	}

	@Override
	public Conexion obtenerConexionPorUsuario(String user) {
		for ( Conexion c : listaUsuarios) {
			if((c.getUsuario().getUserName().equals(user))){
				return c;
			}
		}
		return null;
	}	

}
