
var context = null;
var menu = null;
var lista = null;
var tabGeneral = null;
var tabprincipal = null;
var ent = null;
var layoutConeinerCenter = null;
var count = 1;
var mostrarMsj = false;
$(function() {

	init();
	cargarMenus();
	cargarEnlaces();
	tabGeneral = $("#tabs");
	if (tabGeneral != null) {
		crearTab();
	}
});

function init() {
	/*
	 * var innerLayout = null; innerLayout = $('body >
	 * .ui-layout-center').layout({ minSize: 60, closable: false });
	 */
	mostrarMsj = $("#consolemessage").val();
	$('body').layout({
		applyDefaultStyles : true,
		west__size : 300,
		center : {
			onresize : function() {
				/*
				 * mensaje_consola("resize"); var h =
				 * $(".ui-layout-center").height() ; var w =
				 * $(".ui-layout-center").width(); mensaje_consola(h);
				 * mensaje_consola(h-(h/5)); mensaje_consola(w);
				 * mensaje_consola( w-(w/4));
				 */
				// $("#lista").jqGrid('setGridWidth', w-(w/4));
				// $("#lista").jqGrid('setGridHeight', h-(h/5));
			}
		}
	});

	ent = $("#ent").val();
	$.ajaxSetup({
		cache : false
	});
	context = $("#context").val();
	layoutConeinerCenter = $(".ui-layout-center");
	var h = layoutConeinerCenter.height();
	var contentPostion = $(".contentPostion");
	contentPostion.css("height", h - 30);

}

function crearTab() {
	tabGeneral.tabs();
	var h = layoutConeinerCenter.height();
	tabGeneral.height(h - (h / 18));
	if (ent != null) {
		cargarLista(ent);
	}
	// tabGeneral.resizable();
	tabGeneral
			.tabs({
				fxAutoHeight : true,
				cache : true,
				tabTemplate : "<li><a href=\"#{href}\">  #{label}  </a> <span class=\"ui-icon ui-icon-close\">Cerrar</span></li>",
				add : function(event, ui) {
					mensaje_consola(ui.tab);
					mensaje_consola("panel id:");
					mensaje_consola(ui.panel.id);
				},
				select : function(event, ui) {
					mensaje_consola(ui.tab);
					mensaje_consola("panel id:");
					mensaje_consola(ui.panel.id);
				}

			});

	tabGeneral.find("span.ui-icon-close").live("click", function() {
		var index = $("li", tabGeneral).index($(this).parent());
		mensaje_consola("index:" + index);
		if (index >= 0) {
			var tab = $(this).parent().find("a").attr("href");
			mensaje_consola("tab:" + tab);
			if (tab != "#tabPrincipal") {
				tabGeneral.tabs("remove", index);
			}
		}
	});

}

function cargarMenus() {

	$("#menu").accordion({
		heightStyle : "fill",
		icons : {
			header : "ui-icon-circle-arrow-e",
			activeHeader : "ui-icon-circle-arrow-s"
		}
	});
	$("#menu-resizer").resizable({
		minHeight : 300,
		minWidth : 170,
		resize : function() {
			mensaje_consola("resize");
			$("#menu").accordion("refresh");
		}
	});
	$(".oplink").click(function() {
		var d = $(this).parent();
		var url = d.find(".url").val();
		irPagina(url);
	});
}

function cargarEnlaces() {

	$(".clNuevo").button().click(function() {
		var d = $(this).parent();
		var codigo = d.find(".codigo").val();
		var icono = d.find(".icono").val();
		var onComplete = d.find(".onComplete").val();
		var onSubmit = d.find(".onSubmit").val();
		var parametrosJson = d.find(".parametrosJson").val();
		var tipo = d.find(".tipo").val();
		var url = d.find(".url").val();
		var descripcion = d.find(".descripcion").val();
		addtab("Nuevo Parametro", "nuevo_paramo", "", url);
	});

}

function addtab(titulo, identificador, html, url) {
	if (!diferenteNull(html) && diferenteNull(url)) {
		$.ajax({
			async : false,
			url : url,
			type : "get",
			success : function(response, textStatus, jqXHR) {
				html = response;
			},
			error : function(jqXHR, textStatus, errorThrown) {
				mensaje_consola("error:");
			},
			complete : function() {
				mensaje_consola("complete");
			}
		});
	}

	mensaje_consola(html);

	if ($("#" + identificador).length <= 0) {
		tabGeneral.append('<div id="' + identificador + '"> ' + html
				+ '</span>');
		tabGeneral.tabs("add", "#" + identificador, titulo);
		count++;
	}
	tabGeneral.tabs("select", identificador);
}

detalleLista = function(id, cap) {
	mensaje_consola(id);
	mensaje_consola(cap);
};

function irPagina(url) {
	url = context + url;
	$(location).attr('href', url);
}

function cargarLista(pm) {
	if (diferenteNull(pm)) {

		$
				.get(
						context + "principal/obtenerLista/" + pm,
						function(lista) {

							addtab("Principal", "tabPrincipal", "");
							tabprincipal = $("#tabPrincipal");
							tabprincipal.html("");

							var nombres = new Array();
							var modelo = new Array();
							var columnas = lista.columnas;

							for ( var i = 0; i < columnas.length; i++) {
								/*
								 * if(columnas[i].titulo){
								 * tituloTabs=columnas[i].codigo; }
								 */
								nombres[i] = columnas[i].cabecera;
								modelo[i] = {
									name : columnas[i].atributo,
									index : columnas[i].atributo,
									width : columnas[i].ancho,
									// align: columnas[i].alineacion,
									// hidden: !columnas[i].visible,
									// formatter:
									// formateadores[columnas[i].tipo],
									searchoptions : {
										sopt : [ 'cn', 'eq' ]
									}
								};

							}

							tabprincipal
									.append("<table id=\"lista\"></table> <div id=\"pager\"></div>");
							tabprincipal
									.append("<input type=\"hidden\" id=\"sizelista\" value=\"${size}\" />");

							var urlData = context
									+ "principal/obtenerDataLista/" + pm;
							/*
							 * $("#lista").resizable({ containment:
							 * ".tabsComponet" });
							 */
							$("#lista").jqGrid({
								url : urlData,
								datatype : "json",
								jsonReader : {
									root : "data",
									repeatitems : false,
									id : "id"
								},
								rowList : [ 10, 20, 30 ],
								colNames : [ 'id', 'campo', 'valor' ],
								colModel : [ {
									name : 'id',
									index : 'id',
									width : 60
								}, {
									name : 'campo',
									index : 'campo',
									width : 90
								}, {
									name : 'valor',
									index : 'valor',
									width : 100
								} ],
								pager : "#pager",
								viewrecords : true,
								// caption: lista.nombre,
								onSelectRow : detalleLista,
								page : 1,
								rowNum : "20",
								rowList : [ 5, 10, 20, 30 ],
								width : tabprincipal.width() - 20,// -
																	// (layoutConeinerCenter.width()/5),
								// height: layoutConeinerCenter.height() - (60),
								hidegrid : false,
								loadComplete : function(json) {
									// mensaje_consola("json:");
								}

							});
							var h = layoutConeinerCenter.height();
							$("#lista").jqGrid('setGridWidth', "60%");
							$("#lista").jqGrid('setGridHeight', h - (h / 5));

							$("#lista").jqGrid('navGrid', '#pager', {
								edit : false,
								add : false,
								del : false,
								search : true
							});

						});

	}

}

function mensaje_consola(objeto) {
	// if (!window.console) {
	if (mostrarMsj=="true") {
		if ($.browser.msie && $.browser.version < 9) {
			alert(objeto);
		} else {
			console.log(objeto);
		}
	}
}

function diferenteNull(objeto) {
	objeto = $.trim(objeto);
	if (objeto != null && objeto != "") {
		return true;
	}
	return false;
}

var formateadores = {
	fecha : function(valor) {
		var fecha = new Date(valor);
		var anio = fecha.getFullYear();
		var mes = fecha.getMonth();
		var dia = fecha.getDay();
		var hoy = new Date();
		if (anio == hoy.getFullYear() && mes == hoy.getMonth()
				&& dia == hoy.getDay()) {
			var minT = fecha.getMinutes();

			if (fecha.getMinutes() < 10) {
				minT = "0" + minT;
			}
			return fecha.getHours() + ":" + minT;
		}
		if (dia < 10) {
			dia = "0" + dia;
		}
		var mesF = mes + 1;
		if (mesF + 1 < 10) {
			mesF = "0" + mesF;
		}
		var minutos = fecha.getMinutes();
		if (minutos < 10) {
			minutos = "0" + minutos;
		}

		var hora = fecha.getHours();
		if (hora < 10) {
			hora = "0" + hora;
		}
		fechaF = dia + "/" + mesF + "/" + anio + " " + hora + ":" + minutos;
		return fechaF;
	},
	boton : function(valor) {
		var lista = valor.split("-");
		return "<button onclick=\"" + lista[2] + "(" + lista[0] + ")\">"
				+ lista[1] + "</button>";
	},
	image : function(valor) {
		return "<img src=\"" + valor + "\"/>";
	}
};
