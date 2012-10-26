package com.vst.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mail{

	private Logger log=LoggerFactory.getLogger(Mail.class);

	private String server;

	private String port;

	private InternetAddress from;

	private String asunto;

	private List<InternetAddress> destinatarios;

	private List<InternetAddress> copias;

	private String contenido;

	private String tipoContenido;

	private List<String> adjuntos;

	public Mail(){
		server=Config.getPropiedad("mail.host");
		port=Config.getPropiedad("mail.port");
		try{
			from=new InternetAddress(Config.getPropiedad("mail.user"));
		}
		catch(AddressException e){
			from=null;
		}
		tipoContenido="text/html; charset=UTF-8";
		destinatarios=new ArrayList<InternetAddress>();
		copias=new ArrayList<InternetAddress>();
		adjuntos=new ArrayList<String>();
	}

	public void setAsunto(String asunto){
		this.asunto=asunto;
	}

	public void agregarDestinatario(String correo){
		try{
			InternetAddress ia=new InternetAddress(correo);
			destinatarios.add(ia);
		}
		catch(AddressException e){
		}
	}

	public void agregarCopia(String correo){
		try{
			InternetAddress ia=new InternetAddress(correo);
			copias.add(ia);
		}
		catch(AddressException e){
		}
	}

	public void agregarAdjunto(String archivo){
		adjuntos.add(archivo);
	}

	public void setContenido(String contenido){
		this.contenido=contenido;
	}

	public boolean enviarCorreo(){
		if(from != null && destinatarios.size() > 0){
			Properties p=new Properties();
			p.put("mail.smtp.host",server);
			//p.put("mail.smtp.port",port);
			//p.put("mail.smtp.starttls.enable","true");
			p.put("mail.smtps.auth",Config.getPropiedad("mail.auth"));
			Session sesion=Session.getInstance(p);
			sesion.setDebug(Config.getPropiedadBoolean("mail.debug"));
			MimeMessage msg=new MimeMessage(sesion);
			try{
				
				msg.setFrom(from);
				for(InternetAddress ia : destinatarios){
					msg.addRecipient(Message.RecipientType.TO,ia);
				}
				for(InternetAddress ia : copias){
					msg.addRecipient(Message.RecipientType.CC,ia);
				}
				Multipart mp=new MimeMultipart();
				MimeBodyPart texto=new MimeBodyPart();
				texto.setContent(contenido,tipoContenido);
				mp.addBodyPart(texto);
				for(String adjunto : adjuntos){
					FileDataSource fds=new FileDataSource(adjunto);
					MimeBodyPart archivo=new MimeBodyPart();
					archivo.setDataHandler(new DataHandler(fds));
					archivo.setFileName(fds.getName());
					mp.addBodyPart(archivo);
				}
				msg.setContent(mp);
				msg.setSubject(asunto);
				msg.saveChanges();
				Transport t=sesion.getTransport("smtps");
				t.connect(server,Config.getPropiedad("mail.user"),Config.getPropiedad("mail.pass"));
				t.sendMessage(msg,msg.getAllRecipients());
				t.close();
			}
			catch(MessagingException e){
				log.error("Error enviando correo",e);
				return false;
			}
			return true;
		}
		return false;
	}

	/*private class SMTPAuthenticator extends Authenticator{
		public PasswordAuthentication getPasswordAuthentication(){
			String username=Config.getPropiedad("mail.user");
			String password=Config.getPropiedad("mail.pass");
			return new PasswordAuthentication(username,password);
		}
	}*/

}