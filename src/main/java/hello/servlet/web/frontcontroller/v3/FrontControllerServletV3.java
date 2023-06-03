package hello.servlet.web.frontcontroller.v3;

import java.io.*;
import java.util.*;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v3.controller.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
	private Map<String, ControllerV3> controllerMap = new HashMap<>();

	public FrontControllerServletV3() {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();

		ControllerV3 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Map<String, String> paramMap = createParamMap(request);
		ModelView mv = controller.process(paramMap);
		String viewName = mv.getViewName();
		
		MyView view = viewResolver(viewName);
		view.render(mv.getModel(), request, response);
	}

	// 파라미터를 꺼내서 paramMap에 담아서 보내줌.
	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName,
						request.getParameter(paramName)));
		return paramMap;
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}
