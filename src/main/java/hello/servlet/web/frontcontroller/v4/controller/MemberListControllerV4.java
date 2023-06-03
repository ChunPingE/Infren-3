package hello.servlet.web.frontcontroller.v4.controller;

import java.util.*;

import hello.servlet.domain.member.*;
import hello.servlet.web.frontcontroller.*;
import hello.servlet.web.frontcontroller.v4.*;

public class MemberListControllerV4 implements ControllerV4 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		List<Member> members = memberRepository.findAll();
		model.put("members", members);
		return "members";
	}
}