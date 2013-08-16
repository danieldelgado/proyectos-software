package com.vst.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TiempoUtil {
	
	public static boolean isFechaValida(Date fecha) {
		return fecha != null;
	}
	
	public static Date agregarDiaMesAno(Date fecha, short dias, short meses, short anos){
		return agregarDiaMesAno(fecha, new Integer(dias), new Integer(meses), new Integer(anos));
	}
	
	public static Date agregarDiaMesAno(Date fecha, Integer dias, Integer meses, Integer anos){
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		if(EnteroUtil.isPositivo(dias)) calendario.add(Calendar.DAY_OF_MONTH, dias);
		if(EnteroUtil.isPositivo(meses)) calendario.add(Calendar.MONTH, meses);
		if(EnteroUtil.isPositivo(anos)) calendario.add(Calendar.YEAR, anos);
		return calendario.getTime();
	}
	
	public static Timestamp enTimestamp(Date fecha) {
		if (fecha != null) return new Timestamp(fecha.getTime());
		return null;
	}
	
	public static Integer getAnoActual() {
		return (new GregorianCalendar()).get(Calendar.YEAR);
	}
	
	public static Integer getMesActual() {
		return (new GregorianCalendar()).get(Calendar.MONTH) + 1;
	}
	
	public static Integer getDiaActual() {
		return (new GregorianCalendar()).get(Calendar.DAY_OF_MONTH);
	}
	
	public static String getNombreMesActual() {
		String mes = new String("");
		switch(getMesActual()) {
			case 1:{ mes = "enero"; break; }
			case 2:{ mes = "febrero"; break; }
			case 3:{ mes = "marzo"; break; }
			case 4:{ mes = "abril"; break; }
			case 5:{ mes = "mayo"; break; }
			case 6:{ mes = "junio"; break; }
			case 7:{ mes = "julio"; break; }
			case 8:{ mes = "agosto"; break; }
			case 9:{ mes = "septiembre"; break; }
			case 10:{ mes = "octubre"; break; }
			case 11:{ mes = "noviembre"; break; }
			case 12:{ mes = "diciembre"; break; }
		}
		return mes;
	}
	
	public static Integer getAno(Date fecha) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		return calendario.get(Calendar.YEAR);
	}
	
	public static Integer getMes(Date fecha) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		return calendario.get(Calendar.MONTH) + 1;
	}
	
	public static Integer getDia(Date fecha) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		return calendario.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Timestamp getTiempoActualEnTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static Date getTiempoActualEnDate() {  	
		return Calendar.getInstance().getTime();
	}
	
	public static String getFechaLargaEnTexto(Date fecha) {
		if (fecha!=null) return DateFormat.getDateInstance(DateFormat.FULL).format(fecha);    
		return "";
	}

	public static String getFechaCortaEnTexto(Date fecha) {
		if (fecha!=null) return DateFormat.getDateInstance(DateFormat.SHORT).format(fecha);    
		return "";
	}
	
	public static String getFechaCortaEnTextoActual() {
		return getFechaCortaEnTexto(getTiempoActualEnDate());
	}
	
	public static String getFechaActualConPatron(String patron) {
		if (patron != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			return formato.format(getTiempoActualEnDate());
		}
		return null;
	}
	
	public static Date getFechaActualEnDateConPatron(String patron) throws ParseException {
		if (patron != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			return formato.parse(getTiempoActualEnDate().toString());
		}
		return null;
	}
	
	public static Integer getAnosTranscurridos(Date fecha) {	
		if(fecha!=null) {		
			Calendar calendarioFecha = Calendar.getInstance();
			Calendar calendarioActual = Calendar.getInstance();		
			calendarioFecha.setTime(fecha);		
			return calendarioActual.get(Calendar.YEAR) - calendarioFecha.get(Calendar.YEAR);
		}
		return null;
	}
	
	/*public static Integer getDiasTranscurridos(Date fecha) {
		if(fecha!=null) {
			DateMidnight jodafec1 = new DateMidnight(2000,11,20);
			DateMidnight jodafec2 = new DateMidnight(2000,11,25);
			Period periodo = new Period(jodafec2.getMillis()-jodafec1.getMillis());
			return periodo.getDays();
		}
		return null;
	}*/
	
	public static Integer getDiasTranscurridos(Date fecha) {
		if(fecha!=null) {
			return getTiempoActualEnDate().compareTo(fecha);
		}
		return null;
	}
	
	public static Integer getMinutosTranscurridos(Date fecha) {
		if(fecha!=null) {		
			Calendar calendarioFecha = Calendar.getInstance();
			Calendar calendarioActual = Calendar.getInstance();		
			calendarioFecha.setTime(fecha);		
			return calendarioActual.get(Calendar.MINUTE) - calendarioFecha.get(Calendar.MINUTE);
		}
		return null;
	}
	
	public static Integer getAnosTranscurridosDesdeNacimiento(Date fechaNacimiento) {
		Integer anosTranscurridos = new Integer("0");
		if(fechaNacimiento != null) {
			anosTranscurridos = getAnosTranscurridos(fechaNacimiento);
			if ((getMesActual()-getMes(fechaNacimiento)) < 0) {
				anosTranscurridos = anosTranscurridos - 1;
			} else if((getMesActual()-getMes(fechaNacimiento)) == 0) {
				if((getDiaActual()-getDia(fechaNacimiento)) < 0) {
					anosTranscurridos = anosTranscurridos - 1;
				}
			}
		}
		return anosTranscurridos;
	}
	
	public static Date getFechaStringDate(String fecha) {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			try {
				return formato.parse(fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Date getFechaStringDateAMD(String fecha) {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return formato.parse(fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Date getFechaStringDateSlash(String fecha) {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return formato.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Convierte una fecha en formato MM/dd/yyyy a Date
	 * @param fecha - Es la fecha que se desea convertir
	 * @return
	 */
	public static Date getFechaStringDateSlashSQL(String fecha) {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
			try {
				return formato.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Date getFechaStringDateSlashSQL(String fecha,String patron) {
		if (fecha != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			try {
				return formato.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String getFechaActualConPatronyDate(String patron, Date fecha) {
		if (patron != null) {
			SimpleDateFormat formato = new SimpleDateFormat(patron);
			return formato.format(fecha);
		}
		return null;
	}
	
}
