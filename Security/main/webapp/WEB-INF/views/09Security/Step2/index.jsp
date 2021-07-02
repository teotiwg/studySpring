<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 
	uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

	<h2>스프링 시큐리티 Step2</h2>
	
	<h3>로그인 화면 커스텀으로 구현하기</h3>
	
	<h4>필요권한 : USER or ADMIN 중 하나가 필요</h4>	
	
	<h4>
		사용자 아이디 : ${user_id }
	</h4>
	
	<form:form method="post" 
		action="${pageContext.request.contextPath }/
			security2/logout">
		<input type="submit" value="로그아웃" />
	</form:form>

	<jsp:include page="/resources/common_link.jsp" />
</div>
</body>
</html>










