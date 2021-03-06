package com.vst.deocecu.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.deocecu.dominio.Documento;
import com.vst.deocecu.dominio.Proyecto;
import com.vst.deocecu.dominio.Seccion_Documento;
import com.vst.deocecu.service.DocumentadorService;
import com.vst.deocecu.util.Util;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	static String htmlEditor = "";

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DocumentadorService documentadorService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		List<Proyecto> listarProyectos = documentadorService.obtenerListaProyectos();
		model.addAttribute("listarProyectos", listarProyectos);
		documentadorService.guardarContenidoHTMLALFRESCO("");
		return "home";
	}
	@RequestMapping(value = "/nuevoProyecto", method = RequestMethod.GET)
	public String nuevoProyecto( Model model) {	
		return "nuevoProyecto";
	}
	
	@RequestMapping(value = "/guardarProyecto", method = RequestMethod.POST)
	public String guardarProyecto(Model model, Proyecto proyecto) {
		int r = documentadorService.guardarNuevoProyecto(proyecto);		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/Proyecto/{folder}/{id}", method = RequestMethod.GET)
	public String Proyecto(@PathVariable String folder,@PathVariable Integer id , Model model) {	
		Proyecto p = documentadorService.obtenerProyectoPorID(id);
		p.setSeccion_Documentos(documentadorService.obtenerSeccionesDocumentos(p));
		model.addAttribute("proyecto", p);		
		return "listaDocumentos";
	}
		
	@RequestMapping(value = "/Proyecto/{folder}/{id}/nuevaSeccion", method = RequestMethod.GET)
	public String nuevaSeccion(@PathVariable String folder,@PathVariable Integer id , Model model) {
		Proyecto p = documentadorService.obtenerProyectoPorID(id);
		model.addAttribute("proyecto", p);			
		return "nuevaSeccion";
	}
	
	@RequestMapping(value = "/Proyecto/{folder}/{id_proyecto}/guardarSeccion", method = RequestMethod.POST)
	public String guardarSeccion(@PathVariable String folder,@PathVariable Integer id_proyecto , Model model, Seccion_Documento seccion_Documento) {
		int r = documentadorService.guardarSeccionProyecto( id_proyecto, seccion_Documento);
		return "redirect:/Proyecto/"+folder+"/"+id_proyecto;
	}
	
	
	
	@RequestMapping(value = "/Proyecto/{folder}/{proyecto_id}/nuevaSubSeccionDocumento/{sdid}", method = RequestMethod.GET)
	public String nuevaSubSeccionDocumento(@PathVariable String folder,@PathVariable Integer proyecto_id,@PathVariable Integer sdid, Model model) {
		Proyecto p = documentadorService.obtenerProyectoPorID(proyecto_id);
		Seccion_Documento sd = documentadorService.obtenerSeccionProyectoPorId(sdid);
		model.addAttribute("seccionDocumento", sd);
		model.addAttribute("proyecto", p);
		return "nuevaSubSeccionDocumento";
	}
	
	@RequestMapping(value = "/Proyecto/{folder}/{proyecto_id}/guardarSubSeccionDocumento/{sdid}", method = RequestMethod.POST)
	public String guardarSubSeccionDocumento(@PathVariable String folder,@PathVariable Integer proyecto_id,@PathVariable Integer sdid, Model model, Seccion_Documento seccion_Documento) {
		Seccion_Documento sd = documentadorService.obtenerSeccionProyectoPorId(sdid);
		seccion_Documento.setSeccion_padre(sd);
		int r = documentadorService.guardarSeccionProyecto( proyecto_id, seccion_Documento);		
		return "redirect:/Proyecto/"+folder+"/"+proyecto_id;
	}
	
	@RequestMapping(value = "/Proyecto/{folder}/{proyecto_id}/VerListaContenidos/{sdid}", method = RequestMethod.GET)
	public String VerListaContenidos(@PathVariable String folder,@PathVariable Integer proyecto_id,@PathVariable Integer sdid, Model model) {
		Proyecto p = documentadorService.obtenerProyectoPorID(proyecto_id);
		Seccion_Documento sd = documentadorService.obtenerSeccionProyectoPorId(sdid);
		sd.setLstdocumentos(documentadorService.obtenerDocumentosPorSeccion(sd));
		model.addAttribute("seccionDocumento", sd);
		model.addAttribute("proyecto", p);		
		return "VerListaContenidos";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/Proyecto/{folder}/{proyecto_id}/crearContenido/{sdid}", method = RequestMethod.GET)
	public String crearContenido(@PathVariable String folder,@PathVariable Integer proyecto_id,@PathVariable Integer sdid, Model model) {
		Proyecto p = documentadorService.obtenerProyectoPorID(proyecto_id);
		Seccion_Documento sd = documentadorService.obtenerSeccionProyectoPorId(sdid);
		model.addAttribute("seccionDocumento", sd);
		model.addAttribute("proyecto", p);
		return "agregarContenidoSeccionDocumento";
	}
	
	
	
	@RequestMapping(value = "/Proyecto/{folder}/{proyecto_id}/guardarContenido/{sdid}", method = RequestMethod.POST)
	public String guardarContenido(@PathVariable String folder,@PathVariable Integer proyecto_id,@PathVariable Integer sdid, Model model, Documento documento) {
		Proyecto p = documentadorService.obtenerProyectoPorID(proyecto_id);
		Seccion_Documento sd = documentadorService.obtenerSeccionProyectoPorId(sdid);
		documento.setSeccion_documento(sd);
		int r = documentadorService.guardarContenidoEnDocumentoAlfresco(p,sd,documento);
		
		return "redirect:/Proyecto/"+folder+"/"+proyecto_id;
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/222", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		System.out.println("documentadorService:"+documentadorService.guardarContenidoHTMLALFRESCO(""));
		
		
		return "home";
	}

	@RequestMapping(value = "/guardarContenido", method = RequestMethod.POST)
	public String guardarContenido(String editor, Model model) {
		htmlEditor = editor;
		logger.info("guardarContenido: " + editor);
		model.addAttribute("editor", editor);
		return "verContenido";
	}

	@RequestMapping(value = "/export")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		long c = Calendar.getInstance().getTime().getTime();
		try {
			byte[] b = Util.convertirHTMLaPDFbytes(htmlEditor);
			if (b != null) {
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition","attachment;filename=newFile" + c + ".pdf");
				response.getOutputStream().write(b);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
