package com.vst.service.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vst.dominio.Conexion;
import com.vst.dominio.MessageInfo;
import com.vst.dominio.StatusInfo;
import com.vst.dominio.Usuario;
import com.vst.service.ChatService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context-test.xml"})
public class ChatServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatServiceTest.class);

	@Autowired
	private ChatService chatService;

	private Usuario usuarioinsert = null;
	private Usuario usuarioinsert_fail = null;
	private MessageInfo messageInfo = null;
	private Usuario usuarioinsert_mensaje = null;
	private MessageInfo messageInfo_fail = null;
	private StatusInfo statusInfo = null;
	private StatusInfo statusInfo_fail = null;
	private Conexion conexion = null;
	private Conexion conexion_fail = null;
	
	
	
	@Before
	public void initTest() {
		logger.info("initTest");
		usuarioinsert = new Usuario("usuaerioTest1", "1234", "test", "test");
		usuarioinsert_fail = new Usuario();
		usuarioinsert_mensaje  = new Usuario("usuaerioTest", "1234", "test", "test");		
		
		messageInfo = new MessageInfo(usuarioinsert, usuarioinsert_mensaje, "mensaje prueba");
		messageInfo_fail = new MessageInfo(usuarioinsert, usuarioinsert_fail, "mensaje prueba");
		messageInfo_fail = new MessageInfo(usuarioinsert, usuarioinsert_fail, null );
		
		
	}
	
	@Test
	public void testexisteUsuario() {
		logger.info("testexisteUsuario");
		Assert.assertTrue(chatService.existeUsuario(usuarioinsert.getUserName()));
	}
	

	@Test
	public void testexisteUsuario_fail() {
		logger.info("testexisteUsuario_fail");
		Assert.assertFalse(chatService.existeUsuario("alguientest"));
	}

	@Test
	public void testgetUsuario() {
		logger.info("testgetUsuario");		
		Assert.assertNotNull(chatService.getUsuario(usuarioinsert.getUserName()));
	}

	@Test
	public void testgetUsuario_fail() {
		logger.info("testgetUsuario_fail");	
		Assert.assertNull(chatService.getUsuario(usuarioinsert_fail.getUserName()));			
	}

	@Test
	public void testlistaUsuarios() {
		logger.info("testlistaUsuarios");
				
	}
	@Test
	public void testlistaUsuarios_fail() {
		logger.info("testlistaUsuarios_fail");
				
	}
	
	@Test
	public void testguardarUsuario() {
		logger.info("testguardarUsuario");
		chatService.guardarUsuario(usuarioinsert);
		Assert.assertNotNull(usuarioinsert.getId());
	}


	@Test
	public void testguardarUsuario_fail() {
		logger.info("testguardarUsuario_fail");
		chatService.guardarUsuario(usuarioinsert_fail);
		Assert.assertNull(usuarioinsert.getId());	
				
	}

//	messageInfo = new MessageInfo(usuarioinsert, usuarioinsert_mensaje, "mensaje prueba");
//	messageInfo_fail = new MessageInfo(usuarioinsert, usuarioinsert_fail, "mensaje prueba");
//	messageInfo_fail = new MessageInfo(usuarioinsert, usuarioinsert_fail, null );
	@Test
	public void testguardarMessageInfo() {
		logger.info("testguardarMessageInfo");
		chatService.guardarMessageInfo(messageInfo);
		Assert.assertNotNull(messageInfo.getId());		
	}


	@Test
	public void testguardarMessageInfo_fail() {
		logger.info("testguardarMessageInfo_fail");
		chatService.guardarMessageInfo(messageInfo_fail);
		Assert.assertNotNull(messageInfo_fail.getId());	
				
	}


	@Test
	public void testguardarStatusInfo() {
		logger.info("testguardarStatusInfo");
				
	}


	@Test
	public void testguardarStatusInfo_fail() {
		logger.info("testguardarStatusInfo_fail");
				
	}

	@Test
	public void testguardarConexion() {
		logger.info("testguardarConexion");
				
	}
	
	@Test
	public void testguardarConexion_fail() {
		logger.info("testguardarConexion_fail");
				
	}
	
	
	@After
	public void finishTest() {
		logger.info("finishTest");
				
	}
	
	
	
	
}
