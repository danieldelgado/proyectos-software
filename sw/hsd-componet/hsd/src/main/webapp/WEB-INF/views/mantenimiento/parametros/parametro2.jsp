<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.chimera.org/chimera.tld" prefix="p"%>
<script type="text/javascript"	src="<c:url value="/resources/js/mantenimiento/parametro/mantenimientoParametro.js" ></c:url>"></script>
<div id="Parametro-${rand}" class="pnlParametro">
	<p:botones botones="${lstBotones}" />
	<input type="hidden" id="codigoFormulario" name="codigoFormulario" value="${codigoFormulario}" /> 
	<input type="hidden" id="rand" name="rand" value="${rand}" /> 
	<fieldset>
		<legend></legend>
		<form id="" action="" method="post" class="formulario-${rand}">
			<input type="hidden" id="id" name="parametro.id" value="${parametro.id}" />
		</form>
	</fieldset>
</div>