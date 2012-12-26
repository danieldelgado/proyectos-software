package com.vst.hsd.listener;
import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vst.hsd.dominio.Usuario;
import com.vst.util.Constantes;
import com.vst.util.Util;
 
public class SessionCounterListener implements HttpSessionListener {
 
     private static int totalActiveSessions;
     public long milisegundosInicio;
     public long milisegundosFin;
     
     
     public static int getTotalActiveSession(){
           return totalActiveSessions;
     }
 
    public void sessionCreated(HttpSessionEvent arg0) {
    	System.out.println("----------------------------------------");
           totalActiveSessions++;
           System.out.println("sessionCreated - add one session into counter");	
           Calendar c= Calendar.getInstance();
           System.out.println("c:"+c.getTime());
           milisegundosInicio=c.getTimeInMillis();
           System.out.println("milisegundosInicio:"+milisegundosInicio);
           printCounter(arg0);
       	System.out.println("----------------------------------------");
    }
 
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	System.out.println("----------------------------------------");
           totalActiveSessions--;
           System.out.println("sessionDestroyed - deduct one session from counter");	
           Calendar c= Calendar.getInstance();
           System.out.println("c:"+c.getTime());
           milisegundosFin=c.getTimeInMillis();
           printCounter(arg0);
           System.out.println("milisegundosInicio:"+milisegundosInicio);
           System.out.println("milisegundosFin:"+milisegundosFin);
           long result = milisegundosFin - milisegundosInicio;
           System.out.println("result:"+result);
           System.out.println("result/1000:"+(result/1000));
       	System.out.println("----------------------------------------");
           
    }	
 
    private void printCounter(HttpSessionEvent sessionEvent){
 
          HttpSession session = sessionEvent.getSession();
 
          ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
          
          Usuario usuarioSession = (Usuario)session.getAttribute(Constantes.SESION_USUARIO);
          System.out.println("usuarioSession:");
          System.out.println(Util.getJson(usuarioSession));
          /*
          CounterService counterService = 
                      (CounterService) ctx.getBean("counterService");
 
          counterService.printCounter(totalActiveSessions);*/
    }
}