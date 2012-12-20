package com.vst.util;

import java.util.List;

public interface IDAO<T extends Entidad>{

    public T  obtenerPorCodigo(String codigo , String campoCodigo);
    
	public T get(Integer id);
	
	public List<T> getTodos();
	
	public void guardar(T objeto);
	
	public void eliminar(T objeto);
}
