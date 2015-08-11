<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core - choose</title>
</head>
<body>
	<ul>
	<c:choose>
		<c:when test="${ param.flag == 0 }">
			<li>파라미터 flag 의 값은 0 입니다.
		</c:when>
		<c:when test="${ param.flag == 1 }">
			<li>파라미터 flag 의 값은 1 입니다.
		</c:when>
		<c:when test="${ param.flag == 2 }">
			<li>파라미터 flag 의 값은 2 입니다.
		</c:when>
		<c:otherwise>
			<li>파라미터 flag 의 값은 0,1,2 중에 하나를 입력해주세요.
		</c:otherwise>
	</c:choose>
	</ul>
</body>
</html>