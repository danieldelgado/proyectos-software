<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.chimera.org/chimera.tld" prefix="p" %>
<p:html titulo="Mantenimiento de Parametros" ent="Parametro" javascript="mantenimiento/parametro/mantenimientoParametro.js">

<div class="tabsComponet" >
<div id="toolbar" class="ui-widget-header ui-corner-all">
<div>
<button class="clNuevo"> Nuevo </button>
<input type="hidden" class="codigo" value="1526" >
<input type="hidden" class="icono" value="" >
<input type="hidden" class="onComplete" value="" >
<input type="hidden" class="onSubmit" value="" >
<input type="hidden" class="parametrosJson" value="" >
<input type="hidden" class="tipo" value="" >
<input type="hidden" class="url" value="<c:url value="/mantenimiento/parametro/nuevo"/>" >
<input type="hidden" class="descripcion" value="" >
</div>
</div>
<div id="tabs" >
	<ul>
		
	</ul>    
</div>
</div>

</p:html>
