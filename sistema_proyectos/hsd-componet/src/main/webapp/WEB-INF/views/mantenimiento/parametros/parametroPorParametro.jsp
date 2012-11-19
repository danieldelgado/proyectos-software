<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.chimera.org/chimera.tld" prefix="p"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div style="width: 350px; height: 120px;">

<p:conentTag tituloConent="probando2!" ent="ParametroPorParametro" javascriptConent="mantenimiento/parametro/mantenimientoParametroPorParametro.js,formulario/validarFormulario.js">

	<div id="toolbar" class="ui-widget-header ui-corner-all" >
		<div>
			<span>
				<button id="btnGuardarParametroPorParametro" class="clGuardar">Guardar</button> 
				<input type="hidden" class="codigo" value="1526"> 
				<input type="hidden" class="icono" value="">
				<input type="hidden" class="onComplete" value=""> 
				<input type="hidden" class="onSubmit" value=""> 
				<input type="hidden" class="parametrosJson" value=""> 
				<input type="hidden" class="tipo" value=""> 
				<input type="hidden" class="url" value=""> 
				<input type="hidden" class="descripcion" value="">
			</span>
		</div>
	</div>


	<div >
		<fieldset>
			<legend>Asignar Parametros</legend>
			<form class="formulario" action="" method="post">
				<div>
					<p>
						<label for="parametro">Parametro</label> <input id="parametro" name="parametro" class="autoComplete" value="">
					</p>
					<p>
						<label for="atributo">Atritubo</label> <input id="atributo" name="atributo" class="" value="">
					</p>
				</div>
			</form>			
		</fieldset>


	</div>

</p:conentTag>

</div>
