package hello.servlet.web.springmvc.v1;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import hello.servlet.domain.member.*;

@Controller
public class SpringMemberListControllerV1 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/springmvc/v1/members")
	public ModelAndView process() {
		List<Member> members = memberRepository.findAll();
		ModelAndView mv = new ModelAndView("members");
		mv.addObject("members", members);
		return mv;
	}
}
