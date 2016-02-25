<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<nav class="navbar navbar-fixed-top navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">우리동네 가게들</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">				
				<li><a href="#about">About</a></li>
				<li><a href="">Contact</a></li>
				<li><a href="/user/register">Join</a></li>		
			</ul>			
			
			<c:if test="${login eq null}">
				<form class="navbar-form pull-right" action="/user/loginPost" method="post">
	              <input class="span2" type="text" name="userid" placeholder="Email">
	              <input class="span2" type="password" name="userpw" placeholder="Password">
	              <button type="submit" class="btn btn-small btn-success" id="sign">Sign in</button>
	            </form>
            </c:if>
           	<c:if test="${login ne null }">
            	<div class="navbar pull-right">
            		<a class="navbar-brand" href="#">${login.userid }</a> 
            		<div class="navbar-brand" >님 접속중...</div>
            	</div>
            	<div class="navbar pull-right">
            		<a class="navbar-brand" href="/user/logout">로그아웃</a>
            	</div>
           	</c:if>
            
            
		</div>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.container -->
</nav>