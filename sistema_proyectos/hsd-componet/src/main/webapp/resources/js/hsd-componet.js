var context = null;
var menu = null;
var lista=null;
var tabGeneral=null;
var tabprincipal = null;
var layoutConeinerCenter=null;
var ent = null;
$(function() {   
	init();
	cargarMenus();
	cargarEnlaces();
});

function init(){
	
	$('body').layout({ 
		applyDefaultStyles: true,
		west__size: 300
	});
	
	$.ajaxSetup({
		cache: false
	});

	context = $("#context").val();
	layoutConeinerCenter = $(".ui-layout-center");	
	tabGeneral = $("#tabs");
	if(tabGeneral!=null){		
		crearTab();
		tabprincipal =  $("#tabprincipal");			
		ent =  $("#ent").val();
		if(ent!=null){
			cargarLista(ent);			
		}	
	}
		
}

function crearTab(){
	
	tabGeneral.resizable();
	tabGeneral.tabs({
			cache: true,
			tabTemplate: "<li><a href=\"#{href}\">#{label}</a><span class=\"ui-icon ui-icon-close\">Cerrar</span></li>",
			add: function(event,ui){
				
				var pad=$(ui.panel).css("padding-top");				
				pad=pad.substring(0,pad.indexOf("px"));				
				$(ui.panel).height(tabGeneral.height() - $(".ui-tabs-nav",tabGeneral).height() - 2 * pad - 4);				
				if(ui.panel.id == "tabprincipal"){					
					$(ui.tab).siblings("span").remove();					
				}
				
				tabGeneral.tabs("select","#" + ui.panel.id);
				
				}		
			}
	);
	
	/*var pad=tabGeneral.css("padding-top");
	pad=pad.substring(0,pad.indexOf("px"));
	var pie=4;
	if($("#pie")){
		pie+=$("#pie").height();
	}
	
	tabGeneral.height($("#centro").height() - 2 * pad - pie);
*/
	tabGeneral.find("span.ui-icon-close").live("click",function(){
		var index=$("li",tabGeneral).index($(this).parent());
		if(index >= 0){
			var tab=$(this).parent().find("a").attr("href");			
			tabGeneral.tabs("remove",index);
		}
	});
	
	
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
        minHeight: 300,
        minWidth: 170,
        resize: function() {
            $( "#menu" ).accordion( "refresh" );
        }
    });
		
}

function cargarEnlaces(){
	
	$(".oplink").click( function() {
		var d = $(this).parent();
		var url = d.find(".url").val();	
		irPagina(url);	
	});
	
	$(".clNuevo").button().click( function() {
		var d = $(this).parent();
		var codigo = d.find(".codigo").val();
		var icono = d.find(".icono").val();	
		var onComplete = d.find(".onComplete").val();	
		var onSubmit = d.find(".onSubmit").val();	
		var parametrosJson = d.find(".parametrosJson").val();	
		var tipo = d.find(".tipo").val();	
		var url = d.find(".url").val();			
		var descripcion = d.find(".descripcion").val();	
		manejoTabs(url , tipo , "codigo"  );
		
		
	});
	
}

function manejoTabs(url , tipo ,  codigo ){
	codigo = "#"+codigo;
	if($(codigo).length <= 0){
		tabGeneral.tabs("add",codigo,"titulo");		
	}else{
		tabGeneral.tabs("select",codigo);
	}	
}

detalleLista = function(id,cap){
	mensaje_consola(id);
	mensaje_consola(cap);
}

function irPagina(url){
	url = context + url;
	$(location).attr('href',url);
}

function cargarLista(pm){	
	if(diferenteNull(pm)){
		
		tabprincipal.html("");
		$.get(context + "principal/obtenerLista/" + pm ,function(lista){		
							
			tabGeneral.tabs("remove",0);
			tabGeneral.tabs("add","#tabPrincipal",pm,0);
			
			
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
				onSelectRow: detalleLista,
			   	page: 1,
				rowNum: "20",
				rowList: [5,10,20,30],
				width: tabprincipal.width() ,
				height: layoutConeinerCenter.height() - (layoutConeinerCenter.height()/5),
				hidegrid: false,
				loadComplete: function(json){
					//mensaje_consola("json:");
				}
				
				
			});
			
			$("#lista").jqGrid('navGrid','#pager',{
				edit: false,
				add: false,
				del: false,
				search: true
			});

			
		});
		
	}
	
}

function mensaje_consola(objeto) {		
	//if (!window.console) {
	if($.browser.msie && $.browser.version < 9){
		alert(msj);		
	}else{
		console.log(objeto);
	}
}

function diferenteNull(objeto) {
	objeto = $.trim(objeto);	
	if(objeto!=null && objeto!=""){
		return true;
	}
	return false;
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
