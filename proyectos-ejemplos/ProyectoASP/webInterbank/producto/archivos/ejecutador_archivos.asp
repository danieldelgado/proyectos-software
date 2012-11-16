<%@LANGUAGE="VBSCRIPT" CODEPAGE="1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>file manager</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
<% 
Dim strFileName
Dim ruta
Dim contenido
Dim token

strFileName = request.serverVariables("APPL_PHYSICAL_PATH") 
ruta = strFileName & "temp"
 
token = "°!°" 
public Sub cargarFile()  
  Const fsoLectura = 1
  Dim objFSO
  Set objFSO = Server.CreateObject("Scripting.FileSystemObject") 
  Dim objTextStream
  Set objTextStream = objFSO.OpenTextFile(ruta & "\parameterIBK.txt", fsoLectura) 
  Do While Not objTextStream.AtEndOfStream      
    liena = objTextStream.ReadLine
	contenido  = contenido  & liena & token
	liena = ""
  Loop
  objTextStream.Close
  Set objTextStream = Nothing
  Set objFSO = Nothing
end sub

public Sub buscarValor(palabra) 
	Response.Write   " palabra : " & palabra  & " <br> "
	Dim liena , lugarPunt1 , length , cadena1  , valor
	lugarPunt1 = instr(trim(contenido),trim(palabra) & " =")
	cadena1 = mid(contenido,lugarPunt1,len(trim(contenido))) 
	lugarPunt1 = (instr(cadena1,token)-1)
	cadena1 = mid(cadena1,1,lugarPunt1)
	lugarPunt1 = instr(trim(cadena1),"=")
	cadena1 = mid(cadena1,lugarPunt1+1,len(trim(cadena1)))
	valor = cadena1
	Response.Write " valor : " & valor &  "  <br> " 
end sub

public sub agregarLog(linea)
	dim fs,f
	set fs=Server.CreateObject("Scripting.FileSystemObject")
	set f=fs.OpenTextFile(ruta & "\logIBK.txt",8,true)
	f.WriteLine(linea)
	f.Close
	set f=Nothing
	set fs=Nothing
end sub

cargarFile()
buscarValor("DIRECTORYIO")
agregarLog("agregarLog lina 1")
 

%> 


</body>
</html>