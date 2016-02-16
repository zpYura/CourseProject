<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>The Paradise-Hotel | Reservation</title>
    <c:import url="/jsp/common/import.jsp"/>
</head>
<body>
<!-- start header -->
<c:import url="fragment/header.jsp" />
<!--start main -->
<div class="main_bg">
<div class="wrap">
	<div class="main">
		<form action="/controller">
			<input type="hidden" name="command" value="book" />
		<div class="res_online">
			<h4>${reservation_page_header}</h4>
			<p class="para">${reservation_page_message}</p>
		</div>
			<div class="span_of_2">
				<div class="span2_of_1">
					<h4>${reservation_page_check_in}:</h4>
					<div class="book_date btm">
						<%--<form>--%>
							<input name="check_in" class="date" id="datepicker" type="text" value="${reservation_page_year_type}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '${reservation_page_year_type}';}">
						<%--</form>--%>
					</div>	
					<div class="sel_room">
						<h4>${reservation_page_room_type}</h4>
						<select id="country" name="roomType" onchange="change_country(this.value)" class="frm-field required">
							<option value="null">${reservation_page_select_message}</option>
				            <option value="SINGLE_ROOM">${main_page_room_for_one}</option>
				            <option value="DOUBLE_ROOM">${main_page_room_for_two}</option>
							<option value="SUITE_ROOM">${main_page_suite}</option>
		        		</select>
					</div>	
					<div class="sel_room left">
						<h4>${reservation_page_number_of_rooms}:</h4>
						<select id="country"  name="numberOfRooms" onchange="change_country(this.value)" class="frm-field required">
							<option value="1">1</option>
				            <option value="2">2</option>
				            <option value="3">3</option>
							<option value="4">4</option>
		        		</select>
					</div>	
				</div>
				<div class="span2_of_1">
					<h4>${reservation_page_check_out}:</h4>
					<div class="book_date btm">
						<%--<form>--%>
							<input name="check_out" class="date" id="datepicker1" type="text" value="${reservation_page_year_type}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '${reservation_page_year_type}';}">
						<%--</form>--%>
					</div>	
					<div class="sel_room">
						<h4>${reservation_page_max_cost}:</h4>
						<input name="maxCost" type="text" class="textbox">
					</div>	
					<div class="sel_room left">
						<h4>${reservation_page_min_cost}:</h4>
						<input name="minCost" type="text" class="textbox">
					</div>	
				</div>
				<div class="clear"></div>
			</div>
			<div >
					<input type="submit" value="${reservation_page_submit_button}" class="reservation_but">
			</div>
			</form>
	</div>
</div>
</div>
<!-- start footer -->
<c:import url="/jsp/client/fragment/footer.jsp" />
</body>
</html>
