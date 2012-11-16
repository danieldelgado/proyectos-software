<%
Dim TestValue 
Dim lblResult  

TestValue = Trim(Request.Form("captcha"))

Response.ContentType = "application/json"

if Request.ServerVariables("REQUEST_METHOD") = "POST" then
		 if IsEmpty(Session("ASPCAPTCHA")) or Trim(Session("ASPCAPTCHA")) = "" then
                lblResult = "false"
         end if
    TestValue = Replace(TestValue, "i", "I", 1, -1, 1)
    TestValue = Replace(TestValue, "İ", "I", 1, -1, 1)
    TestValue = Replace(TestValue, "ı", "I", 1, -1, 1)
	TestValue = UCase(TestValue)    
    if (StrComp(TestValue, Trim(Session("ASPCAPTCHA")), 1) = 0)  then
        'lblResult = "{"& chr(34) &"lblResult"& chr(34) &": "& chr(34) &"1"& chr(34) &"}" 
        lblResult = "true" 
    else
        'lblResult = "{"& chr(34) &"lblResult"& chr(34) &": "& chr(34) &"0"& chr(34) &"}"  
         lblResult = "false"        
    end if  
    'Session("ASPCAPTCHA") = vbNullString
    'Session.Contents.Remove("ASPCAPTCHA")      
end if
%>
<%=lblResult%>