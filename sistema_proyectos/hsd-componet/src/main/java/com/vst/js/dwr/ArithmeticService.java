package com.vst.js.dwr;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("springService")
@RemoteProxy(name = "dwrService")
@Transactional
public class ArithmeticService {

	protected static Logger logger = Logger.getLogger("service");

	@RemoteMethod
	public Integer add(Integer operand1, Integer operand2) {
		logger.debug("Adding two numbers");

		return operand1 + operand2;
	}

}