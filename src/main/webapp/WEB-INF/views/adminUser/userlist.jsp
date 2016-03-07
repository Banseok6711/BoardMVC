<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/simple-sidebar.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

      <!-- sidebar -->
      <%@include  file="../adminTemplate/sidebar.jsp" %>      
      <!-- //sidebar -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>User List</h1>
                        <!--  Content -->

			<div class="col-xs-12 col-sm-12">
			<!-- 	<p class="pull-left visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p> -->				
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
              <c:forEach items="${userList}" var="userVO" varStatus="status" >
                <tr>
                  <td>${status.count}</td>
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
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/resources/dist/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/dist/js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>
