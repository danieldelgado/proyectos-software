package com.vst.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.dao.ConexionDAO;
import com.vst.dominio.Conexion;
import com.vst.util.DAO;

@Repository("ConexionDAO")
public class ConexionDAOImpl extends DAO<Conexion> implements ConexionDAO {

}
