<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
		<div id="content">
			<div id="user">

				<form id="join-form" name="join-form" method="post" action="join">
					<input type="hidden" name="a" value="join"> <label class="block-label" for="name">이름</label> 
					<input id="name" name="name" type="text"> <img id="name-checked" src="/assets/images/check.png" style="display:none">
						<label class="block-label" for="email">이메일</label> <input id="email" name="email" type="text">
						<input type="button" value="id 중복체크">
						<img id="email-checked" src="/assets/images/check.png" style="display:none">
					 <label class="block-label">패스워드</label>
					  <input id="password" name="password" type="password">
					   <img id="password-checked" src="/assets/images/check.png" style="display:none">

					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female"
							checked="checked"> <label>남</label> <input type="radio"
							name="gender" value="male">
					</fieldset>

					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agree-prov" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>

					<input type="submit" value="가입하기">

				</form>
			</div>
		</div>
		<div id="navigation">
		</div>
		<div id="footer">
		</div>
	</div>
		</div>
</body>
</html>