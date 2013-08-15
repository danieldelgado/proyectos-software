package com.vst.ChatWebsocket.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.ChatWebsocket.Entitys.Conexion;
import com.vst.ChatWebsocket.Entitys.MessageInfo;
import com.vst.ChatWebsocket.Entitys.StatusInfo;
import com.vst.ChatWebsocket.Entitys.Usuario;
import com.vst.ChatWebsocket.dao.ConexionDAO;
import com.vst.ChatWebsocket.dao.MessageInfoDAO;
import com.vst.ChatWebsocket.dao.StatusInfoDAO;
import com.vst.ChatWebsocket.dao.UsuarioDAO;
import com.vst.ChatWebsocket.service.ChatService;

@Service("ChatService")
public class ChatServiceImpl implements ChatService {

	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private ConexionDAO conexionDAO;

	@Autowired
	private StatusInfoDAO statusInfoDAO; 

	@Autowired
	private MessageInfoDAO messageInfoDAO; 
	
	
	@Override
	public List<Usuario> listaUsuarios() {
		return usuarioDAO.getTodos();
	}

	@Override
	@Transactional
	public void guardarUsuario(Usuario usuario) {
		logger.info("Guardando nuevo usuario");
		Usuario u = usuarioDAO.buscarUsuario(usuario);
//		if(u==null){
			logger.info("No esta en base de datos, se guardara. ");
			System.out.println("usuario:"+usuario.getId());
			usuarioDAO.guardar(usuario);
			System.out.println("usuario:"+usuario.getId());
//		}else{
//			logger.info("Existe Usuario en base de datos")	;		
//		}		
	}

	@Override
	public boolean existeUsuario(String usuario) {
		logger.info("existeUsuario");
		Usuario u = usuarioDAO.buscarUsuario(usuario);
		if(u!=null){
			return true;
		}
		return false;
	}

	@Override
	public Usuario getUsuario(String usuario) {
		logger.info("existeUsuario");
		Usuario u = usuarioDAO.buscarUsuario(usuario);
		if(u!=null){
			return u;
		}
		return null;
	}

	@Override
	@Transactional
	public void guardarMessageInfo(MessageInfo messageInfo) {
		logger.info("guardarMessageInfo");
		messageInfoDAO.guardar(messageInfo);
	}

	@Override
	@Transactional
	public void guardarStatusInfo(StatusInfo statusInfo) {
		logger.info("guardarStatusInfo");
		statusInfoDAO.guardar(statusInfo);
	}

	@Override
	@Transactional
	public void guardarConexion(Conexion c) {
		logger.info("guardarConexion");
		conexionDAO.guardar(c);
		
	}

}
