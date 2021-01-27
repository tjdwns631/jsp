package com.yedam.book.all;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;

public class BookinsertFormAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "/jsp/book/bookinsert.jsp";
	}

}
