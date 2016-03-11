<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="contentType" content="text/html;charset=UTF-8">
<link rel="icon" href="../../favicon.ico">

<title>Off Canvas Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="/resources/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/dist/css/offcanvas.css" rel="stylesheet">

</head>

<body>
	<!--  navbar -->
	<%@include file="../userTemplate/navbar.jsp"%>
	<!-- /.navbar -->

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">

			<!-- SideBar (left)  -->
			<%@include file="../userTemplate/sidebar.jsp"%>
			<!-- /SideBar (left)  -->


			<!--  Content -->
			<div class="col-xs-12 col-sm-9">

				<div class="jumbotron">
					<h1>UserInfo</h1>
					<p></p>
				</div>
				<div class="row">
					<!-- <div class="col-xs-6 col-lg-4"> -->					
					<div class="col-xs-6 col-xs-offset-1">
						<form class="form-signin" method="get"  action="/user/userEdit?userid=${userVO.userid}">
							<h2 class="form-signin-heading">회원 정보 ${userVO.userid}</h2>
								
							
								<p class="text-info">아이디</p> <input type="text" name="userid" class="form-control" value="${userVO.userid}" readonly="readonly">
								<p class="text-info">비밀번호</p><input type="password" name="userpw" class="form-control" value="${userVO.userpw}" readonly="readonly" >
								<p class="text-info">이름</p><input type="text"  name="username"class="form-control"	 value="${userVO.username}" readonly="readonly"> 
								<p class="text-info">생년월일</p><input type="text"  name="birth" class="form-control" value="${userVO.birth}" readonly="readonly">
								<p class="text-info">이메일</p><input type="email" name="email" id="inputEmail" class="form-control" value="${userVO.email}" readonly="readonly">
								<p class="text-info">전화번호</p><input type="text"  name="phone" class="form-control" value="${userVO.phone}" readonly="readonly">
								
								<button type="submit" class="btn btn-lg btn-success">수정</button>	
												
						</form>
					</div>
				</div> 

			

	</div>

	<!--  /Content -->

	<!--  footer -->
	<%@include file="../userTemplate/footer.jsp"%>
	<!--  /footer -->

	</div>
	<!--/.container-->



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="/resources/dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="/resources/dist/js/offcanvas.js"></script>
</body>
</html>