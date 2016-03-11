<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
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
                        <h1>userInfo</h1>
                        <div class="row">
					<!-- <div class="col-xs-6 col-lg-4"> -->					
					<div class="col-xs-6 col-xs-offset-1">
						<form class="form-signin" method="get"  action="/user/userEdit?userid=${userVO.userid}">
							<h2 class="form-signin-heading">회원 정보 ${userVO.userid}</h2>
								
							
								<p class="text-info">아이디</p> <input type="text" name="userid" class="form-control" value="${userVO.userid}" readonly="readonly">
								<p class="text-info">비밀번호</p><input type="text" name="userpw" class="form-control" value="${userVO.userpw}" readonly="readonly" >
								<p class="text-info">이름</p><input type="text"  name="username"class="form-control"	 value="${userVO.username}" readonly="readonly"> 
								<p class="text-info">생년월일</p><input type="text"  name="birth" class="form-control" value="${userVO.birth}" readonly="readonly">
								<p class="text-info">이메일</p><input type="email" name="email" id="inputEmail" class="form-control" value="${userVO.email}" readonly="readonly">
								<p class="text-info">전화번호</p><input type="text"  name="phone" class="form-control" value="${userVO.phone}" readonly="readonly">
								
								<button type="submit" class="btn btn-lg btn-success">수정</button>	
								<!-- <button type="button" class="btn btn-lg btn-danger">취소</button> -->					
						</form>
					</div>
				</div> 
                        
                        
                       
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
