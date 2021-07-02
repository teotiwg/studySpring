package mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
 
@Service
public interface IBoardDAO {
	//게시물 갯수 카운트
	public int getTotalCount(ParameterDTO parameterDTO);
	//출력할 게시물 가져오기
	public ArrayList<BoardDTO> listPage(ParameterDTO parameterDTO);
	//게시물 내용보기
	public ArrayList<BoardDTO> view(ParameterDTO parameterDTO);
}
