<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>The Paradise-Hotel |Bills </title>
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
					<h4>${admin_bills_page_header}</h4>
					<p class="para">${admin_bills_page_first_description}</p>
				</div>
				<div class="grids_of_2">
					<div class="grids_of_para">
						<h1>${admin_bills_page_header}</h1>
						<table class="table3">
							<thead>
							<tr>
								<th scope="col"  class="tablespecHeader">Id</th>
								<th scope="col" >${admin_bills_page_cost}</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="elem" items="${billsList}" varStatus="status">
								<tr>
									<td><a href="/jsp/admin/main.jsp"><c:out value="${elem.getId()}"/></a></td>
									<td><c:out value="${elem.getCost()}"/></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="clear"></div>
				</div>
				<div class="grids_of_2">
					<div class="grids_of_para">
						<h1>${admin_bills_page_room_guide}</h1>
						<table class="table3">
							<thead>
							<tr>
								<th scope="col"  class="tablespecHeader">Id</th>
								<th scope="col" >${admin_bills_page_room_id}</th>
								<th scope="col" >${admin_bills_page_request_id}</th>
								<th scope="col" >${admin_bills_page_bill_id}</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="elem" items="${roomGuidesList}" varStatus="status">
								<tr>
									<td><c:out value="${elem.getId()}"/></td>
									<td><c:out value="${elem.getRoomId()}"/></td>
									<td><c:out value="${elem.getRequestId()}"/></td>
									<td><c:out value="${elem.getBillId()}"/></td>
								</tr>

							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<!-- start footer -->
<c:import url="/jsp/admin/fragment/footer.jsp" />
</body>
</html>
