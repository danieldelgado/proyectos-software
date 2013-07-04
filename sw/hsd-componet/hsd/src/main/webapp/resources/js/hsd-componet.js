var context = null;
var menu = null;
var lista = null;
var tabsGeneralHSD = null;
var tabprincipal = null;
var ent = null;
var layoutConeinerCenter = null;
var count = 1;
var mostrarMsj = true;
var myLayout;
var uilayoutwest;

$(function() {
	init();
	cargarMenus();
	crearTab();
	cargarLista(ent);
});

function init() {
//	mostrarMsj = $("#consolemessage").val();
	context = $("#context").val();
	ent = "Parametro";
	uilayoutwest = $(".ui-layout-west");
	layoutConeinerCenter = $(".ui-layout-center");

	myLayout = $('body').layout({
		north__size : 40,
		west__size : 200,
		south__size : 40,
		west__onresize : $.layout.callbacks.resizePaneaccordions,
		north__fxName : "drop",
		north__fxSettings_open : {
			duration : 1500
		},
		west__fxName : "drop",
		west__fxSettings_open : {
			duration : 1500
		},
		south__fxName : "drop",
		south__fxSettings_open : {
			duration : 1500
		},
		center : {
			onshow : function(pane, p, paneState) {
				console.log("load");
			},
			onresize : function(pane, p, paneState) {
				jQuery("#lista").jqGrid('setGridWidth', paneState.innerWidth - 20, 'true');
				jQuery("#lista").jqGrid('setGridHeight', paneState.innerHeight - 125, 'true');
			}
		}
	});

	myLayout.options.north.minSize = 40;
	myLayout.options.north.maxSize = 80;
	myLayout.options.west.minSize = 200;
	myLayout.options.west.maxSize = 250;
	myLayout.options.south.minSize = 40;
	myLayout.options.south.maxSize = 80;

	var icons = {
		header : "ui-icon-circle-arrow-e",
		activeHeader : "ui-icon-circle-arrow-s"
	};

	$("#accordion-west").accordion({
		icons : icons,
		heightStyle : "fill",
		fillSpace : true
	});

	setTimeout("myLayout.resizeall", 1000);

}

function cargarMenus() {

	$(".lkmenu").click(function() {
		var li = $(this).parent();
		var codigo = li.find(".codigo").val();
		var tipo = li.find(".tipo").val();
		if (tipo == "interno") {
			cargarLista(codigo);
		}
	});

}

function crearTab() {
	tabsGeneralHSD = $(".ui-layout-center");
	tabsGeneralHSD.html("");
	tabsGeneralHSD.html("<ul></ul>");

	var tabTemplate = "<li><a href=\"#{href}\"> #{label} </a> <span class=\"ui-icon ui-icon-close\">Cerrar</span></li>";

	tabsGeneralHSD.tabs({
		collapsible : true,
		fxAutoHeight : true,
		cache : true,
		tabTemplate : tabTemplate,
		add : function(event, ui) {
		},
		select : function(event, ui) {
		}
	}).find(".ui-tabs-nav").sortable({
		axis : 'x',
		zIndex : 2
	});

	tabsGeneralHSD.delegate("span.ui-icon-close", "click", function() {
		var index = $("li", tabsGeneralHSD).index($(this).parent());
		var tab = $(this).parent().find("a").attr("href");
		if (tab != "#tabPrincipal") {
			$(tab).remove();
			$(this).closest("li").remove().attr("aria-controls");
		}
	});

	addtab("Principal", "tabPrincipal", "", true);
	tabprincipal = $("#tabPrincipal");
}

function addtab(titulo, identificador, content, select) {
	var tabIdentificadorExists = get("#"+identificador);	
	if (isNull(tabIdentificadorExists)) {
		var tabTemplate = "<li><a href=\"#{href}\"> #{label} </a> <span class=\"ui-icon ui-icon-close\">Cerrar</span></li>";
		var li = $(tabTemplate.replace(/#\{href\}/g, "#" + identificador).replace(/#\{label\}/g, titulo));
		tabsGeneralHSD.find(".ui-tabs-nav").append(li);
		tabsGeneralHSD.append("<div id='" + identificador + "'>" + content + "</div>");
		tabsGeneralHSD.tabs("refresh");
	}
	selectTab(identificador);
}

function selectTab(identificador) {
	tabsGeneralHSD.tabs("select", identificador);
}

function existsTabSelect(identificador) {
	var tabIngresado = get("#"+identificador);
	if (isNull(tabIngresado)) {
		return false;
	}
	return true;
}

detalleLista = function(id, cap) {
	 consola("detalleLista:"+id+" "+cap);
};

function irPagina(url) {
	// url = context + url;
	// $(location).attr('href', url);
}

function cargarLista(pm) {
	tabprincipal.html("");
	if ( !isStringNull(pm) )  {
		$.get(context + "principal/obtenerLista/" + pm, function(lista) {			
			if(!isNullSpace(lista)){
			var nombres = new Array();
			var modelo = new Array();
			var columnas = lista.columnas;
			for ( var i = 0; i < columnas.length; i++) {
				nombres[i] = columnas[i].cabecera;
				modelo[i] = {
					name : columnas[i].atributo,
					index : columnas[i].atributo,
					width : columnas[i].ancho,
					align : columnas[i].alineacion,
					hidden : !columnas[i].visible,
					// formatter:
					// formateadores[columnas[i].tipo],
					searchoptions : {
						sopt : [ 'cn', 'eq' ]
					}
				};
			}		
			ajaxAsyncGet(context + "principal/obtenerBotonesPorMenu/" + lista.idMenu, null, function(res) {
				var toolbarButton = $('<div/>', {
					'class' : 'ui-widget-header toolbar'
				});
				$(res).each(function(i, item) {
					var btnNuevo = $('<button/>', {
						text : item.nombre,
						id : item.id
					}).click(function() {					
							if (!existsTabSelect(item.codigo)) {
								var html = "";
								ajaxAsyncGetHtml(context + item.url, {rand:count}, function(h) {
									html = h;
								});
								addtab(lista.nombre, item.codigo+count, html, true);
								count++;
							} else {
								selectTab(item.codigo);
							}
					}).button({
						icons : {
							primary : item.icono
						}
					});
					btnNuevo.appendTo(toolbarButton);
				});
				toolbarButton.appendTo(tabprincipal);
				
			});

			tabprincipal.append("<table id='lista'></table><div id='pager'></div> <input type=\"hidden\" id=\"sizelista\" value=\"${size}\" />");
			var urlData = context + "principal/obtenerDataLista/" + pm;

			$("#lista").jqGrid({
				url : urlData,
				datatype : "json",
				jsonReader : {
					root : "data",
					repeatitems : false,
					id : "id"
				},
				rowList : [ 10, 20, 30 ],
				colNames : nombres,
				colModel : modelo,
				pager : "#pager",
				viewrecords : true,
				caption : lista.nombre,
				onSelectRow : detalleLista,
				page : 1,
				rowNum : "20",
				rowList : [ 5, 10, 20, 30 ],
				hidegrid : false,
				loadComplete : function(json) {
					// consola("json:");
				}

			});

			$("#lista").jqGrid('navGrid', '#pager', {
				edit : false,
				add : false,
				del : false,
				search : true
			});

			jQuery("#lista").jqGrid('setGridWidth', layoutConeinerCenter.width() - 20, 'true');
			jQuery("#lista").jqGrid('setGridHeight', layoutConeinerCenter.height() - 125, 'true');
			}

		});

	}

}

function get(identificadorObjeto) {
	var obj = $(identificadorObjeto)[0];
	
	return obj;

}

function consola(objeto) {
	// if (!window.console) {
	// alert($.browser.msie);
	if (mostrarMsj == true) {
		if ($.browser.msie && $.browser.version < 9) {
			alert(objeto);
		} else {
			console.log(objeto);
		}
	}
}
function isStringNull(objeto) {
	objeto = $.trim(objeto);	
	if (objeto == null || objeto == "" ) {
		return true;
	}
	return false;
}

function isNull(objeto) {
	if  (objeto == null || objeto == undefined || objeto == "" ) {
		return true;
	}
	return false;
}

function isNullSpace(objeto) {
	if  (objeto == "" ) {
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
		if (anio == hoy.getFullYear() && mes == hoy.getMonth() && dia == hoy.getDay()) {
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
		return "<button onclick=\"" + lista[2] + "(" + lista[0] + ")\">" + lista[1] + "</button>";
	},
	image : function(valor) {
		return "<img src=\"" + valor + "\"/>";
	}
};

function ajaxAsyncGet(url, data, callback) {
	$.ajax({
		type : "get",
		url : url,
		data : data,
		async : false,
		dataType : "json",
		success : callback
	});
}

function ajaxAsyncGetHtml(url, data, callback) {
	$.ajax({
		type : "get",
		url : url,
		data : data,
		async : false,
		dataType : "html",
		success : callback
	});
}

function ajaxAsyncPost(url, data, callback) {
	$.ajax({
		type : "post",
		url : url,
		data : data,
		async : false,
		dataType : "json",
		success : callback
	});
}

function ajaxAsync(url, data, method, callback, callbackError) {
	$.ajax({
		type : method,
		url : url,
		data : data,
		async : false,
		dataType : "json",
		success : callback
	});
}

function ajaxAsync(url, data, method, dataType, callback) {
	$.ajax({
		type : method,
		url : url,
		data : data,
		async : false,
		dataType : dataType,
		success : callback
	});
}

function ajaxSync(url, data, method, callback) {
	$.ajax({
		type : method,
		url : url,
		data : data,
		async : false,
		dataType : "json",
		success : callback
	});
}

function ajaxSyncMap(map) {
	// consola(map);
	$.ajax(map);
}

function openDialog(url, data) {
	ajaxSyncMap({
		type : "get",
		url : context + url,
		async : false,
		data : data,
		dataType : "html",
		success : function(html) {
			$("#dialogo").html("");
			$("#dialogo").html(html);
			$("#dialogo").dialog("open");
		}
	});
}

function crearDialogos() {
	$("#dialogo").dialog({
		autoOpen : false,
		resizable : true,
		draggable : true,
		width : 'auto',
		modal : true
	});

	$("#error").dialog({
		autoOpen : false,
		resizable : false,
		draggable : false,
		width : 300,
		minHeight : 30,
		modal : true,
		buttons : {
			OK : function() {
				$(this).dialog("close");
			}
		}
	}).siblings(".ui-widget-header").addClass("ui-state-error");

	$("#mensaje").dialog({
		autoOpen : false,
		resizable : false,
		draggable : false,
		width : 300,
		minHeight : 30,
		modal : true,
		buttons : {
			OK : function() {
				$(this).dialog("close");
			}
		}
	});
}

function error(texto) {
	$("#error").text(texto);
	$("#error").dialog("open");
}

function mensaje(texto) {
	$("#mensaje").text(texto);
	$("#mensaje").dialog("open");
}

function mensajeConfirmacion(texto) {
	$("#mensaje").text(texto);
	$("#mensaje").dialog("open");
	return true;
}

// function cargarLista(entidad) {
//
// var mydata = [ {
// id : "1",
// invdate : "2010-05-24",
// name : "test",
// note : "note",
// tax : "10.00",
// total : "2111.00"
// }, {
// id : "2",
// invdate : "2010-05-25",
// name : "test2",
// note : "note2",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "3",
// invdate : "2007-09-01",
// name : "test3",
// note : "note3",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "4",
// invdate : "2007-10-04",
// name : "test",
// note : "note",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "5",
// invdate : "2007-10-05",
// name : "test2",
// note : "note2",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "6",
// invdate : "2007-09-06",
// name : "test3",
// note : "note3",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "7",
// invdate : "2007-10-04",
// name : "test",
// note : "note",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "8",
// invdate : "2007-10-03",
// name : "test2",
// note : "note2",
// amount : "300.00",
// tax : "21.00",
// total : "320.00"
// }, {
// id : "9",
// invdate : "2007-09-01",
// name : "test3",
// note : "note3",
// amount : "400.00",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "11",
// invdate : "2007-10-01",
// name : "test",
// note : "note",
// amount : "200.00",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "12",
// invdate : "2007-10-02",
// name : "test2",
// note : "note2",
// amount : "300.00",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "13",
// invdate : "2007-09-01",
// name : "test3",
// note : "note3",
// amount : "400.00",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "14",
// invdate : "2007-10-04",
// name : "test",
// note : "note",
// amount : "200.00",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "15",
// invdate : "2007-10-05",
// name : "test2",
// note : "note2",
// amount : "300.00",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "16",
// invdate : "2007-09-06",
// name : "test3",
// note : "note3",
// amount : "400.00",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "17",
// invdate : "2007-10-04",
// name : "test",
// note : "note",
// amount : "200.00",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "18",
// invdate : "2007-10-03",
// name : "test2",
// note : "note2",
// amount : "300.00",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "19",
// invdate : "2007-09-01",
// name : "test3",
// note : "note3",
// amount : "400.00",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "21",
// invdate : "2007-10-01",
// name : "test",
// note : "note",
// amount : "200.00",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "22",
// invdate : "2007-10-02",
// name : "test2",
// note : "note2",
// amount : "300.00",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "23",
// invdate : "2007-09-01",
// name : "test3",
// note : "note3",
// amount : "400.00",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "24",
// invdate : "2007-10-04",
// name : "test",
// note : "note",
// amount : "200.00",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "25",
// invdate : "2007-10-05",
// name : "test2",
// note : "note2",
// amount : "300.00",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "26",
// invdate : "2007-09-06",
// name : "test3",
// note : "note3",
// amount : "400.00",
// tax : "30.00",
// total : "430.00"
// }, {
// id : "27",
// invdate : "2007-10-04",
// name : "test",
// note : "note",
// amount : "200.00",
// tax : "10.00",
// total : "210.00"
// }, {
// id : "28",
// invdate : "2007-10-03",
// name : "test2",
// note : "note2",
// amount : "300.00",
// tax : "20.00",
// total : "320.00"
// }, {
// id : "29",
// invdate : "2007-09-01",
// name : "test3",
// note : "note3",
// amount : "400.00",
// tax : "30.00",
// total : "430.00"
// } ];
//
// jQuery("#lista").jqGrid(
// {
// data : mydata,
// datatype : "local",
// rowNum : 10,
// rowList : [ 10, 20, 30 ],
// colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax',
// 'Total', 'Notes' ],
// colModel : [ {
// name : 'id',
// index : 'id',
// width : 60,
// sorttype : "int"
// }, {
// name : 'invdate',
// index : 'invdate',
// width : 90,
// sorttype : "date",
// formatter : "date"
// }, {
// name : 'name',
// index : 'name',
// width : 100
// }, {
// name : 'amount',
// index : 'amount',
// width : 80,
// align : "right",
// sorttype : "float",
// formatter : "number"
// }, {
// name : 'tax',
// index : 'tax',
// width : 80,
// align : "right",
// sorttype : "float"
// }, {
// name : 'total',
// index : 'total',
// width : 80,
// align : "right",
// sorttype : "float"
// }, {
// name : 'note',
// index : 'note',
// width : 150,
// sortable : false
// } ],
// pager : "#pages",
// viewrecords : true,
// caption : "Manipulating Array Data"
// });
// jQuery("#lista").jqGrid('setGridWidth', layoutConeinerCenter.width() - 20,
// 'true');
// jQuery("#lista").jqGrid('setGridHeight',
// layoutConeinerCenter.height() - 125, 'true');
//
// }
