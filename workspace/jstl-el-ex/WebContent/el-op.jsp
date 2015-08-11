<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "페이지네임");
	request.setAttribute("name", "리퀘스트네임");
	session.setAttribute("name", "세션네임");
	application.setAttribute("name", "어플리케이션네임");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Operation</title>
</head>
<body>
	<h1>객체</h1>
	name : ${ name }<br>
	pagename : ${ pageScope.name }<br>
	requestName : ${ requestScope.name }<br>
	sessionName : ${ sessionScope.name }<br>
	applicationName : ${ applicationScope.name }<br>
	<hr>
	
	<h1>수치 연산자</h1>
	더하기 : ${ 10 + 10 }<br>
	빼기 : ${ 10 - 10 }<br>
	곱하기 : ${'10' * "10" }<br>
	몫 : ${ 40 / '6' }<br>
	나머지 : ${40 % 6 }<br>
	<hr>
	
	<h1>비교 연산자</h1>
	같은가 : ${ 10 eq 10 }<br>
	다른가 : ${ 10 eq 10 }<br>
	작은가 : ${ 10 lt 10 }<br>
	큰가 : ${ 10 gt 10 }<br>
	작거나같은가 : ${ 10 le 10 }<br>
	크거나같은가 : ${ 10 ge 10 }<br>
	<hr>
</body>
</html>