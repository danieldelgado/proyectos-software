<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head lang="es">

<title>Simple Layout Demo</title>

<link rel="stylesheet" href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.2.custom.css" ></c:url>" />
<link rel="stylesheet" href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.9.2.custom.min.css" ></c:url>" />
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

		myLayout = $('body').layout({
			north__size : 40,
			west__size : 200,
			south__size : 40,
			west__onresize : $.layout.callbacks.resizePaneaccordions,
			north__fxName : "drop",
			north__fxSettings_open : {
				duration : 1500
			},
			west__fxName : "drop",
			west__fxSettings_open : {
				duration : 1500
			},
			south__fxName : "drop",
			south__fxSettings_open : {
				duration : 1500
			},
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

		$(".ui-layout-center").tabs({
			collapsible: true
		})
			.find(".ui-tabs-nav")
			.sortable({ axis: 'x', zIndex: 2 });
		
 
		setTimeout(myLayout.resizeall, 1000);

	});
</script>


<style type="text/css">
.ui-layout-pane {
	background: #FFF;
	border: 1px solid #0078ae;
}

.ui-layout-center {
	overflow: auto;
}

.ui-layout-resizer {
	background: #79c9ec;
}

.ui-layout-toggler {
	background: #056b93;
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
				<b>accordion inside a layout-pane</b>
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
				pellentesque purus in massa. aenean in pede.</div>

			<h3>
				<a href="#">Section 4</a>
			</h3>
			<div>
				<p>Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames
					ac turpis egestas.</p>
				<p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
					aenean lacinia mauris vel est.</p>
				<p>Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent
					taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>
			</div>

		</div>

	</div>


	<div class="ui-layout-south"></div>

	<div class="ui-layout-center" style="font-size: 10px;">
			<ul>
				<li><a href="#tabs-center-1">Nunc tincidunt</a></li>
				<li><a href="#tabs-center-2">Proin dolor</a></li>
				<li><a href="#tabs-center-3">Proin dolor</a></li>
				<li><a href="#tabs-center-4">Proin dolor</a></li>
				<li><a href="#tabs-center-5">Proin dolor</a></li>
				<li><a href="#tabs-center-6">Proin dolor</a></li>
				<li><a href="#tabs-center-7">Proin dolor</a></li>
				<li><a href="#tabs-center-8">Proin dolor</a></li>
				<li><a href="#tabs-center-9">Proin dolor</a></li>
				<li><a href="#tabs-center-10">Proin dolor</a></li>
			</ul>
			<!-- add wrapper that Layout will auto-size to 'fill space' -->
			
				<div id="tabs-center-1">
					<P>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. aliquam vulputate,
						pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum
						non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos
						himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus
						hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a,
						lacus.</P>
					<P>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac
						lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit.
						Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id
						euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut
						sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. aenean vehicula
						velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus.
						Vivamus a libero vitae lectus hendrerit hendrerit.</P>
				</div>
				<div id="tabs-center-2">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
				<div id="tabs-center-3">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
			
				<div id="tabs-center-4">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
				<div id="tabs-center-5">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
				<div id="tabs-center-6">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
				<div id="tabs-center-7">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
				<div id="tabs-center-8">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
				<div id="tabs-center-9">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>
				<div id="tabs-center-10">
					<P>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra
						massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus
						malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. aenean aliquet fringilla
						sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi
						adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. aenean vel metus. Ut
						posuere viverra nulla. aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus
						pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
						consectetur tortor et purus.</P>
				</div>

		<br>
		<br>
		<br>
		
	
</div>

</body>
</html>