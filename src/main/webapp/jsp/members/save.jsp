<%@page import="hello.servlet.domain.member.Member"%>
<%@page import="hello.servlet.domain.member.MemberRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
//request response사용가능
MemberRepository memberRepository = MemberRepository.getInstance();

String username = request.getParameter("username");
int age = Integer.parseInt(request.getParameter("age"));

Member member = new Member(username, age);

memberRepository.save(member);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	성공
	<ul>
		<li>
			id=<%=member.getId()%></li>
		<li>
			username=<%=member.getUsername()%></li>
		<li>
			age=<%=member.getAge()%></li>
	</ul>
	<a href="/index.html">메인</a>
</body>
</html>