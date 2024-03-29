package hello.servlet.basic.reponse;

import java.io.*;

import com.fasterxml.jackson.databind.*;

import hello.servlet.basic.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/**
 * http://localhost:8080/response-json
 *
 */
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Content-Type: application/json
		response.setHeader("content-type", "application/json");
		response.setCharacterEncoding("utf-8");
		HelloData data = new HelloData();
		data.setUsername("kim");
		data.setAge(20);
		// {"username":"kim","age":20}
		String result = objectMapper.writeValueAsString(data);
		response.getWriter().write(result);
	}
}