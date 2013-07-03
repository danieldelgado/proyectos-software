<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
	var divs = $("#btn${rand}");
	var bts = divs.find("button");
	$(bts).each(function(i, item) {

		$(this).click(function() {

		}).button({
			icons : {
				primary : "ui-icon-document"
			}
		});
	});
</script>

<div id="btn${rand}" class="ui-widget-header toolbar">

	<c:forEach items="${listaBotones}" var="btn">
		<span>
			<button class="bt">${btn.nombre}</button> <input type="hidden"
			class="codigo" value="${btn.codigo}"> <input type="hidden"
			class="icono" value="${btn.icono}"> <input type="hidden"
			class="onComplete" value="${btn.onComplete}"> <input
			type="hidden" class="onSubmit" value="${btn.onSubmit}"> <input
			type="hidden" class="parametrosJson" value="${btn.parametrosJson}">
			<input type="hidden" class="tipo" value="${btn.tipo}"> <input
			type="hidden" class="url" value="<c:url value="${btn.url}"/>">
			<input type="hidden" class="descripcion" value="${btn.descripcion}">
		</span>
	</c:forEach>

</div>
