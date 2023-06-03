package hello.servlet.web.frontcontroller.v5.adapter;

import java.util.*;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v3.*;
import hello.servlet.web.frontcontroller.v5.*;
import jakarta.servlet.http.*;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV3);
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		ControllerV3 controller = (ControllerV3) handler;
		Map<String, String> paramMap = createParamMap(request);
		ModelView mv = controller.process(paramMap);
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