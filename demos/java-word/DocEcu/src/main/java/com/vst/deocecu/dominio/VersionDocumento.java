package com.vst.deocecu.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.deocecu.util.Entidad;

@Entity
@Table(name = "Documento.java")
public class VersionDocumento implements Entidad {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_VersionDcumento")
	private Integer id;

	@Column(name = "ruta_alfresco")
	private String ruta_alfresco;

	@Column(name = "version")
	private String version;

	@Column(name = "description")
	private String description;

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaActua")
	private Date fechaActua;

	private transient String content_html;

	@ManyToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "seccion_documento")
	private Documento documento;

	public VersionDocumento() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRuta_alfresco() {
		return ruta_alfresco;
	}

	public void setRuta_alfresco(String ruta_alfresco) {
		this.ruta_alfresco = ruta_alfresco;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActua() {
		return fechaActua;
	}

	public void setFechaActua(Date fechaActua) {
		this.fechaActua = fechaActua;
	}

	public String getContent_html() {
		return content_html;
	}

	public void setContent_html(String content_html) {
		this.content_html = content_html;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
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
