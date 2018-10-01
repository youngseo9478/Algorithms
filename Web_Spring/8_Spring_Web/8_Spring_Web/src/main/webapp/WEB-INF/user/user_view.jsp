 
<%@page contentType="text/html; charset=utf-8" %>
 
 
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script >
	function userList() {
		f.action="listuser.do"
		f.submit();
	}
	function userModify() {
		f.action="modifyuser.do";
		f.submit();
	}
	function userRemove() {
		if ( confirm("정말 삭제하시겠습니까?") ) {
			f.action="removeuser.do";
			f.submit();
		}
	}
</script>
</head>
<body >
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 - 사용자 정보보기</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- view Form  -->
	  <form name="f" method="post" action="">
	   <input type="hidden" name="id" value="${user.id }">
	  <table border="0" cellpadding="0" cellspacing="1" width="610" bgcolor="BBBBBB">
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${user.id}
			</td>
		  </tr>
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 				 ${user.name}
			</td>
		  </tr>
		  <tr>
			<td width=120 align=center bgcolor="E6ECDE" height="22">권한정보</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 				 ${user.role}
			</td>
		  </tr>		
		 
	  </table>
	  </form>
	  <table width=610 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="수정" onClick="userModify()"> &nbsp;
			<input type="button" value="삭제" onClick="userRemove()"> &nbsp;
			<input type="button" value="목록" onClick="userList()"> 
			</td>
		  </tr>
	  </table>
	  </td>
	</tr>
</table>  

</body>
</html>