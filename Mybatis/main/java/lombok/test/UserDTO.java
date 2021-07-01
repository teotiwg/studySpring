package lombok.test;

import java.util.ArrayList;

import lombok.Data;

/*
롬복 라이브러리를 추가하면 아래와 같이 @Data 어노테이션만으로도
getter/setter/생성자 등을 자동으로 생성해줌
 */

@Data
public class UserDTO {
	
	private String name;
	private int age;
	private ArrayList<String> hobby;
	
}
