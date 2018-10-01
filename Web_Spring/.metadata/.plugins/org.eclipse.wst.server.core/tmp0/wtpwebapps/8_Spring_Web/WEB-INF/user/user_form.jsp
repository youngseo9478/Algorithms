<%@ page   contentType="text/html; charset=utf-8" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html >
<html>
<head>
<meta   charset="utf-8">
<TITLE>개인 정보 입력 화면</TITLE>
<script type="text/javascript">
function userCreate(){		 
	f.action="./add.do";
	f.submit();	
}
function userList(){
	f.action="./list.do";
	f.submit();
}
</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"49631",secure:"49636"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-1" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/user/user_form.jsp">
<br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-1" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/user/user_form.jsp">
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 - 개인 정보 입력</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  
	  <!-- write Form  -->
	  <form name="f" method="post" action="">
	 
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="text" style="width:150" name="userid" value="">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="password" style="width:150" name="userpwd" value="">
			</td>
		  </tr>
		
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="text" style="width:200" name="username" value="">
			</td>
		  </tr>
		  
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일 주소</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="text" style="width:340px" name="email">
			</td>
		  </tr>		
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">전화 번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="text" style="width:150px" name="phone">
			</td>
		  </tr>		
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">주    소</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="text" style="width:340px" name="address">
			</td>
		  </tr>		
	  </table>
	  
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="회원 가입" onClick="userCreate()"> &nbsp;
			<input type="button" value="목록" onClick="userList()">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  
 </form>
</body>
</html>