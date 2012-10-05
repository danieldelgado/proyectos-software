package com.vst.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vst.controller.pruebaController;

//@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config-test.xml"})  
public class main {

	public static void main(String[] args) {
		try {

			String[] paths = { "classpath:/WEB-INF/spring/root-context.xml","classpath:/WEB-INF/spring/appServlet/servlet-context.xml" };
			ApplicationContext context = new ClassPathXmlApplicationContext(paths);
				
			System.out.println(context);
			System.out.println(context.getBeanDefinitionCount());
			System.out.println(context.getBeanDefinitionNames());
			System.out.println(context.getBeanDefinitionNames().length);
			for (int i = 0; i < context.getBeanDefinitionNames().length; i++) {
				String name = context.getBeanDefinitionNames()[i];
				System.out.println(name);				
			}
			
			pruebaController p = (pruebaController) context.getBean("pruebaController");
			System.out.println(p.prueba("algooo para ingresa2r"));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}