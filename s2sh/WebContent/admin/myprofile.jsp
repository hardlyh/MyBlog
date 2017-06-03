<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>lyh2016.cn - 后台管理</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<%@ include file="js_css.jsp" %>
	<style type="text/css">
		
		.left{
			width: 500px; 
			margin-right: 28%;
		}
		
		.social-icons i{
			margin-top: 30%;
		}
		

	</style>
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
					<div class="panel panel-profile">
						<div class="clearfix" >
							<!-- LEFT COLUMN -->
							<div id="left" class="left profile-right" ">
								<!-- PROFILE HEADER -->
								<div class="profile-header">
									<div class="overlay"></div>
									<div class="profile-main">
										<img src="assets/img/user-medium.png" class="img-circle" alt="Avatar">
										<h3 class="name">${mp.name }</h3>
										<span class="online-status status-available">Available</span>
									</div>
									
								</div>
								<!-- END PROFILE HEADER -->
								<!-- PROFILE DETAIL -->
								<div class="profile-detail">
									<div class="profile-info">
										<h4 class="heading">Basic Info</h4>
										<ul class="list-unstyled list-justify">
											<li>年龄 <span>${mp.age }</span></li>
											<li>毕业院校 <span>${mp.school }</span></li>
											<li>Email <span>${mp.email }</span></li>
											<li>Website <span><a href="#">${mp.web }</a></span></li>
										</ul>
									</div>
									<div class="profile-info">
										<h4 class="heading">Social</h4>
										<ul class="list-inline social-icons ">
											<li><a href="${mp.weibo }"  target="_blank" class="facebook-bg"><i class="fa fa fa-weibo" ></i></a></li>
											<li><a href="${mp.qq }"  target="_blank" class="twitter-bg"><i class="fa fa-qq"></i></a></li>	
											<li><a href="${mp.github }"  target="_blank" class="github-bg"><i class="fa fa-github"></i></a></li>
										</ul>
									</div>
									<div class="profile-info">
										<h4 class="heading">About</h4>
										<p>${mp.profile }</p>
									</div>
									<div class="text-center" id="edit"><a href="#" class="btn btn-primary">Edit Profile</a></div>
								</div>
								<!-- END PROFILE DETAIL -->
							</div>
							<!-- END LEFT COLUMN -->
							<!-- 修改个人信息 -->
								<div id="right" class="profile-right">
								<h4 class="heading">修改个人信息</h4>
								<!-- form  -->
								
									<form class="form-horizontal" style="width: 90%;" action="myProfileAction_updateMyProfile.action" method="post" enctype="multipart/form-data">
										<input type="hidden" value="${mp.UId }" name="mp.UId">
										<div class="profile-main" style="margin-left: 50%;" id="head">
											<img src="assets/img/user-medium.png" class="img-circle" alt="Avatar" title="100*100/.png .jpg">
										</div>
									
										<input type="file" name="file2" id="file2" >
										
										<br><br>

										<div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.name }" name="mp.name">
										    </div>
										 </div>

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">年龄</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.age }" name="mp.age">
										    </div>
										 </div>

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">email</label>
										    <div class="col-sm-10">
										      <input type="eamil" class="form-control" id="inputEmail3" value="${mp.email }" name="mp.email">
										    </div>
										 </div>

									  

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">微博</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.weibo }" name="mp.weibo">
										    </div>
										 </div>

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">QQ</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.qq }" name="mp.qq">
										    </div>
										 </div>

										

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">github</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.github }" name="mp.github">
										    </div>
										 </div>

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">毕业院校</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.school }" name="mp.school">
										    </div>
										 </div>

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">个人简介</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.profile }" name="mp.profile">
										    </div>
										 </div>

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">网站地址</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.web }" name="mp.web">
										    </div>
										 </div>

										 <div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">标题文字</label>
										    <div class="col-sm-10">
										      <input type="text" class="form-control" id="inputEmail3" value="${mp.ability }" name="mp.ability">
										    </div>
										 </div>
										
										<button type="submit" class="btn btn-success update_herf" id="add" style="margin-left:87%;">提交</button>

									</form>
										
									
								</div>
								<!-- END TABBED CONTENT -->
							</div>
							<!-- END RIGHT COLUMN -->
						</div>
					</div>
				</div>
			</div>
				<!-- 通知 -->
					<%@ include file="notifications.jsp"%>
			
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		
			<%@ include file="footer.jsp" %>  
		
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<%@ include file="js.jsp" %>
	<script type="text/javascript">
		

		$().ready(function(){
			$("#profile").addClass("active");
			
			var s=1;
			$("#right").hide();
			$("#file2").hide();
			$("#edit").click(function(){
				if(s==1){
					$("#left").attr("class","profile-left");
					$("#div1").fadeTo("slow",0.15);
					$("#right").fadeToggle(1000);
					s=2;
				}else{
					$("#left").attr("class","left profile-right");
					$("#div1").fadeTo("slow",0.15);
					$("#right").fadeToggle(1000);
					s=1;	

				}
			});

			$("#head").click(function(){
				$("#file2").click();
				
			});
		});



	</script>
</body>

</html>
