package com.kosmo.k11transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import transaction.TicketDAO;
import transaction.TicketDTO;
import transaction.TicketTplDAO;

/*
2. 트랜젝션 템플릿을 활용한 처리

자동 주입 시 setter를 사용 않아도 됌. 멤버변수에 직접 적용 가능
 */
@Controller
public class TransactionController {
	
	private TicketTplDAO daoTpl;
	
	@Autowired
	public void setDaoTpl(TicketTplDAO daoTpl) {
		this.daoTpl = daoTpl;
	}
	// 구매 페이지
	@RequestMapping("/transaction/buyTicketTpl.do")
	public String buyTicketTpl() {
		return "08Transaction/buyTicketTpl";
	}
	
	// 구매 처리
	@RequestMapping("/transaction/buyTicketTplAction.do")
	public String buyTicketTplAction(TicketDTO ticketDTO, Model model) {
		
		// 폼값을 저장한 커맨드 객체를 매개변수로 구매 메소드 호출
		boolean isBool = daoTpl.buyTicket(ticketDTO);
		if(isBool == true) {
			// 정상처리된 경우 모든 작업은 commit됌
			model.addAttribute("successOrFail", "티켓구매가 정상 처리됐습니다.");
		}
		else {
			// 오류가 발생한 경우, 모든 작업이 rollback됌
			model.addAttribute("successOrFail", "티켓구매가 최소됐습니다. 다시 시도해주세요");
		}
		model.addAttribute("ticketInfo", ticketDTO);
		
		return "08Transaction/buyTicketTplAction";
	}
	/**************
	 
	 트랜젝션 매니져와 템플릿은 동시에 사용 불가하므로
	 2단게에선 1단계의 모든 부분을 주석으로 처리 후 진행
	 
	 **************/
	
	
/*
 1. 트랜잭션 매니저를 활용한 트랜잭션 처리:
 	servlet-context.xml 에서 미리 생성한 DAO를 자동주입받아 사용
 */
	//private TicketDAO dao;
/*	
	@Autowired
	public void setDAO(TicketDAO dao) {
		this.dao = dao;
		System.out.println("@Autowired => TicketDAO 주입 성공");
	}
	
	// 티켓 구매 페이지
	@RequestMapping("/transaction/buyTicketMain.do")
	public String buyTicketMain() {
		
		return "08Transaction/buyTicketMain";
	}
	
	@RequestMapping("/transaction/buyTicketAction.do")
	public String buyTicketAction(TicketDTO ticketDTO, Model model) {
		
		//클라이언트가 전송한 폼값을 커맨드 객체를 통해 
		//헌번에 받아 DAO로 전달
		 
		dao.buyTicket(ticketDTO);
		model.addAttribute("ticketInfo", ticketDTO);
		
		return "08Transaction/buyTicketAction";
	}
*/	
}
