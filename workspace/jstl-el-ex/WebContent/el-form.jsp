<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Form</title>
</head>
<body>
	<form action="el-result.jsp" method="post">
		아이디 : <input type="text" name="id">
		<br>
		<br>
		회원님이 관심있는 스포츠를 선택하세요
		<br>
		축구<input type="checkbox" name="sports" value="축구">
		농구<input type="checkbox" name="sports" value="농구">
		야구<input type="checkbox" name="sports" value="야구">
		골프<input type="checkbox" name="sports" value="골프">
		<br>
		<br>
		<input type="submit" value="확인"><input type="reset" value="취소">
		<input type="submit" value="확인"><input type="reset" value="취소">
	</form>
</body>
</html>