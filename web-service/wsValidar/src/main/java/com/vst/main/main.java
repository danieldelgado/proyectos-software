package com.vst.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config-test.xml"})  
public class main {

	public static void main(String[] args) {
		try {

			String[] paths = { "classpath:/WEB-INF/spring/root-context.xml","classpath:/WEB-INF/spring/appServlet/servlet-context.xml" };
			ApplicationContext context = new ClassPathXmlApplicationContext(paths);
				
			for (int i = 0; i < context.getBeanDefinitionNames().length; i++) {
				String name = context.getBeanDefinitionNames()[i];
				System.out.println(name);				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}