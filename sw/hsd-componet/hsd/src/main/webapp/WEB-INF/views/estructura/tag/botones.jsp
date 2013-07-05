<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
	var divs = $("#btn${rand}");
	var bts = divs.find("button");
	$(bts).each(function(i, item) {
		var parentDiv = $(this).parent();
		var codigo = parentDiv.find(".codigo").val();
		var icono = parentDiv.find(".icono").val();
		var onClick = parentDiv.find(".onClick").val();
		var onSubmit = parentDiv.find(".onSubmit").val();
		var onComplete = parentDiv.find(".onComplete").val();
		var parametrosJson = parentDiv.find(".parametrosJson").val();
		var tipo = parentDiv.find(".tipo").val();
		var url = parentDiv.find(".url").val();
		var descripcion = parentDiv.find(".descripcion").val();		
		$(this).click(function() {
			
			if(!isStringNull(onClick)){
			}
			if(!isStringNull(onSubmit)){
				console.log("window[onSubmit]  rad:"+${rand}+"  url:"+url);
				window[onSubmit](${rand},url);				
			}			
			if(!isStringNull(onComplete)){
// 				window[onComplete](url);				
			}			
		}).button({
			icons : {
				primary : icono
			}
		});
	});
</script>

<div id="btn${rand}" class="ui-widget-header toolbar">
	<c:forEach items="${listaBotones}" var="btn">
		<span>
			<button class="bt" title="${btn.descripcion}" >${btn.nombre}</button> 
			<input type="hidden" class="codigo" value="${btn.codigo}"> 
			<input type="hidden" class="icono" value="${btn.icono}"> 
			<input type="hidden" class="onClick" value="${btn.onClick}"> 
			<input type="hidden" class="onComplete" value="${btn.onComplete}"> 
			<input type="hidden" class="onSubmit" value="${btn.onSubmit}"> 
			<input type="hidden" class="parametrosJson" value="${btn.parametrosJson}">
			<input type="hidden" class="tipo" value="${btn.tipo}"> 
			<input type="hidden" class="url" value="<c:url value="${btn.url}"/>">
		</span>
	</c:forEach>
</div>