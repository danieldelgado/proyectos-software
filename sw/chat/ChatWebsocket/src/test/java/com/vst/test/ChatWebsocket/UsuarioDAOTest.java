package com.vst.test.ChatWebsocket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dasdtemp.Usuario;
import dasdtemp.UsuarioDAO;




//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath*:WEB-INF/spring/appServlet/servlet-context.xml","classpath*:/WEB-INF/spring/root-context.xml"})
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-test-context.xml"})
public class UsuarioDAOTest{
//
//	@Autowired
//	UsuarioDAO usuarioDAO;
//	
//    @Test()
//    public void testAdd() {
//    	System.out.println("cantidad:"+usuarioDAO.getTodos().size());
//    	usuarioDAO.guardar(new Usuario( "chat1213", "chat", "chat", "chat"));
//    	System.out.println("cantidad:"+usuarioDAO.getTodos().size());
//    	usuarioDAO.guardar(new Usuario( "chat2342", "chat", "chat", "chat"));
//    	System.out.println("cantidad:"+usuarioDAO.getTodos().size());
//    	usuarioDAO.guardar(new Usuario( "chat323432", "chat", "chat", "chat"));
//    	System.out.println("cantidad:"+usuarioDAO.getTodos().size());
//    }

}