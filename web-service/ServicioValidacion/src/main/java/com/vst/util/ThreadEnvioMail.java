package com.vst.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadEnvioMail implements Runnable{
	
	private Logger log=LoggerFactory.getLogger(ThreadEnvioMail.class);

	private String[] destinatarios;

	private String titulo;

	private String contenido;

	public ThreadEnvioMail(String[] destinatarios,String titulo,String contenido){
		//ApplicationContext obj=WebApplicationContextUtils.getWebApplicationContext(contexto);
		//servicioMail=obj.getBean(ServicioMail.class);
		this.destinatarios=destinatarios;
		this.titulo=titulo;
		this.contenido=contenido;
	}

	public void run(){
		//servicioMail.sendMail(destinatarios,titulo,contenido);
		Mail mail=new Mail();
		String destinos="";
		for(String destinatario : destinatarios){
			mail.agregarDestinatario(destinatario);
			destinos+=" "+destinatario+",";
		}
		log.debug("Enviando notificacion por correo a "+destinos);
		mail.setAsunto(titulo);
		mail.setContenido(contenido);
		if(mail.enviarCorreo()){
			log.info("Notificaciones por correo enviadas a "+destinos);
		}
		else{
			log.warn("No se pudo enviar el correo");
		}
	}

}
