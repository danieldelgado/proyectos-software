package com.vst.hsd.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListenerBean implements ApplicationListener<ContextRefreshedEvent> {

	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
            System.out.println("onApplicationEvent");
        }
		
	}

   
	
}
