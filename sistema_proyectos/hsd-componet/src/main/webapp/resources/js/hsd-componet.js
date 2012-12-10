var context = null;
var menu = null;
var lista = null;
var tabs = null;
var tabprincipal = null;
var ent = null;
var layoutConeinerCenter = null;
var count = 1;
var mostrarMsj = false;
var myLayout;
var uilayoutwest;

$(function() {
	init();
	cargarMenus();
	crearTab();
	cargarLista(ent);
});

function init() {
	mostrarMsj = $("#consolemessage").val();
	context = $("#context").val();
	ent = "Parametro";
	uilayoutwest = $(".ui-layout-west");
	layoutConeinerCenter = $(".ui-layout-center");

	myLayout = $('body').layout(
			{
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
						jQuery("#lista").jqGrid('setGridWidth',paneState.innerWidth - 20, 'true');
						jQuery("#lista").jqGrid('setGridHeight',paneState.innerHeight - 125, 'true');
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
		var functions = li.find(".function").val();
		var url = li.find(".url").val();
		var tipo = li.find(".tipo").val();
		if (tipo == "interno") {
			$.ajax({
				type : "get",
				url : context + "principal/obtenerLista/" + url,
				async : false,
				dataType : "json",
				success : function(resp) {

				}
			});

		}
	});

}

function crearTab() {
	tabs = $(".ui-layout-center");
	tabs.html("");
	tabs.html("<ul></ul>");

	// <ul>
	// <li><a href="#tabs-center-1">Nunc tincidunt</a></li>
	// <li><a href="#tabs-center-2">Proin dolor</a></li>
	// </ul>
	// <div id="tabs-center-1" style="font-size: 10px;">
	//
	// <table id="list47"></table>
	// <div id="plist47"></div>
	//	
	//	
	//
	// </div>
	// <div id="tabs-center-2">
	// <P>Morbi tincidunt, dui sit s.</P>
	// </div>

	tabs.tabs({
						collapsible : true,
						fxAutoHeight : true,
						cache : true,
						tabTemplate : "<li><a href=\"#{href}\"> #{label} </a> <span class=\"ui-icon ui-icon-close\">Cerrar</span></li>",
						add : function(event, ui) {
						},
						select : function(event, ui) {
						}
					}).find(".ui-tabs-nav").sortable({
				axis : 'x',
				zIndex : 2
			});
//	tabs.find("span.ui-icon-close").live("click", function() {
//		var index = $("li", tabs).index($(this).parent());
//		if (index >= 0) {
//			var tab = $(this).parent().find("a").attr("href");
//			if (tab != "#tabPrincipal") {
//				tabs.tabs("remove", index);
//			}
//		}
//	});	
	addtab("Principal", "tabPrincipal", '<table id="lista"></table><div id="pager"></div>');
	tabprincipal = $("#tabPrincipal");
//	tabs.tabs("select","#tabPrincipal");
}

function addtab(titulo, identificador, content,select) {
	if ($("#" + identificador).length <= 0) {
		tabs.append('<div id="' + identificador + '"> ' + content + '</span>');
		tabs.tabs("add", "#" + identificador, titulo);
	}
	if(select){
		tabs.tabs("select","#"+identificador);
	}
}

detalleLista = function(id, cap) {
	// consola("detalleLista:"+id+" "+cap);
};

function irPagina(url) {
	// url = context + url;
	// $(location).attr('href', url);
}


function cargarLista(pm) {
	if (diferenteNull(pm)) {

		$.get(context + "principal/obtenerLista/" + pm,
						function(lista) {
							var nombres = new Array();
							var modelo = new Array();
							var columnas = lista.columnas;
							for ( var i = 0; i < columnas.length; i++) {
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

							tabprincipal.append("<input type=\"hidden\" id=\"sizelista\" value=\"${size}\" />");

							var urlData = context+ "principal/obtenerDataLista/" + pm;
							
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
									name : 'nombre',
									index : 'nombre',
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
							
							jQuery("#lista").jqGrid('setGridWidth', layoutConeinerCenter.width() - 20,'true');
							jQuery("#lista").jqGrid('setGridHeight',layoutConeinerCenter.height() - 125, 'true');
							
						});

	}

}

function consola(objeto) {
	// if (!window.console) {
	// alert($.browser.msie);
	if (mostrarMsj == "true") {
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





//function cargarLista(entidad) {
//
//	var mydata = [ {
//		id : "1",
//		invdate : "2010-05-24",
//		name : "test",
//		note : "note",
//		tax : "10.00",
//		total : "2111.00"
//	}, {
//		id : "2",
//		invdate : "2010-05-25",
//		name : "test2",
//		note : "note2",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "3",
//		invdate : "2007-09-01",
//		name : "test3",
//		note : "note3",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "4",
//		invdate : "2007-10-04",
//		name : "test",
//		note : "note",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "5",
//		invdate : "2007-10-05",
//		name : "test2",
//		note : "note2",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "6",
//		invdate : "2007-09-06",
//		name : "test3",
//		note : "note3",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "7",
//		invdate : "2007-10-04",
//		name : "test",
//		note : "note",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "8",
//		invdate : "2007-10-03",
//		name : "test2",
//		note : "note2",
//		amount : "300.00",
//		tax : "21.00",
//		total : "320.00"
//	}, {
//		id : "9",
//		invdate : "2007-09-01",
//		name : "test3",
//		note : "note3",
//		amount : "400.00",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "11",
//		invdate : "2007-10-01",
//		name : "test",
//		note : "note",
//		amount : "200.00",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "12",
//		invdate : "2007-10-02",
//		name : "test2",
//		note : "note2",
//		amount : "300.00",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "13",
//		invdate : "2007-09-01",
//		name : "test3",
//		note : "note3",
//		amount : "400.00",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "14",
//		invdate : "2007-10-04",
//		name : "test",
//		note : "note",
//		amount : "200.00",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "15",
//		invdate : "2007-10-05",
//		name : "test2",
//		note : "note2",
//		amount : "300.00",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "16",
//		invdate : "2007-09-06",
//		name : "test3",
//		note : "note3",
//		amount : "400.00",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "17",
//		invdate : "2007-10-04",
//		name : "test",
//		note : "note",
//		amount : "200.00",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "18",
//		invdate : "2007-10-03",
//		name : "test2",
//		note : "note2",
//		amount : "300.00",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "19",
//		invdate : "2007-09-01",
//		name : "test3",
//		note : "note3",
//		amount : "400.00",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "21",
//		invdate : "2007-10-01",
//		name : "test",
//		note : "note",
//		amount : "200.00",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "22",
//		invdate : "2007-10-02",
//		name : "test2",
//		note : "note2",
//		amount : "300.00",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "23",
//		invdate : "2007-09-01",
//		name : "test3",
//		note : "note3",
//		amount : "400.00",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "24",
//		invdate : "2007-10-04",
//		name : "test",
//		note : "note",
//		amount : "200.00",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "25",
//		invdate : "2007-10-05",
//		name : "test2",
//		note : "note2",
//		amount : "300.00",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "26",
//		invdate : "2007-09-06",
//		name : "test3",
//		note : "note3",
//		amount : "400.00",
//		tax : "30.00",
//		total : "430.00"
//	}, {
//		id : "27",
//		invdate : "2007-10-04",
//		name : "test",
//		note : "note",
//		amount : "200.00",
//		tax : "10.00",
//		total : "210.00"
//	}, {
//		id : "28",
//		invdate : "2007-10-03",
//		name : "test2",
//		note : "note2",
//		amount : "300.00",
//		tax : "20.00",
//		total : "320.00"
//	}, {
//		id : "29",
//		invdate : "2007-09-01",
//		name : "test3",
//		note : "note3",
//		amount : "400.00",
//		tax : "30.00",
//		total : "430.00"
//	} ];
//
//	jQuery("#lista").jqGrid(
//			{
//				data : mydata,
//				datatype : "local",
//				rowNum : 10,
//				rowList : [ 10, 20, 30 ],
//				colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax',
//						'Total', 'Notes' ],
//				colModel : [ {
//					name : 'id',
//					index : 'id',
//					width : 60,
//					sorttype : "int"
//				}, {
//					name : 'invdate',
//					index : 'invdate',
//					width : 90,
//					sorttype : "date",
//					formatter : "date"
//				}, {
//					name : 'name',
//					index : 'name',
//					width : 100
//				}, {
//					name : 'amount',
//					index : 'amount',
//					width : 80,
//					align : "right",
//					sorttype : "float",
//					formatter : "number"
//				}, {
//					name : 'tax',
//					index : 'tax',
//					width : 80,
//					align : "right",
//					sorttype : "float"
//				}, {
//					name : 'total',
//					index : 'total',
//					width : 80,
//					align : "right",
//					sorttype : "float"
//				}, {
//					name : 'note',
//					index : 'note',
//					width : 150,
//					sortable : false
//				} ],
//				pager : "#pages",
//				viewrecords : true,
//				caption : "Manipulating Array Data"
//			});
//	jQuery("#lista").jqGrid('setGridWidth', layoutConeinerCenter.width() - 20,
//			'true');
//	jQuery("#lista").jqGrid('setGridHeight',
//			layoutConeinerCenter.height() - 125, 'true');
//
//}
