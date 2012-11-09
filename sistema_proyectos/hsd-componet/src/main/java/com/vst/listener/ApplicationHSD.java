package com.vst.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import com.vst.util.Config;

public class ApplicationHSD implements ServletContextListener	{

	public Boolean consolemessage=false;
	public static long applicationInitialized =	0L;

	public void	contextInitialized(ServletContextEvent ce) {
		applicationInitialized = System.currentTimeMillis();
		consolemessage=Boolean.valueOf(Config.getPropiedad("applicacion.context,console.log.js"));
		System.out.println("contextInitialized");
		ServletContext c = ce.getServletContext();
		System.out.println(consolemessage);
		c.setAttribute("consolemessage", consolemessage);		
	}

	public void	contextDestroyed(ServletContextEvent ce) {
		System.out.println("contextDestroyed");
		ServletContext c = ce.getServletContext();
		System.out.println(consolemessage);
		consolemessage = (Boolean) c.getAttribute("consolemessage");
		System.out.println(consolemessage);	
		
	}
	
}