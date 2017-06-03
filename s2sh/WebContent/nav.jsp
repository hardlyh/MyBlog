<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="assets/js/jquery.min.js"></script>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "htt://www.w3.org/TR/html4/loose.dtd">


<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
<div class="am-u-sm-8 am-u-sm-centered">
	
	<h2 class="am-hide-sm-only">${myprofile.ability }</h2>
</div>
</header>
<hr>
<!-- nav start -->
<nav class="am-g am-g-fixed blog-fixed blog-nav">
<div class="am-collapse am-topbar-collapse" id="blog-collapse">
	<ul class="am-nav am-nav-pills am-topbar-nav">
		<li class="" id="index"><a href="webPageAction_jumpIndex">首页</a></li>
		<li class="am-dropdown" data-am-dropdown><a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">分类列表 <span class="am-icon-caret-down"></span>
		</a>
			<ul class="am-dropdown-content">
			<c:forEach items="${categoryList }" var="cg">
				<li><a href="webPageAction_condition?tagCondition=${cg.name }">${cg.name }</a></li>
			</c:forEach>
			</ul></li>
		<li id="pageList"><a href="webPageAction_findAllNoCondition">文章列表</a></li>
		<li id="timeline"><a href="webPageAction_timeLine">存档</a></li>
		<li><a href="webPageAction_getArticle">知识整理</a></li>
		<li id="aboutWeb"><a href="aboutWeb.jsp">关于本站</a></li>
		<c:if test="${!empty user}">
			<li id="privateList"><a href="webPageAction_findByPrivate">私密文章</a></li>
		</c:if>
	</ul>
	<form class="am-topbar-form am-topbar-right am-form-inline" id="conditionForm" role="search" method="post" action="webPageAction_condition">
		<div class="am-form-group">
			<input type="text" name="condition" value="${condition }" class="am-form-field am-input-sm" placeholder="搜索"> &nbsp; <span class="am-icon-search " id="search2"></span>
		</div>
	</form>
</div>
</nav>


<script type="text/javascript">
	$().ready(
			function() {
				$("#search2").mouseenter(
						function() {
							$(this).addClass("am-icon-search-plus")
									.removeClass("am-icon-search");

						});
				$("#search2").mouseleave(
						function() {
							$(this).addClass("am-icon-search").removeClass(
									"am-icon-search-plus");
						});
				$("#search2").click(function() {
					$("#conditionForm").submit();
				})

			});
</script>


