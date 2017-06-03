<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>lyh2016.cn - 后台管理</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<%@include file="js_css.jsp" %>
	<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
<style type="text/css">
</style>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top"> <%@ include
			file="nav.jsp"%> </nav>
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
							<h3 class="panel-title">统计数据</h3>
							<p class="panel-subtitle">Period: 2017.5.18 -</p>
						</div>
						<div class="panel-body" >
							<div class="row" >
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-eye" style="margin-top:30%;"></i></span>
										<p>
											<span class="number">${application.totalCount }</span> <span class="title">访问量</span>
										</p>
									</div>
								</div>
							
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-sun-o" style="margin-top:30%;"></i></span>
										<p>
											<span class="number">${application.countByDay }</span> <span class="title">日访问量</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-file-text-o" style="margin-top:30%;"></i></span>
										<p>
											<span class="number">${data.web_articleamount }</span> <span class="title">文章数</span>
										</p>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-adjust" style="margin-top:30%;"></i></span>
										<p>
											<span class="number">${application.mouthAmount }</span> <span class="title">月访问量</span>
										</p>
									</div>
								</div>
								
							</div>


							<div class="row">


								<div class="col-md-9" style="width: 80%; margin-left:10%; ">
									<h3 class="panel-title">近五天访问人数</h3>
									<br>
									<div id="headline-chart" class="ct-chart"></div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
				<!-- END OVERVIEW -->


				<!-- TASKS -->
				<!-- 
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">My Tasks</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								 -->

				
				
				<div class="col-md-4" style="width: 80%; margin-left:10%; ">
							<!-- VISIT CHART -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">文章占比</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<div id="visits-chart" class="ct-chart"></div>
								</div>
							</div>
							<!-- END VISIT CHART -->
						</div>
			</div>
			<!-- END TASKS -->
			<%@include file="notifications.jsp" %>
		</div>
	</div>



	<!-- END MAIN -->
	<div class="clearfix"></div>
	<%@ include file="footer.jsp"%>
	</div>


	<!-- END WRAPPER -->
	<!-- Javascript -->
	<%@include file="js.jsp" %>
	
	<script src="assets/vendor/chartist/js/chartist.min.js"></script>
	<script>
		$("#index").addClass("active");
		
		
		
		
		$(function() {
			
			var ajaxdata;
			
			var labels;
			
			var labels1;
			
			var series;
			
			var series1;
			
			$.post("indexAction_json",function(data){
				ajaxdata=jQuery.parseJSON(data);
				labels=ajaxdata.labels;
				series=ajaxdata.series;
				labels1=ajaxdata.labels1;
				series1=ajaxdata.series1;
				
				<!-- -->
				
				var data, options;

				// headline charts
				data = {
					labels : labels1 ,
					series : [ series1 ]
				};

				options = {
					height : 300,
					showArea : true,
					showLine : false,
					showPoint : false,
					fullWidth : false,
					axisX : {
						showGrid : false
					},
					lineSmooth : false,
				};

				new Chartist.Line('#headline-chart', data, options);

				
				
				// visits chart
				
				data = {
					labels: labels,
					series: [
						series
					] 
				};

				options = {
					height: 300,
					axisX: {
						showGrid: false
					},
				};

				new Chartist.Bar('#visits-chart', data, options);
				
				
				
				var updateInterval = 3000; // in milliseconds

				setInterval(function() {
					var randomVal;
					randomVal = getRandomInt(0, 100);
				}, updateInterval);

				function getRandomInt(min, max) {
					return Math.floor(Math.random() * (max - min + 1)) + min;
				}

			});
			
			
		});
	</script>

</body>

</html>
