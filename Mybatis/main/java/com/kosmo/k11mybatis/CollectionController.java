package com.kosmo.k11mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mybatis.MyBoardDTO;
import mybatis.MybatisDAOImpl;

@Controller
public class CollectionController {

	@Autowired
	private SqlSession sqlSession;
	
	/*
	Mapper에서 HashMap컬렉션 사용
	
	 */
	@RequestMapping("/Collection/hashMap.do")
	public String hashMap(Model model) {
		
		// 검색어 저장 위해 Map컬렉션 생성
		Map<String, String> hashMap = new HashMap<String, String>();
		// 각 키값에 원하는 검색어(파라미터) 추가
		hashMap.put("key_id", "kosmo");
		hashMap.put("key_name", "고스톱");
		hashMap.put("key_contents", "잔치집");
		
		// 파라미터를 저장한 Map객체를 Mapper로 전달
		ArrayList<MyBoardDTO> lists = 
				sqlSession.getMapper(MybatisDAOImpl.class).hashMapUse(hashMap);
		
		// Mapper에서 동적으로 생성되는 쿼리문을 로그로 출력
		String sql = 
				sqlSession.getConfiguration().getMappedStatement("hashMapUse").getBoundSql(hashMap).getSql();
		
		System.out.println("sql = "+ sql);
		
		model.addAttribute("lists", lists);
		return "08CollectionUse/hashMapUse";
	}
	
	// Mapper에서 ArrayList컬렉션 사용
	@RequestMapping("/Collection/arrayList.do")
	public String arrayList(Model model) {
		
		// 파라미터를 리스트에 저장
		List<String> arrayList = new ArrayList<String>();
		
		arrayList.add("고스톱");
		arrayList.add("낙자쌤");
		arrayList.add("기즈모");
		
		ArrayList<MyBoardDTO> lists = 
				sqlSession.getMapper(MybatisDAOImpl.class).arrayListUse(arrayList);
		
		model.addAttribute("lists", lists);
		return "08CollectionUse/ArrayListUse";
		
	}
	
}
