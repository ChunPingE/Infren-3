package hello.servlet.web.frontcontroller.v2.controller;

import java.io.*;

import hello.servlet.domain.member.*;
import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v2.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MemberSaveControllerV2 implements ControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		Member member = new Member(username, age);
		memberRepository.save(member);
		request.setAttribute("member", member);
		return new MyView("/WEB-INF/views/save-result.jsp");
	}
}