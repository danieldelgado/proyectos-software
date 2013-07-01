package com.vst.hsd.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationListenerBean.
 */
public class ApplicationListenerBean implements ApplicationListener<ContextRefreshedEvent> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationListener#onApplicationEvent(org
	 * .springframework.context.ApplicationEvent)
	 */
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
			System.out.println("onApplicationEvent");
		}

	}

}
