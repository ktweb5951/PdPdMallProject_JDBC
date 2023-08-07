package freeBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import freeBoard.model.service.FreeBoardService;
import freeBoard.model.vo.FreeBoard;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/bulletinBoard/freeBoard/insert.do")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/bulletinBoard/freeBoard/write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//	    HttpSession session = request.getSession();
//	    String memberId = (String) session.getAttribute("memberId");
		
		FreeBoardService service = new FreeBoardService();
		String freeBoardTitle = request.getParameter("freeBoard-title");
		String freeBoardContent = request.getParameter("freeBoard-content");
		 FreeBoard freeBoard = new FreeBoard(freeBoardTitle, freeBoardContent);
		int result = service.insertFreeBoard(freeBoard);
		if(result > 0) {
			//성공하면 공지사항 리스트로 이동
			response.sendRedirect("/bulletinBoard/freeBoard/list.do");
			
		}else {
			//실패하면 실패메시지 출력
			request.setAttribute("msg", "게시글등록이 완료되지 않았습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}
	

}
