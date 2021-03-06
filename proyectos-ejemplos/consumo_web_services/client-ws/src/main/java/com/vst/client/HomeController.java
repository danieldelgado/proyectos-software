package com.vst.client;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.ws.HelloWorldServiceProxy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		try {
			
			HelloWorldServiceProxy proxy = new HelloWorldServiceProxy();
			System.out.println(proxy.sayHello(" sriveeee"));
			
		} catch (Exception e) {
			
			
			
		}
		
		
		return "home";
	}
	
}
