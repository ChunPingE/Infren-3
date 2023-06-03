package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.*;

@Component("/springmvc/old-controller")
public class OldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("OldController.handleRequest");
		return new ModelAndView("new-form");
	}
}
