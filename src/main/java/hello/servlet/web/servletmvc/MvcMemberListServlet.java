package hello.servlet.web.servletmvc;

import java.io.*;
import java.util.*;

import hello.servlet.domain.member.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MvcMemberListServlet.service");
		List<Member> members = memberRepository.findAll();
		request.setAttribute("members", members);
		
		String viewPath = "/WEB-INF/views/members.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
