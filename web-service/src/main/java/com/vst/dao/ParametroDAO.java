package com.vst.dao;

import com.vst.dominio.Parametro;
import com.vst.util.IDAO;

public interface ParametroDAO extends IDAO<Parametro> {


	public Integer getCantidadDecimales();
	
	public Integer getRangoEnteroMin();

	public Integer getRangoEnteroMax();

	public Integer getValorEnteroMax();

	public Integer getValorEnteroMin();

	public Double  getRangoDecimalMin();

	public Double getRangoDecimalMax();

	public Double getValorDecimalMin();

	public Integer getValorDecimalMax();

	public Integer getRangoCadenaMin();

	public Integer getRangoCadenaMax();

	public String[] getCadenasRestringidas();

	public String[] getCadenasRestringidasSelector();

	public Integer getValorSelectorMin();

}
