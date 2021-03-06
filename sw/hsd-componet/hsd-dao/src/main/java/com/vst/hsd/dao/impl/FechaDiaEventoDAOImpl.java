package com.vst.hsd.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.FechaDiaEventoDAO;
import com.vst.hsd.dominio.FechaDiaEvento;
import com.vst.util.persistence.impl.DAO;

@Repository("FechaDiaEventoDAO")
public class FechaDiaEventoDAOImpl extends DAO<FechaDiaEvento> implements FechaDiaEventoDAO {

}
