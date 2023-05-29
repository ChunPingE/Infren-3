package hello.servlet.basic.request;

import java.io.*;
import java.nio.charset.*;

import org.springframework.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream,
				StandardCharsets.UTF_8);
		System.out.println("messageBody = " + messageBody);
		response.getWriter().write("ok");
	}
}