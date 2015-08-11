<%@page import="com.bit.emaillist.dao.EmailListDao"%>
<%@page import="com.bit.emaillist.vo.EmailListVo"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
EmailListDao dao = new EmailListDao();
List<EmailListVo> list = dao.getList();

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>현재 저장된 메일 </p>
	<!-- 메일정보 리스트 -->
	<%
	for(EmailListVo vo : list){
	
	%>
	
	
	
	<table width="600px" border="1" cellpadding="5" cellspacing="10">
		<tr>
			<td align=right>First name: </td>
			<td><%=vo.getFirst_name() %></td>
		</tr>
		<tr>
			<td align=right width="110">Last name: </td>
			<td width="110"><%=vo.getLast_name() %></td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td><%=vo.getEmail() %></td>
		</tr>
		<tr align="right" width="400">
		<td colspan="2">
		<a href="./form_up_emaillist.jsp?email=<%=vo.getEmail() %>" target="_self">수정</a>
		<a href="./delete_emaillist.jsp?email=<%=vo.getEmail() %>" target="_self">삭제</a>
		</td>
		</tr>
		</table>
		
	
	<%} %>
	    
	<br>
	<p>
		<a href="./form_emaillist.jsp" target="_self">추가메일 등록</a>
	</p>
	<br>
</body>
</html>