<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core - if</title>
</head>
<body>
	<c:if test="true">
		항상 실행된다.<br>
	</c:if>
	
	<c:if test="false">
		항상 실행되지않는다.<br>
	</c:if>
	
	<c:if test="ture 나 false 값이 아닌 텍스트">
		항상 실행되지않는다.<br>
	</c:if>
	
	<c:if test="${ param.name == 'smu' }">
		EL 결과 값이 true 일 때 실행된다.<br>
		name 파라미터의 값 : ${ param.name}<br>
	</c:if>
	

</body>
</html>