package com.vst.spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.vst.service.ChatService;



public class InstanstBeans {

	private static final Logger log = LoggerFactory.getLogger(InstanstBeans.class);
	private static final ApplicationContext ctx = SpringContextUtil.getContext();
	private static ChatService chatService;

	private InstanstBeans() {
	}

	public static InstanstBeans newInstante() {
		chatService = (ChatService) ctx.getBean(ChatService.class.getSimpleName());
		log.info("instance ApplicationContext ");
		return new InstanstBeans();
	}

	public static ChatService getChatService() {
		return chatService;
	}

}
