<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
	<title>lyh2016.cn</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">

	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>
<style type="text/css">
	

</style>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<%@ include file="nav.jsp" %>  
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<%@ include file="siderbar-nav.jsp" %>  
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
							<h3 class="panel-title">修改密码</h3>
							<p class="panel-subtitle">Period: update_pssword . </p>
						</div>
						<div class="panel-body">
							<div style="width:80%; margin:0 auto;">
								<form class="form-horizontal" action="adminAction_updateTwo" method="post">
									<input type="hidden" value="${username }" name="username"> 
									<label>新密码:</label>
								
									<input type="text" id="password"  class="form-control" placeholder="input" name="password">															
										
									<br>
									
									<label>重复新密码:</label>
								
									<input type="text" id="password1"  class="form-control" placeholder="input" name="category.name">
									</br>
									
									<span id="inputError"><font color="red">* 两次输入密码不一致</font></span>
									<br>
									<div style="width: 80px; margin-left:  90%; ">
										<div><%=new Date().toLocaleString()%></div>
										<br>
										<button type="submit" class="btn btn-success update_herf" >提交</button>		
									</div>	

								</form>	
							</div>
							
						</div>
					</div>
				</div>
				

				<div class="panel-body">
					
				</div>
			</div>

			<!-- END TASKS -->
		</div>
	

		
	
		
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<%@include file="footer.jsp" %>
	
	</div>
	
	
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>

	<script type="text/javascript">
	</script>
	<script type="text/javascript">
		$(".btn-success").attr("disabled",true);
		$("#inputError").hide();
		$("#password1").blur(function(){
			var password=$("#password").val();
			var password2=$("#password1").val();
			if(password!=password2&&password2!=""&&password!=""){
				
				$("#inputError").show();
			}else{
				$("#inputError").hide();
				$(".btn-success").attr("disabled",false);
			}
		});
		
	</script>
		
</body>

</html>
