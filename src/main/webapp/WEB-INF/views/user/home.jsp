<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Off Canvas Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="/resources/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/dist/css/offcanvas.css" rel="stylesheet">

</head>

<body>
	<c:choose>		
		<c:when test="${login ne null}">
			<script>
				alert("${login.userid} 님 반갑습니다!");
			</script>
		</c:when>	
		<c:when test="${msg eq 'logout'}">
			<script>
				alert("로그아웃!");
			</script>
		</c:when>	
		<c:when test="${msg eq 'loginFail'}">	
			<script>
				alert("ID,PW error!");
			</script> 
		</c:when>
		<c:when test="${msg eq 'loginCheck' }">
			<script>
				alert("Please Login !!");
			</script> 
		</c:when>	
	</c:choose>
	<%-- 
	<c:if test="${login ne null }">	
		<script>
			alert("${login.userid} 님 반갑습니다!");
		</script>
	</c:if>
	<c:if test="${login eq null}">
		<script>
			alert("로그인 실패!");
		</script>
	</c:if>
	<c:if test="${'logout' == msg}">
		<script>
			alert("로그아웃!");
		</script>
	</c:if> --%>
<%-- 
	<c:if test="${result == 'loginFail'}">
		<script>
			alert("로그인 실패!");
		</script>
	</c:if>	
	<c:if test="${result == 'loginSuccess'}">
		<script>	
			alert("로그인 성공!");
		</script>
	</c:if>

 --%>	<!--  navbar -->	
	<%@include file="../userTemplate/navbar.jsp" %>	
	<!-- /.navbar -->

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
		
			<!-- SideBar (left)  -->			
			<%@include file="../userTemplate/sidebar.jsp" %>		
			<!-- /SideBar (left)  -->
			
		
		<!--  Content -->

			<div class="col-xs-12 col-sm-9">
			<!-- 	<p class="pull-left visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p> -->
				<div class="jumbotron">
					<h1>Hello, world!</h1>
					<p>This is an example to show the potential of an offcanvas
						layout pattern in Bootstrap. Try some responsive-range viewport
						sizes to see it in action.</p>
				</div>
				<div class="row">
					<div class="col-xs-6 col-lg-4">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
				</div>
				<!--/row-->
			</div>
			<!--/.col-xs-12.col-sm-9-->

		</div>
		<!--/row-->

		<hr>
		
		<!--  /Content -->

		<!--  footer -->		
		<%@include file="../userTemplate/footer.jsp" %>		
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