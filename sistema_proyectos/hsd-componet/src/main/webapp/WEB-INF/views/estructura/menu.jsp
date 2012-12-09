<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="accordion-west">


	<c:forEach items="${lstMenus}" var="menu">
		<h3>
			<a href="#"><b> ${menu.nombre}</b> </a>
		</h3>

		<div>
			<ul>
				<c:forEach items="${menu.menus}" var="m">
					<li><a href="javascript:void(0);"> ${m.nombre}</a></li>
				</c:forEach>
			</ul>
		</div>
	</c:forEach>

</div>
