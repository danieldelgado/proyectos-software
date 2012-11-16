<!-- #include file ="archivos/gestor_archivos.asp" -->
<%

Dim qs : qs = Trim(Request.Querystring)


Dim urlredirect
Dim sValue
Dim codProducto : codProducto = Trim(Request.Form("codProducto"))
	'Response.Write "<br>codProducto:"&codProducto
Dim val2 : val2 = Trim(Request.Form("val2"))
	'Response.Write "<br>val2:"&val2
Dim url 
buscarValor("servidor.peregrino.ws.lead")
url = valor	
	'Response.Write "<br>url:"&url
Dim xmlLead : xmlLead = Trim(Request.Form("xmlLead"))
	'Response.Write "<br>xmlLead:"&xmlLead
Dim actionLead : actionLead = Trim(Request.Form("actionLead"))

	'Response.Write "<br>actionLead:"&actionLead

sub cargarConfirmacion()

	Dim persona
	Dim horaConfirmacion
	Dim mensaje
	Dim conBotones

	'xmlLead = Server.HTMLEncode(xmlLead)
	agregar_log(" solicitar Producto: "&codProducto&" xmlLead :"&xmlLead )
	agregar_log(" solicitar Producto qs :"&qs )
	agregar_log(" solicitar Producto Server.HTMLEncode(qs) :"&Server.HTMLEncode(qs) )
	xmlLead = replace(xmlLead,qs,Server.HTMLEncode(qs))
	agregar_log(" solicitar Producto replace: "&codProducto&" xmlLead :"&xmlLead )

	call servicioWeb(url,actionLead,xmlLead)
	'Response.Write ":::sValue:::" & sValue
	sValue = mid(sValue,2,1)
	
	agregar_log(" solicitar Producto  "&codProducto&" actionLead :"&actionLead&" sValue : " & sValue )
	'Response.Write ":::sValue:::" & sValue
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



Select Case codProducto
		Case 1
			Select Case sValue 'MyRandomNum
				Case "1"
					'Mensaje de Confirmacion
					if codProducto = 4 then
							buscarValor("producto.mesaje.credito.hipotecario.mensaje.confirmacion.hora.24")	
							horaConfirmacion = valor
						else
							buscarValor("producto.mesaje.credito.hipotecario.mensaje.confirmacion.hora.72")	
							horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)						
									
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select
				urlredirect="credito-hipotecario-mensaje.asp"
		Case 3
				Select Case sValue 'MyRandomNum
				Case "1"
					'Mensaje de Confirmacion
					if codProducto = 4 then
							buscarValor("producto.mesaje.prestamo.personal.mensaje.confirmacion.hora.24")	
							horaConfirmacion = valor
						else
							buscarValor("producto.mesaje.prestamo.personal.mensaje.confirmacion.hora.72")	
							horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.prestamo.personal.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)						
									
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.prestamo.personal.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select			
				urlredirect="prestamo-personal-mensaje.asp"
		Case 4
				Select Case sValue 'MyRandomNum
				Case "1"
					'Mensaje de Confirmacion
					if codProducto = 4 then
							buscarValor("producto.mesaje.prestamo.vehicular.mensaje.confirmacion.hora.24")	
							horaConfirmacion = valor
						else
							buscarValor("producto.mesaje.prestamo.vehicular.mensaje.confirmacion.hora.72")	
							horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)						
									
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select						
				urlredirect="prestamo-vehicular-mensaje.asp"	
		Case 6					
				Select Case sValue 'MyRandomNum
				Case "1"
					'Mensaje de Confirmacion
					if codProducto = 4 then
							buscarValor("producto.mesaje.tarjeta.mensaje.confirmacion.hora.24")	
							horaConfirmacion = valor
						else
							buscarValor("producto.mesaje.tarjeta.mensaje.confirmacion.hora.72")	
							horaConfirmacion = valor				
					end if	
					buscarValor("producto.mesaje.tarjeta.mensaje.confirmacion")
					mensaje = valor
					mensaje = replace(mensaje, "{0}", horaConfirmacion)						
									
				Case else
					'Mensaje de error sistema
					buscarValor("producto.mesaje.tarjeta.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""			
				end select			
				urlredirect="tarjetas-mensaje.asp"				
	End Select	

		Session("mensaje") = mensaje
		Session("conBotones") = false
		Session("persona") = ""	
		Session("codProducto") = "0"	
		Session("val2") = ""		
		Session("xmlLead") = ""	
		Session("actionLead") = ""
		Session("sValue") = sValue
		agregar_log(" Valores de session mensaje :" & mensaje )
		
		
		if qs <> "" then
			qs = replace(qs, "&amp;","&")	
			qs = urlredirect & "?" & qs 		
		else
			qs = urlredirect
		end if
					
		agregar_log(" qs urlredirect :" & urlredirect ); 
				
		'Response.Write sValue
		'Response.Write urlredirect
		Response.Redirect(urlredirect)
		
end sub


sub servicioWeb(u,a,x)

			'Response.Write "<br> u:" & u&  "<br>"
			'Response.Write "<br> a:" & a&  "<br>"
			'Response.Write "<br> x:" & x&  "<br>"		
				
	agregar_log(" solicitar servicioWeb  u: " & u )
	agregar_log(" solicitar servicioWeb  a : " & a )
	agregar_log(" solicitar servicioWeb  x: " & x )
									
	Dim xmlhttp	
	Dim blnSuccess
	Dim xmlResponse

	Set xmlhttp = server.CreateObject("WinHttp.WinHttpRequest.5.1")
	xmlhttp.Open "POST", u
	xmlhttp.setRequestHeader "Man", "POST " & u & " HTTP/1.1"
	xmlhttp.setRequestHeader "Content-Type", "text/xml; charset=utf-8"
	xmlhttp.setRequestHeader "SOAPAction", a
	call xmlhttp.send(x)
	If xmlhttp.Status = 200 Then
	 blnSuccess = True
	Else
	 blnSuccess = False
	End If
	xmlResponse = xmlhttp.ResponseText
	agregar_log(" solicitar servicioWeb  xmlResponse: " & xmlResponse )
	Set xmlhttp = Nothing
	Dim oXML, oNode, sKey
	Set oXML = Server.CreateObject("Microsoft.XMLDOM")
	oXML.LoadXML(xmlResponse)
	if oXML.hasChildNodes then
		For Each oNode In oXML.SelectNodes("soapenv:Envelope/soapenv:Body")
		  sKey = oNode.GetAttribute(a)
		  sValue = oNode.Text 
		  agregar_log(" solicitar servicioWeb  : " & sValue )
		Next
	end if
	Set oXML = Nothing


	
end sub	
cargarConfirmacion()
%>