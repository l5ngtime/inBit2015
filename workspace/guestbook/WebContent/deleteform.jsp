<%@page import="guestbook.bit.dao.GuestBookDao"%>
<%@page import="guestbook.bit.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 request.setCharacterEncoding("utf-8");
 String no = request.getParameter("no");
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제화면</title>
</head>
<body>
	<form method="post" action="delete.jsp">
	<input type='hidden' name="id" value="<%=no%>">
	
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="index.jsp">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>