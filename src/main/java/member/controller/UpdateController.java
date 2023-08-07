package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/member/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		String memberId = request.getParameter("member-id");
		Member member = service.selectOneById(memberId);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/member/modifyMemberInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberNickname = request.getParameter("member-nickname");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String postarCodeOne = request.getParameter("post-1");
		String postarCodeTwo = request.getParameter("post-2");
		String postarEmail = request.getParameter("member-email");
	
		MemberService service = new MemberService();
		Member member = new Member(memberId, memberPw, memberNickname, memberPhone, memberAddress, postarCodeOne, postarCodeTwo, postarEmail);
		int result = service.updateMember(member);
		if(result>0) {		
	        request.setAttribute("msg", "회원정보 수정이 완료되었습니다.");
	        request.setAttribute("url", "/index.jsp");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp");
			view.forward(request, response);	
			
		} else {
			request.setAttribute("msg", "회원정보 수정이 완료되지 않았습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);	
		}
		
	}
}
