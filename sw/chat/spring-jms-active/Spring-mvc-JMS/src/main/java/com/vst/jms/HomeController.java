package com.vst.jms;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
	
	public static List<LinkedHashMap<String, Object>> dbListaProductos = new ArrayList<LinkedHashMap<String,Object>>();
	
	static{
		LinkedHashMap<String, Object> bd = null;
		for (int i = 1; i < 16; i++) {
			bd = new LinkedHashMap<String, Object>();
			bd.put("id", i);
			bd.put("nombre", "productoNumerico - "+i);
			bd.put("precio", new Random(i).nextDouble());
			bd.put("fechaRegistro", new Date());
			dbListaProductos.add(bd);
			bd = null;
		}
	}
	
	
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
		System.out.println(" dbListaProductos : " + dbListaProductos);
		return "home";
	}

	@RequestMapping(value = "{otroLugar}", method = RequestMethod.GET)
	public  String otroLugar(@PathVariable String otroLugar,Model model) {
		model.addAttribute("lstBD", dbListaProductos);
		return otroLugar;
	}
	
	
	@RequestMapping(value = "guardarProducto", method = RequestMethod.POST)
	public  String guardarProducto( String nombre , String precio , String fechaRegistro , Model model) {
		LinkedHashMap<String, Object> bd = new LinkedHashMap<String, Object>();
		int id = dbListaProductos.size()+1;
		bd.put("id", id );
		bd.put("nombre", nombre+" - "+id);
		bd.put("precio", precio );
		bd.put("fechaRegistro", fechaRegistro );
		dbListaProductos.add(bd);
		bd = null;		
		return "agregarProducto";
	}
	
	
	
}
