package com.vst.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.vst.util.Entidad;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@Table(name="historial")
public class Historial implements Entidad , Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator",
					table = "sequence_table", 
					pkColumnName = "sequence_name", 
					valueColumnName = "sequence_value")
	@Column(name="id_historial")
	private Integer id;


	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	@Column(name="valor",length=200)
	private String valor;
	
	
	
    public Historial() {
    }



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getFechaRegistro() {
		return fechaRegistro;
	}



	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}



	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

	
    

}