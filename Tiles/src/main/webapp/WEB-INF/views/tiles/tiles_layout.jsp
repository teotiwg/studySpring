<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 타일즈에서 제공하는 taglib 지시어가 필요함 -->    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="../resources/css/common.css">
<title>타일즈 레이아웃</title>
</head>
<body>
<!--  
	tiles-define.xml에서 설정한 템플릿 파일들을 해당 파일에서
	레이아웃으로 배치한다. 
-->
<div class="container">
	<h2>타일즈 레이아웃</h2>
	<div class='wrap'>
		<tiles:insertAttribute name="top" />
		<div class='content'>  	
			<tiles:insertAttribute name="left" />
			<div class="page_content">
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
		<tiles:insertAttribute name="bottom" />
	</div>
</div>
</body>
</html>