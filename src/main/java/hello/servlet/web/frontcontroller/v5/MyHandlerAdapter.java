package hello.servlet.web.frontcontroller.v5;

import java.io.*;

import hello.servlet.web.frontcontroller.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public interface MyHandlerAdapter {
	boolean supports(Object handler);

	ModelView handle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws ServletException, IOException;
}
