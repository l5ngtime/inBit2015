<%@page import="com.bit.emaillist.dao.EmailListDao"%>
<%@page import="com.bit.emaillist.vo.EmailListVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String first_name = request.getParameter("fn");
	String last_name = request.getParameter("ln");
	String email = request.getParameter("email");

	EmailListVo vo = new EmailListVo();
	EmailListDao dao = new EmailListDao();

	vo.setFirst_name(first_name);
	vo.setLast_name(last_name);
	vo.setEmail(email);

	dao.insert(vo);
	
	
	//response.sendRedirect("./show_emaillist.jsp");
%>
<%=first_name%><br>
<%=last_name%><br>
<%=email%><br>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META http-equiv=refresh content="1;url=show_emaillist.jsp">
<title>Insert title here</title>
</head>
<body>

</body>
</html>