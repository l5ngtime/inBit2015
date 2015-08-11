<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="kr.ac.smu.mysite.vo.UserVo" %>
<%
	UserVo user = new UserVo();
	user.setNo( 1 );
	user.setEmail( "kickscar@gmail.com" );
	user.setName( "안대혁" );
	user.setGender( "male" );
	
	String[] a = { "축구", "야구", "농구", "골프", "수영", "볼링"};
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("name", "Gz");
	map.put("age", "25");
	map.put("tel", "010-1234-5678");
	map.put("date", new java.util.Date());
%>

<c:set var="kickscar" value="<%=user%>"/>
<c:set var="map" value="<%=map%>"/>
<c:set var="sports" value="<%=a%>"/>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Object</title>
</head>
<body>
	${ kickscar.no }<br>
	${ map.name } <br>
	${ sports[1] }
</body>
</html>