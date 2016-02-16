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
				<li><a href="/controller?command=logout" >${exit}</a></li>
				<li></li>
				<li><a href="/jsp/client/main.jsp">${hotel}</a></li> |
				<li><a href="/jsp/client/rooms.jsp">${rooms}</a></li> |
				<li><a href="/jsp/client/reservation.jsp">${reservation}</a></li> |
				<div class="clear" align="center" style="color: #1c2eff;"><p>${book_result_message}</p></div>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="top-nav">
		<nav class="clearfix">
				<ul>
					<li><a href="/jsp/client/main.jsp">${hotel}</a></li>
					<li><a href="/jsp/client/rooms.jsp">${rooms}</a></li>
					<li><a href="/jsp/client/reservation.jsp">${reservation}</a></li>
				</ul>
				<a href="#" id="pull">Menu</a>
			</nav>
		</div>
	</div>
</div>
</div>
</body></html>
