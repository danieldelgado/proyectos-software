var context = null;
var menu = null;
var lista=null;
var tabGeneral=null;
var tabprincipal = null;
var layoutConeinerCenter=null;

$(function() {   
	init();
	cargarMenus();    
});

function init(){
	
	$('body').layout({ applyDefaultStyles: true });
	
	$.ajaxSetup({
		cache: false
	});

	context = $("#context").val();
	layoutConeinerCenter = $(".ui-layout-center");
	tabGeneral = $("#tabs");
	tabGeneral.resizable();
	tabGeneral.tabs();
	tabprincipal =  $("#tabprincipal");	
	cargarLista("Parametro");
}

function cargarMenus(){
	
	$( "#menu" ).accordion({
        heightStyle: "fill",
        icons: {
            header: "ui-icon-circle-arrow-e",
            activeHeader: "ui-icon-circle-arrow-s"
        	}
    });
	
	 $( "#menu-resizer" ).resizable({
         minHeight: "100%",
         minWidth: "100%",
         resize: function() {
             $( "#accordion" ).accordion( "refresh" );
         }
     });
	 
	$(".oplink").click( function() {
		var d = $(this).parent();
		var url = d.find(".url");		
		cargarLista($(url).val());
	});
	
	$(".clNuevo").button().click( function() {
		var d = $(this).parent();
		var codigo = d.find(".codigo");
		var codigo = d.find(".codigo");	
		var icono = d.find(".icono");	
		var onComplete = d.find(".onComplete");	
		var onSubmit = d.find(".onSubmit");	
		var parametrosJson = d.find(".parametrosJson");	
		var tipo = d.find(".tipo");	
		var url = d.find(".url");			
		var descripcion = d.find(".descripcion");			
		irPagina(url);		
	});
	
}

function irPagina(url){
	location.href=$(url).val();
}

function cargarLista(pm){	
	
	tabprincipal.html("");
	$.get(context + "principal/obtenerLista/" + pm ,function(lista){		
						
		var nombres=new Array();
		var modelo=new Array();
		var columnas=lista.columnas;

		for( var i=0;i < columnas.length;i++){
			/*if(columnas[i].titulo){
				tituloTabs=columnas[i].codigo;
			}*/
			nombres[i]=columnas[i].cabecera;
			modelo[i]={
				name: columnas[i].atributo,
				index: columnas[i].atributo,
				width: columnas[i].ancho,
				//align: columnas[i].alineacion,
				//hidden: !columnas[i].visible,
				//formatter: formateadores[columnas[i].tipo],
				searchoptions: {
					sopt: ['cn','eq']
				}
			};

		}
		
		tabprincipal.append("<table id=\"lista\"></table> <div id=\"pager\"></div>");
		tabprincipal.append("<input type=\"hidden\" id=\"sizelista\" value=\"${size}\" />");
		
		var urlData = context + "principal/obtenerDataLista/" + pm;

		$("#lista").jqGrid({
			url: urlData,
			datatype: "json",
			jsonReader: {
				root: "data",
				repeatitems: false,
				id: "id"
			},
			rowList: [10,20,30],
		   	colNames:['id','campo', 'valor'],
		   	colModel:[
		   		{name:'id',index:'id', width:60},
		   		{name:'campo',index:'campo', width:90},
		   		{name:'valor',index:'valor', width:100}
		   	],
		   	pager: "#pager",
		   	viewrecords: true,
		   	//caption: lista.nombre,
		   	page: 1,
			rowNum: "20",
			rowList: [5,10,20,30],
			width: tabprincipal.width() ,
			height: layoutConeinerCenter.height() - (layoutConeinerCenter.height()/5),
			hidegrid: false,
			loadComplete: function(json){
				//mensaje_consola("json:");
			}
			
			
		}).resizable();
		$("#lista").jqGrid('navGrid','#pager',{
			edit: false,
			add: false,
			del: false,
			search: true
		});

		
	});
	
}

function mensaje_consola(objeto) {		
	//if (!window.console) {
	if($.browser.msie && $.browser.version < 9){
		alert(msj);		
	}else{
		console.log(objeto);
	}
}

var formateadores={
	fecha: function(valor){
		var fecha=new Date(valor);
		var anio=fecha.getFullYear();
		var mes=fecha.getMonth();
		var dia=fecha.getDay();
		var hoy=new Date();
		if(anio == hoy.getFullYear() && mes == hoy.getMonth() && dia == hoy.getDay()){
			var minT=fecha.getMinutes();

			if(fecha.getMinutes() < 10){
				minT="0" + minT;
			}
			return fecha.getHours() + ":" + minT;
		}
		if(dia < 10){
			dia="0" + dia;
		}
		var mesF=mes + 1;
		if(mesF + 1 < 10){
			mesF="0" + mesF;
		}
		var minutos=fecha.getMinutes();
		if(minutos < 10){
			minutos="0" + minutos;
		}

		var hora=fecha.getHours();
		if(hora < 10){
			hora="0" + hora;
		}
		fechaF=dia + "/" + mesF + "/" + anio + " " + hora + ":" + minutos;
		return fechaF;
	},
	boton: function(valor){
		var lista=valor.split("-");
		return "<button onclick=\"" + lista[2] + "(" + lista[0] + ")\">" + lista[1] + "</button>";
	},
	image: function(valor){
		return "<img src=\"" + valor + "\"/>";
	}
};
