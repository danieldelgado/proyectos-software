
<%

'Dim objBad Set objBad = Server.CreateObject("BAD.OBJECT.CLASS")

Dim sValue 
Dim sValueLead : sValueLead = 2

Dim tagInit
Dim header
Dim footer

Dim urlLead
Dim xmlLead
Dim valueLead
Dim actionLead
Dim eLead : eLead = "0"
Dim qs : qs = Trim(Request.Querystring)
qs = Server.HTMLEncode(qs)
'qs = replace(qs, "&amp;","&")

'Dim p : p = Trim(Request.QueryString("p"))
Dim codProducto : codProducto = Trim(Request.Form("codProducto"))
Dim nombres : nombres = Trim(Request.Form("nombres"))
Dim apellidos : apellidos = Trim(Request.Form("apellidos"))
Dim documento : documento = Trim(Request.Form("documento"))
Dim nrodocumento : nrodocumento = Trim(Request.Form("nrodocumento"))
Dim ecivil : ecivil = Trim(Request.Form("ecivil"))
Dim departamento : departamento = Trim(Request.Form("departamento"))
Dim provincia : provincia = Trim(Request.Form("provincia"))
Dim situacionLaboral : situacionLaboral = Trim(Request.Form("situacionLaboral"))
Dim ruc : ruc = Trim(Request.Form("ruc"))
Dim renta : renta = Trim(Request.Form("renta"))
Dim email : email = Trim(Request.Form("email"))
Dim fchNacimiento : fchNacimiento = Trim(Request.Form("fchNacimiento"))
Dim telefono : telefono = Trim(Request.Form("telefono"))
Dim captcha : captcha =  Trim(Request.Form("captcha"))
Dim dtI : dtI =  Trim(Request.Form("dtI"))
Response.ContentType = "application/json"
'dtI = "jsa"

Dim valNombres : valNombres = false
Dim valApellidos : valApellidos = false
Dim valDocumento : valDocumento = false
Dim valNrodocumento : valNrodocumento = false
Dim valEcivil : valEcivil = false
Dim valDepartamento : valDepartamento = false
Dim valProvincia : valProvincia = false
Dim valSituacionLaboral : valSituacionLaboral = false
Dim valRuc : valRuc = false
Dim valRenta : valRenta = false
Dim valEmail : valEmail = false
Dim valFchNacimiento : valFchNacimiento = false
Dim valTelefono : valTelefono = false
Dim valCaptcha : valCaptcha = false 

valNombres = validarAlfanumerico(nombres,2,100,"Nombres")
valApellidos =validarAlfanumerico(apellidos,2,100,"Apellidos")
valDocumento = validarCombo(documento)
valNrodocumento = validarNumeroDocumento(documento,nrodocumento,"N° de documento")
valEcivil =  validarCombo(ecivil)
valDepartamento =  validarCombo(departamento)
valProvincia =  validarCombo(provincia)
valSituacionLaboral  =  validarCombo(situacionLaboral)
valRuc = validarNumerico(ruc,11,11,"RUC")
valRenta = validarNumerico(renta,1,12,"Renta Bruta Mensual S/.")
valEmail = validarEmail(email,100,"Correo Electrónico")
valFchNacimiento = validarFecha(fchNacimiento)
valTelefono = validarNumerico(telefono,7,13,"Teléfono")
valCaptcha = validarCaptcha(captcha)


agregar_log(" valEmail :" & valEmail)

'Response.Write "<br> valNombres:" & valNombres
'Response.Write "<br> valApellidos:" & valApellidos
'Response.Write "<br> valDocumento:" & valDocumento
'Response.Write "<br> valNrodocumento:" & valNrodocumento
'Response.Write "<br> valEcivil:" & valEcivil
'Response.Write "<br> valDepartamento:" & valDepartamento
'Response.Write "<br> valProvincia:" & valProvincia
'Response.Write "<br> valSituacionLaboral:" & valSituacionLaboral
'Response.Write "<br> valRuc:" & valRuc
'Response.Write "<br> valRenta:" & valRenta
'Response.Write "<br> valEmail:" & valEmail
'Response.Write "<br> valFchNacimiento:" & valFchNacimiento
'Response.Write "<br> valTelefono:" & valTelefono
'Response.Write "<br> valSituacionLaboral:" & valSituacionLaboral
'Response.Write "<br> valCaptcha:" & valCaptcha

valNombres = true
valApellidos = true
valDocumento = true
valNrodocumento = true
valEcivil = true
valDepartamento = true
valProvincia = true
valSituacionLaboral = true
valRuc = true
valRenta = true
valEmail = true
valFchNacimiento = true
valTelefono = true
valCaptcha = true

%>
<!-- #include file ="archivos/gestor_archivos.asp" -->
<%
Dim a 					
Dim u 
Dim x  
Dim e
Dim ip : ip = Request.ServerVariables("REMOTE_ADDR")

function validarAlfanumerico(campo , lengthMin , lengthMax, diferente) 
if isNull(campo)<>true then
	if len(campo)>lengthMin and len(campo)<lengthMax then
		if campo<>diferente then	
			validarAlfanumerico = true	
			exit function
		end if
	end if
end if
validarAlfanumerico = false
end function

function validarCaptcha(cap)
Dim TestValue : TestValue = cap
if Request.ServerVariables("REQUEST_METHOD") = "POST" then
		 if IsEmpty(Session("ASPCAPTCHA")) or Trim(Session("ASPCAPTCHA")) = "" then
                validarCaptcha = false
         end if
    TestValue = Replace(TestValue, "i", "I", 1, -1, 1)
    TestValue = Replace(TestValue, "İ", "I", 1, -1, 1)
    TestValue = Replace(TestValue, "ı", "I", 1, -1, 1)
	TestValue = UCase(TestValue)    
    if (StrComp(TestValue, Trim(Session("ASPCAPTCHA")), 1) = 0)  then
        validarCaptcha = true 
    else
         validarCaptcha = false       
    end if  
	
	if validarCaptcha = "" then
		validarCaptcha = false
	end if	     
end if
end function



function validarNumerico(campo , lengthMin , lengthMax, diferente) 
if isNull(campo)<>true then
	if campo<>diferente then
		if isNumeric(campo)<>false then
			if len(campo)>= lengthMin and len(campo)<=lengthMax then		
				validarNumerico = true	
				exit function
			end if		
		end if	
	end if	
end if
validarNumerico = false
end function

function validarCombo(campo)
if isNull(campo)<>true then
	if isNumeric(campo)<>false then
		if len(campo)>=0 then	
			if campo>0 then	
				validarCombo = true	
				exit function			
			end if			
		end if	
	end if	
end if
validarCombo = false
end function 

function validarNumeroDocumento(doc,numDoc , diferente)

if valDocumento then
	if isNumeric(numDoc) then
		if campo<>diferente then
			if doc = 2 then				
				if len(numDoc)=8 then	
					validarNumeroDocumento = true	
					exit function			
				end if					
			end if					
		end if	
	end if	
	
	if doc = 4 then			
				if len(numDoc) >= 9 and len(numDoc) <= 12 then	
					validarNumeroDocumento = true	
					exit function			
				end if					
	end if			
	
end if
validarNumeroDocumento = false
end function


function validarEmail(email,leng,diferente) 
	if len(campo)<=leng then	
		if campo<>diferente then
			dim partes, parte, i, c 
			partes = Split(email, "@") 
			if UBound(partes) <> 1 then 
				 validarEmail = false 
				 exit function 
			end if 
			for each parte in partes 
				 if Len(parte) <= 0 then 
					 validarEmail = false 
					 exit function 
				 end if 
				 for i = 1 to Len(parte) 
					 c = Lcase(Mid(parte, i, 1)) 
					 if InStr("._-abcdefghijklmnopqrstuvwxyz", c) <= 0 and not IsNumeric(c) then 
						 validarEmail = false 
						 exit function 
					 end if 
				 next 
				 if Left(parte, 1) = "." or Right(parte, 1) = "." then 
					 validarEmail = false 
					 exit function 
				 end if 
			next 
			if InStr(partes(1), ".") <= 0 then 
				 validarEmail = false 
				 exit function 
			end if 
			i = Len(partes(1)) - InStrRev(partes(1), ".") 
			if not (i = 2 or i = 3) then 
				 validarEmail = false 
				 exit function 
			end if 
			if InStr(email, "..") > 0 then 
				 validarEmail=false 
				 exit function 
			end if 
			validarEmail = true 
		else
			validarEmail = false 
		end if 	
	end if 	
end function

function validarFecha(campo)
if IsDate(campo) then 
	Dim a : a = DateDiff("yyyy", campo, date())
	if a >=18 then
		validarFecha = true
		exit function

	end if
end if
validarFecha = false
end function 

function splitValues(arg)
Dim ar: ar = arg 
ar = replace(ar, " " , "")
ar=split(trim((replace(replace(replace(replace(ar, "," , " "), "[" , " "), "," , " "), "]" , " "))))
splitValues = ar
end function 

cargarValidaciones()

public sub refrescarparametros(schema)
buscarValor("tag.xml.schema.prefijo.inicio")
tagInit = valor	
	
if schema = 1 then
buscarValor("soapenv.Envelope.schemas.xml.header")
header = valor	
header = replace(header, "{0}", tagInit)
	
buscarValor("soapenv.Envelope.schemas.xml.footer")
footer = valor	
footer = replace(footer, "{0}", tagInit)
else
buscarValor("soapenv.Envelope.schemas.xml.lead.header")
header = valor	
header = replace(header, "{0}", tagInit)
	
buscarValor("soapenv.Envelope.schemas.xml.lead.footer")
footer = valor	
footer = replace(footer, "{0}", tagInit)


end if

end sub

public sub cargarValidaciones()
'Response.Write(codProducto&"<br>")
'Response.Write(dtI)


if dtI = "jsa" then


if codProducto = 1 then
		if valNombres and valApellidos and valDocumento and valNrodocumento and valEcivil and  valSituacionLaboral and valDepartamento and valProvincia and valRuc and  valRenta and valEmail and valFchNacimiento and valTelefono and valCaptcha then
			
			refrescarparametros(1)
			buscarValor("servidor.peregrino.ws.precalificacion")
			u = valor				
			buscarValor("pre.calificacion.credito.hipotecario.request.accion")			
			a = valor										
			header = replace(header, "{1}", a)									
			footer = replace(footer, "{1}", a)				
			x = header&" <{0}:nombres>"&nombres&"</{0}:nombres>  <{0}:apellidos>"&apellidos&"</{0}:apellidos><{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento> <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>  <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral> <{0}:departamento>"&departamento&"</{0}:departamento>   <{0}:provincia>"&provincia&"</{0}:provincia> <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>  <{0}:email>"&email&"</{0}:email> <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento> <{0}:telefono>"&telefono&"</{0}:telefono> <{0}:ip> "&ip&" </{0}:ip> <{0}:queryString >  "&qs&" </{0}:queryString>  " & footer														
			x = replace(x, "{0}", tagInit)
			
			agregar_log(" Credito hipotecario precalificacion xml consulta :" & x)
			call servicioWeb(u,a,x)	
			e = sValue	
			agregar_log(" Credito hipotecario precalificacion respuesta :" & e)
			e=splitValues(e)

			if e(0) < 9 and e(0) > 0 then
				refrescarparametros(2)
				buscarValor("servidor.peregrino.ws.lead")
				urlLead = valor				
				buscarValor("lead.credito.hipotecario.request.accion")			
				actionLead = valor										
				header = replace(header, "{1}", actionLead)									
				footer = replace(footer, "{1}", actionLead)
				valueLead = e(1)
				xmlLead = header & " <{0}:nombres>"&nombres&"</{0}:nombres>   <{0}:apellidos>"&apellidos&"</{0}:apellidos>   <{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento>   <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>   <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral>  <{0}:departamento>"&departamento&"</{0}:departamento>   <{0}:provincia>"&provincia&"</{0}:provincia>   <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>   <{0}:email>"&email&"</{0}:email>   <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento>   <{0}:telefono>"&telefono&"</{0}:telefono>   <{0}:ip> "&ip&" </{0}:ip> <{0}:codigoLead>"&valueLead&"</{0}:codigoLead>   <{0}:queryString>"&qs&"</{0}:queryString>" & footer										
				xmlLead = replace(xmlLead, "{0}", tagInit)
				agregar_log(" Credito hipotecario lead xml consulta :" & xmlLead)

				if  e(0)=3 or e(0)=4  then				
					call servicioWebLead(urlLead,actionLead,xmlLead)	
					eLead = sValueLead	
					eLead = splitValues(eLead)
					sValueLead = eLead(0)
					agregar_log(" Credito hipotecario sValueLead :" & sValueLead)	

				end if
			end if
			call respuesta(e,codProducto)
			exit sub			
		end if
	end if
	
	if codProducto = 2 then	
		if valNombres and valApellidos and valDocumento and valNrodocumento and valEcivil and  valSituacionLaboral and valRuc and  valRenta and valEmail and valFchNacimiento and valTelefono and valCaptcha then
			
			refrescarparametros(2)
			buscarValor("servidor.peregrino.ws.lead")
			u = valor				
			buscarValor("lead.cuenta.sueldo.request.accion")			
			a = valor													
			header = replace(header, "{1}", a)									
			footer = replace(footer, "{1}", a)						
			x = header&"<{0}:nombres>"&nombres&"</{0}:nombres>   <{0}:apellidos>"&apellidos&"</{0}:apellidos>  <{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento>   <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento	>   <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral>   <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>   <{0}:email>"&email&"</{0}:email>   <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento>  <{0}:telefono>"&telefono&"</{0}:telefono>    <{0}:ip> "&ip&" </{0}:ip>  <{0}:codigoLead>"&valueLead&"</{0}:codigoLead>   <{0}:queryString>"&qs&"</{0}:queryString> " & footer
			x = replace(x, "{0}", tagInit)
			agregar_log(" Cuenta sueldo lead xml consulta :" & x)
			call servicioWeb(u,a,x)	
			e = sValue
			e=splitValues(e)
			call respuesta(e,codProducto)	
			exit sub			
		end if
		
	end if
	
	if codProducto = 3 then
		if valNombres and valApellidos and valDocumento and valNrodocumento and valEcivil and  valSituacionLaboral and valRuc and valRenta and valEmail and valFchNacimiento and valTelefono and valCaptcha then
				
			refrescarparametros(1)
			buscarValor("servidor.peregrino.ws.precalificacion")
			u = valor				
			buscarValor("pre.calificacion.prestamo.personal.request.accion")			
			a = valor										
			header = replace(header, "{1}", a)									
			footer = replace(footer, "{1}", a)				
			x = header & " <{0}:nombres>"&nombres&"</{0}:nombres>  <{0}:apellidos>"&apellidos&"</{0}:apellidos><{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento> <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>  <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral> <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>  <{0}:email>"&email&"</{0}:email> <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento> <{0}:telefono>"&telefono&"</{0}:telefono> <{0}:ip> "&ip&" </{0}:ip> <{0}:queryString >  "&qs&" </{0}:queryString> " & footer
			x = replace(x, "{0}", tagInit)					
			agregar_log(" Prestamo Personal precalificacion xml consulta :" & x)
			call servicioWeb(u,a,x)	
			e = sValue	
			agregar_log(" Prestamo Personal precalificacion respuesta :" & e)
			e=splitValues(e)

			if e(0) < 9 and e(0) > 0 then
				refrescarparametros(2)
				buscarValor("servidor.peregrino.ws.lead")
				urlLead = valor				
				buscarValor("lead.prestamo.personal.request.accion")			
				actionLead = valor										
				header = replace(header, "{1}", actionLead)									
				footer = replace(footer, "{1}", actionLead)
				valueLead = e(1)
				xmlLead = header & " <{0}:nombres>"&nombres&"</{0}:nombres>   <{0}:apellidos>"&apellidos&"</{0}:apellidos>  <{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento>   <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>   <{0}: estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral>   <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>   <{0}:email>"&email&"</{0}:email>   <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento>  <{0}:telefono>"&telefono&"</{0}:telefono>     <{0}:ip> "&ip&" </{0}:ip> <{0}:codigoLead>"&valueLead&"</{0}:codigoLead>   <{0}:queryString>"&qs&"</{0}:queryString> " & footer
				xmlLead = replace(xmlLead, "{0}", tagInit)
				agregar_log(" Prestamo Personal lead xml consulta :" & xmlLead)

				if  e(0)=3 or e(0)=4  then				
					call servicioWebLead(urlLead,actionLead,xmlLead)	
					eLead = sValueLead	
					eLead = splitValues(eLead)
					sValueLead = eLead(0)
					agregar_log(" Prestamo Personal sValueLead :" & sValueLead)	

				end if
			end if
				
			call respuesta(e,codProducto)

			exit sub
		end if
	end if
	
	if codProducto = 4 then
			if valNombres and valApellidos and valDocumento and valNrodocumento and valEcivil and  valSituacionLaboral and valDepartamento and valProvincia  and valRuc and valRenta and valEmail and valFchNacimiento and valTelefono and valCaptcha then
			
			refrescarparametros(1)
			buscarValor("servidor.peregrino.ws.precalificacion")
			u = valor				
			buscarValor("pre.calificacion.credito.vehicular.request.accion")			
			a = valor										
			header = replace(header, "{1}", a)									
			footer = replace(footer, "{1}", a)				
			x = header & " <{0}:nombres>"&nombres&"</{0}:nombres>  <{0}:apellidos>"&apellidos&"</{0}:apellidos><{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento> <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>  <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral>  <{0}:departamento>"&departamento&"</{0}:departamento>   <{0}:provincia>"&provincia&"</{0}:provincia> <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>  <{0}:email>"&email&"</{0}:email> <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento> <{0}:telefono>"&telefono&"</{0}:telefono> <{0}:ip> "&ip&" </{0}:ip> <{0}:queryString >  "&qs&" </{0}:queryString> " & footer					
			x = replace(x, "{0}", tagInit)	
			agregar_log(" Credito vehicular precalificacion xml consulta :" & x)
			call servicioWeb(u,a,x)	
			e = sValue	
			agregar_log(" Credito vehicular precalificacion respuesta :" & e)
			e=splitValues(e)

			if e(0) < 9 and e(0) > 0 then
				refrescarparametros(2)
				buscarValor("servidor.peregrino.ws.lead")
				urlLead = valor				
				buscarValor("lead.credito.vehicular.request.accion")		
				actionLead = valor										
				header = replace(header, "{1}", actionLead)									
				footer = replace(footer, "{1}", actionLead)
				valueLead = e(1)
				xmlLead = header & " <{0}:nombres>"&nombres&"</{0}:nombres>  <{0}:apellidos>"&apellidos&"</{0}:apellidos> <{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento>   <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>   <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>    <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral>  <{0}:departamento>"&departamento&"</{0}:departamento>   <{0}:provincia>"&provincia&"</{0}:provincia>     <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>  <{0}:email>"&email&"</{0}:email>   <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento><{0}:telefono>"&telefono&"</{0}:telefono>    <{0}:ip> "&ip&" </{0}:ip>  <{0}:codigoLead>"&telefono&"</{0}:codigoLead>  <{0}:queryString >  "&qs&" </{0}:queryString>  " & footer
				xmlLead = replace(xmlLead, "{0}", tagInit)
				agregar_log(" Credito vehicular lead xml consulta :" & xmlLead)

				if  e(0)=3 or e(0)=4  then				
					call servicioWebLead(urlLead,actionLead,xmlLead)	
					eLead = sValueLead	
					eLead = splitValues(eLead)
					sValueLead = eLead(0)
					agregar_log(" Credito vehicular sValueLead :" & sValueLead)	

				end if
			end if
				
			call respuesta(e,codProducto)

			exit sub			
		end if
	end if
		
	if codProducto = 5 then
		if valNombres and valApellidos and valDocumento and valNrodocumento and valCaptcha then
			refrescarparametros(2)
		buscarValor("servidor.peregrino.ws.lead")
		u = valor				
		buscarValor("lead.seguro.soat.request.accion")			
		a = valor										
		header = replace(header, "{1}", a)									
		footer = replace(footer, "{1}", a)	
			x = header & " <{0}:nombres>"&nombres&"</{0}:nombres>   <{0}:apellidos>"&apellidos&"</{0}:apellidos>   <{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento>   <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento> <{0}:telefono>"&telefono&"</{0}:telefono>   <{0}:ip> "&ip&" </{0}:ip> <{0}:codigoLead>"&valueLead&"</{0}:codigoLead>   <{0}:queryString>"&qs&"</{0}:queryString> " & footer
			x = replace(x, "{0}", tagInit)	
			agregar_log(" Seguro Soat lead xml consulta :" & x)			
			call servicioWeb(u,a,x)		
			e = sValue
			e=splitValues(e)
			call respuesta(e,codProducto)
			exit sub
		end if
	end if

	if codProducto = 6 then
		if valNombres and valApellidos and valDocumento and valNrodocumento and valEcivil and  valSituacionLaboral and valRuc and valRenta and valEmail and valFchNacimiento and valTelefono and valCaptcha then
						
			refrescarparametros(1)
			buscarValor("servidor.peregrino.ws.precalificacion")
			u = valor				
			buscarValor("pre.calificacion.tarjeta.credito.request.accion")			
			a = valor										
			header = replace(header, "{1}", a)									
			footer = replace(footer, "{1}", a)				
			x =  header & "  <{0}:nombres>"&nombres&"</{0}:nombres>  <{0}:apellidos>"&apellidos&"</{0}:apellidos><{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento> <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>  <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral> <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>  <{0}:email>"&email&"</{0}:email> <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento> <{0}:telefono>"&telefono&"</{0}:telefono> <{0}:ip> "&ip&" </{0}:ip> <{0}:queryString >  "&qs&" </{0}:queryString> " & footer
			x = replace(x, "{0}", tagInit)	
			agregar_log(" Tarjeta Credito precalificacion xml consulta :" & x)
			call servicioWeb(u,a,x)	
			e = sValue	
			agregar_log(" Tarjeta Credito precalificacion respuesta :" & e)
			e=splitValues(e)
			if e(0) < 9 and e(0) > 0 then
				refrescarparametros(2)
				buscarValor("servidor.peregrino.ws.lead")
				urlLead = valor				
				buscarValor("lead.tarjeta.credito.request.accion")			
				actionLead = valor										
				header = replace(header, "{1}", actionLead)									
				footer = replace(footer, "{1}", actionLead)	
				valueLead = e(1)
				agregar_log(" valueLead :" & valueLead)	
				xmlLead = header & " <{0}:nombres>"&nombres&"</{0}:nombres>   <{0}:apellidos>"&apellidos&"</{0}:apellidos>   <{0}:tipoDocumento>"&documento&"</{0}:tipoDocumento>   <{0}:numeroDocumento>"&nrodocumento&"</{0}:numeroDocumento>   <{0}:estadoCivil>"&ecivil&"</{0}:estadoCivil>   <{0}:situacionLaboral>"&situacionLaboral&"</{0}:situacionLaboral>   <{0}:ruc>"&ruc&"</{0}:ruc>   <{0}:renta>"&renta&"</{0}:renta>   <{0}:email>"&email&"</{0}:email>   <{0}:fechaNacimiento>"&fchNacimiento&"</{0}:fechaNacimiento>   <{0}:telefono>"&telefono&"</{0}:telefono>   <{0}:ip> "&ip&" </{0}:ip> <{0}:codigoLead>"&valueLead&"</{0}:codigoLead>   <{0}:queryString>"&qs&"</{0}:queryString> " & footer	
				xmlLead = replace(xmlLead, "{0}", tagInit)
				agregar_log(" Tarjeta Credito lead xml consulta :" & xmlLead)

				if  e(0)=3 or e(0)=4  then				
					call servicioWebLead(urlLead,actionLead,xmlLead)	
					eLead = sValueLead	
					eLead = splitValues(eLead)
					sValueLead = eLead(0)
					agregar_log(" Tarjeta Credito sValueLead :" & sValueLead)	

				end if
			end if
				
			call respuesta(e,codProducto)

			exit sub			
		end if
	end if
		
	sValue = "["
	
	if valNombres<>true then
		sValue = sValue & "10001,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valApellidos<>true then
		sValue = sValue & "10002,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valDocumento<>true then
		sValue = sValue & "10003,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valNrodocumento<>true then
		sValue = sValue & "10004,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valEcivil<>true then
		sValue = sValue & "10005,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valSituacionLaboral<>true then
		sValue = sValue & "10006,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valRuc<>true then
		sValue = sValue & "10009,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valRenta<>true then
		sValue = sValue & "10012,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valEmail<>true then
		sValue = sValue & "10013,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valFchNacimiento<>true then
		sValue = sValue & "10010,"
		else
		sValue = sValue & "100,"		
	end if
		
	if  codProducto = 1 or codProducto = 4 then
		if  valDepartamento <>true then
			sValue = sValue & "10007,"
			else
			sValue = sValue & "100,"		
		end if
		if valProvincia<>true then
			sValue = sValue & "10008,"
			else
			sValue = sValue & "100,"		
		end if
	end if
	
	if valTelefono<>true then
		sValue = sValue & "10011,"
		else
		sValue = sValue & "100,"		
	end if
	
	if valCaptcha<>true then
		sValue = sValue & "10014"
		else
		sValue = sValue & "100"		
	end if
		
	sValue = sValue & "]"
else
	'Response.Redirect("index.asp")
end  if

end sub
sub servicioWebLead(urlLead,actionLead,xmlLead)	

	agregar_log(" Ingreso a servicioWebLead urlLead:"&urlLead)	
	agregar_log(" Ingreso a servicioWebLead actionLead:"&actionLead)			
	agregar_log(" Ingreso a servicioWebLead xmlLead:"&xmlLead)	
	
	if  e(0)=3 or e(0)=4  then
		
		Dim xmlhttp	
		Dim blnSuccess
		Dim xmlResponse

		Set xmlhttp = server.CreateObject("WinHttp.WinHttpRequest.5.1")
		xmlhttp.Open "POST", urlLead
		xmlhttp.setRequestHeader "Man", "POST " & urlLead & " HTTP/1.1"
		xmlhttp.setRequestHeader "Content-Type", "text/xml; charset=utf-8"
		xmlhttp.setRequestHeader "SOAPAction", actionLead
		call xmlhttp.send(xmlLead)
		If xmlhttp.Status = 200 Then
		 blnSuccess = True
		Else
		 blnSuccess = False
		End If
		xmlResponse = xmlhttp.ResponseText
		Set xmlhttp = Nothing
		Dim oXML, oNode, sKey
		agregar_log(" leyendo xml respuesta :" & xmlResponse)
		Set oXML = Server.CreateObject("Microsoft.XMLDOM")
		oXML.LoadXML(xmlResponse)
		if oXML.hasChildNodes then
			For Each oNode In oXML.SelectNodes("soapenv:Envelope/soapenv:Body")
			  sKey = oNode.GetAttribute(a)
			  sValueLead = oNode.Text 
			Next
		end if
		Set oXML = Nothing
	else
		sValueLead = "[0]"
	end if

	agregar_log(" sValueLead respuesta "&actionLead&" :" & sValueLead)

end sub

sub servicioWeb(u,a,x)
				
	agregar_log(" Ingreso a servicioWeb "&a)	
	Dim xmlhttp	
	Dim blnSuccess
	Dim xmlResponse

	'buscarValor("resolveTimeout")
	'resolveTimeout = valor
	'buscarValor("connectTimeout")
	'connectTimeout =valor
	'buscarValor("sendTimeout")
	'sendTimeout =valor
	'buscarValor("receiveTimeout")
	'receiveTimeout =valor
	
	Set xmlhttp = server.CreateObject("WinHttp.WinHttpRequest.5.1")
	xmlhttp.Open "POST", u	
	xmlhttp.setRequestHeader "Man", "POST " & u & " HTTP/1.1"
	xmlhttp.setRequestHeader "Content-Type", "text/xml; charset=utf-8"
	xmlhttp.setRequestHeader "SOAPAction", a
	'xmlhttp.SetTimeouts resolveTimeout, connectTimeout, sendTimeout, receiveTimeout 

	call xmlhttp.send(x)

	agregar_log(" servicioWeb blnSuccess  :" & blnSuccess)
	agregar_log(" servicioWeb xmlhttp.Status  :" & xmlhttp.Status)
	
	If xmlhttp.Status = 200 Then
	 blnSuccess = True
	Else
	 blnSuccess = False
	End If

	if blnSuccess then 
		xmlResponse = xmlhttp.ResponseText
		agregar_log(" leyendo xml respuesta :" & xmlResponse)
		Set xmlhttp = Nothing
		Dim oXML, oNode, sKey
		Set oXML = Server.CreateObject("Microsoft.XMLDOM")
		oXML.LoadXML(xmlResponse)
		if oXML.hasChildNodes then
			For Each oNode In oXML.SelectNodes("soapenv:Envelope/soapenv:Body")
			  sKey = oNode.GetAttribute(a)
			  sValue = oNode.Text 			  
			Next
		end if	
		Set oXML = Nothing
	else
		sValue = "[0]"
	end if	

	agregar_log(" sValue respuesta "&a&" :" & sValue)

end sub	

sub respuesta(val,prod)
	
	Session("mensaje") = vbNullString
    Session.Contents.Remove("mensaje")
	Session("conBotones") = vbNullString
    Session.Contents.Remove("conBotones")
	Session("persona") = vbNullString
    Session.Contents.Remove("persona")
	Session("xmlLead") = vbNullString
    Session.Contents.Remove("xmlLead") 
	Session("actionLead") = vbNullString
    Session.Contents.Remove("actionLead") 
	
	Dim conBotones : conBotones = false
	Dim mensaje : mensaje = ""
	Dim persona : persona = ""
	Dim url : url = ""
	Dim horaConfirmacion
	
	
	Dim siz : siz =  Ubound(val) + 1
	Dim val1 
	Dim val2 
	if siz > 0 and siz < 4 then 
		val1 = "["&val(0)&"]"
		if siz = 2 then
			val2 = val(1)	
		end if
	else
		val1 = "[5]"	
	end if
	
	if siz > 0 and siz < 4 then 


		val = mid(val1,2,1)
			
		agregar_log(" Evalua respuesta 1 val:" & val & " - sValueLead:" &  sValueLead)

		if val=0 then
			val=7
		end if

		if sValueLead = 1 then
			if val = 3 or val = 4 then
				val = 4
			end if
		end if
		if sValueLead = 0 then

			val = 0

		end if

		agregar_log(" Evalua respuesta 2 val:" & val & " - sValueLead:" &  sValueLead)
		
		Select Case prod
		Case 1
			Select Case val 'MyRandomNum
				Case "0"
					'Mensaje de Error Registro								
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.error.registro")
					mensaje = valor
					conBotones = false
					persona = ""
				Case "1"
					'Mensaje de sinOferta
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.sin.oferta")
					mensaje = valor
					conBotones = false
					persona = ""
				
				Case "2"				
					'Mensaje de felicitaciones
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.error.felicitaciones")
					mensaje = valor
					conBotones = true
					persona = nombres	
				Case "3"
					'Mensaje de Confirmacion
					if prod = 4 then
							buscarValor("producto.mesaje.credito.hipotecario.mensaje.confirmacion.hora.24")	
							horaConfirmacion = valor
						else
							buscarValor("producto.mesaje.credito.hipotecario.mensaje.confirmacion.hora.72")	
							horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)
					conBotones = false
					persona = ""					
				Case "4" 
					'Mensaje de Contacto
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.contacto")
					mensaje = valor
					conBotones = false
					persona = ""						
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select
				url="credito-hipotecario-mensaje.asp"
		Case 2					
				Select Case val 'MyRandomNum
						
				Case "1"
					'Mensaje de Confirmacion				
					buscarValor("producto.mesaje.cuenta.sueldo.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", 72)
					conBotones = false
					persona = ""				
								
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.cuenta.sueldo.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""	
				end select
				url="cuenta-sueldo-mensaje.asp"
		Case 3
				Select Case val 'MyRandomNum
				Case "0"
					'Mensaje de Error Registro								
					buscarValor("producto.mesaje.prestamo.personal.mensaje.error.registro")
					mensaje = valor
					conBotones = false
					persona = ""
				Case "1"
					'Mensaje de sinOferta
					buscarValor("producto.mesaje.prestamo.personal.mensaje.sin.oferta")
					mensaje = valor
					conBotones = false
					persona = ""
				
				Case "2"				
					'Mensaje de felicitaciones
					buscarValor("producto.mesaje.prestamo.personal.mensaje.error.felicitaciones")
					mensaje = valor
					conBotones = true
					persona = nombres	
				Case "3"
					'Mensaje de Confirmacion
					if prod = 4 then
					buscarValor("producto.mesaje.prestamo.personal.mensaje.confirmacion.hora.24")	
					horaConfirmacion = valor
					else
					buscarValor("producto.mesaje.prestamo.personal.mensaje.confirmacion.hora.72")	
					horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.prestamo.personal.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)
					conBotones = false
					persona = ""					
				Case "4" 
					'Mensaje de Contacto
					buscarValor("producto.mesaje.prestamo.personal.mensaje.contacto")
					mensaje = valor
					conBotones = false
					persona = ""						
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.prestamo.personal.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select				
				url="prestamo-personal-mensaje.asp"
		Case 4
				Select Case val 'MyRandomNum
				Case "0"
					'Mensaje de Error Registro								
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.error.registro")
					mensaje = valor
					conBotones = false
					persona = ""
				Case "1"	
					'Mensaje de sinOferta
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.sin.oferta")
					mensaje = valor
					conBotones = false
					persona = ""
				
				Case "2"				
					'Mensaje de felicitaciones
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.error.felicitaciones")
					mensaje = valor
					conBotones = true
					persona = nombres	
				Case "3"
					'Mensaje de Confirmacion
					if prod = 4 then
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.confirmacion.hora.24")	
					horaConfirmacion = valor
					else
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.confirmacion.hora.72")	
					horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)
					conBotones = false
					persona = ""					
				Case "4" 
					'Mensaje de Contacto
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.contacto")
					mensaje = valor
					conBotones = false
					persona = ""						
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select					
				url="prestamo-vehicular-mensaje.asp"
		Case 5				
				Select Case val 'MyRandomNum
				Case "1"					
					buscarValor("producto.mesaje.soat.mensaje.contacto")
					mensaje = valor
					conBotones = false
					persona = ""								
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.soat.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select				
				url="soat-mensaje.asp"
		Case 6					
				Select Case val 'MyRandomNum
				Case "0"
					'Mensaje de Error Registro								
					buscarValor("producto.mesaje.tarjeta.mensaje.error.registro")
					mensaje = valor
					conBotones = false
					persona = ""
				Case "1"	
					'Mensaje de sinOferta
					buscarValor("producto.mesaje.tarjeta.mensaje.sin.oferta")
					mensaje = valor
					conBotones = false
					persona = ""
				
				Case "2"				
					'Mensaje de felicitaciones
					buscarValor("producto.mesaje.tarjeta.mensaje.error.felicitaciones")
					mensaje = valor
					conBotones = true
					persona = nombres	
				Case "3"
					'Mensaje de Confirmacion
					if prod = 4 then
					buscarValor("producto.mesaje.tarjeta.mensaje.confirmacion.hora.24")	
					horaConfirmacion = valor
					else
					buscarValor("producto.mesaje.tarjeta.mensaje.confirmacion.hora.72")	
					horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.tarjeta.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)
					conBotones = false
					persona = ""					
				Case "4" 
					'Mensaje de Contacto
					buscarValor("producto.mesaje.tarjeta.mensaje.contacto")
					mensaje = valor
					conBotones = false
					persona = ""						
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.tarjeta.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select					
				url="tarjetas-mensaje.asp"				
	End Select	
		
		if qs <> "" then
			qs = replace(qs, "&amp;","&")	
			qs = url & "?" & qs 		
		else
			qs = url
		end if
				
		val = replace(val1, "]", ","& chr(34)&qs&chr(34)&"]")

		agregar_log(" val respuesta :" & val)		

		agregar_log(" Valores de session mensaje :" & mensaje 			& " - conBotones:" &  conBotones			& " - persona:" &  persona			& " - codProducto:" &  codProducto			& " - val2:" &  val2			& " - xmlLead:" &  xmlLead			& " - actionLead:" &  actionLead)

		Session("mensaje") = mensaje
		Session("conBotones") = conBotones
		Session("persona") = persona	
		Session("codProducto") = codProducto	
		Session("val2") = val2		
		Session("xmlLead") = xmlLead	
		Session("actionLead") = actionLead	
		
		sValue=val
	end if			
end sub
%>
<%=sValue%>

