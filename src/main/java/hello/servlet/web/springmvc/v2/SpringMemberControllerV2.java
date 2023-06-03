package hello.servlet.web.springmvc.v2;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import hello.servlet.domain.member.*;
import jakarta.servlet.http.*;

/**
 * 클래스 단위 -> 메소드 단위
 * 
 * @RequestMapping 클래스 레벨과 메소드 레벨 조합
 */
@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}

	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		Member member = new Member(username, age);
		memberRepository.save(member);
		ModelAndView mav = new ModelAndView("save-result");
		mav.addObject("member", member);
		return mav;
	}

	@RequestMapping
	public ModelAndView members() {
		List<Member> members = memberRepository.findAll();
		ModelAndView mav = new ModelAndView("members");
		mav.addObject("members", members);
		return mav;
	}
}