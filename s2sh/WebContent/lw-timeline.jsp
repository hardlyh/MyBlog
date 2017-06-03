<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>lyh2016.cn</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <meta name="mobile-web-app-capable" content="yes">
  <link rel="icon" sizes="192x192" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="msapplication-TileImage" content="assets/i/app-icon72x72@2x.png">
  <meta name="msapplication-TileColor" content="#0e90d2">
  <link rel="stylesheet" href="assets/css/amazeui.min.css">
  <link rel="stylesheet" href="assets/css/app.css">
</head>

<body id="blog-article-sidebar">
<!-- nav start -->
	<%@include file="nav.jsp" %>
<!-- nav end -->
<hr>
<!-- content srart -->
<div class="am-g am-g-fixed blog-fixed blog-content">
    <div class="am-u-sm-12">
        <h1 class="blog-text-center">-- 存档 --</h1>
         
       
        <div class="timeline-year">
    		    <br>
                <ul>
                <c:forEach items="${map }" var="m">
                <h3>${m.key }月</h3>
                <hr>
	               <c:forEach items="${m.value }" var="p2">
		                <li>
		                    <span class="am-u-sm-4 am-u-md-2 timeline-span">${p2.time }</span>
		                    <span class="am-u-sm-8 am-u-md-6"><a href="${p2.htmlUrl }.jsp">${p2.title }(${p2.pageview })</a></span>
		                    <span class="am-u-sm-4 am-u-md-2 am-hide-sm-only">${p2.tag }</span>
		                    <span class="am-u-sm-4 am-u-md-2 am-hide-sm-only">lyh2016</span>
		                </li>
	                </c:forEach>
 				 </c:forEach>
                </ul>
       
        </div>
      
    </div>


</div>
<!-- content end -->

 <footer class="blog-footer">
 	<%@include file="foot.jsp" %>
  </footer>



<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="assets/js/amazeui.min.js"></script>
<!-- <script src="assets/js/app.js"></script> -->
<script type="text/javascript">
	$("#timeline").addClass("am-active");
	
	
	</script>
</body>
</html>