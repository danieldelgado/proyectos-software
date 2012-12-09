<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head lang="es">

<title>Simple Layout Demo</title>

<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.9.1.custom.css" ></c:url>" />
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.9.1.custom.min.css" ></c:url>" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.3.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.9.2.custom.min.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.layout.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.layout.min.js" ></c:url>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.layout.resize.js" ></c:url>"></script>

<script type="text/javascript">

	var myLayout;
	var uilayoutwest;
	$(document).ready(function() {
		uilayoutwest = $(".ui-layout-west");
		pnlMenu = $("#pnlMenu");
		
		myLayout = $('body').layout({
			north__size : 40,
			west__size : 200,
			south__size : 40,
			west__onresize : $.layout.callbacks.resizePaneAccordions, 	
			north__fxName:"drop",	
			north__fxSettings_open:	{ duration: 1500 },		
			west__fxName:"drop",	
			west__fxSettings_open:	{ duration: 1500 },		
			south__fxName:"drop",	
			south__fxSettings_open:	{ duration: 1500 },		
			center : {
				onresize : function() {
				}
			}
		});

		myLayout.options.north.minSize = 40;
		myLayout.options.north.maxSize = 80;
		myLayout.options.west.minSize = 200;
		myLayout.options.west.maxSize = 250;
		myLayout.options.south.minSize = 40;
		myLayout.options.south.maxSize = 80;

		var icons = {
			header : "ui-icon-circle-arrow-e",
			activeHeader : "ui-icon-circle-arrow-s"
		};

		$("#accordion-west").accordion({
			icons : icons,
			heightStyle : "fill",
			fillSpace : true
		});
		
		setTimeout(myLayout.resizeAll, 1000);
		
	});
</script>


<style type="text/css">
.ui-layout-pane {
	background: #FFF;
	border: 1px solid #BBB;
}

.ui-layout-center {
	overflow: auto;
}

.ui-layout-resizer {
	background: #DDD;
}

.ui-layout-toggler {
	background: #AAA;
}

body {
	font-family: Arial, sans-serif;
	font-size: 0.85em;
}

p {
	margin: 1em 0;
}

ul {
	z-index: 100000;
	margin: 1ex 0;
	padding: 0;
	list-style: none;
	cursor: pointer;
	border: 1px solid Black;
	/* rules for outer UL only */
	width: 15ex;
	position: relative;
}

ul li {
	background-color: #EEE;
	padding: 0.15em 1em 0.3em 5px;
}

ul ul {
	display: none;
	position: absolute;
	width: 100%;
	left: -1px;
	/* Pop-Up */
	bottom: 0;
	margin: 0;
	margin-bottom: 1.55em;
}

.ui-layout-north ul ul { /* Drop-Down */
	bottom: auto;
	margin: 0;
	margin-top: 1.45em;
}

ul ul li {
	padding: 3px 1em 3px 5px;
}

ul ul li:hover {
	background-color: #FF9;
}

ul li:hover ul {
	display: block;
	background-color: #EEE;
}
</style>

</head>
<body>

	<div class="ui-layout-north"></div>
	
	<div class="ui-layout-west" style="font-size: 10px;">
	
		<div id="accordion-west">

			<h3>
				<a href="#">Section 1</a>
			</h3>
			<div>
				<b>Accordion inside a layout-pane</b>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum condimentum neque a
					velit laoreet dapibus. Etiam eleifend tempus pharetra.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
				<p>.</p>
			</div>

			<h3>
				<a href="#">Section 2</a>
			</h3>
			<div>
				<p style="font-weight: bold;">Sed Non Urna</p>
				<p>Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor
					at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo.</p>
				<p>Vivamus non quam. In suscipit faucibus urna.</p>
			</div>

			<h3>
				<a href="#">Section 3</a>
			</h3>
			<div>Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus
				pellentesque purus in massa. Aenean in pede.</div>

			<h3>
				<a href="#">Section 4</a>
			</h3>
			<div>
				<p>Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames
					ac turpis egestas.</p>
				<p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
					Aenean lacinia mauris vel est.</p>
				<p>Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent
					taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>
			</div>

		</div>

	</div>


	<div class="ui-layout-south"></div>

	<div class="ui-layout-center"></div>

</body>
</html>