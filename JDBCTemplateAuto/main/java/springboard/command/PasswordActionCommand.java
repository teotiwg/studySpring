package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;

public class PasswordActionCommand implements BbsCommandImpl {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		
		String mode = req.getParameter("mode");
		String idx = req.getParameter("idx");
		String nowPage = req.getParameter("nowPage");
		String pass = req.getParameter("pass");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();		
		int rowExist = dao.password(idx, pass);
		if(rowExist<=0) {
			//패스워드틀림
			model.addAttribute("isCorrMsg", "패스워드가 일치하지 않습니다");
			model.addAttribute("idx", idx);
			model.addAttribute("modePage", "07Board/password");
		}
		else {
			if(mode.equals("edit")){
				//수정이면 수정폼으로 이동한다.
				model.addAttribute("modePage", "edit");
			}
			else if(mode.equals("delete")) {
				//패스워드 검증후 문제가없다면 즉시 삭제처리한다.
				model.addAttribute("modePage", "delete");
			}
		}		
	}
}
