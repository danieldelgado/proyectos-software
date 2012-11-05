var context = null;
var menu = null;
var lista=null;
var tabGeneral=null;
var tabsLista = null;
$(function() {   
	init();
	cargarMenus();    
});

function init(){
	
	$.ajaxSetup({
		cache: false
	});
	
	context = $("#context").val();
	tabsLista =  $("#tabsLista");
	
}

function cargarMenus(){
	menu = $("#menu");
	var menus = $(".menus");
	menus.click(function() {
		
		
		
	});
}


function cargarLista(pm){	
	mensaje_consola("pm:"+pm);
	tabsLista.html("");
	$.get(context + "principal/obtenerLista/" + pm ,function(lista){		
		mensaje_consola(lista);
				
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
				align: columnas[i].alineacion,
				hidden: !columnas[i].visible,
				//formatter: formateadores[columnas[i].tipo],
				searchoptions: {
					sopt: ['cn','eq']
				}
			};

		}

		mensaje_consola("nombres:");
		mensaje_consola(nombres);
		mensaje_consola("modelo:");
		mensaje_consola(modelo);
		
		tabsLista.append("<table id=\"lista\"></table> " +
						 "<div id=\"pager\"></div>");
		tabsLista.append("<input type=\"hidden\" id=\"sizelista\" value=\"${size}\" />");
		
		var urlData = context + "principal/obtenerDataLista/" + pm;
		

		/*var mydata = [
				{id:"1",invdate:"2010-05-24",name:"test",note:"note",tax:"10.00",total:"2111.00"} ,
				{id:"2",invdate:"2010-05-25",name:"test2",note:"note2",tax:"20.00",total:"320.00"},
				{id:"3",invdate:"2007-09-01",name:"test3",note:"note3",tax:"30.00",total:"430.00"},
				{id:"4",invdate:"2007-10-04",name:"test",note:"note",tax:"10.00",total:"210.00"},
				{id:"5",invdate:"2007-10-05",name:"test2",note:"note2",tax:"20.00",total:"320.00"},
				{id:"6",invdate:"2007-09-06",name:"test3",note:"note3",tax:"30.00",total:"430.00"},
				{id:"7",invdate:"2007-10-04",name:"test",note:"note",tax:"10.00",total:"210.00"},
				{id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"21.00",total:"320.00"},
				{id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"11",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"12",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"13",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"14",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"15",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"16",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"17",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"18",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"19",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"21",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"22",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"23",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"24",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"25",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"26",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"27",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"28",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"29",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
			];
		
		$("#lista").jqGrid({
			data: mydata,
			datatype: "local",
			height: 150,
			rowNum: 10,
			rowList: [10,20,30],
		   	colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
		   	colModel:[
		   		{name:'id',index:'id', width:60},
		   		{name:'invdate',index:'invdate', width:90, sorttype:"date"},
		   		{name:'name',index:'name', width:100},
		   		{name:'amount',index:'amount', width:80, align:"right",sorttype:"float"},
		   		{name:'tax',index:'tax', width:80, align:"right",sorttype:"float"},		
		   		{name:'total',index:'total', width:80,align:"right",sorttype:"float"},		
		   		{name:'note',index:'note', width:150, sortable:false}		
		   	],
		   	pager: "#pager",
		   	viewrecords: true,
		   	caption: "Manipulating Array Data"
		});
		*/
		
		
		$("#lista").jqGrid({
			url: urlData,
			datatype: "json",
			hidegrid: false,
			width: tabsLista.width(),
			height: tabsLista.height() ,
			colNames: nombres,
			colModel: modelo,
			rowNum: function(){
				return $("#sizeLista").val();
			},
			jsonReader: {
				root: "data",
				repeatitems: false,
				id: "id"
			},
			caption: lista.nombre,
			//onSelectRow: verDetalle,
			page: 1,
			pager: "#pager",
			rowNum: "20",
			rowList: [5,10,20,30],
			loadComplete: function(json){
				mensaje_consola(json);
				/*$(json.data).each(function(){
					if(this.leido != null){
						if(!this.leido){
							// alert("leido");
							var id=this.id;

							var trElement=$("#" + id,jQuery('#lista'));
							// trElement.css("font-weight","bold");
							trElement.attr("class","jqgrow ui-row-ltr ui-state-active");
							trElement.hover(function(){
								$(this).removeClass("ui-state-active");
							},function(){
								$(this).addClass("ui-state-active");
							});
						}
					}
				});*/
			}
		});

	/*	$("#lista").jqGrid('navlista','#pager',{
			edit: false,
			add: false,
			del: false,
			search: true
		});

		*/
		
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


