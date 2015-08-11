<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8"); 
	request.setAttribute("name", "안대혁");
		
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Result</title>
</head>
<body>
	요청 URI : ${ pageContext.request.requestURI }
	<hr>
	request의 name 속성 : ${name }
	<hr>
	아이디 : ${ param.id }<br>
	<hr>
	아이디 : ${ param.id }<br>
	선택한 운동 :	${ paramValues.sports[0] } 
				${ paramValues.sports[1] } 
				${ paramValues.sports[2] }
				${ paramValues.sports[3] }	

</body>
</html>