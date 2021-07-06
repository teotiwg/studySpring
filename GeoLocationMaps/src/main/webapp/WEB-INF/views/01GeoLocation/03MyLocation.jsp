<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03MyLocation.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	#map{
		width:100%; height:700px;
	}
</style>
<script type="text/javascript">
/*
watchPosition() : 위치가 변경될때마다 알려주는 반복위치 서비스
	getCurrentPosition()과 사용법은 동일하다. 
사용법 : var 참조변수 = watchPosition()
							위치가 변경될때마다 호출되는 콜백함수,
							위치파악중 오류발생시 호출되는 콜백함수,
							옵션
						);
clearWatch() : 반복위치 서비스 중단하기
사용법 : clearWatch(watchPosition의 참조변수);
 */
var span;
window.onload = function(){
	span = document.getElementById("result");
	
	if(navigator.geolocation){
		span.innerHTML = "Geolocation API를 지원합니다.";
		
		var options = {	
			enableHighAccurcy:true, 
			timeout:5000,
			maximumAge:3000
		};
		//navigator.geolocation.getCurrentPosition(showPosition,showError,options);
		
		//지속적인 위치 갱신이 필요한 경우 사용
		var watchID = 
			navigator.geolocation.watchPosition(showPosition,showError,options);
		//더이상 위치 갱신이 필요없다면 아래 함수 사용
		//navigator.geolocation.clearWatch(watchID);
	}
	else{
		span.innerHTML = "이 브라우저는 Geolocation API를 지원하지 않습니다.";
	}	
}

var showPosition = function(position){
	//위도를 가져오는 부분
	var latitude = position.coords.latitude;
	//경도를 가져오는 부분
	var longitude = position.coords.longitude;
	span.innerHTML = "위도:"+latitude+",경도:"+longitude;	
		
	//위경도를 가져온후 지도 표시
	initMap(latitude, longitude) ;
}

function initMap(latVar, lngVar) {				
	var uluru = {lat: latVar, lng: lngVar};
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 17,
		center: uluru
	});
	var marker = new google.maps.Marker({
		position: uluru,
		map: map
	});
}

var showError = function(error){
	switch(error.code){
		case error.UNKNOWN_ERROR:
			span.innerHTML = "알수없는오류발생";break;
		case error.PERMISSION_DENIED:
			span.innerHTML = "권한이 없습니다";break;
		case error.POSITION_UNAVAILABLE:
			span.innerHTML = "위치 확인불가";break;
		case error.TIMEOUT:
			span.innerHTML = "시간초과";break;
	}
}
</script>
</head>
<body>
<div class="container">
	<h2>내위치를 구글맵에 표시하기</h2>
	
	<fieldset>
		<legend>현재위치 - 위도, 경도</legend>
		<span id="result" style="color:red; font-size:1.5em; font-weight:bold;"></span>
	</fieldset>
	
	<div id="map"></div>
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=${apiKey }"></script>
</div>
</body>
</html>