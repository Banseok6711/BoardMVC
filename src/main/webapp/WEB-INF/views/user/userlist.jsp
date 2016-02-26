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
	<c:if test="${msg =='deleteSuccess'}">
		<script>
			alert("삭제되었습니다!");
		</script>
	</c:if>
	


	<!--  navbar -->	
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
					<h1>userList</h1>					
				</div>
				<div class="row">
				
				<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>아이디</th>
                  <th>이름</th>
                  <th>생년월일</th>
                  <th>가입날짜</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${userList}" var="userVO">
                <tr>
                  <td></td>
                  <td>
                  	<a href="<%=request.getContextPath()%>/user/userinfo?userid=${userVO.userid}">${userVO.userid}</a>
                  </td>
                  <td>${userVO.username}</td>
                  <td>${userVO.birth}</td>
                  <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${userVO.regdate}"/>                  	
                  </td>
                </tr>
               </c:forEach>              
              </tbody>
            </table>
          </div>
				</div>
				<!--/row-->
			</div>
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