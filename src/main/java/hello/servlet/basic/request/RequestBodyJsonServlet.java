package hello.servlet.basic.request;

import java.io.*;
import java.nio.charset.*;

import org.springframework.util.*;

import com.fasterxml.jackson.databind.*;

import hello.servlet.basic.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream,
				StandardCharsets.UTF_8);
		System.out.println("messageBody = " + messageBody);
		HelloData helloData = objectMapper.readValue(messageBody,
				HelloData.class);
		System.out.println("helloData.username = " + helloData.getUsername());
		System.out.println("helloData.age = " + helloData.getAge());
		response.getWriter().write("ok");
	}
}
