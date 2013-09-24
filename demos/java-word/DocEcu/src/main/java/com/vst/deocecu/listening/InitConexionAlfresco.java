package com.vst.deocecu.listening;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vst.deocecu.service.DocumentadorService;

/**
 * Application Lifecycle Listener implementation class InitConexionAlfresco
 *
 */
public class InitConexionAlfresco implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(InitConexionAlfresco.class);
    
	@Autowired
	private DocumentadorService documentadorService;
	
    public InitConexionAlfresco() {
    	logger.info("InitConexionAlfresco:");
    }

	
    public void contextInitialized(ServletContextEvent sce) {
    	logger.info("contextInitialized");
    	documentadorService.guardarContenidoHTMLALFRESCO("");
    }

	
    public void contextDestroyed(ServletContextEvent sce) {
    	logger.info("contextDestroyed");    	
    }
	
}
