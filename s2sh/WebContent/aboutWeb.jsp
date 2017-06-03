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
<!-- header start -->
<%@include file="nav.jsp" %>
<!-- nav end -->
<hr>
<!-- content srart -->
<div class="am-g am-g-fixed blog-fixed blog-content">
    
  <div>
    <h1>关于本站</h1>
    

    <blockquote style="font-family: am-sans-serif;">

      <h3><p>前段样式 : amaze UI </p></h3>
      <h3> <p>图标样式 : amaze UI / bootstarp / 等</p><h3>
      <h3><p>后台语言 : java </p><h3>  
      <h3><p>后台框架 : spring / struts2 / hibernate (s2sh) </p><h3>
      <h3><p>辅助语言 : javascript , jQuery , css , html </p><h3>
      <h3><p>后端样式 : bootstarp </p><h3>
      <h3><p>富文本编辑器 : wangEditor </p><h3>
    </blockquote>


  <span class="am-icon-tags"> &nbsp;</span>本站由作者自行构建并且实现,作为学习阶段成果






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
	$("#aboutWeb").addClass("am-active");
	
	
	</script>
</body>
</html>