<%@page import="java.util.List"%>
<%@page import="com.bit.emaillist.vo.EmailListVo"%>
<%@page import="com.bit.emaillist.dao.EmailListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String emailReal = request.getParameter("email");
EmailListDao dao = new EmailListDao();
EmailListVo vo = dao.upSelect(emailReal);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트 수정</h1>
	<p>
		메일 리스트를 수정 하신 뒤<br>
		수정을 눌러주세요.
	</p>
	<form action="update_emaillist.jsp?emailReal=<%=emailReal%>" method="post">
	    First name: <input type="text" name="fn" value="<%=vo.getFirst_name() %>" ><br>
	    Last name: <input type="text" name="ln" value="<%=vo.getLast_name()%>"><br>
	    Email address: <input type="text" name="email" value="<%=vo.getEmail()%>"><br>
	    <input type="submit" value="수정">
	</form>
	<br>
	<p>
	<a href="./show_emaillist.jsp" target="_self">리스트 바로가기</a>
	</p>
</body>
</html>