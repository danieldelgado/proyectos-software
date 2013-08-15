package com.vst.ChatWebsocket.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.ChatWebsocket.Entitys.MessageInfo;
import com.vst.ChatWebsocket.dao.MessageInfoDAO;
import com.vst.ChatWebsocket.util.DAO;

@Repository("MessageInfoDAO")
public class MessageInfoDAOImpl extends DAO<MessageInfo> implements MessageInfoDAO {

}
