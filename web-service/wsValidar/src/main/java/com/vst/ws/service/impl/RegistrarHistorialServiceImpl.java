package com.vst.ws.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.HistorialDAO;
import com.vst.dominio.Historial;
import com.vst.util.Util;
import com.vst.ws.service.RegistrarHistorialService;

@Service("RegistrarHistorialService")
public class RegistrarHistorialServiceImpl implements RegistrarHistorialService {

	private static Logger log=LoggerFactory.getLogger(RegistrarHistorialServiceImpl.class);
	
	@Autowired
	private HistorialDAO historialDAO;
	

	

}
