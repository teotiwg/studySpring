<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.css" />
	<script src="./resources/jquery/jquery-3.6.0.js"></script>
	
</head>
<body>
	<div class="container">
		<h2>파일 업로드 결과 보기</h2>
		<a href="./uploadForm.do">
			파일업로드 폼 바로 가기
		</a>
		<!-- 모델 객체에 저장된 갯수만큼 반복 출력 -->
		<c:forEach begin="0"
			end="${ returnObj.files.size() - 1}"
			var="i">
			<ul>
				<li>제목${i+1 }:
					${returnObj.files[i].title }</li>
				<li>원본파일명${i+1 }:
					${returnObj.files[i].originalName }</li>
				<li>저장된파일명${i+1 }:
					${returnObj.files[i].saveFileName }</li>
				<li>전체경로${i+1 }:
					${returnObj.files[i].serverFullName }</li>
				<li><img src="../images/upload/${returnObj.files[i].saveFileName }" width="200"></li>
			</ul>
		</c:forEach>
	</div>
</body>
</html>