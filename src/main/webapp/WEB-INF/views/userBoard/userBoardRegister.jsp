<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>	
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
	<!--  navbar -->	
	<%@include file="../userTemplate/navbar.jsp" %>	
	<!-- /.navbar -->

		<div class="container">		
			
			
				<!-- SideBar (left)  -->			
				<%@include file="../userTemplate/sidebar.jsp" %>		
				<!-- /SideBar (left)  -->
									
			<!-- content -->
			<form action="/userBoard/write" method="post">
			<div class="col-xs-6 col-sm-9">
					<div class="page-header">
  						<h1>Write <small> for UserBoard</small></h1>
					</div>	
					<!-- row -->			
					<div class="row">			
						<div class="col-xs-6 col-sm-3">				
							<div>
								 <h3>Title</h3>													
							</div>
						</div>
						<div class="col-xs-6 col-sm-9">				
							<div> 
								<input type="text" class="form-control" placeholder="input Title" name="title">					
							</div>
						</div>											
					</div>				
					<!--  //row -->	
					<!-- row -->			
					<div class="row">			
						<div class="col-xs-6 col-sm-3">				
							<div>
								 <h3>Writer</h3>													
							</div>
						</div>
						<div class="col-xs-6 col-sm-9">				
							<div> 
								<c:if test="${userVO ne null }">
									<input type="text" class="form-control" placeholder="${userVO.username}" readonly="readonly" >
								</c:if>
								<c:if test="${userVO eq null }">
									<input type="text" class="form-control" placeholder="input your name">
								</c:if>
													
							</div>
						</div>											
					</div>				
					<!--  //row -->	
					<!-- row -->			
					<div class="row">			
						<div class="col-xs-6 col-sm-3">				
							<div>
								 <h3>Content</h3>													
							</div>
						</div>
						<div class="col-xs-6 col-sm-9">				
							<div> 
								<textarea class="form-control" rows="10" name="content"></textarea>
							</div>
						</div>											
					</div>				
					<!--  //row -->	
					<!-- row -->			
					<div class="row">			
						<div class="col-xs-6 col-sm-3">				
							<div>
								 <h3>file</h3>													
							</div>
						</div>
						<div class="col-xs-6 col-sm-9">				
							<div> 
								<!-- file  -->
								<input type="file" name="images"/>
							</div>							
						</div>											
					</div>				
					<!--  //row -->	
					<!-- row -->			
					<div class="row">			
						<div class="col-xs-6 col-sm-3">				
							<div>								 											
							</div>
						</div>
						<div class="col-xs-6 col-sm-9">				
							<div> 
								<button type="submit" class="btn btn-lg btn-success">Write</button>	
								<button type="button" class="btn btn-lg btn-danger">Cancle</button>									
							</div>							
						</div>											
					</div>									
			</div>
			</form>		
			<!-- //content -->
			
		</div>
		<!--/.container-->
		
		
		<!--  footer -->		
		<%@include file="../userTemplate/footer.jsp" %>		
		<!--  /footer -->
			



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