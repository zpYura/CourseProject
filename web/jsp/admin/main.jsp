<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zpYura
  Date: 02.12.2015
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>The Paradise-Hotel | Hotel</title>
    <c:import url="/jsp/common/import.jsp"/>
</head>
<body>
<!-- start header -->
<c:import url="/jsp/admin/fragment/header.jsp" />
<!----start-images-slider---->
<div class="images-slider">
    <!-- start slider -->
    <div id="fwslider">
        <div class="slider_container">
            <div class="slide">
                <!-- Slide image -->
                <img src="/images/slider-bg.jpg" alt=""/>
                <!-- /Slide image -->
                <!-- Texts container -->
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <!-- Text title -->
                        <h4 class="title"><i class="bg"></i>${main_page_slider1_message1} <span class="hide"></span></h4>
                        <h5 class="title1"><i class="bg"></i>${main_page_slider1_message2} <span class="hide" ></span></h5>
                        <!-- /Text title -->
                    </div>
                </div>
                <!-- /Texts container -->
            </div>
            <!-- /Duplicate to create more slides -->
            <div class="slide">
                <img src="/images/slider-bg.jpg" alt=""/>
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <!-- Text title -->
                        <h4 class="title"><i class="bg"></i>${main_page_slider2_message1}<span class="hide">  </span></h4>
                        <h5 class="title1"><i class="bg"></i>${main_page_slider2_message2} <span class="hide"></span> </h5>
                        <!-- /Text title -->
                    </div>
                </div>
            </div>
            <!--/slide -->
        </div>
        <div class="timers"> </div>
        <div class="slidePrev"><span> </span></div>
        <div class="slideNext"><span> </span></div>
    </div>
    <!--/slider -->
</div>
<!--start main -->
<div class="main_bg">
    <div class="wrap">
        <!--start grids_of_3 -->
        <div class="grids_of_3">
            <div class="grid1_of_3">
                <div class="grid1_of_3_img">
                    <%--develop later--%>
                    <a href="#">
                        <img src="/images/pic2.jpg" alt="" />
                        <span class="next"> </span>
                    </a>
                </div>
                <h4><a href="#">${main_page_room_for_one}<span>120$</span></a></h4>
                <p>${main_page_room_for_one_description}</p>
            </div>
            <div class="grid1_of_3">
                <div class="grid1_of_3_img">
                    <%--develop later--%>
                    <a href="#">
                        <img src="/images/pic1.jpg" alt="" />
                        <span class="next"> </span>
                    </a>
                </div>
                <h4><a href="#">${main_page_room_for_two}<span>180$</span></a></h4>
                <p>${main_page_room_for_two_description}</p>
            </div>
            <div class="grid1_of_3">
                <div class="grid1_of_3_img">
                    <a href="#">
                        <img src="/images/pic3.jpg" alt="" />
                        <span class="next"> </span>
                    </a>
                </div>
                <h4><a href="#">${main_page_suite}<span>210$</span></a></h4>
                <p>${main_page_suite_description}</p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<!--start footer -->
<c:import url="/jsp/admin/fragment/footer.jsp" />
</body>
</html>