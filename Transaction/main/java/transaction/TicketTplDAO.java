package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TicketTplDAO {

	// 트랜젝션 템플릿 사용 위한 DAO
	
	// 멤버변수 선언
	JdbcTemplate template; // Spring-JDBC 사용
	TransactionTemplate transactionTemplate; // 
	
	public void setTemplate(JdbcTemplate template) {
		
		this.template = template;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		
		this.transactionTemplate = transactionTemplate;
	}
	
	public TicketTplDAO() {
		System.out.println("TicketTplDAO() 생성자 호출됌");
	}
	
	public boolean buyTicket(final TicketDTO dto) {
		
		System.out.println("buyTicket()메소드 호출");
		System.out.println(dto.getCustomerId() + "님이 티켓" + dto.getAmount() + "장을 구매합니다.");
		
		try {
			// 트랜젝션 템플릿은 execute()메소드를 통해 트랜젝션 처리
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					// 티켓 구매금액 처리
					template.update(new PreparedStatementCreator() {
						
						// 익명클래스 내부에서 오버라이딩
						@Override
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

							String query = "INSERT INTO "
									+ " transaction_pay (customerId, amount) "
									+ " VALUES (?, ?)";
							
							PreparedStatement psmt = con.prepareStatement(query);
							
							psmt.setString(1, dto.getCustomerId());
							psmt.setInt(2, dto.getAmount()*10000);
							return psmt;
						}
					});
					// 티켓 구매장수 처리
					template.update(new PreparedStatementCreator() {
						
						@Override
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

							String query = "INSERT INTO "
									+ " transaction_ticket (customerId, "
									+ " countNum) VALUES (?, ?)";
							PreparedStatement psmt = con.prepareStatement(query);
							psmt.setString(1,  dto.getCustomerId());
							psmt.setInt(2,  dto.getAmount());
							
							return psmt;
						}
					});
				}
			});
			/*
			 모든 업무에 대해 성공처리됐을 때 true 반환
			 템플릿을 사용하는 경우 별도의 commint() 혹은 rollback()이 필요 없음
			 */
				System.out.println("카드결제와 티켓구매 모두 정상처리됐습니다.");
				System.out.println("=트랜젝션 템플릿 사용함=");
				return true;
			}
			catch(Exception e) {
				System.out.println("제약조건 위반으로 모두 취소됐습니다.");
				return false;
		}
		
	}
	
}
