<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head><!-- CDN hosted by Cachefly -->
	<link rel="stylesheet" href="<c:url value="/resources/css/smoothness/jquery-ui-1.8.13.custom.css" ></c:url>" type="text/css" media="screen" charset="utf-8">
	
	<script src="<c:url value="/resources/js/jquery-1.6.1.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
	<script src="<c:url value="/resources/js/jquery-ui-1.8.13.custom.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
	<script src="<c:url value="/resources/js/tinymce/jquery.tinymce.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
	<script src="<c:url value="/resources/js/tinymce/tinymce.min.js" ></c:url>" type="text/javascript" charset="utf-8"></script>
</head>
<script type="text/javascript">
$(document).ready(function() {
    $('textarea.tinymce').tinymce({
        script_url: 'http://tinymce.moxiecode.com/js/tinymce/jscripts/tiny_mce/tiny_mce.js',
//         theme : "modern",
//         plugins : "table,preview,paste",
// 		skin: 'o2k7',
// 		theme_advanced_buttons1 : "bold,italic,underline,strikethrough,|,sup,sub,|,justifyleft,justifycenter,justifyright,justifyfull,|,outdent,indent,|,fontsizeselect,styleselect,formatselect,|,removeformat",
// 		theme_advanced_buttons2 : "bullist,numlist,|,blockquote,cite,abbr,acronym,ins,del,|,link, unlink,|,table,|,hr,|,cut,copy,paste,pastetext,pasteword,|,preview,code",
// 		theme_advanced_buttons3 : "",
// 		theme_advanced_buttons4 : "",
// 		theme_advanced_toolbar_location : "top",
// 		theme_advanced_toolbar_align : "left",
// 		theme_advanced_statusbar_location : "bottom",
// 		theme_advanced_resizing : true,
		  plugins: [
		            "advlist autolink lists link image charmap print preview hr anchor pagebreak",
		            "searchreplace wordcount visualblocks visualchars code fullscreen",
		            "insertdatetime media nonbreaking save table contextmenu directionality",
		            "emoticons template paste textcolor "
		        ],
		        toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
		        toolbar2: "print preview media | forecolor backcolor emoticons",
		        image_advtab: true,
// 		content_css : "css/demo.css",

		// Style formats
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red H1', block : 'h1', styles : {color : '#ff0000'}},
		],

		formats : {
			alignleft : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'left'},
			aligncenter : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'center'},
			alignright : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'right'},
			alignfull : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'full'},
			bold : {inline : 'span', 'classes' : 'bold'},
			italic : {inline : 'span', 'classes' : 'italic'},
			underline : {inline : 'span', 'classes' : 'underline', exact : true},
			strikethrough : {inline : 'del'}
		}
    });
    
   
    
  });
</script>
<body>
<textarea name="text" class="tinymce"></textarea>




</body>

</html>
