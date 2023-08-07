package freeBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.model.service.FreeBoardService;
import freeBoard.model.vo.FreeBoard;
import freeBoard.model.vo.PageData;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/bulletinBoard/freeBoard/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardService service = new FreeBoardService();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		PageData pd= service.selectFreeBoardList(currentPage);
		List<FreeBoard> fList = pd.getfList();
		request.setAttribute("fList", fList);
		request.setAttribute("pageNavi", pd.getPageNavi());
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/bulletinBoard/freeBoard/freeBoard.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
