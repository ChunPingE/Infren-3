package hello.servlet.basic.reponse;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/**
 * http://localhost:8080/response-header
 *
 */
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// [status-line]
		response.setStatus(HttpServletResponse.SC_OK); // 200
		// [response-headers]
		response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-header", "hello");
		// [Header 편의 메소드]
		content(response);
		cookie(response);
		redirect(response);
		// [message body]
		PrintWriter writer = response.getWriter();
		writer.println("ok");
	}

	// content편의 메소드
	private void content(HttpServletResponse response) {
		// Content-Type: text/plain;charset=utf-8
		// Content-Length: 2
		// response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		// response.setContentLength(2); //(생략시 자동 생성)
	}

	// 쿠키 편의 메소드
	private void cookie(HttpServletResponse response) {
		// Set-Cookie: myCookie=good; Max-Age=600;
		// response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
		Cookie cookie = new Cookie("myCookie", "good");
		cookie.setMaxAge(600); // 600초
		response.addCookie(cookie);
	}

	// redirect 편의 메소드
	private void redirect(HttpServletResponse response) throws IOException {
		// Status Code 302
		// Location: /basic/hello-form.html
		// response.setStatus(HttpServletResponse.SC_FOUND); //302
		// response.setHeader("Location", "/basic/hello-form.html");
		response.sendRedirect("/basic/hello-form.html");
	}
}