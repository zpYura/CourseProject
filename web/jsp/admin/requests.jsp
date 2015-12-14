<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>The Paradise-Hotel | Requests </title>
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
				<h4>${requests_page_header}</h4>
				<p class="para">${requests_page_first_description}</p>
			</div>
				<div class="grids_of_2">
					<div class="grids_of_para">
						<table class="table3">
							<thead>
							<tr>
								<th scope="col"  class="tablespecHeader">Id</th>
								<th scope="col" >${requests_page_rooms}</th>
								<th scope="col" >${requests_page_type}</th>
								<th scope="col" >${requests_page_in_date}</th>
								<th scope="col" >${requests_page_out_date}</th>
								<th scope="col" >${requests_page_max_cost}</th>
								<th scope="col" >${requests_page_min_cost}</th>
								<th scope="col" >${requests_page_client_id}</th>
								<th scope="col">${requests_page_admin_id}</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="elem" items="${requestsList}" varStatus="status">
							<tr>
							<td><a href="/controller?command=compute_request&request_id=${elem.getId()}"><c:out value="${elem.getId()}"/></a></td>
							<td><c:out value="${elem.getNumberOfbeds()}"/></td>
							<td><c:out value="${elem.getType()}"/></td>
							<td><c:out value="${elem.getInDate()}"/></td>
							<td><c:out value="${elem.getOutDate()}"/></td>
							<td><c:out value="${elem.getMaxCost()}"/></td>
							<td><c:out value="${elem.getMinCost()}"/></td>
							<td><c:out value="${elem.getClientId()}"/></td>
							<td><c:out value="${elem.getAdminId()}"/></td>
							</tr>

							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="clear"></div>					
				</div>
		</div>
		<div class="sidebar">
			 <div class="date_btn">
				<form action="/controller">
					<input type="hidden" name="command" value="request_search" />
					<input type="submit" value="${requests_page_button}" style="width: 82px;">
				</form>
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
