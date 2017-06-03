<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>lyh2016.cn - 后台管理</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<%@ include file="js_css.jsp"%>
</head>
<style type="text/css">
	

</style>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
	<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		 <%@ include file="nav.jsp"%> </nav>
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
							<h3 class="panel-title">网站图片管理</h3>
							<p class="panel-subtitle">Period: edit . </p>
						</div>
						<div class="panel-body">
							<div style="width:80%; margin:0 auto;">
								<form class="form-horizontal" method="post" enctype="multipart/form-data" action="webManageAction">

								<!-- 
								<label></label>
									<div class="form-group">
								    <label for="inputEmail3" class="col-sm-2 control-label">网页头部图片 :</label>
								    <div class="col-sm-10">
								      <input type="file" class="form-control" name="picture1" id="inputEmail3" placeholder="Email">
								    </div>
								  </div>
								 -->
									<label>主页面滚动banner(1434*620最佳) : </label>
								

									<div class="form-group">
								    <label for="inputEmail3" class="col-sm-2 control-label">图片1 : </label>
								    <div class="col-sm-10">
								      <input type="file" class="form-control" name="picture2" id="inputEmail3" placeholder="Email">
								    </div>
								  </div>	

								  <div class="form-group">
								    <label for="inputEmail3" class="col-sm-2 control-label">图片2 : </label>
								    <div class="col-sm-10">
								      <input type="file" class="form-control" name="picture3" id="inputEmail3" placeholder="Email">
								    </div>
								  </div>	


								  <div class="form-group">
								    <label for="inputEmail3" class="col-sm-2 control-label">图片3 : </label>
								    <div class="col-sm-10">
								      <input type="file" class="form-control" name="picture4" id="inputEmail3" placeholder="Email">
								    </div>
								  </div>	
								  <div style="width: 80px; margin-left:  90%; ">
										<button type="submit" id="submit1" class="btn btn-success" onclick="return confirm('是否提交');">提交</button>		
								</div>	
								</form>	
							</div>	
						</div>
					</div>
				</div>
				

				<div class="panel-body">
					<%@ include file="notifications.jsp"%>
				</div>
			</div>

			<!-- END TASKS -->
		</div>

		<div id="advice">
			
		
		</div>
	
	
		
	
		
		<!-- END MAIN -->
		<div class="clearfix"></div>
			<%@ include file="footer.jsp"%>
	
	</div>
	
	
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<%@ include file="js.jsp"%>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#message").addClass("active");
	});
	</script>
		
</body>

</html>
