<%--
  Created by IntelliJ IDEA.
  User: zpYura
  Date: 06.12.2015
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="/js/jquery.min.js"></script>
<!--start slider -->
<link rel="stylesheet" href="/css/fwslider.css" media="all">
<script src="/js/jquery-ui.min.js"></script>
<script src="/js/css3-mediaqueries.js"></script>
<script src="/js/fwslider.js"></script>
<!--end slider -->
<!---strat-date-piker---->
<link rel="stylesheet" href="/css/jquery-ui.css" />
<script src="/js/jquery-ui.js"></script>
<script>
    $(function() {
        $( "#datepicker,#datepicker1" ).datepicker();
    });
</script>
<!---/End-date-piker---->
<link type="text/css" rel="stylesheet" href="/css/JFFormStyle-1.css" />
<script type="text/javascript" src="/js/JFCore.js"></script>
<script type="text/javascript" src="/js/JFForms.js"></script>
<!-- Set here the key for your domain in order to hide the watermark on the web server -->
<script type="text/javascript">
    (function() {
        JC.init({
            domainKey: ''
        });
    })();
</script>
<!--nav-->
<script>
    $(function() {
        var pull 		= $('#pull');
        menu 		= $('nav ul');
        menuHeight	= menu.height();

        $(pull).on('click', function(e) {
            e.preventDefault();
            menu.slideToggle();
        });

        $(window).resize(function(){
            var w = $(window).width();
            if(w > 320 && menu.is(':hidden')) {
                menu.removeAttr('style');
            }
        });
    });
</script>

