package co.micol.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.MemberDAO;
import co.micol.board.vo.MemberVO;

public class MemberInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원정보를 DB에 입력
		MemberDAO dao =new MemberDAO();
		MemberVO vo =new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setEnterdate(Date.valueOf(request.getParameter("enterdate")));
		
		int n= dao.insert(vo);
		String page;
		if(n !=0) {
			page="jsp/member/insertSucess.jsp";
		}else {
			page="jsp/member/insertFail.jsp";
		}
		return page;
	}

}
