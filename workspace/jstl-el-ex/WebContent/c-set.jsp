<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="kr.ac.smu.mysite.vo.UserVo" %>
<%
	UserVo user = new UserVo();
	user.setNo( 1 );
	user.setEmail( "kickscar@gmail.com" );
	user.setName( "안대혁" );
	user.setGender( "male" );

	UserVo user2 = new UserVo();
	user2.setNo( 2 );
	user2.setEmail( "doolly@gmail.com" );
	user2.setName( "둘리" );
	user2.setGender( "male" );

	request.setAttribute( "doolly", user2 );
	
%>

<c:set var="nameKickscar" value="<%=user.getName() %>" scope="request" />
<c:set var="emailDoolly" value="${ requestScope.doolly.name } : ${ requestScope.doolly.email }" scope="request" />

<c:set var="nameKickscar2"><%=user.getName() %></c:set>
<c:set var="emailDoolly2">${ requestScope.doolly.name } : ${ requestScope.doolly.email }</c:set>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core - set</title>
</head>
<body>
	${nameKickscar  } <br>
	${emailDoolly } <br>
	
	${nameKickscar2  } <br>
	${emailDoolly2 }
</body>
</html>