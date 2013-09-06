package com.vst.android.beans;

/**
 * Clase del tipo Bean donde se isntancia las filas.
 * @author ddelgado
 *
 */
public class RowItem {
	
    private int idItem;
    private int idImagen;
    private String nombre;
    private String descripcion;
        
   	public RowItem(int idItem, String nombre, String descripcion) {
   		
   		this.idItem = idItem;
   		this.nombre = nombre;
   		this.descripcion = descripcion;
   	}
    
   	public RowItem(int idItem,int idImagen, String nombre, String descripcion) {
   	
   		this.idItem = idItem;
   		this.idImagen = idImagen;
   		this.nombre = nombre;
   		this.descripcion = descripcion;
   	}
   	
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdImagen() {
		return idImagen;
	}
	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}
    
}