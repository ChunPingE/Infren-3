package hello.servlet.web.springmvc.old;

import java.io.*;

import org.springframework.stereotype.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MyHttpRequestHandler.handleRequest");
	}
}