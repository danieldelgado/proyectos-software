package com.ap.sample;

public class BeanConexion {

	private String ip;
	private String puerto;
	private String fechaRegsitro;
	private String responsable;
	private String metodo;
	private String queryString;
	private String json;
		
	public BeanConexion(String ip, String puerto, String fechaRegsitro,
			String responsable, String metodo, String queryString, String json) {
		this.ip = ip;
		this.puerto = puerto;
		this.fechaRegsitro = fechaRegsitro;
		this.responsable = responsable;
		this.metodo = metodo;
		this.queryString = queryString;
		this.json = json;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getFechaRegsitro() {
		return fechaRegsitro;
	}
	public void setFechaRegsitro(String fechaRegsitro) {
		this.fechaRegsitro = fechaRegsitro;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	
	
}
