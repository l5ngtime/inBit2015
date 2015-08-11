<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	String[] sports = { "축구", "야구", "농구", "골프", "수영", "볼링"};

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("name", "Gz");
	map.put("age", "25");
	map.put("tel", "010-1234-5678");
	map.put("date", new java.util.Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core Foreach</title>
</head>
<body>
	<h1>1부터 100까지의 홀수의 합 :
	<c:set var="sum" value="0" />
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${ sum + i }" />
	</c:forEach>
	${ sum }</h1>
	
	<hr><!-- ------------------------------------------------ -->
	
	<h1>구구단</h1>
	<hr><!-- ------------------------------------------------ -->
	
	
	<h1>스포츠 배열 2번째 값부터 3개만 출력</h1>
	<c:set var="sportsArray" value="<%= sports %>" />
	<c:forEach var="i" items="${ sportsArray }" begin="1" end="3" step="1" varStatus="status">
		i 값 : ${ i }<br>
		루프 실행 현재 인덱스 값 : ${ status.index }<br>
		루프 실행 횟수 : ${ status.count }<br>
		begin 값 : ${ status.begin }<br>
		end 값 : ${ status.end }<br>
		step 값 : ${ status.step }<br>
		<br>
	</c:forEach>
	
	<hr><!-- ------------------------------------------------ -->
	
	<h1>Map</h1>
	<c:set var="memberMap" value="<%= map %>" />
	<c:forEach var="i" items="${ memberMap }">
		${ i.key } : ${ i.value }<br>
	</c:forEach>	
	
</body>
</html>