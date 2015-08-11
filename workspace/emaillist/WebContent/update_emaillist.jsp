<%@page import="com.bit.emaillist.dao.EmailListDao"%>
<%@page import="com.bit.emaillist.vo.EmailListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String emailReal = request.getParameter("emailReal");
	String first_name = request.getParameter("fn");
	String last_name = request.getParameter("ln");
	String email = request.getParameter("email");

	EmailListVo vo = new EmailListVo();
	EmailListDao dao = new EmailListDao();

	vo.setFirst_name(first_name);
	vo.setLast_name(last_name);
	vo.setEmail(email);

	dao.update(vo,emailReal);
	
	response.sendRedirect("./show_emaillist.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>