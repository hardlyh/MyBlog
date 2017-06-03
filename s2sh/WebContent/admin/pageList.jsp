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
							<h3 class="panel-title">标签管理</h3>
							<p class="panel-subtitle">Period: tag_message .</p>
						</div>
						<div class="panel-body">

							<div style="width: 80%; margin: 0 auto;">


								<div class="panel-heading">
									<h3 class="panel-title">所有文章:</h3>
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
								<div class="panel-body">
									<!-- 主要内容 -->
									<table class="table">
										<colgroup>
											<col style="width: 5%">
											<col style="width: 40%;">
											<col style="width: 10%">
											<col style="width: 5%">
											<col style="width: 5%">
											<col style="width: 5%">
										</colgroup>
										<!-- table列表 -->
										<thead>
											<tr>
												<th>#</th>
												<th>标题</th>
												<th>类目</th>
												<th>私密</th>
												<th>修改</th>
												<th>删除</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${pageBean.list }" var="l">
												<tr>
													<td>${l.pid }</td>
													<td>${l.title }</td>
													<td>${l.tag }</td>
													<td>${l.isprivate }</td>
													<td><a href="pageAction_updatePageOne.action?id=${l.pid }"><i class="lnr lnr-pencil"></i></a></td>
													<td><a class="delete_herf" href="pageAction_deletePage.action?id=${l.pid }"><i class="lnr lnr-trash"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>


									<%@ include file="page.jsp"%>

								</div>
								<div style="width: 80px; margin-left: 90%;">
									<a href="edit.jsp">
										<button type="button" class="btn btn-success" id="add">添加</button>
									</a>
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
</body>

<script type="text/javascript">
	$.post("categoryAction_showAllTag.action", null);

	$("#pageList").addClass("active");
</script>


</html>