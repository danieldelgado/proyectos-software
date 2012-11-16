<% 
Dim strFileName
Dim ruta
Dim contenido 
Dim token
Dim valor

strFileName = request.serverVariables("APPL_PHYSICAL_PATH") 
ruta = strFileName & "producto\archivos\data_properties"
 
token = "||" 
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
	Dim liena , lugarPunt1 , length , cadena1 
	lugarPunt1 = instr(trim(contenido),trim(palabra) & " =")
	cadena1 = mid(contenido,lugarPunt1,len(trim(contenido))) 
	lugarPunt1 = (instr(cadena1,token)-1)
	cadena1 = mid(cadena1,1,lugarPunt1)
	lugarPunt1 = instr(trim(cadena1),"=")
	cadena1 = mid(cadena1,lugarPunt1+1,len(trim(cadena1)))
	valor = cadena1
end sub
public sub agregarLog(linea)
	Dim fs,f
	set fs=Server.CreateObject("Scripting.FileSystemObject")
	buscarValor("pathLogError")
	Dim r:r=valor
	set f=fs.OpenTextFile("C:\WebPublica\IBPeregrino\Log\peregrino_"&year(now())&"_"&Month(now())&"_"&day(now())&".log",8,true)
	f.WriteLine(linea)
	f.Close
	set f=Nothing
	set fs=Nothing
end sub


public sub agregar_log(linea)
	Dim fs,f
	set fs=Server.CreateObject("Scripting.FileSystemObject")	
	buscarValor("pathLogError")	
	set f=fs.OpenTextFile(valor&"\peregrino_"&year(now())&"_"&Month(now())&"_"&day(now())&".log",8,true)
	f.WriteLine( "["&date()&" - "& time() & "]" & "["& linea &"]")
	f.Close
	set f=Nothing
	set fs=Nothing
end sub

cargarFile()
%> 