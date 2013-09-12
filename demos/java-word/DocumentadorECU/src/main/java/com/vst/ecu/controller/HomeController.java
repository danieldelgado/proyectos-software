package com.vst.ecu.controller;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/{otropagina}", method = RequestMethod.GET)
	public String otropagina( @PathVariable  String otropagina, Locale locale, Model model) {
		logger.info("otropagina:"+otropagina);			
		return otropagina;
	}
	
	@RequestMapping(value = "/guardarContenido", method = RequestMethod.POST)
	public String guardarContenido( String editor,Model model ) {
//		editor = "<html><boby>"+ editor +  "</boby></html>";
		logger.info("guardarContenido: "+ editor);	
		String rft = HTML2RTFUtil.toRtf2( editor );
		System.out.println("rft");
		System.out.println(rft);
		System.out.println("-----------------------------------------------");
		String rft1 = HTML2RTFUtil.toRtf( editor );
		System.out.println("rft1");
		System.out.println(rft1);
		String prueba = test.convertHTMLtoRFT(editor);
		System.out.println("prueba");
		System.out.println(prueba);
		System.out.println("-----------------------------------------------");
		try {
			String rfttohtml = HTML2RTFUtil.rtfToHtml2(new StringReader(prueba));
			System.out.println("rfttohtml");
			System.out.println(rfttohtml);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String html = HTML2RTFUtil.toHtml(rft);
//		System.out.println(html);
		

		model.addAttribute("editor", editor);
		
		return "verContenido";
	}
	
}
