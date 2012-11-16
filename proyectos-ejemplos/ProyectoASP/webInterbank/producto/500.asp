<!-- #include file ="archivos/gestor_archivos.asp" -->
<%'Obtenemos el objeto ASPError

Dim codProducto : codProducto = Trim(Request.Form("codProducto"))
Dim documento : documento = Request.Form("documento")
Dim nrodocumento : nrodocumento = Request.Form("nrodocumento")
Dim sessi : sessi = Session.SessionID
Dim url
Response.ContentType = "application/json"


Set objASPError=Server.GetLastError()
Dim errorLog
strNumError=objASPError.Number
strCodigoASP=objASPError.ASPCode
If Len(strCodigoASP) Then
strCodigoASP="'"&strCodigoASP&"'"
Else
strCodigoASP=""
End if
strDescripcionError=objASPError.Description
strDescripcionASP=objASPError.ASPDescription
strCategoria=objASPError.Category
strNombreFichero=objASPError.File
strLinea=objASPError.Line
strColumna=objASPError.Column
If IsNumeric(strColumna) Then
lngColumna=CLng(strColumna)
Else
lngColumna=0
End if
strCodigoFuente=objASPError.Source
strDetalles="Se ha producido un error ASP " & strCodigoASP & " a las " & Time&_
" del día "&Date
If Len(strCategoria) Then strDetalles=strDetalles & vbCrlf& strCategoria
strDetalles=strDetalles & vbCrlf & "Número de error: " & strNumError _
& "(0X" & Hex(strNumError) & ")" & vbCrlf
If Len(strNombreFichero) Then
strDetalles=strDetalles & "Fichero: "&strNombreFichero
If strLinea>"0" Then
strDetalles=strDetalles & ", línea " & strLinea
If lngColumna>0 Then
strDetalles=strDetalles & ", columna " & lngColumna
If Len(strCodigoFuente) Then
strDetalles=strDetalles & vbCrlf & strCodigoFuente _
& vbCrlf & String (lngColumna-1,"-") & "^"
End if
End if
End if
strDetalles=strDetalles&vbCrlf
End if
strDetalles=strDetalles & strDescripcionError & vbCrlf
If Len(strDescripcionASP) Then
strDetalles= strDetalles & "ASP informa: " & strDescripcionASP & vbCrlf
End if

errorLog = "[" &Date& " - "&Time&"]"&"["&strCategoria&"]"&"["&documento&"]"&"["&nrodocumento&"]"&"["&strNombreFichero&"  linea  "& strLinea& ", columna " & lngColumna&"]"&"["&strNumError&"][]"&"["&strCodigoFuente&"]"&"["&strDescripcionError&"]"&"["&sessi&"]"  

public sub agregarLog(linea)
	Dim fs,f
	set fs=Server.CreateObject("Scripting.FileSystemObject")	
	buscarValor("pathLogError")	
	set f=fs.OpenTextFile(valor&"\peregrino_"&year(now())&"_"&Month(now())&"_"&day(now())&".log",8,true)
	f.WriteLine(linea)
	f.Close
	set f=Nothing
	set fs=Nothing
end sub

agregarLog(errorLog)
cargarPaginaError()

sub cargarPaginaError()

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

	Dim mensaje
	Dim conBotones
	Dim persona
	
	Select Case codProducto


		Case 1				
					buscarValor("producto.mesaje.credito.hipotecario.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""	
					url="credito-hipotecario-mensaje.asp"
		Case 2		
					buscarValor("producto.mesaje.cuenta.sueldo.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""	
					url="cuenta-sueldo-mensaje.asp"
		Case 3				
					buscarValor("producto.mesaje.prestamo.personal.mensaje.error.sistema")
					mensaje = valor
					conBotones = false
					persona = ""	
					url="prestamo-personal-mensaje.asp"
		Case 4
					buscarValor("producto.mesaje.prestamo.vehicular.mensaje.error.sistema")
					mensaje = valor	
					conBotones = false
					persona = ""		
					url="prestamo-vehicular-mensaje.asp"
		Case 5								
					buscarValor("producto.mesaje.soat.mensaje.error.sistema")
					mensaje = valor	
					conBotones = false
					persona = ""						
					url="soat-mensaje.asp"
		Case 6		
					buscarValor("producto.mesaje.tarjeta.mensaje.error.sistema")
					mensaje = valor	
					conBotones = false
					persona = ""								
					url="tarjetas-mensaje.asp"				
	End Select	
		Session("mensaje") = mensaje
		Session("conBotones") = conBotones
		Session("persona") = persona	
		Session("codProducto") = codProducto	
		Session("val2") = val2		
		Session("xmlLead") = xmlLead	
		Session("actionLead") = actionLead	
end sub

%>
<%=url%>
