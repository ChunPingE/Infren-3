package hello.servlet.web.springmvc.old;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public interface HttpRequestHandler {
	void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
