package hello.servlet.web.frontcontroller.v5;

import java.io.*;
import java.util.*;

import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v3.controller.*;
import hello.servlet.web.frontcontroller.v4.controller.*;
import hello.servlet.web.frontcontroller.v5.adapter.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
	private final Map<String, Object> handlerMappingMap = new HashMap<>();
	private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

	public FrontControllerServletV5() {
		initHandlerMappingMap();
		initHandlerAdapters();
	}

	private void initHandlerMappingMap() {
		// V3 추가
		handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
		handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
		handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

		// V4 추가
		handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
		handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
		handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
	}

	private void initHandlerAdapters() {
		handlerAdapters.add(new ControllerV3HandlerAdapter());
		handlerAdapters.add(new ControllerV4HandlerAdapter()); // V4 추가
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 핸들러 찾는 메소드
		Object handler = getHandler(request);

		if (handler == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// 핸들러어댑터목록에서 핸들러 찾기
		MyHandlerAdapter adapter = getHandlerAdapter(handler);
		ModelView mv = adapter.handle(request, response, handler);
		MyView view = viewResolver(mv.getViewName());
		view.render(mv.getModel(), request, response);
	}

	// 핸들러 찾는 메소드
	private Object getHandler(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return handlerMappingMap.get(requestURI);
	}

	// 핸들러어댑터목록에서 핸들러 찾기
	private MyHandlerAdapter getHandlerAdapter(Object handler) {
		for (MyHandlerAdapter adapter : handlerAdapters) {
			if (adapter.supports(handler)) {
				return adapter;
			}
		}
		throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}