package com.vst.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.dao.ClienteDAO;
import com.vst.dominio.Cliente;
import com.vst.util.DAO;

@Repository("ClienteDAO")
public class ClienteDAOImpl extends DAO<Cliente> implements ClienteDAO {


}
