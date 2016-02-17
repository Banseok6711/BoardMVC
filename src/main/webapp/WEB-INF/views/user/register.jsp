<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
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
	<%@include file="../include/navbar.jsp"%>
	<!-- /.navbar -->

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">

			<!-- SideBar (left)  -->
			<%@include file="../include/sidebar.jsp"%>
			<!-- /SideBar (left)  -->


			<!--  Content -->
			<div class="col-xs-12 col-sm-9">

				<div class="jumbotron">
					<h1>회원가입</h1>
					<p></p>
				</div>

				<div class="row">
					<!-- <div class="col-xs-6 col-lg-4"> -->						
					<div class="col-xs-6">
						<form class="form-signin" method="post"  action="/user/register">
							<h2 class="form-signin-heading">회원가입</h2>
							
								아이디 <input type="text" name="userid" class="form-control" placeholder="ID" >
								<hr>
								비밀번호<input type="password" name="userpw" class="form-control"	placeholder="Password" >
								<hr>
								비밀번호 확인<input type="password" class="form-control"placeholder="PasswordCheck" >
								<hr>
								이름<input type="text"  name="username"class="form-control"	placeholder="name" >
								<hr>
								생년월일<input type="text"  name="birth" class="form-control"	placeholder="birth(900127)">
								<hr>
								이메일<input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" >
								<hr>
								전화번호<input type="text"  name="phone" class="form-control" placeholder="phone(01092438100)">
								<hr>
								
								<button type="submit" class="btn btn-lg btn-success">OK</button>	
								<button type="button" class="btn btn-lg btn-danger">Cancle</button>					
						</form>
					</div>
									
				</div> 

			

	</div>

	<!--  /Content -->

	<!--  footer -->
	<%@include file="../include/footer.jsp"%>
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