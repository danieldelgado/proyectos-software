<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type='text/javascript' src="<c:url value="/krams/dwr/engine.js" ></c:url>"></script>
<script type='text/javascript' src="<c:url value="/krams/dwr/util.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/krams/dwr/dwr/interface/dwrService.js" ></c:url>"></script>



<div>

<div>
<fieldset>
<div id="toolbar" class="ui-widget-header ui-corner-all">
	<label class="encabezadoTool">Nuevo parametro</label>
</div>
<br>
<form id="" action="" method="post" class="formulario">
<div>
<p> <label> Estado : </label> <select id="" name="estado" > <option value="0" > Seleccione </option>  </select> </p>
<p> <label> Activo : </label> <input type="checkbox" name="activo" /></p>
<p> <label> Entidad : </label> <input type="text" name="entidad" /></p>
<p> <label> Campo : </label> <input type="text" name="campo" /></p>
<p> <label> Tipo : </label> <input type="text" name="tipo" /></p>
<p> <label> Valor : </label> <input type="text" name="valor" /></p>
<p> <label> Descripcion : </label>  </p>
<p> <textarea name="descripcion" ></textarea> </p>
<div>
<fieldset>
<legend>Lista de Pametros Assignar</legend>




</fieldset>
</div>

</div>

</form>
</fieldset>
<!--

	
	@Temporal( TemporalType.DATE)	 
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;
		
	@ManyToOne(fetch = FetchType.LAZY)
	private Parametro parametro;

	@OneToMany(mappedBy = "parametro")
	private List<Parametro> parametros;
	
	@Column(name="id_parametro")
	private Integer id;

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;
	
  -->
</div>

</div>