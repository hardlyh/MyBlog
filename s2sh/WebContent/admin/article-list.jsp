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
							<h3 class="panel-title">网页管理</h3>
							<p class="panel-subtitle">Period: html_message .</p>
						</div>
						<div class="panel-body">

								<div style="width: 80%; margin: 0 auto;">


								<div class="panel-heading">
									<h3 class="panel-title">所有网页:</h3>
								</div>
								<!-- 查询表单 -->
								<form class="form-inline" id="titleForm" style="margin-left: 30%;" action="${targetAction }">
									<div class="form-group">
										<label for="类别"></label> <input type="text" name="condition" value="${condition }" class="form-control" id="exampleInputEmail2" placeholder="标题关键字">
									</div>
									<button type="submit" class="btn btn-link">
										<span class="fa fa-search"></span>
									</button>
								</form>
								<!-- tag列表 -->
								<div class="panel-body">
									<table class="table">
									<colgroup>
											<col style="width: 60%">
											<col style="width: 20%;">
											<col style="width: 10%">
											<col style="width: 10%">
									</colgroup>
										<thead>
											<tr>
												<th>标题</th>
												<th>时间</th>
												<th>删除</th>
												<th>更新</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${pageBean.list }" var="l">
												<tr>
													<td>${l.name }</td>
													<td>${l.time }</td>
													<td><a href="articleAction_updateOne.action?id=${l.id }"><i class="lnr lnr-pencil"></i></a></td>
													<td><a class="delete_herf" href="articleAction_deleteArticle.action?id=${l.id }"><i class="lnr lnr-trash"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- 分页 -->
									<%@ include file="page.jsp"%>

								</div>
								<div style="width: 80px; margin-left: 90%;">
									<a href="article-add.jsp">
										<button type="button" class="btn btn-success" id="add">添加</button>
									</a>
									<div></div>

								</div>
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
$("#article").addClass("active");


</script>
</body>

</html>