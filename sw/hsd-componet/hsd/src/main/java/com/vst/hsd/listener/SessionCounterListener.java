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

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving sessionCounter events. The class that is
 * interested in processing a sessionCounter event implements this interface,
 * and the object created with that class is registered with a component using
 * the component's <code>addSessionCounterListener<code> method. When
 * the sessionCounter event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see SessionCounterEvent
 */
public class SessionCounterListener implements HttpSessionListener {

	/** The total active sessions. */
	private static int totalActiveSessions;

	/** The milisegundos inicio. */
	public long milisegundosInicio;

	/** The milisegundos fin. */
	public long milisegundosFin;

	/**
	 * Gets the total active session.
	 * 
	 * @return the total active session
	 */
	public static int getTotalActiveSession() {
		return totalActiveSessions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("----------------------------------------");
		totalActiveSessions++;
		System.out.println("sessionCreated - add one session into counter");
		Calendar c = Calendar.getInstance();
		System.out.println("c:" + c.getTime());
		milisegundosInicio = c.getTimeInMillis();
		System.out.println("milisegundosInicio:" + milisegundosInicio);
		printCounter(arg0);
		System.out.println("----------------------------------------");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("----------------------------------------");
		totalActiveSessions--;
		System.out.println("sessionDestroyed - deduct one session from counter");
		Calendar c = Calendar.getInstance();
		System.out.println("c:" + c.getTime());
		milisegundosFin = c.getTimeInMillis();
		printCounter(arg0);
		System.out.println("milisegundosInicio:" + milisegundosInicio);
		System.out.println("milisegundosFin:" + milisegundosFin);
		long result = milisegundosFin - milisegundosInicio;
		System.out.println("result:" + result);
		System.out.println("result/1000:" + (result / 1000));
		System.out.println("----------------------------------------");

	}

	/**
	 * Prints the counter.
	 * 
	 * @param sessionEvent
	 *            the session event
	 */
	@SuppressWarnings("unused")
	private void printCounter(HttpSessionEvent sessionEvent) {

		HttpSession session = sessionEvent.getSession();

		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());

		Usuario usuarioSession = (Usuario) session.getAttribute(Constantes.SESION_USUARIO);
		System.out.println("usuarioSession:");
		System.out.println(Util.getJson(usuarioSession));
		/*
		 * CounterService counterService = (CounterService)
		 * ctx.getBean("counterService");
		 * 
		 * counterService.printCounter(totalActiveSessions);
		 */
	}
}