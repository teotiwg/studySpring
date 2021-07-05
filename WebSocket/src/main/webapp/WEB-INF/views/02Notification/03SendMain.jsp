<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<script>
	function chatWin(){
		var id = document.getElementById("chat_id");
		if(id.value==''){
			alert('닉네임을 입력후 채팅창을 열어주세요');
			id.focus();
			return;
		}
		var room = document.getElementById("chat_room");
		window.open("03SendMessage.do?chat_id="+id.value+"&chat_room="+room.value, room.value+"-"+id.value,"width=500,height=700"); 
	}
	</script>
	
	<h2>SPRING WebSocket+Notification 활용한 실시간쪽지 보내기</h2>
	<table border=1 cellpadding="10" cellspacing="0">
		<tr>
			<td>채팅방</td>
			<td>
				<select id="chat_room">
					<option value="myRoom1">KOSMO-1번방</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>회원아이디[본인의아이디]</td>
			<td>
				<input type="text" id="chat_id" value="" />
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center;">
				<button type="button" onclick="chatWin();">쪽지보내기창열기</button>				
			</td>
		</tr>
	</table>
</div>
</body>
</html>