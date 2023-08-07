package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EnrollController
 */
@WebServlet("/member/register.do")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String memberNickname = request.getParameter("member-nickname");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberPostOne = request.getParameter("post-1");
		String memberPostTwo = request.getParameter("post-2");
		String memberEmail = request.getParameter("member-email");
		
		Member member = new Member(memberId, memberPw, memberName, memberNickname, memberPhone, memberAddress, memberPostOne, memberPostTwo, memberEmail);
		MemberService service = new MemberService();
		int result = service.insertMember(member);
		
		if(result > 0 ) {
	        request.setAttribute("msg", "🎉 폰다판다 회원이 되신걸 환영합니다. 🎉");
	        request.setAttribute("url", "/member/login.do");
	        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp");
			view.forward(request, response);	
		} else {
			request.setAttribute("msg", "회원가입 실패");
			request.setAttribute("url", "/member/login.do");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);	
		}
	}

}
