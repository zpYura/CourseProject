<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>The Paradise-Hotel | Clients </title>
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
				<h4>${admin_clients_header}</h4>
				<p class="para">${admin_clients_description}</p>
			</div>
				<div class="grids_of_2">
					<div class="grids_of_para">
						<table class="table3">
							<thead>
							<tr>
								<th scope="col"  class="tablespecHeader">Id</th>
								<th scope="col" >${admin_clients_last_name}</th>
								<th scope="col" >${admin_clients_first_name}</th>
								<th scope="col" >${admin_clients_middle_name}</th>
								<th scope="col" >${admin_clients_birth_date}</th>
								<th scope="col" >${admin_clients_address}</th>
								<th scope="col" >${admin_clients_phone_number}</th>
								<th scope="col" >${admin_clients_email}</th>
								<th scope="col">${admin_clients_login}</th>
								<th scope="col">${admin_clients_password}</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="elem" items="${clientsList}" varStatus="status">
							<tr>
							<td><c:out value="${elem.getId()}"/></td>
							<td><c:out value="${elem.getLastName()}"/></td>
							<td><c:out value="${elem.getFirstName()}"/></td>
							<td><c:out value="${elem.getMiddleName()}"/></td>
							<td><c:out value="${elem.getBirthDate()}"/></td>
							<td><c:out value="${elem.getAddress()}"/></td>
							<td><c:out value="${elem.getPhoneNumber()}"/></td>
							<td><c:out value="${elem.getEmail()}"/></td>
							<td><c:out value="${elem.getLogin()}"/></td>
                                <td><c:out value="${elem.getPassword()}"/></td>
							</tr>

							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="clear"></div>
				</div>
		</div>
		<%--<div class="sidebar">--%>
			 <%--<div class="date_btn">--%>
				<%--<form action="/controller">--%>
					<%--<input type="hidden" name="command" value="request_search" />--%>
					<%--<input type="submit" value="${requests_page_button}" style="width: 82px;">--%>
				<%--</form>--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="clear"></div>
	</div>
</div>
</div>
<!-- start footer -->
<c:import url="/jsp/admin/fragment/footer.jsp" />
</body>
</html>
