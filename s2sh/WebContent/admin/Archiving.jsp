<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<heml>

<head>
<title>lyh2016.cn - 后台管理</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
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
		<%@ include file="nav.jsp"%>
		</nav>
			
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
							<h3 class="panel-title">文章归档</h3>
							<p class="panel-subtitle">Period: timeline .</p>
						</div>
						<div class="panel-body">

							<div style="width: 80%; margin: 0 auto;">


								
								<div class="panel-body">
									<!-- 主要内容 -->
									<table class="table">
										<colgroup>
											<col style="width: 60%">
											<col style="width: 15%;">
											<col style="width: 25%;">
										</colgroup>
										<!-- table列表 -->

										<c:forEach items="${map }" var="m">
											
													<th><h3>${m.key }</h3></th>
											
											
											
												<tbody>
												<c:forEach items="${m.value }" var="list">
													<tr>
														<td><a href="../${list.htmlUrl}.jsp">${list.title }(${list.pageview })</a></td>
														<td>${list.tag }</td>
														<td>${list.time }</td>
													</tr>
												</c:forEach>
												</tbody>
											
										</c:forEach>
									</table>


								</div>
							</div>
						</div>

					</div>
				
					</div>
				</div>
			</div>


			<div class="panel-body"></div>
		</div>


		<!-- END MAIN -->
		<div class="clearfix"></div>
		<%@ include file="footer.jsp"%>

	</div>


	<!-- END WRAPPER -->
	<!-- Javascript -->
	<%@ include file="js.jsp"%>


	<script type="text/javascript">
		$("#archiving").addClass("active");
	</script>
</body>

</html>