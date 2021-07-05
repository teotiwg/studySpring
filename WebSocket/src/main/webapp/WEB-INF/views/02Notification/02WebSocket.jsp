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
<script>
function chatWin(skin){
	var id = document.getElementById("chat_id");
	if(id.value==''){
		alert('채팅 닉네임을 입력후 채팅창을 열어주세요');
		id.focus();
		return;
	}
	var room = document.getElementById("chat_room");
	if(skin=='normal')
		window.open(
			"02WebChat.do?chat_id="+id.value+"&chat_room="+room.value, 
			room.value+"-"+id.value, /* 방명과 접속자아이디를 통해 창의 이름 설정 */
			"width=500,height=700");
		/*
		window.open(창의URL(경로), 창의이름, 창의속성);
		※창의 이름의 동일할 경우 여러개의 창을 열어도 하나의 창에서
		열리게 되므로 항상 다른 이름으로 설정해야 한다.
		*/
	else
		window.open("02WebChatUI.do?chat_id="+id.value+"&chat_room="+room.value, 
				room.value+"-"+id.value,"width=350,height=490");
}
</script>
</head>
<body>
<div class="container">	
	<h2>SPRING WebSocket 활용한 채팅</h2>
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
			<td>회원아이디</td>
			<td>
				<input type="text" id="chat_id" 
					placeholder="본인의 닉네임을 쓰세요" />
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center;">
				<button type="button" onclick="chatWin('normal');" 
					class="btn btn-primary">채팅창열기</button>				
				<button type="button" onclick="chatWin('ui');" 
					class="btn btn-primary">UI적용된채팅창열기</button>				
			</td>
		</tr>
	</table>
</div>
</body>
</html>