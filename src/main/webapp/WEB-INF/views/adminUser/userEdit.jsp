<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
                        <h1>Admin Home</h1>
                        <div class="row">
					<!-- <div class="col-xs-6 col-lg-4"> -->
					<div class="col-xs-6 col-xs-offset-1">
						<form class="form-signin" method="post" action="/user/userEdit">
							<h2 class="form-signin-heading">회원 정보 ${userVO.userid}</h2>


							<p class="text-info">아이디</p>
							<input type="text" name="userid" class="form-control"
								value="${userVO.userid}">
							<p class="text-info">비밀번호</p>
							<input type="text" name="userpw" class="form-control"
								value="${userVO.userpw}">
							<p class="text-info">이름</p>
							<input type="text" name="username" class="form-control"
								value="${userVO.username}">
							<p class="text-info">생년월일</p>
							<input type="text" name="birth" class="form-control"
								value="${userVO.birth}">
							<p class="text-info">이메일</p>
							<input type="email" name="email" id="inputEmail"
								class="form-control" value="${userVO.email}">
							<p class="text-info">전화번호</p>
							<input type="text" name="phone" class="form-control"
								value="${userVO.phone}">

							<button type="submit" class="btn btn-lg btn-success">OK</button>
							<button type="button" class="btn btn-lg btn-danger">취소</button>
							<button type="button" class="btn btn-lg btn-warning"
								data-toggle="modal" id="delete" data-target="#myModal">탈퇴</button>

							<!-- modal  -->
							<div id="myModal" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h3>회원 탈퇴</h3>
										</div>
										<div class="modal-body">
											<p>탈퇴 하시겠습니까???</p>
										</div>
										<div class="modal-footer">
											<a href="#" class="btn">Close</a> 
											<a href="/user/userDelete?userid=${userVO.userid}"	class="btn btn-primary">OK</a>
										</div>
									</div>
								</div>
							</div>
							<!--  -->
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
