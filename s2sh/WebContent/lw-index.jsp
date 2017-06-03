<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="admin/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="admin/assets/vendor/linearicons/style.css">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileImage" content="assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileColor" content="#0e90d2">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<style type="text/css">
.am-radius a{
	color:#FFFFFF;
}
.am-radius a:hover{
	color:#33FF33;
	text-decoration: none;
}
</style>

</head>

<body id="blog">
	<!-- 头部 -->
	 <%@include file="nav.jsp"%> 
	<hr>
	<!-- nav end -->
	<!-- banner start -->
	<div class="am-g am-g-fixed blog-fixed am-u-sm-centered blog-article-margin">
		<div data-am-widget="slider" class="am-slider am-slider-b1" data-am-slider='{&quot;controlNav&quot;:false}'>
			<ul class="am-slides">
				<li><img src="assets/i/b1.png"></li>
				<li><img src="assets/i/b2.png"></li>
				<li><img src="assets/i/b3.png"></li>
				<li><img src="assets/i/b2.png"></li>
			</ul>
		</div>
	</div>
	<!-- banner end -->

	<!-- content srart -->
	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-8 am-u-sm-12">
		<!-- 文章列表 -->
		<c:forEach items="${pageBean.list }" var="article">
			<article class="am-g blog-entry-article">
			<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
				<img src="admin/assets/page_img/${article.head_url}" alt="" class="am-u-sm-12">
			</div>
			<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
				<span><a class="blog-color"> @author &nbsp;</a></span> <span>${article.time } &nbsp;</span> <span class="am-icon-tags"><b> ${article.tag } </b> &nbsp;</span>
				<span><font size="-1.5">阅读: ${article.pageview }</font></span>
				<h1 class="hrefAmount">
					<input type="hidden" value="${article.pid }">
					<a href="${article.htmlUrl }.jsp">${article.title }</a>
				</h1>
				<p>${article.description }</p>
			</div>
			
			
			</article>
		</c:forEach>
		
		<!-- 分页 -->
		
				<%@include file="page.jsp" %>
		</div>
		<!-- 左边栏 -->
				<%@include file="left.jsp" %>
	</div>
	<!-- content end -->



	<footer class="blog-footer">
		 <%@include file="foot.jsp"%>
	  </footer>





	<!--[if (gte IE 9)|!(IE)]><!-->
	
	<!--<![endif]-->


<script src="assets/js/amazeui.min.js"></script>
<script type="text/javascript">
	$("#index").addClass("am-active");
	
	$(".hrefAmount").click(function(){
		
		var s=$(this).find("input").val();
		
		$.post("webPageAction_updateView", {tag:s});
	});
	
	
</script>
</body>
</html>