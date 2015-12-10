<%--
  User: Druzenok Yury
  Date: 07.12.2015
  Time: 16:37
  Registration form
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <c:import url="/jsp/common/import.jsp"/>
</head>
<body>
<%-- header --%>
<div class="header_bg">
    <div class="wrap">
        <div class="header">
            <div class="logo_login">
                <a href="/jsp/common/login.jsp"><img src="/images/logo.png" alt=""></a>
            </div>
            <div class="clear"></div>
            <div class="top-nav">
                <nav class="clearfix">
                    <ul>
                        <li class="active"><a href="/index.jsp">hotel</a></li>
                        <li><a href="/jsp/client/rooms.jsp">rooms & suits</a></li>
                        <li><a href="/jsp/client/reservation.jsp">reservation</a></li>
                        <li><a href="/jsp/client/activities.jsp">activities</a></li>
                        <li><a href="/jsp/client/contact.jsp">contact</a></li>
                    </ul>
                    <a href="#" id="pull">Menu</a>
                </nav>
            </div>
        </div>
    </div>
</div>
<!--start main -->
<div class="main_bg">
    <div class="wrap">
        <div class="main">
            <div class="contact">
                <div class="contact-form">
                    <h2 class="login-header" align="center">${registration_message}</h2>
                    <form method="post" action="/controller" class="login-form">
                        <input type="hidden" name="command" value="sign_up" />
                        <div>
                            <span><label>${registration_lastName}</label></span>
                            <span><input name="userLastName" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationLastName}</label></span>
                        </div>
                        <div>
                            <span><label>${registration_firstName}</label></span>
                            <span><input name="userFirstName" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationFirstName}</label></span>
                        </div>
                        <div>
                            <span><label>${registration_middleName}</label></span>
                            <span><input name="userMiddleName" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationMiddleName}</label></span>
                        </div>
                        <div>
                            <span><label>${registration_birthDate}</label></span>
                            <span><input name="userBirthDate" type="text" class="textbox" value="07/06/13"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationDate}</label></span>
                        </div>
                        <div>
                            <span><label>${registration_address}</label></span>
                            <span><input name="userAddress" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span><label>${registration_phoneNumber}</label></span>
                            <span><input name="userPhoneNumber" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationPhoneNumber}</label></span>
                        </div>
                        <div>
                            <span><label>${registration_email}</label></span>
                            <span><input name="userEmail" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationEmail}</label></span>
                        </div>
                        <div>
                            <span><label>${registration_login}</label></span>
                            <span><input name="userLogin" type="text" class="textbox"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationLogin}</label></span>
                        </div>
                        <div>
                            <span><label>${registration_password}</label></span>
                            <span><input name="userPassword" type="password" class="textbox"></span>
                        </div>
                        <div>
                            <span align="center" style="color: #cd0a0a"><label>${errorRegistrationEmpty}</label></span>
                        </div>
                        <div>
                            <span><input  type="submit"  value=${registration_submit}></span>
                        </div>
                        <div>
                            <span><input  class="login-reset" type="reset" value=${registration_refresh}></span>
                        </div>
                    </form>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<%--footer--%>
<div class="footer_bg">
    <div class="wrap">
        <div class="footer">
            <div class="login-copy">
                <p align="center" class="link"><span>${registration_footer}&nbsp;<a href="/jsp/common/login.jsp"> ${registration_registlink}</a></span></p>
            </div>
            <div class="login-copy">
                <p align="center" class="link"><span>© 2015 All rights reserved | Druzenok Yury</span></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
