package com.vst.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.dao.MessageInfoDAO;
import com.vst.dominio.MessageInfo;
import com.vst.util.DAO;

@Repository("MessageInfoDAO")
public class MessageInfoDAOImpl extends DAO<MessageInfo> implements MessageInfoDAO {

}
