<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<title>Simple Layout Demo</title>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />


<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.8.2.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui-1.9.1.custom.min.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.layout.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.layout.min.js" ></c:url>"></script>

<script type="text/javascript">
	var myLayout; // a var is required because this page utilizes: myLayout.allowOverflow() method
	var uilayoutwest;
	var pnlMenu ;
	$(document).ready(function() {

		
		myLayout = $('body').layout({
			north__size : 40,
			west__size : 200,
			south__size : 40,
			center : {
				onresize : function() {
					pnlMenu = $("#pnlMenu");
					alert(uilayoutwest.height());
					pnlMenu.height(uilayoutwest.height());
					alert(pnlMenu.height());
				}
			}
		});

		myLayout.options.north.minSize = 40;
		myLayout.options.north.maxSize = 80;
		myLayout.options.west.minSize = 200;
		myLayout.options.west.maxSize = 250;
		myLayout.options.south.minSize = 40;
		myLayout.options.south.maxSize = 80;

		uilayoutwest = $(".ui-layout-west");
		
		pnlMenu = $("#pnlMenu");
		alert(uilayoutwest.height());
		pnlMenu.height(uilayoutwest.height());
		alert(pnlMenu.height());
		
		
		$("#accordion").accordion({
			heightStyle : "fill"
		});

		$("#accordion-resizer").resizable({
			minHeight : 140,
			minWidth : 200,
			resize : function() {
				$("#accordion").accordion("refresh");
			}
		});

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

ul { /* rules common to BOTH inner and outer UL */
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

#accordion-resizer {
	padding: 10px;
	width: 150px;
}
</style>

</head>
<body>

	<div class="ui-layout-north"></div>

	<div class="ui-layout-west">
	
		<div id="pnlMenu" >
		
			<div id="accordion-resizer" class="ui-widget-content">
				<div id="accordion">
					<h3>Section 1</h3>
					<div>
						<p>Mauris mauris ante, blandit et, ultrices a, suscipit eget,
							quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida
							in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros.
							Nam mi. Proin viverra leo ut odio. Curabitur malesuada.
							Vestibulum a velit eu ante scelerisque vulputate.</p>
					</div>
					<h3>Section 2</h3>
					<div>
						<p>Sed non urna. Donec et ante. Phasellus eu ligula.
							Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet
							laoreet, mauris turpis porttitor velit, faucibus interdum tellus
							libero ac justo. Vivamus non quam. In suscipit faucibus urna.</p>
					</div>
					<h3>Section 3</h3>
					<div>
						<p>Nam enim risus, molestie et, porta ac, aliquam ac, risus.
							Quisque lobortis. Phasellus pellentesque purus in massa. Aenean
							in pede. Phasellus ac libero ac tellus pellentesque semper. Sed
							ac felis. Sed commodo, magna quis lacinia ornare, quam ante
							aliquam nisi, eu iaculis leo purus venenatis dui.</p>
						<ul>
							<li>List item one</li>
							<li>List item two</li>
							<li>List item three</li>
						</ul>
					</div>
					<h3>Section 4</h3>
					<div>
						<p>Cras dictum. Pellentesque habitant morbi tristique senectus
							et netus et malesuada fames ac turpis egestas. Vestibulum ante
							ipsum primis in faucibus orci luctus et ultrices posuere cubilia
							Curae; Aenean lacinia mauris vel est.</p>
						<p>Suspendisse eu nisl. Nullam ut libero. Integer dignissim
							consequat lectus. Class aptent taciti sociosqu ad litora torquent
							per conubia nostra, per inceptos himenaeos.</p>
					</div>
				</div>
			</div>
			
		</div>

	</div>

	<div class="ui-layout-south"></div>

	<div class="ui-layout-center"></div>

</body>
</html>