var cboDocumento=null;
var cboSexo=null;
var cboEstadoCivil=null;
var cboSituacionLavoral=null;
var cboDepartamento=null;
var cboProvincia=null;

$(function() {

	cboDocumento = $("#documento");
	cboSexo = $("#sexo");
	cboEstadoCivil = $("#ecivil");
	cboSituacionLavoral = $("#situacionLaboral");
	cboDepartamento = $("#departamento");
	cboProvincia = $("#provincia");

	cboDepartamento.change(function(){
		cargarProvincia($(this).val());
	});

	cargarDocumento();
	cargarSexo();
	cargarEstadoCivil();
	cargarSituacionLavoral();
	cargarDepartamento();
});

function cargarDocumento(){

	var doc = null;
	
	$.ajax({
		url: "../js/data/jsonDocumento.txt",
		type: "GET",
		dataType: "json",
		success: function(source){
			doc = source;
			$(doc).each(function(i,item){
				$(cboDocumento).append("<option value="+item.id+" title='"+item.descripcion+"'>"+item.descripcion+"</option>");
			});
		}
	});		
	
}

function cargarSexo(){
	var sexo = null;
	
	$.ajax({
		url: "../js/data/jsonSexo.txt",
		type: "GET",
		dataType: "json",
		success: function(source){
			sexo = source;
			$(sexo).each(function(i,item){
				$(cboSexo).append("<option value="+item.id+"  title='"+item.descripcion+"' >"+item.descripcion+"</option>");
			});
		}
	});	
}

function cargarEstadoCivil(){
	var estado = null;
	
	$.ajax({
		url: "../js/data/jsonEstadosCivil.txt",
		type: "GET",
		dataType: "json",
		success: function(source){
			estado = source;
			$(estado).each(function(i,item){
				$(cboEstadoCivil).append("<option value="+item.id+"  title='"+item.descripcion+"'>"+item.descripcion+"</option>");
			});

		}
	});	
}

function cargarSituacionLavoral(){
	var situacion = null;
	$.ajax({
		url: "../js/data/jsonSituacionLaboral.txt",
		type: "GET",
		dataType: "json",
		success: function(source){
			situacion = source;
			$(situacion).each(function(i,item){
				$(cboSituacionLavoral).append("<option value="+item.id+" title='"+item.descripcion+"'>"+item.descripcion+"</option>");
			});

		}
	});	
}

function cargarDepartamento(){

	var departamento = null;
	$.ajax({
		url: "../js/data/jsonDepartamentos.txt",
		type: "GET",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(source){
				departamento = source;
				$(departamento).each(function(i,item){
					$(cboDepartamento).append("<option value="+item.id+" title='"+item.descripcion+"'>"+item.descripcion+"</option>");
				});
		}
	});		
}

function cargarProvincia(dept){
	var provinc = null;
	$.ajax({
		url: "../js/data/jsonProvincias.txt",
		type: "GET",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(source){
			provinc = source;
			cboProvincia.html("");			
			$(cboProvincia).append("<option value='0'>Seleccionar</option>");
			$(provinc).each(function(i,item){
				if(dept>0){
					if(item.id_departamento == dept){
						
						$(cboProvincia).append("<option value="+item.id+" title='"+item.descripcion+"'>"+item.descripcion+"</option>");
					}
				}
			});
		},
        error:function (xhr, ajaxOptions, thrownError){
                
        }
	});	
}

function cargarDataMensajeError(){
	
	var departamento = null;
	$.ajax({
		async: false,
		url: "../js/data/jsonMensajeErrores.txt",
		type: "GET",
		dataType: "json",
		success: function(source){
			msjError = source;
		}
	});		
}

