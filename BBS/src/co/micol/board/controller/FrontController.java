package co.micol.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.book.all.BookinsertAction;
import com.yedam.book.all.BookinsertFormAction;
import com.yedam.book.all.BooklistAction;
import com.yedam.book.all.Main2Action;

import co.micol.board.common.Action;

@WebServlet("/FrontController")

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Action> map = new HashMap<String, Action>();

	public FrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		// 요청들을 정의함
		map.put("/main.do" , new Main2Action());
		map.put("/bookinsertForm.do", new BookinsertFormAction());
		map.put("/bookinsert.do", new BookinsertAction());
		map.put("/booklist.do", new BooklistAction());
		map.put("/rentlist.do" , new RentlistAction());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 수행할 명령을 정리
		request.setCharacterEncoding("utf-8");// 한글 처리
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());// 실제들어오는 요청페이지를 찾음

		Action command = map.get(path);
		String viewPage = command.exec(request, response);// 명령이 수행되고 나서 보여줄페이지를 선택

		if (viewPage != null) {
			if (viewPage.startsWith("redirect")) {
				response.sendRedirect(viewPage.substring(9));
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);// 선택한페이지로 가기
				dispatcher.forward(request, response);
			}
		}

	}

}
