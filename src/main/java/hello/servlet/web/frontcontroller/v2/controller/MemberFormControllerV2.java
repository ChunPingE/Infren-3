package hello.servlet.web.frontcontroller.v2.controller;

import java.io.*;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v2.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MemberFormControllerV2 implements ControllerV2 {
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new MyView("/WEB-INF/views/new-form.jsp");
	}
}