<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  파라미터  NO : ${ empty param.no ? '0' : param.no } <br>
  
<c:if test="${not empty param.id}">
	파라미터 id: ${param.id }
</c:if>
	
</body>
</html>