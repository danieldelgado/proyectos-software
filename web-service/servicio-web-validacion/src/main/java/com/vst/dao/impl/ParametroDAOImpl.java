package com.vst.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.util.Constantes;
import com.vst.util.DAO;
import com.vst.util.Util;
import com.vst.ws.service.impl.RegistrarHistorialServiceImpl;

@Repository("ParametroDAO")
public class ParametroDAOImpl extends DAO<Parametro> implements ParametroDAO {
	private static Logger log = LoggerFactory.getLogger(ParametroDAOImpl.class);

	
}
