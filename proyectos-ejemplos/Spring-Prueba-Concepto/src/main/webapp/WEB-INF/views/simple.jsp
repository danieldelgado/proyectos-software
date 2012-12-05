<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

	<title>Simple Layout Demo</title>


	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.js" ></c:url>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.min.js" ></c:url>" ></script> 
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.layout.js" ></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.layout.min.js" ></c:url>"></script>

	<script type="text/javascript">

	var myLayout; // a var is required because this page utilizes: myLayout.allowOverflow() method

	$(document).ready(function () {
		myLayout = $('body').layout({
			north__size : 50,
			west__size : 300,
			south__size : 50,
			center : {
				onresize : function() {
				}
			}						
		});

		myLayout.options.north.minSize = 50;
		myLayout.options.north.maxSize = 80;
		myLayout.options.west.minSize = 300;
		myLayout.options.west.maxSize = 320;
		myLayout.options.south.minSize = 50;
		myLayout.options.south.maxSize = 80;
		
 	});

	</script>


	<style type="text/css">

	.ui-layout-pane { /* all 'panes' */ 
		background: #FFF; 
		border: 1px solid #BBB; 
		padding: 10px; 
		overflow: auto;
	} 

	.ui-layout-resizer { /* all 'resizer-bars' */ 
		background: #DDD; 
	} 

	.ui-layout-toggler { /* all 'toggler-buttons' */ 
		background: #AAA; 
	} 
	</style>

	<style type="text/css">
	

	body {
		font-family: Arial, sans-serif;
		font-size: 0.85em;
	}
	p {
		margin: 1em 0;
	}


	ul {
		/* rules common to BOTH inner and outer UL */
		z-index:	100000;
		margin:		1ex 0;
		padding:	0;
		list-style:	none;
		cursor:		pointer;
		border:		1px solid Black;
		/* rules for outer UL only */
		width:		15ex;
		position:	relative;
	}
	ul li {
		background-color: #EEE;
		padding: 0.15em 1em 0.3em 5px;
	}
	ul ul {
		display:	none;
		position:	absolute;
		width:		100%;
		left:		-1px;
		/* Pop-Up */
		bottom:		0;
		margin:		0;
		margin-bottom: 1.55em;
	}
	.ui-layout-north ul ul {
		/* Drop-Down */
		bottom:		auto;
		margin:		0;
		margin-top:	1.45em;
	}
	ul ul li		{ padding: 3px 1em 3px 5px; }
	ul ul li:hover	{ background-color: #FF9; }
	ul li:hover ul	{ display:	block; background-color: #EEE; }

	</style>

</head>
<body>

<div class="ui-layout-north" >

</div>

<div class="ui-layout-west">

</div>

<div class="ui-layout-south">
	
</div>

<div class="ui-layout-center">
	
</div>

</body>
</html>