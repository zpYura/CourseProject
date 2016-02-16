<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 13.02.2016
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Error Page</title></head>
<c:import url="/jsp/common/import.jsp"/>
<body>
<div class="header_bg">
    <div class="wrap">
        <div class="header">
            <div class="logo_login">
                <a href="/jsp/common/login.jsp"><img src="/images/logo.png" alt=""></a>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div class="main_bg">
    <div class="wrap">
        <div class="main">
            Request from ${pageContext.errorData.requestURI} is failed
            <br/>
            Servlet name or type: ${pageContext.errorData.servletName}
            <br/>
            Status code: ${pageContext.errorData.statusCode}
            <br/>
            Exception: ${pageContext.errorData.throwable}
            <div class="clear"></div>
        </div>
    </div>
</div>
<div class="footer_bg">
    <div class="wrap">
        <div class="footer">
            <div class="login-copy">
                <p align="center" class="link"><span>&nbsp;<a href="/jsp/common/login.jsp">Login Page</a></span></p>
            </div>
            <div class="login-copy">
                <p align="center" class="link"><span>© 2016 All rights reserved | Druzenok Yury</span></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
