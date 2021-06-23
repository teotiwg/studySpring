package di;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration:
해당 클래스를 스프링 설정파일로 사용하겠다는 선언으로
XML 설정파일을 사용하는 대신 자바파일을 설정파일로 사용 
 */

@Configuration
public class AnnotationBean {
	/*
	@Bean :
	<bean>태그와 같이 자바빈 생성 시 선언
	생성된 빈은 컨트롤러에서 getBean()을 통해 주입받을 수 있다.
	메소드명은 주입받을때의 참조변수명으로 사용
	즉, Circle circleBean = new Circle()과 동일
	 */
	@Bean
	public Circle circleBean() {
		Point point2 = new Point(7, 8);
		Circle circle2 = new Circle();
		circle2.setPoint(point2);
		circle2.setRadian(20);
		
		return circle2;
	}
	
	@Bean
	public Persons personBean() {
		Persons person2 = new Persons();
		person2.setName("유겸");
		person2.setAge(10);
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("기타");
		hobbys.add("칼림바");
		hobbys.add("피아노");
		person2.setHobbys(hobbys);
		
		return person2;
	}
	
}
