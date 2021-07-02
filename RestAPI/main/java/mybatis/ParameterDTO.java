package mybatis;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ParameterDTO {		
	private String num;
	private String searchField;
	private ArrayList<String> searchTxt;
	private int start; 	
	private int end;
	
}
