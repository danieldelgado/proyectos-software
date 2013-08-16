package com.vst.dao.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context-test.xml"})
public class UsuarioDAOTest{
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOTest.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	private Usuario usuarioinsert = null;
	private Usuario usuarioinsert_fail = null;
	
	private Usuario usuariobuscar = null;
	private Usuario usuariobuscar_fail = null;
	

	@Before
	public void initTest() {
		logger.info("initTest");
		usuarioinsert=new Usuario("das", "1234", "User", "Name");	
		usuarioinsert_fail=new Usuario();
		usuariobuscar=new Usuario("das", "1234", "User", "Name");	
		usuariobuscar_fail=new Usuario("alkguiqdwq", "qwd", "qwdwd", "qwdwqdw");	
	}
	
    @Test()
    @Transactional
    public void testguardarUsuairo() {
    	logger.info("testguardarUsuairo");
    	logger.info("cantidad de usuarios : "+usuarioDAO.getTodos().size());
    	usuarioDAO.guardar(usuarioinsert);
    	Assert.assertNotNull(usuarioinsert.getId());    	
    }
    
    @Test()
    @Transactional
    public void testguardarUsuairo_fail() {
    	logger.info("testguardarUsuairo_fail");
    	logger.info("cantidad de usuarios : "+usuarioDAO.getTodos().size());
    	usuarioDAO.guardar(usuarioinsert_fail);
    	Assert.assertNotNull(usuarioinsert_fail.getId());    	
    }
 

    @Test()
    public void testbuscarUsuario() {
    	logger.info("testbuscarUsuario");
    	Assert.assertNotNull(usuarioDAO.buscarUsuario(usuariobuscar));    	
    }
    
    @Test()
    public void testbuscarUsuario_fail() {
    	logger.info("buscarUsuario_fail");
    	Assert.assertNotNull(usuarioDAO.buscarUsuario(usuariobuscar_fail));    	
    }

    @Test()
    public void testbuscarUserName() {
    	logger.info("testbuscarUserName");
    	Assert.assertNotNull(usuarioDAO.buscarUsuario(usuariobuscar.getUserName()));    	
    }
    
    @Test()
    public void testbuscarUserName_fail() {
    	logger.info("testbuscarUserName_fail");
    	Assert.assertNotNull(usuarioDAO.buscarUsuario(usuariobuscar_fail.getUserName()));    	
    }
        
    @Test()
    public void testcantidadUsuario() {
    	logger.info("testcantidadUsuario");
    	Assert.assertNotNull(usuarioDAO.getTodos().size());    	
    }    
    
    @After
    public void testfinishTest() {
    	logger.info("finishTest");
    	logger.info("cantidad de usuarios : "+usuarioDAO.getTodos().size());
	}
    

}