<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>elRTE</title>

	<!-- jQuery and jQuery UI -->
	
	<script src="<c:url value="/resources/js/jquery-1.6.1.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
	<script src="<c:url value="/resources/js/jquery-ui-1.8.13.custom.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/smoothness/jquery-ui-1.8.13.custom.css" ></c:url>" type="text/css" media="screen" charset="utf-8">

	<!-- elRTE -->
	<script src="<c:url value="/resources/js/elrte.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/elrte.min.css" ></c:url>" type="text/css" media="screen" charset="utf-8">

	<!-- elRTE translation messages -->
	<script src="<c:url value="/resources/js/i18n/elrte.es.js" ></c:url>" type="text/javascript" charset="utf-8"></script>



	<script type="text/javascript" charset="utf-8">
		$().ready(function() {
			
			elRTE.prototype.options.panels.custom = [
			                         				'bold', 'italic', 'underline', 'forecolor',
			                         				'fontsize', 'formatblock', 'insertorderedlist', 'insertunorderedlist', 'docstructure'
			                         			];
			                         			elRTE.prototype.options.toolbars.custom = ['custom', 'eol', 'undoredo', 'alignment', 'eol', 'links', 'images'];
			
			
			var opts = {
// 				cssClass : 'el-rte',
				lang     : 'es',
				height   : 450,
				toolbar  : 'complete',
				cssfiles : ['<c:url value="/resources/css/elrte-inner.css" ></c:url>']
			}
			$('#editor').elrte(opts);
		})
	</script>

	<style type="text/css" media="screen">
		body { padding:20px;}
	</style>
	
</head>
<body>


<form action="<c:url value="/guardarContenido" ></c:url>" method="post">
	<div id="editor">
		<h2></h2><img src="http://upload.wikimedia.org/wikipedia/en/1/1c/Hitchhiker%27s_Guide_%28book_cover%29.jpg" style="float:left;margin-top:0px;margin-right:20px;margin-left:20px" height="229" width="140"><h3><br></h3><br><br>
        <p style="padding-left:40px;color:#003366">"Difficulty?"&nbsp;<span style="color:#000000">exclaimed Ford.</span> "Difficulty? What do you mean, difficulty? It's the single simplest machine in the entire Universe!"</p>
        <p style="padding-left:40px">The marketing girl soured him with a look.</p>
        <p style="padding-left:40px"><span style="color:#993333">"Alright, Mr. Wiseguy,"</span> she said, <span style="color:#993333">"if you're so clever, you tell us what colour it should be."</span></p>  
	</div>
</form>	
</body>
</html>
