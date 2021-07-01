package transaction;

import lombok.Data;

/*
 롬복 라이브러리를 통해 getter/setter 자동 처리
 */

@Data
public class TicketDTO {

	private String customerId;
	private int amount;
	
}
