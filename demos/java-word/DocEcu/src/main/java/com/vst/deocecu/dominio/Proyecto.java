package com.vst.deocecu.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.vst.deocecu.util.Entidad;

@Entity
@Table(name = "Proyecto")
public class Proyecto implements Entidad{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_proyecto")
	private Integer id;
	
	private String folder;
	
	private String ruta_completa;
	
	private String path; 
	
	private String uuid; 
	
	private String address; 
	
	private String scheme;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "carpeta")
	private List<Documento>  documentos;
	
	
	public Proyecto(){
		
	}



	public Proyecto(String folder, String ruta_completa, String path, String uuid, String address, String scheme) {
		this.folder = folder;
		this.ruta_completa = ruta_completa;
		this.path = path;
		this.uuid = uuid;
		this.address = address;
		this.scheme = scheme;
	}





	public String getFolder() {
		return folder;
	}



	public void setFolder(String folder) {
		this.folder = folder;
	}



	public String getRuta_completa() {
		return ruta_completa;
	}



	public void setRuta_completa(String ruta_completa) {
		this.ruta_completa = ruta_completa;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getScheme() {
		return scheme;
	}



	public void setScheme(String scheme) {
		this.scheme = scheme;
	}



	public List<Documento> getDocumentos() {
		return documentos;
	}



	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean getActivo() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

}
