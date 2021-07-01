package mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
	해당 인터페이스는 컨트롤러와 DAO 사이에서 매개역할을 하는 서비스 객체로 사용됌
 */
@Service
public interface MybatisDAOImpl {
	
	// 게시물 수 카운트
	//public int getTotalCount();
	// 목록에 출력할 게시물 가져오기
	//public ArrayList<MyBoardDTO> listPage(int s, int e);

	public int getTotalCount(ParameterDTO parameterDTO);
	public ArrayList<MyBoardDTO> listPage(ParameterDTO parameterDTO);
	
	/*
	Mapper에서 파라미터를 처리할 수 있는 세번째 방법으로,
	@Param어노테이션 사용
	이때는 변수명을 그대로 Mapper에서 사용 가능
	 */
	public void write(@Param("_name") String name,
					@Param("_contents") String contents,
					@Param("_id") String id);
	
	// 기존 게시물 조회
	public MyBoardDTO view(ParameterDTO parameterDTO);
	// 수정 처리
	public int modify(MyBoardDTO myBoardDTO);
	// 삭제처리
	public int delete(String idx, String id);
	
	// Map컬렉션 사용 위한 메소드
	public ArrayList<MyBoardDTO> hashMapUse(Map<String, String> hMap);
	// List컬렉션 사용 위한 메소드
	public ArrayList<MyBoardDTO> arrayListUse(List<String> aList);
	
}
