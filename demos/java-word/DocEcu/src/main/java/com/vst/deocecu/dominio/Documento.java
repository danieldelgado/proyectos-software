package com.vst.deocecu.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.vst.deocecu.util.Entidad;

@Entity
@Table(name = "Documento")
public class Documento implements Entidad{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_documento")
	private Integer id;
	
	private String ruta_alfresco;
	
	private String content_html;
	
	private String nombre;
	
	private String titulo;
	
	private String descripcion;
	
	private Date fechaRegistro;
	
	private Date fechaActua;
	
	private Boolean isDocumento;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carpeta")
	private Documento carpeta;

	/** The menus. */
	@OneToMany(mappedBy = "menu")
	private List<Documento> menus;
	
	
	public Documento(){
		
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
