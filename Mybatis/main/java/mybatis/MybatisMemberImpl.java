package mybatis;

import org.springframework.stereotype.Service;

/*
 @Service 어노테이션이 있으면 스프링이 시작될 때
 자동으로 빈 생성됌
 따라서 해당 프로그램에선 @Autowired하는 부분이 없으므로 
 어노테이션은 생략 가능
 */

@Service
public interface MybatisMemberImpl {
	// 로그인 처리
	public MemberVO login(String id, String pass);

}
