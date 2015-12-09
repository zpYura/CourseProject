<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Header</title>
</head>
<body>
<!-- start header -->
<div class="header_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<a href="/jsp/client/main.jsp"><img src="/images/logo.png" alt=""></a>
		</div>
		<div class="h_right">
			<!--start menu -->
			<ul class="menu">
				<li class="active"> ${hello}, ${user}</li> |
				<li><a href="/jsp/client/main.jsp">${hotel}</a></li> |
				<li><a href="/jsp/client/rooms.jsp">${rooms}</a></li> |
				<li><a href="/jsp/client/reservation.jsp">${reservation}</a></li> |
				<%--develop later--%>
				<%--<li><a href="/jsp/client/activities.jsp">activities</a></li> |--%>
				<%--<li><a href="/jsp/client/contact.jsp">${contact}</a></li>--%>
				<div class="clear"></div>
			</ul>
			<%--develop later--%>
			<!-- start profile_details -->
					<%--<form class="style-1 drp_dwn"  >--%>
						<%--<div class="row">--%>
							<%--<div class="grid_3 columns">--%>
								<%--<select class="custom-select" id="select-1">--%>
									<%--<option selected="selected">EN</option>--%>
									<%--<option>RU</option>--%>
									<%--<option>ES</option>--%>
								<%--</select>--%>
							<%--</div>		--%>
						<%--</div>		--%>
					<%--</form>--%>
		</div>
		<div class="clear"></div>
		<div class="top-nav">
		<nav class="clearfix">
				<ul>
					<li class="active"><a href="/jsp/client/main.jsp">hotel</a></li>
					<li><a href="/jsp/client/rooms.jsp">rooms & suits</a></li>
					<li><a href="/jsp/client/reservation.jsp">reservation</a></li>
					<li><a href="/jsp/client/activities.jsp">activities</a></li>
					<li><a href="/jsp/client/contact.jsp">contact</a></li>
				</ul>
				<a href="#" id="pull">Menu</a>
			</nav>
		</div>
	</div>
</div>
</div>
</body></html>
