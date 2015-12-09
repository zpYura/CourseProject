<%@ page import="java.util.Locale" %>
<%@ page import="by.epam.managers.LanguageManager" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zpYura
  Date: 02.12.2015
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%--<html><head><title>JSP Timing</title></head>
<body>
<h5>Счетчик времени от запуска приложения до нажатия кнопки</h5>
<jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
<form name="Simple" action="timeaction" method="POST">
  <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
  <input type="submit" name="button" value="Посчитать время"/>
</form>
</body></html>--%>
<html>
<head>
<title>The Paradise-Hotel | Hotel</title>
<c:import url="/jsp/common/import.jsp"/>
</head>
<body>
<!-- start header -->
<%--<c:import url="/jsp/client/fragment/header.jsp" />--%>
<!----start-images-slider---->
		<%--<div class="images-slider">--%>
			<%--<!-- start slider -->--%>
		    <%--<div id="fwslider">--%>
		        <%--<div class="slider_container">--%>
		            <%--<div class="slide"> --%>
		                <%--<!-- Slide image -->--%>
		                    <%--<img src="images/slider-bg.jpg" alt=""/>--%>
		                <%--<!-- /Slide image -->--%>
		                <%--<!-- Texts container -->--%>
		                <%--<div class="slide_content">--%>
		                    <%--<div class="slide_content_wrap">--%>
		                        <%--<!-- Text title -->--%>
		                        <%--<h4 class="title"><i class="bg"></i>Lorem Ipsum is simply <span class="hide">dummy text</span></h4>--%>
		                        <%--<h5 class="title1"><i class="bg"></i>Morbi justo <span class="hide" >condimentum accumsan</span></h5>--%>
		                        <%--<!-- /Text title -->--%>
		                    <%--</div>--%>
		                <%--</div>--%>
		                 <%--<!-- /Texts container -->--%>
		            <%--</div>--%>
		            <%--<!-- /Duplicate to create more slides -->--%>
		            <%--<div class="slide">--%>
		                <%--<img src="images/slider-bg.jpg" alt=""/>--%>
		                <%--<div class="slide_content">--%>
		                     <%--<div class="slide_content_wrap">--%>
		                        <%--<!-- Text title -->--%>
		                        <%--<h4 class="title"><i class="bg"></i>Morbi justo <span class="hide"> condimentum </span>text</h4>--%>
		                        <%--<h5 class="title1"><i class="bg"></i>Lorem Ipsum is <span class="hide">simply dummy text</span> </h5>--%>
		                        <%--<!-- /Text title -->--%>
		                    <%--</div>--%>
		                <%--</div>--%>
		            <%--</div>--%>
		            <%--<!--/slide -->--%>
		        <%--</div>--%>
		        <%--<div class="timers"> </div>--%>
		        <%--<div class="slidePrev"><span> </span></div>--%>
		        <%--<div class="slideNext"><span> </span></div>--%>
		    <%--</div>--%>
		    <%--<!--/slider -->--%>
		<%--</div>--%>
<!--start main -->
<%--<div class="main_bg">--%>
<%--<div class="wrap">--%>
	<%--<div class="online_reservation">--%>
	<%--<div class="b_room">--%>
		<%--<div class="booking_room">--%>
			<%--<h4>book a room online</h4>--%>
			<%--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>--%>
		<%--</div>--%>
		<%--<div class="reservation">--%>
			<%--<ul>--%>
				<%--<li class="span1_of_1">--%>
					<%--<h5>type of room:</h5>--%>
					<%--<!----------start section_room----------->--%>
					<%--<div class="section_room">--%>
						<%--<select id="country" onchange="change_country(this.value)" class="frm-field required">--%>
							<%--<option value="null">Select a type of room</option>--%>
				            <%--<option value="null">Suite room</option>         --%>
				            <%--<option value="AX">Single room</option>--%>
							<%--<option value="AX">Double room</option>--%>
		        		<%--</select>--%>
					<%--</div>	--%>
				<%--</li>--%>
				<%--<li  class="span1_of_1 left">--%>
					<%--<h5>check-in-date:</h5>--%>
					<%--<div class="book_date">--%>
						<%--<form>--%>
							<%--<input class="date" id="datepicker" type="text" value="DD/MM/YY" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'DD/MM/YY';}">--%>
						<%--</form>--%>

					<%--</div>					--%>
				<%--</li>--%>
				<%--<li  class="span1_of_1 left">--%>
					<%--<h5>check-out-date:</h5>--%>
					<%--<div class="book_date">--%>
						<%--<form>--%>
							<%--<input class="date" id="datepicker1" type="text" value="DD/MM/YY" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'DD/MM/YY';}">--%>
						<%--</form>--%>
					<%--</div>		--%>
				<%--</li>--%>
				<%--<li class="span1_of_2 left">--%>
					<%--<h5>Adults:</h5>--%>
					<%--<!----------start section_room----------->--%>
					<%--<div class="section_room">--%>
						<%--<select id="country" onchange="change_country(this.value)" class="frm-field required">--%>
							<%--<option value="null">1</option>--%>
				            <%--<option value="null">2</option>         --%>
				            <%--<option value="AX">3</option>--%>
							<%--<option value="AX">4</option>--%>
		        		<%--</select>--%>
					<%--</div>					--%>
				<%--</li>--%>
				<%--<li class="span1_of_3">--%>
					<%--<div class="date_btn">--%>
						<%--<form action="select_language" method="POST">--%>
							<%--<input type="submit" value="book now" />--%>
						<%--</form>--%>
					<%--</div>--%>
				<%--</li>--%>
				<%--<div class="clear"></div>--%>
			<%--</ul>--%>
		<%--</div>--%>
		<%--<div class="clear"></div>--%>
		<%--</div>--%>
	<%--</div>--%>
	<%--<!--start grids_of_3 -->--%>
	<%--<div class="grids_of_3">--%>
		<%--<div class="grid1_of_3">--%>
			<%--<div class="grid1_of_3_img">--%>
				<%--<a href="jsp/client/details.jsp">--%>
					<%--<img src="images/pic2.jpg" alt="" />--%>
					<%--<span class="next"> </span>--%>
				<%--</a>--%>
			<%--</div>--%>
			<%--<h4><a href="#">single room<span>120$</span></a></h4>--%>
			<%--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>--%>
		<%--</div>--%>
		<%--<div class="grid1_of_3">--%>
			<%--<div class="grid1_of_3_img">--%>
				<%--<a href="jsp/client/details.jsp">--%>
					<%--<img src="images/pic1.jpg" alt="" />--%>
					<%--<span class="next"> </span>--%>
				<%--</a>--%>
			<%--</div>--%>
			<%--<h4><a href="#">double room<span>180$</span></a></h4>--%>
			<%--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>--%>
		<%--</div>--%>
		<%--<div class="grid1_of_3">--%>
			<%--<div class="grid1_of_3_img">--%>
				<%--<a href="jsp/client/details.jsp">--%>
					<%--<img src="images/pic3.jpg" alt="" />--%>
					<%--<span class="next"> </span>--%>
				<%--</a>--%>
			<%--</div>--%>
			<%--<h4><a href="#">suite room<span>210$</span></a></h4>--%>
			<%--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>--%>
		<%--</div>--%>
		<%--<div class="clear"></div>--%>
	<%--</div>	--%>
<%--</div>--%>
<%--</div>--%>
<!--start footer -->
<%--<c:import url="/jsp/common/footer.jsp" />--%>
<%--<jsp:useBean id="ob" scope="session" class="by.epam.managers.LanguageManager" />--%>
<%--${ob.formLogin(locale,sessionScope)}--%>
<%
	Locale current = Locale.getDefault();
	LanguageManager.setLanguage(current,session);
%>
<jsp:forward page="jsp/common/login.jsp"/>
</body>
</html>

