package co.micol.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.bookDAO;
import co.micol.board.vo.bookVO;

public class RentlistAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		bookDAO dao= new bookDAO();
		List<bookVO> list = new ArrayList<bookVO>();
		
		list= dao.rentselect_all();
		request.setAttribute("rent", list);
		
		return "jsp/book/borrow.jsp";
		
	}

}
