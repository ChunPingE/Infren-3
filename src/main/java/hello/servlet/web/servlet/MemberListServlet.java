package hello.servlet.web.servlet;

import java.io.*;
import java.util.*;

import hello.servlet.domain.member.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		List<Member> members = memberRepository.findAll();
		PrintWriter w = response.getWriter();
		w.write("<html>");
		w.write("<head>");
		w.write(" <meta charset=\"UTF-8\">");
		w.write(" <title>Title</title>");
		w.write("</head>");
		w.write("<body>");
		w.write("<a href=\"/index.html\">메인</a>");
		w.write("<table>");
		w.write(" <thead>");
		w.write(" <th>id</th>");
		w.write(" <th>username</th>");
		w.write(" <th>age</th>");
		w.write(" </thead>");
		w.write(" <tbody>");
		/*
		 * w.write(" <tr>"); w.write(" <td>1</td>"); w.write(" <td>userA</td>");
		 * w.write(" <td>10</td>"); w.write(" </tr>");
		 */
		for (Member member : members) {
			w.write(" <tr>");
			w.write(" <td>" + member.getId() + "</td>");
			w.write(" <td>" + member.getUsername() + "</td>");
			w.write(" <td>" + member.getAge() + "</td>");
			w.write(" </tr>");
		}
		w.write(" </tbody>");
		w.write("</table>");
		w.write("</body>");
		w.write("</html>");
	}
}