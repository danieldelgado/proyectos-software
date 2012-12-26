package com.vst.hsd.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ClienteDAO;
import com.vst.hsd.dominio.Cliente;
import com.vst.util.DAO;

@Repository("ClienteDAO")
public class ClienteDAOImpl extends DAO<Cliente> implements ClienteDAO {


}
