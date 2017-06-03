<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>lyh2016.cn</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
<%@ include file="js_css.jsp" %> 
</head>

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
							<h3 class="panel-title">修改标签</h3>
							<p class="panel-subtitle">Period: tag_message . </p>
						</div>
						<div class="panel-body">
							<div style="width:80%; margin:0 auto;">
								<form class="form-horizontal" action="categoryAction_updateTagTwo.action">
									<input type="hidden" name="category.time" value="${category.time}">
									<input type="hidden" name="category.CId" value="${category.CId}">
									<label>类别:</label>
								
									<input type="text" value="${category.name }" class="form-control"  name="category.name">															
							
									<br>
									
									<div style="width: 80px; margin-left:  90%; ">
										<div>创建时间 : ${category.time }</div>
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
		<footer>
			<div class="container-fluid">
				<p class="copyright">&copy; 2017 <a href="#" target="_blank">Theme I Need</a>. All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
			</div>
		</footer>
	
	</div>
	
	
	<!-- END WRAPPER -->
	<!-- Javascript -->
		<%@ include file="js.jsp" %>  



		
</body>
<%@ include file="js.jsp"%>

<script type="text/javascript">
$("#tag").addClass("active");
</script>

</html>
