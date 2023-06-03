package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import hello.servlet.domain.member.*;
import jakarta.servlet.http.*;

@Controller
public class SpringMemberSaveControllerV1 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/springmvc/v1/members/save")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		Member member = new Member(username, age);
		System.out.println("member = " + member);
		memberRepository.save(member);
		ModelAndView mv = new ModelAndView("save-result");
		mv.addObject("member", member);
		return mv;
	}
}
