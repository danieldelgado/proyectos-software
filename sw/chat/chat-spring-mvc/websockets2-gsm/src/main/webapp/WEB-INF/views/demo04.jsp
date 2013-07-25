<!doctype html>

<html lang="en">
<head>
<meta charset="utf-8" />
<title>jQuery UI Effects - Hide Demo</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<style>
body {
	font-size: 10px;
}

.toggler {
	position: fixed;
	top: 10px;
	right: 0px;
	z-index: 100;
	width: : 100%;
	float: right;
	margin: 0px;
	display: block;
	bottom: 0px;
}

#btnAparece {
	padding: .5em 1em;
	text-decoration: none;
}

#btnDesaparece {
	padding: .5em 1em;
	text-decoration: none;
}

#effect {
	width: 240px;
	position: relative;
    overflow-y: auto;
	height: 97%;
}

#effect h3 {
	margin: 0;
	padding: 0.4em;
	text-align: center;
}
#lstusuario {
	bottom: 5px;
}

</style>
</head>
<body>
	<div class="toggler">
<div id="effect" class="ui-widget-content ui-corner-all">
<h3 class="ui-widget-header ui-corner-all">Hide</h3>
			<div class="lstusuario">				
					<div class="user_chat">
						<p>
							<span>usuario </span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 1</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 2</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 3</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 4</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 5</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 6</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 7</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 8</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 9</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 11</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 12</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 13</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 14</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 15</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 16</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 17</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 18</span>
						</p>
					</div>
					<div class="user_chat">
						<p>
							<span>usuario 19</span>
						</p>
					</div>
			</div>
		</div>
	</div>
	<a href="#" id="btnAparece" class="ui-state-default ui-corner-all">Aparece
		Run Effect</a>
	<a href="#" id="btnDesaparece" class="ui-state-default ui-corner-all">Desaparece
		Run Effect</a>
	<div style="height: 1500px"></div>
	<div id="dialog"></div>
</body>
<script>
	$(function() {
		var dialog = $('#dialog');
		var lista_user_chat = $(".user_chat");
		
		$("#effect").hide();
		
		$(dialog).dialog({
			autoOpen : false,
			buttons : {
				'Ok' : function() {
					$(this).dialog('close');
				}
			},
			close : function(event, ui) {
				$(this).dialog('close');
			}
		});
		
		function runEffectAparece() {
			var selectedEffect = "drop";
			var options = {
				direction : "right"
			};
			$("#effect").show(selectedEffect, options, 500, function() {
			});
		};
		
		function runEffectDesaparece() {
			var selectedEffect = "drop";
			var options = {
				direction : "right"
			};
			if ($(dialog).dialog("isOpen") == true) {
				$(dialog).dialog("close");
			}
			$("#effect").hide(selectedEffect, options, 500, function() {});			
		};
		
		$("#btnAparece").click(function() {
			runEffectAparece();
			return false;
		});
		
		$("#btnDesaparece").click(function() {
			runEffectDesaparece();
			return false;
		});
		
		lista_user_chat.click(function() {
			var target = $(this);
			var tit = $(target).find("span").html();
			$(dialog).dialog("option", "title", "My modal form tit:" + tit);
			$(dialog).dialog("option", "position", {
				my : "right-130",
				of : target
			});
			if ($(dialog).dialog("isOpen") == false) {
				$(dialog).dialog("open");
			}
		});
		
	});
</script>
</html>