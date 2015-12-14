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
				<h4>${admin_rooms_page_header}</h4>
				<p class="para">${admin_rooms_page_first_description}</p>
			</div>
				<div class="grids_of_2">
					<div class="grids_of_para">
						<table class="table3">
							<thead>
							<tr>
								<th scope="col"  class="tablespecHeader">Id</th>
								<th scope="col" >${admin_rooms_page_rooms}</th>
								<th scope="col" >${admin_rooms_page_type}</th>
								<th scope="col" >${admin_rooms_page_cost}</th>
								<th scope="col" >${admin_rooms_page_release_date}</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="elem" items="${roomsList}" varStatus="status">
							<tr>
							<td><c:out value="${elem.getId()}"/></td>
							<td><c:out value="${elem.getNumberOfbeds()}"/></td>
							<td><c:out value="${elem.getType()}"/></td>
							<td><c:out value="${elem.getCostPerDay()}"/></td>
							<td><c:out value="${elem.getReleaseDate()}"/></td>
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
