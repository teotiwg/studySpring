<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script>
//jQuery의 진입점
$(function(){
	//목록불러오기 버튼을 클릭했을때 ajax()를 호출한다. 
	$('#btnBoard').click(function(){
		$.ajax({
			type : 'get', //전송방식		
			url : '../restapi/boardList.do', //요청할URL
			data : {nowPage : $('#nowPage').val()}, //전송할 파라미터
			contentType : "text/html;charset:utf-8",
			dataType : "json", //콜백 받을 데이터의 형식
			success : sucCallBack, //성공시의 콜백메소드
			error : errCallBack //실패시의 콜백메소드
		});
	});
	//페이지가 로드되면 trigger()함수를 통해 click이벤트를 발생시킴.
	//즉, 우리가 직접 버튼을 클릭한것과 동일한 액션을 실행함.
	$('#btnBoard').trigger('click');
});
//성공시 콜백메소드. 
function sucCallBack(resData){
	//서버에서 콜백해준 JSON데이터를 파싱하여 출력한다. 
	let tableData = "";
	//JSON배열이므로 each()함수를 통해 갯수만큼 반복한다. 
	$(resData).each(function(index, data){		
		tableData += ""
		+"<tr>"
		+"    <td>"+data.num+"</td>"
		+"    <td>"+data.title+"</td>"             
		+"    <td>"+data.id+"</td>"
		+"    <td>"+data.postdate+"</td>"
		+"    <td>"+data.visitcount+"</td>"
		+"</tr>";
	});
	//해당 위치에 있던 내용을 새로운 내용으로 대체한다.
	$('#show_data').html(tableData);
}
//실패했을때의 콜백 메소드
function errCallBack(errData){
	console.log(errData.status+":"+errData.statusText);
}
</script>
</head>
<body>
<div class="container">
	<h2>게시판 API 활용하여 목록 출력하기</h2>
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>제목</th>			
			<th>아이디</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tbody id="show_data"></tbody>
	</table>
	<div>
		<select id="nowPage">
			<option value="1">1page</option>
			<option value="2">2page</option>
			<option value="3">3page</option>
			<option value="4">4page</option>
			<option value="5">5page</option>
		</select>
		<input type="button" value="목록불러오기" id="btnBoard" />
	</div>
</div>
</body>
</html>