<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04SearchRadius.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	#map{
		width:100%; height:700px;
	}
</style>

<!-- 검색하는 반경에 따른 맵의 줌 레벨 설정 -->
<c:choose>
	<c:when test="${param.distance eq 1 }">
		<c:set var="zoomLevel" value="15" />
	</c:when>
	<c:when test="${param.distance eq 5 }">
		<c:set var="zoomLevel" value="14" />
	</c:when>
	<c:when test="${param.distance eq 10 }">
		<c:set var="zoomLevel" value="13" />
	</c:when>
	<c:otherwise>
		<c:set var="zoomLevel" value="12" />
	</c:otherwise>
</c:choose>

<script type="text/javascript">
var span;
//페이지가 로드되면 현재 위치를 가져온다. 
window.onload = function(){
	span = document.getElementById("result");
	
	if(navigator.geolocation){
		span.innerHTML = "Geolocation API를 지원합니다.";
		
		var options = {	
			enableHighAccurcy:true, 
			timeout:5000,
			maximumAge:3000
		};
		navigator.geolocation.getCurrentPosition(showPosition,showError,options);
	}
	else{
		span.innerHTML = "이 브라우저는 Geolocation API를 지원하지 않습니다.";
	}	
}
//위치를 정상적으로 가져왔을때..
var showPosition = function(position){
	//위도를 가져오는 부분
	var latitude = position.coords.latitude;
	//경도를 가져오는 부분
	var longitude = position.coords.longitude;
	span.innerHTML = "위도:"+latitude+",경도:"+longitude;	
	
	////////////////////////////////////////////////////////////////////////
	//위경도를 text input에 입력
	document.getElementById("latTxt").value = latitude;
	document.getElementById("lngTxt").value = longitude;
	////////////////////////////////////////////////////////////////////////
	
	//위경도를 가져온후 지도 표시
	initMap(latitude, longitude) ;
}
//구글맵 초기화 및 출력
function initMap(latVar, lngVar) {				
	var uluru = {lat: latVar, lng: lngVar};
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: ${zoomLevel}, /* 반경에 따른 줌 레벨(JSTL로 처리됨) */
		center: uluru
	});
	//현재 내 위치를 맵에 표시
	var marker = new google.maps.Marker({
		position: uluru,
		map: map,
		/////////////////////////////////////////////////////////////////////
		//내위치 아이콘 변경
		icon: '../resources/icon/icon_me.png'
		/////////////////////////////////////////////////////////////////////
	});
	
	//////////////////////////////////////////////////////////////////////////
	//다중마커s
	var infowindow = new google.maps.InfoWindow();
	
 	//시설을 맵에 표시
	var locations = [		
		/*['명동', 37.563576, 126.983431],
		['가로수길', 37.520300, 127.023008],
		['광화문', 37.575268, 126.976896],
		['남산', 37.550925, 126.990945],
		['이태원', 37.540223, 126.994005]*/	
		
		/* 검색된 결과 갯수만큼 반복하여 배열 형태로 출력한다. 
			[시설명(병원명), 위도, 경도] 와 같이 반복 출력된다.  */
		<c:forEach items="${searchLists }" var="row">
			['${row.hp_name }', ${row.hp_latitude }, ${row.hp_longitude }], 
		</c:forEach>
	];
	
 	var marker, i;

 	//위에서 설정한 locations의 갯수만큼 시설 아이콘을 표시한다.
	for (i=0; i<locations.length; i++) {  
		marker = new google.maps.Marker({
			id:i,
			position: new google.maps.LatLng(locations[i][1], locations[i][2]),
			map: map,
			icon: '../resources/icon/icon_facil.png'
		});
	
		google.maps.event.addListener(marker, 'click', (function(marker, i) {
			return function() {
				//정보창에 HTML코드가 들어갈 수 있음.
				infowindow.setContent(locations[i][0]+"<br/><a href='javascript:alert(\"병원명:"+locations[i][0]+"\");'>바로가기</a>");
				infowindow.open(map, marker);
			}
		})(marker, i));
	
		if(marker)
		{
			marker.addListener('click', function() {
				map.setZoom(16);
				map.setCenter(this.getPosition());
			});
		}
	}
	//다중마커s
	//////////////////////////////////////////////////////////////////////////
}
//위치 확인에 실패했을때의 콜백메소드
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

	<h2>내위치기반 반경검색하기</h2>
	
	<span id="result" style="color:red; font-size:1.5em; font-weight:bold;"></span>
	<fieldset>
		<legend>검색조건 ${resultCount }</legend>		
		<form name="searchFrm">
			현재위치에서
			<!-- 현재위치 위경도 입력상자 -->
			<input type="text" id="latTxt" name="latTxt" />
			<input type="text" id="lngTxt" name="lngTxt" />
			 
			<select name="distance" id="distance">
				<option value="1" <c:if test="${param.distance==1 }">selected</c:if>>1Km</option>
				<option value="5" <c:if test="${param.distance==5 }">selected</c:if>>5Km</option>
				<option value="10" <c:if test="${param.distance==10 }">selected</c:if>>10Km</option>
				<option value="20" <c:if test="${param.distance==20 }">selected</c:if>>20Km</option>
				<option value="30" <c:if test="${param.distance==30 }">selected</c:if>>30Km</option>
				<option value="40" <c:if test="${param.distance==40 }">selected</c:if>>40Km</option>
			</select>
			반경내 시설 검색하기
			<!-- 
				컨트롤러에서 검색된 게시물의 갯수와 출력할 갯수를 
				나눈 값을 model에 저장한 후 여기서 사용한다. 
			 -->
			<select name="pageNum" id="pageNum">			
			<c:forEach begin="1" end="${selectNum }" var="i" varStatus="loop">
				<option value="${i }" <c:if test="${param.pageNum==i }">selected</c:if>>${i }페이지</option>			
			</c:forEach>				
			</select>
			 
			<input type="submit" value="검색하기" />
		</form>
	</fieldset>
		
	<!-- <fieldset>
		<legend>현재위치 - 위도, 경도</legend>
		<span id="result" style="color:red; font-size:1.5em; font-weight:bold;"></span>
	</fieldset> -->
	
	<div id="map"></div>
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=${apiKey }"></script>
</div>
</body>
</html>