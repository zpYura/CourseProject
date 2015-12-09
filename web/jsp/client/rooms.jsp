<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>The Paradise-Hotel | Rooms </title>
	<c:import url="/jsp/common/import.jsp"/>
</head>
<body>
<!-- start header -->
<c:import url="fragment/header.jsp" />
<!--start main -->
<div class="main_bg">
<div class="wrap">
	<div class="main">
		<div class="content">
			<div class="room">
				<h4>${room_page_header}</h4>
				<p class="para">${room_page_first_description}</p>
			</div>
				<div class="grids_of_2">
					<div class="grids_of_img">
						<img src="/images/pic4.jpg" alt=""/>
					</div>
					<div class="grids_of_para">
					<p class="para">${room_page_second_description}</p>
					</div>
					<div class="clear"></div>					
				</div>
				<div class="grids_of_2">
					<div class="grids_of_img">
						<img src="/images/pic5.jpg" alt=""/>
					</div>
					<div class="grids_of_para">
					<p class="para">${room_page_third_description}</p>
					</div>
					<div class="clear"></div>					
				</div>						

		</div>
		<div class="sidebar">
			 <div class="date_btn">
				<form action="reservation.jsp">
					<input type="submit" value="${room_page_button}" style="width: 82px;">
				</form>
			</div>
			<h4>${room_page_features_description}</h4>
			<ul class="s_nav">
				<li><a href="#">${room_page_feature1}</a></li>
				<li><a href="#">${room_page_feature2}</a></li>
				<li><a href="#">${room_page_feature3}</a></li>
				<li><a href="#">${room_page_feature4}</a></li>
				<li><a href="#">${room_page_feature5}</a></li>
			</ul>
			<h4>${room_page_accepts}</h4>
			<ul class="s_nav1">
				<li><a class="icon1" href="#"></a></li>
				<li><a class="icon2" href="#"></a></li>
				<li><a class="icon3" href="#"></a></li>
				<li><a class="icon4" href="#"></a></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>
</div>
<!-- start footer -->
<c:import url="/jsp/client/fragment/footer.jsp" />
</body>
</html>
