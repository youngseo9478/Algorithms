<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"49631",secure:"49636"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-0" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/user/loginForm.jsp">
<center data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-0" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/user/loginForm.jsp"><h3>로그인</h3>
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