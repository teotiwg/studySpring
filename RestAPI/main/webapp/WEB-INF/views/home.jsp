<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body> 	
	<h2>JSON 사용하기</h2>
	<li>
		<a href="./jsonUse/jsonView.do" target="_blank">
			@ResponseBody 어노테이션을 이용한 JSON데이터 보기
		</a>
	</li>
	
	
	
	
	
	<h2>RestAPI 만들어보기</h2>
	<li>
		<a href="./restapi/boardList.do?nowPage=1" target="_blank">
			리스트보기(페이지별)
		</a>
	</li>
	<li>
		<a href="./restapi/boardList.do?searchField=title&searchTxt=70%EB%B2%88+67%EB%B2%88" target="_blank">
			검색결과보기(공백으로구분)
		</a>
	</li>
	<li>
		<a href="./restapi/boardView.do?num=67" target="_blank">
			내용보기
		</a>
	</li>
	
	<h2>Ajax와 연동하기</h2>
	<li>
		<a href="./ajax/boardList.do" target="_blank">
			리스트보기(페이지별)
		</a>
	</li>
	<li>
		<a href="./ajax/boardView.do" target="_blank">
			내용보기
		</a>
	</li>
		
</body>
</html>
