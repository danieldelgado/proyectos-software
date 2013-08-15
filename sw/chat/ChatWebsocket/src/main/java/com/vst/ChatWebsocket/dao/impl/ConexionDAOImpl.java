package com.vst.ChatWebsocket.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.ChatWebsocket.Entitys.Conexion;
import com.vst.ChatWebsocket.dao.ConexionDAO;
import com.vst.ChatWebsocket.util.DAO;

@Repository("ConexionDAO")
public class ConexionDAOImpl extends DAO<Conexion> implements ConexionDAO {

}
