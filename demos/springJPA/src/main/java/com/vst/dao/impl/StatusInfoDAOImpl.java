package com.vst.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.dao.StatusInfoDAO;
import com.vst.dominio.StatusInfo;
import com.vst.util.DAO;

@Repository("StatusInfoDAO")
public class StatusInfoDAOImpl extends DAO<StatusInfo> implements StatusInfoDAO{

}
