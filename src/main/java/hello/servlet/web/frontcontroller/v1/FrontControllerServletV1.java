package hello.servlet.web.frontcontroller.v1;

import java.io.*;
import java.util.*;

import hello.servlet.web.frontcontroller.v1.controller.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
	private Map<String, ControllerV1> controllerMap = new HashMap<>();

	public FrontControllerServletV1() {
		controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
		controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
		controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("FrontControllerServletV1.service");
		String requestURI = request.getRequestURI();
		ControllerV1 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		controller.process(request, response);
	}
}