<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>企业增值税分析系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/public.css" type="text/css" rel="stylesheet">
		<link href="css/houtai.css" type="text/css" rel="stylesheet">
		<link href="css/smartMenu.css" type="text/css" rel="stylesheet">

	</head>

	<body>
		<div id="admin">
			<div class="ad-menu" id="ad-menu">
				<div class="ad-logo">
					<img src="image/m-logo.png" height="123" width="220">
				</div>
				<div class="ad-list">
					<ul>





						<li>
							<div class="li-item">
								<em class="scm li-ico ic2"></em>月度分析
								<span class="scm arrow"></span>
							</div>
							<dl>
								<dd>
									<a href="#" class="dd-item">单一商品分析<span class="scm dd-ar"></span>
									</a>
									<ul class="ad-item-list">
										<li class="J_menuItem" href="input_analy.do" data-index="1">
											进项分析
										</li>

										<li class="J_menuItem" href="output_analy.do" data-index="11">
											销项分析
										</li>
										<li class="J_menuItem" href="inout_analy.do" data-index="12">
											对比分析
										</li>
									</ul>
								</dd>

								<dd>
									<a href="#" class="dd-item">全部商品分析<span class="scm dd-ar"></span>
									</a>

									<ul class="ad-item-list">
										<li class="J_menuItem" href="minput.do" data-index="1">
											进项分析
										</li>

										<li class="J_menuItem" href="moutput.do" data-index="11">
											销项分析
										</li>
										<li class="J_menuItem" href="minout_analy.do" data-index="12">
											对比分析
										</li>
									</ul>

								</dd>

							</dl>
						</li>





						<li>
							<div class="li-item">
								<em class="scm li-ico ic2"></em>年度分析
								<span class="scm arrow"></span>
							</div>
							<dl>
								<dd>
									<a href="#" class="dd-item">单一商品分析<span class="scm dd-ar"></span>
									</a>
									<ul class="ad-item-list">
										<li class="J_menuItem" href="yinput_analy.do" data-index="1">
											进项分析
										</li>

										<li class="J_menuItem" href="youtput_analy.do" data-index="11">
											销项分析
										</li>
										<li class="J_menuItem" href="yinout_analy.do" data-index="12">
											对比分析
										</li>
									</ul>
								</dd>

								<dd>
									<a href="#" class="dd-item">全部商品分析<span class="scm dd-ar"></span>
									</a>

									<ul class="ad-item-list">
										<li class="J_menuItem" href="yallinput_analy.do" data-index="1">
											进项分析
										</li>

										<li class="J_menuItem" href="yalloutput_analy.do" data-index="11">
											销项分析
										</li>
										<li class="J_menuItem" href="yallinout_analy.do" data-index="12">
											对比分析
										</li>
									</ul>

								</dd>

							</dl>
						</li>














					</ul>
				</div>
			</div>


			<div class="ad-comment-box" id="ad-comment">
				<div class="ad-top-comment">
					<div class="ad-message">
						<div class="ad-top-left">
							<div class="ad-change-btn">
								<a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a>
							</div>

						</div>
						<div class="ad-top-right">


							<div class="ad-welcom">
								<div class="ad-wel-img">
									<img src="image/min_logo.png" height="36" width="36">
								</div>
								<div class="ad-wel-text">
									<div class="font-wel">
										欢迎您！
										<strong>vvc-Dream</strong>
									</div>
									<div class="font-wel">
										<a href="javascript:;"><strong>【退出】</strong> </a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
					
					
					<div class="ad-main-nav-box">
						<ul id="breadcrumbs-three">
							<li title="首页">
								<a href="javascript:;" class="dot">首页</a>
							</li>
						</ul>
						<a href="javascript:;" class="scm jian-a J_mainLeft main-sel pre"></a>
						
						<div class="ad-main-wraper .J_menuItems">
							<ul class="ad-main-list" id="ad-main">
							</ul>
						</div>
						
						<a href="javascript:;" class="scm jian-a J_mainRight next"></a>
					</div>
					
					
				
				<div class="ad-main-comment J_mainContent" id="ad-iframe">

					<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
						src="index_v1.jsp" frameborder="0" data-id="index_v0.html"
						seamless></iframe>
				</div>
				
				
			</div>
		</div>
		
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/contabs.js"></script>
		<script type="text/javascript" src="js/maintabs.js"></script>
		<script type="text/javascript" src="js/jquery-smartMenu-min.js"></script>
		<script type="text/javascript" src="js/jquery.nicescroll.min.js"></script>
		<script type="text/javascript">
		
		
		
		
	$(function() {
		
		$(".ad-menu").niceScroll( {
			cursorborder : "0 none",
			cursorcolor : "#1a1a19",
			cursoropacitymin : "0",
			boxzoom : false
		});
	})
</script>
	</body>
</html>
