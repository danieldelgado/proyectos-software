package com.vst.ChatWebsocket;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.ChatWebsocket.Entitys.Usuario;
import com.vst.ChatWebsocket.service.ChatService;
import com.vst.ChatWebsocket.util.Constantes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ChatService chatService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/iniciarSession", method = RequestMethod.POST)
	public String iniciarSession(Locale locale, Model model,HttpSession session,String usuario,String calve) {		
		if(chatService.existeUsuario(usuario)){
			Usuario u = chatService.getUsuario(usuario);
			session.setAttribute(Constantes.USUARIO_SESSION, u);
			model.addAttribute(Constantes.USUARIO_SESSION, u);
			return "index";
		}else{
			return "redirect:/";
		}
	}

	@RequestMapping(value = "{otroLugar}", method = RequestMethod.GET)
	public String otroLugar(@PathVariable String otroLugar) {
		return otroLugar;
	}

}
