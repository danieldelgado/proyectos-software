<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.chimera.org/chimera.tld" prefix="p"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div id="toolbar" class="ui-widget-header ui-corner-all">
<div>
<span>
<button class="clGuardar"> Guardar </button>
<input type="hidden" class="codigo" value="1526" >
<input type="hidden" class="icono" value="" >
<input type="hidden" class="onComplete" value="" >
<input type="hidden" class="onSubmit" value="" >
<input type="hidden" class="parametrosJson" value="" >
<input type="hidden" class="tipo" value="" >
<input type="hidden" class="url" value="" >
<input type="hidden" class="descripcion" value="" >
</span>
</div>
</div>
<div id="txtDiv">
	<p:conentTag tituloConent="yujuu!" ent="Parametro" dwr="false" javascriptConent="mantenimiento/parametro/mantenimientoParametro.js,formulario/validarFormulario.js">

		<div>
			<fieldset>
				<div id="toolbar" class="ui-widget-header ui-corner-all">
					<label class="encabezadoTool">Nuevo parametro</label>
				</div>
				<br>
					<div class="">
					
				<form id="${entidad}formulario" action="<c:url  value="/mantenimiento/parametro/guardar"></c:url>" method="post" class="formulario">
						<div>
						<p>
							<label for="estado"> Estado : </label> <select id="estado" name="estado">
								<c:forEach items="${lstEstados}" var="e">
									<option value="${e.id}">${e.valor}</option>
								</c:forEach>
							</select>
						</p>
						<p>
							<label for="cboEstado" > Activo : </label> <input type="checkbox"  id="activo" name="activo" />
						</p>
						<p>
							<label for="entidad"> Entidad : </label> <input type="text" id="entidad" name="entidad" />
						</p>
						<p>
							<label for="campo"> Campo : </label> <input type="text" name="campo" id="campo" />
						</p>
						<p>
							<label for="tipo"> Tipo : </label> <input id="tipo" type="text" name="tipo" />
						</p>
						<p>
							<label for="valor"> Valor : </label> <input  id="valor" type="text" name="valor" />
						</p>
						<p>
							<label  for="descripcion"> Descripcion : </label>
						</p>
						<p>
							<textarea  id="descripcion" name="descripcion"></textarea>
							<br>
						</p>
						<input type="hidden" name="parametroPadre" value="" id="" >
						</div>
						</form>
						<br>
						<br>
						<br>
						<br>
						<div>
							<fieldset >
								<legend>Lista de Pametros Assignar</legend>
								<div>
								<div class="disponibles" style="float: left; width: 50%">
								<fieldset>
								<legend>Parametros Disponibles</legend>
								<ul class="droptrue" >
									<c:forEach items="${lstParametrosPadre}" var="e">
										<li class="ui-state-default"  >
										<span> ${e.valor} ${e.tipo} </span> 
										<input type="hidden" class="id" value="${e.id}" /> 
										<input type="hidden" class="codigo" value="${e.codigo}" /> 
										<input type="hidden" class="estado" value="${e.estado}" /> 
										<input type="hidden" class="activo" value="${e.activo}" /> 
										<input type="hidden" class="entidad" value="${e.entidad}" /> 
										<input type="hidden" class="campo" value="${e.campo}" /> 
										<input type="hidden" class="tipo" value="${e.tipo}" /> 
										<input type="hidden" class="valor" value="${e.valor}" /> 
										<input type="hidden" class="descripcion" value="${e.descripcion}" />
										</li>
									</c:forEach>
								</ul>
								</fieldset>
								</div>
								<div class="asignados" style="float: left; width: 50%">
								<fieldset>
								<legend>Parametros Asignados</legend>
								<ul class="droptrue" >
								</ul>
								</fieldset>
								</div>

								<br style="clear: both;" />
								</div>
							</fieldset>
						</div>

					</div>

			</fieldset>
			
		</div>
	</p:conentTag>

</div>