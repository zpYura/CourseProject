<%@ page import="java.util.Locale" %>
<%@ page import="by.epam.managers.LanguageManager" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: zpYura
  Date: 02.12.2015
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%
    // save current locale
    request.setAttribute("current_session", session);
%>
<ctg:setLanguage session="${current_session}"/>

<jsp:forward page="jsp/common/login.jsp"/>
</body>
</html>

