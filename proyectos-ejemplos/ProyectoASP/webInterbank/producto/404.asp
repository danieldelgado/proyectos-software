<%'Obtenemos el objeto ASPError
Set objASPError=Server.GetLastError()
'Se obtienen los valores de sus propiedades
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
'Se crea la cadena del mensaje de error
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
'se marca la columna que ha producido el error
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
'Se muestra el error al cliente%>
<html>
<head>
<title>Errores 500:100</title>
</head>
<body>
<PRE><%=Server.HTMLEncode(strDetalles)%></PRE>
</body>
</html>