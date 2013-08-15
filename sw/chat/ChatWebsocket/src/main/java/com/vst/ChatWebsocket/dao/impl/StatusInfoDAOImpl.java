package com.vst.ChatWebsocket.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.ChatWebsocket.Entitys.StatusInfo;
import com.vst.ChatWebsocket.dao.StatusInfoDAO;
import com.vst.ChatWebsocket.util.DAO;

@Repository("StatusInfoDAO")
public class StatusInfoDAOImpl extends DAO<StatusInfo> implements StatusInfoDAO{

}
