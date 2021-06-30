package mybatis;

import java.util.ArrayList;

//파라미터 처리를 위한 DTO객체
public class ParameterDTO {
	private String user_id;//사용자아이디
	private String board_idx;//게시판일련번호
	private String searchField; 
	/////////////////////////////////////////////////////////////
	//private String searchTxt;//검색어(2차버전)
	private ArrayList<String> searchTxt;//검색어(3차버전)
	///////////////////////////////////////////////////////////
	private int start; 	
	private int end; 	
	public ParameterDTO() {}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(String board_idx) {
		this.board_idx = board_idx;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
//	public String getSearchTxt() {
//		return searchTxt;
//	}
//	public void setSearchTxt(String searchTxt) {
//		this.searchTxt = searchTxt;
//	}	 
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public ArrayList<String> getSearchTxt() {
		return searchTxt;
	}
	public void setSearchTxt(ArrayList<String> searchTxt) {
		this.searchTxt = searchTxt;
	}

}
