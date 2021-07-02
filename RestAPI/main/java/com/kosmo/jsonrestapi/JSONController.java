package com.kosmo.jsonrestapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONController {

	/*
	jackson 라이브러리를 통해 Map컬렉션은 JSON객체로, 
	List컬렉션은 JSON배열로 출력해준다. 
	*/
	@RequestMapping("/jsonUse/jsonView.do")
	@ResponseBody 
	public Map<String, Object> responseBodyView(){
		//맵 컬렉션 생성
		Map<String, Object> map = new HashMap<String, Object>();
		//맵에 데이터 저장
		map.put("String", "나는 문자열이다");
		map.put("Number", 1004);
		map.put("Message", "JSON은 Jackson의존설정이 필요해욧");
		//리스트 컬렉션 생성
		ArrayList<String> list = new ArrayList<String>();
		list.add("Collection");
		list.add("되게편해요");
		list.add("배열보다 좋아요");
		//맵에 리스트 컬렉션 추가
		map.put("Collection", list);
		
		//출력결과는 JSON객체 형태이다. 
		return map;		
		/*
		{"Number":1004,
		"Message":"JSON은 Jackson의존설정이 필요해욧",
		"Collection":["Collection","되게편해요","배열보다 좋아요"],
		"String":"나는 문자열이다"
		} 
		*/
	}
}















