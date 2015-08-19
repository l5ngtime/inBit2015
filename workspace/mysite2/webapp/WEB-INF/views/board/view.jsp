<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp">
			</c:import>
		</div>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="4" width="100%">글보기</th>
					</tr>
					<tr>
						<td class="label" width="20%">제목</td>
						<td colspan=3 width="80%">${vo.title }</td>
					</tr>
					<tr>
						<td class="label" width="20%">내용</td>
						<td colspan=3 width="80%">
							<div class="view-content">
								${fn:replace(vo.content, newLineChar,"<br>") }
							</div>
						</td>
					</tr>
					<c:set var="post_no" value="${vo.no }" />
					<c:forEach var="vo" items="${list }" varStatus="status">
					<tr>
					<th width="20%">${vo.member_name}</th>
					<td width="50%">${vo.content }</td>
					<td width="20%">${vo.reg_date }</td>
					<td width="10%">
					<c:if test="${authUser.no == vo.member_no}">
						<a href="redelete?no=${vo.no }&post_no=${post_no}">[삭제]</a>
					</c:if>
					</td>
					</tr>
					</c:forEach>
					<c:if test="${not empty authUser }">
					<form action="reply?post_no=${vo.no }" method="post">
						<tr>
							<td colspan=4>이름 <input type="text" name="member_name" value="${authUser.name }" readonly />
							<input type="hidden" name="member_no" value="${authUser.no }" /></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
				</form>
				</c:if>
				</table>
				<div class="bottom">
					<a href="list">글목록</a>
					<c:if test="${authUser.no == vo.member_no}">
					<a href="updateform?no=${post_no }">글수정</a>
					</c:if>
				</div>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="pageName" value="board"/>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp">
			</c:import>
		</div>
	</div>
</body>
</html>