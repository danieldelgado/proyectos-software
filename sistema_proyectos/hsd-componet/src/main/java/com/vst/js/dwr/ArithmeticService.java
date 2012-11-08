package com.vst.js.dwr;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("springService")
@RemoteProxy(name = "dwrService")
@Transactional
public class ArithmeticService {

	private static Logger log=LoggerFactory.getLogger(ArithmeticService.class);

	@RemoteMethod
	public Integer add(Integer operand1, Integer operand2) {
		log.debug("Adding two numbers");

		return operand1 + operand2;
	}

}