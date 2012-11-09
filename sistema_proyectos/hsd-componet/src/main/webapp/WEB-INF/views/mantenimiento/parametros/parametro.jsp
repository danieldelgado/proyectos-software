<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.chimera.org/chimera.tld" prefix="p"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div id="txtDiv">

	<p:conentTag tituloConent="yujuu!" ent="Parametro" dwr="false" javascriptConent="mantenimiento/parametro/mantenimientoParametro.js">

		<div>
			<fieldset>
				<div id="toolbar" class="ui-widget-header ui-corner-all">
					<label class="encabezadoTool">Nuevo parametro</label>
				</div>
				<br>
				<form id="" action="" method="post" class="formulario">
					<div>

						<p>
							<label> Estado : </label> <select id="" name="estado"   >
								<c:forEach items="${lstEstados}" var="e">
									<option  value="${e.id}">${e.valor}</option>
								</c:forEach>
							</select>
						</p>
						<p>
							<label> Activo : </label> <input type="checkbox" name="activo" />
						</p>
						<p>
							<label> Entidad : </label> <input type="text" name="entidad" />
						</p>
						<p>
							<label> Campo : </label> <input type="text" name="campo" />
						</p>
						<p>
							<label> Tipo : </label> <input type="text" name="tipo" />
						</p>
						<p>
							<label> Valor : </label> <input type="text" name="valor" />
						</p>
						<p>
							<label> Descripcion : </label>
						</p>
						<p>
							<textarea name="descripcion"></textarea>
						</p>
						<div>
							<fieldset>
								<legend>Lista de Pametros Assignar</legend>

								<!-- se listara aquelos q no pertenecen a ninguno -->

								<ul id="sortable1" class="droptrue">
									<c:forEach items="${lstParametrosPadre}" var="e">
										<li class="ui-state-default"><span> ${e.valor}
												${e.tipo} </span> <INPUT type="hidden" class="id" value="${e.id}" />
											<INPUT type="hidden" class="codigo" value="${e.codigo}" />
											<INPUT type="hidden" class="estado" value="${e.estado}" />
											<INPUT type="hidden" class="activo" value="${e.activo}" />
											<INPUT type="hidden" class="entidad" value="${e.entidad}" />
											<INPUT type="hidden" class="campo" value="${e.campo}" /> <INPUT
											type="hidden" class="tipo" value="${e.tipo}" /> <INPUT
											type="hidden" class="valor" value="${e.valor}" /> <INPUT
											type="hidden" class="descripcion" value="${e.descripcion}" />
										</li>
									</c:forEach>
								</ul>

								<ul id="sortable3" class="droptrue">
								</ul>

								<br style="clear: both;" />
							</fieldset>
						</div>

					</div>

				</form>
			</fieldset>
			<!--de este parametro a quien pertenece;	
	
	@Column(name="id_parametro")
	private Integer id;

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;
	
  -->
		</div>
	</p:conentTag>

</div>