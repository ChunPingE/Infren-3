package hello.servlet.web.frontcontroller.v1.controller;

import java.io.*;

import hello.servlet.web.frontcontroller.v1.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MemberFormControllerV1 implements ControllerV1 {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}