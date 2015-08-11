<%@page import="guestbook.bit.vo.GuestBookVo"%>
<%@page import="guestbook.bit.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 request.setCharacterEncoding("utf-8");
 String id = request.getParameter("id");
 String password = request.getParameter("password");
 
GuestBookDao dao = new GuestBookDao();
dao.delete(id, password);
 
response.sendRedirect("./index.jsp");
%>
	 
 
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>