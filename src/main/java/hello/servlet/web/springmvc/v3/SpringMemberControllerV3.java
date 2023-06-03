package hello.servlet.web.springmvc.v3;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import hello.servlet.domain.member.*;

/**
 * v3 Model 도입 ViewName 직접 반환
 * 
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	// @RequestMapping(value = "/new-form", method = RequestMethod.GET)
	@GetMapping("/new-form")
	public String newForm() {
		return "new-form";
	}

	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String save(
			@RequestParam("username") String username,
			@RequestParam("age") int age,
			Model model) {
		Member member = new Member(username, age);
		memberRepository.save(member);
		model.addAttribute("member", member);
		return "save-result";
	}

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String members(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		return "members";
	}
}