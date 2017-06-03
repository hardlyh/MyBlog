<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<heml>

<head>
<title>lyh2016.cn - 后台管理</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->

<%@ include file="js_css.jsp"%>

<style type="text/css">
</style>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top"> <%@ include file="nav.jsp"%> </nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<%@ include file="siderbar-nav.jsp"%>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">网页更新</h3>
							<p class="panel-subtitle">Period: html_update .</p>
						</div>
						<div class="panel-body">

							<div style="width:80%; margin:0 auto;">
								<form class="form-horizontal" action="articleAction_updateTwo" method="post" enctype="multipart/form-data">
									<input type="hidden" value="${article.id }" name="article.id">
									<label>标题:</label>
								
									<input type="text"  value="${article.name }" name="article.name" class="form-control" placeholder=""  >	


									<br>
								

									<div style="width: 80px; margin-left:  90%; ">
									<button type="button" class="btn btn-success" >提交</button>		
									<div>	

								</form>	
							</div>
						</div>


						<div class="panel-body"></div>
					</div>


					<!-- 通知 -->
					<%@ include file="notifications.jsp"%>
					<!-- END MAIN -->
					<div class="clearfix"></div>
					<%@ include file="footer.jsp"%>

				</div>


				<!-- END WRAPPER -->
				<!-- Javascript -->
				<%@ include file="js.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
	$("#article").addClass("active");
	$(".btn-success").click(function(){
		if(confirm("是否提交")){
			$(".form-horizontal").submit()
		}
	});

});
</script>
</body>

</html>