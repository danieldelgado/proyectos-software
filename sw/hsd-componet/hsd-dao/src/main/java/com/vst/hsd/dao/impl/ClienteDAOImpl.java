package com.vst.hsd.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ClienteDAO;
import com.vst.hsd.dominio.Cliente;
import com.vst.util.persistence.impl.DAO;

/**
 * The Class ClienteDAOImpl.
 */
@Repository("ClienteDAO")
public class ClienteDAOImpl extends DAO<Cliente> implements ClienteDAO {

}
