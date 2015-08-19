<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<div id="board">
				<table class="tbl-ex">
					<tr>
						<th width="10%">번호</th>
						<th width="33%">제목</th>
						<th width="15%">글쓴이</th>
						<th width="12%">조회수</th>
						<c:choose>
						<c:when test="${empty authUser }">
						<th width="29%">작성일</th>
						<th width="1%">&nbsp;</th>
						</c:when>
						<c:otherwise>
						<th width="20%">작성일</th>
						<th width="10%">&nbsp;</th>
						</c:otherwise>
						</c:choose>
					</tr>
					<c:set var="count" value="${total }"></c:set>
					<c:choose>
					<c:when test="${count==0 }">
					<tr><td colspan="5">해당하는 글이 없습니다.</td></tr>
					</c:when>
					<c:otherwise>
				<c:forEach var="vo" items="${list }" varStatus="status">
					<tr>
						<td>[${stnum-status.index }]</td>
						<td style="text-align:left;padding-left:${(vo.dap-1)*10 }px">
						<c:if test="${vo.order_no!=0 }">
						└
						</c:if>
						<a href="view?no=${vo.no }">${vo.title }</a></td>
						<td>${vo.member_name }</td>
						<td>${vo.view_cnt }</td>
						<td>${vo.reg_date }</td>
						<td>
						<c:if test="${not empty authUser }">
						<a href="dapform?my_no=${vo.my_no }&dap=${vo.dap}&order_no=${vo.order_no}">[답글]</a>
						</c:if>
								<c:if test="${authUser.no == vo.member_no}">
							<a href="delete?no=${vo.no }&member_no=${vo.member_no}">[삭제]</a>
								</c:if>
						</td>
					</tr>
				</c:forEach>
				</c:otherwise>
				</c:choose>
				</table>
			
				<table class="tbl-page">
					<tr>
						<td colspan="5">
				<c:choose>
					<c:when test="${empty kwd }">
					키워드 없음 서치중 아님
					<a href="list?num=1">◀◀[${panum }]</a> <a href="list?num=${num-1 }">◁</a>
						<c:forEach var="i" begin="${panum }" end="${panum+4 }">
						<c:if test = "${to >= i}" >
						<a href="list?num=${i}">
						<c:if test="${i==num}">
						<strong><font color = "gray" style="text-decoration:underline">
						</c:if>
						${i}</a>
						<c:if test="${i==num}">
						</font></strong>
						</c:if>
						</c:if>
						</c:forEach>
						
						<a href="list?num=${num+1 }">▷</a>
						<a href="list?num=${to }">[${to }]▶▶</a>
					</c:when>
					<c:when test ="${not empty kwd }">	
						서치중
						<a href="list?num=1&search=yes&kwd=${kwd }">◀◀[${panum }]</a> <a href="list?num=${num-1 }&search=yes&kwd=${kwd }">◁</a>
						<c:forEach var="i" begin="${panum }" end="${panum+4 }">
						<c:if test = "${to >= i}" >
						<a href="list?num=${i}&search=yes&kwd=${kwd }">
						<c:if test="${i==num}">
						<strong><font color = "gray" style="text-decoration:underline">
						</c:if>
						${i}</a>
						<c:if test="${i==num}">
						</font></strong>
						</c:if>
						</c:if>
						</c:forEach>
								<a href="list?num=${num+1 }&search=yes&kwd=${kwd }">▷</a>
								 <a href="list?num=${to }&search=yes&kwd=${kwd }">[${to }]▶▶</a>	 
					</c:when>
				</c:choose>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<c:if test="${not empty authUser}">
					<a href="writeform" id="new-book">글쓰기</a>
					</c:if>
					<a href="list" id="new-book">목록으로</a>
				</div>
				<form id="search_form" action="list?search=yes" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
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