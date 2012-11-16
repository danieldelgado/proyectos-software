var formulario = null;
var validateForm = null;
var settings = null;
var valSeleccionado = null;
var msjError = null;
var qS = "";
$(function() {
	
	formulario = $("#formRegistro");
	
	$("#btnActualizarCaptcha").click(function(){
			refreshImage('imgCaptcha');
	});
	
	var cboDia =  $("#dia");
	cboDia.html("");
	cboDia.append("<option value = 0>Día</option>");
	for (var i = 1;i<=30 ; i++){		
		cboDia.append("<option value = "+i+">"+i+"</option>");		
	}

	$("#dia").change(function(){
		valSeleccionado = $("#dia").val();
		asignarFechaNacimiento($("#anno"),$("#mes"),$("#dia"));
	});

	$("#mes").change(function(){
		llenarDias(valSeleccionado,$("#mes"),$("#anno"));
		asignarFechaNacimiento($("#anno"),$("#mes"),$("#dia"));
	});	
	
	$("#anno").change(function(){
		llenarDias(valSeleccionado,$("#mes"),$("#anno"));
		asignarFechaNacimiento($("#anno"),$("#mes"),$("#dia"));
	});

	$("#email").attr("maxlength",100);
	$("#renta").attr("maxlength",12);
	$("#telefono").attr("maxlength",13);
	
	$("input[name=renta]").keydown(function(event) {
            soloNumeros(event);
    });
	
	cargarAños();
	cargarPlaceHolder(1);
	cargarMensajesError();
	validarFormulario();

	$("#bntRegistro").click(function(){	
			//$("input[name=dtI]").val("jsa");	
			formulario.submit();
	});
	
	
});

function obtenerUrl(cadena){
		var queryStringAux=cadena;
		if(document.location.href.indexOf('?')!=-1){
			queryStringAux = queryStringAux + document.location.href.substring(document.location.href.indexOf('?'));
		}
		location.href=queryStringAux;
	}
function obtenerUrlPOST(){
		if(document.location.href.indexOf('?')!=-1){
			qS = document.location.href.substring(document.location.href.indexOf('?'));
		}
}

function cargarMensajesError(){	
	cargarDataMensajeError();	
	$(msjError).each(function(index, element) {        
		msjError = element;
    });
}


function validarFormulario(){	
	validateForm = formulario.validate({
		ignore: "input[type='text']:hidden",	
		rules: {
			nombres:{required: true,diferente:"Nombres",minlength: 2,maxlength: 100},
			apellidos: {required: true,diferente:"Apellidos",minlength: 2,maxlength: 100},
			hiddendocumento: { required: true, valorMayor_0: true}, 
      		nrodocumento: { requiredDoc:true, required: true,diferente:"N° de documento",limite:true},		
      		hiddenecivil: { required : true, valorMayor_0 : true},
      		hiddendepartamento :{required: true,valorMayor_0: true},
      		hiddenprovincia :{required: true,valorMayor_0: true},
      		hiddensituaLab : {required: true,valorMayor_0: true},
			ruc:{ required: true,diferente: "RUC" , number: true,minlength: 11,maxlength: 11},	
      		renta:	{ required: true,diferente:"Renta Bruta Mensual S/.",valorMayor_0: true,limiteFormatoMoneda:true},
      		email : { required: true, diferente : "Correo Electrónico" , maxlength: 100,validarEmail : true },
      		fchNacimiento : { required: true ,minlength: 10,maxlength: 10 ,edadMinima:18},
      		telefono:	{ required: true, number: true,minlength: 7,maxlength: 13,diferente:"Teléfono"},
      		captcha :{required: true,diferente :"Ingresar el  código",validarCaptcha: true,maxlength: 8}
			},
			messages: msjError,	
		invalidHandler: function(form, validator) {
			var errors = validator.numberOfInvalids();
			if (errors) {                    
				var element = validator.errorList[0].element;
				if(element.tagName == "input"){					
					element.focus();
				}
			}	
	    },
		showErrors: function(errorMap, errorList) {
			
			limpiarColores();

			$(errorList).each(function(i,item){
				var campo =  item.element ; 
				var id = $(campo).attr("id");
				var idMSJ = "#"+"id_"+id;
				var campo =  item.element ; 
				var name = $(campo).attr("name");
				$(campo).css({"background-color" : "#fddbca"});
								
				if(name=="hiddendepartamento"){
					$("select[name=departamento]").css({"background-color" : "#fddbca"});
				}
				if(name=="hiddenprovincia"){
					$("select[name=provincia]").css({"background-color" : "#fddbca"});
				}
				if(name=="hiddendocumento"){
					$("select[name=documento]").css({"background-color" : "#fddbca"});
				}
				
				if(name=="hiddenecivil"){
					$("select[name=ecivil]").css({"background-color" : "#fddbca"});
				}
				
				if(name=="hiddensituaLab"){
					$("select[name=situacionLaboral]").css({"background-color" : "#fddbca"});
				}
				
				if(name=="fchNacimiento"){
					$("select[name=anno]").css({"background-color" : "#fddbca"});
					$("select[name=mes]").css({"background-color" : "#fddbca"});
					$("select[name=dia]").css({"background-color" : "#fddbca"});
				}
				var msjdiv =  $(idMSJ);
				msjdiv.html(item.message);
			});
						
			
			$(".msj").each(function(i,item){
				$(item).attr("class","msj");
			});	
			
			$(errorList).each(function(i,item){				
				var campo =  item.element ; 
				var id = $(campo).attr("id");
				var idMSJ = "#"+"id_"+id;
				var msjdiv =  $(idMSJ);
				msjdiv.attr("class","msj most");
				//msjdiv.html(errorList.message);		
			});				
		},
		submitHandler: function(form){
			$("input[name=dtI]").val("jsa");
			$("#bntRegistro").attr("disabled", "disabled");			
			obtenerUrlPOST();			
			$.ajax({
			  async:true,  
              cache:false,
			  type: "POST",
			  url: form.action+qS,//&p="+$("input[name=codProducto]").val()
			  data: formulario.serialize(),
			  success: function(msg){
				//console.log(msg);
				procesarRespuesta(msg);
				$("#bntRegistro").removeAttr("disabled");
			  },
			  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  	var r = $.trim(XMLHttpRequest.responseText);
				//console.log(XMLHttpRequest);
				//console.log(textStatus);
				//console.log(errorThrown);
				try{	
					if(XMLHttpRequest.status==500){		
						location.href = r ;	
					}	
					$("#bntRegistro").removeAttr("disabled");								
				}catch (e){
					alert(e.message);
				}				
			  }
			});
			
		
		
		}
	});	
		
}

function soloNumeros(event){  	
    if ( event.keyCode == 8 || event.keyCode == 9 || (event.keyCode >= 37 && event.keyCode <= 40) || event.keyCode == 110
            || event.keyCode == 188 || event.keyCode == 190  ) {
    } else {
        if ((event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105  || event.keyCode == 110 || event.keyCode == 190 )) {
            event.preventDefault();
        }   
    }
}

function limpiarColores(){
var fonblan= "white";
		$("input[name=nombres]").css({"background-color" : fonblan});
		$("input[name=apellidos]").css({"background-color" : fonblan});
		$("select[name=documento]").css({"background-color" : fonblan});
		$("input[name=nrodocumento]").css({"background-color" : fonblan});		
		$("select[name=ecivil]").css({"background-color" : fonblan});
		$("select[name=situacionLaboral]").css({"background-color" : fonblan});
		$("select[name=departamento]").css({"background-color" : fonblan});
		$("select[name=provincia]").css({"background-color" : fonblan});	
		$("input[name=ruc]").css({"background-color" : fonblan});
		$("select[name=anno]").css({"background-color" : fonblan});
		$("select[name=mes]").css({"background-color" : fonblan});
		$("select[name=dia]").css({"background-color" : fonblan});	
		$("input[name=telefono]").css({"background-color" : fonblan});	
		$("input[name=renta]").css({"background-color" : fonblan});	
		$("input[name=email]").css({"background-color" : fonblan});	
		$("input[name=captcha]").css({"background-color" : fonblan});
}

function procesarRespuesta(r){
	limpiarColores();
	if($(r).size()>0){
		var length = ((r[0])+"").length;
		if(length==1){
			var codProduct= $("input[name=codProducto]").val();			
			location.href = r[1]; 			
			return;
		}
	}
	
	var frojo="#fddbca";
	$(r).each(function(i,item){
		
		if(item==10001){
			$("input[name=nombres]").css({"background-color" : frojo});
		}
		if(item==10002){
			$("input[name=apellidos]").css({"background-color" : frojo});		
		}
		if(item==10003){	
			$("select[name=documento]").css({"background-color" : frojo});
		}
		if(item==10004){
			$("input[name=nrodocumento]").css({"background-color" : frojo});
		}
		if(item==10005){
			$("select[name=ecivil]").css({"background-color" : frojo});
		}
		if(item==10006){
			$("select[name=situacionLaboral]").css({"background-color" : frojo});
		}
		if(item==10007){
			$("select[name=departamento]").css({"background-color" : frojo});
		}
		if(item==10008){
			$("select[name=provincia]").css({"background-color" : frojo});
		}
		if(item==10009){
			$("input[name=ruc]").css({"background-color" : frojo});
		}
		if(item==10010){
			$("select[name=anno]").css({"background-color" : frojo});
			$("select[name=mes]").css({"background-color" : frojo});
			$("select[name=dia]").css({"background-color" : frojo});
		}
		if(item==10012){
			$("input[name=renta]").css({"background-color" : frojo});
		}	
		if(item==10013){
			$("input[name=email]").css({"background-color" : frojo});
		}	
		if(item==10011){
			$("input[name=telefono]").css({"background-color" : frojo});
		}	
		if(item==10014){
			$("input[name=captcha]").css({"background-color" : frojo});
		}
			
	});
			
}

$.validator.addMethod("requiredDoc", function(value, element, params) {
	var resp=false;	
		if(params){		
			//var doc = $("input[name=hiddendocumento]").valid();
			//console.log("doc:"+doc);
			//if(doc==1){
				resp = true;
			//}
		}
	return resp;
});

$.validator.addMethod("limiteFormatoMoneda", function(value, element, params) {
	var resp=false;	
		if(params){
			resp=(/^([0-9])*[.]?[0-9]*$/.test(value));
		}
	return resp;
});

function unformatNumber(num,prefix)  { 

	num = Math.round(parseFloat(num)*Math.pow(10,2))/Math.pow(10,2)  
	prefix = prefix || ''; 
	//console.log("prefix:"+prefix); 
	num += '';  
	//console.log("num:"+num);
	var splitStr = num.split('.');  
	//console.log("splitStr:"+splitStr);
	var splitLeft = splitStr[0];  
	//console.log("splitLeft:"+splitLeft);
	var splitRight = splitStr.length > 1 ? '.' + splitStr[1] : '.00';  
	//console.log("splitRight:"+splitRight);
	splitRight = splitRight + '00';  
	//console.log("splitRight:"+splitRight);
	splitRight = splitRight.substr(0,3);  
	//console.log("splitRight:"+splitRight);
	var regx = /(\d+)(\d{3})/;
	//console.log("regx:"+regx);  
	//console.log("regx.test(splitLeft):"+(regx.test(splitLeft)));  	
	//console.log("prefix + splitLeft + splitRight:"+(prefix + splitLeft + splitRight)); 

	return prefix + splitLeft + splitRight;  
}  



$.validator.addMethod("edadMinima", function(value, element, params) {
	var resp=false;
		//console.log("valu1e:"+value);
		//console.log("dia:"+$("#dia").val());
		//console.log("mes:"+$("#mes").val());
		//console.log("anno:"+$("#anno").val());
	if($("#dia").val()>0&&$("#mes").val()>0&&$("#anno").val()>0){
		
		var f = new Date();

	    f.setYear($("#anno").val());
	    f.setMonth($("#mes").val()-1);
	    f.setDate($("#dia").val());

	    //console.log(f);

		var edad = calcular_edad($("#dia").val(),$("#mes").val()-1,$("#anno").val());
		if(edad>=18){
			resp=true;
		}
	}
//console.log("resp:"+resp);
	return resp;
});

function calcular_edad(dia_nacim,mes_nacim,anio_nacim){
    fecha_hoy = new Date();
    ahora_anio = fecha_hoy.getYear();
    ahora_mes = fecha_hoy.getMonth();
    ahora_dia = fecha_hoy.getDate();
    edad = (ahora_anio + 1900) - anio_nacim;
    if ( ahora_mes < (mes_nacim - 1)){
      edad--;
    }
    if (((mes_nacim - 1) == ahora_mes) && (ahora_dia < dia_nacim)){ 
      edad--;
    }
    if (edad > 1900){
    edad -= 1900;
    }
  return edad;
}

$.fn.alfanumerico = function(){
	return this.each(function() {
		 $(this).keyup(function(e) {
			 var v = $(this).val();
			 if(!(/^[a-z0-9]+$/i.test(v))){
			 	$(this).val(v.substr(0,(v.length-1)));
			 }	
			 return (/^[a-z]+$/i.test(v));
		 });
	});
}
$.fn.alfanumerico = function(limite){
	return this.each(function() {
		 $(this).keyup(function(e) {
			 var v = $(this).val();
			 if(!(/^[a-z0-9]+$/i.test(v))){
				 if(limite==v.length){
			 		$(this).val(v.substr(0,(v.length-1)));
				 }
			 }	
			 return (/^[a-z]+$/i.test(v));
		 });
	});
}

$.fn.limiteMoney = function(){
	return this.each(function() {
		 $(this).blur(function(e) {	
			 validarFormatoMoneda($(this).val(),$(this));		 		
			 return false;
		 });
	});
	
	
}

$.validator.addMethod("validarCaptcha", function(value, element, params) {
	var resp=false;
	$.ajax({
				async:false,  
				type: 'POST',   
				url: "validarCaptcha.asp",
				data: {	captcha:value },
				success:  function(data){ 
						resp = data;
				} 
	}); 
	return resp;
});

$.validator.addMethod("validarEmail", function(value, element, params) {
	var resp=true;
	if(params){	
		var regex = /^([A-Za-z0-9-._])+\@([A-Za-z0-9\-\.])+\.([A-Za-z]{2,4})$/;
		resp=regex.test(value);
	}
	return resp;
});

$.validator.addMethod("limite",function(value, element,params) {
		var resp = false ;
		var select = $("#documento").val();		
		if(params){		
			if(select==2){							
				if((/^[0-9]+$/i.test(value))){	
					if(value.length == 8){						
						resp = true;
					}
				}
			}
			else
			if(select==4){						
				if((/^[a-z0-9]+$/i.test(value))){					
					if(value.length >= 9 && value.length <= 12){						
						resp = true;
					}
				}
			}			
		}	
		return resp;
},""); 

$.validator.addMethod("diferente",function(value, element, params) {
	    if ($(element).val() == params){ 
	        return false; 
	    }else 
	    	return true; 
		}
,""); 

$.validator.addMethod("valorMayor_0",function(value, element) { 
	    if ($(element).val() == "0") { 
	      	return false; 
	    }else 
	    	return true; 
		}	
,""); 

$.fn.ForceNumericOnly = function(){
    return this.each(function() {
        $(this).keydown(function(e) {
            var key = e.charCode || e.keyCode || 0;
			
                return (
                key == 8 || 
                key == 9 ||  
                key == 110 ||
                key == 190 ||
                key == 46 ||
                (key >= 37 && key <= 40) ||
                (key >= 48 && key <= 57) ||
                (key >= 96 && key <= 105)
                );
        });
    });
};

function refreshImage(valImageId) {
	
    var objImage = document.getElementById(valImageId);	
	objImage.src="";
	
	var d = new Date();
  	var milliseconds=d.getTime();
	objImage.src="/captcha.asp?x=" + milliseconds;
	
	if($.browser.msie && $.browser.version <= 6){		
		$.delay(1000);
		var mywindow = window.open("", "mywindow", "location=1,status=1,scrollbars=1,  width=10,height=10,screenX=2100,screenY=2100");
		mywindow.close();		
	}
		
	$("#captcha").focus();
	
}

function validarFormatoMoneda(num,ob){
	//console.log("num:"+num);
		num = parseFloat(num).toFixed(2);
		var r = 0;
		var d = 0;
		if(!(isNaN(num))){
			var enteros = 0;
			var tokenPunto = "."
			var decimales = 0;
			if(num.indexOf(tokenPunto)>0){
				var punt = num.indexOf(tokenPunto);				
				enteros = num.substr(0,punt);
				decimales = num.substr(punt+1,num.length);				
				if(enteros.length>9){
					enteros = enteros.substr(0,9);
					r = enteros;
				}else{
					r = enteros;
				}
				if(decimales.length>2){
					decimales = decimales.substr(0,2);
					d = decimales;
				}else{
					d = decimales;
				}			
				ob.val((parseFloat(r+"."+d).toFixed(2)));
			}else{				
				if((num.length>9)){
					num = num.substr(0,9);						
					r =  num +".00";
				}else{
					r =  num +".00";
				}
				ob.val((parseFloat(r).toFixed(2)));
			}
		}

}

function cargarPlaceHolder(minCantidad){
	$("input[name=nombres]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="Nombres"){
			$(this).val("");
		}
	}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("Nombres");
		}	
		}).alfanumerico();

	$("input[name=apellidos]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="Apellidos"){
			$(this).val("");
		}
	}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("Apellidos");
		}
		}).alfanumerico();
		
	
	$("select[name=provincia]").change(function(){
		$("input[name=hiddenprovincia]").val($(this).val());	
	});
					
	$("select[name=departamento]").change(function(){
		$("input[name=hiddendepartamento]").val($(this).val());	
	});
		
	$("select[name=ecivil]").change(function(){
		$("input[name=hiddenecivil]").val($(this).val());	
	});
	
	$("select[name=situacionLaboral]").change(function(){
		$("input[name=hiddensituaLab]").val($(this).val());	
	});
		
	$("select[name=ecivil]").change(function(){
		$("input[name=hiddenecivil]").val($(this).val());	
	});
			
		
	$("select[name=documento]").change(function(){
		$("input[name=nrodocumento]").val("");
		$("input[name=hiddendocumento]").val($(this).val());
		
		$("input[name=nrodocumento]").unbind("keyup");
		$("input[name=nrodocumento]").unbind("keyup");
	
		
		
	if($(this).val()==2||$(this).val()==4){
		if($(this).val()==2){
			$("input[name=nrodocumento]").bind("keyup", function(e){   
			var v = $(this).val();
			if(!(/^[0-9]+$/i.test(v))){
				$(this).val(v.substr(0,(v.length-1)));
			}				
			var select = $("#documento").val();			
			var r=false;
			var texto = $(this).val().length;   
			var cant=null;
			var l = $(this).val().length;
			if(l>0){
				if(select!=null){
					if(select==2){												
						if(l>8){							
							$(this).val( $(this).val().substr(0, 8) );
						}
					}					
				}
			}
			
			});	
			$("input[name=nrodocumento]").bind("keyup", function(e){
			var v = $(this).val();
			if(!(/^[0-9]+$/i.test(v))){
				$(this).val(v.substr(0,(v.length-1)));
			}
			var select = $("#documento").val();			
			var r=false;
			var texto = $(this).val().length;   
			var cant=null;
			var l = $(this).val().length;
			if(l>0){
				if(select!=null){
					if(select==2){
						if(l>8){
							$(this).val( $(this).val().substr(0, 8) );
						}
					}					
				}
			}
			
			});	
		}
		
		if($(this).val()==4){
			$("input[name=nrodocumento]").bind("keyup", function(e){
			var v = $(this).val();
			if(!(/^[a-z0-9]+$/i.test(v))){
				$(this).val(v.substr(0,(v.length-1)));
			}	
			var select = $("#documento").val();
			var r=false;
			var texto = $(this).val().length;   
			var cant=null;
			var l = $(this).val().length;
			if(l>0){
				
				if(select!=null){					
					if(select==4){					
						if(l>=9 && l>12){
							$(this).val( $(this).val().substr(0,12) );
						}		
					}
				}
			}
				
			});	
			$("input[name=nrodocumento]").bind("keypress", function(e){
			var v = $(this).val();
			if(!(/^[a-z0-9]+$/i.test(v))){
				$(this).val(v.substr(0,(v.length-1)));
			}
			var select = $("#documento").val();
			var r=false;
			var texto = $(this).val().length;   
			var cant=null;
			var l = $(this).val().length;
			if(l>0){				
				if(select!=null){					
					if(select==4){							
						if(l>=9 && l<12){
							$(this).val( $(this).val().substr(0,12) );
						}		
					}
				}
			}
			
			});	
		}
		
		}else{
			$("input[name=nrodocumento]").bind("keyup", function(e){
				$("select[name=documento]").focus(); 			
				$(this).val("N° de documento");
			});
		}
		
	});
	
	$("input[name=nrodocumento]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="N° de documento"){
			$(this).val("");
		}
		
	}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("N° de documento");
		}	
		if($("select[name=documento]").val()==0){
			$(this).val("N° de documento");
		}
		
		}).keyup(function(){		
			if(!($(this).val()==2||$(this).val()==4)){
				$("select[name=documento]").focus();
				$(this).val("N° de documento");
			}
		});  
	
	$("input[name=email]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="Correo Electrónico"){
			$(this).val("");
		}
	}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("Correo Electrónico");
		}	
	});
	
	$("input[name=ruc]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="RUC"){
			$(this).val("");
		}
	}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("RUC");
		}
		
		}).keyup(function(){	
			var count=11;
			var texto = $(this).val().length;   
			var cant=null;
			var l = $(this).val().length;
			if(l>0){
				cant=count;
				if(l!=cant){
					$(this).val( $(this).val().substr(0, cant) );
				}								
			}
		}).ForceNumericOnly();  

	$("input[name=renta]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="Renta Bruta Mensual S/."){
			$(this).val("");
		}
		}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("Renta Bruta Mensual S/.");
		}
			
	}).limiteMoney().ForceNumericOnly();  
	
    $("input[name=telefono]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="Teléfono"){
			$(this).val("");
		}
	}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("Teléfono");
		}
		}).ForceNumericOnly().keyup(function(){	
			var count=13;
			var texto = $(this).val().length;   
			var cant=null;
			var l = $(this).val().length;
			if(l>0){
				cant=count;
				if(l!=cant){
					$(this).val( $(this).val().substr(0, cant) );
				}								
			}
		});  
	
	$("input[name=captcha]").focus(function(){
		var len=$(this).val().length;
		if(len<minCantidad||$(this).val()=="Ingresa el código"){
			$(this).val("");
		}	
		}).blur(function(){
		var len=$(this).val().length;	
		if(len<minCantidad){
			$(this).val("Ingresa el código");
		}
	})
	
	
}

function mensajesError(li){
	var ul = $("ul",$("#errorContainer"));
	ul.html("");
	var html = "";
	html += '<li><label for="txtNombre" generated="true" class="error" style="display: block;">'+li+'</label></li>'			
	ul.html(html);
}

function llenarDias(diaSelect,cboMes,annoSelect){
	
	var dias = getDays(cboMes.val()-1,annoSelect.val());
	if(dias<diaSelect){
		diaSelect=1;
	}
	var d = $("#dia");
	d.html("");	
	d.append("<option value='0'>Día</option>");	
	for (var i=1 ; i<dias+1;i++){
		if(diaSelect==i){
			d.append("<option  selected='selected' value='"+i+"'>"+i+"</option>");
		}else{
			d.append("<option value='"+i+"'>"+i+"</option>");
		}
	}
}

function esBisiesto(ano) {
	if (ano % 4 == 0)
	return true
	else 
	return false
} 

function getDays(month, a) {

	var ar = new Array(12)
	ar[0] = 31 // Enero
	
	if(a>0){		
		if(esBisiesto(a)){
				ar[1]=29
			}else{
				ar[1]=28
			}
	}else{
		ar[1]=28
	}	
	ar[2] = 31 // Marzo
	ar[3] = 30 // Abril
	ar[4] = 31 // Mayo
	ar[5] = 30 // Junio
	ar[6] = 31 // Julio
	ar[7] = 31 // Agosto
	ar[8] = 30 // Septiembre
	ar[9] = 31 // Octubre
	ar[10] = 30 // Noviembre
	ar[11] = 31 // Diciembre

	return ar[month];
}


function asignarFechaNacimiento(anno,mes,dia){
	var d=dia.val();
	var m=mes.val();
	var a=anno.val();
	if(d<10){
		d="0"+d;
	}
	if(m<10){
		m="0"+m;
	}
	var fecha=a+"-"+m+"-"+d;
	$("#fchNacimiento").val(fecha);
}

function cargarAños(){
	
	var cboAno = $("#anno");
	cboAno.html("");
	var fecha_hoy = new Date();
	var fin = fecha_hoy.getYear()-18;	
	var ini = fecha_hoy.getYear()-70;	

	cboAno.append("<option value = 0>Año</option>");


	for (var i = fin;i>=ini ; i--){		
		var an = i;
		if(fecha_hoy.getYear()<1900){
			an = i + 1900;
		}		
		cboAno.append("<option value = "+an+">"+an+"</option>");		
	}
		

}
