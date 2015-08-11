<%@page import="guestbook.bit.dao.GuestBookDao"%>
<%@page import="guestbook.bit.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String password = request.getParameter("pass");
String content=request.getParameter("content");

GuestBookVo vo = new GuestBookVo();
GuestBookDao dao = new GuestBookDao();

vo.setName(name);
vo.setPassword(password);
vo.setContent(content);

dao.insert(vo);

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