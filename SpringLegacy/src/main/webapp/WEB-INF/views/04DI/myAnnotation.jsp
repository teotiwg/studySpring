<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">
	<h2>어노테이션을 통해 JAVA파일에서 DI 사용하기</h2>

	<ul>
		<li>홍길동 회원님 정보 : </li>
		<li>${memberInfo1 }</li>
	</ul>
	<ul>
		<li>[본인이름] 회원님의 정보 :</li>
		<li>${memberInfo2 }</li>
	</ul>
</div>
</body>
</html>