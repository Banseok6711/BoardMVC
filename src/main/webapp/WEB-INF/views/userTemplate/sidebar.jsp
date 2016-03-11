<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<div class="col-xs-6 col-sm-3"  id="sidebar">
	<div class="list-group">
		<a href="#" class="list-group-item active">Category</a>
		
		<c:if test="${login ne null }">
			<a href="/user/userinfo" class="list-group-item">내 정보</a>
		 </c:if>
		 
		<a href="#"	class="list-group-item">병원</a> 
		<a href="#" class="list-group-item">약국</a>
		<a href="#" class="list-group-item">헬스</a> 
		<a href="#"	class="list-group-item">약국</a> 
		<a href="/userBoard/listPage"	class="list-group-item">게시판</a> 
		<a href="/userBoard/write"	class="list-group-item">게시판 write</a> 
		<a href="#" class="list-group-item">QnA</a>		
	</div>
</div>