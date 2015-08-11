<%@page import="com.bit.emaillist.dao.EmailListDao"%>
<%@page import="com.bit.emaillist.vo.EmailListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String email = request.getParameter("email");

	EmailListVo vo = new EmailListVo();
	EmailListDao dao = new EmailListDao();

	vo.setEmail(email);

	dao.delete(vo);
	
	
	//response.sendRedirect("./show_emaillist.jsp");
%>
<%=email%><br>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META http-equiv=refresh content="1;url=show_emaillist.jsp">
<title>Insert title here</title>
</head>
<body>

</body>
</html>