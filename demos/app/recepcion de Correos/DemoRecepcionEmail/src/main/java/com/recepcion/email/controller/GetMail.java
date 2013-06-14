package com.recepcion.email.controller;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;


// freelance 
// https://www.freelancer.com.pe/projects/Java-Linux/Java-Spring-MVC-email-indexing.html#
/*
Descripción del proyecto:
I am looking for a Java J2EE Spring MVC expert to develop a web-application for me.

Basic flow of the application:
Emails received in the inbox of a specific email id have to be grabbed and stored into the database.
This stored email content has to be displayed using the Spring MVC web-application.
Habilidades requeridas:
J2EE, Java, Linux, MySQL 


 * */

// gmail hotmail yahoo por su host
// el getStore imaps

// todas las cadenas desded imaps tienen que ser parametros de configuracion 
// getfolder en que carpeta sera filtrado en este caso es correcto q sea INBOX ya que es lo que se pide
// y bueno en los parametros el correo que se desea filtrar
// en el caso de correos empresariales hay q investigar un poco. por ejemplo de infonet.
 public class GetMail {

	public static void main(String args[]) throws MessagingException {

		Properties prop = new Properties();

//		prop.setProperty("mail.pop3.starttls.enable", "false");
//		prop.setProperty("mail.pop3.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//		prop.setProperty("mail.pop3.socketFactory.fallback", "false");
//		prop.setProperty("mail.pop3.port", "995");
//		prop.setProperty("mail.pop3.socketFactory.port", "995");
//		Store tienda = session.getStore("pop3");
//		tienda.connect("mail.infonet-consulting.com", "ajimenez@infonet-consulting.com", "ajimenez");
		
		Session session = Session.getInstance(prop);		
		Store tienda = session.getStore("pop3");
		tienda.connect("pop3.live.com", "anisella@outlook.com", "");
		Folder folder = tienda.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);

		Message mensaje[] = folder.getMessages();
		for (int i = mensaje.length - 1; i >= 0; i--) {
//			System.out.println(i + ":" + mensaje[i].getFrom()[0] + " = " + mensaje[i].getSubject());
			
			
			
			if(String.valueOf(mensaje[i].getFrom()[0]).indexOf("danieldelgado20g@gmail.com")>0){
				
				System.err.println(" salioo filtrado ");
				
			}
			
			
		}

		folder.close(false);
		tienda.close();

	}
}
