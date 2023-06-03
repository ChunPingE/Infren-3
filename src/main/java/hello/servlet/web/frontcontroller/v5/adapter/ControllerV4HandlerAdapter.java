package hello.servlet.web.frontcontroller.v5.adapter;

import java.util.*;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v4.*;
import hello.servlet.web.frontcontroller.v5.*;
import jakarta.servlet.http.*;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV4);
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		ControllerV4 controller = (ControllerV4) handler;
		Map<String, String> paramMap = createParamMap(request);
		Map<String, Object> model = new HashMap<>();
		String viewName = controller.process(paramMap, model);

		ModelView mv = new ModelView(viewName);
		mv.setModel(model);

		return mv;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName,
						request.getParameter(paramName)));
		return paramMap;
	}
}
