package hello.servlet.web.frontcontroller.v1;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public interface ControllerV1 {
	void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}