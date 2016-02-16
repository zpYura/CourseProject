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
			<a href="/jsp/admin/main.jsp"><img src="/images/logo.png" alt=""></a>
		</div>
		<div class="h_right">
			<!--start menu -->
			<ul class="menu" style="width: 25%">
				<li class="active"> ${hello}, ${user}</li> |
				<li><a href="/controller?command=logout" >${exit}</a></li>
			</ul>
			<ul class="menu">
				<li><a href="/jsp/admin/main.jsp">${hotel}</a></li> |
				<li><a href="/controller?command=request_all">${requests}</a></li> |
				<li><a href="/controller?command=rooms_all">${rooms}</a></li> |
				<li><a href="/controller?command=bills_all">${bills}</a></li> |
				<li><a href="/controller?command=clients_all">${admin_clients_header}</a></li>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="top-nav">
		<nav class="clearfix">
				<ul>
					<li><a href="/jsp/admin/main.jsp">${hotel}</a></li>
					<li><a href="/controller?command=request_all">${requests}</a></li>
					<li><a href="/controller?command=rooms_all">${rooms}</a></li>
					<li><a href="/controller?command=bills_all">${bills}</a></li>
					<li><a href="/controller?command=clients_all">${admin_clients_header}</a></li>
				</ul>
				<a href="#" id="pull">Menu</a>
			</nav>
		</div>
	</div>
</div>
</div>
</body></html>
