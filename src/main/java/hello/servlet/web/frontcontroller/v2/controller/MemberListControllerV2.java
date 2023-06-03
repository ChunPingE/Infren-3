package hello.servlet.web.frontcontroller.v2.controller;

import java.io.*;
import java.util.*;

import hello.servlet.domain.member.*;
import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v2.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MemberListControllerV2 implements ControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();
		request.setAttribute("members", members);
		return new MyView("/WEB-INF/views/members.jsp");
	}
}