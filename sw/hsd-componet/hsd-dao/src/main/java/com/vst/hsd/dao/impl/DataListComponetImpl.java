package com.vst.hsd.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.DataListComponet;
import com.vst.hsd.dominio.Columna;
import com.vst.hsd.dominio.Usuario;
import com.vst.util.BeanFlags;
import com.vst.util.Util;

@Repository("DataListComponet")
public class DataListComponetImpl implements DataListComponet {
	
	private static final Logger log = LoggerFactory.getLogger(DataListComponetImpl.class);
	
	@PersistenceContext
	protected EntityManager em;
	
	private String createQuery(BeanFlags f,boolean _search,boolean cuenta,Usuario usuario,String codigo,List<Columna> columnas,Character estado,String columnaOrden,String direccionOrden,String searchField,String searchOper){
		String sql="SELECT ";

		if(cuenta){
			sql+=" count(x.id) ";
		}
		else{
			boolean primero=true;
			for(Columna columna : columnas){
				if(columna.getMapping()){
					if(!primero){
						sql+=",";
					}
					if(estado!=null && columna.getAtributo().equals("id")){
						sql+=" DISTINCT (x." + columna.getCodigo()+") ";
					}else{
						sql+="x." + columna.getAtributo();
					}	
			    	primero=false;
				}
			}			
		}

		sql+=" FROM " + codigo + " x";
		
		if(_search){
			if(sql.indexOf("WHERE") < 0){
				sql+=" WHERE ";
			}
			if(sql.indexOf("AND") > 0){
				sql+=" AND ";
			}
			if(searchOper.equals("eq")){
				sql+=" x." + searchField + " = :qBuscar";
				f.setConBusqueda(true);
			}
			else if(searchOper.equals("cn")){
				sql+=" x." + searchField + " like :qBuscar";
				f.setConBusqueda(true);
			}
		}

		if(!Util.vacio(columnaOrden) && !Util.vacio(direccionOrden)){
			if(columnaOrden.equals("actividad")){
				sql+=" ORDER BY tt." + columnaOrden + " " + direccionOrden;
			}
			else
				sql+=" ORDER BY x." + columnaOrden + " " + direccionOrden;

		}

		return sql;
	}

	public Integer getCuentaData(Usuario usuario, String codigo, List<Columna> columnas, Character estado) {
		
		String sql="SELECT COUNT(*) FROM " + codigo + " x";

		boolean conUsuario=false;
		boolean conEstado=false;	
				
		log.info("Query :" + sql);
		Query q =em.createQuery(sql);
		if(conUsuario){
			q.setParameter("usuario",usuario);
		}
		if(conEstado){
			q.setParameter("estado",estado);
		}
		
		//log.info("respuesta :" + q.getSingleResult());
		Long retorno=(Long) q.getSingleResult();
		//log.info("Resultado de la query :" + retorno);
		if(retorno > 0){

			return retorno.intValue();
		}
		return 0;
	}
	
	public List<Map<String, Object>> getData(Usuario usuario, String codigo, List<Columna> columnas, Character estado, String columnaOrden, String direccionOrden, int pagina, int filas,
			boolean _search, String searchField, String searchOper, String searchString) {
		BeanFlags flags=new BeanFlags();
		flags.setConAction(false);
		flags.setConEstado(false);
		flags.setConUsuario(false);
		flags.setConBusqueda(false);
		flags.setCopiado(false);

		String sql=createQuery(flags,_search,false,usuario,codigo,columnas,estado,columnaOrden,direccionOrden,searchField,searchOper);
		log.debug("query dinamica bandeja:" + sql);		
		Query q=em.createQuery(sql);
		if(flags.getConUsuario()){
			q.setParameter("usuario",usuario);
		}
		if(flags.getConEstado()){
			q.setParameter("estado",estado);
		}
		
		if(flags.getConBusqueda()){
			if(searchOper.equals("cn")){
				q.setParameter("qBuscar","%" + searchString + "%");
			}
			else
				q.setParameter("qBuscar",searchString);
		}
		

		q.setFirstResult(filas * pagina - filas);
		q.setMaxResults(filas);

		List<Object[]> retorno=q.getResultList();
		if(retorno.size() > 0){
			List<Map<String,Object>> salida=new ArrayList<Map<String,Object>>();
			for(Object[] dato : retorno){
				Map<String,Object> data=new HashMap<String,Object>();
				for(int i=0;i < dato.length;i++){
					data.put(columnas.get(i).getAtributo(),dato[i]);
				}
				/*for(int i=0;i < columnas.size();i++){
					if(columnas.get(i).getAtributo()!=null && columnas.get(i).getAtributo().equals(Constantes.COLUMNA_TIPO_IMAGE)){
						data.put(columnas.get(i).getAtributo(),columnas.get(i).getOrden());
					}
				}*/
				salida.add(data);
			}
			return salida;
		}
		return null;
	}

	

	public int getCantidadDataRows(Usuario usuario, String codigo, Character estado) {
		BeanFlags flags=new BeanFlags();
		flags.setConAction(false);
		flags.setConEstado(false);
		flags.setConUsuario(false);
		flags.setConBusqueda(false);

		String sql=createQuery(flags,false,true,usuario,codigo,null,estado,null,null,null,null);

		Query q=em.createQuery(sql);

		if(flags.getConUsuario()){
			q.setParameter("usuario",usuario);
		}
		if(flags.getConEstado()){
			q.setParameter("estado",estado);
		}		
		Long count=(Long) q.getSingleResult();
		return count.intValue();
	}

}
