<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="am-u-md-4 am-u-sm-12 blog-sidebar">
			<div class="blog-sidebar-widget blog-bor">
				<h2 class="blog-text-center blog-title">
					<span>About ME</span>
				</h2>
				<img src="admin/assets/img/user-medium.png" alt="about me" class="blog-entry-img">
				<p><b>age : ${myprofile.age }</b></p>
				<p><b>email : ${myprofile.email }</b></p>
				<p><b>web_url : ${myprofile.web }</b></p>
			</div>
			<div class="blog-sidebar-widget blog-bor">
				<h2 class="blog-text-center blog-title">
					<span>Contact ME</span>
				</h2>
				<p>
					<a href="${myprofile.qq }" target="_blank"><span class="am-icon-qq am-icon-fw am-primary blog-icon"></span></a>
	                <a href="${myprofile.github }" target="_blank"><span class="am-icon-github am-icon-fw blog-icon" ></span></a>
	                <a href="${myprofile.weibo }" target="_blank"><span class="am-icon-weibo am-icon-fw blog-icon" ></span></a>
	               
	             </p>
			</div>
			<div class="blog-clear-margin blog-sidebar-widget blog-bor am-g ">
				<h2 class="blog-title">
					<span>TAG cloud</span>
				</h2>
				<div class="am-u-sm-12 blog-clear-padding">
					<c:forEach items="${categoryList }" var="cg">
						  <a href="webPageAction_condition?tagCondition=${cg.name }" class="blog-tag">${cg.name }</a>
					</c:forEach>
				</div>
			</div>
			<div class="blog-sidebar-widget blog-bor">
				<h2 class="blog-title">
					<span>推荐文章</span>
				</h2>
				<ul class="am-list">
				<c:forEach items="${session.listPage }" var="lp">
					 <li><a href="${lp.htmlUrl }.jsp">${lp.title }(${lp.pageview })</a></li>
				 </c:forEach>
               
				</ul>
			</div>
		</div>