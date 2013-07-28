package com.autentia.tutorial.dao;

import org.springframework.stereotype.Repository;

import com.autentia.tutorial.beans.DAO;
import com.autentia.tutorial.beans.Usuario;

@Repository("UsuarioDAO")
public class UsuarioDAOImpl extends DAO<Usuario> implements UsuarioDAO {
	
	

}
