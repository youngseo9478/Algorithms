<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
</head>
<body>
<center><h3>로그인</h3>
<hr> 
<form action="login.do" method="post">
	<table border="1">
		<tr><td colspan="2">로그인</td></tr>
		<tr><td> 아이디 </td>
		<td><input type="text" name="userid"></td></tr>
		<tr><td> 비밀번호 </td>
		<td><input type="password" name="userpwd"></td></tr>
		<tr><td colspan="2"><input type="submit" value="로그인">
		<input type="reset" value="취소"></td></tr>
	</table>
</form>
</center>
</body>
</html>