package com.yedam.book.all;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.bookDAO;
import co.micol.board.vo.bookVO;

public class BooklistAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		bookDAO dao= new bookDAO();
		List<bookVO> list = new ArrayList<bookVO>();
		
		list= dao.bookselect_all();
		request.setAttribute("booklist", list);
		
		return "jsp/book/booklist.jsp";
	}

}
