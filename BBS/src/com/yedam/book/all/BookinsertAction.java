package com.yedam.book.all;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.bookDAO;
import co.micol.board.vo.bookVO;

public class BookinsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		bookDAO dao = new bookDAO();
		bookVO vo =new bookVO();
		vo.setBook_name(request.getParameter("book_name"));
		vo.setBook_coverimg(request.getParameter("book_coverimg"));
		vo.setBook_date(Date.valueOf(request.getParameter("book_date")));
		vo.setBook_price(Integer.parseInt(request.getParameter("book_price")));
		vo.setBook_publisher(request.getParameter("book_publisher"));
		vo.setBook_info(request.getParameter("book_info"));
		
		int n = dao.bookinsert(vo);
		
		return "jsp/main/main.jsp";
	}

}
