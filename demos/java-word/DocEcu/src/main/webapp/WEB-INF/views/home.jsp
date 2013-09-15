<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head><meta http-equiv="content-type" content="text/html;charset=utf-8" />
<!-- CDN hosted by Cachefly -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/smoothness/jquery-ui-1.8.13.custom.css" ></c:url>"
	type="text/css" media="screen" charset="utf-8">

<script src="<c:url value="/resources/js/jquery-1.6.1.min.js" ></c:url>"
	type="text/javascript" charset="utf-8"></script>
<script
	src="<c:url value="/resources/js/jquery-ui-1.8.13.custom.min.js" ></c:url>"
	type="text/javascript" charset="utf-8"></script>
<script
	src="<c:url value="/resources/js/tinymce/jquery.tinymce.min.js" ></c:url>"
	type="text/javascript" charset="utf-8"></script>
<script
	src="<c:url value="/resources/js/tinymce/tinymce.min.js" ></c:url>"
	type="text/javascript" charset="utf-8"></script>
</head>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
					
						
						$('textarea.tinymce')
								.tinymce(
										{

											plugins : [
													"advlist autolink autosave link image lists charmap print preview hr anchor pagebreak spellchecker",
													"searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
													"table contextmenu directionality emoticons template textcolor paste fullpage textcolor" ],

											toolbar1 : "btnGrabar | insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | newdocument fullpage | bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | styleselect formatselect fontselect fontsizeselect",
											toolbar2 : "print preview media | forecolor backcolor emoticons | cut copy paste | searchreplace | bullist numlist | outdent indent blockquote | undo redo | link unlink anchor image media code | inserttime preview | forecolor backcolor",
											toolbar3 : "table | hr removeformat | subscript superscript | charmap emoticons | print fullscreen | ltr rtl | spellchecker | visualchars visualblocks nonbreaking template pagebreak restoredraft",

											toolbar_items_size : 'small',

											style_formats : [ {
												title : 'Bold text',
												inline : 'b'
											}, {
												title : 'Red text',
												inline : 'span',
												styles : {
													color : '#ff0000'
												}
											}, {
												title : 'Red header',
												block : 'h1',
												styles : {
													color : '#ff0000'
												}
											}, {
												title : 'Example 1',
												inline : 'span',
												classes : 'example1'
											}, {
												title : 'Example 2',
												inline : 'span',
												classes : 'example2'
											}, {
												title : 'Table styles'
											}, {
												title : 'Table row 1',
												selector : 'tr',
												classes : 'tablerow1'
											} ],

											templates : [ {
												title : 'Test template 1',
												content : 'Test 1'
											}, {
												title : 'Test template 2',
												content : 'Test 2'
											} ],
											setup : function(editor) {
												editor
														.addButton(
																'btnGrabar',
																{
																	text : 'Guardar',
																	icon : false,
																	onclick : function() {
																		$("#formContenido").submit();
																	}
																});
											}

										});

					});
</script>
<body>

<form id="formContenido" method="post" action="<c:url value="/guardarContenido" ></c:url>">
	<textarea name="editor" class="tinymce">
<p>
			<span style="font-family: 'comic sans ms', sans-serif;">FWEFEWFWFEWFWEF</span>
		</p>
<p>
			<span style="font-family: 'comic sans ms', sans-serif;">E<strong>F</strong></span>
		</p>
<p>
			<span style="font-family: 'comic sans ms', sans-serif;"><strong>EWFEW</strong>Fdweqfe</span>w<em>fefewf</em>
		</p>
<hr />
		<hr />

<table style="width: 1px; float: left;" border="1" cellspacing="1"
			cellpadding="1">
			<caption>qwdqwqfwqf</caption>
<tbody>
<tr>
<td></td>
<td>qwfqTest <span
						style="font-family: 'comic sans ms', sans-serif;">2w</span></td>
<td></td>
</tr>
<tr>
<td>qwfwqfqf</td>
<td></td>
<td><span
						style="font-size: 10pt; color: #ff0000; background-color: #99cc00;">qfdqwdf</span></td>
</tr>
</tbody>
</table>
<p></p>

</textarea>
</form>



</body>

</html>
